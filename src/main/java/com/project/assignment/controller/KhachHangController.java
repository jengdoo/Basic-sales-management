package com.project.assignment.controller;

import com.project.assignment.model.KhachHang;
import com.project.assignment.model.SanPham;
import com.project.assignment.service.implement.KhachHangIpl;
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
@RequestMapping("/admin/khachhangview")
public class KhachHangController {
    private final KhachHangIpl khachHangIpl;
    @GetMapping("/khachhang")
    public String findAllKh(@RequestParam(value = "p", defaultValue = "0") int page, Model model) {
        model.addAttribute("khachhang",new KhachHang());
        model.addAttribute("lstkh", khachHangIpl.getAllKH(page));
        return "admin/khachhangview/khachhang";
    }
    @PostMapping("/khachhang")
    public String addKh(@Valid @ModelAttribute("khachhang") KhachHang khachHang, BindingResult result){
        if(result.hasErrors()){
            return "admin/khachhangview/khachhang";
        }
        khachHangIpl.createKh(khachHang);
        return "redirect:/admin/khachhangview/khachhang";
    }
    @GetMapping("/delete/{id}")
    public String deleteKh(@PathVariable("id") int id){
        khachHangIpl.deleteKh(id);
        return "forward:/admin/khachhangview/khachhang";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam("tenkh") String tenkh,@RequestParam(name = "p",defaultValue = "0") int page,Model model){
        model.addAttribute("khachhang",new KhachHang());
        Page<KhachHang> lstkh = khachHangIpl.getByNameKH(tenkh,page);
        if(lstkh.isEmpty()){
            return "redirect:/admin/khachhangview/khachhang";
        }
        model.addAttribute("lstkh",lstkh);
        return "admin/khachhangview/khachhang";
    }
    @GetMapping("/update/{id}")
    public String detailKH(@PathVariable("id") int id,Model model){
        KhachHang kh =khachHangIpl.getByIdKh(id);
        model.addAttribute("khachhang",kh);
        return "admin/khachhangview/khachhangdetail";
    }
    @PostMapping("/update")
    public String updateKh(@Valid @ModelAttribute("khachhang") KhachHang khachhang,BindingResult result,Model model){
        if(result.hasErrors()){
            return "admin/khachhangview/khachhangdetail";
        }
        khachHangIpl.updateKh(khachhang);
        return "redirect:/admin/khachhangview/khachhang";
    }
}
