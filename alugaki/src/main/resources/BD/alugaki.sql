-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`TB_CLIENTE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TB_CLIENTE` (
  `ID_CLIENTE` INT NOT NULL,
  `DS_NOME` VARCHAR(45) NULL,
  `NU_CPF` VARCHAR(45) NULL,
  `DS_EMAIL` VARCHAR(100) NULL,
  PRIMARY KEY (`ID_CLIENTE`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TB_VEICULO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TB_VEICULO` (
  `ID_VEICULO` INT NOT NULL,
  `DS_MARCA` VARCHAR(45) NULL,
  `DS_NOME` VARCHAR(45) NULL,
  `DS_COR` VARCHAR(45) NULL,
  `QTD_PASSAGEIROS` INT NULL,
  PRIMARY KEY (`ID_VEICULO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TB_STATUS_PAGAMENTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TB_STATUS_PAGAMENTO` (
  `ID_STATUS_PAGAMENTO` INT NOT NULL,
  `DS_STATUS_PAGAMENTO` VARCHAR(45) NULL,
  `SG_SIGLA` VARCHAR(45) NULL,
  PRIMARY KEY (`ID_STATUS_PAGAMENTO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TB_ALUGUEL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TB_ALUGUEL` (
  `ID_ALUGUEL` INT NOT NULL,
  `FK_CLIENTE` INT NOT NULL,
  `FK_VEICULO` INT NOT NULL,
  `FK_STATUS_PAGAMENTO` INT NULL,
  `DT_ALUGUEL` DATE NULL,
  `DT_DEVOLUCAO` DATE NULL,
  `NU_VALOR_TOTAL` DECIMAL NULL,
  `QT_KM_PECORRIDO` FLOAT NULL,
  `FK_STATUS_PAGAMENTO` INT NOT NULL,
  PRIMARY KEY (`ID_ALUGUEL`, `FK_VEICULO`, `FK_CLIENTE`, `FK_STATUS_PAGAMENTO`),
  INDEX `fk_TB_ALUGUEL_TB_CLIENTE_idx` (`FK_CLIENTE` ASC),
  INDEX `fk_TB_ALUGUEL_TB_VEICULO1_idx` (`FK_VEICULO` ASC),
  INDEX `fk_TB_ALUGUEL_TB_STATUS_PAGAMENTO1_idx` (`FK_STATUS_PAGAMENTO` ASC),
  CONSTRAINT `fk_TB_ALUGUEL_TB_CLIENTE`
    FOREIGN KEY (`FK_CLIENTE`)
    REFERENCES `mydb`.`TB_CLIENTE` (`ID_CLIENTE`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_ALUGUEL_TB_VEICULO1`
    FOREIGN KEY (`FK_VEICULO`)
    REFERENCES `mydb`.`TB_VEICULO` (`ID_VEICULO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TB_ALUGUEL_TB_STATUS_PAGAMENTO1`
    FOREIGN KEY (`FK_STATUS_PAGAMENTO`)
    REFERENCES `mydb`.`TB_STATUS_PAGAMENTO` (`ID_STATUS_PAGAMENTO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
