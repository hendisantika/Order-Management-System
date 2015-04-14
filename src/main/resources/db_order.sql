DROP DATABASE IF EXISTS `db_order`;
CREATE DATABASE IF NOT EXISTS `db_order`;
USE `db_order`;

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  productId int(10) NOT NULL AUTO_INCREMENT,
  productName varchar(25) DEFAULT NULL,
  productDescription varchar(50) DEFAULT NULL,
  unitPrice double DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ;
DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS customer(
	customerId int(10) NOT NULL AUTO_INCREMENT,
	cusLastname varchar(25) NOT NULL,
	cusFirstname varchar(25) NOT NULL,
	cusEmail varchar(50) NOT NULL,
	cusPhoneNo varchar(14) NOT NULL,
	cusCity varchar(15) NULL,
	cusProvince varchar(25) NULL,
	cusCountry varchar(25) NULL,
	PRIMARY KEY (customerId)
);
DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS orders(
	orderID int(10) NOT NULL AUTO_INCREMENT,
	customerId int(10) NOT NULL,
	totalAmount double NOT NULL,
	PRIMARY KEY (orderID),
	FOREIGN KEY (customerId) REFERENCES customer(customerId)
);

DROP TABLE IF EXISTS `orderDetails`;
CREATE TABLE IF NOT EXISTS orderDetails (
	orderDetailsNo int(10) NOT NULL AUTO_INCREMENT,
	orderID int(10) NOT NULL,
	productId int(10) NOT NULL,
	quantity int(4) NOT NULL,
	subtotal double NOT NULL,
	PRIMARY KEY (orderDetailsNo),
	CONSTRAINT fk_productId FOREIGN KEY (productId) REFERENCES product(productId),
	CONSTRAINT fk_orderID FOREIGN KEY (orderID) REFERENCES orders(orderID)
);
