package com.project.assignment.service.implement;

import com.project.assignment.model.KichThuoc;
import com.project.assignment.model.MauSac;
import com.project.assignment.model.SanPham;
import com.project.assignment.model.SanPhamChiTiet;
import com.project.assignment.reponsitory.SanPhamChiTietRepo;
import com.project.assignment.service.SanPhamChiTietService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class SanPhamChiTietEpl implements SanPhamChiTietService {
    @Autowired
    SanPhamChiTietRepo sanPhamChiTietRepo;
    private static int PAGE_SIZE_SAN_PHAM_CHI_TIET = 10;
    private static int PAGE_SAN_PHAM_CHI_TIET_BAN_HANG = 5;
    @Override
    public Page<SanPhamChiTiet> getByIdSanPham(Integer id,int p) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(p,PAGE_SIZE_SAN_PHAM_CHI_TIET,sort);
        return sanPhamChiTietRepo.findSanPhamChiTietBySanphamId(id,pageable);
    }

    @Override
    public Page<SanPhamChiTiet> getAllSPCT(int p) {
        Sort sort = Sort.by(Sort.Direction.DESC,"soluong");
        Pageable pageable = PageRequest.of(p,PAGE_SAN_PHAM_CHI_TIET_BAN_HANG,sort);
        return sanPhamChiTietRepo.findAll(pageable);
    }

    @Override
    public void create(SanPhamChiTiet spct) {
        String masp = spct.getMaspct();
        SanPham sp = spct.getSanpham();
        KichThuoc kt = spct.getKichthuoc();
        MauSac m = spct.getMausac();
        Integer soluong = spct.getSoluong();
        Double gia = spct.getDongia();
        SanPhamChiTiet spctt = new SanPhamChiTiet(masp,sp,m,kt,soluong,gia);
        sanPhamChiTietRepo.save(spctt);
    }

    @Override
    public void delete(Integer id) {
        sanPhamChiTietRepo.deleteById(id);
    }

    @Override
    public void update(SanPhamChiTiet spct) {
        sanPhamChiTietRepo.save(spct);
    }

    @Override
    public SanPhamChiTiet getByID(Integer id) {
        return sanPhamChiTietRepo.findById(id).get();
    }

    @Override
    public List<SanPhamChiTiet> getByIdToBanHang(Integer id) {
        return sanPhamChiTietRepo.findAll();
    }

    @Override
    public List<SanPhamChiTiet> getAll() {
        return sanPhamChiTietRepo.findAll();
    }

}
