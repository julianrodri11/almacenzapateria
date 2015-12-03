-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-12-2015 a las 10:17:20
-- Versión del servidor: 5.6.11
-- Versión de PHP: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdzapateria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacenes`
--

CREATE TABLE `almacenes` (
  `idalmacenes` int(11) NOT NULL,
  `almacen` varchar(45) DEFAULT NULL,
  `nit` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `celular` bigint(15) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `almacenes`
--

INSERT INTO `almacenes` (`idalmacenes`, `almacen`, `nit`, `correo`, `celular`, `telefono`, `direccion`) VALUES
(1, 'Gasolina Extra', '321123211-7', 'info@gasolinaextra.com', 3121002311, '0327321213', 'Calle 30'),
(2, 'Seventeen Sport', '321221321-7', 'info@seventeensport.com', 312102101, '03232113213', 'Calle 20'),
(3, 'N/A', '0000', '000', 0, '000', '000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bonos`
--

CREATE TABLE `bonos` (
  `idbonos` int(11) NOT NULL,
  `nombre_bono` varchar(45) DEFAULT NULL,
  `valor` bigint(15) DEFAULT NULL,
  `usuarios_idusuarios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `bonos`
--

INSERT INTO `bonos` (`idbonos`, `nombre_bono`, `valor`, `usuarios_idusuarios`) VALUES
(1, 'Bono para ropa ', 15000, 10882),
(2, 'Bono para comida', 20000, 10885);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cajas`
--

CREATE TABLE `cajas` (
  `idcajas` int(11) NOT NULL,
  `caja` varchar(45) DEFAULT NULL,
  `sucursales_idsucursales` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cajas`
--

INSERT INTO `cajas` (`idcajas`, `caja`, `sucursales_idsucursales`) VALUES
(1, 'Caja Uno', 1),
(2, 'Caja Uno', 2),
(3, 'Caja Dos', 1),
(4, 'Caja Dos', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `idcategorias` int(11) NOT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`idcategorias`, `categoria`, `descripcion`) VALUES
(1, 'Futbol', ''),
(2, 'Botas ', ''),
(3, 'Elegantes', ''),
(4, 'Tennis', ''),
(5, 'Originales', ''),
(6, 'Running', ''),
(7, 'Training', ''),
(8, 'Basketball', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudades`
--

CREATE TABLE `ciudades` (
  `idciudades` int(11) NOT NULL,
  `ciudad` varchar(45) DEFAULT NULL,
  `departamentos_iddepartamentos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ciudades`
--

INSERT INTO `ciudades` (`idciudades`, `ciudad`, `departamentos_iddepartamentos`) VALUES
(1, 'Pasto', 1),
(2, 'Ipiales', 1),
(3, 'Cali', 2),
(4, 'Yumbo', 2),
(5, 'Popayan', 3),
(6, 'Santader de Quilichao', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE `departamentos` (
  `iddepartamentos` int(11) NOT NULL,
  `departamento` varchar(45) DEFAULT NULL,
  `paises_idpaises` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `departamentos`
--

INSERT INTO `departamentos` (`iddepartamentos`, `departamento`, `paises_idpaises`) VALUES
(1, 'NariÃ±o', 1),
(2, 'Valle', 1),
(3, 'Cauca', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadocuotas`
--

CREATE TABLE `estadocuotas` (
  `idestadocuotas` int(11) NOT NULL,
  `nombre_est_cuota` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estadocuotas`
--

INSERT INTO `estadocuotas` (`idestadocuotas`, `nombre_est_cuota`, `descripcion`) VALUES
(1, 'Pagada', ''),
(2, 'En Mora', ''),
(3, 'Generada', ''),
(4, 'En Mora Absoluta', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `idfacturas` int(11) NOT NULL,
  `cajas_idcajas` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time(6) DEFAULT NULL,
  `cliente_idusuarios` int(11) NOT NULL,
  `cajero_idusuarios` int(11) NOT NULL,
  `tipoventas_idtipoventas` int(11) NOT NULL,
  `ventas_idventas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`idfacturas`, `cajas_idcajas`, `fecha`, `hora`, `cliente_idusuarios`, `cajero_idusuarios`, `tipoventas_idtipoventas`, `ventas_idventas`) VALUES
(1, 1, '2015-11-30', '05:00:00.000000', 10882, 10883, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE `marcas` (
  `idmarcas` int(11) NOT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `marcas`
--

INSERT INTO `marcas` (`idmarcas`, `marca`, `descripcion`) VALUES
(1, 'Adidas', ''),
(2, 'Nike', ''),
(3, 'Puma', ''),
(4, 'lacoste', ''),
(5, 'Reebok', ''),
(6, 'Converse', ''),
(7, 'Dieses', ''),
(8, 'Fila', ''),
(9, 'Jordan', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materiales`
--

CREATE TABLE `materiales` (
  `idmateriales` int(11) NOT NULL,
  `material` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `materiales`
--

INSERT INTO `materiales` (`idmateriales`, `material`, `descripcion`) VALUES
(1, 'Cuero', ''),
(2, 'tela', ''),
(3, 'Cuero Liso', ' textura o superficie con pequeños poros'),
(4, 'Nubuck ', 'Cuero con cabello, especial es muy fino'),
(5, 'Suede', 'cuero verdadero sobre el lado de la carne'),
(6, 'Fibras sintéticas', 'caucho, plástico, cuero artificial'),
(7, 'Poromerics', 'cuero sintético,similar al del cuero natural');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `idpago` int(11) NOT NULL,
  `facturas_idfacturas` int(11) NOT NULL,
  `nopagos` int(11) DEFAULT NULL,
  `valor_pago_cuota` bigint(15) DEFAULT NULL,
  `fecha_a_pagar` date DEFAULT NULL,
  `hora` time(6) DEFAULT NULL,
  `estadocuotas_idestadocuotas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pagos`
--

INSERT INTO `pagos` (`idpago`, `facturas_idfacturas`, `nopagos`, `valor_pago_cuota`, `fecha_a_pagar`, `hora`, `estadocuotas_idestadocuotas`) VALUES
(1, 1, 1, 232000, '2015-11-30', '03:00:00.000000', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paises`
--

CREATE TABLE `paises` (
  `idpaises` int(11) NOT NULL,
  `pais` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `paises`
--

INSERT INTO `paises` (`idpaises`, `pais`) VALUES
(1, 'Colombia'),
(2, 'Ecuador'),
(3, 'Venezuela'),
(4, 'Peru');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

CREATE TABLE `perfiles` (
  `idperfiles` int(11) NOT NULL,
  `perfil` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `usuarios_idusuarios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `perfiles`
--

INSERT INTO `perfiles` (`idperfiles`, `perfil`, `descripcion`, `usuarios_idusuarios`) VALUES
(1, 'administrador', 'todos los privilegios', 10881),
(2, 'cliente', 'Quien compra los productos al almacen', 10882),
(3, 'cajero', 'Quien guarda las facturas de venta', 10883),
(4, 'cajero', '', 10886),
(5, 'almacenista', '', 10885);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idproductos` int(11) NOT NULL,
  `producto` varchar(45) DEFAULT NULL,
  `precio` bigint(20) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `imagen` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `talla` varchar(45) DEFAULT NULL,
  `materiales_idmateriales` int(11) NOT NULL,
  `categorias_idcategorias` int(11) NOT NULL,
  `marcas_idmarcas` int(11) NOT NULL,
  `sucursales_idsucursales` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idproductos`, `producto`, `precio`, `descripcion`, `imagen`, `color`, `talla`, `materiales_idmateriales`, `categorias_idcategorias`, `marcas_idmarcas`, `sucursales_idsucursales`) VALUES
(1, 'Guayos Chaos X-15', 116000, '', '/img/chaos.jpg', 'Verde', '39', 6, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock`
--

CREATE TABLE `stock` (
  `idstock` int(11) NOT NULL,
  `cantidad` bigint(20) DEFAULT NULL,
  `productos_idproductos` int(11) NOT NULL,
  `usuarios_idusuarios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursales`
--

CREATE TABLE `sucursales` (
  `idsucursales` int(11) NOT NULL,
  `almacenes_idalmacenes` int(11) NOT NULL,
  `ciudades_idciudades` int(11) NOT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `celular` bigint(15) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `sucursales`
--

INSERT INTO `sucursales` (`idsucursales`, `almacenes_idalmacenes`, `ciudades_idciudades`, `direccion`, `correo`, `celular`, `telefono`) VALUES
(1, 1, 1, 'Crra 30 No 10-15', 'info@gasolinaextra.com', 312542125, '0324546512'),
(2, 1, 2, 'Calle 7 No-23-30', 'ipiales@gasolinaextra.com', 3121122331, '03214544123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoventas`
--

CREATE TABLE `tipoventas` (
  `idtipoventas` int(11) NOT NULL,
  `tipo_venta` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipoventas`
--

INSERT INTO `tipoventas` (`idtipoventas`, `tipo_venta`, `descripcion`) VALUES
(1, 'Contado', ''),
(2, 'Debito', ''),
(3, 'Credito', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idusuarios` int(11) NOT NULL,
  `primer_nombre` varchar(45) DEFAULT NULL,
  `segundo_nombre` varchar(45) DEFAULT NULL,
  `primer_apellido` varchar(45) DEFAULT NULL,
  `segundo_apellido` varchar(45) DEFAULT NULL,
  `celular` bigint(15) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `ciudades_idciudades` int(11) NOT NULL,
  `foto` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `contrasena` text,
  `almacenes_idalmacenes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idusuarios`, `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `celular`, `direccion`, `genero`, `fecha_nacimiento`, `ciudades_idciudades`, `foto`, `correo`, `contrasena`, `almacenes_idalmacenes`) VALUES
(10881, 'Julian', 'Enrique', 'Rodriguez', 'Valenzuela', 3127080006, 'Barrio el dorado calle 40No10-10', 'Masculino', '1989-12-27', 1, '/images/julian.jpg', 'julianrodri11@gmail.com', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 3),
(10882, 'David', 'Ricardo', 'Benavides', 'Hernandez', 3124546121, 'Barrio Pandiaco calle 45', 'Masculino', '1995-11-30', 1, '/img/1.jpg', 'david@gmail.com', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 1),
(10883, 'Jose', 'Sebastian', 'Rodriguez', 'Jativa', 3102312132, 'Las americas crra 25 No 14-19', 'Masculino', '1993-11-10', 1, '/img/1.jpg', 'sebastian@gmail.com', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 1),
(10884, 'Hector', 'Guillermo', 'Rodriguez', 'Burbano', 3146835857, '', 'Masculino', '1963-11-03', 2, '', 'hector@gmail.com', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 1),
(10885, 'Juan', 'Andres', 'Toledo', '', NULL, 'Calle 30 10-10', 'Masculino', '1975-11-17', 2, '', 'vairon@gmail.com', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 2),
(10886, 'Jesus', 'Alexander', 'Chiran', 'Rodriguez', 3120011331, 'Centro calle 10', 'Masculino', '2000-12-07', 1, '', 'jesus@gmail.com', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idventas` int(11) NOT NULL,
  `productos_idproductos` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `iva` int(2) DEFAULT NULL,
  `total` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idventas`, `productos_idproductos`, `cantidad`, `iva`, `total`) VALUES
(1, 1, 2, 16, 194880),
(2, 1, 2, 16, 234);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `almacenes`
--
ALTER TABLE `almacenes`
  ADD PRIMARY KEY (`idalmacenes`);

--
-- Indices de la tabla `bonos`
--
ALTER TABLE `bonos`
  ADD PRIMARY KEY (`idbonos`),
  ADD KEY `fk_bonos_usuarios1_idx` (`usuarios_idusuarios`);

--
-- Indices de la tabla `cajas`
--
ALTER TABLE `cajas`
  ADD PRIMARY KEY (`idcajas`),
  ADD KEY `fk_cajas_sucursales1_idx` (`sucursales_idsucursales`);

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`idcategorias`);

--
-- Indices de la tabla `ciudades`
--
ALTER TABLE `ciudades`
  ADD PRIMARY KEY (`idciudades`),
  ADD KEY `fk_ciudades_departamentos1_idx` (`departamentos_iddepartamentos`);

--
-- Indices de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`iddepartamentos`),
  ADD KEY `fk_departamentos_paises_idx` (`paises_idpaises`);

--
-- Indices de la tabla `estadocuotas`
--
ALTER TABLE `estadocuotas`
  ADD PRIMARY KEY (`idestadocuotas`);

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`idfacturas`),
  ADD KEY `fk_facturas_tipoventas1_idx` (`tipoventas_idtipoventas`),
  ADD KEY `fk_facturas_usuarios1_idx` (`cliente_idusuarios`),
  ADD KEY `fk_facturas_usuarios2_idx` (`cajero_idusuarios`),
  ADD KEY `fk_facturas_cajas1_idx` (`cajas_idcajas`),
  ADD KEY `fk_facturas_ventas1_idx` (`ventas_idventas`);

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`idmarcas`);

--
-- Indices de la tabla `materiales`
--
ALTER TABLE `materiales`
  ADD PRIMARY KEY (`idmateriales`);

--
-- Indices de la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD PRIMARY KEY (`idpago`),
  ADD KEY `fk_credito_estadocuotas1_idx` (`estadocuotas_idestadocuotas`),
  ADD KEY `fk_credito_facturas1_idx` (`facturas_idfacturas`);

--
-- Indices de la tabla `paises`
--
ALTER TABLE `paises`
  ADD PRIMARY KEY (`idpaises`);

--
-- Indices de la tabla `perfiles`
--
ALTER TABLE `perfiles`
  ADD PRIMARY KEY (`idperfiles`),
  ADD KEY `fk_perfiles_usuarios1_idx` (`usuarios_idusuarios`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idproductos`),
  ADD KEY `fk_productos_materiales1_idx` (`materiales_idmateriales`),
  ADD KEY `fk_productos_categorias1_idx` (`categorias_idcategorias`),
  ADD KEY `fk_productos_marcas1_idx` (`marcas_idmarcas`),
  ADD KEY `fk_productos_sucursales1_idx` (`sucursales_idsucursales`);

--
-- Indices de la tabla `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`idstock`),
  ADD KEY `fk_stock_productos1_idx` (`productos_idproductos`),
  ADD KEY `fk_stock_usuarios1_idx` (`usuarios_idusuarios`);

--
-- Indices de la tabla `sucursales`
--
ALTER TABLE `sucursales`
  ADD PRIMARY KEY (`idsucursales`),
  ADD KEY `fk_sucursales_ciudades1_idx` (`ciudades_idciudades`),
  ADD KEY `fk_sucursales_almacenes1_idx` (`almacenes_idalmacenes`);

--
-- Indices de la tabla `tipoventas`
--
ALTER TABLE `tipoventas`
  ADD PRIMARY KEY (`idtipoventas`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idusuarios`),
  ADD KEY `fk_usuarios_almacenes1_idx` (`almacenes_idalmacenes`),
  ADD KEY `fk_usuarios_ciudades1_idx` (`ciudades_idciudades`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idventas`),
  ADD KEY `fk_ventas_productos1_idx` (`productos_idproductos`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `bonos`
--
ALTER TABLE `bonos`
  ADD CONSTRAINT `fk_bonos_usuarios1` FOREIGN KEY (`usuarios_idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `cajas`
--
ALTER TABLE `cajas`
  ADD CONSTRAINT `fk_cajas_sucursales1` FOREIGN KEY (`sucursales_idsucursales`) REFERENCES `sucursales` (`idsucursales`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `ciudades`
--
ALTER TABLE `ciudades`
  ADD CONSTRAINT `fk_ciudades_departamentos1` FOREIGN KEY (`departamentos_iddepartamentos`) REFERENCES `departamentos` (`iddepartamentos`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD CONSTRAINT `fk_departamentos_paises` FOREIGN KEY (`paises_idpaises`) REFERENCES `paises` (`idpaises`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD CONSTRAINT `fk_facturas_cajas1` FOREIGN KEY (`cajas_idcajas`) REFERENCES `cajas` (`idcajas`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_facturas_tipoventas1` FOREIGN KEY (`tipoventas_idtipoventas`) REFERENCES `tipoventas` (`idtipoventas`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_facturas_usuarios1` FOREIGN KEY (`cliente_idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_facturas_usuarios2` FOREIGN KEY (`cajero_idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_facturas_ventas1` FOREIGN KEY (`ventas_idventas`) REFERENCES `ventas` (`idventas`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD CONSTRAINT `fk_credito_estadocuotas1` FOREIGN KEY (`estadocuotas_idestadocuotas`) REFERENCES `estadocuotas` (`idestadocuotas`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_credito_facturas1` FOREIGN KEY (`facturas_idfacturas`) REFERENCES `facturas` (`idfacturas`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `perfiles`
--
ALTER TABLE `perfiles`
  ADD CONSTRAINT `fk_perfiles_usuarios1` FOREIGN KEY (`usuarios_idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `fk_productos_categorias1` FOREIGN KEY (`categorias_idcategorias`) REFERENCES `categorias` (`idcategorias`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_productos_marcas1` FOREIGN KEY (`marcas_idmarcas`) REFERENCES `marcas` (`idmarcas`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_productos_materiales1` FOREIGN KEY (`materiales_idmateriales`) REFERENCES `materiales` (`idmateriales`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_productos_sucursales1` FOREIGN KEY (`sucursales_idsucursales`) REFERENCES `sucursales` (`idsucursales`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `stock`
--
ALTER TABLE `stock`
  ADD CONSTRAINT `fk_stock_productos1` FOREIGN KEY (`productos_idproductos`) REFERENCES `productos` (`idproductos`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_stock_usuarios1` FOREIGN KEY (`usuarios_idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `sucursales`
--
ALTER TABLE `sucursales`
  ADD CONSTRAINT `fk_sucursales_almacenes1` FOREIGN KEY (`almacenes_idalmacenes`) REFERENCES `almacenes` (`idalmacenes`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_sucursales_ciudades1` FOREIGN KEY (`ciudades_idciudades`) REFERENCES `ciudades` (`idciudades`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_usuarios_almacenes1` FOREIGN KEY (`almacenes_idalmacenes`) REFERENCES `almacenes` (`idalmacenes`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_usuarios_ciudades1` FOREIGN KEY (`ciudades_idciudades`) REFERENCES `ciudades` (`idciudades`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `fk_ventas_productos1` FOREIGN KEY (`productos_idproductos`) REFERENCES `productos` (`idproductos`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
