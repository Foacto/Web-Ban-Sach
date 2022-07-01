-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 14, 2022 lúc 11:31 AM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `db_sach`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `bill_id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `date` datetime NOT NULL,
  `phone_number` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `delivery_address` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `payment_status` int(5) NOT NULL,
  `bill_status` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `bill`
--

INSERT INTO `bill` (`bill_id`, `user_id`, `total`, `date`, `phone_number`, `delivery_address`, `payment_status`, `bill_status`) VALUES
(1, 4, 230000, '2020-06-10 17:00:00', '', '', 16, 0),
(2, 3, 370000, '2020-07-01 14:03:44', '', '', 1, 0),
(3, 2, 140000, '2021-07-01 14:06:21', '', '', 1, 0),
(4, 1, 390000, '2021-07-01 14:24:27', '', '', 0, 1),
(7, 10, 100000, '2022-06-12 17:49:02', '', '', 1, 0),
(8, 10, 100000, '2022-06-12 17:54:26', '', '', 1, 0),
(9, 10, 1450000, '2022-06-13 18:53:38', '', '', 1, 1),
(10, 10, 1650000, '2022-06-13 18:57:04', '', '', 1, 1),
(11, 10, 100000, '2022-06-13 18:57:43', '', '', 0, 0),
(12, 10, 320000, '2022-06-14 09:30:48', '0358785476', '213 ÄÆ°á»ng váº¡n xuÃ¢n, xÃ£ háº¡ má»', 0, 0),
(13, 10, 170000, '2022-06-14 09:32:12', '0358785476', '213 ÄÆ°á»ng váº¡n xuÃ¢n, xÃ£ háº¡ má»', 0, 0),
(14, 10, 50000, '2022-06-14 09:34:05', '0358785476', '213 ÄÆ°á»ng váº¡n xuÃ¢n, xÃ£ háº¡ má»', 0, 0),
(16, 10, 50000, '2022-06-14 09:35:41', '0358785476', '213 đường vạn xuân, xã hạ mỗ', 1, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill_detail`
--

CREATE TABLE `bill_detail` (
  `bill_detail_id` bigint(20) NOT NULL,
  `bill_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `bill_detail`
--

INSERT INTO `bill_detail` (`bill_detail_id`, `bill_id`, `product_id`, `price`, `quantity`) VALUES
(1, 1, 1, 50000, 1),
(2, 1, 2, 120000, 1),
(3, 1, 3, 60000, 1),
(4, 2, 4, 100000, 1),
(5, 2, 5, 200000, 1),
(6, 2, 6, 70000, 1),
(7, 3, 7, 140000, 1),
(8, 4, 8, 80000, 1),
(9, 4, 9, 150000, 1),
(10, 4, 10, 160000, 1),
(11, 8, 1, 50000, 2),
(12, 9, 2, 120000, 3),
(13, 9, 1, 50000, 6),
(14, 9, 3, 60000, 2),
(15, 9, 5, 200000, 3),
(16, 9, 6, 70000, 1),
(17, 10, 2, 120000, 3),
(18, 10, 1, 50000, 6),
(19, 10, 3, 60000, 2),
(20, 10, 5, 200000, 4),
(21, 10, 6, 70000, 1),
(22, 11, 1, 50000, 2),
(23, 12, 1, 50000, 4),
(24, 12, 2, 120000, 1),
(25, 13, 1, 50000, 1),
(26, 13, 2, 120000, 1),
(27, 14, 1, 50000, 1),
(28, 15, 1, 50000, 1),
(29, 16, 1, 50000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `id` int(50) NOT NULL,
  `user_id` int(50) NOT NULL,
  `product_id` int(50) NOT NULL,
  `quantity` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `cart`
--

INSERT INTO `cart` (`id`, `user_id`, `product_id`, `quantity`) VALUES
(4, 9, 3, 2),
(17, 10, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
(1, 'Khoa học'),
(2, 'Tâm lý'),
(3, 'Văn học'),
(4, 'Kinh tế');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `product_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_image` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_price` double DEFAULT NULL,
  `product_description` longtext COLLATE utf8_unicode_ci DEFAULT NULL,
  `sell_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`product_id`, `category_id`, `product_name`, `product_image`, `product_price`, `product_description`, `sell_id`) VALUES
(1, 2, '27 Bài học tự cổ vũ bản thân', '1.png', 50000, 'Cuốn sách \"27 Bài Học Tự Cổ Vũ Bản Thân\" là cuốn sách giúp những bậc phụ huynh hướng con mình trở thành thiên tài. Cuốn sách này cung cấp rất nhiều trò chơi tương tác liên quan tới “khích lệ”, giúp trẻ có được sự tự tin trong học tập cũng như trong cuộc sống, đồng thời cũng nắm bắt được nhiều cơ hội thành công.', 1),
(2, 3, 'Overlord Vol.1', '2.jpg', 120000, 'Chuyện xảy ra vào năm 2138, thời đại công nghệ thực tế ảo phát triển đến đỉnh cao, giúp người chơi game trải nghiệm thế giới ảo theo một cách chân thực nhất...', 3),
(3, 2, '27 Bài học về tinh thần lạc quan', '3.png', 60000, 'Dành tặng những bạn nhỏ muốn trở thành thiên tài: Ở trường, cho dù là trong lúc nghe giảng, thi cử, làm bài tập hay quan hệ với bạn bè… lúc nào bạn cũng có thể gặp những chuyện không vui. Nhưng bạn đừng buồn, bởi vì ai cũng có thể gặp phải vấn đề tương tự như thế! Hãy \"đương đầu\" với khó khăn bằng tâm trạng lạc quan, vui vẻ, đừng vì buồn bã mà không muốn đi học nữa, bạn nhé! Dành tặng những bậc phụ huynh muốn con mình trở thành thiên tài: Những cô bé, cậu bé đang trong độ tuổi đến trường thường gặp rất nhiều chuyện không vui khiến chúng cảm thấy buồn bã, chán nản, thậm chí còn ghét phải đi học. Bố mẹ nên chủ động quan tâm đến con cái, để chúng luôn giữ được tâm trạng vui vẻ, hướng dẫn chúng đối diện vấn đề với thái độ lạc quan, tích cực. Cuốn sách này cung cấp rất nhiều trò chơi tương tác liên quan tới “lạc quan”, giúp trẻ cảm nhận được niềm vui trong học tập cũng như trong cuộc sống, đồng thời cũng nắm bắt được nhiều cơ hội thành công.', 2),
(4, 1, '100 bí ẩn đáng kinh ngạc về vũ trụ', '4.jpg', 100000, 'Gồm 4 chủ đề: Cơ thể, Khoa học, Vũ trụ và Thức ăn, bộ sách \"100 bí ẩn đáng kinh ngạc\" là bộ sách khoa học điển hình với những kiến thức chính xác và cô đọng dành cho trẻ.', 1),
(5, 4, 'Marketing căn bản', '5.jpg', 200000, 'Với những hướng dẫn tỉ mỉ và những bảng tính dễ sử dụng, \"Marketing căn bản\" mang đến một cái nhìn thực tế về marketing và hỗ trợ tất cả những ai muốn tăng doanh thu, lợi nhuận, đồng tiền và RIO của doanh nghiệp mình. Dưới sự hướng dẫn của Don Sexton, bạn sẽ tự mình khám phá những chiến lược kinh doanh hiệu quả cũng như làm chủ chúng để tăng doanh thu, lợi nhuận, xây dựng thương hiệu và niềm tin của khách hàng.', 4),
(6, 3, 'Your Name', '6.png', 70000, 'Your Name. là câu chuyện nổi tiếng và đạt được nhiều kỉ lục ở cả hai bản phim và truyện, xoay quanh một thiếu niên và một thiếu nữ hoán đổi linh hồn với nhau, sống dậy ở môi trường hoàn toàn khác biệt và tự thích ứng theo bản năng. Sự hoán đổi đó không đơn thuần để đem đến trạng thái hòa hợp về tình cảm, kể lại một chuyện tình ly kì làm lòng ta hồi hộp rồi khuây khỏa, mà gây ấn tượng hơn, là lưu ý chúng ta về định mệnh hình thành từ những hành vi nhỏ nhặt nhất, về ý nghĩa sâu xa tiềm ẩn trong từng sự vật bé bỏng nhất, như sợi dây tết, như rượu cúng thần, như vị trí và hành vi của từng người trong suốt dòng thời gian biến động.', 9),
(7, 1, '6 phát minh làm nên thời đại 1', '7.jpg', 140000, 'ád', 10),
(8, 4, '10 điều răn lãnh đạo tối ưu nhất thế giới', '8.jpg', 80000, 'Năng lực lãnh đạo được thực hành bởi con người, với con người và cho con người. 10 ĐIỀU RĂN LÃNH ĐẠO TỐI ƯU NHẤT THẾ GIỚI được xây dựng dựa trên chân lý đó. Sự phức tạp của năng lực lãnh đạo không chỉ nằm ở thực tế rằng mỗi người chúng ta đều khác nhau, mà còn ở việc mỗi cá nhân lãnh đạo đều là độc nhất vô nhị. Công việc lãnh đạo là khó khăn và mọi người đều có thể sai phạm.', 10),
(10, 1, 'A-Z Chiêm tinh học (Tập 1)', '10.jpg', 160000, 'Đọc A-Z Chiêm tinh học (tập 1), ngoài cung Hoàng Đạo là phần khởi nguồn và căn bản nhất, độc giả sẽ được tìm hiểu về các nguyên tố, các đặc tính và phân cực, các hành tinh. Ở đó, độc giả sẽ biết cách đọc bản đồ sao, khám phá được những tầng sâu nội tâm bên trong không ngờ tới, những đặc điểm quy định mỗi cá thể trở nên khác biệt và duy nhất trong vũ trụ bao la này.', 5),
(15, 2, 'a', '3.png', 3000, 'mota', 10),
(19, 2, 'sherlock home', 'sherlock.jpg', 30000, 'asdsad', 10),
(28, NULL, NULL, NULL, NULL, NULL, 10),
(29, NULL, 'tôi là ai', 'sherlock.jpg', 30000, NULL, 10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `role` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`user_id`, `name`, `email`, `pass`, `role`) VALUES
(2, 'Nguyễn Đức Luận', 'ducluan@gmail.com', '123456', b'0'),
(3, 'Đỗ Trọng Mai', 'trongmai@gmail.com', '123456', b'0'),
(4, 'Nguyễn Xuân Hoàng', 'xuanhoang@gmail.com', '123456', b'0'),
(5, 'Nguyễn Khắc Sơn', 'sonnk712@gmail.com', '123456', b'0'),
(6, 'Nguyễn Khắc Sơn', 'son7@gmail.com', '123', b'0'),
(9, 'son', 'sonnnk712@gmail.com', '123', b'1'),
(10, 'sonson', 'son2', '123', b'1'),
(12, 'son3', 'sonn011', '123', b'1');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`bill_id`);

--
-- Chỉ mục cho bảng `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD PRIMARY KEY (`bill_detail_id`);

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `bill`
--
ALTER TABLE `bill`
  MODIFY `bill_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `bill_detail`
--
ALTER TABLE `bill_detail`
  MODIFY `bill_detail_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT cho bảng `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
