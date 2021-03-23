CREATE TABLE `WorkingDays` (
                        `id` varchar(10) NOT NULL,
                        `noOfDays` varchar(30) DEFAULT NULL,
                        `sunday` boolean  DEFAULT 0,
                        `monday` boolean  DEFAULT 0,
                        `tuesday` boolean  DEFAULT 0,
                        `wednesday` boolean  DEFAULT 0,
                        `thursday` boolean  DEFAULT 0,
                        `friday` boolean  DEFAULT 0,
                        `saturday` boolean  DEFAULT 0,
                        `workingTime` decimal(6,2) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;






CREATE TABLE `Customer` (
  `customerId` varchar(10) NOT NULL,
  `name` varchar(15) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Item` (
  `code` varchar(10) NOT NULL,
  `description` varchar(30) DEFAULT NULL,
  `unitPrice` decimal(6,2) DEFAULT NULL,
  `qtyOnHand` int(5) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Order` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `customerId` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKckicmtwun913u69pha7agsgpd` (`customerId`),
  CONSTRAINT `FKckicmtwun913u69pha7agsgpd` FOREIGN KEY (`customerId`) REFERENCES `Customer` (`customerId`),
  CONSTRAINT `Order_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `Customer` (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `OrderDetail` (
  `orderId` int(11) NOT NULL,
  `itemCode` varchar(10) NOT NULL,
  `qty` int(5) DEFAULT NULL,
  `unitPrice` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`orderId`,`itemCode`),
  KEY `FKtogd3d0kvb3mreeh4pn7qox19` (`itemCode`),
  CONSTRAINT `FK21x4a3ee3h5uwombp0n7cayng` FOREIGN KEY (`orderId`) REFERENCES `Order` (`id`),
  CONSTRAINT `FKtogd3d0kvb3mreeh4pn7qox19` FOREIGN KEY (`itemCode`) REFERENCES `Item` (`code`),
  CONSTRAINT `OrderDetail_ibfk_2` FOREIGN KEY (`itemCode`) REFERENCES `Item` (`code`),
  CONSTRAINT `OrderDetail_ibfk_3` FOREIGN KEY (`orderId`) REFERENCES `Order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

