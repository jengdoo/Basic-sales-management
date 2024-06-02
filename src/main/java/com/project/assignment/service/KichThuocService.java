package com.project.assignment.service;

import com.project.assignment.model.KichThuoc;
import org.springframework.data.domain.Page;

import java.util.List;

public interface KichThuocService {
    Page<KichThuoc> getAllKT(int p);
    void createKT(KichThuoc kt);
    void deleteKT(Integer id);
    void updateKT(KichThuoc kt);
    KichThuoc kichThuocByID(Integer id);
    Page<KichThuoc> getByNameKichThuoc(String ten, int p);
}
