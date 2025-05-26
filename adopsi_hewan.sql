-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: adopsi_hewan
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adopsi`
--

DROP TABLE IF EXISTS `adopsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adopsi` (
  `id_adopsi` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `id_hewan` int(11) DEFAULT NULL,
  `tanggal_ajuan` date NOT NULL,
  `status` enum('proses','diterima','ditolak') NOT NULL,
  `catatan` text DEFAULT NULL,
  PRIMARY KEY (`id_adopsi`),
  KEY `id_user` (`id_user`),
  KEY `id_hewan` (`id_hewan`),
  CONSTRAINT `adopsi_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE,
  CONSTRAINT `adopsi_ibfk_2` FOREIGN KEY (`id_hewan`) REFERENCES `hewan` (`id_hewan`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adopsi`
--

LOCK TABLES `adopsi` WRITE;
/*!40000 ALTER TABLE `adopsi` DISABLE KEYS */;
/*!40000 ALTER TABLE `adopsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hewan`
--

DROP TABLE IF EXISTS `hewan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hewan` (
  `id_hewan` int(11) NOT NULL AUTO_INCREMENT,
  `nama_hewan` varchar(100) NOT NULL,
  `jenis` varchar(50) NOT NULL,
  `umur` int(11) NOT NULL,
  `kelamin` enum('jantan','betina') NOT NULL,
  `deskripsi` text DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `status` enum('tersedia','diadopsi','proses') NOT NULL,
  PRIMARY KEY (`id_hewan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hewan`
--

LOCK TABLES `hewan` WRITE;
/*!40000 ALTER TABLE `hewan` DISABLE KEYS */;
/*!40000 ALTER TABLE `hewan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riwayat_adopsi`
--

DROP TABLE IF EXISTS `riwayat_adopsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riwayat_adopsi` (
  `id_riwayat` int(11) NOT NULL AUTO_INCREMENT,
  `id_adopsi` int(11) DEFAULT NULL,
  `tanggal_update` datetime DEFAULT current_timestamp(),
  `status` enum('proses','diterima','ditolak') DEFAULT NULL,
  PRIMARY KEY (`id_riwayat`),
  KEY `id_adopsi` (`id_adopsi`),
  CONSTRAINT `riwayat_adopsi_ibfk_1` FOREIGN KEY (`id_adopsi`) REFERENCES `adopsi` (`id_adopsi`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riwayat_adopsi`
--

LOCK TABLES `riwayat_adopsi` WRITE;
/*!40000 ALTER TABLE `riwayat_adopsi` DISABLE KEYS */;
/*!40000 ALTER TABLE `riwayat_adopsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `alamat` text DEFAULT NULL,
  `no_hp` varchar(20) DEFAULT NULL,
  `role` enum('user','admin') NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-25 14:53:18
