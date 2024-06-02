package com.project.assignment.controller;

import com.project.assignment.model.KhachHang;
import com.project.assignment.model.NhanVien;
import com.project.assignment.service.implement.NhanVienimp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/nhanvienview")
public class NhanVienController {
    private final NhanVienimp nhanVienimp;
    @GetMapping("/nhanvien")
    public String getAllNV(@RequestParam(value = "p", defaultValue = "0") int page, Model model) {
        model.addAttribute("nhanvien",new NhanVien());
        model.addAttribute("lstnv",nhanVienimp.getAllNV(page));
        return "admin/nhanvienview/nhanvien";
    }
    @PostMapping("/nhanvienadd")
    public String postNhanVien(@Valid @ModelAttribute("nhanvien") NhanVien nhanvien, BindingResult result){
        if(result.hasErrors()){
            return "admin/nhanvienview/nhanvien";
        }
        nhanVienimp.create(nhanvien);
        return "admin/nhanvienview/nhanvien";
    }
    @GetMapping("/detail/{id}")
    public String detailNhanVien(@PathVariable("id") int id,Model model){
        NhanVien nv = nhanVienimp.getById(id);
       if(nv.equals(null)){
           return "admin/nhanvienview/nhanvien";
       }
        model.addAttribute("nhanvien",nv);
        return "admin/nhanvienview/chitietnhanvien";
    }
    @PostMapping("/detail")
    public String updateNhanVien(@Valid @ModelAttribute("nhanvien") NhanVien nhanvien, BindingResult result){
        if (result.hasErrors()){
            return "admin/nhanvienview/chitietnhanvien";
        }
        nhanVienimp.update(nhanvien);
        return "redirect:/admin/nhanvienview/nhanvien";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id,Model model){
        nhanVienimp.delete(id);
        return "redirect:/admin/nhanvienview/nhanvien";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam("ten") String ten,
                               @RequestParam(name = "p",defaultValue = "0") int p,
                               Model model){
        Page<NhanVien> lstnvs = nhanVienimp.getByName(ten,p);
        if(lstnvs.isEmpty()){
            return "redirect:/admin/nhanvienview/nhanvien";
        }
        model.addAttribute("lstnv",lstnvs);
        return "forward:/admin/nhanvienview/nhanvien";
    }
}
