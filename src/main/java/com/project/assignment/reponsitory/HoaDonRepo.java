package com.project.assignment.reponsitory;

import com.project.assignment.model.HoaDon;
import com.project.assignment.model.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HoaDonRepo extends JpaRepository<HoaDon,Integer> {
    @Query("select count(hd) from HoaDon hd where hd.trangThai = 0 ")
    int countHoaDonByTrangthai();
    @Query("select count(hd) from HoaDon hd")
    int countHoaDon();

    @Query("select hd from HoaDon hd where hd.trangThai = 0")
    List<HoaDon> findHoaDonsByTrangthai();

    List<HoaDon> findByTrangThai(Integer trangThai);

    @Query("SELECT COUNT(hd) FROM HoaDon hd WHERE hd.trangThai = 1")
    int countCancelledOrders();

}
