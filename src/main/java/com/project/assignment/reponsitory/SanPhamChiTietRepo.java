package com.project.assignment.reponsitory;

import com.project.assignment.model.SanPham;
import com.project.assignment.model.SanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamChiTietRepo extends JpaRepository<SanPhamChiTiet,Integer> {
    @Query("SELECT spct FROM SanPhamChiTiet spct JOIN SanPham sp ON spct.sanpham.id = sp.id WHERE spct.sanpham.id = :id")
    Page<SanPhamChiTiet> findSanPhamChiTietBySanphamId(@Param("id") Integer idsp, Pageable pageable);
//    SanPhamChiTiet findSanPhamChiTietBySanphamId(Integer idsp);
}
