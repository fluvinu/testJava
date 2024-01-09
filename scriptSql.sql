USE testjdbc;

-- Create product_info table
CREATE TABLE `testjdbc`.`product_info` (
  `pid` INT NOT NULL AUTO_INCREMENT,
  `pname` VARCHAR(45) NOT NULL,
  `pqty` INT NULL,
  `pro_price` DOUBLE NULL,
  PRIMARY KEY (`pid`)
);

-- Create order_info table
CREATE TABLE `testjdbc`.`order_info` (
  `oid` INT NOT NULL AUTO_INCREMENT,
  `c_name` VARCHAR(45) NULL,
  `pid` INT NOT NULL,
  `order_p_qty` INT NULL,
  `totaCostl` DOUBLE NULL,
  PRIMARY KEY (`oid`),
  INDEX `pid_idx` (`pid` ASC) VISIBLE,
  CONSTRAINT `pid`
    FOREIGN KEY (`pid`)
    REFERENCES `testjdbc`.`product_info` (`pid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- Insert data into product_info
INSERT INTO product_info VALUES (1, 'icecream', 3, 300);
INSERT INTO product_info VALUES (2, 'chocolate', 5, 250);
INSERT INTO product_info VALUES (3, 'milk', 2, 150);

-- Update product_info
UPDATE product_info SET pqty = 8 WHERE pid = 2;

-- Define stored procedure placedOrder
DELIMITER //
CREATE PROCEDURE placedOrder (cname VARCHAR(45), pidu INT, OrderQty INT)
BEGIN
  DECLARE total DOUBLE;
  DECLARE priceP DOUBLE;
  DECLARE proQtyac INT;
declare newProductQty int ;
  SELECT pqty INTO proQtyac FROM product_info WHERE pid = pidu;
  SELECT pro_price INTO priceP FROM product_info WHERE pid = pidu;
  SET total = OrderQty * priceP;
  set newProductQty= proQtyac-OrderQty;
  INSERT INTO order_info (c_name, pid, order_p_qty, totaCostl) VALUES (cname, pidu, OrderQty, total);
  UPDATE product_info SET pqty = newProductQty WHERE pid = pidu;
END//
DELIMITER ;

-- Insert data into order_info
INSERT INTO order_info (c_name, pid, order_p_qty) VALUES ('sid', 2, 1);

-- Call the placedOrder procedure
CALL placedOrder('sid', 2, 1);
