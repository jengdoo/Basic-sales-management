package com.project.assignment.controller;

import com.project.assignment.model.NhanVien;
import com.project.assignment.service.implement.NhanVienimp;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class QuanlyCotroller {
    private final NhanVienimp nhanVienimp;
    private final HttpSession session;
    @GetMapping("/quanly")
    public String getAdmin(Model model) {
        NhanVien nhanvien = (NhanVien) session.getAttribute("user");
        if (nhanvien == null ) {
            return "redirect:/user/logins";
        }
        return "admin/quanly";
    }
    @GetMapping("/nhanvien")
    public String getAll(Model model) {
        NhanVien nhanVien = (NhanVien) session.getAttribute("user");
        if (nhanVien == null) {
            return "redirect:/user/logins";
        }
        return "admin/nhanvien";
    }
}
