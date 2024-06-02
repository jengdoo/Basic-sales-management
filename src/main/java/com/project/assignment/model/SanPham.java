package com.project.assignment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table (name = "SanPham")
public class SanPham {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank(message = "không để trống mã sản phẩm")
    @Column(name = "Ma")
    private String masp;
    @NotBlank(message = "không để trống tên sản phẩm")
    @Column(name = "Ten")
    private String tensp;
    @NotNull(message = "vui lòng chọn trạng thái")
    @Column(name = "TrangThai")
    private Boolean trangthai;

}
