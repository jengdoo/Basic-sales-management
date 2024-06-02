package com.project.assignment.controller;

import com.project.assignment.model.*;
import com.project.assignment.reponsitory.HoaDonRepo;
import com.project.assignment.reponsitory.KhachHangRepo;
import com.project.assignment.reponsitory.NhanVienRepo;
import com.project.assignment.reponsitory.SanPhamChiTietRepo;
import com.project.assignment.service.implement.HoaDonIpl;
import com.project.assignment.service.implement.KhachHangIpl;
import com.project.assignment.service.implement.NhanVienimp;
import com.project.assignment.service.implement.SanPhamChiTietEpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    HttpSession session;

    @GetMapping("/hoadon")
    public String getHoaDon(@RequestParam(name = "p",defaultValue = "0") int p,Model model){
        model.addAttribute("lsthd",hoaDonIpl.getAllHD(p));
        return "admin/hoadonview/hoadon";
    }
    @GetMapping("/banhang")
   public String toIndex(@RequestParam(value = "p", defaultValue = "0") int page, Model model) {
        model.addAttribute("lstspct",sanPhamChiTietEpl.getAllSPCT(page));
        model.addAttribute("lsthdbh",hoaDonIpl.getLstHoaDonBanHang());
        return "admin/hoadonview/banhang";
    }
    @GetMapping("/muahang")
    public String addSanPham(@RequestParam("id") Integer id,Model model){
        SanPhamChiTiet sanPhamChiTiets = sanPhamChiTietEpl.getByID(id);
        if(sanPhamChiTiets==null|| sanPhamChiTiets.getSoluong()<=0){
            model.addAttribute("messagesoluong","sản phẩm đã hết");
            return "redirect:/admin/hoadonview/banhang";
        }
        // Lấy giỏ hàng từ session, nếu không có tạo giỏ hàng mới
        List<SanPhamChiTiet> gioHang = (List<SanPhamChiTiet>) session.getAttribute("gioHang");
        if (gioHang == null) {
            gioHang = new ArrayList<>();
        }

        // Kiểm tra sản phẩm đã tồn tại trong giỏ hàng chưa
        boolean sanPhamTonTai = false;
        for (SanPhamChiTiet spct : gioHang) {
            if (spct.getMaspct().equals(sanPhamChiTiets.getMaspct())) {
                spct.setSoluong(spct.getSoluong() + 1);
                sanPhamTonTai = true;
                break;
            }
        }

        // Nếu sản phẩm chưa tồn tại trong giỏ hàng, thêm vào giỏ hàng
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
        // Giảm số lượng sản phẩm trong kho
        sanPhamChiTiets.setSoluong(sanPhamChiTiets.getSoluong() - 1);
        sanPhamChiTietRepo.save(sanPhamChiTiets);

        // Lưu giỏ hàng vào session
        session.setAttribute("gioHang", gioHang);

        return "redirect:/admin/hoadonview/banhang";
    }
    @GetMapping("/updategiohang")
    public String soLuongGioHang(@RequestParam("id") Integer id,@RequestParam("action") String action,Model model){
        SanPhamChiTiet spct = sanPhamChiTietEpl.getByID(id);
        List<SanPhamChiTiet> spctl = (List<SanPhamChiTiet>) session.getAttribute("gioHang");
        if(spctl.isEmpty()|| spctl==null){
            model.addAttribute("messagesoluong","không còn sản phẩm");
            return "redirect:/admin/hoadonview/banhang";
        }
        boolean sanphamtontai = false;
        for (SanPhamChiTiet sanPhamChiTiet: spctl){
            if(sanPhamChiTiet.getMaspct().equals(spct.getMaspct())){
                if("increase".equals(action)&&spct.getSoluong()>0){
                    sanPhamChiTiet.setSoluong(sanPhamChiTiet.getSoluong()+1);
                    spct.setSoluong(spct.getSoluong()-1);
                    if(spct.getSoluong()==0){
                        model.addAttribute("messagesoluong","Hết hàng");
                    }
                    sanphamtontai=true;
                }
                else if("decrease".equals(action)&&sanPhamChiTiet.getSoluong()>0){
                    sanPhamChiTiet.setSoluong(sanPhamChiTiet.getSoluong()-1);
                    spct.setSoluong(spct.getSoluong()+1);
                    if(sanPhamChiTiet.getSoluong()==0){
                        spctl.remove(sanPhamChiTiet);
                    }
                    sanphamtontai=true;
                }
                sanPhamChiTietRepo.save(spct);
                break;
            }
        }
        if(!sanphamtontai){
            model.addAttribute("messagesoluong","Sản phẩm không còn trong giỏ hàng");
        }

        session.setAttribute("gioHang",spctl);
        return "redirect:/admin/hoadonview/banhang";
    }
    @PostMapping("/hoadon-giohang")
    public String hoaDonGioHang(HoaDonChiTiet hoaDonChiTiet,Model model){
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
    @PostMapping("/banhang")
    public String addHoaDon(@ModelAttribute HoaDon hoadon, Model model){
        hoaDonIpl.create(hoadon);
        model.addAttribute("messagehd", "Tạo hóa đơn thành công");
        return "redirect:/admin/hoadonview/banhang";
    }
    @GetMapping("/huyhoadon")
    public String huyHoaDon(@RequestParam("id") int id,Model model){
        HoaDon dh = hoaDonIpl.updateHoaDon(id);
        List<HoaDon> listhd = new ArrayList<>();
        listhd.remove(dh);
        HoaDon hoaDon = hoaDonRepo.findById(id).orElse(null);
        if(hoaDon!=null && hoaDon.getTrangthai()==0){
            hoaDon.setTrangthai(1);
            hoaDonRepo.save(hoaDon);
        }
        model.addAttribute("lsthdbh",hoaDonIpl.getLstHoaDonBanHang());
        return "redirect:/admin/hoadonview/banhang";
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
    public int hoaDonHuy(Model model){
        return hoaDonIpl.hoaDonHuy();
    }
}
