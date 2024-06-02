package com.project.assignment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table (name = "MauSac")
public class MauSac {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @NotBlank(message = "không để trống mã màu")
    @Column(name = "Ma")
    private String mamau;
    @NotBlank (message = "không để trống tên màu")
    @Column(name = "Ten")
    private String tenmau;
    @NotNull(message = "vui lòng chọn trạng thái")
    @Column (name = "TrangThai")
    private Boolean trangthai;
}
