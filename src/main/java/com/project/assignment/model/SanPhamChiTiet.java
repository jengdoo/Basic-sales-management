package com.project.assignment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "SanPhamChiTiet")
public class SanPhamChiTiet {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank(message = "mã sản phẩm chi tiết không trống")
    @Column(name = "MaSPCT")
    private String maspct;
    @ManyToOne
    @JoinColumn(name = "IdSanPham",referencedColumnName = "ID")
    private SanPham sanpham;
    @ManyToOne
    @JoinColumn(name = "IdMauSac",referencedColumnName = "ID")
    private MauSac mausac;
    @ManyToOne
    @JoinColumn(name = "IdKichThuoc",referencedColumnName = "ID")
    private KichThuoc kichthuoc;
    @Min(value = 0,message = "số lượng >=0")
    private int soluong;
    @Min(value = 0,message = "giá >0")
    private Double dongia;
    private Boolean trangthai;
    public SanPhamChiTiet( String maspct, SanPham sanpham, MauSac mausac, KichThuoc kichthuoc, Integer soluong, Double dongia) {
        this.maspct = maspct;
        this.sanpham = sanpham;
        this.mausac = mausac;
        this.kichthuoc = kichthuoc;
        this.soluong = soluong;
        this.dongia = dongia;
        this.trangthai = soluong > 0;
    }
//    public void updateTT(){
//        this.trangthai = soluong>0;
//    }
}
