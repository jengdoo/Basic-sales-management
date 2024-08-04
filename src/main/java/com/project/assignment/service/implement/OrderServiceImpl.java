package com.project.assignment.service.implement;

import com.project.assignment.model.HoaDon;
import com.project.assignment.model.HoaDonChiTiet;
import com.project.assignment.reponsitory.HoaDonChiTietRepo;
import com.project.assignment.reponsitory.HoaDonRepo;
import com.project.assignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private HoaDonRepo hoaDonRepository;

    @Autowired
    private HoaDonChiTietRepo hoaDonChiTietRepository;
    @Override
    public void saveOrderAndOrderDetails(HoaDon hoaDon, List<HoaDonChiTiet> hoaDonChiTietList) {
        hoaDonRepository.save(hoaDon);
        for (HoaDonChiTiet hoaDonChiTiet : hoaDonChiTietList) {
            hoaDonChiTiet.setHoadon(hoaDon);
            hoaDonChiTietRepository.save(hoaDonChiTiet);
        }
    }
}
