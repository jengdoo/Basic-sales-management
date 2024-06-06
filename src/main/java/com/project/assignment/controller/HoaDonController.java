package com.project.assignment.controller;

import com.project.assignment.model.*;
import com.project.assignment.reponsitory.*;
import com.project.assignment.service.HoaDonChiTietSevice;
import com.project.assignment.service.implement.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    private final HoaDonChiTietRepo hoaDonChiTietRepo;
    private final HoaDonChiTietIpl hoaDonChiTietIpl;
    @Autowired
    HttpSession session;

    @GetMapping("/hoadon")
    public String getHoaDon(@RequestParam(name = "p",defaultValue = "0") int p,Model model){
        model.addAttribute("lsthd",hoaDonIpl.getAllHD(p));
        return "admin/hoadonview/hoadon";
    }
    @GetMapping("/banhang")
   public String toIndex(@RequestParam(value = "p", defaultValue = "0") int page, Model model) {
        List<SanPhamChiTiet> gioHang = (List<SanPhamChiTiet>) session.getAttribute("gioHang");
        if (gioHang == null) {
            gioHang = new ArrayList<>();
        }
        model.addAttribute("gioHang", gioHang);
        model.addAttribute("lstspct",sanPhamChiTietEpl.getAllSPCT(page));
        model.addAttribute("lsthdbh",hoaDonIpl.getLstHoaDonBanHang());
        return "admin/hoadonview/banhang";
    }
    @GetMapping("/muahang")
    public String addSanPham(@RequestParam("id") Integer id,Model model,@Param("tienKhachDua") Double tienKhachDua){
        SanPhamChiTiet sanPhamChiTiets = sanPhamChiTietEpl.getByID(id);
        if(sanPhamChiTiets==null|| sanPhamChiTiets.getSoluong()<=0){
            model.addAttribute("messagesoluong","sản phẩm đã hết");
            return "redirect:/admin/hoadonview/banhang";
        }
        List<SanPhamChiTiet> gioHang = (List<SanPhamChiTiet>) session.getAttribute("gioHang");
        if (gioHang == null) {
            gioHang = new ArrayList<>();
        }
        HoaDonChiTiet hoadonchitiet = (HoaDonChiTiet) session.getAttribute("hoadonchitiet");
        if (hoadonchitiet == null) {
            hoadonchitiet = new HoaDonChiTiet();
        }
        boolean sanPhamTonTai = false;
        for (SanPhamChiTiet spct : gioHang) {
            if (spct.getMaspct().equals(sanPhamChiTiets.getMaspct())) {
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
        if(sanPhamChiTiets.getSoluong()<=0){
            sanPhamChiTiets.setTrangthai(false);
        }
        sanPhamChiTietRepo.save(sanPhamChiTiets);
        int tongSoLuong = 0;
        double tongGia = 0.0;

        for (SanPhamChiTiet spct : gioHang) {
            int soluong = spct.getSoluong();
            double gia = spct.getDongia();

            tongSoLuong += soluong;
            tongGia += soluong * gia;
        }
        tienKhachDua =0.0;
        double tienthua = tienKhachDua-tongGia;
        hoadonchitiet.setSoluong(tongSoLuong);
        hoadonchitiet.setDongia(tongGia);
        model.addAttribute("tongSoLuong", tongSoLuong);
        model.addAttribute("tongGia", tongGia);
        model.addAttribute("tienThua",tienthua);
        session.setAttribute("gioHang", gioHang);
        session.setAttribute("hoadonchitiet", hoadonchitiet);
        return "redirect:/admin/hoadonview/banhang";
    }
    @PostMapping("/muaSPCT")
    public String muaTheoSPCT(@ModelAttribute("hoadonchitiet") HoaDonChiTiet hoaDonChiTiet, @RequestParam("tienKhachDua") Double tienKhachDua, Model model){
        List<SanPhamChiTiet> gioHang = (List<SanPhamChiTiet>) session.getAttribute("gioHang");
        HoaDonChiTiet hoadonchitiet = (HoaDonChiTiet) session.getAttribute("hoadonchitiet");
        if (hoadonchitiet == null) {
            hoadonchitiet = new HoaDonChiTiet();
        }
        if (gioHang == null) {
            gioHang = new ArrayList<>();
        }
        List<HoaDonChiTiet> hoaDonChiTiets = new ArrayList<>();
        for (SanPhamChiTiet productDetail : gioHang) {
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setSpct(productDetail);
            hdct.setDongia(productDetail.getDongia());
            hdct.setSoluong(productDetail.getSoluong());
            hoaDonChiTiets.add(hoaDonChiTiet);
        }
        int tongSoLuong = 0;
        double tongGia = 0.0;
        for (SanPhamChiTiet spct : gioHang) {
            tongSoLuong += spct.getSoluong();
            tongGia += spct.getSoluong() * spct.getDongia();
        }
        double tienThua = tienKhachDua - tongGia;


        if (tienThua < 0) {
            model.addAttribute("errorMessage", "Số tiền khách đưa không đủ để thanh toán hóa đơn.");
            return "admin/hoadonview/banhang";
        }

        for (HoaDonChiTiet hdcts : hoaDonChiTiets) {
            if(hdcts.getHoadon().getTrangthai()==0){
                hdcts.setTrangthai(2);
                hoaDonChiTietIpl.thanhToanHoaDon(hdcts);
            }
        }

        session.removeAttribute("hoadonchitiet");
        session.removeAttribute("gioHang");

        model.addAttribute("hoaDonChiTiet", hoaDonChiTiet);
        model.addAttribute("tienThua", tienThua);
        return "redirect:/admin/hoadonview/banhang";
    }
    @GetMapping("/thanhtoan")
    public String thanhToanHoaDon( @RequestParam("id") Integer id) {
//        List<SanPhamChiTiet> gioHang = (List<SanPhamChiTiet>) session.getAttribute("gioHang");
//        HoaDonChiTiet hoadonchitiet = (HoaDonChiTiet) session.getAttribute("hoadonchitiet");
//        if (hoadonchitiet == null) {
//            hoadonchitiet = new HoaDonChiTiet();
//        }
//        if (gioHang == null) {
//            gioHang = new ArrayList<>();
//        }
//        List<HoaDonChiTiet> hoaDonChiTiets = new ArrayList<>();
//        for (SanPhamChiTiet productDetail : gioHang) {
//            HoaDonChiTiet hdct = new HoaDonChiTiet();
//            hdct.setSpct(productDetail);
//            hdct.setDongia(productDetail.getDongia());
//            hdct.setSoluong(productDetail.getSoluong());
//            hoaDonChiTiets.add(hoaDonChiTiet);
//        }
//        int tongSoLuong = 0;
//        double tongGia = 0.0;
//        for (SanPhamChiTiet spct : gioHang) {
//            tongSoLuong += spct.getSoluong();
//            tongGia += spct.getSoluong() * spct.getDongia();
//        }
//        double tienThua = tienKhachDua - tongGia;
//
//
//        if (tienThua < 0) {
//            model.addAttribute("errorMessage", "Số tiền khách đưa không đủ để thanh toán hóa đơn.");
//            return "admin/hoadonview/banhang";
//        }
        session.removeAttribute("hoadonchitiet");
        session.removeAttribute("gioHang");
        for (HoaDonChiTiet hdcts : hoaDonChiTietRepo.findHoaDonChiTietByHoadonId(id)) {
            if(hdcts.getHoadon().getTrangthai()==0){
                hdcts.getHoadon().setTrangthai(2);
                hdcts.setTrangthai(2);
                hoaDonChiTietIpl.thanhToanHoaDon(hdcts);
            }
        }

//        model.addAttribute("hoaDonChiTiet", hoaDonChiTiet);
//        model.addAttribute("tienThua", tienThua);
        return "redirect:/admin/hoadonview/banhang";
    }
    @GetMapping("/updategiohang")
    public String soLuongGioHang(@RequestParam("id") Integer id, @RequestParam("action") String action, Model model,@RequestParam(name = "p",defaultValue = "0") int page) {
        SanPhamChiTiet spct = sanPhamChiTietEpl.getByID(id);
        List<SanPhamChiTiet> spctl = (List<SanPhamChiTiet>) session.getAttribute("gioHang");
        if (spctl == null || spctl.isEmpty()) {
            model.addAttribute("messagesoluong", "Không còn sản phẩm trong giỏ hàng");
            return "redirect:/admin/hoadonview/banhang";
        }

        Object hoadonchitietObj = session.getAttribute("hoadonchitiet");
        if (hoadonchitietObj instanceof HoaDonChiTiet) {
            HoaDonChiTiet hoadonchitiet = (HoaDonChiTiet) hoadonchitietObj;

            int tongSoLuong = 0;
            double tongGia = 0.0;
            boolean sanphamtontai = false;

            for (SanPhamChiTiet sanPhamChiTiet : spctl) {
                if (sanPhamChiTiet.getMaspct().equals(spct.getMaspct())) {
                    if ("increase".equals(action) && spct.getSoluong() > 0) {
                        sanPhamChiTiet.setSoluong(sanPhamChiTiet.getSoluong() + 1);
                        spct.setSoluong(spct.getSoluong() - 1);
                        if (spct.getSoluong() == 0) {
                            model.addAttribute("messagesoluong", "Hết hàng");
                        }
                        if (hoadonchitiet.getSoluong() == 0) {
                            model.addAttribute("messagehoadon", "Hết hàng");
                        }

                        // Tính lại tổng số lượng và tổng giá
                        for (SanPhamChiTiet sp : spctl) {
                            int soluong = sp.getSoluong();
                            double gia = sp.getDongia();

                            tongSoLuong += soluong;
                            tongGia += soluong * gia;
                        }
                        double tienKhachDua = 0.0;
                        double tienthua = tienKhachDua - tongGia;
                        hoadonchitiet.setSoluong(tongSoLuong);
                        hoadonchitiet.setDongia(tongGia);
                        model.addAttribute("tienKhachDua", tienKhachDua);
                        model.addAttribute("tongSoLuong", tongSoLuong);
                        model.addAttribute("tongGia", tongGia);
                        model.addAttribute("tienThua", tienthua);
                        sanphamtontai = true;
                    } else if ("decrease".equals(action) && sanPhamChiTiet.getSoluong() > 0) {
                        sanPhamChiTiet.setSoluong(sanPhamChiTiet.getSoluong() - 1);
                        spct.setSoluong(spct.getSoluong() + 1);
                        if (sanPhamChiTiet.getSoluong() == 0) {
                            spctl.remove(sanPhamChiTiet);
                        }
                        for (SanPhamChiTiet spd : spctl){
                            int soluong = spd.getSoluong();
                            double gia = spd.getDongia();

                            tongSoLuong = soluong;
                            tongGia = soluong * gia;
                        }
                        double tienKhachDua = 0.0;
                        double tienthua = tienKhachDua - tongGia;
                        hoadonchitiet.setSoluong(tongSoLuong);
                        hoadonchitiet.setDongia(tongGia);
                        model.addAttribute("tienKhachDua", tienKhachDua);
                        model.addAttribute("tongSoLuong", tongSoLuong);
                        model.addAttribute("tongGia", tongGia);
                        model.addAttribute("tienThua", tienthua);
                        sanphamtontai = true;
                    }
                    sanPhamChiTietRepo.save(spct);
                    break;
                }
            }

            if (!sanphamtontai) {
                model.addAttribute("messagesoluong", "Sản phẩm không còn trong giỏ hàng");
            }
        } else {
            model.addAttribute("messagesoluong", "Không còn sản phẩm trong giỏ hàng");
            return "redirect:/admin/hoadonview/banhang";
        }

        session.setAttribute("gioHang", spctl);
        model.addAttribute("lstspct",sanPhamChiTietEpl.getAllSPCT(page));
        return "forward:/admin/hoadonview/banhang";
    }
    @PostMapping("/hoadon-giohang")
    public String hoaDonGioHang(HoaDonChiTiet hoaDonChiTiet,Model model){
        return "redirect:/admin/hoadonview/banhang";
    }
    @PostMapping("/taoHD")
    public String addHoaDon(HoaDon hoadon,
                            Model model){
        hoaDonIpl.create(hoadon);
        model.addAttribute("messagehd", "Tạo hóa đơn thành công");
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
        if(hoaDon!=null && hoaDon.getTrangthai()==0){
            hoaDon.setTrangthai(1);
            hoaDonRepo.save(hoaDon);
        }
        model.addAttribute("lsthdbh",hoaDonIpl.getLstHoaDonBanHang());
        return "redirect:/admin/hoadonview/banhang";
    }
//    @GetMapping("/choosegiohang/{id}")
//    public String getChooseGioHang(@PathVariable("id") Integer id,Model model,@RequestParam(name = "p",defaultValue = "0")int page){
//        model.addAttribute("spctChoose",sanPhamChiTietEpl.getByID(id));
//        model.addAttribute("lstspct",sanPhamChiTietEpl.getAllSPCT(page));
//        return "forward:/admin/hoadonview/banhang";
//    }
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
