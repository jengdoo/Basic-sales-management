package com.project.assignment.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaymuahang;
    @Column(name = "TrangThai")
    private int trangThai;

    public HoaDon(NhanVien nhanvien, KhachHang khachhang, Date ngaymuahang, int trangthai) {
        this.nhanvien = nhanvien;
        this.khachhang = khachhang;
        this.ngaymuahang = ngaymuahang;
        this.trangThai = trangthai;
    }
}
