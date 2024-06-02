package com.project.assignment.reponsitory;

import com.project.assignment.model.KichThuoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KichThuocRepo extends JpaRepository<KichThuoc,Integer> {
    Page<KichThuoc> findByTenkt(String tenkt, Pageable p);
}
