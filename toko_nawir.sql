-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 05, 2026 at 07:11 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `toko_nawir`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` varchar(10) NOT NULL,
  `nama_brg` varchar(255) NOT NULL,
  `id_kategori` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_brg`, `id_kategori`) VALUES
('BRG0001', 'ABC Klepon', 'KTG002'),
('BRG0002', 'Antangin', 'KTG003'),
('BRG0003', 'Aquaviva', 'KTG002'),
('BRG0004', 'Bodrex', 'KTG003'),
('BRG0005', 'Bumbu Racik Ayam Goreng', 'KTG004'),
('BRG0006', 'Bumbu Racik Nasi Goreng', 'KTG004'),
('BRG0007', 'Bumbu Racik Sayur Sop', 'KTG004'),
('BRG0008', 'Bumbu Racik Tempe Goreng', 'KTG004'),
('BRG0009', 'Bumbu Racik Tumis Kangkung', 'KTG004'),
('BRG0010', 'Ciptadent', 'KTG009'),
('BRG0011', 'Daia', 'KTG005'),
('BRG0012', 'Downy', 'KTG006'),
('BRG0013', 'Fresh', 'KTG007'),
('BRG0014', 'Freshcare', 'KTG003'),
('BRG0015', 'Garam Daun', 'KTG004'),
('BRG0016', 'Gula pasir', 'KTG008'),
('BRG0017', 'Hansaplast', 'KTG003'),
('BRG0018', 'Indomie Goreng', 'KTG001'),
('BRG0019', 'Kalpa', 'KTG001'),
('BRG0020', 'Kecap ABC Botol', 'KTG004'),
('BRG0021', 'Koyo', 'KTG003'),
('BRG0022', 'Mama Lemon', 'KTG010'),
('BRG0023', 'Marjan', 'KTG007'),
('BRG0024', 'Minyak Goreng Baswara', 'KTG008'),
('BRG0025', 'Minyak Kayu Putih', 'KTG003'),
('BRG0026', 'Minyak Telon', 'KTG003'),
('BRG0027', 'Paramex', 'KTG003'),
('BRG0028', 'Pepsodent', 'KTG009'),
('BRG0029', 'Pop Mie', 'KTG001'),
('BRG0030', 'Promag', 'KTG003'),
('BRG0031', 'Rokok Dio 12', 'KTG011'),
('BRG0032', 'Rokok Diplomat 12', 'KTG011'),
('BRG0033', 'Rokok Gudang Garam 12', 'KTG011'),
('BRG0034', 'Rokok Signature 12', 'KTG011'),
('BRG0035', 'Rokok Surya 12', 'KTG011'),
('BRG0036', 'Roma Kelapa', 'KTG001'),
('BRG0037', 'Royco', 'KTG004'),
('BRG0038', 'Sabun Giv batang', 'KTG012'),
('BRG0039', 'Sabun Harmony batang', 'KTG012'),
('BRG0040', 'Salonpas', 'KTG003'),
('BRG0041', 'Sari Gandum', 'KTG001'),
('BRG0042', 'Sarimi', 'KTG001'),
('BRG0043', 'Saus ABC Botol', 'KTG004'),
('BRG0044', 'Sayang', 'KTG005'),
('BRG0045', 'Shampo Lifebuoy', 'KTG013'),
('BRG0046', 'Shampo Pantene', 'KTG013'),
('BRG0047', 'Shampo Rejoice', 'KTG013'),
('BRG0048', 'Shampo Sunsilk', 'KTG013'),
('BRG0049', 'Shampo Zinc', 'KTG013'),
('BRG0050', 'So Klin', 'KTG005'),
('BRG0051', 'Sosis So Nice', 'KTG001'),
('BRG0052', 'Sunlight 5000', 'KTG010'),
('BRG0053', 'Teh Nutu', 'KTG002'),
('BRG0054', 'Teh Tong Ji', 'KTG002'),
('BRG0055', 'Tepung Padi', 'KTG008'),
('BRG0056', 'Tisu Jolly', 'KTG014'),
('BRG0057', 'Tisu Nice', 'KTG014'),
('BRG0058', 'Tolakangin', 'KTG003'),
('BRG0059', 'Barang Fauzan', 'KTG001');

-- --------------------------------------------------------

--
-- Stand-in structure for view `daftar_barang`
-- (See below for the actual view)
--
CREATE TABLE `daftar_barang` (
`id_barang` varchar(10)
,`nama_brg` varchar(255)
,`nama_kategori` varchar(100)
,`satuan` varchar(100)
,`harga_beli` int(8)
,`harga_jual` int(8)
,`stok` int(8) unsigned
);

-- --------------------------------------------------------

--
-- Table structure for table `detail_barang`
--

CREATE TABLE `detail_barang` (
  `id_detail_barang` varchar(10) NOT NULL,
  `id_barang` varchar(10) NOT NULL,
  `satuan` varchar(100) NOT NULL,
  `harga_jual` int(8) NOT NULL,
  `harga_beli` int(8) NOT NULL,
  `stok` int(8) UNSIGNED NOT NULL,
  `status` enum('aktif','tidak aktif') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detail_barang`
--

INSERT INTO `detail_barang` (`id_detail_barang`, `id_barang`, `satuan`, `harga_jual`, `harga_beli`, `stok`, `status`) VALUES
('D0001', 'BRG0001', 'Pack', 20750, 18500, 0, 'aktif'),
('D0002', 'BRG0002', 'Pack', 37500, 32000, 0, 'tidak aktif'),
('D0003', 'BRG0003', 'Pack', 2000, 1500, 0, 'aktif'),
('D0004', 'BRG0004', 'Pack', 96500, 85000, 0, 'aktif'),
('D0005', 'BRG0005', 'Renceng', 1600, 1300, 0, 'aktif'),
('D0006', 'BRG0006', 'Renceng', 1600, 1300, 0, 'aktif'),
('D0007', 'BRG0007', 'Renceng', 1600, 1300, 0, 'aktif'),
('D0008', 'BRG0008', 'Renceng', 1600, 1300, 0, 'aktif'),
('D0009', 'BRG0009', 'Renceng', 1600, 1300, 0, 'aktif'),
('D0010', 'BRG0010', 'Pack', 11500, 10000, 0, 'aktif'),
('D0011', 'BRG0011', 'Dus', 4500, 3800, 0, 'aktif'),
('D0012', 'BRG0012', 'Dus', 4500, 3800, 0, 'aktif'),
('D0013', 'BRG0013', 'Dus', 17000, 15000, 0, 'aktif'),
('D0014', 'BRG0014', 'Pack', 121500, 108000, 0, 'aktif'),
('D0015', 'BRG0015', 'Dus', 2500, 2000, 0, 'aktif'),
('D0016', 'BRG0016', 'Kg', 16500, 15000, 0, 'aktif'),
('D0017', 'BRG0017', 'Pack', 28500, 25000, 0, 'aktif'),
('D0018', 'BRG0018', 'Dus', 112800, 101000, 0, 'aktif'),
('D0019', 'BRG0019', 'Pack', 21500, 19000, 0, 'aktif'),
('D0020', 'BRG0020', 'Dus', 6500, 5500, 0, 'aktif'),
('D0021', 'BRG0021', 'Pack', 205500, 180000, 0, 'aktif'),
('D0022', 'BRG0022', 'Dus', 3500, 3000, 0, 'aktif'),
('D0023', 'BRG0023', 'Dus', 19500, 17000, 0, 'aktif'),
('D0024', 'BRG0024', 'Botol', 14500, 13000, 0, 'aktif'),
('D0025', 'BRG0025', 'Pack', 63000, 55000, 0, 'aktif'),
('D0026', 'BRG0026', 'Botol', 31500, 28000, 0, 'aktif'),
('D0027', 'BRG0027', 'Pack', 109500, 98000, 0, 'aktif'),
('D0028', 'BRG0028', 'Pack', 8750, 7500, 0, 'aktif'),
('D0029', 'BRG0029', 'Dus', 135500, 122000, 0, 'aktif'),
('D0030', 'BRG0030', 'Pack', 89500, 80000, 0, 'aktif'),
('D0031', 'BRG0031', 'Pack', 9000, 8500, 0, 'aktif'),
('D0032', 'BRG0032', 'Pack', 24600, 24000, 0, 'aktif'),
('D0033', 'BRG0033', 'Pack', 15450, 14900, 0, 'aktif'),
('D0034', 'BRG0034', 'Pack', 24850, 24200, 0, 'aktif'),
('D0035', 'BRG0035', 'Pack', 25100, 24500, 0, 'aktif'),
('D0036', 'BRG0036', 'Pack', 57500, 50000, 0, 'aktif'),
('D0037', 'BRG0037', 'Renceng', 500, 400, 0, 'aktif'),
('D0038', 'BRG0038', 'Dus', 2200, 1800, 0, 'aktif'),
('D0039', 'BRG0039', 'Dus', 2250, 1900, 0, 'aktif'),
('D0040', 'BRG0040', 'Pack', 83500, 75000, 0, 'aktif'),
('D0041', 'BRG0041', 'Pack', 20000, 17500, 0, 'aktif'),
('D0042', 'BRG0042', 'Dus', 103800, 93000, 0, 'aktif'),
('D0043', 'BRG0043', 'Dus', 10000, 8500, 0, 'aktif'),
('D0044', 'BRG0044', 'Dus', 10500, 9000, 0, 'aktif'),
('D0045', 'BRG0045', 'Renceng', 9500, 8500, 0, 'aktif'),
('D0046', 'BRG0046', 'Renceng', 9500, 8500, 0, 'aktif'),
('D0047', 'BRG0047', 'Renceng', 9500, 8500, 0, 'aktif'),
('D0048', 'BRG0048', 'Renceng', 9500, 8500, 0, 'aktif'),
('D0049', 'BRG0049', 'Renceng', 9500, 8500, 0, 'aktif'),
('D0050', 'BRG0050', 'Dus', 9000, 8000, 0, 'aktif'),
('D0051', 'BRG0051', 'Toples', 19000, 16000, 0, 'aktif'),
('D0052', 'BRG0052', 'Dus', 4500, 4000, 0, 'aktif'),
('D0053', 'BRG0053', 'Pack', 2500, 2000, 0, 'aktif'),
('D0054', 'BRG0054', 'Pack', 6250, 5000, 0, 'aktif'),
('D0055', 'BRG0055', 'Satuan', 3000, 2500, 0, 'aktif'),
('D0056', 'BRG0056', 'Pack', 7500, 6500, 0, 'aktif'),
('D0057', 'BRG0057', 'Pack', 7000, 6000, 0, 'aktif'),
('D0058', 'BRG0058', 'Pack', 43500, 39000, 0, 'aktif'),
('D0059', 'BRG0001', 'pcs', 1500, 1250, 0, 'aktif');

-- --------------------------------------------------------

--
-- Table structure for table `detail_pembelian`
--

CREATE TABLE `detail_pembelian` (
  `id_detail_beli` varchar(25) NOT NULL,
  `id_beli` varchar(25) NOT NULL,
  `id_detail_brg` varchar(10) NOT NULL,
  `qty` int(8) NOT NULL,
  `harga` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detail_pembelian`
--

INSERT INTO `detail_pembelian` (`id_detail_beli`, `id_beli`, `id_detail_brg`, `qty`, `harga`) VALUES
('DTBL-20260102-0001-001', 'TBL-20260102-0001', 'D0001', 100, 18500);

--
-- Triggers `detail_pembelian`
--
DELIMITER $$
CREATE TRIGGER `trg_hapus_pembelian_kurangi_stok` AFTER DELETE ON `detail_pembelian` FOR EACH ROW BEGIN
    UPDATE detail_barang 
    SET stok = stok - OLD.qty
    WHERE id_detail_barang = OLD.id_detail_brg;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trg_tambah_stok_pembelian` AFTER INSERT ON `detail_pembelian` FOR EACH ROW BEGIN
    UPDATE detail_barang 
    SET stok = stok + NEW.qty
    WHERE id_detail_barang = NEW.id_detail_brg;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trg_update_pembelian` AFTER UPDATE ON `detail_pembelian` FOR EACH ROW BEGIN
	UPDATE detail_barang 
	SET stok = stok + (NEW.qty - OLD.qty)
	WHERE id_detail_barang = NEW.id_detail_brg;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `detail_penjualan`
--

CREATE TABLE `detail_penjualan` (
  `id_detail_jual` varchar(25) NOT NULL,
  `id_jual` varchar(25) NOT NULL,
  `id_detail_brg` varchar(10) NOT NULL,
  `qty` int(8) NOT NULL,
  `harga` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detail_penjualan`
--

INSERT INTO `detail_penjualan` (`id_detail_jual`, `id_jual`, `id_detail_brg`, `qty`, `harga`) VALUES
('DTJL-20260104-0001-001', 'TJL-20260104-0001', 'D0001', 10, 20750),
('DTJL-20260104-0001-002', 'TJL-20260104-0001', 'D0003', 5, 2000),
('DTJL-20260104-0001-003', 'TJL-20260104-0001', 'D0059', 7, 1500);

--
-- Triggers `detail_penjualan`
--
DELIMITER $$
CREATE TRIGGER `trg_hapus_penjualan_kembalikan_stok` AFTER DELETE ON `detail_penjualan` FOR EACH ROW BEGIN
    UPDATE detail_barang 
    SET stok = stok + OLD.qty
    WHERE id_detail_barang = OLD.id_detail_brg;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trg_kurang_stok_penjualan` AFTER INSERT ON `detail_penjualan` FOR EACH ROW BEGIN
    UPDATE detail_barang 
    SET stok = stok - NEW.qty
    WHERE id_detail_barang = NEW.id_detail_brg;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trg_update_penjualan` AFTER UPDATE ON `detail_penjualan` FOR EACH ROW BEGIN
	UPDATE detail_barang 
    SET stok = stok + (OLD.qty - NEW.qty)
    WHERE id_detail_barang = NEW.id_detail_brg;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` varchar(10) NOT NULL,
  `nama_kategori` varchar(100) NOT NULL,
  `status` enum('aktif','tidak aktif') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`, `status`) VALUES
('KTG001', 'Makanan', 'aktif'),
('KTG002', 'Minuman', 'aktif'),
('KTG003', 'Obat-obatan', 'aktif'),
('KTG004', 'Bumbu Masakan', 'aktif'),
('KTG005', 'Sabun Cuci Baju', 'aktif'),
('KTG006', 'Pewangi Pakaian', 'aktif'),
('KTG007', 'Sirup', 'aktif'),
('KTG008', 'Bahan Pokok', 'aktif'),
('KTG009', 'Pasta Gigi', 'aktif'),
('KTG010', 'Sabun Cuci Piring', 'aktif'),
('KTG011', 'Rokok', 'aktif'),
('KTG012', 'Sabun Mandi', 'aktif'),
('KTG013', 'Shampo', 'aktif'),
('KTG014', 'Tisu', 'aktif');

-- --------------------------------------------------------

--
-- Stand-in structure for view `laporan_detail_pembelian`
-- (See below for the actual view)
--
CREATE TABLE `laporan_detail_pembelian` (
`id_beli` varchar(25)
,`tanggal` datetime
,`id_detail_beli` varchar(25)
,`id_detail_brg` varchar(10)
,`nama_brg` varchar(255)
,`qty` int(8)
,`harga` int(12)
,`total_harga_barang` bigint(22)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `laporan_detail_penjualan`
-- (See below for the actual view)
--
CREATE TABLE `laporan_detail_penjualan` (
`id_jual` varchar(25)
,`tanggal` datetime
,`id_detail_jual` varchar(25)
,`id_detail_barang` varchar(10)
,`nama_brg` varchar(255)
,`qty` int(8)
,`harga` int(12)
,`total_harga_barang` bigint(22)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `laporan_pembelian`
-- (See below for the actual view)
--
CREATE TABLE `laporan_pembelian` (
`id_beli` varchar(25)
,`tanggal` datetime
,`nama_suppl` varchar(50)
,`total_harga_barang` decimal(43,0)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `laporan_penjualan`
-- (See below for the actual view)
--
CREATE TABLE `laporan_penjualan` (
`id_jual` varchar(25)
,`tanggal` datetime
,`total_harga_barang` decimal(43,0)
,`uang_diterima` int(11)
,`uang_kembalian` decimal(44,0)
);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` varchar(10) NOT NULL,
  `nama_suppl` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `telepon` varchar(20) NOT NULL,
  `status` enum('aktif','tidak aktif') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `nama_suppl`, `alamat`, `telepon`, `status`) VALUES
('SUP0001', 'PT. Indomarco Adi Prima', 'Jl.Raya Tegal Sari Gg. Gagak, Batang, Proyonanggan Tengah, Kec. Kandeman, Kabupaten Batang, Jawa Tengah 51216', '085729910365', 'aktif'),
('SUP0002', 'John Doe ', 'Jakarta', '1234567890', 'aktif');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_pembelian`
--

CREATE TABLE `transaksi_pembelian` (
  `id_beli` varchar(25) NOT NULL,
  `id_suppl` varchar(10) NOT NULL,
  `tanggal` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi_pembelian`
--

INSERT INTO `transaksi_pembelian` (`id_beli`, `id_suppl`, `tanggal`) VALUES
('TBL-20260102-0001', 'SUP0001', '2026-01-02 13:13:54');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_penjualan`
--

CREATE TABLE `transaksi_penjualan` (
  `id_jual` varchar(25) NOT NULL,
  `tanggal` datetime NOT NULL,
  `uang_diterima` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi_penjualan`
--

INSERT INTO `transaksi_penjualan` (`id_jual`, `tanggal`, `uang_diterima`) VALUES
('TJL-20260104-0001', '2026-01-04 07:05:59', 230000);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` varchar(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `username` varchar(75) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('pemilik','kasir') NOT NULL,
  `status` enum('aktif','tidak aktif') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `nama`, `username`, `password`, `role`, `status`) VALUES
('USR0001', 'Default Toko Anwar (rootAdmin)', 'rootAdmin', '63a9f0ea7bb98050796b649e85481845', 'pemilik', 'aktif'),
('USR0002', 'Default Toko Anwar (rootKasir)', 'rootKasir', '63a9f0ea7bb98050796b649e85481845', 'kasir', 'aktif'),
('USR0003', 'Fauzan Priatmana', 'fawzanp', 'e64b78fc3bc91bcbc7dc232ba8ec59e0', 'pemilik', 'aktif'),
('USR0004', 'Muhammad Ichsan', 'nashci', 'e64b78fc3bc91bcbc7dc232ba8ec59e0', 'pemilik', 'aktif'),
('USR0005', 'Hamam Zul Fahmi', 'fahmi', 'e64b78fc3bc91bcbc7dc232ba8ec59e0', 'kasir', 'aktif'),
('USR0006', 'Nadhifatunnizza', 'nadin', 'e64b78fc3bc91bcbc7dc232ba8ec59e0', 'kasir', 'aktif'),
('USR0007', 'Imel Aimanda Bregawati', 'aimanda', 'e64b78fc3bc91bcbc7dc232ba8ec59e0', 'kasir', 'aktif');

-- --------------------------------------------------------

--
-- Structure for view `daftar_barang`
--
DROP TABLE IF EXISTS `daftar_barang`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `daftar_barang`  AS SELECT `barang`.`id_barang` AS `id_barang`, `barang`.`nama_brg` AS `nama_brg`, `kategori`.`nama_kategori` AS `nama_kategori`, `detail_barang`.`satuan` AS `satuan`, `detail_barang`.`harga_beli` AS `harga_beli`, `detail_barang`.`harga_jual` AS `harga_jual`, `detail_barang`.`stok` AS `stok` FROM ((`barang` join `kategori` on(`barang`.`id_kategori` = `kategori`.`id_kategori`)) join `detail_barang` on(`barang`.`id_barang` = `detail_barang`.`id_barang`)) ORDER BY `barang`.`nama_brg` ASC ;

-- --------------------------------------------------------

--
-- Structure for view `laporan_detail_pembelian`
--
DROP TABLE IF EXISTS `laporan_detail_pembelian`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `laporan_detail_pembelian`  AS SELECT `transaksi_pembelian`.`id_beli` AS `id_beli`, `transaksi_pembelian`.`tanggal` AS `tanggal`, `detail_pembelian`.`id_detail_beli` AS `id_detail_beli`, `detail_pembelian`.`id_detail_brg` AS `id_detail_brg`, `barang`.`nama_brg` AS `nama_brg`, `detail_pembelian`.`qty` AS `qty`, `detail_pembelian`.`harga` AS `harga`, `detail_pembelian`.`qty`* `detail_pembelian`.`harga` AS `total_harga_barang` FROM (((`transaksi_pembelian` join `detail_pembelian` on(`transaksi_pembelian`.`id_beli` = `detail_pembelian`.`id_beli`)) join `detail_barang` on(`detail_pembelian`.`id_detail_brg` = `detail_barang`.`id_detail_barang`)) join `barang` on(`detail_barang`.`id_barang` = `barang`.`id_barang`)) ORDER BY `transaksi_pembelian`.`tanggal` DESC ;

-- --------------------------------------------------------

--
-- Structure for view `laporan_detail_penjualan`
--
DROP TABLE IF EXISTS `laporan_detail_penjualan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `laporan_detail_penjualan`  AS SELECT `detail_penjualan`.`id_jual` AS `id_jual`, `transaksi_penjualan`.`tanggal` AS `tanggal`, `detail_penjualan`.`id_detail_jual` AS `id_detail_jual`, `detail_barang`.`id_detail_barang` AS `id_detail_barang`, `barang`.`nama_brg` AS `nama_brg`, `detail_penjualan`.`qty` AS `qty`, `detail_penjualan`.`harga` AS `harga`, `detail_penjualan`.`qty`* `detail_penjualan`.`harga` AS `total_harga_barang` FROM (((`detail_penjualan` join `transaksi_penjualan` on(`detail_penjualan`.`id_jual` = `transaksi_penjualan`.`id_jual`)) join `detail_barang` on(`detail_penjualan`.`id_detail_brg` = `detail_barang`.`id_detail_barang`)) join `barang` on(`detail_barang`.`id_barang` = `barang`.`id_barang`)) ORDER BY `transaksi_penjualan`.`tanggal` DESC ;

-- --------------------------------------------------------

--
-- Structure for view `laporan_pembelian`
--
DROP TABLE IF EXISTS `laporan_pembelian`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `laporan_pembelian`  AS SELECT `transaksi_pembelian`.`id_beli` AS `id_beli`, `transaksi_pembelian`.`tanggal` AS `tanggal`, `supplier`.`nama_suppl` AS `nama_suppl`, sum(`detail_pembelian`.`qty` * `detail_pembelian`.`harga`) AS `total_harga_barang` FROM ((`transaksi_pembelian` left join `detail_pembelian` on(`transaksi_pembelian`.`id_beli` = `detail_pembelian`.`id_beli`)) left join `supplier` on(`transaksi_pembelian`.`id_suppl` = `supplier`.`id_supplier`)) GROUP BY `transaksi_pembelian`.`id_beli` ORDER BY `transaksi_pembelian`.`tanggal` DESC ;

-- --------------------------------------------------------

--
-- Structure for view `laporan_penjualan`
--
DROP TABLE IF EXISTS `laporan_penjualan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `laporan_penjualan`  AS SELECT `transaksi_penjualan`.`id_jual` AS `id_jual`, `transaksi_penjualan`.`tanggal` AS `tanggal`, sum(`detail_penjualan`.`qty` * `detail_penjualan`.`harga`) AS `total_harga_barang`, `transaksi_penjualan`.`uang_diterima` AS `uang_diterima`, `transaksi_penjualan`.`uang_diterima`- sum(`detail_penjualan`.`qty` * `detail_penjualan`.`harga`) AS `uang_kembalian` FROM (`transaksi_penjualan` left join `detail_penjualan` on(`transaksi_penjualan`.`id_jual` = `detail_penjualan`.`id_jual`)) GROUP BY `transaksi_penjualan`.`id_jual` ORDER BY `transaksi_penjualan`.`tanggal` DESC ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`),
  ADD KEY `id_kategori` (`id_kategori`);

--
-- Indexes for table `detail_barang`
--
ALTER TABLE `detail_barang`
  ADD PRIMARY KEY (`id_detail_barang`),
  ADD KEY `id_barang` (`id_barang`);

--
-- Indexes for table `detail_pembelian`
--
ALTER TABLE `detail_pembelian`
  ADD PRIMARY KEY (`id_detail_beli`),
  ADD KEY `kd_brg` (`id_detail_brg`) USING BTREE,
  ADD KEY `id_beli` (`id_beli`);

--
-- Indexes for table `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  ADD PRIMARY KEY (`id_detail_jual`),
  ADD KEY `kd_jual` (`id_jual`),
  ADD KEY `kd_brg` (`id_detail_brg`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- Indexes for table `transaksi_pembelian`
--
ALTER TABLE `transaksi_pembelian`
  ADD PRIMARY KEY (`id_beli`),
  ADD KEY `kd_suppl` (`id_suppl`);

--
-- Indexes for table `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  ADD PRIMARY KEY (`id_jual`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`);

--
-- Constraints for table `detail_barang`
--
ALTER TABLE `detail_barang`
  ADD CONSTRAINT `detail_barang_ibfk_1` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`);

--
-- Constraints for table `detail_pembelian`
--
ALTER TABLE `detail_pembelian`
  ADD CONSTRAINT `detail_pembelian_ibfk_1` FOREIGN KEY (`id_beli`) REFERENCES `transaksi_pembelian` (`id_beli`),
  ADD CONSTRAINT `detail_pembelian_ibfk_2` FOREIGN KEY (`id_detail_brg`) REFERENCES `detail_barang` (`id_detail_barang`);

--
-- Constraints for table `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  ADD CONSTRAINT `detail_penjualan_ibfk_1` FOREIGN KEY (`id_jual`) REFERENCES `transaksi_penjualan` (`id_jual`),
  ADD CONSTRAINT `detail_penjualan_ibfk_2` FOREIGN KEY (`id_detail_brg`) REFERENCES `detail_barang` (`id_detail_barang`);

--
-- Constraints for table `transaksi_pembelian`
--
ALTER TABLE `transaksi_pembelian`
  ADD CONSTRAINT `transaksi_pembelian_ibfk_1` FOREIGN KEY (`id_suppl`) REFERENCES `supplier` (`id_supplier`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
