create database QLCH
use master
create table NhaCungCap
(
	MaNCC				NCHAR(5)					NOT NULL,
	TenNCC				NVARCHAR(10)				NOT NULL,
	DiaChiNCC			NVARCHAR(10),
	SDTNCC				NVARCHAR(10)
)

create table SanPham
(
	MaSP				NCHAR(5)					NOT NULL,
	MaKho				NCHAR(5)					NOT NULL,
	TenSP				NVARCHAR(20)				NOT NULL,
	DonGia				MONEY						NOT NULL,
	SL 					INT							NOT NULL
)
create table DoanhThu
(
	MaDoanhThu		NCHAR(5)						NOT NULL,
	TongDoanhThu			money
)
create table TaiKhoan
(
	MaTK				NCHAR(5)					NOT NULL,
	TenDangNhap				NCHAR(5)					NOT NULL,
	MatKhau				NVARCHAR(20)				NOT NULL,
	Quyen				NVARCHAR(20)						NOT NULL,
	TrangThai					NVARCHAR(20)							NOT NULL
)

create table NhanVien
(
	MaNV		NCHAR(5)					NOT NULL,
	TenNV			NVARCHAR(40)				NOT NULL,
	SDTNV				NVARCHAR(20),
	DiaChiNV			NVARCHAR(10)
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
	MaCTKM			NCHAR(5)					NOT NULL,
	TenCTKM				NVARCHAR(100)				NOT NULL,
	
)
create table CTChuongTrinhKhuyenMai
(
	MaPhieuXuat				NCHAR(5)					NOT NULL,
	MaCTKM			NCHAR(5)					NOT NULL,
	MucGiamGia				int,
	LoaiSanPhamDuocApDung				NVARCHAR(100),
	ThoiGianApDung				NVARCHAR(100)
	
)

create table HoaDon
(
	MaHoaDon			NCHAR(5)					NOT NULL,
	MaKH		NCHAR(5)					NOT NULL,
	MaNV			NCHAR(5)					NOT NULL,
	MaDoanhThu			NCHAR(5)						NOT NULL,
	NgayBanHang			datetime,
	TongGiaTri			money
)

create table CTHoaDon
(
	MaPhieuXuat				NCHAR(5)					NOT NULL,
	MaHoaDon			NCHAR(5)					NOT NULL,
	SoLuong				int,
	GiaTien				money
)

create table Kho
(
	MaKho			NCHAR(5)						NOT NULL,
	TenKho			NVARCHAR(40)					NOT NULL,
	DiaChiKho		NVARCHAR(10),
	SDTKho			NVARCHAR(10)
)
create table PhieuXuat
(
	MaPhieuXuat		NCHAR(5)						NOT NULL,
	NgayNhap		datetime,
	TamTinh		money
)
create table CTPhieuXuat
(
	MaPhieuXuat		NCHAR(5)						NOT NULL,
	MaSP			NCHAR(5)						NOT NULL,
	SoLuong			int,
	DonGia			money
)
create table PhieuNhapKho
(
	MaPhieuNhap		NCHAR(5)						NOT NULL,
	MaNCC			NCHAR(5)						NOT NULL,
	NgayNhap		datetime,
	TongGiaTri		money
)

create table CTPhieuNhapKho
(
	MaPhieuNhap		NCHAR(5)						NOT NULL,
	MaKho			NCHAR(5)						NOT NULL,
	SLNhap			int,
	GiaNhap			money
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

alter table PhieuXuat
	add constraint PK_PhieuXuat primary key(MaPhieuXuat)

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

alter table CTHoaDon 
	add constraint FK_MaHoaDon_CTHoaDon foreign key (MaHoaDon) references HoaDon(MaHoaDon)
alter table CTHoaDon 
	add constraint FK_MaPhieuXuat_CTHoaDon foreign key (MaPhieuXuat) references PhieuXuat(MaPhieuXuat)


alter table NhanVien
	add constraint FK_MaNV_NhanVien foreign key (MaNV) references TaiKhoan(MaTK)

alter table SanPham
	add constraint FK_MaKho_SanPham foreign key (MaKho) references Kho(MaKho)

alter table PhieuNhapKho
	add constraint FK_MaNCC_PhieuNhapKho foreign key (MaNCC) references NhaCungCap(MaNCC)

alter table CTPhieuNhapKho
	add constraint FK_MaPhieuNhap_CTPhieuNhapKho foreign key (MaPhieuNhap) references PhieuNhapKho(MaPhieuNhap)
alter table CTPhieuNhapKho
	add constraint FK_MaKho_CTPhieuNhapKho foreign key (MaKho) references Kho(MaKho)

alter table CTPhieuXuat
	add constraint FK_MaPhieuXuat_CTPhieuXuat foreign key (MaPhieuXuat) references PhieuXuat(MaPhieuXuat)
alter table CTPhieuXuat	
	add constraint FK_MaSP_CTPhieuXuat foreign key (MaSP) references SanPham(MaSP)

alter table CTChuongTrinhKhuyenMai
	add constraint FK_MaCTKM_CTChuongTrinhKhuyenMai foreign key (MaCTKM) references ChuongTrinhKhuyenMai(MaCTKM)
alter table CTChuongTrinhKhuyenMai
	add constraint FK_MaPhieuXuat_CTChuongTrinhKhuyenMai foreign key (MaPhieuXuat) references PhieuXuat(MaPhieuXuat)

