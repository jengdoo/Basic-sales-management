package com.project.assignment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
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
    @ManyToOne
    @JoinColumn(name = "IdHoaDon",referencedColumnName = "id")
    @NotNull(message = "Vui lòng tạo hóa đơn trước khi thanh toán")
    private HoaDon hoadon;
    @ManyToOne
    @JoinColumn(name = "IdSPCT",referencedColumnName = "id")
    @NotNull(message = "Vui lòng thêm sản phẩm trước khi thanh toán")
    private SanPhamChiTiet spct;
    @Column(name = "SoLuong")
    private Integer soluong;
    @Column(name = "DonGia")
    private Double dongia;
    @Column(name = "ThoiGian")
    private LocalTime tg;
    @Column(name = "TrangThai")
    private Integer trangthai;

    public HoaDonChiTiet(HoaDon hoadon, SanPhamChiTiet spct, Integer soluong, Double dongia, LocalTime tg, Integer trangthai) {
        this.hoadon = hoadon;
        this.spct = spct;
        this.soluong = soluong;
        this.dongia = dongia;
        this.tg = tg;
        this.trangthai = trangthai;
    }
}
