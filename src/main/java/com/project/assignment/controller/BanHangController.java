package com.project.assignment.controller;

import com.project.assignment.model.HoaDon;
import com.project.assignment.model.SanPhamChiTiet;
import com.project.assignment.service.implement.HoaDonIpl;
import com.project.assignment.service.implement.SanPhamChiTietEpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@RequestMapping("/admin/hoadonview")
//public class BanHangController {
//    SanPhamChiTietEpl sanPhamChiTietEpl = new SanPhamChiTietEpl();
//    HoaDonIpl hoaDonIpl = new HoaDonIpl();
//    @GetMapping("/banhang")
//    public String getBanHang(Model model){
//        model.addAttribute("lstspct",sanPhamChiTietEpl.getAllSPCT());
//        return "admin/hoadonview/banhang";
//    }
//    @GetMapping("/banhang")
//    public String toIndex(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
//        model.addAttribute("lstspct",sanPhamChiTietEpl.getAllSPCT());
//        int recordsPerPage = 3;
//        int start = (page - 1) * recordsPerPage;
//        int end = Math.min(start + recordsPerPage, sanPhamChiTietEpl.getAllSPCT().size());
//
//        List<SanPhamChiTiet> list = sanPhamChiTietEpl.getAllSPCT().subList(start, end);
//        int noOfRecords = sanPhamChiTietEpl.getAllSPCT().size();
//        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
//
//        model.addAttribute("lstspct", list);
//        model.addAttribute("noOfPages", noOfPages);
//        model.addAttribute("currentPage", page);
//
//        return "admin/hoadonview/banhang";
//    }
//    @PostMapping("/banhang")
//    public String addHoaDon(@ModelAttribute HoaDon hoadon, Model model){
//        boolean hasError = false;
//        if (hoadon.getKhachhang() == null || hoadon.getKhachhang().getTenkh() == null || hoadon.getKhachhang().getTenkh().trim().isEmpty()) {
//            model.addAttribute("messagehd", "Vui lòng nhập khách hàng");
//            hasError = true;
//        }
//        if (hoadon.getNhanvien() == null || hoadon.getNhanvien().getManv() == null || hoadon.getNhanvien().getManv().trim().isEmpty()) {
//            model.addAttribute("messagehd", "Vui lòng nhập nhân viên");
//            hasError = true;
//        }
//        if ( hoadon.getId() <= 0) {
//            model.addAttribute("messagehd", "Vui lòng nhập mã hóa đơn hợp lệ");
//            hasError = true;
//        }
//        if (hasError) {
//            return "admin/hoadonview/banhang";
//        }
//        hoaDonIpl.create(hoadon);
//        model.addAttribute("lsthdbh",hoaDonIpl.getLstHoaDonBanHang());
//        model.addAttribute("lsthd", hoaDonIpl.getAllHD());
//        model.addAttribute("messagehd", "Tạo hóa đơn thành công");
//        System.out.println("lstbh"+hoaDonIpl.getLstHoaDonBanHang());
//        System.out.println("lsthd"+ hoaDonIpl.getAllHD());
//        return "admin/hoadonview/banhang";
//    }
//}
