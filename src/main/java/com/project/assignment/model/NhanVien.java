package com.project.assignment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table (name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank (message = "không để trống mã nhân viên")
    @Column(name = "Ma")
    private String manv;
    @NotBlank (message = "không để trống tên")
    @Column(name = "Ten")
    private String ten;
    @NotBlank (message = "không để trống tên đăng nhập")
    @Column(name = "TenDangNhap")
    private String tendangnhap;
    @NotBlank (message = "không để trống mật khẩu")
    @Column(name = "MatKhau")
    private String matkhau;
    @NotNull(message = "Vui lòng chọn trạng thái")
    @Column(name = "TrangThai")
    private Boolean trangthai;
}
