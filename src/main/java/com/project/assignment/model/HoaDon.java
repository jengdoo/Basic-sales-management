package com.project.assignment.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "IdNV",referencedColumnName = "ID")
    private NhanVien nhanvien;
    @ManyToOne
    @JoinColumn(name = "IdKH",referencedColumnName = "ID")
    private KhachHang khachhang;
    @Column(name = "NgayMuaHang")
    private LocalDate ngaymuahang;
    @Column(name = "TrangThai")
    private int trangthai;

    public HoaDon(NhanVien nhanvien, KhachHang khachhang, LocalDate ngaymuahang, int trangthai) {
        this.nhanvien = nhanvien;
        this.khachhang = khachhang;
        this.ngaymuahang = ngaymuahang;
        this.trangthai = trangthai;
    }
}
