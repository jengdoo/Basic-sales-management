package com.project.assignment.controller;

import com.project.assignment.model.MauSac;
import com.project.assignment.service.implement.MauIpl;
import com.project.assignment.service.implement.SanPhamChiTietEpl;
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
public class MauController {
    private final MauIpl mauIpl;

    @GetMapping("/mau")
    public String getAllMau(Model model,@RequestParam(name = "p",defaultValue = "0") int p){
        model.addAttribute("mausac",new MauSac());
        model.addAttribute("lstmau",mauIpl.getAllMau(p));
        return "admin/sanphamview/mausac";
    }
    @PostMapping("/mau")
    public String addMau(@Valid @ModelAttribute("mausac") MauSac mausac, BindingResult result){
        if(result.hasErrors()){
            return "admin/sanphamview/mausac";
        }
        mauIpl.createMau(mausac);
        return "redirect:/admin/sanphamview/mau";
    }
    @GetMapping("/deleteMau")
    public String deleteMau(@RequestParam("id") int id,Model model){
        model.addAttribute("mausac",new MauSac());
        mauIpl.deleteMau(id);
        return "redirect:/admin/sanphamview/mau";
    }
    @GetMapping("/updateMau/{id}")
    public String detailMau(@PathVariable("id") int id,Model model){
        model.addAttribute("mausac",new MauSac());
        model.addAttribute("mausac",mauIpl.mauSacByID(id));
        return "admin/sanphamview/chitietmausac";
    }
    @PostMapping("/updateMau")
    public String updateMau(@Valid @ModelAttribute("mausac") MauSac mausac,BindingResult result){
        if(result.hasErrors()){
            return "admin/sanphamview/chitietmausac";
        }
        mauIpl.updateMau(mausac);
        return "redirect:/admin/sanphamview/mau";
    }
    @GetMapping("/searchmau")
    public String searchByNameMau(@RequestParam("tenmau") String tenmau,Model model,@RequestParam(name = "p",defaultValue = "0") int p){
        model.addAttribute("mausac",new MauSac());
        Page<MauSac> mau = mauIpl.getByNameMau(tenmau,p);
        if(mau.isEmpty()){
            model.addAttribute("lstmau",mauIpl.getAllMau(p));
            return "admin/sanphamview/mausac";
        }
        model.addAttribute("lstmau",mau);
        return "admin/sanphamview/mausac";
    }
}
