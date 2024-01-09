CREATE TABLE `testjdbc`.`product_info` (
  `pid` INT NOT NULL AUTO_INCREMENT,
  `pname` VARCHAR(45) NOT NULL,
  `pqty` INT NULL,
  `pro_price` DOUBLE NULL,
  PRIMARY KEY (`pid`));

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
    ON UPDATE CASCADE);
