package com.project.assignment.controller;

import com.project.assignment.model.KichThuoc;
import com.project.assignment.model.MauSac;
import com.project.assignment.model.SanPham;
import com.project.assignment.model.SanPhamChiTiet;
import com.project.assignment.reponsitory.KichThuocRepo;
import com.project.assignment.reponsitory.MauRepo;
import com.project.assignment.service.KichThuocService;
import com.project.assignment.service.MauService;
import com.project.assignment.service.implement.KichThuocIpl;
import com.project.assignment.service.implement.MauIpl;
import com.project.assignment.service.implement.SanPhamChiTietEpl;
import com.project.assignment.service.implement.SanPhamIpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/sanphamview")
public class SanPhamChiTietController {
    private final SanPhamIpl spIpl;
    private final MauRepo mauRepo;
    private final KichThuocRepo kichThuocRepo;
    SanPhamChiTietEpl spctepl = new SanPhamChiTietEpl();
//    @GetMapping("/sanphamchitiet")
//    public String getSPCT(@RequestParam("id") Integer id, Model model,@RequestParam(name = "p",defaultValue = "0") int p){
//        Page<SanPhamChiTiet> spct = spctepl.getByIdSanPham(id,p);
//        SanPham sp = spIpl.getSanPham(id);
//            model.addAttribute("productName", sp);
//            model.addAttribute("sanphamchitiet",new SanPhamChiTiet());
//            model.addAttribute("lstspct",spct);
//            System.out.println("lll"+spct);
//            model.addAttribute("lstmau",mauIpl.getAllMau(p));
//            model.addAttribute("lstkt",kichThuocIpl.getAllKT(p));
//        return "admin/sanphamview/sanphamchitiet";
//    }
//    @PostMapping("/sanphamchitiet")
//    public String addSPCT(@RequestParam("id") int id,@RequestParam(name = "p" ,defaultValue = "0") int p ,@Valid @ModelAttribute("sanphamchitiet") SanPhamChiTiet sanphamchitiet, BindingResult result, Model model) {
//        Page<SanPhamChiTiet> spct = spctepl.getByIdSanPham(id,p);
//            try {
//                if (result.hasErrors()) {
//                    model.addAttribute("message", "Lỗi khi thêm");
//                    model.addAttribute("lstspct", spct);
//                    return "admin/sanphamview/sanphamchitiet";
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//       try {
//         if(spct.isEmpty()){
//             model.addAttribute("message", "Không thêm được");
//         }
//            spctepl.create(sanphamchitiet);
//           model.addAttribute("message", "Thêm thành công");
////           model.addAttribute("lstspct", spctepl.getAllSPCT(id));
//           System.out.println("lst" + spct);
//           return "redirect:/admin/sanphamview/sanpham";
//       }catch (Exception e) {
//           throw new RuntimeException("Lỗi khi thêm sản phẩm chi tiết", e);
//       }
//    }
//    @ModelAttribute("lstmau")
//    public List<MauSac> getAllMau(){
//        return mauRepo.findAll();
//    }
//    @ModelAttribute("lstkt")
//    public List<KichThuoc> getAllKT(){
//        return kichThuocRepo.findAll();
//    }
//    @GetMapping("/deletespct")
//    public String deleteSPCT(@RequestParam("id") int id,Model model){
//        List<SanPhamChiTiet> spct = spctepl.getByIdSanPham(id);
//        model.addAttribute("sanphamchitiet",new SanPhamChiTiet());
//        spctepl.delete(id);
//        model.addAttribute("lstspct", spct);
//        return "admin/sanphamview/sanphamchitiet";
//    }
}
