package com.project.assignment.service;

import com.project.assignment.model.HoaDon;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HoaDonService {
    Page<HoaDon> getAllHD(int p);
    List<HoaDon> getById(int id);
    void create(HoaDon hoaDon);
}
