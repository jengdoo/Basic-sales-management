package com.project.assignment.controller;

import com.project.assignment.model.NhanVien;
import com.project.assignment.service.implement.NhanVienimp;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class QuanlyCotroller {
    private NhanVienimp nvsv = new NhanVienimp();

    @GetMapping("/quanly")
    public String getAll(NhanVien nhanvien, HttpSession session) {
        if (nhanvien != null) {
            session.setAttribute("trangthai", nhanvien.getTrangthai());
            System.out.println(nhanvien);
            return "admin/quanly";
        }
        return "admin/quanly";
    }
}
