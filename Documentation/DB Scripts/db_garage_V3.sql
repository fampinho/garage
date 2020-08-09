CREATE TABLE `booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(14) NOT NULL,
  `appointment` timestamp NOT NULL,
  `description` varchar(50) NOT NULL,
  `status` varchar(21) NOT NULL,
  `staff_id` int NOT NULL,
  `customer_id` int NOT NULL,
  `vehicle_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_staff_booking_idx` (`staff_id`),
  KEY `FK_customer_booking_idx` (`customer_id`),
  KEY `FK_vehicle_booking_idx` (`vehicle_id`),
  CONSTRAINT `FK_customer_booking` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FK_vehicle_booking` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `car_licence` (
  `vehicle_id` int NOT NULL,
  `licence_number` varchar(10) NOT NULL,
  `manufacture` varchar(4) NOT NULL,
  PRIMARY KEY (`vehicle_id`),
  UNIQUE KEY `vehicle_id_UNIQUE` (`vehicle_id`),
  KEY `FK_vehicle_car_licence_idx` (`vehicle_id`),
  CONSTRAINT `FK_vehicle_car_licence` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ppsn` varchar(9) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `customer_name` (
  `customer_id` int NOT NULL,
  `name` varchar(10) NOT NULL,
  `mid_name` varchar(20) DEFAULT NULL,
  `surname` varchar(20) NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `FK_customer_customer_name_idx` (`customer_id`),
  CONSTRAINT `FK_customer_customer_name` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(8) NOT NULL,
  `customer_id` int DEFAULT NULL,
  `staff_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `FK_customer_login_idx` (`customer_id`),
  KEY `FK_staff_login_idx` (`staff_id`),
  CONSTRAINT `FK_customer_login` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FK_staff_login` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  `date_in` timestamp NOT NULL,
  `date_out` timestamp NOT NULL,
  `price` float NOT NULL,
  `extra_price` float DEFAULT NULL,
  `extra_service` varchar(200) DEFAULT NULL,
  `booking_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_booking_service_idx` (`booking_id`),
  CONSTRAINT `FK_booking_service` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `staff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ppsn` varchar(9) NOT NULL,
  `salary` float NOT NULL,
  `is_available` tinyint(1) NOT NULL,
  `service_counter` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `ppsn_UNIQUE` (`ppsn`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `staff_name` (
  `staff_id` int NOT NULL,
  `name` varchar(10) NOT NULL,
  `mid_name` varchar(20) DEFAULT NULL,
  `surname` varchar(20) NOT NULL,
  PRIMARY KEY (`staff_id`),
  UNIQUE KEY `id_UNIQUE` (`staff_id`) /*!80000 INVISIBLE */,
  KEY `FK_staff_staff_name_idx` (`staff_id`),
  CONSTRAINT `FK_staff_staff_name` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `quantity` int NOT NULL,
  `date_in` timestamp NOT NULL,
  `date_out` timestamp NULL DEFAULT NULL,
  `unit_price` float NOT NULL,
  `service_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_service_stock_idx` (`service_id`),
  CONSTRAINT `FK_service_stock` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `vehicle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `model` varchar(16) NOT NULL,
  `maker` varchar(16) NOT NULL,
  `fuel` varchar(8) NOT NULL,
  `type` varchar(9) NOT NULL,
  `customer_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_customer_vehicle_idx` (`customer_id`),
  CONSTRAINT `FK_customer_vehicle` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
