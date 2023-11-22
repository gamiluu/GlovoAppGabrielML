-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema glovo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema glovo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `glovo` DEFAULT CHARACTER SET utf8 ;
USE `glovo` ;

-- -----------------------------------------------------
-- Table `glovo`.`restaurantes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `glovo`.`restaurantes` (
  `id_restaurante` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NULL,
  `clave` VARCHAR(50) NULL,
  `descripcion` VARCHAR(250) NULL,
  `ubicacion` VARCHAR(60) NULL,
  PRIMARY KEY (`id_restaurante`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `glovo`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `glovo`.`usuarios` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NULL,
  `contrasena` VARCHAR(50) NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `glovo`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `glovo`.`categorias` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(40) NULL,
  PRIMARY KEY (`id_categoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `glovo`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `glovo`.`productos` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `id_restaurante` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `imagen` VARCHAR(255) NULL,
  `descripcion` VARCHAR(250) NULL,
  `precio` INT NULL,
  PRIMARY KEY (`id_producto`),
  INDEX `fk_productos_restaurantes1_idx` (`id_restaurante` ASC) VISIBLE,
  CONSTRAINT `fk_productos_restaurantes1`
    FOREIGN KEY (`id_restaurante`)
    REFERENCES `glovo`.`restaurantes` (`id_restaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `glovo`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `glovo`.`compras` (
  `id_compra` INT NOT NULL AUTO_INCREMENT,
  `id_usuario` INT NOT NULL,
  `confirmada` TINYINT NULL,
  `fecha` DATE NULL,
  PRIMARY KEY (`id_compra`),
  INDEX `fk_compras_usuarios1_idx` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_compras_usuarios1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `glovo`.`usuarios` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `glovo`.`lineas_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `glovo`.`lineas_compra` (
  `id_compra` INT NOT NULL,
  `id_producto` INT NOT NULL,
  `cantidad` INT NULL,
  INDEX `fk_productos_has_compras_compras1_idx` (`id_compra` ASC) VISIBLE,
  INDEX `fk_productos_has_compras_productos1_idx` (`id_producto` ASC) VISIBLE,
  CONSTRAINT `fk_productos_has_compras_productos1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `glovo`.`productos` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productos_has_compras_compras1`
    FOREIGN KEY (`id_compra`)
    REFERENCES `glovo`.`compras` (`id_compra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `glovo`.`puntuaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `glovo`.`puntuaciones` (
  `id_usuario` INT NOT NULL,
  `id_restaurante` INT NOT NULL,
  `nota` INT NULL,
  INDEX `fk_restaurantes_has_usuarios_usuarios1_idx` (`id_usuario` ASC) VISIBLE,
  INDEX `fk_restaurantes_has_usuarios_restaurantes1_idx` (`id_restaurante` ASC) VISIBLE,
  CONSTRAINT `fk_restaurantes_has_usuarios_restaurantes1`
    FOREIGN KEY (`id_restaurante`)
    REFERENCES `glovo`.`restaurantes` (`id_restaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_restaurantes_has_usuarios_usuarios1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `glovo`.`usuarios` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `glovo`.`restaurantes_categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `glovo`.`restaurantes_categorias` (
  `id_restaurante` INT NOT NULL,
  `id_categoria` INT NOT NULL,
  INDEX `fk_restaurantes_has_categorias_categorias1_idx` (`id_categoria` ASC) VISIBLE,
  INDEX `fk_restaurantes_has_categorias_restaurantes1_idx` (`id_restaurante` ASC) VISIBLE,
  CONSTRAINT `fk_restaurantes_has_categorias_restaurantes1`
    FOREIGN KEY (`id_restaurante`)
    REFERENCES `glovo`.`restaurantes` (`id_restaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_restaurantes_has_categorias_categorias1`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `glovo`.`categorias` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
