package com.project.assignment.service.implement;

import com.project.assignment.model.HoaDonChiTiet;
import com.project.assignment.reponsitory.HoaDonChiTietRepo;
import com.project.assignment.service.HoaDonChiTietSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoaDonChiTietIpl implements HoaDonChiTietSevice {
    @Autowired
    HoaDonChiTietRepo hoaDonChiTietRepo;
    @Override
    public HoaDonChiTiet getHoaDonChiTietByIdHoaDon(int id) {
        return hoaDonChiTietRepo.findHoaDonChiTietByHoadonId(id);
    }
}
