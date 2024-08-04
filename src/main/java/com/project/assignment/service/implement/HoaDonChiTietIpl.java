package com.project.assignment.service.implement;

import com.project.assignment.model.HoaDon;
import com.project.assignment.model.HoaDonChiTiet;
import com.project.assignment.model.SanPhamChiTiet;
import com.project.assignment.reponsitory.HoaDonChiTietRepo;
import com.project.assignment.service.HoaDonChiTietSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class HoaDonChiTietIpl implements HoaDonChiTietSevice {
    @Autowired
    HoaDonChiTietRepo hoaDonChiTietRepo;
    @Override
    public List<HoaDonChiTiet> getHoaDonChiTietByIdHoaDon(int id) {
        return hoaDonChiTietRepo.findHoaDonChiTietByHoadonId(id);
    }

    @Override
    public void thanhToanHoaDon(HoaDonChiTiet hoaDonChiTiet) {
        HoaDon hd = hoaDonChiTiet.getHoadon();
        SanPhamChiTiet spct = hoaDonChiTiet.getSpct();
        Integer soluong = hoaDonChiTiet.getSoluong();
        Double dongia = hoaDonChiTiet.getDongia();
        Date time = new Date();
        Integer trangthai = hoaDonChiTiet.getTrangthai();
        HoaDonChiTiet hdct = new HoaDonChiTiet(hd,spct,soluong,dongia,time,trangthai);
        hoaDonChiTietRepo.save(hdct);
    }

    @Override
    public List<HoaDonChiTiet> getAll() {
        return hoaDonChiTietRepo.findAll();
    }

}
