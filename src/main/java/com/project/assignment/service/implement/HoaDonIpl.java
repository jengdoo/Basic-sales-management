package com.project.assignment.service.implement;

import com.project.assignment.model.HoaDon;
import com.project.assignment.model.KhachHang;
import com.project.assignment.model.NhanVien;
import com.project.assignment.reponsitory.HoaDonRepo;
import com.project.assignment.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HoaDonIpl implements HoaDonService {
    @Autowired
    HoaDonRepo hoaDonRepo;
    List<HoaDon> lsthd = new ArrayList<>();
    private static int PAGE_SIZE_HOA_DON=10;
    @Override
    public Page<HoaDon> getAllHD(int p) {
        Sort sort = Sort.by(Sort.Direction.DESC,"ngaymuahang");
        Pageable pageable = PageRequest.of(p,PAGE_SIZE_HOA_DON,sort);
        return hoaDonRepo.findAll(pageable);
    }

    @Override
    public List<HoaDon> getById(int id) {
        return null;
    }

    @Override
    public void create(HoaDon hoaDon) {
        NhanVien nv = hoaDon.getNhanvien();
        KhachHang kh = hoaDon.getKhachhang();
        Date ngaymua = new Date();
        int  tt= 0;
        HoaDon hd = new HoaDon(nv,kh,ngaymua,tt);
        lsthd.add(hd);
        hoaDonRepo.save(hd);
    }
    public List<HoaDon> getLstHoaDonBanHang(){

        return lsthd.stream().toList();
    }
    public HoaDon updateHoaDon(int id){
        for(HoaDon h : lsthd){
            if(h.getId()==id){
                lsthd.remove(h);
            }
            return h;
        }
        return null;
    }

    public int hoaDonHuy(){
        return hoaDonRepo.countHoaDonByTrangthai();
    }
}
