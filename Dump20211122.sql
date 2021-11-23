-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: inventario
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cat001_usuario`
--

DROP TABLE IF EXISTS `cat001_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cat001_usuario` (
  `USUARI_ID` int NOT NULL AUTO_INCREMENT,
  `USUARI_NOMBRE` varchar(45) DEFAULT NULL,
  `USUARI_NIDENTIFIACION` varchar(45) DEFAULT NULL,
  `USUARI_TPIDENTIFICACION` int DEFAULT NULL,
  `USUARI_NVL` int DEFAULT '2',
  `USUARI_CONTRASEÑA` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`USUARI_ID`),
  KEY `USUARIO_IDENTIFICAION_idx` (`USUARI_TPIDENTIFICACION`),
  CONSTRAINT `USUARIO_IDENTIFICAION` FOREIGN KEY (`USUARI_TPIDENTIFICACION`) REFERENCES `cat002_identificacion` (`IDENTI_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat001_usuario`
--

LOCK TABLES `cat001_usuario` WRITE;
/*!40000 ALTER TABLE `cat001_usuario` DISABLE KEYS */;
INSERT INTO `cat001_usuario` VALUES (1,'administrador','1007379176',1,1,'1234'),(2,'empleado1','1001315604',2,2,'34552'),(3,'empleado2','1000349634',1,2,'9874'),(4,'empleado3','1008612134',3,2,'45678'),(5,'empleado4','1008574891',1,2,'54684');
/*!40000 ALTER TABLE `cat001_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat002_identificacion`
--

DROP TABLE IF EXISTS `cat002_identificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cat002_identificacion` (
  `IDENTI_ID` int NOT NULL AUTO_INCREMENT,
  `IDENTI_NOMBRE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IDENTI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat002_identificacion`
--

LOCK TABLES `cat002_identificacion` WRITE;
/*!40000 ALTER TABLE `cat002_identificacion` DISABLE KEYS */;
INSERT INTO `cat002_identificacion` VALUES (1,'cedula'),(2,'tarjet de identidad'),(3,'nit'),(4,'pasaporte');
/*!40000 ALTER TABLE `cat002_identificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inv001_inventario`
--

DROP TABLE IF EXISTS `inv001_inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inv001_inventario` (
  `INVENT_ID` int NOT NULL AUTO_INCREMENT,
  `INVENT_NOMBRE` varchar(45) DEFAULT NULL,
  `INVENT_PRODUCTO` int DEFAULT NULL,
  `INVENT_USUARIO` int DEFAULT NULL,
  PRIMARY KEY (`INVENT_ID`),
  KEY `INVENTARIO_USUARIO_idx` (`INVENT_USUARIO`),
  KEY `INVENTARIO_PRODUCTO_idx` (`INVENT_PRODUCTO`),
  CONSTRAINT `INVENTARIO_PRODUCTO` FOREIGN KEY (`INVENT_PRODUCTO`) REFERENCES `inv002_producto` (`PRODUC_ID`),
  CONSTRAINT `INVENTARIO_USUARIO` FOREIGN KEY (`INVENT_USUARIO`) REFERENCES `cat001_usuario` (`USUARI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inv001_inventario`
--

LOCK TABLES `inv001_inventario` WRITE;
/*!40000 ALTER TABLE `inv001_inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inv001_inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inv002_producto`
--

DROP TABLE IF EXISTS `inv002_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inv002_producto` (
  `PRODUC_ID` int NOT NULL AUTO_INCREMENT,
  `PRODUC_NOMBRE` varchar(45) DEFAULT NULL,
  `PRODUC_CANTIDAD` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PRODUC_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inv002_producto`
--

LOCK TABLES `inv002_producto` WRITE;
/*!40000 ALTER TABLE `inv002_producto` DISABLE KEYS */;
INSERT INTO `inv002_producto` VALUES (1,'gominola','1230'),(2,'superRicas','12312'),(3,'Chocorramo','123'),(4,'pan bimbo','1000');
/*!40000 ALTER TABLE `inv002_producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-22 19:10:48
