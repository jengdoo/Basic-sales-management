package com.project.assignment.controller;

import com.project.assignment.model.NhanVien;
import com.project.assignment.service.implement.NhanVienimp;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class RegisterController {
    List<NhanVien> lstnv = new ArrayList<>();


}
