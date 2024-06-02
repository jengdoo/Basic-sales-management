package com.project.assignment.service.implement;

import com.project.assignment.model.MauSac;
import com.project.assignment.reponsitory.MauRepo;
import com.project.assignment.service.MauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MauIpl implements MauService {
    @Autowired
    MauRepo mauRepo;
    private static int PAGE_SIZE_MAU=10;

    @Override
    public Page<MauSac> getAllMau(int p) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(p,PAGE_SIZE_MAU,sort);
        return mauRepo.findAll(pageable);
    }

    @Override
    public void createMau(MauSac mau) {
        mauRepo.save(mau);
    }

    @Override
    public void deleteMau(Integer id) {
        mauRepo.deleteById(id);
    }

    @Override
    public void updateMau(MauSac mau) {
        mauRepo.save(mau);
    }

    @Override
    public MauSac mauSacByID(Integer id) {
        return mauRepo.findById(id).get();
    }

    @Override
    public Page<MauSac> getByNameMau(String ten, int page) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(page,PAGE_SIZE_MAU,sort);
        return mauRepo.findByTenmau(ten,pageable);
    }
}
