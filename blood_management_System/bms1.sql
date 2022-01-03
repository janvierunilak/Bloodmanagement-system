-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 03, 2022 at 05:52 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bms1`
--

-- --------------------------------------------------------

--
-- Table structure for table `bloodbank`
--
CREATE DATABASE bms1;
use bms1;
CREATE TABLE `bloodbank` (
  `bloodbank_id` int(10) NOT NULL,
  `bloodbank_name` varchar(50) NOT NULL,
  `bloodbank_address` varchar(50) NOT NULL,
  `bloodbank_phone` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bloodbank`
--

INSERT INTO `bloodbank` (`bloodbank_id`, `bloodbank_name`, `bloodbank_address`, `bloodbank_phone`) VALUES
(1, 'bb', 'kabuye', NULL),
(2, 'mm', 'rurenge', '0877666666'),
(3, 'ka', 'karu', '07883'),
(4, 'Mr.Eager', 'CHUK', '0789729209');

-- --------------------------------------------------------

--
-- Table structure for table `bloodstock`
--

CREATE TABLE `bloodstock` (
  `bloodstock_id` int(10) NOT NULL,
  `bloodstock_name` varchar(50) NOT NULL,
  `bloodgroup` char(2) DEFAULT NULL,
  `ExpirationDate` varchar(20) DEFAULT NULL,
  `quantity` varchar(10) DEFAULT NULL,
  `bloodbankId` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `delivery`
--

CREATE TABLE `delivery` (
  `delivery_id` int(10) NOT NULL,
  `hospital` int(10) DEFAULT NULL,
  `driver_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `donnation_request`
--

CREATE TABLE `donnation_request` (
  `Id` int(10) NOT NULL,
  `donnorId` int(10) DEFAULT NULL,
  `place` varchar(50) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `status` varchar(30) DEFAULT 'Pending'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donnation_request`
--

INSERT INTO `donnation_request` (`Id`, `donnorId`, `place`, `date`, `status`) VALUES
(2, 30, 'Kacyiru', '2021-10-28', 'Approved'),
(3, 30, 'Kacyiru', '2021-10-30', 'Denied'),
(4, 30, 'Kacyiru', '2021-11-04', 'Approved'),
(5, 30, 'Kacyiru', '2021-11-06', 'Denied'),
(6, 30, 'Kacyiru', '2021-11-17', 'Denied'),
(7, 30, 'Kacyiru', '2021-11-30', 'Approved'),
(8, 30, 'Kacyiru', '2022-01-08', 'Approved'),
(9, 30, 'Kacyiru', '2021-12-29', 'Approved'),
(11, 32, 'Kacyiru', '2021-12-29', 'Denied');

-- --------------------------------------------------------

--
-- Table structure for table `donor`
--

CREATE TABLE `donor` (
  `donor_id` int(10) NOT NULL,
  `donor_name` varchar(50) DEFAULT NULL,
  `blood_group` char(2) DEFAULT NULL,
  `donation_date` timestamp(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE current_timestamp(6),
  `address` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `hospital_id` int(10) NOT NULL,
  `hospital_name` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hospital`
--

INSERT INTO `hospital` (`hospital_id`, `hospital_name`, `address`) VALUES
(1, 'mugisha', 'remera'),
(2, 'k', 'kabuga'),
(4, 'janvier', 'Kabarondo');

-- --------------------------------------------------------

--
-- Table structure for table `seeker`
--

CREATE TABLE `seeker` (
  `seeker_id` int(10) NOT NULL,
  `seeker_name` varchar(30) DEFAULT NULL,
  `seeker_age` varchar(10) DEFAULT NULL,
  `bloodgroup` char(2) DEFAULT NULL,
  `City` varchar(20) DEFAULT NULL,
  `hospital` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Id` int(11) NOT NULL,
  `Firstname` varchar(50) DEFAULT NULL,
  `Lastname` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `salt` varchar(50) NOT NULL,
  `user_type` varchar(30) NOT NULL DEFAULT 'normal_user'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Id`, `Firstname`, `Lastname`, `Email`, `phone`, `Username`, `Password`, `salt`, `user_type`) VALUES
(9, 'mugisha', 'muhire', 'mugisha@gmail.com', '0788483456', 'mugisha', 'mugisha', '', 'Hospital'),
(10, 'kaka', 'kaka', 'kaka@gmail.com', '0726203933', 'kaka', 'kaka', '', 'BloodBank'),
(12, 'kaka', 'kaka', 'koka@gmail.com', '0788483477', 'koka', 'koka', '', 'BloodBank'),
(13, 'Karangwa', 'Christophe', 'karangwa@gmail.com', '0788924568', 'Karangwachris', 'chriss', '', 'BloodBank'),
(14, 'karake', 'ferdinand', 'karake@gmail.com', '0788345661', 'karake', 'karake', '', 'BloodBank'),
(15, 'k', 'k', 'k@gmail.com', '0726202911', 'k', 'k', '', 'Hospital'),
(16, 'bb', 'baba', 'baba@gmail.com', '47904994307493', 'babab', 'babbabababa', '', 'BloodBank'),
(17, 'khkllsdf', 'jidshjsh', 'jsdhkksdkf', '32567', 'sdhsdsd', 'klhdfhldf', '', 'Hospital'),
(18, 'jyplh', 'jkhllvhklhsgd', 'jkgsdffds', '567890-', 'oidfsiyoyf', 'oiufupgs', '', 'Deliverer'),
(19, 'b', 'b', 'b', '456789', 'bb', 'bb', '', 'Bloodbank'),
(20, 'mm', 'mm', 'mm@gmail.com', '0877666666', 'mm', 'mmm', '', 'Bloodbank'),
(21, 'janvier', 'janvier', 'janvier@gmail.com', '0726203911', 'janvier', 'janvier', '', 'Hospital'),
(23, 'ka', 'ka', 'ka@gmail.com', '07883', 'ka', 'ka', '', 'Bloodbank'),
(24, 'jj', 'jj', 'jj@gmail.com', '0877', 'jj', 'jj', '', 'Deliverer'),
(25, 'jjj', 'jjj', 'jjj@gmail.com', '0988', 'jjj', 'jjj', '', 'BloodStock'),
(26, 'gg', 'gg', 'gg@gmail.com', '7886', 'gg', 'ZdvOJPmfoiVJXi4LTMLCg+RFDKPL3Pqblvfr7UWtyRU=', '', 'Normal_user'),
(27, 'dd', 'dd', 'dd@gmail.com', '988', 'dd', 'yE1/ckjDGM9vyB6h2m7LF4rFaOX1/6T14R+7iDHpteA=', 'avvlX057O3a2VMadIZaRTWnLgv9Ulw', 'Normal_user'),
(28, 'First name', 'Last name', 'myname@gmail.com', '0789684903', 'myname', 'DWYc6TlfhFLZUeC5VvePv6r6+zmTOQXYhRvLFo8F1C4=', '1x1uIWIBgzLwsELM5QGKD7gdtMbWqI', 'Normal_user'),
(29, 'rugamba', 'rugamba', 'ruga@gmail.com', '0788483455', 'africa', 'q7i3DsyMGXL7mv+ct+HuFOclhRuOk4R3pV4YYwGQPEs=', 'e4V4BlOXw8SQ61h3s3DoAvooDPQjQG', 'Deliverer'),
(30, 'africa', 'africa', 'africa@gmail.com', '0788345522', 'europe', 'Ssc1U4UpGpP5tQHXy3QXWCw06CfB/qSblMFBQC0IAMo=', 'avlMVl6JVBu0RyAPIjnya9VYn49y5P', 'Normal_user'),
(31, 'kwizera', 'claude', 'claude@gmail.com', '0789729209', 'Mr.Eager', 'LftQrneY0t8TBkxGGEni/2d7HJUtWRRV+LXBGTxuVfk=', '7v0oCSLz3NBgmHl66qoCEEN3MkK9VX', 'Bloodbank'),
(32, 'john', 'direceur', 'john@gmail.com', '0788483455', 'kigali', '1/RkximIg+r86d1GQFTGsOOceXcUnZEODxenH3X6D+M=', 'r8SLcAqYz7Rup0Bo0kAmvQAUhFMBn6', 'Normal_user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bloodbank`
--
ALTER TABLE `bloodbank`
  ADD PRIMARY KEY (`bloodbank_id`),
  ADD KEY `bloodbank_name` (`bloodbank_name`);

--
-- Indexes for table `bloodstock`
--
ALTER TABLE `bloodstock`
  ADD PRIMARY KEY (`bloodstock_id`),
  ADD KEY `bloodbankId` (`bloodbankId`);

--
-- Indexes for table `delivery`
--
ALTER TABLE `delivery`
  ADD PRIMARY KEY (`delivery_id`),
  ADD KEY `hospital` (`hospital`),
  ADD KEY `driver_name` (`driver_name`);

--
-- Indexes for table `donnation_request`
--
ALTER TABLE `donnation_request`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `donnorId` (`donnorId`);

--
-- Indexes for table `donor`
--
ALTER TABLE `donor`
  ADD PRIMARY KEY (`donor_id`),
  ADD KEY `donor_name` (`donor_name`);

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`hospital_id`),
  ADD KEY `hospital_name` (`hospital_name`);

--
-- Indexes for table `seeker`
--
ALTER TABLE `seeker`
  ADD PRIMARY KEY (`seeker_id`),
  ADD KEY `hospital` (`hospital`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Id`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bloodbank`
--
ALTER TABLE `bloodbank`
  MODIFY `bloodbank_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `bloodstock`
--
ALTER TABLE `bloodstock`
  MODIFY `bloodstock_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `delivery`
--
ALTER TABLE `delivery`
  MODIFY `delivery_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `donnation_request`
--
ALTER TABLE `donnation_request`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `donor`
--
ALTER TABLE `donor`
  MODIFY `donor_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `hospital_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `seeker`
--
ALTER TABLE `seeker`
  MODIFY `seeker_id` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bloodbank`
--
ALTER TABLE `bloodbank`
  ADD CONSTRAINT `bloodbank_ibfk_1` FOREIGN KEY (`bloodbank_name`) REFERENCES `users` (`Username`);

--
-- Constraints for table `bloodstock`
--
ALTER TABLE `bloodstock`
  ADD CONSTRAINT `bloodstock_ibfk_1` FOREIGN KEY (`bloodbankId`) REFERENCES `bloodbank` (`bloodbank_id`);

--
-- Constraints for table `delivery`
--
ALTER TABLE `delivery`
  ADD CONSTRAINT `delivery_ibfk_1` FOREIGN KEY (`hospital`) REFERENCES `hospital` (`hospital_id`),
  ADD CONSTRAINT `delivery_ibfk_2` FOREIGN KEY (`driver_name`) REFERENCES `users` (`Username`);

--
-- Constraints for table `donnation_request`
--
ALTER TABLE `donnation_request`
  ADD CONSTRAINT `donnation_request_ibfk_1` FOREIGN KEY (`donnorId`) REFERENCES `users` (`Id`);

--
-- Constraints for table `donor`
--
ALTER TABLE `donor`
  ADD CONSTRAINT `donor_ibfk_1` FOREIGN KEY (`donor_name`) REFERENCES `users` (`Username`);

--
-- Constraints for table `hospital`
--
ALTER TABLE `hospital`
  ADD CONSTRAINT `hospital_ibfk_1` FOREIGN KEY (`hospital_name`) REFERENCES `users` (`Username`);

--
-- Constraints for table `seeker`
--
ALTER TABLE `seeker`
  ADD CONSTRAINT `seeker_ibfk_1` FOREIGN KEY (`hospital`) REFERENCES `hospital` (`hospital_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
