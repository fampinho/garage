
CREATE TABLE `staff_name` (
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

CREATE TABLE `stock` (
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

CREATE TABLE `vehicle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `model` varchar(16) NOT NULL,
  `maker` varchar(16) NOT NULL,
  `fuel` varchar(8) NOT NULL,
  `customer_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_customer_vehicle_idx` (`customer_id`),
  CONSTRAINT `FK_customer_vehicle` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
