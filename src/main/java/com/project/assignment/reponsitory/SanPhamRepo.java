package com.project.assignment.reponsitory;

import com.project.assignment.model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham,Integer> {
    Page<SanPham> findBytensp(String tensp, Pageable pageable);
    Page<SanPham> findByTrangthai(Boolean trangThai,Pageable pageable);

    SanPham findSanPhamById(Integer id);
}
