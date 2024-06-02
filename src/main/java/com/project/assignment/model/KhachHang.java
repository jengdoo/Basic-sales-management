package com.project.assignment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank(message = "không đê trống tên khách hàng")
    @Column(name = "Ten")
    private String tenkh;
    @NotBlank(message = "Không để trống số điện thoại")
    @Column(name = "SDT")
    private String sodt;
    @NotBlank(message = "không để trống mã khách hàng")
    @Column(name = "Ma")
    private String makh;
    @NotNull(message = "vui lòng chọn trạng thái")
    @Column(name = "TrangThai")
    private Boolean trangthai;
}
