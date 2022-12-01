CREATE TABLE `MoimPublic`.`moim_place_upper` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `place_id` BIGINT(20) NOT NULL,
  `place_name` VARCHAR(200) NOT NULL,
  `category_id` INT NOT NULL,
  `page` VARCHAR(500) NOT NULL,
  `crn` VARCHAR(500) NOT NULL,
  `sido` VARCHAR(200) NOT NULL,
  `sigungu` VARCHAR(200) NOT NULL,
  `dong` VARCHAR(200) NOT NULL,
  `period` INT NOT NULL,
  `money` INT NOT NULL,
  `recStartDate` DATETIME NOT NULL,
  `recEndDate` DATETIME NOT NULL,
  PRIMARY KEY (`id`));