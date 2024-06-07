package com.project.assignment.controller;

import com.project.assignment.model.NhanVien;
import com.project.assignment.service.NhanVienService;
import com.project.assignment.service.implement.NhanVienimp;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class LoginController {
    private final NhanVienimp nhanVienimp ;
    private final HttpSession session;
    @GetMapping("/logins")
    public String toLogin(Model model){
        return "user/login";
    }
    @PostMapping("/logins")
    public String getLogin(NhanVien nhanvien, Model model    ) {
        String tendangnhap = nhanvien.getTendangnhap();
        String matkhau = nhanvien.getMatkhau();
        NhanVien nvm = nhanVienimp.logIn(tendangnhap, matkhau);
        if (tendangnhap.equals(null) || tendangnhap.isEmpty() || matkhau.equals(null) || matkhau.isEmpty()) {
            model.addAttribute("messagelogin", "Vui lòng không để trống tên đăng nhập và password!");
            return "user/login";
        }
        if (nvm != null) {
            session.setAttribute("user", nvm);
            if (nvm.getTrangthai()==true) {
                System.out.println(nvm);
                return "redirect:/admin/quanly";
            } else {
                System.out.println(nvm);
                return "redirect:/admin/nhanvien";
            }
        }
        System.out.println(nvm);
        model.addAttribute("messagelogin", "sai tài khoản hoặc mật khẩu");
        return "user/login";
    }
    @RequestMapping("/register")
    public String toRegister(Model model){
        model.addAttribute("nhanvien",new NhanVien());
        return "user/registers";
    }
    @PostMapping("/register")

    public String postRegister(@Valid @ModelAttribute("nhanvien") NhanVien nhanvien, BindingResult result, Model model, @RequestParam("xacnhanmatkhau") String xacnhanmatkhau){
//        List<NhanVien> lnv = nvsv.getAllNV();
        if(result.hasErrors()){
            return "user/registers";
        }
        if(!nhanvien.getMatkhau().equals(xacnhanmatkhau)){
            model.addAttribute("messagepass","mật khẩu không trùng khớp");
        }
        nhanVienimp.create(nhanvien);
        System.out.println();
        model.addAttribute("message","đăng ký thành công");
        return "redirect:/user/logins";
    }
}
