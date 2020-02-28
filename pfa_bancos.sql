-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-11-2016 a las 21:28:01
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pfa.bancos`
--
CREATE DATABASE IF NOT EXISTS `pfa.bancos` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `pfa.bancos`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asalto`
--

CREATE TABLE `asalto` (
  `ID` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `CodigoSucursal` varchar(50) NOT NULL,
  `CodigoJuez` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asalto`
--

INSERT INTO `asalto` (`ID`, `Fecha`, `CodigoSucursal`, `CodigoJuez`) VALUES
(1, '2016-02-02', 'S_003', 'J_001'),
(2, '2016-03-06', 'S_001', 'J_002'),
(3, '2016-03-08', 'S_004', 'J_005'),
(4, '2016-06-05', 'S_013', 'J_003'),
(5, '2016-08-15', 'S_001', 'J_001'),
(6, '2016-10-27', 'S_016', 'J_005'),
(7, '2017-02-08', 'S_015', 'J_001'),
(8, '2017-02-19', 'S_001', 'J_007'),
(9, '2017-05-10', 'S_002', 'J_008'),
(10, '2017-08-19', 'S_002', 'J_001'),
(11, '2017-12-12', 'S_001', 'J_002'),
(12, '2018-01-13', 'S_003', 'J_005'),
(13, '2018-02-22', 'S_001', 'J_004'),
(14, '2018-05-10', 'S_004', 'J_005'),
(15, '2018-07-26', 'S_005', 'J_001'),
(16, '2019-03-17', 'S_013', 'J_002'),
(17, '2019-06-28', 'S_012', 'J_010'),
(18, '2019-09-11', 'S_009', 'J_002'),
(19, '2019-12-20', 'S_011', 'J_001'),
(20, '2019-12-23', 'S_018', 'J_002');


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banda`
--

CREATE TABLE `banda` (
  `CodigoBanda` varchar(50) NOT NULL,
  `NroDeMiembros` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `banda`
--

INSERT INTO `banda` (`CodigoBanda`, `NroDeMiembros`) VALUES
('B_001', 24),
('B_002', 25),
('B_003', 22),
('B_004', 15),
('B_005', 19),
('B_006', 17),
('B_007', 10),
('B_008', 25),
('B_009', 22),
('B_010', 14),
('B_011', 21),
('B_012', 9),
('B_013', 17),
('B_014', 10),
('B_015', 25),
('B_016', 21),
('B_017', 16),
('B_018', 22),
('B_019', 21),
('B_020', 14);


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `condena`
--

CREATE TABLE `condena` (
  `CodigoDelincuente` varchar(50) NOT NULL,
  `CodigoAsalto` int(11) NOT NULL,
  `FechaDeInicio` date NOT NULL,
  `FechaFin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `condena`
--

INSERT INTO `condena` (`CodigoDelincuente`, `CodigoAsalto`,`FechaDeInicio`,`FechaFin`) VALUES
('D_001', 1, '2016-04-27', '2026-12-15'),
('D_002', 1, '2016-04-05', '2023-05-03'),
('D_003', 1, '2016-05-08', '2020-11-11'),
('D_004', 1, '2016-05-18', '2025-05-10'),
('D_009', 3, '2016-06-27', '2025-12-26'),
('D_010', 4, '2016-08-27', '2023-02-02'),
('D_011', 4, '2016-08-27', '2025-07-16'),
('D_012', 5, '2016-11-24', '2026-03-31'),
('D_017', 7, '2017-05-21', '2022-11-06'),
('D_018', 10, '2017-11-24', '2027-04-08'),
('D_019', 10, '2017-11-20', '2027-08-06'),
('D_020', 10, '2017-11-01', '2028-06-04');


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contratacion`
--

CREATE TABLE `contratacion` (
  `CodigoSucursal` varchar(50) NOT NULL,
  `CodigoVigilante` varchar(50) NOT NULL,
  `Fecha` date NOT NULL,
  `Armas` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `contratacion`
--

INSERT INTO `contratacion` (`CodigoSucursal`, `CodigoVigilante`, `Fecha`, `Armas`) VALUES
('S_003', 'v_001', '2020-03-08', 1),
('S_001', 'v_002', '2020-03-13', 1),
('S_004', 'v_003', '2020-03-25', 0),
('S_013', 'v_004', '2020-03-09', 1),
('S_001', 'v_003', '2020-03-26', 1),
('S_016', 'v_008', '2020-02-27', 1),
('S_015', 'v_002', '2020-03-31', 0),
('S_001', 'v_003', '2020-03-21', 1),
('S_002', 'v_004', '2020-02-25', 0),
('S_002', 'v_003', '2020-03-18', 1),
('S_001', 'v_008', '2020-03-07', 0),
('S_003', 'v_007', '2020-03-19', 1),
('S_001', 'v_008', '2020-03-11', 0),
('S_004', 'v_001', '2020-03-16', 1),
('S_005', 'v_003', '2020-03-27', 1),
('S_013', 'v_003', '2020-03-28', 0),
('S_012', 'v_004', '2020-02-23', 1),
('S_009', 'v_008', '2020-03-31', 1),
('S_011', 'v_006', '2020-02-20', 0),
('S_018', 'v_007', '2020-03-07', 1);


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `delincuente`
--

CREATE TABLE `delincuente` (
  `Codigo` varchar(50) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Detenido` tinyint(1) NOT NULL,
  `CodigoBanda` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `delincuente`
--

INSERT INTO `delincuente` (`Codigo`, `Nombre`, `Detenido`, `CodigoBanda`) VALUES
('D_001', 'QUINTERO, RUBEN ROLANDO', 1, 'B_001'),
('D_002', 'COBAS, DIEGO MARTIN', 1, 'B_001'),
('D_003', 'SIBILLA, FACUNDO SEBASTIAN', 0, 'B_002'),
('D_004', 'ROSSI, EMILIO ERNESTO', 1, 'B_001'),
('D_005', 'JIMENEZ, MIGUEL ANGEL', 1, 'B_006'),
('D_006', 'MARTINETTI, DAMIAN RICARDO', 0, 'B_006'),
('D_007', 'BARROS, DANIEL PEDRO', 1, 'NULL'),
('D_008', 'PRUNERA, DANIEL LUIS', 1, 'B_005'),
('D_009', 'GATTO, NICOLAS CARLOS', 0, 'NULL'),
('D_010', 'BERTOLDI, JOSE MARIA', 1, 'NULL'),
('D_011', 'DASSO, ALBERTO ANGEL', 1, 'B_005'),
('D_012', 'PACE, CARLOS FABIAN', 0, 'NULL'),
('D_013', 'MENDEZ, MIGUEL LEANDRO', 1, 'B_001'),
('D_014', 'CANOS, JORGE LEONARDO', 1, 'B_002'),
('D_015', 'KULCAR, JUAN CARLOS', 0, 'B_003'),
('D_016', 'SCHELOTTO, LUCAS DANIEL', 1, 'B_003'),
('D_017', 'CACHEDA, FERNANDO JORGE', 1, 'B_001'),
('D_018', 'FLORENTIN, VICTOR ARIEL', 0, 'B_002'),
('D_019', 'RIFFEL, CLAUDIO MANUEL', 1, 'NULL'),
('D_020', 'MUÑOZ, DANIEL ANTONIO', 1, 'NULL');


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `delincuentesporasalto`
--

CREATE TABLE `delincuentesporasalto` (
  `CodigoDelincuente` varchar(50) NOT NULL,
  `AsaltoID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `delincuentesporasalto`
--

INSERT INTO `delincuentesporasalto` (`CodigoDelincuente`, `AsaltoID`) VALUES
('D_001', 1),
('D_002', 1),
('D_003', 1),
('D_004', 1),
('D_005', 2),
('D_006', 2),
('D_007', 2),
('D_008', 2),
('D_009', 3),
('D_010', 4),
('D_011', 4),
('D_012', 5),
('D_013', 6),
('D_014', 6),
('D_015', 6),
('D_016', 6),
('D_017', 7),
('D_018', 10),
('D_019', 10),
('D_020', 10);


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entidadbancaria`
--

CREATE TABLE `entidadbancaria` (
  `Codigo` varchar(50) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Domicilio` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `entidadbancaria`
--

INSERT INTO `entidadbancaria` (`Codigo`, `Nombre`, `Domicilio`) VALUES
('BNA', 'Banco de la Nación Argentina', 'AVENIDA R CASTILLO 750, C.A.B.A., BUENOS AIRES'),
('BGLA', 'Banco Galicia', 'AVENIDA MONTES DE OCA 1044, C.A.B.A., BUENOS AIRES'),
('BPBA', 'Banco Provincia de Buenos Aires', 'MORENO 3317, C.A.B.A., BUENOS AIRES'),
('BCBA', 'Banco Ciudad de Buenos Aires', 'DEAN FUNES GREGORIO 1912, C.A.B.A., BUENOS AIRES'),
('BSRA', 'Banco Santander Río', 'CIUDAD DE LA PAZ 3546 , C.A.B.A., BUENOS AIRES'),
('BBVA', 'Banco Frances', 'AVENIDA BEIRO FRANCISCO 2757 , C.A.B.A., BUENOS AIRES'),
('BMA', 'Banco Macro', 'AVENIDA COBO 1753, C.A.B.A., BUENOS AIRES'),
('BHIP', 'Banco Hipotecario', 'AVENIDA CERVIÑO 3912, C.A.B.A., BUENOS AIRES');


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juez`
--

CREATE TABLE `juez` (
  `Nombre` varchar(50) NOT NULL,
  `Codigo` varchar(50) NOT NULL,
  `FechaDeIngreso` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `juez`
--

INSERT INTO `juez` (`Nombre`, `Codigo`, `FechaDeIngreso`) VALUES
('GUTTE, PAMELA ALEJANDRA', 'J_001', '1998-10-07'),
('BARRIENTO, DANIEL MARCELO', 'J_002', '1995-09-04'),
('GIMENEZ, LUCAS GONZALO', 'J_003', '1993-03-08'),
('AGUIRRE, MARIA TERESA ', 'J_004', '1996-01-21'),
('VEGA, JUAN ANDRES', 'J_005', '2005-06-22'),
('ROSELLI, CLAUDIA BEATRIZ', 'J_006', '2009-05-07'),
('ROMANO, JULIA VANESA', 'J_007', '2011-11-21'),
('LOPEZ, MARIA SOLEDAD', 'J_008', '2006-06-25'),
('PATURLANNE, HUGO ALFREDO', 'J_009', '1994-02-15'),
('GONZALEZ, ANA JACQUELINE', 'J_010', '2007-12-14'),
('SARAVIA, MARIA ELENA', 'J_011', '2007-03-22'),
('GUEVARA, TOMAS LUCAS', 'J_012', '1995-07-10'),
('GODOY, MARGAREJO MARIO', 'J_013', '1999-09-28'),
('MUÑOZ, EDUARDO CARLOS', 'J_014', '2015-08-03'),
('MOYA, GONZALO EZEQUIEL', 'J_015', '1992-08-05'),
('CORSINI, LUCAS NAHUEL', 'J_016', '2008-10-23'),
('AGUIRRE, EMANUEL SEBASTIAN', 'J_017', '2003-11-24'),
('COLOCA, NESTOR FABIAN', 'J_018', '1993-07-20'),
('BORDO, ARIEL EDUARDO', 'J_019', '2005-10-27'),
('GIMENEZ, MIGUEL ERNESTO', 'J_020', '2004-07-08');


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`ID`, `Nombre`) VALUES
(1, 'Administrador'),
(2, 'Vigilante'),
(3, 'Inspector');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursal`
--

CREATE TABLE `sucursal` (
  `Codigo` varchar(50) NOT NULL,
  `Domicilio` varchar(50) NOT NULL,
  `NroEmpleados` int(11) NOT NULL,
  `CodigoEntidad` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sucursal`
--

INSERT INTO `sucursal` (`Codigo`, `Domicilio`, `NroEmpleados`, `CodigoEntidad`) VALUES
('S_001', 'MONSEÑOR MARCON 3478, SAN JUSTO, BUENOS AIRES', 29, 'BNA'),
('S_002', 'SEGUROLA DR SATURNINO 1568 7 A MO, C.A.B.A., BUENOS AIRES', 27, 'BGLA'),
('S_003', 'SUPERI JOSE 3230 2, C.A.B.A., BUENOS AIRES', 15, 'BPBA'),
('S_004', 'SUCRE MRCAL ANTONIO JOSE DE 1949 2 B, C.A.B.A., BUENOS AIRES', 32, 'BSRA'),
('S_005', 'CAAGUAZU 2520, C.A.B.A., BUENOS AIRES', 17, 'BSRA'),
('S_006', 'OLGA COSETINI 152 PEN HOUSE 8, C.A.B.A., BUENOS AIRES', 22, 'BNA'),
('S_007', 'AVENIDA JUAN BAUTISTA JUSTO, C.A.B.A., BUENOS AIRES', 20, 'BGLA'),
('S_008', 'INCLAN 4230, C.A.B.A., BUENOS AIRES', 23, 'BSRA'),
('S_009', 'ZAVALIA SALUSTIANO 2090 4 A, C.A.B.A., BUENOS AIRES', 29, 'BSRA'),
('S_010', 'MEDINA NICOLAS 674, C.A.B.A., BUENOS AIRES', 16, 'BSRA'),
('S_011', 'COSQUIN 4118, C.A.B.A., BUENOS AIRES', 33, 'BNA'),
('S_012', 'POTOSI 3854 6 A, C.A.B.A., BUENOS AIRES', 30, 'BGLA'),
('S_013', 'PILAR 1832, C.A.B.A., BUENOS AIRES', 16, 'BPBA'),
('S_014', 'AVENIDA SCALABRINI ORTIZ DR RAUL 682, C.A.B.A., BUENOS AIRES', 30, 'BSRA'),
('S_015', 'CARACAS 1238, C.A.B.A., BUENOS AIRES', 19, 'BSRA'),
('S_016', 'ZAMUDIO MAXIMO 4460, C.A.B.A., BUENOS AIRES', 26, 'BCBA'),
('S_017', 'CERVANTES 1618, C.A.B.A., BUENOS AIRES', 23, 'BSRA'),
('S_018', 'SAN MARTIN 1485, C.A.B.A., BUENOS AIRES', 15, 'BPBA'),
('S_019', 'ZAPIOLA 1550, C.A.B.A., BUENOS AIRES', 34, 'BSRA'),
('S_020', 'PERU 410, C.A.B.A., BUENOS AIRES', 29, 'BSRA');


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Nombre` varchar(50) NOT NULL,
  `Contraseña` varchar(50) NOT NULL,
  `ID` int(11) NOT NULL,
  `RolID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Nombre`, `Contraseña`, `ID`, `RolID`) VALUES
('administrador_1', 'a1', 1, 1),
('administrador_2', 'a2', 2, 1),
('administrador_3', 'a3', 3, 1),
('administrador_4', 'a4', 4, 1),
('administrador_5', 'a5', 5, 1),
('vigilante_1', 'v1', 6, 2),
('vigilante_2', 'v2', 7, 2),
('vigilante_3', 'v3', 8, 2),
('vigilante_4', 'v4', 9, 2),
('vigilante_5', 'v5', 10, 2),
('vigilante_6', 'v6', 11, 2),
('vigilante_7', 'v7', 12, 2),
('vigilante_8', 'v8', 13, 2),
('vigilante_9', 'v9', 14, 2),
('vigilante_10', 'v10', 15, 2),
('inspector_1', 'i1', 16, 3),
('inspector_2', 'i2', 17, 3),
('inspector_3', 'i3', 18, 3),
('inspector_4', 'i4', 19, 3),
('inspector_5', 'i5', 20, 3);


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vigilante`
--

CREATE TABLE `vigilante` (
  `Codigo` varchar(50) NOT NULL,
  `FechaNac` varchar(10) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Usuario` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vigilante`
--

INSERT INTO `vigilante` (`Codigo`, `FechaNac`, `Nombre`, `Usuario`) VALUES
('v_001', '1988-04-01', 'FAEDDA, JOSHUA DAMIAN', 'vigilante_1'),
('v_002', '1987-10-02', 'CAPALBO, LUIS MARIANO', 'vigilante_2'),
('v_003', '1971-03-15', 'RODRIGUEZ, GUIDO GONZALO', 'vigilante_3'),
('v_004', '1981-10-29', 'ZAMORA, DIEGO JAVIER', 'vigilante_4'),
('v_005', '1986-04-24', 'MARTINEZ, ANGEL JOSE', 'vigilante_5'),
('v_006', '1975-11-14', 'MUNOZ VALLEJOS, EDGAR', 'vigilante_6'),
('v_007', '1976-11-19', 'ARCE, JAIME ARIEL', 'vigilante_7'),
('v_008', '1974-02-10', 'SPIZZO, GUSTAVO ANDRES', 'vigilante_8'),
('v_009', '1990-09-13', 'FORTES, JOSE ELISARDO', 'vigilante_9'),
('v_010', '1972-01-10', 'RADICHE, GUSTAVO ARIEL', 'vigilante_10');


--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asalto`
--
ALTER TABLE `asalto`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `CodigoSucursal` (`CodigoSucursal`),
  ADD KEY `CodigoJuez` (`CodigoJuez`);

--
-- Indices de la tabla `banda`
--
ALTER TABLE `banda`
  ADD PRIMARY KEY (`CodigoBanda`);

--
-- Indices de la tabla `condena`
--
ALTER TABLE `condena`
  ADD PRIMARY KEY (`CodigoDelincuente`,`CodigoAsalto`),
  ADD KEY `asalto_condena` (`CodigoAsalto`);

--
-- Indices de la tabla `contratacion`
--
ALTER TABLE `contratacion`
  ADD PRIMARY KEY (`CodigoSucursal`,`CodigoVigilante`,`Fecha`),
  ADD KEY `vigilante_contratacion` (`CodigoVigilante`);

--
-- Indices de la tabla `delincuente`
--
ALTER TABLE `delincuente`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `CodigoBanda` (`CodigoBanda`);

--
-- Indices de la tabla `delincuentesporasalto`
--
ALTER TABLE `delincuentesporasalto`
  ADD PRIMARY KEY (`CodigoDelincuente`,`AsaltoID`),
  ADD KEY `asalto_delincuentesporasalto` (`AsaltoID`);

--
-- Indices de la tabla `entidadbancaria`
--
ALTER TABLE `entidadbancaria`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `juez`
--
ALTER TABLE `juez`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `CodigoEntidad` (`CodigoEntidad`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `RolID` (`RolID`);

--
-- Indices de la tabla `vigilante`
--
ALTER TABLE `vigilante`
  ADD PRIMARY KEY (`Codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asalto`
--
ALTER TABLE `asalto`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asalto`
--
ALTER TABLE `asalto`
  ADD CONSTRAINT `Juez_asalto` FOREIGN KEY (`CodigoJuez`) REFERENCES `juez` (`Codigo`),
  ADD CONSTRAINT `asalto_sucursal` FOREIGN KEY (`CodigoSucursal`) REFERENCES `sucursal` (`Codigo`);

--
-- Filtros para la tabla `condena`
--
ALTER TABLE `condena`
  ADD CONSTRAINT `asalto_condena` FOREIGN KEY (`CodigoAsalto`) REFERENCES `asalto` (`ID`),
  ADD CONSTRAINT `delincuente_condena` FOREIGN KEY (`CodigoDelincuente`) REFERENCES `delincuente` (`Codigo`);

--
-- Filtros para la tabla `contratacion`
--
ALTER TABLE `contratacion`
  ADD CONSTRAINT `sucursal_contratacion` FOREIGN KEY (`CodigoSucursal`) REFERENCES `sucursal` (`Codigo`),
  ADD CONSTRAINT `vigilante_contratacion` FOREIGN KEY (`CodigoVigilante`) REFERENCES `vigilante` (`Codigo`);

--
-- Filtros para la tabla `delincuente`
--
ALTER TABLE `delincuente`
  ADD CONSTRAINT `delincuente_banda` FOREIGN KEY (`CodigoBanda`) REFERENCES `banda` (`CodigoBanda`);

--
-- Filtros para la tabla `delincuentesporasalto`
--
ALTER TABLE `delincuentesporasalto`
  ADD CONSTRAINT `asalto_delincuentesporasalto` FOREIGN KEY (`AsaltoID`) REFERENCES `asalto` (`ID`),
  ADD CONSTRAINT `delincuentes_delincuentesporasalto` FOREIGN KEY (`CodigoDelincuente`) REFERENCES `delincuente` (`Codigo`);

--
-- Filtros para la tabla `sucursal`
--
ALTER TABLE `sucursal`
  ADD CONSTRAINT `sucursal_entidad` FOREIGN KEY (`CodigoEntidad`) REFERENCES `entidadbancaria` (`Codigo`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `rol_usuario` FOREIGN KEY (`RolID`) REFERENCES `rol` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
