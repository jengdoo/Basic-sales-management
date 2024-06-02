package com.project.assignment.reponsitory;

import com.project.assignment.model.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HoaDonChiTietRepo extends JpaRepository<HoaDonChiTiet,Integer> {

    @Query("select hdct from HoaDonChiTiet hdct where hdct.hoadon.id = :id")
    HoaDonChiTiet findHoaDonChiTietByHoadonId(@Param("id") int id);
}
