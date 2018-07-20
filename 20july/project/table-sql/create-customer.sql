CREATE TABLE `customer` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`firstName` VARCHAR(50) NOT NULL,
	`lastName` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`id`)
);

INSERT INTO `testdb`.`customer` (`id`, `firstName`, `lastName`, `email`) VALUES ('1', 'sourabh', 'gour', 'sg@cg.com');
INSERT INTO `testdb`.`customer` (`id`, `firstName`, `lastName`, `email`) VALUES ('2', 'ben', 'k', 'ben@cg.com');
