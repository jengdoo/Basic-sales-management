package com.project.assignment.reponsitory;

import com.project.assignment.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang,Integer> {
    Page<KhachHang> findByTenkh(String tenkh, Pageable pageable);
}
