package com.project.assignment.service;

import com.project.assignment.model.KichThuoc;
import com.project.assignment.model.MauSac;
import com.project.assignment.model.SanPham;
import com.project.assignment.model.SanPhamChiTiet;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface SanPhamChiTietService {
    Page<SanPhamChiTiet> getByIdSanPham(Integer id,int p);
    Page<SanPhamChiTiet> getAllSPCT(int p);
    void create(SanPhamChiTiet spct);
    void delete(Integer id);
    void update(SanPhamChiTiet spct);
    SanPhamChiTiet getByID(Integer id);
    List<SanPhamChiTiet> getByIdToBanHang(Integer id);
    List<SanPhamChiTiet> getAll();
}
