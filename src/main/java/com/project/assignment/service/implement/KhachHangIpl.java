package com.project.assignment.service.implement;

import com.project.assignment.model.KhachHang;
import com.project.assignment.reponsitory.KhachHangRepo;
import com.project.assignment.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class KhachHangIpl implements KhachHangService {
    @Autowired
    KhachHangRepo khachHangRepo;
    private static int SIZE_PAGE_KHACH_HANG =10;

    @Override
    public Page<KhachHang> getAllKH(int p) {
        Sort sort = Sort.by(Sort.Direction.DESC,"tenkh");
        Pageable pageable = PageRequest.of(p,SIZE_PAGE_KHACH_HANG,sort);
        return khachHangRepo.findAll(pageable);
    }

    @Override
    public Page<KhachHang> getByNameKH(String tenkh,int p) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(p,SIZE_PAGE_KHACH_HANG,sort);
        return khachHangRepo.findByTenkh(tenkh,pageable);
    }

    @Override
    public List<KhachHang> getAllKh() {
        return khachHangRepo.findAll();
    }

    @Override
    public KhachHang getByIdKh(Integer id) {
        return khachHangRepo.findById(id).get();
    }

    @Override
    public void createKh(KhachHang kh) {
        khachHangRepo.save(kh);
    }

    @Override
    public void deleteKh(Integer id) {
        khachHangRepo.deleteById(id);
    }

    @Override
    public void updateKh(KhachHang kh) {
       khachHangRepo.save(kh);
    }
}
