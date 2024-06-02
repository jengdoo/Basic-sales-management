package com.project.assignment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "KichThuoc")
public class KichThuoc {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ID")
    private Integer id;
    @NotBlank(message = "không để trống mã")
    @Column (name = "Ma")
    private String makt;
    @Column (name = "Ten")
    @NotBlank(message = "không để trống tên")
    private String tenkt;
    @NotNull (message = "vui lòng chọn trạng thái")
    @Column(name = "TrangThai")
    private Boolean trangthai;
}
