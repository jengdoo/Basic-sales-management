package com.project.assignment.service.implement;

import com.project.assignment.model.KichThuoc;
import com.project.assignment.reponsitory.KichThuocRepo;
import com.project.assignment.service.KichThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class KichThuocIpl implements KichThuocService {
    @Autowired
    KichThuocRepo kichThuocRepo;
    private static int PAGE_SIZE_KICH_THUOC=10;
    @Override
    public Page<KichThuoc> getAllKT(int p) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(p,PAGE_SIZE_KICH_THUOC,sort);
        return kichThuocRepo.findAll(pageable);
    }

    @Override
    public void createKT(KichThuoc kt) {
        kichThuocRepo.save(kt);
    }

    @Override
    public void deleteKT(Integer id) {
        kichThuocRepo.deleteById(id);
    }

    @Override
    public void updateKT(KichThuoc kt) {
        kichThuocRepo.save(kt);
    }

    @Override
    public KichThuoc kichThuocByID(Integer id) {
        return kichThuocRepo.findById(id).get();
    }

    @Override
    public Page<KichThuoc> getByNameKichThuoc(String ten, int p) {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(p,PAGE_SIZE_KICH_THUOC,sort);
        return kichThuocRepo.findByTenkt(ten,pageable);
    }
}
