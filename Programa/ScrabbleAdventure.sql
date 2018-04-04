/*CONSULTA QUE SE REALIZA AL INICIO*/
/*show databases;
show tables;*/

/*SE EJECUTA EL SCRIPT*/

CREATE DATABASE IF NOT EXISTS `adventure_scrabble`;
USE `adventure_scrabble`;

CREATE TABLE IF NOT EXISTS `juego` (
  `id_juego` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `ubicacion` varchar(200),
  `archivo` varchar(20),
  `fecha_hecho` DATE,
  `fecha_baja` DATE ,
  PRIMARY KEY (`id_juego`)
);

/*select * from juego;*/

CREATE TABLE IF NOT EXISTS `imagen_juego` (
  `id_juego` INT NOT NULL,
  `id_imagen_juego` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion`varchar(200),
  `archivo` varchar(20),
  `fecha_hecho` DATE,
  `fecha_baja` DATE ,
  PRIMARY KEY (`id_imagen_juego`,`id_juego`),
  KEY `FK_Imagen_Juego_Juego` (`id_juego`),
  CONSTRAINT `FK_Imagen_Juego_Juego` FOREIGN KEY (`id_juego`) REFERENCES `juego` (`id_juego`)
);

CREATE TABLE IF NOT EXISTS `mapa` (
  `id_juego` INT NOT NULL,
  `id_mapa` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(20),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_mapa`,`id_juego`),
  KEY `FK_Mapa_Juego` (`id_juego`),
  CONSTRAINT `FK_Mapa_Juego` FOREIGN KEY (`id_juego`) REFERENCES `juego` (`id_juego`)
  );

CREATE TABLE IF NOT EXISTS `pantalla` (
  `id_juego` INT NOT NULL,
  `id_mapa` INT NOT NULL,
  `id_pantalla` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(20),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_pantalla`,`id_mapa`,`id_juego`),
  KEY `FK_Pantalla_Mapa` (`id_mapa`),
  KEY `FK_Pantalla_Juego` (`id_juego`),
  CONSTRAINT `FK_Pantalla_Mapa` FOREIGN KEY (`id_mapa`) REFERENCES `mapa` (`id_mapa`),
  CONSTRAINT `FK_Pantalla_Juego` FOREIGN KEY (`id_juego`) REFERENCES `mapa` (`id_juego`)
);

CREATE TABLE IF NOT EXISTS `tablero` (
  `id_juego` INT NOT NULL,
  `id_mapa` INT NOT NULL,
  `id_pantalla` INT NOT NULL,
  `id_tablero` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(20),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_tablero`, `id_pantalla`, `id_mapa`,`id_juego`),
  KEY `FK_Tablero_Pantalla` (`id_pantalla`),
  KEY `FK_Tablero_Mapa` (`id_mapa`),
  KEY `FK_Tablero_Juego` (`id_juego`),
  CONSTRAINT `FK_Tablero_Pantalla` FOREIGN KEY (`id_pantalla`) REFERENCES `pantalla` (`id_pantalla`),
  CONSTRAINT `FK_Tablero_Mapa` FOREIGN KEY (`id_mapa`) REFERENCES `pantalla` (`id_mapa`),
  CONSTRAINT `FK_Tablero_Juego` FOREIGN KEY (`id_juego`) REFERENCES `pantalla` (`id_juego`)
);

CREATE TABLE IF NOT EXISTS `tipo_cuadrado` (
  `id_tipo_cuadrado` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(20),
  `fecha_hecho` DATE,
  `fecha_baja` DATE ,
  PRIMARY KEY (`id_tipo_cuadrado`)
);

CREATE TABLE IF NOT EXISTS `cuadrado` (
  `id_juego` INT NOT NULL,
  `id_mapa` INT NOT NULL,
  `id_pantalla` INT NOT NULL,
  `id_tablero` INT NOT NULL,
  `id_cuadrado` INT NOT NULL AUTO_INCREMENT,
  `id_tipo_cuadrado` INT NOT NULL,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(20),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_cuadrado`, `id_tablero`, `id_pantalla`, `id_mapa`, `id_juego`),
  KEY `FK_Cuadrado_Tablero` (`id_tablero`),
  KEY `FK_Cuadrado_Pantalla` (`id_pantalla`),
  KEY `FK_Cuadrado_Mapa` (`id_mapa`),
  KEY `FK_Cuadrado_Juego` (`id_juego`),
  KEY `FK_Cuadrado_Tipo_Cuadrado` (`id_tipo_cuadrado`),
  CONSTRAINT `FK_Cuadrado_Tablero` FOREIGN KEY (`id_tablero`) REFERENCES `tablero` (`id_tablero`),
  CONSTRAINT `FK_Cuadrado_Pantalla` FOREIGN KEY (`id_pantalla`) REFERENCES `tablero` (`id_pantalla`),
  CONSTRAINT `FK_Cuadrado_Mapa` FOREIGN KEY (`id_mapa`) REFERENCES `tablero` (`id_mapa`),
  CONSTRAINT `FK_Cuadrado_Juego` FOREIGN KEY (`id_juego`) REFERENCES `tablero` (`id_juego`),
  CONSTRAINT `FK_Cuadrado_Tipo_Cuadrado` FOREIGN KEY (`id_tipo_cuadrado`) REFERENCES `tipo_cuadrado` (`id_tipo_cuadrado`)
);

ALTER TABLE `adventure_scrabble`.`cuadrado` 
ADD COLUMN `coordenada_x` INT NULL AFTER `fecha_baja`,
ADD COLUMN `coordenada_y` INT NULL AFTER `coordenada_x`;

CREATE TABLE IF NOT EXISTS `modelo` (
  `id_modelo` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(20),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_modelo`)
);

CREATE TABLE IF NOT EXISTS `ficha` (
  `id_juego` INT NOT NULL,
  `id_ficha` INT NOT NULL AUTO_INCREMENT,
  `id_modelo` INT NOT NULL,
  `numero_ficha` INT NOT NULL,
  `puntaje_ficha` INT NOT NULL,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(20),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_ficha`, `id_juego`),
  KEY `FK_Ficha_Modelo` (`id_modelo`),
  KEY `FK_Ficha_Juego` (`id_juego`),
  CONSTRAINT `FK_Ficha_Modelo` FOREIGN KEY (`id_modelo`) REFERENCES `modelo` (`id_modelo`),
  CONSTRAINT `FK_Ficha_Juego` FOREIGN KEY (`id_juego`) REFERENCES `juego` (`id_juego`)
);

CREATE TABLE IF NOT EXISTS `tipo_condicionante` (
  `id_tipo_condicionante` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_tipo_condicionante`)
);

CREATE TABLE IF NOT EXISTS `condicionante` (
  `id_juego` INT NOT NULL,
  `id_mapa` INT NOT NULL,
  `id_pantalla` INT NOT NULL,
  `id_condicionante` INT NOT NULL AUTO_INCREMENT,
  `id_tipo_condicionante` INT NOT NULL,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_condicionante`,`id_pantalla`,`id_mapa`,`id_juego`),
  KEY `FK_Condicionante_Pantalla` (`id_pantalla`),
  KEY `FK_Condicionante_Mapa` (`id_mapa`),
  KEY `FK_Condicionante_Juego` (`id_juego`),
  KEY `FK_Condicionante_Tipo_Condicionante` (`id_tipo_condicionante`),
  CONSTRAINT `FK_Condicionante_Pantalla` FOREIGN KEY (`id_pantalla`) REFERENCES `pantalla` (`id_pantalla`),
  CONSTRAINT `FK_Condicionante_Mapa` FOREIGN KEY (`id_mapa`) REFERENCES `pantalla` (`id_mapa`),
  CONSTRAINT `FK_Condicionante_Juego` FOREIGN KEY (`id_juego`) REFERENCES `pantalla` (`id_juego`),
  CONSTRAINT `FK_Condicionate_Tipo_Condicionante` FOREIGN KEY (`id_tipo_condicionante`) REFERENCES `tipo_condicionante` (`id_tipo_condicionante`)
);

CREATE TABLE IF NOT EXISTS `tipo_objetivo` (
  `id_tipo_objetivo` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_tipo_objetivo`)
);

CREATE TABLE IF NOT EXISTS `objetivo` (
   `id_juego` INT NOT NULL,
   `id_mapa` INT NOT NULL,
   `id_pantalla` INT NOT NULL,
   `id_objetivo` INT NOT NULL AUTO_INCREMENT,
  `id_tipo_objetivo` INT NOT NULL,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_objetivo`,`id_pantalla`,`id_mapa`,`id_juego`),
  KEY `FK_Objetivo_Pantalla` (`id_pantalla`),
  KEY `FK_Objetivo_Mapa` (`id_mapa`),
  KEY `FK_Objetivo_Juego` (`id_juego`),
  KEY `FK_Objetivo_Tipo_Objetivo` (`id_tipo_objetivo`),
  CONSTRAINT `FK_Objetivo_Pantalla` FOREIGN KEY (`id_pantalla`) REFERENCES `pantalla` (`id_pantalla`),
  CONSTRAINT `FK_Objetivo_Mapa` FOREIGN KEY (`id_mapa`) REFERENCES `pantalla` (`id_mapa`),
  CONSTRAINT `FK_Objetivo_Juego` FOREIGN KEY (`id_juego`) REFERENCES `pantalla` (`id_juego`),
  CONSTRAINT `FK_Objetivo_Tipo_Objetivo` FOREIGN KEY (`id_tipo_objetivo`) REFERENCES `tipo_objetivo` (`id_tipo_objetivo`)
);

CREATE TABLE IF NOT EXISTS `estrella` (
  `id_estrella` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(20),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_estrella`)
);

CREATE TABLE IF NOT EXISTS `puntaje_pantalla` (
  `id_juego` INT NOT NULL,
  `id_mapa` INT NOT NULL,
  `id_pantalla` INT NOT NULL,
  `id_puntaje_pantalla` INT NOT NULL AUTO_INCREMENT,
  `id_estrella` INT NOT NULL,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `nivel` INT,
  `puntaje` INT,
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_puntaje_pantalla`,`id_pantalla`,`id_mapa`,`id_juego`),
  KEY `FK_Puntaje_Pantalla_Pantalla` (`id_pantalla`),
  KEY `FK_Puntaje_Pantalla_Mapa` (`id_mapa`),
  KEY `FK_Puntaje_Pantalla_Juego` (`id_juego`),
  KEY `FK_Puntaje_Pantalla_Estrella` (`id_estrella`),
  CONSTRAINT `FK_Puntaje_Pantalla_Pantalla` FOREIGN KEY (`id_pantalla`) REFERENCES `pantalla` (`id_pantalla`),
  CONSTRAINT `FK_Puntaje_Pantallao_Mapa` FOREIGN KEY (`id_mapa`) REFERENCES `pantalla` (`id_mapa`),
  CONSTRAINT `FK_Puntaje_Pantalla_Juego` FOREIGN KEY (`id_juego`) REFERENCES `pantalla` (`id_juego`),
  CONSTRAINT `FK_Puntaje_Pantalla_Estrella` FOREIGN KEY (`id_estrella`) REFERENCES `estrella` (`id_estrella`)
);

CREATE TABLE IF NOT EXISTS `tipo_oferta` (
  `id_tipo_oferta` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(20),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_tipo_oferta`)
);

CREATE TABLE IF NOT EXISTS `oferta` (
  `id_juego` INT NOT NULL,
  `id_oferta` INT NOT NULL AUTO_INCREMENT,
  `id_tipo_oferta` INT NOT NULL,
  `titulo` varchar(50),
  `descripcion` varchar(200),
  `precio` double,
  `moneda` varchar(20),
  `simbolo` varchar(5),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_oferta`,`id_juego`),
  KEY `FK_Oferta_Juego` (`id_juego`),
  KEY `FK_Oferta_Tipo_Oferta` (`id_tipo_oferta`),
  CONSTRAINT `FK_Oferta_Juego` FOREIGN KEY (`id_juego`) REFERENCES `juego` (`id_juego`),
  CONSTRAINT `FK_Oferta_Tipo_Oferta` FOREIGN KEY (`id_tipo_oferta`) REFERENCES `tipo_oferta` (`id_tipo_oferta`)
);

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_juego` INT NOT NULL,
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre_completo` varchar(100),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(20),
  `contrasenia` varchar(15),
  `nombre_usuario` varchar(30),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_usuario`,`id_juego`),
  KEY `FK_Usuario_Juego` (`id_juego`),
  CONSTRAINT `FK_Usuario_Juego` FOREIGN KEY (`id_juego`) REFERENCES `juego` (`id_juego`)
);

CREATE TABLE IF NOT EXISTS `tipo_jugador` (
  `id_tipo_jugador` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_tipo_jugador`)
);

CREATE TABLE IF NOT EXISTS `jugador` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `id_tipo_jugador` INT,
  `puntaje` INT,
  PRIMARY KEY (`id_usuario`),
  KEY `FK_Jugador_Usuario` (`id_usuario`),
  KEY `FK_Jugador_Tipo_Jugador` (`id_tipo_jugador`),
  CONSTRAINT `FK_Jugador_Usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FK_Jugador_Tipo_Jugador` FOREIGN KEY (`id_tipo_jugador`) REFERENCES `tipo_jugador` (`id_tipo_jugador`)
);

CREATE TABLE IF NOT EXISTS `tipo_mensaje` (
  `id_usuario` INT NOT NULL,
  `id_tipo_mensaje` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(30),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_tipo_mensaje`, `id_usuario`),
  KEY `FK_Tipo_Mensaje_Jugador` (`id_usuario`),
  CONSTRAINT `FK_Tipo_Mensaje_Jugador` FOREIGN KEY (`id_usuario`) REFERENCES `jugador` (`id_usuario`)
);

CREATE TABLE IF NOT EXISTS `mensaje` (
  `id_usuario` INT NOT NULL,
  `id_tipo_mensaje` INT NOT NULL,
  `id_mensaje` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(20),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  `fecha_desde` DATE,
  `fecha_hasta` DATE,
  PRIMARY KEY (`id_mensaje`, `id_tipo_mensaje`, `id_usuario`),
   KEY `FK_Mensaje_Jugador` (`id_usuario`),
   KEY `FK_Mensaje_Tipo_Mensaje` (`id_tipo_mensaje`),
  CONSTRAINT `FK_Mensaje_Jugador` FOREIGN KEY (`id_usuario`) REFERENCES `jugador` (`id_usuario`),
  CONSTRAINT `FK_Mensaje_Tipo_Mensaje` FOREIGN KEY (`id_tipo_mensaje`) REFERENCES `tipo_mensaje` (`id_tipo_mensaje`)
);

CREATE TABLE IF NOT EXISTS `tipo_bonus` (
  `id_tipo_bonus` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(20), 
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_tipo_bonus`)
);

CREATE TABLE IF NOT EXISTS `bonus` (
  `id_usuario` INT NOT NULL,
  `id_bonus` INT NOT NULL AUTO_INCREMENT,
  `id_tipo_bonus` INT NOT NULL,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(20),
  `cant_bonus` int,
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_bonus`, `id_usuario`),
  KEY `FK_Bonus_Jugador` (`id_usuario`),
  KEY `FK_Bonus_Tipo_Bonus` (`id_tipo_bonus`),
  CONSTRAINT `FK_Bonus_Jugador` FOREIGN KEY (`id_usuario`) REFERENCES `jugador` (`id_usuario`),
  CONSTRAINT `FK_Bonus_Tipo_Bonus` FOREIGN KEY (`id_tipo_bonus`) REFERENCES `tipo_bonus` (`id_tipo_bonus`)
);

CREATE TABLE IF NOT EXISTS `lingote` (
  `id_usuario` INT NOT NULL,
  `id_lingote` INT NOT NULL AUTO_INCREMENT,
  `ubicacion` varchar(200),
  `descripcion` varchar(200),
  `archivo` varchar(20),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  `cant_monedas` INT,
  PRIMARY KEY (`id_lingote`, `id_usuario`),
   KEY `FK_Lingote_Jugador` (`id_usuario`),
  CONSTRAINT `FK_Lingote_Jugador` FOREIGN KEY (`id_usuario`) REFERENCES `jugador` (`id_usuario`)
);


/*puede haber futuras modificaciones en esta tabla*/
CREATE TABLE IF NOT EXISTS `corazon` (
  `id_usuario` INT NOT NULL,
  `id_corazon` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion` varchar(200),
  `archivo` varchar(20),
  `cant_vidas` INT,
   `es_infinito` BIT,
  `tiempo_prox_vida` DATETIME,
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_corazon`, `id_usuario`),
  KEY `FK_Corazon_Jugador` (`id_usuario`),
  CONSTRAINT `FK_Corazon_Jugador` FOREIGN KEY (`id_usuario`) REFERENCES `jugador` (`id_usuario`)
);

CREATE TABLE IF NOT EXISTS `registro_mapa` (
  `id_usuario` INT NOT NULL,
  `id_registro_mapa` INT NOT NULL AUTO_INCREMENT,
  `id_juego` INT NOT NULL,
  `id_mapa` INT NOT NULL,
  `titulo` varchar(50),
  `descripcion` varchar(200),
  `puntos_mapa` INT,
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_registro_mapa`, `id_usuario`),
  KEY `FK_Registro_Mapa_Jugador` (`id_usuario`),
  KEY `FK_Registro_Mapa_Mapa` (`id_mapa`),
   KEY `FK_Registro_Mapa_Juego` (`id_juego`),
  CONSTRAINT `FK_Registro_Mapa_Jugador` FOREIGN KEY (`id_usuario`) REFERENCES `jugador` (`id_usuario`),
  CONSTRAINT `FK_Registro_Mapa_Mapa` FOREIGN KEY (`id_mapa`) REFERENCES `mapa` (`id_mapa`),
  CONSTRAINT `FK_Registro_Mapa_Juego` FOREIGN KEY (`id_juego`) REFERENCES `juego` (`id_juego`)
);

/*puede haber futuras modificaciones en esta tabla*/
CREATE TABLE IF NOT EXISTS `registro_pantalla` (
  `id_usuario` INT NOT NULL,
  `id_registro_mapa` INT NOT NULL,
  `id_registro_pantalla` INT NOT NULL AUTO_INCREMENT,
  `id_juego` INT NOT NULL,
  `id_mapa` INT NOT NULL, 
  `id_pantalla` INT NOT NULL, 
  `titulo` varchar(50),
  `descripcion` varchar(200),
  `puntos_pantalla` INT,
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_registro_pantalla`, `id_registro_mapa`, `id_usuario`),
   KEY `FK_Registro_Pantalla_Registro_Mapa_` (`id_registro_mapa`),
   KEY `FK_Registro_Pantalla_Jugador` (`id_usuario`),
   KEY `FK_Registro_Pantalla_Juego` (`id_juego`),
   KEY `FK_Registro_Pantalla_Mapa` (`id_mapa`),
   KEY `FK_Registro_Pantalla_Pantalla` (`id_pantalla`),
   CONSTRAINT `FK_Registro_Pantalla_Registro_Mapa` FOREIGN KEY (`id_registro_mapa`) REFERENCES `registro_mapa` (`id_registro_mapa`),
  CONSTRAINT `FK_Registro_Pantalla_Jugador` FOREIGN KEY (`id_usuario`) REFERENCES `jugador` (`id_usuario`),
  CONSTRAINT `FK_Registro_Pantalla_Mapa` FOREIGN KEY (`id_mapa`) REFERENCES `mapa` (`id_mapa`),
  CONSTRAINT `FK_Registro_Pantalla_Juego` FOREIGN KEY (`id_juego`) REFERENCES `juego` (`id_juego`),
  CONSTRAINT `FK_Registro_Pantalla_Pantalla` FOREIGN KEY (`id_pantalla`) REFERENCES `pantalla` (`id_pantalla`)
);

CREATE TABLE IF NOT EXISTS `funcionalidad` (
  `id_juego` INT NOT NULL,
  `id_funcionalidad` INT NOT NULL AUTO_INCREMENT,
  `titulo` varchar(150) NOT NULL,
  `descripcion` varchar(200),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_funcionalidad`, `id_juego`),
   KEY `FK_Funcionalidad_Juego` (`id_juego`),
  CONSTRAINT `FK_Funcionalidad_Juego` FOREIGN KEY (`id_juego`) REFERENCES `juego` (`id_juego`)
);

CREATE TABLE IF NOT EXISTS `sub_funcionalidad` (
  `id_juego` INT NOT NULL,
  `id_funcionalidad` INT NOT NULL,
  `id_sub_funcionalidad` INT NOT NULL AUTO_INCREMENT,
  `titulo_sub` varchar(150) NOT NULL,
  `descripcion` varchar(200),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_sub_funcionalidad`,  `id_funcionalidad`, `id_juego`),
  KEY `FK_Sub_Funcionalidad_Funcionalidad` (`id_funcionalidad`),
  KEY `FK_Sub_Funcionalidad_Juego` (`id_juego`),
  CONSTRAINT `FK_Sub_Funcionalidad_Funcionalidad` FOREIGN KEY (`id_funcionalidad`) REFERENCES `funcionalidad` (`id_funcionalidad`),
  CONSTRAINT `FK_Sub_Funcionalidad_Juego` FOREIGN KEY (`id_juego`) REFERENCES `juego` (`id_juego`)
);

CREATE TABLE IF NOT EXISTS `tipo_permiso` (
  `id_tipo_permiso` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `desc_abreviada` varchar(10),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_tipo_permiso`)
);

CREATE TABLE IF NOT EXISTS `tipo_perfil` (
  `id_tipo_perfil` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `desc_abreviada` varchar(10),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_tipo_perfil`)
);

CREATE TABLE IF NOT EXISTS `permiso_funcionalidad` (
  `id_juego` INT NOT NULL,
  `id_funcionalidad` INT NOT NULL,
  `id_sub_funcionalidad` INT NOT NULL,
  `id_permiso_funcionalidad` INT NOT NULL AUTO_INCREMENT,
  `id_tipo_permiso` INT NOT NULL,
  `id_tipo_perfil` INT NOT NULL,  
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_permiso_funcionalidad`, `id_sub_funcionalidad`, `id_funcionalidad`,  `id_juego`),
   KEY `FK_Permiso_Funcionalidad_Sub_Funcionalidad` (`id_sub_funcionalidad`),
   KEY `FK_Permiso_Funcionalidad_Funcionalidad` (`id_funcionalidad`),
   KEY `FK_Permiso_Funcionalidad_Juego` (`id_juego`),
   KEY `FK_Permiso_Funcionalidad_Tipo_Permiso` (`id_tipo_permiso`),
   KEY `FK_Permiso_Funcionalidad_Tipo_Perfil` (`id_tipo_perfil`),
  CONSTRAINT `FK_Permiso_Funcionalidad_Sub_Funcionalidad` FOREIGN KEY (`id_sub_funcionalidad`) REFERENCES `sub_funcionalidad` (`id_sub_funcionalidad`),
  CONSTRAINT `FK_Permiso_Funcionalidad_Funcionalidad` FOREIGN KEY (`id_funcionalidad`) REFERENCES `funcionalidad` (`id_funcionalidad`),
  CONSTRAINT `FK_Permiso_Funcionalidad_Juego` FOREIGN KEY (`id_juego`) REFERENCES `juego` (`id_juego`),
  CONSTRAINT `FK_Permiso_Funcionalidad_Tipo_Permiso` FOREIGN KEY (`id_tipo_permiso`) REFERENCES `tipo_permiso` (`id_tipo_permiso`),
  CONSTRAINT `FK_Permiso_Funcionalidad_Tipo_Perfil` FOREIGN KEY (`id_tipo_perfil`) REFERENCES `tipo_perfil` (`id_tipo_perfil`)
);

CREATE TABLE IF NOT EXISTS `perfil_usuario` (
  `id_juego` INT NOT NULL,
  `id_usuario` INT NOT NULL,
  `id_perfil_usuario` INT NOT NULL,
  `id_tipo_perfil` INT NOT NULL,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_perfil_usuario`,  `id_usuario`, `id_juego`),
  KEY `FK_Perfil_Usuario_Tipo_Perfil` (`id_tipo_perfil`),
  KEY `FK_Perfil_Usuario_Usuario` (`id_usuario`),
   KEY `FK_Perfil_Usuario_Juego` (`id_juego`),
  CONSTRAINT `FK_Perfil_Usuario_Tipo_Perfil` FOREIGN KEY (`id_tipo_perfil`) REFERENCES `tipo_perfil` (`id_tipo_perfil`),
  CONSTRAINT `FK_Perfil_Usuario_Usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
 CONSTRAINT `FK_Perfil_Usuario_Juego` FOREIGN KEY (`id_juego`) REFERENCES `juego` (`id_juego`)
);

CREATE TABLE IF NOT EXISTS `imagen_mapa` (
  `id_juego` INT NOT NULL,
  `id_mapa` INT NOT NULL,
  `id_imagen_mapa` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30),
  `descripcion` varchar(200),
  `ubicacion_imagen` varchar(200),
  `archivo_imagen` varchar(20),
  `ubicacion_texto` varchar(200),
  `archivo_texto` varchar(20),
  `fecha_hecho` DATE,
  `fecha_baja` DATE,
  PRIMARY KEY (`id_imagen_mapa`, `id_mapa`, `id_juego`),
  KEY `FK_Mapa_Juego` (`id_juego`, `id_mapa`),
  CONSTRAINT `FK_Imagen_Mapa_Juego` FOREIGN KEY (`id_juego`) REFERENCES `juego` (`id_juego`),
   CONSTRAINT `FK_Imagen_Mapa_Mapa` FOREIGN KEY (`id_mapa`) REFERENCES `mapa` (`id_mapa`)
  );




/*-----------------------CREACIÓN DE PROCEDIMIENTOS!!!!-----------------------*/

/*------------------------------MAPA---------------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaMapa`(in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO mapa (id_juego, nombre, descripcion ,ubicacion, archivo, fecha_hecho, fecha_baja) 
	VALUES (1,pNombre, pDescripcion, pUbicacion, pArchivo , pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarMapa`(in `pIdMapa` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pFechaHecho` date)
BEGIN
	UPDATE mapa SET nombre = pNombre, descripcion = pDescripcion, ubicacion = pUbicacion,
    archivo = pArchivo, fecha_hecho = pFechaHecho
	WHERE id_juego = 1 and id_mapa = pIdMapa and fecha_baja is null;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarMapa`(in `pIdMapa` int)
BEGIN
	UPDATE mapa SET fecha_baja = now()
	WHERE id_juego = 1
    and id_mapa = pIdMapa and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoMapa`()
BEGIN
	SELECT * FROM mapa WHERE fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoMapaPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoMapaPorId`(in `pIdMapa` int)
BEGIN
	SELECT * FROM mapa 
    WHERE id_juego = 1 and id_mapa = pIdMapa and fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoMapasEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoMapasEliminados`()
BEGIN
	SELECT * FROM mapa 
    WHERE id_juego = 1 and fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarMapa`(in `pIdMapa` int)
BEGIN
	UPDATE mapa SET fecha_baja = null
	WHERE id_juego = 1
    and id_mapa = pIdMapa
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarMapaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarMapaDefinitivo`(in `pIdMapa` int)
BEGIN
	delete from `mapa` 
    where id_juego = 1
    and id_mapa = pIdMapa 
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaMapaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaMapaDefinitivo`()
BEGIN
	delete from `mapa` 
    where id_juego = 1
    and fecha_baja is not null;
END//
DELIMITER ;


/*--------------------------PANTALLA---------------------------------*/


DROP PROCEDURE IF EXISTS `spAltaPantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaPantalla`(in `pIdMapa` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pFechaHecho` date, out pId int)

BEGIN
	INSERT INTO pantalla (id_juego, id_mapa, nombre, descripcion ,ubicacion, archivo, fecha_hecho, fecha_baja) 
	VALUES (1, pIdMapa, pNombre, pDescripcion, pUbicacion, pArchivo , pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaPantalla(2,'Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarPantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarPantalla`(in `pIdMapa` int, in `pIdPantalla` int, 
in `pNombre` varchar(30), in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), 
in `pArchivo` varchar(20), in `pFechaHecho` date)
BEGIN
	UPDATE pantalla SET nombre = pNombre, descripcion = pDescripcion, ubicacion = pUbicacion,
    archivo = pArchivo, fecha_hecho = pFechaHecho
	WHERE id_juego = 1 
    and id_mapa = pIdMapa 
    and id_pantalla = pIdPantalla 
    and fecha_baja is null;
END//
DELIMITER ;

/*call spModificarPantalla(2,1,'Pantalla 2-1', 'Ingreso Prueba Pantalla 1 correspondiente al mapa 2', '/source', 'pantalla2-1.jpg', '2016-09-13');*/

DROP PROCEDURE IF EXISTS `spEliminarPantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarPantalla`(in `pIdMapa` int, in `pIdPantalla` int)
BEGIN
	UPDATE pantalla SET fecha_baja = now()
	WHERE id_juego = 1
    and id_mapa = pIdMapa
    and id_pantalla = pIdPantalla
    and fecha_baja is null;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `spObtenerListadoPantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoPantalla`()
BEGIN
	SELECT * FROM pantalla WHERE fecha_baja is null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoPantallaPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoPantallaPorId`(in `pIdMapa` int, in `pIdPantalla` int)
BEGIN
	SELECT * FROM pantalla 
    WHERE id_juego = 1 and id_mapa = pIdMapa and id_pantalla = pIdPantalla and fecha_baja is null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoPantallasEliminadas`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoPantallasEliminadas`()
BEGIN
	SELECT * FROM pantalla WHERE fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spReingresarPantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarPantalla`(in `pIdMapa` int, in `pIdPantalla` int)
BEGIN
	UPDATE pantalla SET fecha_baja = null
	WHERE id_juego = 1
    and id_mapa = pIdMapa
    and id_pantalla = pIdPantalla
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarPantallaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarPantallaDefinitivo`(in `pIdMapa` int, in `pIdPantalla` int)
BEGIN
	delete from `pantalla` 
    where id_juego = 1
    and id_mapa = pIdMapa 
    and id_pantalla = pIdPantalla
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaPantallaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaPantallaDefinitivo`()
BEGIN
	delete from `pantalla` 
    where id_juego = 1
    and fecha_baja is not null;
END//
DELIMITER ;

/*------------------------IMAGEN_MAPA---------------------------*/

DROP PROCEDURE IF EXISTS `spAltaImagenMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaImagenMapa`(in `pIdMapa` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion_imagen` varchar(200), in `pArchivo_imagen` varchar(20), 
in `pUbicacion_texto` varchar(200), in `pArchivo_texto` varchar(20), in `pFechaHecho` date, out `pId` int)

BEGIN
INSERT INTO imagen_mapa (`id_juego`,`id_mapa`,`nombre`,`descripcion`,
`ubicacion_imagen`,`archivo_imagen`,`ubicacion_texto`,`archivo_texto`,`fecha_hecho`,
`fecha_baja`)
VALUES(1, pIdMapa, pNombre, pDescripcion, pUbicacion_imagen, pArchivo_imagen,
pUbicacion_texto, pArchivo_texto, pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `spModificarImagenMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarImagenMapa`(in `pIdMapa` int, in `pIdImagenMapa` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion_imagen` varchar(200), in `pArchivo_imagen` varchar(20), 
in `pUbicacion_texto` varchar(200), in `pArchivo_texto` varchar(20), in `pFechaHecho` date, out pId int)
BEGIN

UPDATE `imagen_mapa`
SET `nombre` = pNombre, `descripcion` = pDescripcion, `ubicacion_imagen` = pUbicacion_Imagen,
`archivo_imagen` = pArchivo_Imagen, `ubicacion_texto` = pUbicacion_Texto,
`archivo_texto` = pArchivo_Texto, `fecha_hecho` = pFecha_Hecho
WHERE `id_juego` = 1 AND `id_mapa` = pIdMapa AND 
`id_imagen_mapa` = pIdImagenMapa and fecha_baja = null;

END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `spEliminarImagenMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarImagenMapa`(in `pIdMapa` int, in `pIdImagenMapa` int)
BEGIN
	UPDATE `imagen_mapa`
    SET `fecha_baja` = now()
    WHERE `id_juego` = 1 AND `id_mapa` = pIdMapa AND 
    `id_imagen_mapa` = pIdImagenMapa and fecha_baja = null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoImagenMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoImagenMapa`()
BEGIN
	select * from imagen_mapa  where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoImagenMapaPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoImagenMapaPorId`(in `pIdMapa` int, in `pIdImagenMapa` int)
BEGIN
select * from imagen_mapa WHERE `id_juego` = 1 AND `id_mapa` = pIdMapa AND 
`id_imagen_mapa` = pIdImagenMapa and fecha_baja = null;

END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoImagenMapasEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoImagenMapasEliminados`()
BEGIN
	SELECT * FROM imagen_mapa 
    WHERE id_juego = 1 and fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarImagenMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarImagenMapa`(in `pIdMapa` int, in `pIdImagenMapa` int)
BEGIN
	UPDATE imagen_mapa SET fecha_baja = null
	WHERE id_juego = 1
    and id_mapa = pIdMapa
    and id_imagen_mapa = pIdImagenMapa
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarImagenMapaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarImagenMapaDefinitivo`(in `pIdMapa` int, in `pIdImagenMapa` int)
BEGIN
	delete from `imagen_mapa` 
    where id_juego = 1
    and id_mapa = pIdMapa
    and id_imagen_mapa = pIdImagenMapa
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaImagenMapaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaImagenMapaDefinitivo`()
BEGIN
	delete from `imagen_mapa` 
    where id_juego = 1
    and fecha_baja is not null;
END//
DELIMITER ;

/*----------------------------TABLERO-----------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaTablero`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaTablero`(in `pIdMapa` int, in `pIdPantalla` int, 
in `pNombre` varchar(30), in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), 
in `pArchivo` varchar(20), in `pFechaHecho` date, out pId int)

BEGIN
	INSERT INTO `tablero` (`id_juego`, `id_mapa`, `id_pantalla`,  `nombre`, `descripcion`, 
`ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, pIdMapa, pIdPantalla, pNombre, pDescripcion, pUbicacion, pArchivo, pFecha_Hecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaPantalla(2,'Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarTablero`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarTablero`(in `pIdMapa` int, in `pIdPantalla` int, 
in `pIdTablero` int, in `pNombre` varchar(30), in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), 
in `pArchivo` varchar(20), in `pFechaHecho` date, out pId int)

BEGIN
	UPDATE `tablero` SET `nombre` = pNombre, `descripcion` = pDescripcion, `ubicacion` = pUbicacion,
    `archivo` = pArchivo, `fecha_hecho` = pFecha_Hecho
     WHERE `id_juego` = 1 AND `id_mapa` = pIdMapa AND `id_pantalla` = pIdPantalla 
     AND `id_tablero` = pIdTablero;
END//
DELIMITER ;

/*call spModificarPantalla(2,1,'Pantalla 2-1', 'Ingreso Prueba Pantalla 1 correspondiente al mapa 2', '/source', 'pantalla2-1.jpg', '2016-09-13');*/

DROP PROCEDURE IF EXISTS `spEliminarTablero`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTablero`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdTablero` int)
BEGIN
	UPDATE `tablero` SET `fecha_baja` = now()
	WHERE `id_juego` = 1 
	AND `id_mapa` = pIdMapa 
	AND `id_pantalla` = pIdPantalla 
	AND `id_tablero` = pIdTablero;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `spObtenerListadoTablero`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTablero`()
BEGIN
	SELECT * FROM tablero WHERE fecha_baja is null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoTableroPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTableroPorId`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdTablero` int)
BEGIN
	SELECT * FROM tablero 
    WHERE id_juego = 1 
    and id_mapa = pIdMapa 
    and id_pantalla = pIdPantalla
    and id_tablero = pIdTablero
    and fecha_baja is null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoTableroEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTableroEliminados`()
BEGIN
	SELECT * FROM tablero WHERE fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spReingresarTablero`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarTablero`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdTablero` int)
BEGIN
	UPDATE tablero SET fecha_baja = null
	WHERE id_juego = 1
    and id_mapa = pIdMapa
    and id_pantalla = pIdPantalla
    and id_tablero = pIdTablero
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarTableroDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTableroDefinitivo`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdTablero` int)
BEGIN
	DELETE FROM `tablero`
	WHERE fecha_baja is not null
	and id_mapa = pIdMapa
	and id_pantalla = pIdPantalla
	and id_tablero = pIdTablero
	and id_juego = 1;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaTableroDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaTableroDefinitivo`()
BEGIN
	DELETE FROM `tablero`
	WHERE fecha_baja is not null
	and id_juego = 1;
END//
DELIMITER ;

/*---------------------------CUADRADO------------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaCuadrado`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaCuadrado`(in `pIdMapa` int, in `pIdPantalla` int, 
in `pIdTablero` int, in `pNombre` varchar(30), in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), 
in `pArchivo` varchar(20), in `pFechaHecho` date, out pId int)

BEGIN
	INSERT INTO `cuadrado` (`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero` ,`nombre`, `descripcion`, 
`ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, pIdMapa, pIdPantalla, pNombre, pIdTablero, pDescripcion, pUbicacion, pArchivo, pFecha_Hecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaPantalla(2,'Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarCuadrado`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarCuadrado`(in `pIdMapa` int, in `pIdPantalla` int, 
in `pIdTablero` int, in `pIdCuadrado` int, in `pNombre` varchar(30), in `pDescripcion` varchar(200), 
in `pUbicacion` varchar(200), in `pArchivo` varchar(20), in `pFechaHecho` date)

BEGIN
	UPDATE `cuadrado` SET `nombre` = pNombre, `descripcion` = pDescripcion, `ubicacion` = pUbicacion,
    `archivo` = pArchivo, `fecha_hecho` = pFecha_Hecho
     WHERE `id_juego` = 1 AND `id_mapa` = pIdMapa AND `id_pantalla` = pIdPantalla 
     AND `id_tablero` = pIdTablero and `id_cuadrado` = pIdCuadrado;
END//
DELIMITER ;

/*call spModificarPantalla(2,1,'Pantalla 2-1', 'Ingreso Prueba Pantalla 1 correspondiente al mapa 2', '/source', 'pantalla2-1.jpg', '2016-09-13');*/

DROP PROCEDURE IF EXISTS `spEliminarCuadrado`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarCuadrado`(in `pIdMapa` int, in `pIdPantalla` int, 
in `pIdTablero` int, in `pIdCuadrado` int)
BEGIN
	UPDATE `cuadrado` SET `fecha_baja` = now()
	WHERE `id_juego` = 1 
	AND `id_mapa` = pIdMapa 
	AND `id_pantalla` = pIdPantalla 
	AND `id_tablero` = pIdTablero
    AND `id_cuadrado` = pIdCuadrado;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `spObtenerListadoCuadrado`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoCuadrado`()
BEGIN
	SELECT * FROM cuadrado WHERE fecha_baja is null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoCuadradoPorIdTablero`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoCuadradoPorIdTablero`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdTablero` int)
BEGIN
	SELECT * FROM cuadrado 
    WHERE id_juego = 1 
    and id_mapa = pIdMapa 
    and id_pantalla = pIdPantalla
    and id_tablero = pIdTablero
    and fecha_baja is null;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `spObtenerListadoCuadradoPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoCuadradoPorId`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdTablero` int, in `pIdCuadrado` int)
BEGIN
	SELECT * FROM cuadrado 
    WHERE id_juego = 1 
    and id_mapa = pIdMapa 
    and id_pantalla = pIdPantalla
    and id_tablero = pIdTablero
    and id_cuadrado = pIdCuadrado
    and fecha_baja is null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoCuadradoEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoCuadradoEliminados`()
BEGIN
	SELECT * FROM cuadrado WHERE fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spReingresarCuadrado`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarCuadrado`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdTablero` int, in `pIdCuadrado` int)
BEGIN
	UPDATE cuadrado SET fecha_baja = null
	WHERE id_juego = 1
    and id_mapa = pIdMapa
    and id_pantalla = pIdPantalla
    and id_tablero = pIdTablero
    and id_cuadrado = pIdCuadrado
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarCuadradoDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarCuadradoDefinitivo`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdTablero` int, in `pIdCuadrado` int)
BEGIN
	DELETE FROM `cuadrado`
	WHERE fecha_baja is not null
	and id_mapa = pIdMapa
	and id_pantalla = pIdPantalla
	and id_tablero = pIdTablero
    and id_cuadrado = pIdCuadrado
	and id_juego = 1;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaCuadradoDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaCuadradoDefinitivo`()
BEGIN
	DELETE FROM `cuadrado`
	WHERE fecha_baja is not null
	and id_juego = 1;
END//
DELIMITER ;

/*---------------------------FUNCIONALIDAD--------------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaFuncionalidad`(in `pTitulo` varchar(150), in `pDescripcion` varchar(200), 
in pFechaHecho date)

BEGIN
INSERT INTO `funcionalidad`
(`id_juego`, `titulo`, `descripcion`,
`fecha_hecho`, `fecha_baja`)
VALUES
(1, pTitulo, pDescripcion, pFechaHecho, null);

END//
DELIMITER ;



DROP PROCEDURE IF EXISTS `spModificarFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarFuncionalidad`(in `pIdFuncionalidad` int, in `pTitulo` varchar(150), 
in `pDescripcion` varchar(200), in `pFechaHecho` date)
BEGIN

UPDATE `funcionalidad`
SET `titulo` = pTitulo, `descripcion` = pDescripcion,
`fecha_hecho` = pFechaHecho
WHERE `id_juego` = 1 AND `id_funcionalidad` = pIdFuncionalidad;

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarFuncionalidad`(in `pIdFuncionalidad` int)
BEGIN
	UPDATE `funcionalidad`
    SET `fecha_baja` = now()
    WHERE `id_juego` = 1 AND `id_funcionalidad` = pIdFuncionalidad;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoFuncionalidad`()
BEGIN
	select * from funcionalidad  where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoFuncionalidadPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoFuncionalidadPorId`(in `pIdFuncionalidad` int)
BEGIN
select * from funcionalidad where id_juego = 1 
and id_funcionalidad = pIdFuncionalidad and fecha_baja is null;

END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoFuncionalidadEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoFuncionalidadEliminados`()
BEGIN
	SELECT * FROM funcionalidad
    WHERE id_juego = 1 and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoFuncionalidadEliminadosPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoFuncionalidadEliminadosPorId`(in pIdFuncionalidad int)
BEGIN
	SELECT * FROM funcionalidad WHERE id_juego = 1 and id_funcionalidad = pIdFuncionalidad
    and fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarFuncionalidad`(in `pIdFuncionalidad` int)
BEGIN
	UPDATE funcionalidad SET fecha_baja = null
	WHERE id_juego = 1
    and id_funcionalidad = pIdFuncionalidad
    and fecha_baja is not null;

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarFuncionalidadDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarFuncionalidadDefinitivo`(in `pIdFuncionalidad` int)
BEGIN
	delete from `funcionalidad` 
    where id_juego = 1
    and id_funcionalidad = pIdFuncionalidad
    and fecha_baja is not null;

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaFuncionalidadDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaFuncionalidadDefinitivo`()
BEGIN
	delete from `funcionalidad` 
    where id_juego = 1
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spVerSiguienteIdFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spVerSiguienteIdFuncionalidad`()
BEGIN
select ifnull(max(id_funcionalidad),0) + 1 from funcionalidad;
END//
DELIMITER ;


/*--------------------------SUBFUNCIONALIDAD---------------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaSubFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaSubFuncionalidad`(in `pIdFuncionalidad` int, in `pTitulo_Sub` varchar(150), in `pDescripcion` varchar(200), 
in pFecha_hecho date)

BEGIN
INSERT INTO `sub_funcionalidad`
(`id_juego`, `id_funcionalidad`, `titulo_sub`, `descripcion`,
`fecha_hecho`, `fecha_baja`)
VALUES
(1, pIdFuncionalidad, pTitulo_Sub, pDescripcion, pFecha_hecho,
null);

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spModificarSubFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarSubFuncionalidad`(in `pIdFuncionalidad` int, in `pIdSubFuncionalidad` int ,
in `pTitulo` varchar(150), in `pDescripcion` varchar(200), in pFechaHecho date)
BEGIN

UPDATE `sub_funcionalidad`
SET `titulo_sub` = pTitulo, `descripcion` = pDescripcion,
`fecha_hecho` = pFechaHecho
WHERE `id_juego` = 1 AND `id_funcionalidad` = pIdFuncionalidad and `id_sub_funcionalidad` = pIdSubFuncionalidad;

END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `spEliminarSubFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarSubFuncionalidad`(in `pIdFuncionalidad` int, in `pIdSubFuncionalidad` int)
BEGIN
	UPDATE `sub_funcionalidad`
    SET `fecha_baja` = now()
    WHERE `id_juego` = 1 AND `id_funcionalidad` = pIdFuncionalidad and `id_sub_funcionalidad` = pIdSubFuncionalidad;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarSubFuncionalidadPorIdFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarSubFuncionalidadPorIdFuncionalidad`(in `pIdFuncionalidad` int)
BEGIN
	UPDATE `sub_funcionalidad`
    SET `fecha_baja` = now()
    WHERE `id_juego` = 1 AND `id_funcionalidad` = pIdFuncionalidad;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoSubFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoSubFuncionalidad`()
BEGIN
	select * from sub_funcionalidad  where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoSubFuncionalidadPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoSubFuncionalidadPorId`(in `pIdFuncionalidad` int, in `pIdSubFuncionalidad` int)
BEGIN
select * from sub_funcionalidad where id_juego = 1 
and id_funcionalidad = pIdFuncionalidad
and id_sub_funcionalidad = pIdSubFuncionalidad 
and fecha_baja is null;

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoSubFuncionalidadPorIdDos`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoSubFuncionalidadPorIdDos`(in `pIdFuncionalidad` int)
BEGIN
select * from sub_funcionalidad where id_juego = 1 
and id_funcionalidad = pIdFuncionalidad and fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoSubFuncionalidadEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoSubFuncionalidadEliminados`()
BEGIN
	SELECT * FROM sub_funcionalidad
    WHERE id_juego = 1 and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoSubFuncionalidadEliminadosPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoSubFuncionalidadEliminadosPorId`(in pIdFuncionalidad int)
BEGIN
	SELECT * FROM sub_funcionalidad WHERE id_juego = 1 and id_funcionalidad = pIdFuncionalidad
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spBuscarSubFuncionalidadEliminada`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spBuscarSubFuncionalidadEliminada`(in pIdFuncionalidad int, in pIdSubFuncionalidad int)
BEGIN
	SELECT * FROM sub_funcionalidad WHERE id_juego = 1 and id_funcionalidad = pIdFuncionalidad
    and id_sub_funcionalidad = pIdSubFuncionalidad and fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoSubFuncionalidadEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarSubFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarSubFuncionalidad`(in `pIdFuncionalidad` int, in `pIdSubFuncionalidad` int)
BEGIN
	UPDATE sub_funcionalidad SET fecha_baja = null
	WHERE id_juego = 1
    and id_funcionalidad = pIdFuncionalidad
	and id_sub_funcionalidad = pIdSubFuncionalidad
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarSubFuncionalidadDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarSubFuncionalidadDefinitivo`(in `pIdFuncionalidad` int, in `pIdSubFuncionalidad` int)
BEGIN
	delete from `sub_funcionalidad` 
    where id_juego = 1
    and id_funcionalidad = pIdFuncionalidad
    and id_sub_funcionalidad = pIdSubFuncionalidad
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaSubFuncionalidadDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaSubFuncionalidadDefinitivo`()
BEGIN
	delete from `sub_funcionalidad` 
    where id_juego = 1
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spVerSiguienteIdSubFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spVerSiguienteIdSubFuncionalidad`(in pIdFuncionalidad int)
BEGIN
select ifnull(max(id_sub_funcionalidad),0) + 1  from sub_funcionalidad where id_funcionalidad = pIdFuncionalidad;
END//
DELIMITER ;


/*---------------------------TIPO_CUADRADO-------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaTipoCuadrado`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaTipoCuadrado`(in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO `tipo_cuadrado`(`nombre`, `descripcion`, `ubicacion`, `archivo`,
`fecha_hecho`, `fecha_baja`)
VALUES (pNombre, pDescripcion, pUbicacion, pArchivo,
pFecha_Hecho, null);
u
SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarTipoCuadrado`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarTipoCuadrado`(in `pIdTipoCuadrado` int, 
in `pNombre` varchar(30), in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), 
in `pArchivo` varchar(20), in `pFechaHecho` date, out `pId` int)
BEGIN
	UPDATE tipo_cuadrado SET
	nombre = pNombre, descripcion = pDescripcion, ubicacion = pUbicacion,
    archivo = pArchivo, fecha_hecho = pFecha_Hecho
	where id_tipo_cuadrado = pIdTipoCuadrado;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarTipoCuadrado`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoCuadrado`(in `pIdMapa` int)
BEGIN
	UPDATE tipo_cuadrado SET
	fecha_baja = now()
    where id_tipo_cuadrado = pIdTipoCuadrado
    and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoCuadrado`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoCuadrado`()
BEGIN
	SELECT * FROM tipo_cuadrado WHERE fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoCuadradoPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoCuadradoPorId`(in `pIdTipoCuadrado` int)
BEGIN
	SELECT * FROM tipo_cuadrado 
    WHERE id_tipo_cuadrado = pIdTipoCuadrado 
    and fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoCuadradoEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoCuadradoEliminados`()
BEGIN
	SELECT * FROM tipo_cuadrado where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarTipoCuadrado`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarTipoCuadrado`(in `pIdTipoCuadrado` int)
BEGIN
	UPDATE tipo_cuadrado SET
	fecha_baja = null
	where id_tipo_cuadrado = pIdTipoCuadrado
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarTipoCuadradoDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoCuadradoDefinitivo`(in `pIdTipoCuadrado` int)
BEGIN
	DELETE FROM tipo_cuadrado
	where id_tipo_cuadrado = pIdTipoCuadrado
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaTipoCuadradoDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaTipoCuadradoDefinitivo`()
BEGIN
	DELETE FROM tipo_cuadrado
	where fecha_baja is not null;
END//
DELIMITER ;

/*-----------------------------FICHA-----------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaFicha`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaFicha`(in `pId_Modelo` int, in `pNumeroFicha` int, in `pPuntajeFicha` int
, in `pNombre` varchar(30), in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), 
in `pArchivo` varchar(20), in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO `ficha`(`id_juego`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,`nombre`,
    `descripcion`,`ubicacion`,`archivo`,`fecha_hecho`,`fecha_baja`)
VALUES (1, pIdModelo, pNumeroFicha, pPuntajeFicha, pNombre, pDescripcion,
pUbicacion, pArchivo, pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarFicha`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarFicha`(in `pIdFicha` int, in `pId_Modelo` int, 
in `pNumeroFicha` int, in `pPuntajeFicha` int, in `pNombre` varchar(30), in `pDescripcion` varchar(200), 
in `pUbicacion` varchar(200), in `pArchivo` varchar(20), in `pFechaHecho` date)
BEGIN
	UPDATE `ficha` SET `id_modelo` = pIdModelo, 
	`numero_ficha` = pIdNumero_Ficha, `puntaje_ficha` = pPuntaje_Ficha, 
	`nombre` = pNombre,`descripcion` = pDescripcion, 
	`ubicacion` = pUbicacion,`archivo` = pArchivo, 
	`fecha_hecho` = pFecha_Hecho
	WHERE `id_juego` = 1 AND `id_ficha` = pIdFicha;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarFicha`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarFicha`(in `pIdFicha` int)
BEGIN
	UPDATE `ficha` SET  `fecha_baja` = now()
    WHERE `id_juego` = 1 AND `id_ficha` = pIdFicha
    and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoFicha`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoFicha`()
BEGIN
	SELECT * FROM ficha WHERE fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoFichaPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoFichaPorId`(in `pIdFicha` int)
BEGIN
	SELECT * FROM ficha 
    WHERE id_juego = 1 and id_ficha = pIdFicha and fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoFichasEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoFichasEliminados`()
BEGIN
	SELECT * FROM ficha 
    WHERE id_juego = 1 and fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarFicha`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarFicha`(in `pIdFicha` int)
BEGIN
	UPDATE `ficha` SET  `fecha_baja` = null
    WHERE `id_juego` = 1 AND `id_ficha` = pIdFicha
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarFichaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarFichaDefinitivo`(in `pIdFicha` int)
BEGIN
	delete from `ficha` 
    where id_juego = 1
    and id_ficha= pIdFicha
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaFichaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaFichaDefinitivo`()
BEGIN
	delete from `ficha` 
    where id_juego = 1
    and fecha_baja is not null;
END//
DELIMITER ;

/*---------------------------MODELO---------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaModelo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaModelo`(in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pFechaHecho` date, out `pId` int)

BEGIN
INSERT INTO `modelo` (`nombre`, `descripcion`, `ubicacion`, `archivo`,
`fecha_hecho`, `fecha_baja`)
VALUES (pNombre, pDescripcion, pUbicacion, pArchivo, pFecha_Hecho,
null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarModelo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarModelo`(in `pIdModelo` int, 
in `pNombre` varchar(30), in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), 
in `pArchivo` varchar(20), in `pFechaHecho` date, out `pId` int)
BEGIN
UPDATE `modelo` SET
`nombre` = pNombre, `descripcion` = pDescripcion, `ubicacion` = pUbicacion,
`archivo` = pArchivo, `fecha_hecho` = pFecha_Hecho
WHERE `id_modelo` = pIdModelo;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarModelo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarModelo`(in `pIdModelo` int)
BEGIN
UPDATE `modelo` SET `fecha_baja` = now() 
WHERE `id_modelo` = pIdModelo;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoModelo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoModelo`()
BEGIN
	select * from `modelo` where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoModeloPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoModeloPorId`(in `pIdModelo` int)
BEGIN
	select * from `modelo` where id_modelo = pIdModelo  
    and fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoModeloEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoModeloEliminados`()
BEGIN
	select * from `modelo` where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarModelo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarModelo`(in `pIdModelo` int)
BEGIN
	UPDATE modelo SET
	fecha_baja = null
	where id_modelo = pIdModelo
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarModeloDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarModeloDefinitivo`(in `pIdModelo` int)
BEGIN
	DELETE FROM `modelo`
	WHERE id_modelo = pIdModelo
	AND fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaModeloDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaModeloDefinitivo`()
BEGIN
	DELETE FROM `modelo`
	WHERE fecha_baja is not null;
END//
DELIMITER ;

/*------------------------IMAGEN_JUEGO------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaImagenJuego`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaImagenJuego`(in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO `imagen_juego` (`id_juego`, `nombre`, `descripcion`, `ubicacion`, 
	`archivo`, `fecha_hecho`, `fecha_baja`)
	VALUES
	(1, pNombre, pDescripcion, pUbicacion, pArchivo, pFecha_Hecho);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarImagenJuego`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarImagenJuego`(in `pIdImagenJuego` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pFechaHecho` date)
BEGIN
	UPDATE `imagen_juego`
	SET `nombre` = pNombre, `descripcion` = pDescripcion, `ubicacion` = pUbicacion,
	`archivo` = pArchivo, `fecha_hecho` = pFecha_Hecho, `fecha_baja` = pFecha_Baja
	WHERE `id_juego` = 1 AND `id_imagen_juego` = pIdImagenJuego;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarImagenJuego`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarImagenJuego`(in `pIdImagenJuego` int)
BEGIN
	UPDATE `imagen_juego`
	SET `fecha_baja` = now()
	WHERE `id_juego` = 1 AND 
	`id_imagen_juego` = pIdImagenJuego
	and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoImagenJuego`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoImagenJuego`()
BEGIN
	select * from imagen_juego where fecha_baja is null ;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoImagenJuegoPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoImagenJuegoPorId`(in `pIdImagenJuego` int)
BEGIN
	SELECT * FROM imagen_juego 
    WHERE id_juego = 1 and id_imagen_juego = pIdImagenJuego and fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoImagenJuegoEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoImagenJuegoEliminados`()
BEGIN
	select * from  imagen_juego where `id_juego` = 1 
    and fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarImagenJuego`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarImagenJuego`(in `pIdImagenJuego` int)
BEGIN
	UPDATE `imagen_juego`
	SET `fecha_baja` = null
	WHERE `id_juego` = 1 AND 
	`id_imagen_juego` = pId_Imagen_Juego
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarImagenJuegoDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarImagenJuegoDefinitivo`(in `pIdMapa` int)
BEGIN
	DELETE FROM `imagen_juego`
	WHERE id_juego = 1
	and `id_imagen_juego` = pId_Imagen_Juego
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaImagenJuegoDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaImagenJuegoDefinitivo`()
BEGIN
	DELETE FROM `imagen_juego`
	WHERE id_juego = 1
	and fecha_baja is not null;
END//
DELIMITER ;

/*----------------------------OFERTA------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaOferta`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaOferta`(in `pIdTipoOferta` int, 
in `pTitulo` varchar(50), in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO `oferta` (`id_juego`, `id_tipo_oferta`, `titulo`, `descripcion`, 
    `precio`, `moneda`, `simbolo`, `fecha_hecho`, `fecha_baja`)
	VALUES
	(1, pId, pIdTipoOferta, pTitulo, pDescripcion, pPrecio,
	pMoneda, pSimbolo, pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarOferta`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarOferta`(in `pIdOferta` int, in `pIdTipoOferta` int, 
in `pTitulo` varchar(50), in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pFechaHecho` date, out `pId` int)
BEGIN
	UPDATE `oferta` SET
	`id_tipo_oferta` = pIdTipoOferta, `titulo` = pTitulo, `descripcion` = pDescripcion,
	`precio` = pPrecio, `moneda` = pMoneda, `simbolo` = pSimbolo,
	`fecha_hecho` = pFechaHecho
	WHERE `id_juego` = 1 AND `id_oferta` = pIdOferta;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarOferta`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarOferta`(in `pIdOferta` int)
BEGIN
	UPDATE `oferta` SET `fecha_baja` = now()
	WHERE `id_juego` = 1 AND `id_oferta` = pIdOferta
	and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoOferta`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoOferta`()
BEGIN
	select * from oferta where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoOfertaPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoOfertaPorId`(in `pIdOferta` int)
BEGIN
          select * from oferta where id_oferta = pIdOferta and fecha_baja is null;
END//
DELIMITER;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoOfertaEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoOfertaEliminados`()
BEGIN
	select * from  oferta where `id_juego` = 1 
    and fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarOferta`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarOferta`(in `pIdOferta` int)
BEGIN
	UPDATE `oferta`
	SET `fecha_baja` = null
	WHERE `id_juego` = 1 AND 
	`id_oferta` = pIdOferta
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarOfertaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarOfertaDefinitivo`(in `pIdMapa` int)
BEGIN
	DELETE FROM `oferta`
	WHERE id_juego = 1 
	and id_oferta = pIdOferta
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaOfertaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaOfertaDefinitivo`()
BEGIN
	DELETE FROM `oferta`
	WHERE id_juego = 1 and fecha_baja is not null;
END//
DELIMITER ;


/*--------------------------TIPO_OFERTA----------------------------*/

DROP PROCEDURE IF EXISTS `spAltaTipoOferta`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaTipoOferta`( in `pNombre` varchar(50), in `pDescripcion` varchar(200), 
in `pUbicacion` varchar(200), in `pArchivo` varchar(20), in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO `tipo_oferta` (`nombre`,
	`descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
	VALUES
	(pNombre, pDescripcion, pUbicacion, pArchivo, pFecha_Hecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarTipoOferta`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarTipoOferta`(in `pIdOferta` int, in `pNombre` varchar(50), 
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pFechaHecho` date, out `pId` int)
BEGIN
	UPDATE `tipo_oferta` SET `nombre` = pNombre, `descripcion` = pDescripcion,
	`ubicacion` = pUbicacion, `archivo` = pArchivo, `fecha_hecho` = pFecha_Hecho
	WHERE `id_tipo_oferta` = pIdTipoOferta;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarTipoOferta`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoOferta`(in `pIdOferta` int)
BEGIN
	UPDATE `tipo_oferta` SET
	`fecha_baja` = now()
	WHERE `id_tipo_oferta` = pIdTipoOferta
	and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoOferta`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoOferta`()
BEGIN
	select * from tipo_oferta where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoOfertaPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoOfertaPorId`(in `pIdTipoOferta` int)
BEGIN
	select * from tipo_oferta  WHERE `id_tipo_oferta` = pIdTipoOferta  and fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoOfertaEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoOfertaEliminados`()
BEGIN
	select * from  oferta where `id_juego` = 1 
    and fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarTipoOferta`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarTipoOferta`(in `pIdOferta` int)
BEGIN
	UPDATE `oferta`
	SET `fecha_baja` = null
	WHERE `id_juego` = 1 AND 
	`id_oferta` = pIdOferta
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarTipoOfertaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoOfertaDefinitivo`(in `pIdMapa` int)
BEGIN
	DELETE FROM `oferta`
	WHERE id_juego = 1 
	and id_oferta = pIdOferta
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaTipoOfertaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaTipoOfertaDefinitivo`()
BEGIN
	DELETE FROM `oferta`
	WHERE id_juego = 1 and fecha_baja is not null;
END//
DELIMITER ;

/*----------------------------CONDICIONANTE------------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaCondicionante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaCondicionante`(in `pIdMapa` int, 
in `pIdPantalla` int, in `pTipoCondicionante` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pFechaHecho` date, out pId int)

BEGIN
INSERT INTO `condicionante`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tipo_condicionante`,
`nombre`, `descripcion`, `fecha_hecho`, `fecha_baja`)
VALUES(1, pIdMapa, pIdPantalla, pIdTipoCondicionante, pNombre , pDescripcion,
pFecha_Hecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaPantalla(2,'Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarCondicionante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarCondicionante`(in pIdCondicionante int, in `pIdMapa` int, 
in `pIdPantalla` int, in `pTipoCondicionante` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pFechaHecho` date)
BEGIN
	UPDATE `condicionante` SET `nombre` = pNombre, `descripcion` = pDescripcion,
	`fecha_hecho` = pFechaHecho, `fecha_baja` = pFechaBaja
	WHERE `id_juego` = 1 AND 
	`id_mapa` = pIdMapa AND 
	`id_pantalla` = pIdPantalla AND 
	`id_condicionante` = pIdCondicionante;
END//
DELIMITER ;

/*call spModificarPantalla(2,1,'Pantalla 2-1', 'Ingreso Prueba Pantalla 1 correspondiente al mapa 2', '/source', 'pantalla2-1.jpg', '2016-09-13');*/

DROP PROCEDURE IF EXISTS `spEliminarCondicionante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarCondicionante`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdCondicionante` int)
BEGIN
	UPDATE `condicionante` SET`fecha_baja` = now()
	WHERE `id_juego` = 1 AND `id_mapa` = pIdMapa and
	`id_pantalla` = pIdPantalla and `id_condicionante` = pIdCondicionante
	and fecha_baja is null;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `spObtenerListadoCondicionante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoCondicionante`()
BEGIN
	select * from condicionante where fecha_baja is null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoCondicionantePorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoCondicionantePorId`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdCondicionante` int)
BEGIN
	select * from condicionante where fecha_baja is null
	and `id_mapa` = pIdMapa and `id_pantalla` = pIdPantalla 
	and `id_condicionante` = pIdCondicionante;

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoCondicionanteEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoCondicionanteEliminados`()
BEGIN
	SELECT * FROM condicionante WHERE fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spReingresarCondicionante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarCondicionante`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdCondicionante` int)
BEGIN
	UPDATE `condicionante` SET `fecha_baja` = null
	WHERE `id_juego` = 1 AND `id_mapa` = pIdMapa AND 
	`id_pantalla` = pIdPantalla AND `id_condicionante` = pIdCondicionante
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarCondicionanteDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarCondicionanteDefinitivo`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdCondicionante` int)
BEGIN
	DELETE FROM `condicionante`
	WHERE `id_juego` = 1 
    and `id_mapa` = pIdMapa
    and `id_pantalla` = pIdPantalla
	and `id_condicionante` = pIdCondicionante
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaCondicionanteDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaCondicionanteDefinitivo`()
BEGIN	
    DELETE FROM `condicionante`
	WHERE `id_juego` = 1 
	and fecha_baja is not null;
END//
DELIMITER ;


/*---------------------------OBJETIVO-------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaObjetivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaObjetivo`(in `pIdMapa` int, 
in `pIdPantalla` int, in `pTipoObjetivo` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pFechaHecho` date, out pId int)

BEGIN
INSERT INTO `objetivo` (`id_juego`, `id_mapa`, `id_pantalla`, `id_tipo_objetivo`,
`nombre`, `descripcion`, `fecha_hecho`, `fecha_baja`)
VALUES (1, pIdMapa, pIdPantalla, pIdTipoObjetivo, pNombre,
pDescripcion, pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaPantalla(2,'Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarObjetivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarObjetivo`(in `pIdObjetivo` int, in `pIdMapa` int, 
in `pIdPantalla` int, in `pIdTipoObjetivo` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pFechaHecho` date)
BEGIN
	UPDATE `objetivo`
	SET `id_tipo_objetivo` = pIdTipoObjetivo,
	`nombre` = pNombre,
	`descripcion` = pDescripcion,
	`fecha_hecho` = pFechaHecho
	WHERE `id_juego` = 1 AND `id_mapa` = pIdMapa 
	AND `id_pantalla` = pIdPantalla 
	AND `id_objetivo` = pIdObjetivo;
END//
DELIMITER ;

/*call spModificarPantalla(2,1,'Pantalla 2-1', 'Ingreso Prueba Pantalla 1 correspondiente al mapa 2', '/source', 'pantalla2-1.jpg', '2016-09-13');*/

DROP PROCEDURE IF EXISTS `spEliminarObjetivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarObjetivo`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdObjetivo` int)
BEGIN
	UPDATE `objetivo` SET `fecha_baja` = now()
	WHERE `id_juego` = 1 AND `id_mapa` = pIdMapa 
	AND `id_pantalla` = pIdPantalla AND `id_objetivo` = pIdObjetivo
	and fecha_baja is null;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `spObtenerListadoObjetivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoObjetivo`()
BEGIN
	select * from objetivo where fecha_baja is null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoObjetivoPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoObjetivoPorId`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdObjetivo` int)
BEGIN
	select * from objetivo where `id_mapa` = pIdMapa 
	AND `id_pantalla` = pIdPantalla 
	AND `id_objetivo` = pIdObjetivo
	and fecha_baja is null;

END//
DELIMITER ;

select * from oferta;

DROP PROCEDURE IF EXISTS `spObtenerListadoObjetivoEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoObjetivoEliminados`()
BEGIN
	SELECT * FROM objetivo WHERE fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spReingresarObjetivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarObjetivo`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdCondicionante` int)
BEGIN
	UPDATE `objetivo` SET `fecha_baja` = null
	WHERE `id_juego` = 1 AND `id_mapa` = pIdMapa 
	AND `id_pantalla` = pIdPantalla 
	AND `id_objetivo` = pIdObjetivo
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarObjetivoDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarObjetivoDefinitivo`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdCondicionante` int)
BEGIN
	DELETE FROM `objetivo`
	WHERE `id_juego` = 1 AND `id_mapa` = pIdMapa 
	AND `id_pantalla` = pIdPantalla 
	AND `id_objetivo` = pIdObjetivo
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaObjetivoDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaObjetivoDefinitivo`()
BEGIN	
DELETE FROM `objetivo` WHERE `id_juego` = 1 AND fecha_baja is not null;
END//
DELIMITER ;


/*----------------------TIPO_CONDICIONANTE-------------------------*/

DROP PROCEDURE IF EXISTS `spAltaTipoCondicionante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaTipoCondicionante`(in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pFechaHecho` date, out `pId` int)

BEGIN
INSERT INTO `tipo_condicionante` (`nombre`, `descripcion`, `fecha_hecho`, `fecha_baja`) 
VALUES (pNombre, pDescripcion, pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarTipoCondicionante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarTipoCondicionante`(in `pIdTipoCondicionante` int, 
in `pNombre` varchar(30), in `pDescripcion` varchar(200), in `pFechaHecho` date)
BEGIN
	UPDATE `tipo_condicionante` SET `nombre` = pNombre,
	`descripcion` = pDescripcion,`fecha_hecho` = pFechaHecho
	WHERE `id_tipo_condicionante` = pIdTipoCondicionante;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarTipoCondicionante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoCondicionante`(in `pIdTipoCondicionante` int)
BEGIN
	UPDATE `tipo_condicionante` SET `fecha_baja` = now()
	WHERE `id_tipo_condicionante` = pIdTipoCondicionante
    and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoCondicionante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoCondicionante`()
BEGIN
	select * from tipo_condicionante where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoCondicionantePorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoCondicionantePorId`(in `pIdTipoCondicionante` int)
BEGIN
	select * from tipo_condicionante where 
	id_tipo_condicionante = pIdTipoCondicionante and fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoCondicionanteEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoCondicionanteEliminados`()
BEGIN
	select * from tipo_condicionante where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarTipoCondicionante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarTipoCondicionante`(in `pIdTipoCondicionante` int)
BEGIN
	UPDATE `tipo_condicionante` SET `fecha_baja` = null
	WHERE `id_tipo_condicionante` = pIdTipoCondicionante
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarTipoCondicionanteDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoCondicionanteDefinitivo`(in `pIdTipoCondicionante` int)
BEGIN
	DELETE FROM `tipo_condicionante`
	WHERE id_juego = 1
	and id_tipo_condicionante = pIdTipoCondicionante
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaTipoCondicionanteDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaTipoCondicionanteDefinitivo`()
BEGIN
	DELETE FROM `tipo_condicionante` WHERE id_juego = 1
	and fecha_baja is not null;
END//
DELIMITER ;

/*---------------------------TIPO_OBJETIVO------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaTipoObjetivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaTipoObjetivo`(in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pFechaHecho` date, out `pId` int)

BEGIN
INSERT INTO `tipo_objetivo` (`nombre`, `descripcion`, `fecha_hecho`, `fecha_baja`)
VALUES (pNombre, pDescripcion, pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarTipoObjetivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarTipoObjetivo`(in `pIdTipoObjetivo` int, 
in `pNombre` varchar(30), in `pDescripcion` varchar(200), in `pFechaHecho` date)
BEGIN
	UPDATE `tipo_objetivo` SET `nombre` = pNombre,
	`descripcion` = pDescripcion, `fecha_hecho` = pFechaHecho
	WHERE `id_tipo_objetivo` = pIdObjetivo;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarTipoObjetivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoObjetivo`(in `pIdTipoObjetivo` int)
BEGIN
	UPDATE `tipo_objetivo` SET `fecha_baja` = now()
	WHERE `id_tipo_objetivo` = pIdObjetivo
    and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoObjetivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoObjetivo`()
BEGIN
	select * from tipo_objetivo where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoObjetivoPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoObjetivoPorId`(in `pIdTipoObjetivo` int)
BEGIN
	select * from tipo_objetivo where id_tipo_objetivo = pIdTipoObjetivo 
	and fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoObjetivoEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoObjetivoEliminados`()
BEGIN
	select * from  tipo_objetivo where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarTipoObjetivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarTipoObjetivo`(in `pIdTipoObjetivo` int)
BEGIN
	UPDATE `tipo_objetivo` SET `fecha_baja` = null
	WHERE `id_tipo_objetivo` = pIdObjetivo
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarTipoObjetivoDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoObjetivoDefinitivo`(in `pIdTipoObjetivo` int)
BEGIN
	DELETE FROM `tipo_objetivo` 
	WHERE id_tipo_objetivo = pIdTipoObjetivo 
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaTipoObjetivoDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaTipoObjetivoDefinitivo`()
BEGIN
	DELETE FROM `tipo_objetivo` WHERE fecha_baja is not null;
END//
DELIMITER ;

/*-------------------------PUNTAJE_PANTALLA-------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaPuntajePantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaPuntajePantalla`(in `pIdMapa` int, in `pIdPantalla` int,
in `pIdEstrella` int, in `pNombre` varchar(30), in `pDescripcion` varchar(200), in `pNivel` int, 
in `pPuntaje` int, in `pFechaHecho` date, out pId int)

BEGIN
	INSERT INTO `puntaje_pantalla` (`id_juego`, `id_mapa`, `id_pantalla`, `id_estrella`, 
	`nombre`, `descripcion`, `nivel`, `puntaje`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, pIdMapa, pIdPantalla, pIdEstrella, pNombre, pDescripcion, pNivel, pPuntaje, pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaPantalla(2,'Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarPuntajePantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarPuntajePantalla`(in `pIdPuntajePantalla` int, in `pIdMapa` int, 
in `pIdPantalla` int, in `pIdEstrella` int, in `pNombre` varchar(30), in `pDescripcion` varchar(200), 
in `pNivel` int, in `pPuntaje` int, in `pFechaHecho` date)

BEGIN
	UPDATE `puntaje_pantalla` SET `id_juego` = 1,
	`id_mapa` = pIdMapa, `id_pantalla` = pIdPantalla,
    `id_estrella` = pIdEstrella, `nombre` = pNombre,
	`descripcion` = pDescripcion, `nivel` = pNivel,
	`puntaje` = pPuntaje, `fecha_hecho` = pFechaHecho
	WHERE `id_juego` = 1  AND `id_mapa` = pIdMapa 
	AND `id_pantalla` = pIdPantalla 
	AND `id_puntaje_pantalla` = pIdPuntajePantalla;

END//
DELIMITER ;

/*call spModificarPantalla(2,1,'Pantalla 2-1', 'Ingreso Prueba Pantalla 1 correspondiente al mapa 2', '/source', 'pantalla2-1.jpg', '2016-09-13');*/

DROP PROCEDURE IF EXISTS `spEliminarPuntajePantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarPuntajePantalla`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdPuntajePantalla` int)
BEGIN
	UPDATE `puntaje_pantalla` SET `fecha_baja` = now()
	WHERE `id_juego` = 1 
	AND `id_mapa` = pIdMapa 
	AND `id_pantalla` = pIdPantalla 
	AND `id_puntaje_pantalla` = pIdPuntajePantalla
	and fecha_baja is null;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `spObtenerListadoPuntajePantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoPuntajePantalla`()
BEGIN
	SELECT * FROM puntaje_pantalla WHERE fecha_baja is null;
END//
DELIMITER ;



DROP PROCEDURE IF EXISTS `spObtenerListadoPuntajePantallaPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoPuntajePantallaPorId`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdPuntajePantalla` int)
BEGIN
	SELECT * FROM puntaje_pantalla
    WHERE `id_juego` = 1 
	AND `id_mapa` = pIdMapa 
	AND `id_pantalla` = pIdPantalla 
	AND `id_puntaje_pantalla` = pIdPuntajePantalla
	and fecha_baja is null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoPuntajePantallasEliminadas`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoPuntajePantallasEliminadas`()
BEGIN
	SELECT * FROM puntaje_pantalla WHERE fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spReingresarPuntajePantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarPuntajePantalla`(in `pIdMapa` int, in `pIdPantalla` int, in `pIdPuntajePantalla` int)
BEGIN
	UPDATE `puntaje_pantalla`
	SET `fecha_baja` = null
	WHERE `id_juego` = 1 
	AND `id_mapa` = pIdMapa 
	AND `id_pantalla` = pIdPantalla 
	AND `id_puntaje_pantalla` = pIdPuntajePantalla
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarPuntajePantallaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarPuntajePantallaDefinitivo`(in `pIdMapa` int, in `pIdPantalla` int, in `pPuntajePantalla` int)
BEGIN
	DELETE FROM `puntaje_pantalla`
	WHERE `id_juego` = 1 
	AND `id_mapa` = pIdMapa 
	AND `id_pantalla` = pIdPantalla 
	AND `id_puntaje_pantalla` = pIdPuntajePantalla
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaPuntajePantallaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaPuntajePantallaDefinitivo`()
BEGIN
	DELETE FROM `puntaje_pantalla`
	WHERE `id_juego` = 1 and fecha_baja is not null;
END//
DELIMITER ;

/*--------------------------ESTRELLA-------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaEstrella`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaEstrella`(in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO `estrella` (`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES(pNombre, pDescripcion, pUbicacion, pArchivo, pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarEstrella`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarEstrella`(in `pIdEstrella` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), in `pFechaHecho` date)
BEGIN
	UPDATE  `estrella` SET `nombre` = pNombre, `descripcion` = pDescripcion, `ubicacion` = pUbicacion, 
    `archivo` = pArchivo, `fecha_hecho` = pFechaHecho
	WHERE `id_estrella` = pIdEstrella;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarEstrella`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarEstrella`(in `pIdEstrella` int)
BEGIN
	UPDATE  `estrella` SET `fecha_baja` = now() WHERE `id_estrella` = pIdEstrella
	and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoEstrella`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoEstrella`()
BEGIN
	select * from estrella where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoEstrellaPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoEstrellaPorId`(in `pIdEstrella` int)
BEGIN
	select * from estrella where fecha_baja is null 
	and id_estrella = pIdEstrella;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoEstrellaEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoEstrellaEliminados`()
BEGIN
	select * from estrella where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarEstrella`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarEstrella`(in `pIdEstrella` int)
BEGIN
	UPDATE  `estrella` SET `fecha_baja` = null
	WHERE `id_estrella` = pIdEstrella
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarEstrellaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarEstrellaDefinitivo`(in `pIdEstrella` int)
BEGIN
	DELETE FROM `estrella` WHERE `id_estrella` = pIdEstrella
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaEstrellaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaEstrellaDefinitivo`()
BEGIN
	DELETE FROM `estrella` where fecha_baja is not null;
END//
DELIMITER ;

/*------------------------USUARIO-----------------------------*/

DROP PROCEDURE IF EXISTS `spAltaUsuario`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaUsuario`(in `pNombreCompleto` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pContrasenia` varchar(15), in `pNombreUsuario` varchar(30), in `pFechaHecho` date)

BEGIN
	INSERT INTO `usuario` (`id_juego`, `nombre_completo`, `descripcion`,
	`ubicacion`, `archivo`, `contrasenia`, `nombre_usuario`,
	`fecha_hecho`, `fecha_baja`)
	VALUES (1, pNombreCompleto, pDescripcion, pUbicacion, pArchivo,
	pContrasenia, pNombreUsuario, pFechaHecho, null);

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarUsuario`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarUsuario`(in `pIdUsuario` int, in `pNombreCompleto` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pContrasenia` varchar(15), in `pNombreUsuario` varchar(30), in `pFechaHecho` date)
BEGIN
	UPDATE `usuario` SET `nombre_completo` = pNombreCompleto,
	`descripcion` = pDescripcion, `ubicacion` = pUbicacion,
	`archivo` = pArchivo, `contrasenia` = pContrasenia,
	`nombre_usuario` = pNombreUsuario, `fecha_hecho` = pFechaHecho
	WHERE `id_juego` = 1 AND `id_usuario` = pIdUsuario;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarUsuario`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarUsuario`(in `pIdUsuario` int)
BEGIN
	UPDATE `usuario` SET `fecha_baja` = now()
	WHERE `id_juego` = 1 AND `id_usuario` = pIdUsuario
	and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoUsuario`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoUsuario`()
BEGIN
	select * from usuario where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoUsuarioPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoUsuarioPorId`(in `pIdUsuario` int)
BEGIN
	select * from usuario where fecha_baja is null and`id_juego` = 1 
	AND `id_usuario` = pIdUsuario;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoUsuarioEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoUsuarioEliminados`()
BEGIN
	select * from usuario where fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoUsuarioEliminadosPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoUsuarioEliminadosPorId`(in pIdUsuario int)
BEGIN
	select * from usuario where id_usuario = pIdUsuario and fecha_baja is not null;
END//
DELIMITER ;


/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarUsuario`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarUsuario`(in `pIdUsuario` int)
BEGIN
	UPDATE `usuario` SET `fecha_baja` = null
	WHERE `id_juego` = 1 AND `id_usuario` = pIdUsuario
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarUsuarioDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarUsuarioDefinitivo`(in `pIdUsuario` int)
BEGIN
	DELETE FROM `usuario`
	WHERE `id_juego` = 1 AND `id_usuario` = pIdUsuario
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaUsuarioDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaUsuarioDefinitivo`()
BEGIN
	DELETE FROM `usuario` where fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spVerSiguienteIdUsuario`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spVerSiguienteIdUsuario`()
BEGIN
	SELECT AUTO_INCREMENT FROM information_schema.TABLES
	WHERE TABLE_SCHEMA = 'adventure_scrabble' 
	AND TABLE_NAME = 'usuario';
END//
DELIMITER ;

/*---------------------------JUGADOR-------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaJugador`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaJugador`(in `pIdTipoJugador` int, 
in `pPuntaje` int, out `pId` int)

BEGIN
	INSERT INTO `jugador` (`id_tipo_jugador`,`puntaje`)
	VALUES(pIdTipoJugador, pPuntaje);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarJugador`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarJugador`(in `pIdUsuario` int, in `pIdTipoJugador` int, 
in `pPuntaje` int)

BEGIN
	UPDATE `jugador`
	SET `id_tipo_jugador` = pIdTipoJugador, `puntaje` = pPuntaje
	WHERE `id_usuario` = pIdUsuario;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spObtenerListadoJugador`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoJugador`()
BEGIN
	select u.id_juego, u.id_usuario, u.nombre_completo, u.descripcion,
	u.ubicacion, u.archivo, u.contrasenia, u.nombre_usuario, u.fecha_hecho,
	u.fecha_baja, j.id_tipo_jugador, j.puntaje 
	from usuario u, jugador j
	where u.id_usuario = j.id_usuario
	and u.fecha_baja is null;

END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoJugadorPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoJugadorPorId`(in `pIdUsuario` int)
BEGIN
	select u.id_juego, u.id_usuario, u.nombre_completo, u.descripcion,
	u.ubicacion, u.archivo, u.contrasenia, u.nombre_usuario, u.fecha_hecho,
	u.fecha_baja, j.id_tipo_jugador, j.puntaje 
	from usuario u, jugador j
	where u.id_usuario = j.id_usuario
	and u.fecha_baja is null
	and u.id_juego = 1
	and u.id_usuario = pIdUsuario;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoJugadorEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoJugadorEliminados`()
BEGIN
	select u.id_juego, u.id_usuario, u.nombre_completo, u.descripcion,
	u.ubicacion, u.archivo, u.contrasenia, u.nombre_usuario, u.fecha_hecho,
	u.fecha_baja, j.id_tipo_jugador, j.puntaje 
	from usuario u, jugador j
	where u.id_usuario = j.id_usuario
	and u.fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

/*Los procesos de eliminación, reingreso y eliminación definitiva son los mismos que en la tabla usuario*/

/*--------------------------TIPO_JUGADOR--------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaTipoJugador`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaTipoJugador`(in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pFechaHecho` date, out `pId` int)

BEGIN
INSERT INTO `tipo_jugador` (`nombre`, `descripcion`, `fecha_hecho`,
`fecha_baja`)
VALUES (pNombre, pDescripcion, pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarTipoJugador`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarTipoJugador`(in `pIdTipoObjetivo` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pFechaHecho` date)
BEGIN
	UPDATE `tipo_jugador`
	SET `nombre` = pNombre, `descripcion` = pDescripcion, `fecha_hecho` = pFechaHecho
	WHERE `id_tipo_jugador` = pIdTipoJugador;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarTipoJugador`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoJugador`(in `pIdTipoObjetivo` int)
BEGIN
	UPDATE `tipo_objetivo` SET `fecha_baja` = now()
	WHERE `id_tipo_objetivo` = pIdObjetivo
    and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoJugador`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoJugador`()
BEGIN
	select * from tipo_jugador where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoJugadorPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoJugadorPorId`(in `pIdTipoJugador` int)
BEGIN
	select * from tipo_jugador where fecha_baja is null 
    and id_tipo_jugador = pIdTipoJugador;

END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoJugadorEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoJugadorEliminados`()
BEGIN
	select * from tipo_jugador where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarTipoJugador`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarTipoJugador`(in `pIdTipoJugador` int)
BEGIN
	UPDATE `tipo_jugador` SET `fecha_baja` = null
	WHERE `id_tipo_jugador` = pIdTipoJugador;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarTipoJugadorDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoJugadorDefinitivo`(in `pIdTipoJugador` int)
BEGIN
	DELETE FROM `tipo_jugador`
	WHERE `id_tipo_jugador` = pIdTipoJugador
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaTipoJugadorDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaTipoJugadorDefinitivo`()
BEGIN
	DELETE FROM `tipo_jugador` WHERE fecha_baja is not null;
END//
DELIMITER ;

/*----------------------------TIPO_MENSAJE----------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaTipoMensaje`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaTipoMensaje`(in `IdUsuario` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO `tipo_mensaje`(`id_usuario`, `nombre`, `descripcion`, 
	`ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
	VALUES(pIdUsuario, pNombre, pDescripcion, pUbicacion, pArchivo,
	pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarTipoMensaje`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarTipoMensaje`(in `pIdTipoMensaje` int, in `IdUsuario` int, 
in `pNombre` varchar(30), in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pFechaHecho` date)
BEGIN
	UPDATE `tipo_mensaje` SET `id_usuario` = pIdUsuario, `id_tipo_mensaje` = pIdTipoMensaje,
	`nombre` = pNombre, `descripcion` = pDescripcion, `ubicacion` = pUbicacion,
	`archivo` = pArchivo, `fecha_hecho` = pFechaHecho
	WHERE `id_usuario` = pIdUsuario AND `id_tipo_mensaje` = pIdTipoMensaje;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarTipoMensaje`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoMensaje`(in `pIdUsuario` int, in `pIdTipoMensaje` int)
BEGIN
	UPDATE `tipo_mensaje` SET `fecha_baja` = now()
	WHERE `id_usuario` = pIdUsuario AND `id_tipo_mensaje` = pIdTipoMensaje
	and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoMensaje`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoMensaje`()
BEGIN
	select * from tipo_mensaje where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoMensajePorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoMensajePorId`(in `pIdUsuario` int, in `pIdTipoMensaje` int)
BEGIN
	select * from tipo_mensaje where fecha_baja is null
	and id_usuario = pIdUsuario and id_tipo_mensaje = pIdTipoMensaje;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoMensajeEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoMensajeEliminados`()
BEGIN
	select * from tipo_mensaje where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarTipoMensaje`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarTipoMensaje`(in `pIdUsuario` int, in `pIdTipoMensaje` int)
BEGIN
	UPDATE `tipo_mensaje` SET `fecha_baja` = null
	WHERE `id_usuario` = pIdUsuario AND `id_tipo_mensaje` = pIdTipoMensaje
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarTipoMensajeDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoMensajeDefinitivo`(in `pIdUsuario` int, in `pIdTipoMensaje` int)
BEGIN
	DELETE FROM `tipo_mensaje`
	WHERE `id_usuario` = pIdUsuario 
	AND `id_tipo_mensaje` = pIdTipoMensaje
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaTipoMensajeDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaTipoMensajeDefinitivo`()
BEGIN
	DELETE FROM `tipo_mensaje` WHERE fecha_baja is not null;
END//
DELIMITER ;

/*----------------------------MENSAJE--------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaMensaje`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaMensaje`(in `IdUsuario` int, 
in `pIdTipoMensaje` int, in `pNombre` varchar(30), in `pDescripcion` varchar(200), 
in `pUbicacion` varchar(200), in `pArchivo` varchar(20), in `pFechaHecho` date, 
in pFechaDesde date, in pFechaHasta date ,out `pId` int)

BEGIN

INSERT INTO `mensaje` (`id_usuario`, `id_tipo_mensaje`, 
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, 
`fecha_baja`, `fecha_desde`,`fecha_hasta`)
VALUES (pIdUsuario, pIdTipoMensaje, pNombre, pDescripcion,
pUbicacion, pArchivo, pFechaHecho, null, pFechaDesde, pFechaHasta);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarMensaje`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarMensaje`(in `IdMensaje` int, in `IdUsuario` int, 
in `pIdTipoMensaje` int, in `pNombre` varchar(30), in `pDescripcion` varchar(200), 
in `pUbicacion` varchar(200), in `pArchivo` varchar(20), in `pFechaHecho` date, 
in pFechaDesde date, in pFechaHasta date)
BEGIN
	UPDATE `mensaje` SET `id_usuario` = pIdUsuario, `id_tipo_mensaje` = pIdTipoMensaje, 
    `nombre` = pNombre, `descripcion` = pDescripcion, `ubicacion` = pUbicacion,
	`archivo` = pArchivo, `fecha_hecho` = pFechaHecho,
	`fecha_desde` = pFechaDesde, `fecha_hasta` = pFechaHasta
	WHERE `id_usuario` = pIdUsuario 
	AND `id_tipo_mensaje` = pIdTipoMensaje AND `id_mensaje` = pIdMensaje;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarMensaje`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarMensaje`(in `pIdUsuario` int, in `pIdMensaje` int ,in `pIdTipoMensaje` int)
BEGIN
	UPDATE `mensaje` SET  `fecha_baja` = now()
	WHERE `id_usuario` = pIdUsuario 
	AND `id_tipo_mensaje` = pIdTipoMensaje AND `id_mensaje` = pIdMensaje
    and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoMensaje`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoMensaje`()
BEGIN
	select * from mensaje where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoMensajePorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoMensajePorId`(in `pIdUsuario` int, in `pIdTipoMensaje` int, in `pIdMensaje` int)
BEGIN
	select * from mensaje where fecha_baja is null
	and `id_usuario` = pIdUsuario AND `id_tipo_mensaje` = pIdTipoMensaje 
	AND `id_mensaje` = pIdMensaje;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoMensajeEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoMensajeEliminados`()
BEGIN
	select * from mensaje where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarMensaje`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarMensaje`(in `pIdUsuario` int, in `pIdMensaje` int ,in `pIdTipoMensaje` int)
BEGIN
	UPDATE `mensaje` SET  `fecha_baja` = null
	WHERE `id_usuario` = pIdUsuario 
	AND `id_tipo_mensaje` = pIdTipoMensaje AND `id_mensaje` = pIdMensaje
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarMensajeDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarMensajeDefinitivo`(in `pIdUsuario` int, in `pIdMensaje` int ,in `pIdTipoMensaje` int)
BEGIN
	DELETE FROM `mensaje`
	WHERE `id_usuario` = pIdUsuario AND `id_tipo_mensaje` = pIdTipoMensaje 
	AND `id_mensaje` = pIdMensaje and fecha_baja  is not  null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaMensajeDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaMensajeDefinitivo`()
BEGIN
	DELETE FROM `mensaje` WHERE fecha_baja is not null;
END//
DELIMITER ;

/*-------------------------CORAZON---------------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaCorazon`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaCorazon`(in `IdUsuario` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), in `pCantVidas` int,
in pEsInfinito bit, in pTiempoProxVida date, in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO  `corazon` (`id_usuario`, `nombre`,
	`descripcion`, `ubicacion`, `archivo`, `cant_vidas`, `es_infinito`,
	`tiempo_prox_vida`, `fecha_hecho`, `fecha_baja`)
	VALUES (pIdUsuario, pNombre, pDescripcion, pUbicacion, pArchivo, pCantVidas,
	pEsInfinito, pTiempoProxVida, pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarCorazon`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarCorazon`(in `IdCorazon` int, in `IdUsuario` int, 
in `pNombre` varchar(30), in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), 
in `pArchivo` varchar(20), in `pCantVidas` int, in `pEsInfinito` bit, 
in `pTiempoProxVida` date, in `pFechaHecho` date)
BEGIN
	UPDATE `corazon`
	SET `id_usuario` = pIdUsuario, `nombre` = pNombre, `descripcion` = pDescripcion,
	`ubicacion` = pUbicacion, `archivo` = pArchivo, `cant_vidas` = pCantVidas,
	`es_infinito` = pEsInfinito, `tiempo_prox_vida` = pTiempoProxVida,
	`fecha_hecho` = pFechaHecho
	WHERE `id_usuario` = pIdUsuario AND `id_corazon` = pIdCorazon;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarCorazon`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarCorazon`(in `pIdUsuario` int, in `pIdCorazon` int)
BEGIN
	UPDATE `corazon` set `fecha_baja` = now()
	WHERE `id_usuario` = pIdUsuario 
	AND `id_corazon` = pIdCorazon
	and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoCorazon`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoCorazon`()
BEGIN
	select * from corazon where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoCorazonPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoCorazonPorId`(in `pIdUsuario` int, in `pIdCorazon` int)
BEGIN
	select * from corazon where fecha_baja is null 
	and `id_usuario` = pIdUsuario AND `id_corazon` = pIdCorazon;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoCorazonEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoCorazonEliminados`()
BEGIN
	select * from corazon where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarCorazon`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarCorazon`(in `pIdUsuario` int, in `pIdCorazon` int)
BEGIN
	UPDATE `corazon` set `fecha_baja` = null
	WHERE `id_usuario` = pIdUsuario 
	AND `id_corazon` = pIdCorazon
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarCorazonDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarCorazonDefinitivo`(in `pIdUsuario` int, in `pIdCorazon` int)
BEGIN
	DELETE FROM `corazon`
	WHERE `id_usuario` = pIdUsuario 
	AND `id_corazon` = pIdCorazon
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaCorazonDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaCorazonDefinitivo`()
BEGIN
	DELETE FROM `corazon` where fecha_baja is not null;
END//
DELIMITER ;

/*---------------------------LINGOTE-------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaLingote`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaLingote`(in `IdUsuario` int,  
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pCantMonedas` int, in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO `lingote` (`id_usuario`, `ubicacion`, `descripcion`, 
	`archivo`, `fecha_hecho`, `fecha_baja`, `cant_monedas`)
	VALUES (pIdUsuario, pUbicacion, pDescripcion, pArchivo, pFecha_Hecho, 
	null, pCantMonedas);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarLingote`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarLingote`(in `IdLingote` int, in `IdUsuario` int,  
in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
in `pCantMonedas` int, in `pFechaHecho` date)
BEGIN
	UPDATE `lingote` SET `id_usuario` = pIdUsuario, `ubicacion` = pUbicacion,
	`descripcion` = pDescripcion, `archivo` = pArchivo,
	`fecha_hecho` = pFechaHecho, `cant_monedas` = pCantMonedas
	WHERE `id_usuario` = pIdUsuario AND `id_lingote` = pIdLingote;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarLingote`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarLingote`(in `pIdUsuario` int, in `pIdLingote` int)
BEGIN
	UPDATE `lingote` SET `fecha_baja` = now()
	WHERE `id_usuario` = pIdUsuario AND `id_lingote` = pIdLingote
	and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoLingote`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoLingote`()
BEGIN
	select * from lingote where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoLingotePorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoLingotePorId`(in `pIdUsuario` int, in `pIdLingote` int)
BEGIN
	select * from lingote where fecha_baja is null
	and `id_usuario` = pIdUsuario AND `id_lingote` = pIdLingote;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoLingoteEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoLingoteEliminados`()
BEGIN
	select * from lingote where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarLingote`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarLingote` (in `pIdUsuario` int, in `pIdLingote` int)
BEGIN
	UPDATE `lingote` SET `fecha_baja` = null
	WHERE `id_usuario` = pIdUsuario AND `id_lingote` = pIdLingote
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarLingoteDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarLingoteDefinitivo`(in `pIdUsuario` int, in `pIdLingote` int)
BEGIN
	DELETE FROM `lingote`
	WHERE `id_usuario` = pIdUsuario AND `id_lingote` = pIdLingote
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaLingoteDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaLingoteDefinitivo`()
BEGIN
	DELETE FROM `lingote` WHERE fecha_baja is not null;
END//
DELIMITER ;

/*-----------------------------BONUS--------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaBonus`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaBonus`(in `IdUsuario` int, in `IdTipoBonus` int,
in `pNombre` varchar(30),  in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), 
in `pArchivo` varchar(20), in `pCantBonus` int, in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO `bonus` (`id_usuario`, `id_tipo_bonus`, 
	`nombre`, `descripcion`, `ubicacion`, `archivo`, `cant_bonus`,
	`fecha_hecho`, `fecha_baja`)
	VALUES (pId_Usuario, pIdTipoBonus, pNombre, pDescripcion, pUbicacion,
	pArchivo, pCantBonus, pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarBonus`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarBonus`(in `IdBonus` int, in `IdUsuario` int, 
in `IdTipoBonus` int, in `pNombre` varchar(30),  in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), 
in `pArchivo` varchar(20), in `pCantBonus` int, in `pFechaHecho` date)

BEGIN
	UPDATE `bonus` SET `id_usuario` = pIdUsuario, `id_tipo_bonus` = pIdBonus, `nombre` = pNombre, 
	`descripcion` = pDescripcion, `ubicacion` = pUbicacion, `archivo` = pArchivo, 
    `cant_bonus` = pCantBonus, `fecha_hecho` = pFechaHecho
	WHERE `id_usuario` = pIdUsuario AND `id_bonus` = pIdBonus;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarBonus`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarBonus`(in `pIdUsuario` int, in `pIdBonus` int)
BEGIN
	UPDATE `bonus` SET `fecha_baja` = now()
	WHERE `id_usuario` = pIdUsuario AND `id_bonus` = pIdBonus
    and fecha_baja is not null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoBonus`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoBonus`()
BEGIN
	select * from bonus where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoBonusPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoBonusPorId`(in `pIdUsuario` int, in `pIdBonus` int)
BEGIN
	select * from bonus where fecha_baja is null
	and `id_usuario` = pIdUsuario AND `id_bonus` = pIdBonus;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoBonusPorIdUsuario`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoBonusPorIdUsuario`(in `pIdUsuario` int)
BEGIN
	select * from bonus where fecha_baja is null and `id_usuario` = pIdUsuario;
END//
DELIMITER ;


/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoBonusEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoBonusEliminados`()
BEGIN
	select * from bonus where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarBonus`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarBonus` (in `pIdUsuario` int, in `pIdBonus` int)
BEGIN
	UPDATE `bonus` SET `fecha_baja` = null
	WHERE `id_usuario` = pIdUsuario AND `id_bonus` = pIdBonus
    and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarBonusDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarBonusDefinitivo`(in `pIdUsuario` int, in `pIdBonus` int)
BEGIN
	DELETE FROM `bonus`
	WHERE `id_usuario` = pIdUsuario AND `id_bonus` = pIdBonus
	and fecha_baja is not null;

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaBonusDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaBonusDefinitivo`()
BEGIN
	DELETE FROM `bonus` where fecha_baja is not null;
END//
DELIMITER ;

/*----------------------TIPO_BONUS------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaTipoBonus`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaTipoBonus`(in `pNombre` varchar(30), 
 in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
 in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO `tipo_bonus` (`nombre`, `descripcion`, `ubicacion`,
	`archivo`, `fecha_hecho`, `fecha_baja`)
	VALUES (pNombre, pDescripcion, pUbicacion, pArchivo, pFechaHecho, null);
	
    SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarTipoBonus`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarTipoBonus`(in `pNombre` varchar(30), 
 in `pDescripcion` varchar(200), in `pUbicacion` varchar(200), in `pArchivo` varchar(20), 
 in `pFechaHecho` date)

BEGIN
	UPDATE `tipo_bonus` SET `nombre` = pNombre,
	`descripcion` = pDescripcion, `ubicacion` = pUbicacion,
	`archivo` = pArchivo, `fecha_hecho` = pFechaHecho
	WHERE `id_tipo_bonus` = pIdTipoBonus;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarTipoBonus`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoBonus`(in `pIdTipoBonus` int)
BEGIN
	UPDATE `tipo_bonus` SET `fecha_baja` = now()
	WHERE `id_tipo_bonus` = pIdTipoBonus
	and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoBonus`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoBonus`()
BEGIN
	select * from tipo_bonus where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoBonusPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoBonusPorId`(in `pIdTipoBonus` int)
BEGIN
	select * from tipo_bonus where fecha_baja is null
	and `id_tipo_bonus` = pIdTipoBonus;
END//
DELIMITER ;


/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoBonusEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoBonusEliminados`()
BEGIN
	select * from tipo_bonus where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarTipoBonus`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarTipoBonus` (in `pIdTipoBonus` int)
BEGIN
	UPDATE `tipo_bonus` SET
	`fecha_baja` = null
	WHERE `id_tipo_bonus` = pIdTipoBonus and fecha_baja is not null;

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarTipoBonusDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoBonusDefinitivo`(in `pIdTipoBonus` int)
BEGIN
	DELETE FROM `tipo_bonus`
	WHERE `id_tipo_bonus` = pIdTipoBonus and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaTipoBonusDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaTipoBonusDefinitivo`()
BEGIN
	DELETE FROM `tipo_bonus` WHERE fecha_baja is not null;
END//
DELIMITER ;

/*--------------------------REGISTRO_MAPA--------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaRegistroMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaRegistroMapa`(in `pIdUsuario` int 
,in `IdMapa` int ,in `pTitulo` varchar(50), in `pDescripcion` varchar(200), in `pPuntosMapa` int, 
in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO `registro_mapa` (`id_usuario`, `id_juego`, `id_mapa`,
	`titulo`, `descripcion`, `puntos_mapa`, `fecha_hecho`, `fecha_baja`)
	VALUES (pIdUsuario, 1, pIdMapa, pTitulo, pDescripcion, pPuntosMapa,
	pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarRegistroMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarRegistroMapa`(in `pIdRegistroMapa` int, in `pIdUsuario` int, 
in `IdMapa` int ,in `pTitulo` varchar(50), in `pDescripcion` varchar(200), in `pPuntosMapa` int, 
in `pFechaHecho` date, out `pId` int)
BEGIN
	UPDATE `registro_mapa`
	SET `id_usuario` = pIdUsuario, `id_mapa` = pIdMapa,
	`titulo` = pTitulo, `descripcion` = pDescripcion, `puntos_mapa` = pPuntosMapa,
	`fecha_hecho` = pFechaHecho
	WHERE `id_usuario` = pIdUsuario AND `id_registro_mapa` = pIdRegistroMapa;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarRegistroMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarRegistroMapa`(in `pIdUsuario` int, in `pIdRegistroMapa` int)
BEGIN
	UPDATE `registro_mapa` SET `fecha_baja` = now()
	WHERE `id_usuario` = pIdUsuario 
	AND `id_registro_mapa` = pIdRegistroMapa
	and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoRegistroMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoRegistroMapa`()
BEGIN
	select * from registro_mapa where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoRegistroMapaPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoRegistroMapaPorId`(in `pIdUsuario` int, in `pIdRegistroMapa` int)
BEGIN
	select * from registro_mapa where fecha_baja is null
	and `id_usuario` = pIdUsuario  
    AND `id_registro_mapa` = pIdRegistroMapa;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoRegistroMapasEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoRegistroMapasEliminados`()
BEGIN
	select * from registro_mapa where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarRegistroMapa`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarRegistroMapa`(in `pIdUsuario` int, in `pIdRegistroMapa` int)
BEGIN
	UPDATE `registro_mapa` SET `fecha_baja` = null
	WHERE `id_usuario` = pIdUsuario 
	AND `id_registro_mapa` = pIdRegistroMapa
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarRegistroMapaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarRegistroMapaDefinitivo`(in `pIdUsuario` int, in `pIdRegistroMapa` int)
BEGIN
	DELETE FROM `registro_mapa` WHERE `id_usuario` = pIdUsuario 
	AND `id_registro_mapa` = pIdRegistroMapa
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaRegistroMapaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaRegistroMapaDefinitivo`()
BEGIN
	DELETE FROM `registro_mapa` WHERE fecha_baja is not null;
END//
DELIMITER ;

/*--------------------------REGISTRO_PANTALLA------------------------------*/


DROP PROCEDURE IF EXISTS `spAltaRegistroPantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaRegistroPantalla`(in `pIdUsuario` int, in  `pIdRegistroMapa` int,
in `IdMapa` int, in `pTitulo` varchar(50), in `pDescripcion` varchar(200), in `pPuntosMapa` int, 
in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO `registro_pantalla` (`id_usuario`, `id_registro_mapa`,
	`id_mapa`, `titulo`, `descripcion`, `puntos_pantalla`,
	`fecha_hecho`, `fecha_baja`)
	VALUES (pIdUsuario, pIdRegistroMapa, pIdMapa, pIdTitulo,
	pIdDescripcion, pPuntosPantalla, pFecha_Hecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarRegistroPantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarRegistroPantalla`(in `IdRegistroPantalla` int, in `pIdUsuario` int,
in  `pIdRegistroMapa` int, in `IdMapa` int, in `pTitulo` varchar(50), in `pDescripcion` varchar(200), 
in `pPuntosMapa` int, in `pFechaHecho` date)
BEGIN
	UPDATE `registro_pantalla`
	SET `id_usuario` = pIdUsuario, `id_registro_mapa` = pIdRegistroMapa,
	`id_mapa` = pIdMapa, `titulo` = pTitulo,
	`descripcion` = pDescripcion, `puntos_pantalla` = pPuntosPantalla,
	`fecha_hecho` = pFechaHecho WHERE `id_usuario` = pIdUsuario 
	AND `id_registro_pantalla` = pIdRegistroPantalla;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarRegistroPantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarRegistroPantalla`(in `pIdRegistroPantalla` int, in `pIdUsuario` int, in `pIdRegistroMapa` int)
BEGIN
	UPDATE `registro_pantalla`
	SET `fecha_baja` = now()
	WHERE `id_usuario` = pIdUsuario
	and `id_registro_mapa` = pIdRegistroMapa 
	AND `id_registro_pantalla` = pIdRegistroPantalla
	and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoRegistroPantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoRegistroPantalla`()
BEGIN
	select * from registro_pantalla where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoRegistroPantallaPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoRegistroPantallaPorId`(in `pIdRegistroPantalla` int, in `pIdUsuario` int, in `pIdRegistroMapa` int)
BEGIN
	select * from registro_pantalla where fecha_baja is null
	and `id_usuario` = pIdUsuario
	and `id_registro_mapa` = pIdRegistroMapa  
	and `id_registro_pantalla` = pIdRegistroPantalla;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoRegistroPantallaEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoRegistroPantallaEliminados`()
BEGIN
	select * from registro_pantalla where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarRegistroPantalla`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarRegistroPantalla`(in `pIdRegistroPantalla` int, in `pIdUsuario` int, in `pIdRegistroMapa` int)
BEGIN
	UPDATE `registro_pantalla`
	SET `fecha_baja` = null
	WHERE `id_usuario` = pIdUsuario
	and `id_registro_mapa` = pIdRegistroMapa  
	AND `id_registro_pantalla` = pIdRegistroPantalla
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarRegistroPantallaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarRegistroPantallaDefinitivo`(in `pIdRegistroPantalla` int, in `pIdUsuario` int, in `pIdRegistroMapa` int)
BEGIN
	DELETE FROM `registro_pantalla`
	WHERE `id_usuario` = pIdUsuario
	and `id_registro_mapa` = pIdRegistroMapa  
	AND `id_registro_pantalla` = pIdRegistroPantalla
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaRegistroPantallaDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaRegistroPantallaDefinitivo`()
BEGIN
	DELETE FROM `registro_pantalla` where fecha_baja is not null;
END//
DELIMITER ;

/*----------------------------TIPO_PERFIL-----------------------------*/

DROP PROCEDURE IF EXISTS `spAltaTipoPerfil`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaTipoPerfil`(in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pDescAbreviada` varchar(10), in `pFechaHecho` date)

BEGIN
INSERT INTO `tipo_perfil` (`nombre`, `descripcion`, `desc_abreviada`, 
`fecha_hecho`, `fecha_baja`)
VALUES (pNombre, pDescripcion, pDescAbreviada, pFechaHecho, null);

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarTipoPerfil`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarTipoPerfil`(in `pIdTipoPerfil` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pDescAbreviada` varchar(10), in `pFechaHecho` date)

BEGIN
	UPDATE `tipo_perfil` SET `nombre` = pNombre, `descripcion` = pDescripcion,
	`desc_abreviada` = pDescAbreviada, `fecha_hecho` = pFechaHecho
	WHERE `id_tipo_perfil` = pIdTipoPerfil;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarTipoPerfil`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoPerfil`(in `pIdTipoPerfil` int)
BEGIN
	UPDATE `tipo_perfil` SET `fecha_baja` = now()
	WHERE `id_tipo_perfil` = pIdTipoPerfil
	and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoPerfil`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoPerfil`()
BEGIN
	select * from tipo_perfil where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoPerfilPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoPerfilPorId`(in `pIdTipoPerfil` int)
BEGIN
	select * from tipo_perfil where fecha_baja is null
	and `id_tipo_perfil` = pIdTipoPerfil;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoPerfilEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoPerfilEliminados`()
BEGIN
	select * from tipo_perfil where fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoPerfilEliminadosPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoPerfilEliminadosPorId`(in pIdTipoPerfil int)
BEGIN
	select * from tipo_perfil where id_tipo_perfil = pIdTipoPerfil and fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarTipoPerfil`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarTipoPerfil`(in `pIdTipoPerfil` int)
BEGIN
	UPDATE `tipo_perfil` SET
	`fecha_baja` = null
	WHERE `id_tipo_perfil` = pIdTipoPerfil
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarTipoPerfilDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoPerfilDefinitivo`(in `pIdTipoPerfil` int)
BEGIN
	DELETE FROM `tipo_perfil`
	WHERE `id_tipo_perfil` = pIdTipoPerfil
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaTipoPerfilDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaTipoPerfilDefinitivo`()
BEGIN
	DELETE FROM `tipo_perfil` WHERE fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spVerSiguienteIdTipoPerfil`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spVerSiguienteIdTipoPerfil`()
BEGIN
	SELECT AUTO_INCREMENT FROM information_schema.TABLES
	WHERE TABLE_SCHEMA = 'adventure_scrabble' 
	AND TABLE_NAME = 'tipo_perfil';
END//
DELIMITER ;

/*-------------------------TIPO_PERMISO-----------------------------*/

DROP PROCEDURE IF EXISTS `spAltaTipoPermiso`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaTipoPermiso`(in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pDescAbreviada` varchar(10), in `pFechaHecho` date)

BEGIN
	INSERT INTO `tipo_permiso` (`nombre`, `descripcion`, 
	`desc_abreviada`, `fecha_hecho`, `fecha_baja`)
	VALUES (pNombre, pDescripcion, pDescAbreviada, pFechaHecho, null);
END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarTipoPermiso`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarTipoPermiso`(in `pIdTipoPermiso` int, in `pNombre` varchar(30), 
in `pDescripcion` varchar(200), in `pDescAbreviada` varchar(10), in `pFechaHecho` date)

BEGIN
	UPDATE `tipo_permiso` SET `nombre` = pNombre,
	`descripcion` = pDescripcion, `desc_abreviada` = pDescAbreviada,
	`fecha_hecho` = pFechaHecho WHERE `id_tipo_permiso` = pIdTipoPermiso;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarTipoPermiso`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoPermiso`(in `pIdTipoPermiso` int)
BEGIN
	UPDATE `tipo_permiso` SET `fecha_baja` = now()
	WHERE `id_tipo_permiso` = pIdTipoPermiso and `fecha_baja` is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoPermiso`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoPermiso`()
BEGIN
	select * from tipo_permiso where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoPermisoPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoPermisoPorId`(in `pIdTipoPermiso` int)
BEGIN
	select * from tipo_permiso where fecha_baja is null 
	and `id_tipo_permiso` = pIdTipoPermiso;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoPermisoEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoPermisoEliminados`()
BEGIN
	select * from tipo_permiso where fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoTipoPermisoEliminadosPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoTipoPermisoEliminadosPorId`(in pIdTipoPermiso int)
BEGIN
	select * from tipo_permiso where id_tipo_permiso = pIdTipoPermiso
    and fecha_baja is not null;
END//
DELIMITER ;


/*call spObtenerListadoTipoPermisoEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarTipoPermiso`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarTipoPermiso`(in `pIdTipoPermiso` int)
BEGIN
	UPDATE `tipo_permiso` SET `fecha_baja` = null
	WHERE `id_tipo_permiso` = pIdTipoPermiso and `fecha_baja` is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarTipoPermisoDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarTipoPermisoDefinitivo`(in `pIdTipoPermiso` int)
BEGIN
	DELETE FROM `tipo_permiso` WHERE `id_tipo_permiso` = pIdTipoPermiso
	and `fecha_baja` is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaTipoPermisoDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaTipoPermisoDefinitivo`()
BEGIN
	DELETE FROM `tipo_permiso` WHERE `fecha_baja` is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaTipoPermisoDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaTipoPermisoDefinitivo`()
BEGIN
	DELETE FROM `tipo_permiso` WHERE `fecha_baja` is not null;
END//
DELIMITER ;



DROP PROCEDURE IF EXISTS `spVerSiguienteIdTipoPermiso`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spVerSiguienteIdTipoPermiso`()
BEGIN
	SELECT AUTO_INCREMENT FROM information_schema.TABLES
	WHERE TABLE_SCHEMA = 'adventure_scrabble' 
	AND TABLE_NAME = 'tipo_permiso';
END//
DELIMITER ;

/*----------------------------PERMISO_FUNCIONALIDAD-----------------------------*/

DROP PROCEDURE IF EXISTS `spAltaPermisoFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaPermisoFuncionalidad` (in `pIdFuncionalidad` int, in `pIdSubFuncionalidad` int, 
in `pIdTipoPermiso` int, in `pIdTipoPerfil` int, in `pNombre` varchar(30), in `pDescripcion` varchar(200), 
in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO `permiso_funcionalidad` (`id_juego`, `id_funcionalidad`, `id_sub_funcionalidad`, 
	`id_tipo_permiso`, `id_tipo_perfil`, `nombre`, `descripcion`, `fecha_hecho`, `fecha_baja`)
	VALUES (1, pIdFuncionalidad, pIdSubFuncionalidad, pIdTipoPermiso, 
	pIdTipoPerfil, pNombre, pDescripcion, pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarPermisoFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarPermisoFuncionalidad`(in `pIdPermisoFuncionalidad` int, in `pIdFuncionalidad` int, in `pIdSubFuncionalidad` int, 
in `pIdTipoPermiso` int, in `pIdTipoPerfil` int, in `pNombre` varchar(30), in `pDescripcion` varchar(200), 
in `pFechaHecho` date)
BEGIN
	UPDATE `permiso_funcionalidad`
	SET `id_juego` = 1, `id_funcionalidad` = pIdFuncionalidad,
	`id_sub_funcionalidad` = pIdSubFuncionalidad, `id_tipo_permiso` = pIdTipoPermiso,
	`id_tipo_perfil` = pIdTipoPerfil, `nombre` = pNombre, `descripcion` = pDescripcion, 
    `fecha_hecho` = pFechaHecho, `fecha_baja` = null
	WHERE `id_juego` = 1 AND `id_funcionalidad` = pIdFuncionalidad 
	AND `id_sub_funcionalidad` = pIdSubFuncionalidad 
	AND `id_permiso_funcionalidad` = pIdPermisoFuncionalidad;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarPermisoFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarPermisoFuncionalidad`(in `pIdFuncionalidad` int, in `pIdSubFuncionalidad` int, in `pIdPermisoFuncionalidad` int)
BEGIN
	UPDATE `adventure_scrabble`.`permiso_funcionalidad`
	SET `fecha_baja` = now()
	WHERE `id_juego` = 1 
	AND `id_funcionalidad` = pIdFuncionalidad 
	AND `id_sub_funcionalidad` = pIdSubFuncionalidad 
	AND `id_permiso_funcionalidad` = pIdPermisoFuncionalidad
	and fecha_baja is null;
END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoPermisoFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoPermisoFuncionalidad`()
BEGIN
	select * from permiso_funcionalidad where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoPermisoFuncionalidadPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoPermisoFuncionalidadPorId`(in `pIdFuncionalidad` int, in `pIdSubFuncionalidad` int, in `pIdPermisoFuncionalidad` int)
BEGIN
	select * from permiso_funcionalidad where fecha_baja is null
	and `id_juego` = 1 AND `id_funcionalidad` = pIdFuncionalidad 
	AND `id_sub_funcionalidad` = pIdSubFuncionalidad 
	AND `id_permiso_funcionalidad` = pIdPermisoFuncionalidad;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoPermisoFuncionalidadEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoPermisoFuncionalidadEliminados`()
BEGIN
	select * from permiso_funcionalidad where fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spObtenerListadoPermisoFuncionalidadEliminadosPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoPermisoFuncionalidadlEliminadosPorId`(in pIdTipoPerfil int)
BEGIN
	select * from tipo_perfil where id_tipo_perfil = pIdTipoPerfil and fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarPermisoFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarPermisoFuncionalidad`(in `pIdFuncionalidad` int, in `pIdSubFuncionalidad` int, in `pIdPermisoFuncionalidad` int)
BEGIN
	UPDATE `adventure_scrabble`.`permiso_funcionalidad`
	SET `fecha_baja` = null
	WHERE `id_juego` = 1 
	AND `id_funcionalidad` = pIdFuncionalidad 
	AND `id_sub_funcionalidad` = pIdSubFuncionalidad 
	AND `id_permiso_funcionalidad` = pIdPermisoFuncionalidad
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarPermisoFuncionalidadDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarPermisoFuncionalidadDefinitivo`(in `pIdFuncionalidad` int, in `pIdSubFuncionalidad` int, in `pIdPermisoFuncionalidad` int)
BEGIN
	DELETE FROM `permiso_funcionalidad`
	where fecha_baja is not null 
	and `id_juego` = 1 
	AND `id_funcionalidad` = pIdFuncionalidad 
	AND `id_sub_funcionalidad` = pIdSubFuncionalidad 
	AND `id_permiso_funcionalidad` = pIdPermisoFuncionalidad;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaPermisoFuncionalidadDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaPermisoFuncionalidadDefinitivo`()
BEGIN
	DELETE FROM `permiso_funcionalidad` where fecha_baja is not null; 
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spVerSiguienteIdPermisoFuncionalidad`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spVerSiguienteIdTipoPermiso`()
BEGIN
	SELECT AUTO_INCREMENT FROM information_schema.TABLES
	WHERE TABLE_SCHEMA = 'adventure_scrabble' 
	AND TABLE_NAME = 'permiso_funcionalidad';
END//
DELIMITER ;


/*------------------------------PERFIL_USUARIO-------------------------------*/

DROP PROCEDURE IF EXISTS `spAltaPerfilUsuario`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spAltaPerfilUsuario`(in `pIdUsuario` int, in `pIdTipoPerfil` int, 
in `pNombre` varchar(30), in `pDescripcion` varchar(200), in `pFechaHecho` date, out `pId` int)

BEGIN
	INSERT INTO `perfil_usuario` (`id_juego`, `id_usuario`, `id_tipo_perfil`,
	`nombre`, `descripcion`, `fecha_hecho`,
	`fecha_baja`)
	VALUES (1, pIdUsuario, pIdTipoPerfil, pNombre, pDescripcion,
	pUbicacion, pArchivo, pFechaHecho, null);

SELECT LAST_INSERT_ID() INTO pId;

END//
DELIMITER ;

/*call spAltaMapa('Mapa 13', 'Ingreso Prueba Mapa 13', '/source', 'mapa13.jpg', now());*/

DROP PROCEDURE IF EXISTS `spModificarPerfilUsuario`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spModificarPerfilUsuario`(in `pIdPerfilUsuario` int, in `pIdUsuario` int, in `pIdTipoPerfil` int, 
in `pNombre` varchar(30), in `pDescripcion` varchar(200), in `pFechaHecho` date)
BEGIN
	UPDATE `perfil_usuario` SET `id_juego` = 1,
	`id_usuario` = pIdUsuario, `id_tipo_perfil` = pIdTipoPerfil,
	`nombre` = pNombre, `descripcion` = pDescripcion, `fecha_hecho` = pFechaHecho
	WHERE `id_juego` = 1 AND `id_usuario` = pIdUsuario 
	AND `id_perfil_usuario` = pIdPerfilUsuario;
END//
DELIMITER ;

/*call spModificarMapa(8,'Mapa 8', 'Ingreso Prueba Mapa 8', '/source', 'mapa8.jpg', '1990-03-25');*/

DROP PROCEDURE IF EXISTS `spEliminarPerfilUsuario`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarPerfilUsuario`(in `pIdUsuario` int, in `pIdPerfilUsuario` int)
BEGIN
	UPDATE `perfil_usuario` SET `fecha_baja` = now()
	WHERE `id_juego` = 1 AND `id_usuario` = pIdUsuario 
	AND `id_perfil_usuario` = pIdPerfilUsuario
	and fecha_baja is null;

END//
DELIMITER ;

/*call spEliminarMapa(8);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoPerfilUsuario`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoPerfilUsuario`()
BEGIN
	select * from perfil_usuario where fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapa();*/

DROP PROCEDURE IF EXISTS `spObtenerListadoPerfilUsuarioPorId`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoPerfilUsuarioPorId`(in `pIdUsuario` int, in `pIdPerfilUsuario` int)
BEGIN
	select * from perfil_usuario WHERE `id_juego` = 1 
	AND `id_usuario` = pIdUsuario 
	AND `id_perfil_usuario` = pIdPerfilUsuario
	and fecha_baja is null;
END//
DELIMITER ;

/*call spObtenerListadoMapaPorId(2);*/

DROP PROCEDURE IF EXISTS `spObtenerListadoPerfilUsuarioEliminados`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spObtenerListadoPerfilUsuarioEliminados`()
BEGIN
	select * from perfil_usuario where fecha_baja is not null;
END//
DELIMITER ;

/*call spObtenerListadoMapasEliminados();*/

DROP PROCEDURE IF EXISTS `spReingresarPerfilUsuario`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spReingresarPerfilUsuario`(in `pIdUsuario` int, in `pIdPerfilUsuario` int)
BEGIN
	UPDATE `perfil_usuario` SET `fecha_baja` = null
	WHERE `id_juego` = 1 AND `id_usuario` = pIdUsuario 
	AND `id_perfil_usuario` = pIdPerfilUsuario
	and fecha_baja is not null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarPerfilUsuarioDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarPerfilUsuarioDefinitivo`(in `pIdUsuario` int, in `pIdPerfilUsuario` int)
BEGIN
	DELETE FROM `perfil_usuario`
	WHERE `id_juego` = 1 AND `id_usuario` = pIdUsuario 
	AND `id_perfil_usuario` = pIdPerfilUsuario
	and fecha_baja is null;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `spEliminarListaPerfilUsuarioDefinitivo`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `spEliminarListaPerfilUsuarioDefinitivo`()
BEGIN
	DELETE FROM `perfil_usuario` where fecha_baja is null;
END//
DELIMITER ;

/*---------------------INSERTS DE PRUEBA TABLA JUEGO (NO TOCAR)-----------------------------*/

/*INSERT INTO juego (id_juego, nombre, ubicacion, archivo, fecha_hecho, fecha_baja) 
	VALUES (1,'Adventure Scrabble','no tiene', 'no tiene', now(), null);*/

/*-----------------------------------INSERTS DE PRUEBA---------------------*/

INSERT INTO `adventure_scrabble`.`tipo_bonus`
(`id_tipo_bonus`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, "Mano de Intercambio", "Intercambia una ficha por otra dentro de un bloque del tablero",
"ninguna", "ninguna", now(), null);
INSERT INTO `adventure_scrabble`.`tipo_bonus`
(`id_tipo_bonus`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES (2, "Ficha Bonus Uno", "Intercambia una ficha con otra que tenga el mismo numero grande pero mayor puntaje",
"ninguna", "ninguna", now(), null);
INSERT INTO `adventure_scrabble`.`tipo_bonus`
(`id_tipo_bonus`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES (3, "Ficha Bonus Dos", "Intercambia una ficha del juego por otra cambiando los numeros grandes pero manteniendo el puntaje",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`bonus`
(`id_usuario`, `id_bonus`, `id_tipo_bonus`, `nombre`, `descripcion`,
`ubicacion`, `archivo`, `cant_bonus`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 1, "Mano de Intercambio", "",
"ninguno", "ninguno", 3, now(), null);

INSERT INTO `adventure_scrabble`.`bonus`
(`id_usuario`, `id_bonus`, `id_tipo_bonus`, `nombre`, `descripcion`,
`ubicacion`, `archivo`, `cant_bonus`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 2, 2, "Ficha Bonus Uno", "",
"ninguno", "ninguno", 3, now(), null);

INSERT INTO `adventure_scrabble`.`bonus`
(`id_usuario`, `id_bonus`, `id_tipo_bonus`, `nombre`, `descripcion`,
`ubicacion`, `archivo`, `cant_bonus`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 3, 3, "Ficha Bonus Dos", "",
"ninguno", "ninguno", 3, now(), null);


INSERT INTO `adventure_scrabble`.`condicionante`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_condicionante`, `id_tipo_condicionante`,
`nombre`, `descripcion`, `fecha_hecho`, `fecha_baja`)
VALUES
(<{id_juego: }>, <{id_mapa: }>, <{id_pantalla: }>, <{id_condicionante: }>,
<{id_tipo_condicionante: }>, <{nombre: }>, <{descripcion: }>, <{fecha_hecho: }>, <{fecha_baja: }>);


INSERT INTO `adventure_scrabble`.`corazon`
(`id_usuario`, `id_corazon`, `nombre`, `descripcion`, `ubicacion`, `archivo`, `cant_vidas`,
`es_infinito`, `tiempo_prox_vida`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, "", "", "", "", 5, 0, null, now(), null);

INSERT INTO `adventure_scrabble`.`corazon`
(`id_usuario`, `id_corazon`, `nombre`, `descripcion`, `ubicacion`, `archivo`, `cant_vidas`,
`es_infinito`, `tiempo_prox_vida`, `fecha_hecho`, `fecha_baja`)
VALUES
(2, 1, "", "", "", "", 5, 0, null, now(), null);

INSERT INTO `adventure_scrabble`.`corazon`
(`id_usuario`, `id_corazon`, `nombre`, `descripcion`, `ubicacion`, `archivo`, `cant_vidas`,
`es_infinito`, `tiempo_prox_vida`, `fecha_hecho`, `fecha_baja`)
VALUES
(3, 1, "", "", "", "", 5, 0, null, now(), null);


INSERT INTO `adventure_scrabble`.`estrella`
(`id_estrella`, `nombre`, `descripcion`, `ubicacion`, `archivo`,
`fecha_hecho`, `fecha_baja`)
VALUES
(1, "Estrella Roja", "Estrella con el puntaje minimo para pasar de pantalla", "", "",
now(), null);

INSERT INTO `adventure_scrabble`.`estrella`
(`id_estrella`, `nombre`, `descripcion`, `ubicacion`, `archivo`,
`fecha_hecho`, `fecha_baja`)
VALUES
(2, "Estrella Amarilla", "Estrella con un puntaje intermedio", "", "",
now(), null);

INSERT INTO `adventure_scrabble`.`estrella`
(`id_estrella`, `nombre`, `descripcion`, `ubicacion`, `archivo`,
`fecha_hecho`, `fecha_baja`)
VALUES
(3, "Estrella Verde", "Estrella con un puntaje maximo", "", "",
now(), null);


INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 1, 0, 1,
"Ficha", "", "", "Ficha0-1.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 2, 1, 0, 2,
"Ficha", "", "", "Ficha0-2.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 3, 1, 0, 3,
"Ficha", "", "", "Ficha0-3.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 4, 1, 0, 4,
"Ficha", "", "", "Ficha0-4.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 5, 1, 0, 5,
"Ficha", "", "", "Ficha0-5.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 6, 1, 0, 6,
"Ficha", "", "", "Ficha0-6.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 7, 1, 0, 7,
"Ficha", "", "", "Ficha0-7.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 8, 1, 0, 8,
"Ficha", "", "", "Ficha0-8.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 9, 1, 0, 9,
"Ficha", "", "", "Ficha0-9.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 10, 1, 1, 1,
"Ficha", "", "", "Ficha1-1.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 11, 1, 1, 2,
"Ficha", "", "", "Ficha1-2.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 12, 1, 1, 3,
"Ficha", "", "", "Ficha1-3.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 13, 1, 1, 4,
"Ficha", "", "", "Ficha1-4.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 14, 1, 1, 5,
"Ficha", "", "", "Ficha1-5.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 15, 1, 1, 6,
"Ficha", "", "", "Ficha1-6.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 16, 1, 1, 7,
"Ficha", "", "", "Ficha1-7.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 17, 1, 1, 8,
"Ficha", "", "", "Ficha1-8.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 18, 1, 1, 9,
"Ficha", "", "", "Ficha1-9.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 19, 1, 2, 1,
"Ficha", "", "", "Ficha2-1.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 20, 1, 2, 2,
"Ficha", "", "", "Ficha2-2.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 21, 1, 2, 3,
"Ficha", "", "", "Ficha2-3.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 22, 1, 2, 4,
"Ficha", "", "", "Ficha2-4.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 23, 1, 2, 5,
"Ficha", "", "", "Ficha2-5.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 24, 1, 2, 6,
"Ficha", "", "", "Ficha2-6.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 25, 1, 2, 7,
"Ficha", "", "", "Ficha2-7.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 26, 1, 2, 8,
"Ficha", "", "", "Ficha2-8.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 27, 1, 2, 9,
"Ficha", "", "", "Ficha2-9.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 28, 1, 3, 1,
"Ficha", "", "", "Ficha3-1.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 29, 1, 3, 2,
"Ficha", "", "", "Ficha3-2.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 30, 1, 3, 3,
"Ficha", "", "", "Ficha3-3.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 31, 1, 3, 4,
"Ficha", "", "", "Ficha3-4.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 32, 1, 3, 5,
"Ficha", "", "", "Ficha3-5.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 33, 1, 3, 6,
"Ficha", "", "", "Ficha3-6.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 34, 1, 3, 7,
"Ficha", "", "", "Ficha3-7.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 35, 1, 3, 8,
"Ficha", "", "", "Ficha3-8.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 36, 1, 3, 9,
"Ficha", "", "", "Ficha3-9.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 37, 1, 4, 1,
"Ficha", "", "", "Ficha4-1.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 38, 1, 4, 2,
"Ficha", "", "", "Ficha4-2.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 39, 1, 4, 3,
"Ficha", "", "", "Ficha4-3.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 40, 1, 4, 4,
"Ficha", "", "", "Ficha4-4.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 41, 1, 4, 5,
"Ficha", "", "", "Ficha4-5.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 42, 1, 4, 6,
"Ficha", "", "", "Ficha4-6.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 43, 1, 4, 7,
"Ficha", "", "", "Ficha4-7.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 44, 1, 4, 8,
"Ficha", "", "", "Ficha4-8.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 45, 1, 4, 9,
"Ficha", "", "", "Ficha4-9.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 46, 1, 5, 1,
"Ficha", "", "", "Ficha5-1.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 47, 1, 5, 2,
"Ficha", "", "", "Ficha5-2.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 48, 1, 5, 3,
"Ficha", "", "", "Ficha5-3.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 49, 1, 5, 4,
"Ficha", "", "", "Ficha5-4.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 50, 1, 5, 5,
"Ficha", "", "", "Ficha5-5.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 51, 1, 5, 6,
"Ficha", "", "", "Ficha5-6.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 52, 1, 5, 7,
"Ficha", "", "", "Ficha5-7.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 53, 1, 5, 8,
"Ficha", "", "", "Ficha5-8.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 54, 1, 5, 9,
"Ficha", "", "", "Ficha5-9.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 55, 1, 6, 1,
"Ficha", "", "", "Ficha6-1.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 56, 1, 6, 2,
"Ficha", "", "", "Ficha6-2.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 57, 1, 6, 3,
"Ficha", "", "", "Ficha6-3.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 58, 1, 6, 4,
"Ficha", "", "", "Ficha6-4.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 59, 1, 6, 5,
"Ficha", "", "", "Ficha6-5.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 60, 1, 6, 6,
"Ficha", "", "", "Ficha6-6.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 61, 1, 6, 7,
"Ficha", "", "", "Ficha6-7.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 62, 1, 6, 8,
"Ficha", "", "", "Ficha6-8.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 63, 1, 6, 9,
"Ficha", "", "", "Ficha6-9.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 64, 1, 7, 1,
"Ficha", "", "", "Ficha7-1.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 65, 1, 7, 2,
"Ficha", "", "", "Ficha7-2.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 66, 1, 7, 3,
"Ficha", "", "", "Ficha7-3.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 67, 1, 7, 4,
"Ficha", "", "", "Ficha7-4.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 68, 1, 7, 5,
"Ficha", "", "", "Ficha7-5.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 69, 1, 7, 6,
"Ficha", "", "", "Ficha7-6.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 70, 1, 7, 7,
"Ficha", "", "", "Ficha7-7.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 71, 1, 7, 8,
"Ficha", "", "", "Ficha7-8.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 72, 1, 7, 9,
"Ficha", "", "", "Ficha7-9.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 73, 1, 8, 1,
"Ficha", "", "", "Ficha8-1.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 74, 1, 8, 2,
"Ficha", "", "", "Ficha8-2.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 75, 1, 8, 3,
"Ficha", "", "", "Ficha8-3.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 76, 1, 8, 4,
"Ficha", "", "", "Ficha8-4.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 77, 1, 8, 5,
"Ficha", "", "", "Ficha8-5.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 78, 1, 8, 6,
"Ficha", "", "", "Ficha8-6.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 79, 1, 8, 7,
"Ficha", "", "", "Ficha8-7.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 80, 1, 8, 8,
"Ficha", "", "", "Ficha8-8.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 81, 1, 8, 9,
"Ficha", "", "", "Ficha8-9.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 82, 1, 9, 1,
"Ficha", "", "", "Ficha9-1.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 83, 1, 9, 2,
"Ficha", "", "", "Ficha9-2.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 84, 1, 9, 3,
"Ficha", "", "", "Ficha9-3.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 85, 1, 9, 4,
"Ficha", "", "", "Ficha9-4.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 86, 1, 9, 5,
"Ficha", "", "", "Ficha9-5.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 87, 1, 9, 6,
"Ficha", "", "", "Ficha9-6.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 88, 1, 9, 7,
"Ficha", "", "", "Ficha9-7.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 89, 1, 9, 8,
"Ficha", "", "", "Ficha9-8.png", now(), null);

INSERT INTO `adventure_scrabble`.`ficha`
(`id_juego`, `id_ficha`, `id_modelo`, `numero_ficha`, `puntaje_ficha`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 90, 1, 9, 9,
"Ficha", "", "", "Ficha9-9.png", now(), null);



INSERT INTO `adventure_scrabble`.`imagen_juego`
(`id_juego`, `id_imagen_juego`, `nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`,
`fecha_baja`)
VALUES
(<{id_juego: }>, <{id_imagen_juego: }>, <{nombre: }>, <{descripcion: }>, <{ubicacion: }>, <{archivo: }>,
<{fecha_hecho: }>, <{fecha_baja: }>);

INSERT INTO `adventure_scrabble`.`imagen_mapa`
(`id_juego`, `id_mapa`, `id_imagen_mapa`, `nombre`, `descripcion`, `ubicacion_imagen`,
`archivo_imagen`, `ubicacion_texto`, `archivo_texto`, `fecha_hecho`, `fecha_baja`)
VALUES
(<{id_juego: }>, <{id_mapa: }>, <{id_imagen_mapa: }>, <{nombre: }>, <{descripcion: }>,
<{ubicacion_imagen: }>, <{archivo_imagen: }>, <{ubicacion_texto: }>, <{archivo_texto: }>, <{fecha_hecho: }>,
<{fecha_baja: }>);

INSERT INTO `adventure_scrabble`.`jugador`
(`id_usuario`, `id_tipo_jugador`, `puntaje`)
VALUES
(1, 1, 0);

INSERT INTO `adventure_scrabble`.`jugador`
(`id_usuario`, `id_tipo_jugador`, `puntaje`)
VALUES
(2, 1, 0);

INSERT INTO `adventure_scrabble`.`jugador`
(`id_usuario`, `id_tipo_jugador`, `puntaje`)
VALUES
(3, 1, 0);


INSERT INTO `adventure_scrabble`.`lingote`
(`id_usuario`, `id_lingote`, `ubicacion`, `descripcion`, `archivo`, `fecha_hecho`,
`fecha_baja`, `cant_monedas`)
VALUES
(1, 1, "ninguno" , "Especifica la cantidad de monedas disponibles",
"ninguno", now(), null, 30);

INSERT INTO `adventure_scrabble`.`lingote`
(`id_usuario`, `id_lingote`, `ubicacion`, `descripcion`, `archivo`, `fecha_hecho`,
`fecha_baja`, `cant_monedas`)
VALUES
(2, 1, "ninguno" , "Especifica la cantidad de monedas disponibles",
"ninguno", now(), null, 30);

INSERT INTO `adventure_scrabble`.`lingote`
(`id_usuario`, `id_lingote`, `ubicacion`, `descripcion`, `archivo`, `fecha_hecho`,
`fecha_baja`, `cant_monedas`)
VALUES
(3, 1, "ninguno" , "Especifica la cantidad de monedas disponibles",
"ninguno", now(), null, 30);


INSERT INTO mapa (id_juego, id_mapa, nombre, descripcion ,ubicacion, archivo, fecha_hecho, fecha_baja) 
	VALUES (1,1,'Mapa Medieval', 'Mapa que ambienta la era medieval', 'ninguna', 'ninguna' ,now(), null);

INSERT INTO mapa (id_juego, id_mapa, nombre, descripcion ,ubicacion, archivo, fecha_hecho, fecha_baja) 
	VALUES (1,2,'Mapa Antigua Grecia', 'Mapa que ambienta la era de la antigua grecia', 'ninguna', 'ninguna' ,now(), null);

INSERT INTO `adventure_scrabble`.`mensaje`
(`id_usuario`, `id_tipo_mensaje`, `id_mensaje`, `nombre`, `descripcion`, `ubicacion`,
`archivo`, `fecha_hecho`, `fecha_baja`, `fecha_desde`, `fecha_hasta`)
VALUES
(1, 1, 1, "Pedido de vidas", "Un jugador le pide vidas a otro",
"ninguno", "ninguno", now(), null, now(), '2017-04-01');

INSERT INTO `adventure_scrabble`.`mensaje`
(`id_usuario`, `id_tipo_mensaje`, `id_mensaje`, `nombre`, `descripcion`, `ubicacion`,
`archivo`, `fecha_hecho`, `fecha_baja`, `fecha_desde`, `fecha_hasta`)
VALUES
(1, 2, 1, "Mayor Puntaje", "Llega al mayor puntaje semanal y recibiras una recompensa",
"ninguno", "ninguno", now(), null, now(), '2017-04-01');

INSERT INTO `adventure_scrabble`.`mensaje`
(`id_usuario`, `id_tipo_mensaje`, `id_mensaje`, `nombre`, `descripcion`, `ubicacion`,
`archivo`, `fecha_hecho`, `fecha_baja`, `fecha_desde`, `fecha_hasta`)
VALUES
(1, 2, 1, "Formacion de Bloques", "Llegá a la mayor cantidad de bloques formados y recibiras una recompensa",
"ninguno", "ninguno", now(), null, now(), '2017-04-01');

INSERT INTO `adventure_scrabble`.`mensaje`
(`id_usuario`, `id_tipo_mensaje`, `id_mensaje`, `nombre`, `descripcion`, `ubicacion`,
`archivo`, `fecha_hecho`, `fecha_baja`, `fecha_desde`, `fecha_hasta`)
VALUES
(1, 3, 1, "Campeonato Semanal", "Se organizará un campeonato de competición entre jugadores. Accede a la copa con importante beneficios",
"ninguno", "ninguno", now(), null, now(), '2017-04-01');

INSERT INTO `adventure_scrabble`.`modelo`
(`id_modelo`, `nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`,
`fecha_baja`)
VALUES
(1, "madera_comun", "Diseño de la ficha sobre madera común" , "ninguna", "ninguna", now(),
null);

INSERT INTO `adventure_scrabble`.`modelo`
(`id_modelo`, `nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`,
`fecha_baja`)
VALUES
(2, "madera_negra", "Madera negra con contraste de números blancos", "ninguna", "ninguna", now(), null);


INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 1, "Pantalla Nro 1", "Primera pantalla del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 2, "Pantalla Nro 2", "Segunda pantalla del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 3, "Pantalla Nro 3", "Tercera pantalla del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 4, "Pantalla Nro 4", "Cuarta pantalla del juego",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 5, "Pantalla Nro 5", "Quinta pantalla del juego",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 6, "Pantalla Nro 6", "Sexta pantalla del juego",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 7, "Pantalla Nro 7", "Septima pantalla del juego",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 8, "Pantalla Nro 8", "Octava pantalla del juego",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 9, "Pantalla Nro 9", "Novena pantalla del juego ",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 10, "Pantalla Nro 10", "Decima pantalla del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 11, "Pantalla Nro 11", "Pantalla Nro 11 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 12, "Pantalla Nro 12", "Pantalla Nro 12 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 13, "Pantalla Nro 13", "Pantalla Nro 13 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 14, "Pantalla Nro 14", "Pantalla Nro 14 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 15, "Pantalla Nro 15", "Pantalla Nro 15 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 16, "Pantalla Nro 16", "Pantalla Nro 16 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 17, "Pantalla Nro 17", "Pantalla Nro 17 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 18, "Pantalla Nro 18", "Pantalla Nro 18 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 19, "Pantalla Nro 19", "Pantalla Nro 19 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 20, "Pantalla Nro 20", "Pantalla Nro 20 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 21, "Pantalla Nro 21", "Pantalla Nro 21 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 22, "Pantalla Nro 22", "Pantalla Nro 22 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 23, "Pantalla Nro 23", "Pantalla Nro 23 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 24, "Pantalla Nro 24", "Pantalla Nro 24 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 25, "Pantalla Nro 25", "Pantalla Nro 25 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 26, "Pantalla Nro 26", "Pantalla Nro 26 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 27, "Pantalla Nro 27", "Pantalla Nro 27 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 28, "Pantalla Nro 28", "Pantalla Nro 28 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 29, "Pantalla Nro 29", "Pantalla Nro 29 del juego con tutorial",
"ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `nombre`, `descripcion`, `ubicacion`, `archivo`, 
`fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 30, "Pantalla Nro 30", "Pantalla Nro 30 del juego con tutorial",
"ninguna", "ninguna", now(), null);


INSERT INTO `adventure_scrabble`.`tablero`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `nombre`, `descripcion`, `ubicacion`, 
`archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 1, 1, "Tablero 9 x 9 cuadrado",
"", "ninguno", "ninguno", now(), null);

UPDATE `adventure_scrabble`.`tablero`
SET `archivo` = "TableroPantalla1.png" WHERE `id_juego` = 1 AND `id_mapa` = 1 
AND `id_pantalla` = 1 AND `id_tablero` = 1;


select * from tablero;


INSERT INTO `adventure_scrabble`.`tablero`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `nombre`, `descripcion`, `ubicacion`, 
`archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 2, 1, "Tablero 9 x 9 cuadrado",
"", "ninguno", "ninguno", now(), null);

INSERT INTO `adventure_scrabble`.`tablero`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `nombre`, `descripcion`, `ubicacion`, 
`archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 3, 1, "Tablero 13 x 13 cuadrado",
"", "ninguno", "ninguno", now(), null);


INSERT INTO `adventure_scrabble`.`tipo_cuadrado`
(`id_tipo_cuadrado`, `nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, "Cuadrado Amarillo", "Multiplica el puntaje del bloque x2", "ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`tipo_cuadrado`
(`id_tipo_cuadrado`, `nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(2, "Cuadrado Azul", "Multiplica el puntaje de una ficha x2", "ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`tipo_cuadrado`
(`id_tipo_cuadrado`, `nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(3, "Cuadrado Estrella", "Cuadrado en donde se empieza una partida", "ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`tipo_cuadrado`
(`id_tipo_cuadrado`, `nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(4, "Cuadrado Papel", "Cuadrado bloqueado hasta que se forme un bloque adyacente", "ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`tipo_cuadrado`
(`id_tipo_cuadrado`, `nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(5, "Cuadrado Rojo", "Multiplica el puntaje del bloque x3", "ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`tipo_cuadrado`
(`id_tipo_cuadrado`, `nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(6, "Cuadrado Verde", "Multiplica el puntaje de la ficha x2", "ninguna", "ninguno", now(), null);

INSERT INTO `adventure_scrabble`.`tipo_cuadrado`
(`id_tipo_cuadrado`, `nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(7, "Cuadrado Simple", "Cuadrado en donde se colocan las fichas sin ningun beneficio adicional", "ninguno", "ninguno", now(), null);


INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 1, 5, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 404, 14);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 2, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 468, 14);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 3, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 532, 14);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 4, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 596, 14);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 5, 5, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 660, 14);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 6, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 724, 14);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 7, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 788, 14);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 8, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 852, 14);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 9, 5, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 916, 14);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 10, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 404, 78);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 11, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 468, 78);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 12, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 532, 78);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 13, 6, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 596, 78);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 14, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 660, 78);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 15, 6, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 724, 78);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 16, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 788, 78);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 17, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 852, 78);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 18, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 916, 78);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 19, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 404, 142);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 20, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 468, 142);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 21, 2, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 532, 142);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 22, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 596, 142);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 23, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 660, 142);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 24, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 724, 142);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 25, 2, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 788, 142);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 26, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 852, 142);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 27, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 916, 142);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 28, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 404, 206);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 29, 6, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 468, 206);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 30, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 532, 206);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 31, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 596, 206);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 32, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 660, 206);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 33, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 724, 206);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 34, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 788, 206);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 35, 6, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 852, 206);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 36, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 916, 206);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 37, 1, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 404, 270);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 38, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 468, 270);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 39, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 532, 270);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 40, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 596, 270);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 41, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 660, 270);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 42, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 724, 270);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 43, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 788, 270);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 44, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 852, 270);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 45, 1, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 916, 270);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 46, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 404, 334);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 47, 6, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 468, 334);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 48, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 532, 334);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 49, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 596, 334);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 50, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 660, 334);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 51, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 724, 334);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 52, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 788, 334);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 53, 6, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 852, 334);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 54, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 916, 334);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 55, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 404, 398);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 56, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 468, 398);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 57, 2, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 532, 398);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 58, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 596, 398);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 59, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 660, 398);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 60, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 724, 398);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 61, 2, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 788, 398);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 62, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 852, 398);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 63, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 916, 398);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 64, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 404, 462);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 65, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 468, 462);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 66, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 532, 462);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 67, 6, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 596, 462);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 68, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 660, 462);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 69, 6, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 724, 462);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 70, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 788, 462);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 71, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 852, 462);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 72, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 916, 462);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 73, 5, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 404, 526);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 74, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 468, 526);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 75, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 532, 526);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 76, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 596, 526);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 77, 1, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 660, 526);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 78, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 724, 526);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 79, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 788, 526);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 80, 7, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 852, 526);

INSERT INTO `adventure_scrabble`.`cuadrado`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_tablero`, `id_cuadrado`, `id_tipo_cuadrado`,
`nombre`, `descripcion`, `ubicacion`, `archivo`, `fecha_hecho`, `fecha_baja`, `coordenada_x`, `coordenada_y`)
VALUES
(1, 1, 1, 1, 81, 5, "Cuadrado 1", "", "ninguno", "ninguno", now(), null, 916, 526);


INSERT INTO `adventure_scrabble`.`puntaje_pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_puntaje_pantalla`,
`id_estrella`, `nombre`, `descripcion`, `nivel`, `puntaje`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 1, 1, 1, "Primer Puntaje", "", 1, 120, now(), null);

INSERT INTO `adventure_scrabble`.`puntaje_pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_puntaje_pantalla`,
`id_estrella`, `nombre`, `descripcion`, `nivel`, `puntaje`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 1, 2, 2, "Segundo Puntaje", "", 1, 140, now(), null);

INSERT INTO `adventure_scrabble`.`puntaje_pantalla`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_puntaje_pantalla`,
`id_estrella`, `nombre`, `descripcion`, `nivel`, `puntaje`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 1, 3, 3, "Tercer Puntaje", "", 1, 200, now(), null);


INSERT INTO `adventure_scrabble`.`registro_mapa`
(`id_usuario`, `id_registro_mapa`, `id_juego`, `id_mapa`, `titulo`, `descripcion`,
`puntos_mapa`, `fecha_hecho`, `fecha_baja`)
VALUES
(<{id_usuario: }>, <{id_registro_mapa: }>, <{id_juego: }>, <{id_mapa: }>, <{titulo: }>, <{descripcion: }>, <{puntos_mapa: }>,
<{fecha_hecho: }>, <{fecha_baja: }>);

INSERT INTO `adventure_scrabble`.`registro_pantalla`
(`id_usuario`, `id_registro_mapa`, `id_registro_pantalla`, `id_juego`, `id_mapa`,
`id_pantalla`, `titulo`, `descripcion`, `puntos_pantalla`, `fecha_hecho`, `fecha_baja`)
VALUES
(<{id_usuario: }>, <{id_registro_mapa: }>, <{id_registro_pantalla: }>, <{id_juego: }>,
<{id_mapa: }>, <{id_pantalla: }>, <{titulo: }>, <{descripcion: }>, <{puntos_pantalla: }>,
<{fecha_hecho: }>, <{fecha_baja: }>);


INSERT INTO `adventure_scrabble`.`tipo_condicionante`
(`id_tipo_condicionante`, `nombre`, `descripcion`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, "Limite de tiempo", "Impone un limite de tiempo para llegar a los objetivos de una pantalla", now(),
null);
INSERT INTO `adventure_scrabble`.`tipo_condicionante`
(`id_tipo_condicionante`, `nombre`, `descripcion`, `fecha_hecho`, `fecha_baja`)
VALUES
(2, "Limite de cantidad de fichas", "Impone un limite en la cantidad de fichas disponibles que tiene el usuario para resolver el juego", now(), null);
INSERT INTO `adventure_scrabble`.`tipo_condicionante`
(`id_tipo_condicionante`, `nombre`, `descripcion`, `fecha_hecho`, `fecha_baja`)
VALUES
(3, "Limite de cant de movimientos", "Impone un limite en la cantidad de movimientos que tiene el usuario para resolver el juego", now(), null);

INSERT INTO `adventure_scrabble`.`tipo_mensaje`
(`id_usuario`, `id_tipo_mensaje`, `nombre`, `descripcion`, `ubicacion`,
`archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, "Mensaje Procedente de Amigos", "Recibe los mensajes de pedidos o entrega de vidas procedentes de amigos", "ninguno",
"ninguno", now(), null);

INSERT INTO `adventure_scrabble`.`tipo_mensaje`
(`id_usuario`, `id_tipo_mensaje`, `nombre`, `descripcion`, `ubicacion`,
`archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 2, "Mensaje de Desafios", "Recibe los mensajes de algún desafio con un premio como resultado", "ninguno",
"ninguno", now(), null);

INSERT INTO `adventure_scrabble`.`tipo_mensaje`
(`id_usuario`, `id_tipo_mensaje`, `nombre`, `descripcion`, `ubicacion`,
`archivo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 3, "Campeonatos para Inscripcion", "Recibe los mensajes de inscripción para algun campeonato", "ninguno",
"ninguno", now(), null);


INSERT INTO `adventure_scrabble`.`tipo_objetivo`
(`id_tipo_objetivo`, `nombre`, `descripcion`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, "Cantidad Puntaje", "El jugador debe llegar a un determinado puntaje para pasar de pantalla", now(), null);

INSERT INTO `adventure_scrabble`.`tipo_objetivo`
(`id_tipo_objetivo`, `nombre`, `descripcion`, `fecha_hecho`, `fecha_baja`)
VALUES
(2, "Cantidad de Bloques", "El jugador debe llegar a una determina cantidad de bloques de determinado largo", now(), null);

INSERT INTO `adventure_scrabble`.`tipo_objetivo`
(`id_tipo_objetivo`, `nombre`, `descripcion`, `fecha_hecho`, `fecha_baja`)
VALUES
(3, "Cantidad de una ficha", "Llegar a usar x cantidad de un tipo de ficha (por ejemplo usar el numero grande 1 veinte cantidad de veces)", now(), null);

INSERT INTO `adventure_scrabble`.`objetivo`
(`id_juego`, `id_mapa`, `id_pantalla`, `id_objetivo`, `id_tipo_objetivo`, `nombre`,
`descripcion`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 1, 1, 1,
"", "", now(), null);

INSERT INTO `adventure_scrabble`.`oferta`
(`id_juego`, `id_oferta`, `id_tipo_oferta`, `titulo`, `descripcion`, `precio`,
`moneda`, `simbolo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, 1, "15 Barras de Lingotes", "Oferta de 15 barras de lingotes", 15,
"dolar", "US$", now(), null);

INSERT INTO `adventure_scrabble`.`oferta`
(`id_juego`, `id_oferta`, `id_tipo_oferta`, `titulo`, `descripcion`, `precio`,
`moneda`, `simbolo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 2, 1, "20 Barras de Lingotes", "Oferta de 20 barras de lingotes", 20,
"dolar", "US$", now(), null);

INSERT INTO `adventure_scrabble`.`oferta`
(`id_juego`, `id_oferta`, `id_tipo_oferta`, `titulo`, `descripcion`, `precio`,
`moneda`, `simbolo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 3, 1, "50 Barras de Lingotes", "Oferta de 50 barras de lingotes", 50,
"dolar", "US$", now(), null);

INSERT INTO `adventure_scrabble`.`oferta`
(`id_juego`, `id_oferta`, `id_tipo_oferta`, `titulo`, `descripcion`, `precio`,
`moneda`, `simbolo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 4, 1, "100 Barras de Lingotes", "Oferta de 100 barras de lingotes", 100,
"dolar", "US$", now(), null);

INSERT INTO `adventure_scrabble`.`oferta`
(`id_juego`, `id_oferta`, `id_tipo_oferta`, `titulo`, `descripcion`, `precio`,
`moneda`, `simbolo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 5, 1, "150 Barras de Lingotes", "Oferta de 150 barras de lingotes", 150,
"dolar", "US$", now(), null);

INSERT INTO `adventure_scrabble`.`oferta`
(`id_juego`, `id_oferta`, `id_tipo_oferta`, `titulo`, `descripcion`, `precio`,
`moneda`, `simbolo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 6, 2, "Pack de Bonus Uno", "Pack de Bonus incluyendo 5 manos de intercambio, 5 bonus intercambio 1 y 5 bonus intercambio 2", 150,
"dolar", "US$", now(), null);

INSERT INTO `adventure_scrabble`.`oferta`
(`id_juego`, `id_oferta`, `id_tipo_oferta`, `titulo`, `descripcion`, `precio`,
`moneda`, `simbolo`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 7, 2, "Pack de Bonus Dos", "Incluye 8 manos de intercambio, 8 bonus intercambio 1, 8 bonus intercambio 2, vidas ilimitadas por 72 horas, etc", 300, 
"dolar", "US$", now(), null);


INSERT INTO `adventure_scrabble`.`tipo_oferta`
(`id_tipo_oferta`, `nombre`, `descripcion`, `ubicacion`, `archivo`,
`fecha_hecho`, `fecha_baja`)
VALUES (1, "Venta de Lingote", "", "ninguna", "ninguna", now(), null);

INSERT INTO `adventure_scrabble`.`tipo_oferta`
(`id_tipo_oferta`, `nombre`, `descripcion`, `ubicacion`, `archivo`,
`fecha_hecho`, `fecha_baja`)
VALUES (2, "Venta de Bonus", "", "ninguna", "ninguna", now(), null);


INSERT INTO `adventure_scrabble`.`tipo_perfil`
(`id_tipo_perfil`,
`nombre`,
`descripcion`,
`desc_abreviada`,
`fecha_hecho`,
`fecha_baja`)
VALUES
(<{id_tipo_perfil: }>,
<{nombre: }>,
<{descripcion: }>,
<{desc_abreviada: }>,
<{fecha_hecho: }>,
<{fecha_baja: }>);

INSERT INTO `adventure_scrabble`.`tipo_permiso`
(`id_tipo_permiso`,
`nombre`,
`descripcion`,
`desc_abreviada`,
`fecha_hecho`,
`fecha_baja`)
VALUES
(<{id_tipo_permiso: }>,
<{nombre: }>,
<{descripcion: }>,
<{desc_abreviada: }>,
<{fecha_hecho: }>,
<{fecha_baja: }>);

INSERT INTO `adventure_scrabble`.`usuario`
(`id_juego`, `id_usuario`, `nombre_completo`, `descripcion`, `ubicacion`,
`archivo`, `contrasenia`, `nombre_usuario`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 1, "GamerMasterOne", "Primer Jugador de Prueba",
"ninguna", "ninguna", "ninguna", "GamerMasterOne", now(), null);

INSERT INTO `adventure_scrabble`.`usuario`
(`id_juego`, `id_usuario`, `nombre_completo`, `descripcion`, `ubicacion`,
`archivo`, `contrasenia`, `nombre_usuario`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 2, "Appi", "Segundo Jugador de Prueba",
"ninguna", "ninguna", "ninguna", "Appi", now(), null);

INSERT INTO `adventure_scrabble`.`usuario`
(`id_juego`, `id_usuario`, `nombre_completo`, `descripcion`, `ubicacion`,
`archivo`, `contrasenia`, `nombre_usuario`, `fecha_hecho`, `fecha_baja`)
VALUES
(1, 3, "Butterfly", "Tercer Jugador de Prueba", "ninguna", "ninguna", "ninguna", "Butterfly", now(), null);


INSERT INTO `adventure_scrabble`.`tipo_jugador`
(`id_tipo_jugador`,
`nombre`,
`descripcion`,
`fecha_hecho`,
`fecha_baja`)
VALUES
(1,
"Facebook",
"Jugador usuario de facebook",
now(),
null);

INSERT INTO `adventure_scrabble`.`tipo_jugador`
(`id_tipo_jugador`,
`nombre`,
`descripcion`,
`fecha_hecho`,
`fecha_baja`)
VALUES
(2,
"Google",
"Jugador usuario de google",
now(),
null);

INSERT INTO `adventure_scrabble`.`tipo_jugador`
(`id_tipo_jugador`,
`nombre`,
`descripcion`,
`fecha_hecho`,
`fecha_baja`)
VALUES
(3,
"Usuario Daimond",
"Jugador inscripto en la base de datos de Daimond Games",
now(),
null);

/*----------------ELIMINACIONES PARA LUEGO DE UNA PRUEBA----------------------*/

/*delete from mapa where id_juego = 1;*/
/*delete from pantalla where id_juego = 1;*/

/*--------------DROP DE LA BASE DE DATOS: SÓLO PARA CASOS DE PRUEBA!!!!!---------------*/

/*drop database if exists `adventure_scrabble`;*/

/*--------------DROP DE TABLAS: SÓLO SI ES NECESARIO---------------*/

/*TABLAS SIN DEPENDENCIAS*/

/*drop table permiso_funcionalidad*/
/*drop table cuadrado*/
/*drop table objetivo*/
/*drop table condicionante*/
/*drop table ficha*/
/*drop table corazon*/
/*drop table lingote*/
/*drop table puntaje_pantalla*/
/*drop table registro_pantalla*/
/*drop table imagen_juego*/
/*drop table perfil_usuario;*/
/*drop table bonus;*/
/*drop table oferta*/

/*TABLAS CON UNA DEPENDENCIA*/

/*drop table sub_funcionalidad*/
/*drop table registro mapa*/
/*drop table tablero*/
/*drop table funcionalidad*/  
/*drop estrella*/
/*drop tipo_cuadrado*/
/*drop tipo_condicionante*/
/*drop tipo_objetivo*/
/*drop modelo*/
/*drop tipo_oferta*/
/*drop tipo_jugador*/
/*drop tipo_permiso*/
/*drop tipo_perfil*/

/*TABLA CON MÁS DE DOS DEPENDENCIAS*/

/*drop table jugador*/
/*drop table  pantalla*/
/*drop table  mapa*/
/*drop table usuario*/

/*SELECT AUTO_INCREMENT FROM information_schema.TABLES
WHERE TABLE_SCHEMA = 'adventure_scrabble' 
AND TABLE_NAME = 'sub_funcionalidad';*/

select * from mapa;
select * from pantalla;
select * from usuario;
select * from jugador;
select * from registro_mapa;
select * from registro_pantalla;
select * from corazon;
select * from lingote;
select * from bonus;
select * from tipo_bonus;
select * from tipo_mensaje;
select * from mensaje;
select * from cuadrado;

use blog_facilito;
select * from articles;