-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 11, 2024 at 05:09 PM
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
-- Database: `coursework`
--

-- --------------------------------------------------------

--
-- Table structure for table `assigned_modules`
--

CREATE TABLE `assigned_modules` (
  `Teacher_Name` varchar(50) NOT NULL,
  `Module_1` varchar(50) NOT NULL,
  `Module_2` varchar(50) NOT NULL,
  `Module_3` varchar(50) NOT NULL,
  `Module_4` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `assigned_modules`
--

INSERT INTO `assigned_modules` (`Teacher_Name`, `Module_1`, `Module_2`, `Module_3`, `Module_4`) VALUES
('Rukesh Shrestha', 'Object Oriented Design And Programming', 'Fundamentals of Computing', 'Database', 'JDBC'),
('Rukesh Shrestha', 'Object Oriented Design And Programming', 'Fundamentals of Computing', 'Database', 'JDBC'),
('Aagya Sharma', 'Object Oriented Design And Programming', 'Fundamentals of Computing', 'Database', 'JDBC'),
('Anmol Acharya', 'Internet Software Architecture', 'Database', 'Artificial Intelligence', 'Computational Mathematics'),
('Sujata Thapa', 'Prepare for sucess at University', 'Principle of Business', 'Project Based Learning ', 'The sustainable Business'),
('Junu Hada', 'The Responsible Business', 'The Innovative Business', 'Managing Finance and Accounts', 'The International HR Professtionals'),
('Uttam Acharya', 'Distributed and clound Systems', 'Computer Interaction', 'Numerical methods ', 'Complex Systems');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `Course_id` int(11) NOT NULL,
  `Course_Name` varchar(50) NOT NULL,
  `No_Of_Modules` varchar(50) NOT NULL,
  `Active_Status` varchar(50) NOT NULL,
  `Length` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`Course_id`, `Course_Name`, `No_Of_Modules`, `Active_Status`, `Length`) VALUES
(1, 'BSc Computer Science', '14', 'YES', 3),
(2, 'BSc International Business', '12', 'YES', 4),
(4, 'BBA', '16', 'NO', 4),
(8, 'MBA', '8', 'NO', 2),
(9, 'CSIT', '16', 'NO', 4),
(10, 'BBA', '8', 'YES', 770);

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `student_id` int(11) NOT NULL,
  `Student_Name` varchar(50) NOT NULL,
  `Level` varchar(50) NOT NULL,
  `Module_1` int(11) NOT NULL,
  `Module_2` int(11) NOT NULL,
  `Module_3` int(11) NOT NULL,
  `Module_4` int(11) NOT NULL,
  `Module_5` int(11) NOT NULL,
  `Module_6` int(11) NOT NULL,
  `Module_7` int(11) NOT NULL,
  `Module_8` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`student_id`, `Student_Name`, `Level`, `Module_1`, `Module_2`, `Module_3`, `Module_4`, `Module_5`, `Module_6`, `Module_7`, `Module_8`) VALUES
(2, 'Sahil  Khadka', '4', 70, 82, 85, 87, 90, 82, 85, 90),
(3, 'Unayan Thapa', '5', 69, 70, 45, 89, 80, 87, 85, 83),
(4, 'Rosel Rl Shah', '4', 85, 89, 82, 84, 75, 89, 90, 95),
(5, 'Ayush Pokharel', '6', 62, 67, 50, 45, 80, 72, 74, 67),
(6, 'Jen', '5', 70, 45, 80, 97, 98, 79, 45, 90),
(7, 'Sandhya Niraula', '6', 79, 45, 87, 78, 53, 78, 40, 80),
(8, 'priya', '6', 20, 50, 64, 50, 28, 70, 56, 40),
(9, 'hari', '', 50, 60, 100, 0, 90, 90, 99, 88);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Id` int(11) NOT NULL,
  `Student_Name` varchar(50) NOT NULL,
  `Semester` varchar(50) NOT NULL,
  `Level` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Id`, `Student_Name`, `Semester`, `Level`) VALUES
(2, 'Rosel RL Shah', '2', '4'),
(3, 'Sahil Khadka', '3', '5'),
(5, 'Unayan Thapa', '3', '5'),
(6, 'Jen', '3', '5'),
(7, 'Sandhya NIraula', '5', '6'),
(8, 'Kripa Neupane', '5', '6'),
(9, 'Shashanka Ghimire', '1', '4');

-- --------------------------------------------------------

--
-- Table structure for table `tutor`
--

CREATE TABLE `tutor` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Phone_Number` bigint(20) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Sex` varchar(50) NOT NULL,
  `Module_Assigned` varchar(50) NOT NULL,
  `Date_Of_Birth` date NOT NULL,
  `Full_Time` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tutor`
--

INSERT INTO `tutor` (`Id`, `Name`, `Phone_Number`, `Address`, `Sex`, `Module_Assigned`, `Date_Of_Birth`, `Full_Time`) VALUES
(2, 'Rukesh Shrestha', 98123, 'Bhaktapur', 'Male', 'OODP', '2000-01-02', 'YES'),
(3, 'Aagya Sharma', 98345, 'Sukedhara', 'Female', 'ISA', '2000-02-03', 'NO'),
(4, 'Junu Hada', 98678, 'Lalitpur', 'Female', 'NMC', '2000-03-04', 'NO'),
(5, 'Anmol Acharya', 984123, 'Maharajgunj', 'Male', 'AI', '2000-05-06', 'YES'),
(6, 'Yogesh Shrestha', 98765, 'biruwa', 'Male', 'OODP', '2000-12-12', 'NO'),
(7, 'jesmy', 9876987, 'chabahil', 'Female', 'ISA', '2000-12-10', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `User_Id` int(11) NOT NULL,
  `FullName` text NOT NULL,
  `Sex` varchar(250) NOT NULL,
  `Username` varchar(250) NOT NULL,
  `Password` varchar(250) NOT NULL,
  `Course` varchar(250) NOT NULL,
  `User_Type` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`User_Id`, `FullName`, `Sex`, `Username`, `Password`, `Course`, `User_Type`) VALUES
(1, 'Anushka Upadhyaya', 'Female', 'Anna', 'anna', '', 'Admin'),
(2, 'Rukesh Shrestha', 'Male', 'Rukesh', 'rukesh', 'BIT', 'Teacher'),
(3, 'Rosel shah', 'Female', 'Rosel', 'rosel', 'BIBM', 'Student'),
(4, 'Sujata Thapa', 'Female', 'Sujata', 'sujata', 'BIBM', 'Teacher'),
(6, 'Aagya Sharma', 'Female', 'Aagya', 'aagya', 'BIT', 'Teacher'),
(7, 'Sahil Khadka', 'Male', 'Sahil', 'sahil', 'BIT', 'Student'),
(8, 'kulbhushan', 'Male', 'kul', 'kul2003', 'BIT', ''),
(9, 'kulbhushan', 'Male', 'kul', 'arsenal', 'BIT', 'Teacher'),
(10, 'kul', 'Male', 'kul', 'nepal', 'BIT', 'Admin'),
(11, 'hari', 'Female', 'hari', 'hari', 'BIT', ''),
(12, 'nepal', 'Male', 'nepal', 'nepal', 'BIBM', 'Teacher'),
(13, 'kul', 'Male', 'kul', 'kul', 'BIT', ''),
(14, 'kul', 'Male', 'kul', 'kul', '', ''),
(15, 'krishma', 'Female', 'krishma', 'krishma', 'BIBM', 'Teacher'),
(16, 'krishma', 'Female', 'krishma', 'krishma', '', ''),
(17, 'kul', 'Male', 'kul', 'kul', 'BIT', 'Teacher'),
(18, 'krishma', 'Female', 'krishma', 'krishma', 'BIT', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`Course_id`);

--
-- Indexes for table `marks`
--
ALTER TABLE `marks`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `tutor`
--
ALTER TABLE `tutor`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`User_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `Course_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `marks`
--
ALTER TABLE `marks`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tutor`
--
ALTER TABLE `tutor`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `User_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
