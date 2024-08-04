package com.project.assignment.controller;

import com.project.assignment.model.*;
import com.project.assignment.reponsitory.*;
import com.project.assignment.service.implement.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/hoadonview")
public class HoaDonController {
    private final SanPhamChiTietEpl sanPhamChiTietEpl ;
    private final HoaDonIpl hoaDonIpl;
    private final SanPhamChiTietRepo sanPhamChiTietRepo;
    private final NhanVienimp nhanVienimp;
    private final KhachHangIpl khachHangIpl;
    private final HoaDonRepo hoaDonRepo;
    private final HoaDonChiTietRepo hoaDonChiTietRepo;
    @Autowired
    HttpSession session;

    @GetMapping("/hoadon")
    public String getHoaDon(@RequestParam(name = "p", defaultValue = "0") int p, Model model) {
        model.addAttribute("lsthd", hoaDonIpl.getAllHD(p));
        return "admin/hoadonview/hoadon";
    }

    @GetMapping("/banhang")
    public String toIndex(@RequestParam(value = "p", defaultValue = "0") int page, Model model) {
        List<SanPhamChiTiet> gioHang = (List<SanPhamChiTiet>) session.getAttribute("gioHang");
        if (gioHang == null) {
            gioHang = new ArrayList<>();
        }
        model.addAttribute("gioHang", gioHang);
        model.addAttribute("lstspct", sanPhamChiTietEpl.getAllSPCT(page));
        model.addAttribute("lsthdbh", hoaDonIpl.getLstHoaDonBanHang());
        model.addAttribute("hoaDon", new HoaDon());
        model.addAttribute("lstNhanVien", nhanVienimp.getAllNVL());
        model.addAttribute("lstKhachHang", khachHangIpl.getAllKh());
        return "admin/hoadonview/banhang";
    }

    @GetMapping("/muahang")
    public String addSanPham(@RequestParam("id") Integer id, @RequestParam(name = "tienKhachDua", defaultValue = "0") Double tienKhachDua, Model model) {
        SanPhamChiTiet sanPhamChiTiets = sanPhamChiTietEpl.getByID(id);
        if (sanPhamChiTiets == null || sanPhamChiTiets.getSoluong() <= 0) {
            model.addAttribute("messagesoluong", "Sản phẩm đã hết");
            return "redirect:/admin/hoadonview/banhang";
        }

        List<SanPhamChiTiet> gioHang = (List<SanPhamChiTiet>) session.getAttribute("gioHang");
        if (gioHang == null) {
            gioHang = new ArrayList<>();
        }

        boolean sanPhamTonTai = false;
        for (SanPhamChiTiet spct : gioHang) {
            if (spct.getId().equals(sanPhamChiTiets.getId())) {
                spct.setSoluong(spct.getSoluong() + 1);
                sanPhamTonTai = true;
                break;
            }
        }

        if (!sanPhamTonTai) {
            SanPhamChiTiet spctMoi = new SanPhamChiTiet();
            spctMoi.setId(sanPhamChiTiets.getId());
            spctMoi.setMaspct(sanPhamChiTiets.getMaspct());
            spctMoi.setSanpham(sanPhamChiTiets.getSanpham());
            spctMoi.setMausac(sanPhamChiTiets.getMausac());
            spctMoi.setKichthuoc(sanPhamChiTiets.getKichthuoc());
            spctMoi.setSoluong(1);
            spctMoi.setDongia(sanPhamChiTiets.getDongia());
            gioHang.add(spctMoi);
        }

        sanPhamChiTiets.setSoluong(sanPhamChiTiets.getSoluong() - 1);
        if (sanPhamChiTiets.getSoluong() <= 0) {
            sanPhamChiTiets.setTrangthai(false);
        }
        sanPhamChiTietRepo.save(sanPhamChiTiets);

        double tongGia = gioHang.stream().mapToDouble(spct -> spct.getSoluong() * spct.getDongia()).sum();
        int tongSoLuong = gioHang.stream().mapToInt(SanPhamChiTiet::getSoluong).sum();
        double tienthua = tienKhachDua - tongGia;

        HoaDonChiTiet hoadonchitiet = (HoaDonChiTiet) session.getAttribute("hoadonchitiet");
        if (hoadonchitiet == null) {
            hoadonchitiet = new HoaDonChiTiet();
        }
        hoadonchitiet.setSoluong(tongSoLuong);
        hoadonchitiet.setDongia(tongGia);

        model.addAttribute("tongSoLuong", tongSoLuong);
        model.addAttribute("tongGia", tongGia);
        model.addAttribute("tienThua", tienthua);
        session.setAttribute("gioHang", gioHang);
        session.setAttribute("hoadonchitiet", hoadonchitiet);
        return "redirect:/admin/hoadonview/banhang";
    }

    @PostMapping("/muaSPCT")
    public String muaTheoSPCT(@ModelAttribute("hoadonchitiet") HoaDonChiTiet hoaDonChiTiet, @RequestParam(name = "tienKhachDua",defaultValue = "0.0") Double tienKhachDua, @RequestParam("hoadon") int id,Model model) {
        List<SanPhamChiTiet> gioHang = (List<SanPhamChiTiet>) session.getAttribute("gioHang");
        HoaDonChiTiet hoadonchitiet = (HoaDonChiTiet) session.getAttribute("hoadonchitiet");
        if (hoadonchitiet == null) {
            hoadonchitiet = new HoaDonChiTiet();
        }
        if (gioHang == null || gioHang.isEmpty()) {
            model.addAttribute("info", "Giỏ hàng của bạn đang trống, vui lòng thêm sản phẩm trước khi thanh toán.");
            return "admin/hoadonview/banhang";
        }
        if (id <= 0) {
            model.addAttribute("info", "Vui lòng chọn hóa đơn hợp lệ.");
            return "admin/hoadonview/banhang";
        }
        if (tienKhachDua <= 0) {
            model.addAttribute("errorMessage", "Vui lòng nhập số tiền khách đưa.");
            return "admin/hoadonview/banhang";
        }
        List<HoaDonChiTiet> hoaDonChiTiets = new ArrayList<>();
        for (SanPhamChiTiet productDetail : gioHang) {
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setSpct(productDetail);
            hdct.setDongia(productDetail.getDongia());
            hdct.setSoluong(productDetail.getSoluong());
            hoaDonChiTiets.add(hdct);
        }
        if(tienKhachDua<=0){
            model.addAttribute("errorMessage", "vui lòng nhập tiền");
        }
        double tongGia = gioHang.stream().mapToDouble(spct -> spct.getSoluong() * spct.getDongia()).sum();
        double tienThua = tienKhachDua - tongGia;
        if(tienKhachDua<tienThua){
            model.addAttribute("errorMessage", "Số tiền chưa đủ!");
        }
        if (tienThua < 0) {
            model.addAttribute("errorMessage", "Số tiền khách đưa không đủ để thanh toán hóa đơn.");
            return "admin/hoadonview/banhang";
        }

        HoaDon hoaDon = hoaDonRepo.findById(id).orElse(null);
        if (hoaDon == null) {
            model.addAttribute("info", "Hóa đơn không tồn tại.");
            return "admin/hoadonview/banhang";
        }
        else {
            hoaDon.setTrangThai(2);
            hoaDon.setNgaymuahang(new Date());
            hoaDonRepo.save(hoaDon);
        }
        for (HoaDonChiTiet hdcts : hoaDonChiTiets) {
            hdcts.setHoadon(hoaDon);
            hdcts.setTrangthai(2);
            hdcts.setTg(new Date());
            hoaDonChiTietRepo.save(hdcts);
        }

        session.removeAttribute("hoadonchitiet");
        session.removeAttribute("gioHang");

        model.addAttribute("hoaDonChiTiet", hoaDonChiTiet);
        model.addAttribute("tienThua", tienThua);

        return "redirect:/admin/hoadonview/hoadon";
    }
    @GetMapping("/updategiohang")
    public String updateGioHang(@RequestParam("id") Integer id, @RequestParam("action") String action, Model model) {
        List<SanPhamChiTiet> gioHang = (List<SanPhamChiTiet>) session.getAttribute("gioHang");
        if (gioHang != null) {
            for (SanPhamChiTiet spct : gioHang) {
                if (spct.getId().equals(id)) {
                    if ("increase".equals(action)) {
                        spct.setSoluong(spct.getSoluong() + 1);
                    } else if ("decrease".equals(action) && spct.getSoluong() > 1) {
                        spct.setSoluong(spct.getSoluong() - 1);
                    } else if ("remove".equals(action)) {
                        gioHang.remove(spct);
                    }
                    break;
                }
            }
            session.setAttribute("gioHang", gioHang);
        }
        return "redirect:/admin/hoadonview/banhang";
    }

    @GetMapping("/xemhoadon")
    public String xemHoaDon(@RequestParam("id") Integer id, Model model) {
        HoaDon hoaDon = hoaDonRepo.findById(id).orElse(null);
        if (hoaDon != null) {
            List<HoaDonChiTiet> hoaDonChiTiets = hoaDonChiTietRepo.findHoaDonChiTietByHoadonId(id);
            model.addAttribute("hoaDon", hoaDon);
            model.addAttribute("hoaDonChiTiets", hoaDonChiTiets);
        }
        return "admin/hoadonview/hoadon_detail";
    }
    @PostMapping("/taoHD")
    public String taoHoaDon(@Valid @ModelAttribute("hoaDon") HoaDon hoaDon, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("messagehd", "Có lỗi xảy ra khi tạo hóa đơn");
            model.addAttribute("errors", result.getAllErrors());
            return "redirect:/admin/hoadonview/banhang";
        }
        hoaDonIpl.create(hoaDon);
        return "redirect:/admin/hoadonview/banhang";
    }
    @GetMapping("/banhangnew")
    public String viewBanHang(Model model, HttpSession session) {
        List<SanPhamChiTiet> sanPhamChiTietList = sanPhamChiTietRepo.findAll();
        model.addAttribute("sanPhamChiTietList", sanPhamChiTietList);

        List<SanPhamChiTiet> gioHang = (List<SanPhamChiTiet>) session.getAttribute("gioHang");
        if (gioHang == null) {
            gioHang = new ArrayList<>();
        }
        model.addAttribute("gioHang", gioHang);

        return "admin/hoadonview/banhang";
    }
    @GetMapping("/huyhoadon")
    public String huyHoaDon(@RequestParam("id") int id,Model model){
        HoaDon dh = hoaDonIpl.updateHoaDon(id);
        List<HoaDon> listhd = new ArrayList<>();
        listhd.remove(dh);
        HoaDon hoaDon = hoaDonRepo.findById(id).orElse(null);
        if(hoaDon!=null && hoaDon.getTrangThai()==0){
            hoaDon.setTrangThai(1);
            hoaDonRepo.save(hoaDon);
        }
        model.addAttribute("lsthdbh",hoaDonIpl.getLstHoaDonBanHang());
        return "redirect:/admin/hoadonview/banhang";
    }
    @GetMapping("/choose/{id}")
    public String getChooseHD(@PathVariable("id") Integer id,@RequestParam(name = "p",defaultValue = "0")int page,Model model){
        model.addAttribute("lstspct",sanPhamChiTietEpl.getAllSPCT(page));
        model.addAttribute("hoadon",hoaDonRepo.findById(id).get());
        return "admin/hoadonview/banhang";
    }
    @ModelAttribute("lstNhanVien")
    public List<NhanVien> getAllNV(){
        return nhanVienimp.getAllNVL();
    }
    @ModelAttribute("lstKhachHang")
    public List<KhachHang> getAllKH(){
        return khachHangIpl.getAllKh();
    }

    @ModelAttribute("hoadoncho")
    public int hoaDonHuy(){
        return hoaDonIpl.hoaDonHuy();
    }
    @ModelAttribute("tongHoaDon")
    public int tongHoaDon(){
        return hoaDonRepo.countHoaDon();
    }

    @ModelAttribute("lsthd")
    public List<HoaDon> getListHD(){
        return hoaDonRepo.findHoaDonsByTrangthai();
    }
}