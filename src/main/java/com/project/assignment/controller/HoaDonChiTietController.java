package com.project.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/hoadonview")
public class HoaDonChiTietController {
    @RequestMapping("/hoadonchitiet")
    public String deatilHoaDon(){
        return "admin/hoadonview/hoadonchitiet";
    }
}
