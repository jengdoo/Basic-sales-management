package com.project.assignment.controller;

import com.project.assignment.model.KichThuoc;
import com.project.assignment.service.implement.KichThuocIpl;
import com.project.assignment.service.implement.SanPhamChiTietEpl;
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
@RequestMapping("/admin/sanphamview")
public class KichThuocController {
    private final KichThuocIpl kichThuocIpl ;
    @GetMapping("/kichthuoc")
    public String getKichThuoc(Model model,@RequestParam(name = "p",defaultValue = "0") int p){
        model.addAttribute("kichthuoc",new KichThuoc());
        model.addAttribute("lstkt",kichThuocIpl.getAllKT(p));
        return "admin/sanphamview/kichthuoc";
    }
    @PostMapping("/kichthuoc")
    public String addKichThuoc(@Valid @ModelAttribute("kichthuoc") KichThuoc kichthuoc, BindingResult result){
        if(result.hasErrors()){
            return "admin/sanphamview/kichthuoc";
        }
        kichThuocIpl.createKT(kichthuoc);
        return "admin/sanphamview/kichthuoc";
    }
    @GetMapping("/updateKT/{id}")
    public String detailKT(@PathVariable("id") int id,Model model){
        model.addAttribute("kichthuoc",new KichThuoc());
        model.addAttribute("kichthuoc",kichThuocIpl.kichThuocByID(id));
        return "admin/sanphamview/chitietkichthuoc";
    }
    @PostMapping("/updateKT")
    public String updateKT(@Valid @ModelAttribute("kichthuoc") KichThuoc kichthuoc,BindingResult result){
        if(result.hasErrors()){
            return "admin/sanphamview/chitietkichthuoc";
        }
        kichThuocIpl.updateKT(kichthuoc);
        return "redirect:/admin/sanphamview/kichthuoc";
    }
    @GetMapping("/searchkt")
    public String searchByNameKT(@RequestParam("tenkt") String tenkt,@RequestParam(name = "p", defaultValue = "0") int p,Model model){
        model.addAttribute("kichthuoc",new KichThuoc());
        Page<KichThuoc> lstkt = kichThuocIpl.getByNameKichThuoc(tenkt,p);
        if(lstkt.isEmpty()){
            model.addAttribute("lstkt",kichThuocIpl.getAllKT(p));
            return "admin/sanphamview/kichthuoc";
        }
        model.addAttribute("lstkt",lstkt);
        return "admin/sanphamview/kichthuoc";
    }
    @GetMapping("/deleteKT")
    public String deleteKT(@RequestParam("id") int id){
        kichThuocIpl.deleteKT(id);
        return "redirect:/admin/sanphamview/kichthuoc";
    }
}
