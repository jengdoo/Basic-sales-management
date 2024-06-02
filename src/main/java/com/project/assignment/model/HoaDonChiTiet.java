package com.project.assignment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @OneToOne
    @JoinColumn(name = "IdHoaDon",referencedColumnName = "id")
    private HoaDon hoadon;
    @ManyToOne
    @JoinColumn(name = "IdSPCT",referencedColumnName = "id")
    private SanPhamChiTiet spct;
    @Column(name = "SoLuong")
    private Integer soluong;
    @Column(name = "DonGia")
    private Double dongia;
    @Column(name = "TrangThai")
    private Integer trangthai;
}
