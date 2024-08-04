package com.project.assignment.service;

import com.project.assignment.model.HoaDonChiTiet;

import java.util.List;

public interface HoaDonChiTietSevice {
    List<HoaDonChiTiet> getHoaDonChiTietByIdHoaDon(int id);
    void thanhToanHoaDon(HoaDonChiTiet hoaDonChiTiet);
    List<HoaDonChiTiet> getAll();
}
