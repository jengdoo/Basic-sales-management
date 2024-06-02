package com.project.assignment.service;

import com.project.assignment.model.MauSac;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MauService {
    Page<MauSac> getAllMau(int p);
    void createMau(MauSac mau);
    void deleteMau(Integer id);
    void updateMau(MauSac mau);
    MauSac mauSacByID(Integer id);
    Page<MauSac> getByNameMau(String ten,int page);
}
