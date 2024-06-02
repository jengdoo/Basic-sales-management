package com.project.assignment.service;

import com.project.assignment.model.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KhachHangService {
    Page<KhachHang> getAllKH(int p);
    Page<KhachHang> getByNameKH(String tenkh,int page);
    List<KhachHang> getAllKh();
    KhachHang getByIdKh(Integer id);
    void createKh(KhachHang kh);
    void deleteKh(Integer id);
    void updateKh(KhachHang kh);
}
