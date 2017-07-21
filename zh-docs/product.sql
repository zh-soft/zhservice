
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
	`id` INT (11) NOT NULL AUTO_INCREMENT,
	`bn` INT (11) ,
	`brand` VARCHAR (64),
	`type` VARCHAR (64),
	`series` VARCHAR (64),
	`psn` VARCHAR (32),
	`number` VARCHAR (64),
	`sku` VARCHAR (60),
	`model` VARCHAR (15),
	`descr` CHAR (30),
	`ptime` DATE,
	`gtime` DATE,
	 KEY id (id)
);

DROP TABLE IF EXISTS `product_warehouse`;
CREATE TABLE `product_warehouse` (
	`id` INT (11)  NOT NULL AUTO_INCREMENT,
	`wid` INT (11),
	`counts` INT (11),
  `bn` INT (11),
	`brand` VARCHAR (64),
	`type` CHAR (64),
	`series` VARCHAR (30),
	`model` VARCHAR (64),
	`stime` DATE ,
	 KEY id (id)
);