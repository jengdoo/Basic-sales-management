package com.project.assignment.service;

import com.project.assignment.model.SanPham;
import com.project.assignment.model.SanPhamChiTiet;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SanPhamService {
    Page<SanPham> getAllSP(int p);
    void createSanPham(SanPham sp);
    void deleteSanPham(Integer id);
    void updateSanPham(SanPham sp);
    Page<SanPham> getSanPhamByName(String tensp,int page);
    Page<SanPham> getSanPhamByStatus(Boolean tt,int page);
    String getProductNameById(Integer id);
    SanPham getSanPham(Integer id);
}
