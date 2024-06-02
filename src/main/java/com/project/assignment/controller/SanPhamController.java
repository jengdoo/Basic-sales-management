package com.project.assignment.controller;

import com.project.assignment.model.KichThuoc;
import com.project.assignment.model.MauSac;
import com.project.assignment.model.SanPham;
import com.project.assignment.model.SanPhamChiTiet;
import com.project.assignment.reponsitory.KichThuocRepo;
import com.project.assignment.reponsitory.MauRepo;
import com.project.assignment.reponsitory.SanPhamRepo;
import com.project.assignment.service.implement.SanPhamChiTietEpl;
import com.project.assignment.service.implement.SanPhamIpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/sanphamview")
public class SanPhamController {
     private final SanPhamIpl spipl;
    private final SanPhamChiTietEpl spctIpl;
    private final MauRepo mauRepo;
    private final KichThuocRepo kichThuocRepo;
    private final SanPhamRepo sanPhamRepo;
    @GetMapping("/sanpham")
    public String pageSanPham(Model model,@RequestParam(name = "p",defaultValue = "0") int p) {
        model.addAttribute("lstsp", spipl.getAllSP(p));
        return "admin/sanphamview/sanpham";
    }
    @GetMapping("/delete/{id}")
    public String deleteSanPham(@PathVariable("id") int id){
        spipl.deleteSanPham(id);
        return "redirect:/admin/sanphamview/sanpham";
    }
    @PostMapping("/search")
    public String getByName(@RequestParam("tensp") String tensp,Model model,@RequestParam(name = "p",defaultValue = "0") int p){
        Page<SanPham> lstspn = spipl.getSanPhamByName(tensp,p);
        if(tensp.isEmpty()||tensp.equals(null)){
            model.addAttribute("lstsp",spipl.getAllSP(p));
            return "admin/sanphamview/sanpham";
        }
        if(lstspn.isEmpty()){
            model.addAttribute("lstsp",spipl.getAllSP(p));
            return "admin/sanphamview/sanpham";
        }
        System.out.println("ten"+tensp);
        System.out.println("lst"+lstspn);
        model.addAttribute("lstsp",lstspn);
        return "admin/sanphamview/sanpham";
    }
    @PostMapping("/loc")
    public String getByTT(@RequestParam("trangthai") boolean trangthai,Model model,@RequestParam(name = "p",defaultValue = "0") int p){
        Page<SanPham> lstspn = spipl.getSanPhamByStatus(trangthai,p);
        model.addAttribute("lstsp",lstspn);
        System.out.println("lstp"+lstspn);
        return "admin/sanphamview/sanpham";
    }
    @GetMapping("/add")
    public String addproduct(Model model){
        model.addAttribute("sanpham",new SanPham());
        return "admin/sanphamview/createproduct";
    }
    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("sanpham") SanPham sanpham, BindingResult result, Model model){
        if(result.hasErrors()){
            return "admin/sanphamview/createproduct";
        }
        spipl.createSanPham(sanpham);
        return "redirect:/admin/sanphamview/sanpham";
    }
    @GetMapping("/sanphamchitiet")
    public String detailSanPham(@RequestParam("id") int id,@RequestParam(name = "p",defaultValue = "0") int p, Model model) {
        Page<SanPhamChiTiet> spctList = spctIpl.getByIdSanPham(id,p);
        SanPham sp = sanPhamRepo.findSanPhamById(id);
        model.addAttribute("sanphamid",sp);
        model.addAttribute("sanphamchitiet",new SanPhamChiTiet());
        model.addAttribute("lstspct", spctList);
        return "admin/sanphamview/sanphamchitiet";
    }
    @ModelAttribute("lstmau")
    public List<MauSac> getAllMau(){
        return mauRepo.findAll();
    }
    @ModelAttribute("lstkt")
    public List<KichThuoc> getAllKT(){
        return kichThuocRepo.findAll();
    }
    @PostMapping("/sanphamchitiet")
    public String addSPCT(@RequestParam("id") int id,@RequestParam(name = "p",defaultValue = "0") int p, @Valid @ModelAttribute("sanphamchitiet") SanPhamChiTiet sanphamchitiet, BindingResult result, Model model) {
        SanPham sp = sanPhamRepo.findSanPhamById(id);
        Page<SanPhamChiTiet> spctList = spctIpl.getByIdSanPham(id,p);
        if(result.hasErrors()){
            model.addAttribute("lstspct",spctList);
            return "admin/sanphamview/sanphamchitiet";
        }
        spctIpl.create(sanphamchitiet);
        return "redirect:/admin/sanphamview/sanphamchitiet?id=" + sp.getId();
    }

    @GetMapping("/updatespct/{id}")
    public String getUpdateSPCT(@PathVariable("id") Integer id,Model model){
        model.addAttribute("sanphamchitiet",new SanPhamChiTiet());
        model.addAttribute("sanphamchitiet",spctIpl.getByID(id));
        return "admin/sanphamview/updatespct";
    }
    @PostMapping("/updatespct")
    public String postUpdateSPCT(@Valid @ModelAttribute("sanphamchitiet") SanPhamChiTiet spct,BindingResult result,@RequestParam("sanpham") int id){
        SanPham sp = sanPhamRepo.findSanPhamById(id);
        if(result.hasErrors()){
            return "admin/sanphamview/updatespct";
        }
        spctIpl.update(spct);
        return "redirect:/admin/sanphamview/sanphamchitiet?id=" +sp.getId();
    }
    @GetMapping("/deletespct")
    public String getDeleteSPCT(@RequestParam("id") Integer id,@ModelAttribute("sanphamchitiet") SanPhamChiTiet sanPhamChiTiet) {
         sanPhamChiTiet = spctIpl.getByID(id);

        if (sanPhamChiTiet != null && sanPhamChiTiet.getSanpham() != null) {
            spctIpl.delete(id);
            return "redirect:/admin/sanphamview/sanphamchitiet?id="+sanPhamChiTiet.getSanpham().getId();
        }
        System.out.println(sanPhamChiTiet);
        SanPham sp = sanPhamRepo.findSanPhamById(id);
        System.out.println(sp);

        return "admin/sanphamview/sanphamchitiet";
    }
}
