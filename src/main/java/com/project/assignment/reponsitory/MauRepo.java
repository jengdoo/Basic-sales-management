package com.project.assignment.reponsitory;

import com.project.assignment.model.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauRepo extends JpaRepository<MauSac,Integer> {
    Page<MauSac> findByTenmau(String tenmau, Pageable pageable);
}
