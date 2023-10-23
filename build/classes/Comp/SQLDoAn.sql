create table NhaCungCap
(
	MaNCC				NCHAR(5)					NOT NULL,
	TenNCC				NVARCHAR(10)				NOT NULL,
	DiaChiNCC			NVARCHAR(10),
	SDTNCC				NVARCHAR(10)





	
)
create table Quyen
(
        MaTK				NCHAR(5)					NOT NULL,
        PhanQuyen                       NVARCHAR(20)                                    NOT NULL
)
create table SanPham
(
	MaSP				NCHAR(5)					NOT NULL,
	TenSP				NVARCHAR(20)                                    NOT NULL,
	DonGia				INT						NOT NULL,
	SoLuong 			INT						NOT NULL,
        DuongDanHinhAnh                 NCHAR(100)                                      NOT NULL    
)
create table DoanhThu
(
	MaDoanhThu		NCHAR(5)						NOT NULL,
        TongDoanhThu                    int                   
)

create table TaiKhoan
(
	MaTK				NCHAR(5)					NOT NULL,
	TenDangNhap				NCHAR(5)					NOT NULL,
	MatKhau				NVARCHAR(20)				NOT NULL,
	TrangThai					INT							NOT NULL
)

create table NhanVien
(
	MaNV		NCHAR(5)					NOT NULL,
	TenNV			NVARCHAR(40)				NOT NULL,
        GioiTinh        NVARCHAR(10)                                    NOT NULL,
        DiaChiNV			NVARCHAR(100),
	SDTNV				NVARCHAR(20)
	
)

create table KhachHang
(
	MaKH			NCHAR(5)					NOT NULL,
	TenKH		NVARCHAR(40)				NOT NULL,
	DiaChi				NVARCHAR(10),
	SDT					NVARCHAR(10)
)

create table ChuongTrinhKhuyenMai
(
	MaCTKM                          NCHAR(5)					NOT NULL,
        TenCTKM                         NVARCHAR(100)                                   NOT NULL,
	MucGiamGia			int,
	LoaiSanPhamDuocApDung		NVARCHAR(100)                                 NOT NULL,
        ThoiGianBatDau			NVARCHAR(100)                                    NOT NULL,
	ThoiGianKetThuc			NVARCHAR(100)                         NOT NULL,
        ThoiGianTaoKM                   NVARCHAR(100)                          NOT NULL,
        MaSP				NCHAR(5)					NOT NULL,                                    
        
	
)

create table HoaDon
(
	MaHoaDon			NCHAR(5)					NOT NULL,
	MaKH				NCHAR(5)					NOT NULL,
	MaNV				NCHAR(5)					NOT NULL,
	NgayLap                         datetime,
        NgayXuat                        datetime,
	TongGiaGoc			int                                             NOT NULL,
        TongGiaSauGiam                  int,
        MaDoanhThu		NCHAR(5)						NOT NULL
        
)

create table CTHoaDon
(
	MaHoaDon			NCHAR(5)					NOT NULL,
	MaSP				NCHAR(5)					NOT NULL,
	TenSP				NVARCHAR(40)				NOT NULL,
	SoLuong				int,
	GiaTien				int
)

create table Kho
(
	MaKho			NCHAR(5)						NOT NULL,
	TenKho			NVARCHAR(40)					NOT NULL,
	DiaChiKho		NVARCHAR(10),
	SDTKho			NVARCHAR(10)
)
create table PhieuNhapKho
(
	MaPhieuNhap		NCHAR(5)						NOT NULL,
	MaKho			NCHAR(5)						NOT NULL,
	NgayNhap		datetime                                               NOT NULL,
        NgayNhan                datetime,               
	TongTien		int                                                     NOT NULL,
        Thue                    int
)

create table CTPhieuNhapKho
(
	MaPhieuNhap		NCHAR(5)						NOT NULL,
	MaNCC			NCHAR(5)						NOT NULL,
	SLNhap			int,
	GiaNhap			int
)

create table SanPhamNCC
(
        MaNCC				NCHAR(5)					NOT NULL,
	MaSP				NCHAR(5)					NOT NULL,
        SoLuong                         int                                             NOT NULL,
        DonGia                          int                                             NOT NULL
)



--Thiết lập ràng buộc--
--Khóa chính--
alter table HoaDon
	add constraint PK_HoaDon primary key (MaHoaDon)

alter table NhaCungCap
	add constraint PK_NhaCungCap primary key (MaNCC)

alter table SanPham
	add constraint PK_SanPham primary key (MaSP)

alter table NhanVien
	add constraint PK_NhanVien primary key (MaNV)

alter table KhachHang
	add constraint PK_KhachHang primary key (MaKH)

alter table Kho
	add constraint PK_Kho primary key (MaKho)

alter table PhieuNhapKho
	add constraint PK_PhieuNhapKho primary key(MaPhieuNhap)

alter table ChuongTrinhKhuyenMai
	add constraint PK_ChuongTrinhKhuyenMai primary key(MaCTKM)

alter table TaiKhoan
	add constraint PK_TaiKhoan primary key(MaTK)

alter table DoanhThu
	add constraint PK_DoanhThu primary key(MaDoanhThu)

--Khóa ngoại--
alter table HoaDon
	add constraint FK_MaKhachHang_HoaDon foreign key (MaKH) references KhachHang(MaKH)
alter table HoaDon
        add constraint FK_MaNhanVien_HoaDon foreign key (MaNV) references NhanVien(MaNV)
alter table HoaDon 
        add constraint FK_MaDoanhThu_HoaDon foreign key (MaDoanhThu) references DoanhThu(MaDoanhThu)

alter table SanPhamNCC
        add constraint FK_MaNCC_SanPhamNCC  foreign key (MaNCC)    references NhaCungCap(MaNCC)
alter table SanPhamNCC
        add constraint FK_MaSP_SanPhamNCC   foreign key (MaSP)     references SanPham(MaSP)

alter table CTHoaDon 
	add constraint FK_MaHoaDon_CTHoaDon foreign key (MaHoaDon) references HoaDon(MaHoaDon)
alter table CTHoaDon 
	add constraint FK_MaSP_CTHoaDon foreign key (MaSP) references SanPham(MaSP)


alter table NhanVien
	add constraint FK_MaNV_NhanVien foreign key (MaNV) references TaiKhoan(MaTK)

alter table Quyen   
        add constraint FK_MaTK_Quyen foreign key (MaTK) references TaiKhoan(MaTK)

alter table PhieuNhapKho
	add constraint FK_MaKho_PhieuNhapKho foreign key (MaKho) references Kho(MaKho)

alter table CTPhieuNhapKho
	add constraint FK_MaPhieuNhap_CTPhieuNhapKho foreign key (MaPhieuNhap) references PhieuNhapKho(MaPhieuNhap)
alter table CTPhieuNhapKho
	add constraint FK_MaNCC_CTPhieuNhapKho foreign key (MaNCC) references NhaCungCap(MaNCC)


alter table ChuongTrinhKhuyenMai
	add constraint FK_MaSP_ChuongTrinhKhuyenMai foreign key (MaSP) references SanPham(MaSP)
