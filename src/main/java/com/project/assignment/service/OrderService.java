package com.project.assignment.service;

import com.project.assignment.model.HoaDon;
import com.project.assignment.model.HoaDonChiTiet;

import java.util.List;

public interface OrderService {
    void saveOrderAndOrderDetails(HoaDon hoaDon, List<HoaDonChiTiet> hoaDonChiTietList);
}
