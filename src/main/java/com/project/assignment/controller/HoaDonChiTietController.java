package com.project.assignment.controller;

import com.project.assignment.model.HoaDonChiTiet;
import com.project.assignment.reponsitory.HoaDonChiTietRepo;
import com.project.assignment.service.HoaDonChiTietSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/hoadonview")
public class HoaDonChiTietController {
    private final HoaDonChiTietSevice hoaDonChiTietSevice;
    private final HoaDonChiTietRepo hoaDonChiTietRepo;
    @RequestMapping("/hoadonchitiet/{id}")
    public String deatilHoaDon(@PathVariable("id") int id, Model model){
        List<HoaDonChiTiet> listHDCT = hoaDonChiTietSevice.getHoaDonChiTietByIdHoaDon(id);
        model.addAttribute("hoadonchitiet",listHDCT);
        return "admin/hoadonview/hoadonchitiet";
    }
}
