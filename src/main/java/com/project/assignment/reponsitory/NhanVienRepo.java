package com.project.assignment.reponsitory;

import com.project.assignment.model.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepo extends JpaRepository<NhanVien,Integer> {
    Page<NhanVien> findByTenContains(String ten, Pageable pageable);
}
