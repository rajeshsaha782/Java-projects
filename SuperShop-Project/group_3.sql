-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2017 at 09:33 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `group_3`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminstrator`
--

CREATE TABLE `adminstrator` (
  `AID` varchar(5) NOT NULL,
  `PASS` varchar(5) NOT NULL,
  `NAME` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adminstrator`
--

INSERT INTO `adminstrator` (`AID`, `PASS`, `NAME`) VALUES
('12345', '12345', 'Rajesh'),
('54321', '54321', 'Robi Ullah');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CID` varchar(5) NOT NULL,
  `PASS` varchar(5) NOT NULL,
  `NAME` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CID`, `PASS`, `NAME`) VALUES
('1', '1', 'Efti'),
('2', '2', 'Reza'),
('w', '2', 'Rakib');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `EID` varchar(5) NOT NULL,
  `PASS` varchar(5) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `SALARY` double(10,2) NOT NULL,
  `DESIGNATION` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`EID`, `PASS`, `NAME`, `SALARY`, `DESIGNATION`) VALUES
('1', '1', 'limon', 9500.00, 'Recieptionist'),
('2', '2', 'Efti', 100000.00, 'Casher'),
('3', '2', 'Reza', 50000.00, 'Sells Manager');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `PID` varchar(5) NOT NULL,
  `PNAME` varchar(20) NOT NULL,
  `COMPANY_NAME` varchar(20) NOT NULL,
  `PRICE` double(6,2) NOT NULL,
  `INVENTORY` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`PID`, `PNAME`, `COMPANY_NAME`, `PRICE`, `INVENTORY`) VALUES
('11', 'DEW', 'DEW', 20.00, 50),
('12', 'LUX', 'LUX', 38.00, 20),
('13', 'MOJO', 'MOJO', 16.00, 30),
('14', 'MOJO', 'MOJO', 65.00, 7),
('15', 'FOGG', 'FOGG', 210.00, 25),
('16', 'DOVE', 'DOVE', 50.00, 33);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminstrator`
--
ALTER TABLE `adminstrator`
  ADD PRIMARY KEY (`AID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`PID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
