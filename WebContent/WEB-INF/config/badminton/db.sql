/***/
CREATE TABLE `badminton`.`user` (
  `id` VARCHAR(32) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Table user store the user profile';

/***/
CREATE TABLE `badminton`.`user_credential` (
  `id` VARCHAR(32) NOT NULL,
  `user_id` VARCHAR(32),
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = 'Store use\'s credential';


