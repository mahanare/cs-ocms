SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `ocms` ;
CREATE SCHEMA IF NOT EXISTS `ocms` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `ocms` ;

-- -----------------------------------------------------
-- Table `login_master`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `login_master` ;

CREATE  TABLE IF NOT EXISTS `login_master` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `email_id` VARCHAR(100) NOT NULL ,
  `password` VARCHAR(80) NOT NULL ,
  `first_name` VARCHAR(75) NOT NULL ,
  `last_name` VARCHAR(75) NOT NULL ,
  `date_of_birth` DATETIME NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `email_id_UNIQUE` (`email_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `case_status_master`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `case_status_master` ;

CREATE  TABLE IF NOT EXISTS `case_status_master` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `case_status_name` VARCHAR(50) NOT NULL ,
  `case_status_description` VARCHAR(255) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `case_status_name_UNIQUE` (`case_status_name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `help_category_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `help_category_type` ;

CREATE  TABLE IF NOT EXISTS `help_category_type` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `category_name` VARCHAR(50) NOT NULL ,
  `description` VARCHAR(100) NULL ,
  `parent_type_id` INT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `category_name_UNIQUE` (`category_name` ASC) ,
  INDEX `fk_help_category_parent_id_idx` (`parent_type_id` ASC) ,
  CONSTRAINT `fk_help_category_parent_id`
    FOREIGN KEY (`parent_type_id` )
    REFERENCES `help_category_type` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `case_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `case_type` ;

CREATE  TABLE IF NOT EXISTS `case_type` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `description` VARCHAR(255) NULL ,
  `parent_type_id` INT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) ,
  INDEX `fk_case_parent_type_id_idx` (`parent_type_id` ASC) ,
  CONSTRAINT `fk_case_parent_type_id`
    FOREIGN KEY (`parent_type_id` )
    REFERENCES `case_type` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `case_master`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `case_master` ;

CREATE  TABLE IF NOT EXISTS `case_master` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `created_by` INT NOT NULL ,
  `created_on` DATETIME NOT NULL ,
  `updated_by` INT NOT NULL ,
  `updated_on` DATETIME NOT NULL ,
  `person_name` VARCHAR(100) NOT NULL ,
  `date_of_birth` DATETIME NULL ,
  `case_description` VARCHAR(500) NOT NULL ,
  `contact_number1` VARCHAR(25) NOT NULL ,
  `contact_number2` VARCHAR(45) NULL ,
  `source` VARCHAR(100) NOT NULL ,
  `case_status_id` INT NOT NULL ,
  `case_type_id` INT NOT NULL ,
  `help_category_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_case_master_status_id_idx` (`case_status_id` ASC) ,
  INDEX `fk_case_master_help_category_id_idx` (`help_category_id` ASC) ,
  INDEX `fk_case_master_created_by_idx` (`created_by` ASC) ,
  INDEX `fk_case_master_updated_by_idx` (`updated_by` ASC) ,
  INDEX `fk_case_master_case_type_id_idx` (`case_type_id` ASC) ,
  CONSTRAINT `fk_case_master_status_id`
    FOREIGN KEY (`case_status_id` )
    REFERENCES `case_status_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_case_master_help_category_id`
    FOREIGN KEY (`help_category_id` )
    REFERENCES `help_category_type` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_case_master_created_by`
    FOREIGN KEY (`created_by` )
    REFERENCES `login_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_case_master_updated_by`
    FOREIGN KEY (`updated_by` )
    REFERENCES `login_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_case_master_case_type_id`
    FOREIGN KEY (`case_type_id` )
    REFERENCES `case_type` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `case_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `case_user` ;

CREATE  TABLE IF NOT EXISTS `case_user` (
  `case_id` INT NULL ,
  `user_id` INT NULL ,
  `is_org` TINYINT(1) NULL DEFAULT false ,
  INDEX `fk_case_users_user_id_idx` (`user_id` ASC) ,
  INDEX `fk_case_users_case_id_idx` (`case_id` ASC) ,
  PRIMARY KEY (`case_id`, `user_id`) ,
  CONSTRAINT `fk_case_users_user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `login_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_case_users_case_id`
    FOREIGN KEY (`case_id` )
    REFERENCES `case_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `case_artifact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `case_artifact` ;

CREATE  TABLE IF NOT EXISTS `case_artifact` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `artifact_type` VARCHAR(25) NOT NULL ,
  `artifact` BLOB NOT NULL ,
  `case_id` INT NOT NULL ,
  `added_by` INT NULL ,
  INDEX `fk_case_artifacts_case_id_idx` (`case_id` ASC) ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_case_artifact_user_id_idx` (`added_by` ASC) ,
  CONSTRAINT `fk_case_artifacts_case_id`
    FOREIGN KEY (`case_id` )
    REFERENCES `case_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_case_artifact_user_id`
    FOREIGN KEY (`added_by` )
    REFERENCES `login_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `case_activity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `case_activity` ;

CREATE  TABLE IF NOT EXISTS `case_activity` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `action` VARCHAR(255) NOT NULL ,
  `action_by` INT NOT NULL ,
  `action_date` DATETIME NOT NULL ,
  `description` VARCHAR(255) NOT NULL ,
  `case_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_case_activities_case_id_idx` (`case_id` ASC) ,
  INDEX `fk_case_activity_user_id_idx` (`action_by` ASC) ,
  CONSTRAINT `fk_case_activities_case_id`
    FOREIGN KEY (`case_id` )
    REFERENCES `case_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_case_activity_user_id`
    FOREIGN KEY (`action_by` )
    REFERENCES `login_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fund_management`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fund_management` ;

CREATE  TABLE IF NOT EXISTS `fund_management` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `donor` VARCHAR(100) NOT NULL ,
  `purpose` VARCHAR(255) NOT NULL ,
  `amount` INT NOT NULL ,
  `credit_debit` INT NOT NULL ,
  `date` DATETIME NOT NULL ,
  `case_id` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_fund_management_case_id_idx` (`case_id` ASC) ,
  CONSTRAINT `fk_fund_management_case_id`
    FOREIGN KEY (`case_id` )
    REFERENCES `case_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `help_category_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `help_category_user` ;

CREATE  TABLE IF NOT EXISTS `help_category_user` (
  `user_id` INT NOT NULL ,
  `help_category_id` INT NOT NULL ,
  PRIMARY KEY (`user_id`, `help_category_id`) ,
  INDEX `fk_help_category_users_category_id_idx` (`help_category_id` ASC) ,
  INDEX `fk_help_category_users_user_id_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_help_category_users_category_id`
    FOREIGN KEY (`help_category_id` )
    REFERENCES `help_category_type` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_help_category_users_user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `login_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `case_type_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `case_type_user` ;

CREATE  TABLE IF NOT EXISTS `case_type_user` (
  `user_id` INT NOT NULL ,
  `case_type_id` INT NOT NULL ,
  PRIMARY KEY (`case_type_id`, `user_id`) ,
  INDEX `fk_case_type_user_id_idx` (`user_id` ASC) ,
  INDEX `fk_case_type_case_type_id_idx` (`case_type_id` ASC) ,
  CONSTRAINT `fk_case_type_user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `login_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_case_type_case_type_id`
    FOREIGN KEY (`case_type_id` )
    REFERENCES `case_type` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_profile` ;

CREATE  TABLE IF NOT EXISTS `user_profile` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `other_email_id` VARCHAR(100) NOT NULL ,
  `blood_group` VARCHAR(10) NOT NULL ,
  `anniversary` DATETIME NOT NULL ,
  `user_id` INT NOT NULL ,
  `monthly_updates` TINYINT(1) NOT NULL DEFAULT 1 ,
  `special_updates` TINYINT(1) NOT NULL DEFAULT 1 ,
  `regular_updates` TINYINT(1) NOT NULL DEFAULT 1 ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_user_profile_user_id_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_user_profile_user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `login_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `org_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `org_type` ;

CREATE  TABLE IF NOT EXISTS `org_type` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `description` VARCHAR(255) NOT NULL ,
  `parent_id` INT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) ,
  INDEX `fk_org_type_parent_id_idx` (`parent_id` ASC) ,
  CONSTRAINT `fk_org_type_parent_id`
    FOREIGN KEY (`parent_id` )
    REFERENCES `org_type` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `organization` ;

CREATE  TABLE IF NOT EXISTS `organization` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `org_type_id` INT NOT NULL ,
  `address` VARCHAR(255) NOT NULL ,
  `description` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_organization_info_org_type_id_idx` (`org_type_id` ASC) ,
  CONSTRAINT `fk_organization_info_org_type_id`
    FOREIGN KEY (`org_type_id` )
    REFERENCES `org_type` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_organization` ;

CREATE  TABLE IF NOT EXISTS `user_organization` (
  `user_id` INT NOT NULL ,
  `org_id` INT NOT NULL ,
  INDEX `fk_user_organization_user_id_idx` (`user_id` ASC) ,
  INDEX `fk_user_organization_org_id_idx` (`org_id` ASC) ,
  PRIMARY KEY (`user_id`, `org_id`) ,
  CONSTRAINT `fk_user_organization_user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `login_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_organization_org_id`
    FOREIGN KEY (`org_id` )
    REFERENCES `organization` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `role_master`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `role_master` ;

CREATE  TABLE IF NOT EXISTS `role_master` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `role_name` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(255) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `role_name_UNIQUE` (`role_name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `module_master`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `module_master` ;

CREATE  TABLE IF NOT EXISTS `module_master` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `description` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_role` ;

CREATE  TABLE IF NOT EXISTS `user_role` (
  `user_id` INT NOT NULL AUTO_INCREMENT ,
  `role_id` INT NOT NULL ,
  `module_id` INT NULL ,
  INDEX `fk_user_role_user_id_idx` (`user_id` ASC) ,
  INDEX `fk_user_role_role_id_idx` (`role_id` ASC) ,
  INDEX `fk_user_role_module_id_idx` (`module_id` ASC) ,
  CONSTRAINT `fk_user_role_user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `login_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_role_id`
    FOREIGN KEY (`role_id` )
    REFERENCES `role_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_module_id`
    FOREIGN KEY (`module_id` )
    REFERENCES `module_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `role_permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `role_permission` ;

CREATE  TABLE IF NOT EXISTS `role_permission` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `read_perm` VARCHAR(1) NOT NULL ,
  `edit_perm` VARCHAR(1) NOT NULL ,
  `add_perm` VARCHAR(1) NOT NULL ,
  `approve_perm` VARCHAR(1) NOT NULL ,
  `delete_perm` VARCHAR(1) NOT NULL ,
  `description` VARCHAR(255) NOT NULL ,
  `role_id` INT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_role_permissions_role_id`
    FOREIGN KEY (`role_id` )
    REFERENCES `role_master` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `email_template`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `email_template` ;

CREATE  TABLE IF NOT EXISTS `email_template` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `description` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

USE `ocms` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `login_master`
-- -----------------------------------------------------
START TRANSACTION;
USE `ocms`;
INSERT INTO `login_master` (`id`, `email_id`, `password`, `first_name`, `last_name`, `date_of_birth`) VALUES (1, 'harinath@tmad.org', '5a105e8b9d40e1329780d62ea2265d8a', 'Harinath', 'Mallepally', '1979-06-06');
INSERT INTO `login_master` (`id`, `email_id`, `password`, `first_name`, `last_name`, `date_of_birth`) VALUES (2, 'hari@harinath.in', '5a105e8b9d40e1329780d62ea2265d8a', 'Harinath', '', '1979-06-01');

COMMIT;

-- -----------------------------------------------------
-- Data for table `case_status_master`
-- -----------------------------------------------------
START TRANSACTION;
USE `ocms`;
INSERT INTO `case_status_master` (`id`, `case_status_name`, `case_status_description`) VALUES (1, 'New', NULL);
INSERT INTO `case_status_master` (`id`, `case_status_name`, `case_status_description`) VALUES (2, 'Pending', NULL);
INSERT INTO `case_status_master` (`id`, `case_status_name`, `case_status_description`) VALUES (3, 'In Progress', NULL);
INSERT INTO `case_status_master` (`id`, `case_status_name`, `case_status_description`) VALUES (4, 'On Hold', NULL);
INSERT INTO `case_status_master` (`id`, `case_status_name`, `case_status_description`) VALUES (5, 'Resolved', NULL);

COMMIT;

-- -----------------------------------------------------
-- Data for table `help_category_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `ocms`;
INSERT INTO `help_category_type` (`id`, `category_name`, `description`, `parent_type_id`) VALUES (1, 'Monetary', NULL, NULL);
INSERT INTO `help_category_type` (`id`, `category_name`, `description`, `parent_type_id`) VALUES (2, 'Reference', NULL, NULL);
INSERT INTO `help_category_type` (`id`, `category_name`, `description`, `parent_type_id`) VALUES (3, 'Guidance', NULL, NULL);
INSERT INTO `help_category_type` (`id`, `category_name`, `description`, `parent_type_id`) VALUES (4, 'Non monetary', NULL, NULL);

COMMIT;

-- -----------------------------------------------------
-- Data for table `case_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `ocms`;
INSERT INTO `case_type` (`id`, `name`, `description`, `parent_type_id`) VALUES (1, 'Medical', NULL, NULL);
INSERT INTO `case_type` (`id`, `name`, `description`, `parent_type_id`) VALUES (2, 'Education', NULL, NULL);
INSERT INTO `case_type` (`id`, `name`, `description`, `parent_type_id`) VALUES (3, 'Amenities', NULL, NULL);
INSERT INTO `case_type` (`id`, `name`, `description`, `parent_type_id`) VALUES (4, 'Calamities', NULL, NULL);
INSERT INTO `case_type` (`id`, `name`, `description`, `parent_type_id`) VALUES (5, 'Heart Operation', NULL, 1);
INSERT INTO `case_type` (`id`, `name`, `description`, `parent_type_id`) VALUES (6, 'Kidney', NULL, 1);
INSERT INTO `case_type` (`id`, `name`, `description`, `parent_type_id`) VALUES (7, 'Education Loan', NULL, 2);
INSERT INTO `case_type` (`id`, `name`, `description`, `parent_type_id`) VALUES (8, 'Guidance', NULL, 2);

COMMIT;

-- -----------------------------------------------------
-- Data for table `case_master`
-- -----------------------------------------------------
START TRANSACTION;
USE `ocms`;
INSERT INTO `case_master` (`id`, `created_by`, `created_on`, `updated_by`, `updated_on`, `person_name`, `date_of_birth`, `case_description`, `contact_number1`, `contact_number2`, `source`, `case_status_id`, `case_type_id`, `help_category_id`) VALUES (1, 1, '2008-05-27', 1, '2009-02-23', 'Prasanthi', '1980-01-01', 'need urgent blood group O-', '898989898', '898989', 'friend', 1, 1, 1);
INSERT INTO `case_master` (`id`, `created_by`, `created_on`, `updated_by`, `updated_on`, `person_name`, `date_of_birth`, `case_description`, `contact_number1`, `contact_number2`, `source`, `case_status_id`, `case_type_id`, `help_category_id`) VALUES (2, 1, '2011-01-9', 1, '2009-09-12', 'Kashyap', '1979-05-05', 'Fresher needs Job', '2342343', '4324324', 'news paper', 1, 2, 1);

COMMIT;

-- -----------------------------------------------------
-- Data for table `case_user`
-- -----------------------------------------------------
START TRANSACTION;
USE `ocms`;
INSERT INTO `case_user` (`case_id`, `user_id`, `is_org`) VALUES (1, 1, 0);
INSERT INTO `case_user` (`case_id`, `user_id`, `is_org`) VALUES (2, 1, 0);

COMMIT;

-- -----------------------------------------------------
-- Data for table `org_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `ocms`;
INSERT INTO `org_type` (`id`, `name`, `description`, `parent_id`) VALUES (1, 'NGO', 'Charity organization', NULL);
INSERT INTO `org_type` (`id`, `name`, `description`, `parent_id`) VALUES (2, 'State Government', 'State Government', NULL);
INSERT INTO `org_type` (`id`, `name`, `description`, `parent_id`) VALUES (3, 'Union/Central Government', 'Central Government', NULL);
INSERT INTO `org_type` (`id`, `name`, `description`, `parent_id`) VALUES (4, 'Private Limited/Corporate', 'Company', NULL);
INSERT INTO `org_type` (`id`, `name`, `description`, `parent_id`) VALUES (5, 'International Charity', 'Internal organzation', NULL);

COMMIT;

-- -----------------------------------------------------
-- Data for table `role_master`
-- -----------------------------------------------------
START TRANSACTION;
USE `ocms`;
INSERT INTO `role_master` (`id`, `role_name`, `description`) VALUES (1, 'REGISTERED', 'registered');
INSERT INTO `role_master` (`id`, `role_name`, `description`) VALUES (2, 'USER', 'site user');
INSERT INTO `role_master` (`id`, `role_name`, `description`) VALUES (3, 'MANAGER', 'site manager');
INSERT INTO `role_master` (`id`, `role_name`, `description`) VALUES (4, 'ADMIN', 'admin');

COMMIT;

-- -----------------------------------------------------
-- Data for table `module_master`
-- -----------------------------------------------------
START TRANSACTION;
USE `ocms`;
INSERT INTO `module_master` (`id`, `name`, `description`) VALUES (1, 'Case Registration', 'Registration of case');
INSERT INTO `module_master` (`id`, `name`, `description`) VALUES (2, 'User Registration', 'Registration of user');
INSERT INTO `module_master` (`id`, `name`, `description`) VALUES (3, 'Administration', 'Administration/Back office');
INSERT INTO `module_master` (`id`, `name`, `description`) VALUES (4, 'Case Life Cycle', 'Case life cycle activitiies like adding artifacts etc');
INSERT INTO `module_master` (`id`, `name`, `description`) VALUES (5, 'Case Administration', 'Update case state etc');

COMMIT;

-- -----------------------------------------------------
-- Data for table `user_role`
-- -----------------------------------------------------
START TRANSACTION;
USE `ocms`;
INSERT INTO `user_role` (`user_id`, `role_id`, `module_id`) VALUES (1, 1, NULL);
INSERT INTO `user_role` (`user_id`, `role_id`, `module_id`) VALUES (1, 2, NULL);
INSERT INTO `user_role` (`user_id`, `role_id`, `module_id`) VALUES (1, 3, NULL);
INSERT INTO `user_role` (`user_id`, `role_id`, `module_id`) VALUES (1, 4, NULL);
INSERT INTO `user_role` (`user_id`, `role_id`, `module_id`) VALUES (2, 1, NULL);
INSERT INTO `user_role` (`user_id`, `role_id`, `module_id`) VALUES (2, 2, NULL);

COMMIT;