USE [QLCH]
GO
/****** Object:  Table [dbo].[ChuongTrinhKhuyenMai]    Script Date: 10/4/2023 10:21:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChuongTrinhKhuyenMai](
	[MaCTKM] [nchar](5) NOT NULL,
	[TenCTKM] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_ChuongTrinhKhuyenMai] PRIMARY KEY CLUSTERED 
(
	[MaCTKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTChuongTrinhKhuyenMai]    Script Date: 10/4/2023 10:21:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTChuongTrinhKhuyenMai](
	[MaPhieuXuat] [nchar](5) NOT NULL,
	[MaCTKM] [nchar](5) NOT NULL,
	[MucGiamGia] [int] NULL,
	[LoaiSanPhamDuocApDung] [nvarchar](100) NULL,
	[ThoiGianApDung] [nvarchar](100) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTHoaDon]    Script Date: 10/4/2023 10:21:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTHoaDon](
	[MaPhieuXuat] [nchar](5) NOT NULL,
	[MaHoaDon] [nchar](5) NOT NULL,
	[SoLuong] [int] NULL,
	[GiaTien] [money] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTPhieuNhapKho]    Script Date: 10/4/2023 10:21:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTPhieuNhapKho](
	[MaPhieuNhap] [nchar](5) NOT NULL,
	[MaNCC] [nchar](5) NOT NULL,
	[SLNhap] [int] NULL,
	[GiaNhap] [money] NULL,
	[TamTinh] [money] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTPhieuXuat]    Script Date: 10/4/2023 10:21:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTPhieuXuat](
	[MaPhieuXuat] [nchar](5) NOT NULL,
	[MaSP] [nchar](5) NOT NULL,
	[SoLuong] [int] NULL,
	[DonGia] [money] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DoanhThu]    Script Date: 10/4/2023 10:21:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DoanhThu](
	[MaDoanhThu] [nchar](5) NOT NULL,
	[TongDoanhThu] [money] NULL,
 CONSTRAINT [PK_DoanhThu] PRIMARY KEY CLUSTERED 
(
	[MaDoanhThu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 10/4/2023 10:21:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHoaDon] [nchar](5) NOT NULL,
	[MaKH] [nchar](5) NOT NULL,
	[MaNV] [nchar](5) NOT NULL,
	[MaDoanhThu] [nchar](5) NOT NULL,
	[NgayBanHang] [datetime] NULL,
	[TongGiaTri] [money] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 10/4/2023 10:21:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nchar](5) NOT NULL,
	[TenKH] [nvarchar](40) NOT NULL,
	[DiaChi] [nvarchar](10) NULL,
	[SDT] [nvarchar](10) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Kho]    Script Date: 10/4/2023 10:21:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Kho](
	[MaKho] [nchar](5) NOT NULL,
	[TenKho] [nvarchar](40) NOT NULL,
	[DiaChiKho] [nvarchar](10) NULL,
	[SDTKho] [nvarchar](10) NULL,
 CONSTRAINT [PK_Kho] PRIMARY KEY CLUSTERED 
(
	[MaKho] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 10/4/2023 10:21:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [nchar](5) NOT NULL,
	[TenNCC] [nvarchar](10) NOT NULL,
	[DiaChiNCC] [nvarchar](10) NULL,
	[SDTNCC] [nvarchar](10) NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 10/4/2023 10:21:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nchar](5) NOT NULL,
	[TenNV] [nvarchar](40) NOT NULL,
	[SDTNV] [nvarchar](20) NULL,
	[DiaChiNV] [nvarchar](10) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhapKho]    Script Date: 10/4/2023 10:21:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhapKho](
	[MaPhieuNhap] [nchar](5) NOT NULL,
	[MaKho] [nchar](5) NOT NULL,
	[NgayNhap] [nchar](10) NULL,
	[TongTien] [money] NULL,
	[Thue] [int] NULL,
 CONSTRAINT [PK_PhieuNhapKho] PRIMARY KEY CLUSTERED 
(
	[MaPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuXuat]    Script Date: 10/4/2023 10:21:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuXuat](
	[MaPhieuXuat] [nchar](5) NOT NULL,
	[NgayNhap] [datetime] NULL,
	[TamTinh] [money] NULL,
 CONSTRAINT [PK_PhieuXuat] PRIMARY KEY CLUSTERED 
(
	[MaPhieuXuat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 10/4/2023 10:21:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [nchar](5) NOT NULL,
	[MaKho] [nchar](5) NOT NULL,
	[TenSP] [nvarchar](20) NOT NULL,
	[DonGia] [money] NOT NULL,
	[SL] [int] NOT NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 10/4/2023 10:21:36 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[MaTK] [nchar](5) NOT NULL,
	[TenDangNhap] [nchar](5) NOT NULL,
	[MatKhau] [nvarchar](20) NOT NULL,
	[Quyen] [int] NOT NULL,
	[TrangThai] [int] NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[MaTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CTHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_MaHoaDon_CTHoaDon] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[HoaDon] ([MaHoaDon])
GO
ALTER TABLE [dbo].[CTHoaDon] CHECK CONSTRAINT [FK_MaHoaDon_CTHoaDon]
GO
ALTER TABLE [dbo].[CTHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_MaPhieuXuat_CTHoaDon] FOREIGN KEY([MaPhieuXuat])
REFERENCES [dbo].[PhieuXuat] ([MaPhieuXuat])
GO
ALTER TABLE [dbo].[CTHoaDon] CHECK CONSTRAINT [FK_MaPhieuXuat_CTHoaDon]
GO
ALTER TABLE [dbo].[CTPhieuNhapKho]  WITH CHECK ADD  CONSTRAINT [FK_MaNCC_PhieuNhapKho] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[PhieuNhapKho] ([MaPhieuNhap])
GO
ALTER TABLE [dbo].[CTPhieuNhapKho] CHECK CONSTRAINT [FK_MaNCC_PhieuNhapKho]
GO
ALTER TABLE [dbo].[CTPhieuNhapKho]  WITH CHECK ADD  CONSTRAINT [FK_MaPhieuNhap_CTPhieuNhapKho] FOREIGN KEY([MaPhieuNhap])
REFERENCES [dbo].[Kho] ([MaKho])
GO
ALTER TABLE [dbo].[CTPhieuNhapKho] CHECK CONSTRAINT [FK_MaPhieuNhap_CTPhieuNhapKho]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_MaDoanhThu_HoaDon] FOREIGN KEY([MaDoanhThu])
REFERENCES [dbo].[DoanhThu] ([MaDoanhThu])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_MaDoanhThu_HoaDon]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_MaKhachHang_HoaDon] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_MaKhachHang_HoaDon]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_MaNhanVien_HoaDon] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_MaNhanVien_HoaDon]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_MaNV_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[TaiKhoan] ([MaTK])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_MaNV_NhanVien]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [FK_MaKho_SanPham] FOREIGN KEY([MaKho])
REFERENCES [dbo].[Kho] ([MaKho])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [FK_MaKho_SanPham]
GO

insert into PhieuNhapKho values('p01', 'k01', '29/3/2003', 30000, 5);
insert into PhieuNhapKho values('p02','k01', '7/10/2003', 9865320, 8);
insert into PhieuNhapKho values('p03', 'k01', '25/10/2007', 30000, 15);
insert into PhieuNhapKho values('p04', 'k01', '30/4/1975', 30000, 50);
insert into PhieuNhapKho values('p05', 'k01', '28/8/2655', 30000, 9);

select * from PhieuNhapKho;