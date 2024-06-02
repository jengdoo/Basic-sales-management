package com.project.assignment.service.implement;

import com.project.assignment.model.NhanVien;
import com.project.assignment.reponsitory.KhachHangRepo;
import com.project.assignment.reponsitory.NhanVienRepo;
import com.project.assignment.service.NhanVienService;
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
public class NhanVienimp implements NhanVienService {
    @Autowired
    NhanVienRepo nhanVienRepo;
    private static int PAGE_SIZE_NHAN_VIEN=10;
    @Override
    public NhanVien logIn(String username, String password) {
       for (NhanVien nv : nhanVienRepo.findAll()){
           if(nv.getTendangnhap().equals(username)&&nv.getMatkhau().equals(password)){
               return nv;
           }
       }
        return null;
    }

    @Override
    public Page<NhanVien> getAllNV(int p) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(p,PAGE_SIZE_NHAN_VIEN,sort);
        return nhanVienRepo.findAll(pageable);
    }

    @Override
    public List<NhanVien> getAllNVL() {
        return nhanVienRepo.findAll();
    }

    @Override
    public void create(NhanVien nv) {
        nhanVienRepo.save(nv);
    }

    @Override
    public void update(NhanVien nv) {
       nhanVienRepo.save(nv);
    }

    @Override
    public void delete(Integer id) {
        nhanVienRepo.deleteById(id);
    }

    @Override
    public NhanVien getById(Integer id) {
        return nhanVienRepo.findById(id).get();
    }

    @Override
    public Page<NhanVien> getByName(String ten,int p) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(p,PAGE_SIZE_NHAN_VIEN,sort);
        return nhanVienRepo.findByTenContains(ten,pageable);
    }
}
