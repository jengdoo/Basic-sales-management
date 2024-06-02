package com.project.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonChiTiet {
    private int id;
    private HoaDon hoadon;
    private SanPhamChiTiet spct;
    private int soluong;
    private double dongia;
    private List<String> trangthai;
}
