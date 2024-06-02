package com.project.assignment.service;

import com.project.assignment.model.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NhanVienService {
    NhanVien logIn(String username,String password);
    Page<NhanVien> getAllNV( int p);
    List<NhanVien> getAllNVL();
    void create(NhanVien nv);
    void update(NhanVien nv);
    void delete(Integer id);
    NhanVien getById(Integer id);
    Page<NhanVien> getByName(String ten,int p);
}
