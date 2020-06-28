CREATE TABLE `garage_test`.`login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(8) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `garage_test`.`customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ppsn` varchar(9) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `login_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_login_customer_idx` (`login_id`),
  CONSTRAINT `FK_login_customer` FOREIGN KEY (`login_id`) REFERENCES `login` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `garage_test`.`customer_name` (
  `customer_id` int NOT NULL,
  `name` varchar(10) NOT NULL,
  `mid_name` varchar(20) DEFAULT NULL,
  `surname` varchar(10) NOT NULL,
  PRIMARY KEY (`customer_id`),
  KEY `FK_customer_customer_name_idx` (`customer_id`),
  CONSTRAINT `FK_customer_customer_name` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `garage_test`.`staff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ppsn` varchar(9) NOT NULL,
  `salary` float NOT NULL,
  `available` tinyint(1) NOT NULL,
  `login_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_login_staff_idx` (`login_id`),
  CONSTRAINT `FK_login_staff` FOREIGN KEY (`login_id`) REFERENCES `login` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `garage_test`.`staff_name` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `mid_name` varchar(20) DEFAULT NULL,
  `surname` varchar(10) NOT NULL,
  `staff_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_staff_staff_name_idx` (`staff_id`),
  CONSTRAINT `FK_staff_staff_name` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `garage_test`.`vehicle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `model` varchar(16) NOT NULL,
  `maker` varchar(16) NOT NULL,
  `fuel` varchar(8) NOT NULL,
  `customer_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_customer_vehicle_idx` (`customer_id`),
  CONSTRAINT `FK_customer_vehicle` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `garage_test`.`car_licence` (
  `vehicle_id` int NOT NULL,
  `licence_number` varchar(10) NOT NULL,
  `manufacture` varchar(4) NOT NULL,
  PRIMARY KEY (`vehicle_id`),
  UNIQUE KEY `vehicle_id_UNIQUE` (`vehicle_id`),
  KEY `FK_vehicle_car_licence_idx` (`vehicle_id`),
  CONSTRAINT `FK_vehicle_car_licence` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `garage_test`.`booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(14) NOT NULL,
  `appointment` timestamp NOT NULL,
  `description` varchar(50) NOT NULL,
  `status` varchar(21) NOT NULL,
  `staff_id` int NOT NULL,
  `customer_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_staff_booking_idx` (`staff_id`),
  KEY `FK_customer_booking_idx` (`customer_id`),
  CONSTRAINT `FK_customer_booking` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FK_staff_booking` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `garage_test`.`service` (
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

CREATE TABLE `garage_test`.`stock` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `quantity` int NOT NULL,
  `date_in` timestamp NOT NULL,
  `date_out` timestamp NOT NULL,
  `price` float NOT NULL,
  `service_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_service_stock_idx` (`service_id`),
  CONSTRAINT `FK_service_stock` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;