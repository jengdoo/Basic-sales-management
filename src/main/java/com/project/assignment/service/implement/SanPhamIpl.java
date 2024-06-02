package com.project.assignment.service.implement;

import com.project.assignment.model.SanPham;
import com.project.assignment.model.SanPhamChiTiet;
import com.project.assignment.reponsitory.SanPhamRepo;
import com.project.assignment.service.SanPhamService;
import org.hibernate.integrator.spi.Integrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class SanPhamIpl implements SanPhamService {
    @Autowired
    SanPhamRepo sanPhamRepo;
    private static final int PAGE_SIZE= 10;
    @Override
    public Page<SanPham> getAllSP(int p) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(p,PAGE_SIZE,sort);
        return sanPhamRepo.findAll(pageable);
    }

    @Override
    public void createSanPham(SanPham sp) {
        sanPhamRepo.save(sp);
    }

    @Override
    public void deleteSanPham(Integer id) {
        sanPhamRepo.deleteById(id);
    }
    @Override
    public void updateSanPham(SanPham sp) {
        sanPhamRepo.save(sp);
    }

    @Override
    public Page<SanPham> getSanPhamByName(String tensp, int page) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(page,PAGE_SIZE,sort);
        Page<SanPham> psp = sanPhamRepo.findBytensp(tensp,pageable);
        return psp;
    }

    @Override
    public Page<SanPham> getSanPhamByStatus(Boolean tt,int page) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(page,PAGE_SIZE,sort);
        Page<SanPham> psp= sanPhamRepo.findByTrangthai(tt,pageable);
        return psp;
    }
    @Override
    public String getProductNameById(Integer id) {
        for (SanPham sanPham : sanPhamRepo.findAll()) {
            if (sanPham.getId() == id) {
                return sanPham.getTensp();
            }
        }
        return "Không tìm thấy sản phẩm";
    }

    @Override
    public SanPham getSanPham(Integer id) {
        return sanPhamRepo.findById(id).get();
    }

}
