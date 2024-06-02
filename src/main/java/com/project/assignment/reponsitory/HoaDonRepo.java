package com.project.assignment.reponsitory;

import com.project.assignment.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HoaDonRepo extends JpaRepository<HoaDon,Integer> {
    @Query("select count(hd) from HoaDon hd where hd.trangthai = 0 ")
    int countHoaDonByTrangthai();
    @Query("select count(hd) from HoaDon hd")
    int countHoaDon();
}
