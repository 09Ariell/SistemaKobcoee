-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-12-2024 a las 22:24:55
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `kobcoee`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productoventa`
--

CREATE TABLE `productoventa` (
  `ID` int(11) NOT NULL,
  `CANTIDAD` int(11) DEFAULT NULL,
  `venta_id` int(11) DEFAULT NULL,
  `PRODUCTO_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productoventa`
--

INSERT INTO `productoventa` (`ID`, `CANTIDAD`, `venta_id`, `PRODUCTO_ID`) VALUES
(8, 2, 901, 252),
(9, 3, 901, 201),
(10, 2, 951, 201),
(11, 1, 951, 152),
(12, 1, 1101, 1052),
(13, 2, 1101, 152),
(14, 1, 1101, 252),
(15, 1, 1101, 201),
(16, 2, 1151, 1001),
(17, 2, 1201, 1052),
(18, 1, 1201, 1053),
(19, 2, 1251, 152),
(20, 2, 1301, 1001),
(21, 2, 1301, 1052),
(22, 1, 1351, 152),
(23, 2, 1351, 1001),
(24, 1, 1401, 1053),
(25, 2, 1401, 252);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reportesemanal`
--

CREATE TABLE `reportesemanal` (
  `ID` bigint(20) NOT NULL,
  `ARCHIVOPATH` varchar(255) DEFAULT NULL,
  `DETALLESVENTAS` longtext DEFAULT NULL,
  `FECHA` datetime DEFAULT NULL,
  `TOTALGENERADO` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reportesemanal`
--

INSERT INTO `reportesemanal` (`ID`, `ARCHIVOPATH`, `DETALLESVENTAS`, `FECHA`, `TOTALGENERADO`) VALUES
(136, NULL, 'Fecha de la Venta: 08/12/24\nProducto: Nike Revolution 7 - Cantidad: 1 - Subtotal: 59990.0\nProducto: Polera oversize mujer - Cantidad: 2 - Subtotal: 50000.0\nTotal de la venta: 109990.0\n\n', '2024-12-08 17:07:41', 109990),
(137, NULL, 'Rango de la Semana: 02/12/2024 - 08/12/2024\n\nFecha de la Venta: 04/12/2024\nProducto: Polera Algodon - Cantidad: 2 - Subtotal: 40000.0\nProducto: POLERÓN FULL ZIP RIVAL TERRY HOMBRE UNDER ARMOUR - Cantidad: 3 - Subtotal: 119970.0\nTotal de la venta: 159970.0\n\nFecha de la Venta: 04/12/2024\nProducto: POLERÓN FULL ZIP RIVAL TERRY HOMBRE UNDER ARMOUR - Cantidad: 2 - Subtotal: 79980.0\nProducto: Nike Revolution 7 - Cantidad: 1 - Subtotal: 59990.0\nTotal de la venta: 139970.0\n\nFecha de la Venta: 04/12/2024\nProducto: Adidas Grand Court Lifestyle - Cantidad: 1 - Subtotal: 40000.0\nProducto: Nike Revolution 7 - Cantidad: 2 - Subtotal: 119980.0\nProducto: Polera Algodon - Cantidad: 1 - Subtotal: 20000.0\nProducto: POLERÓN FULL ZIP RIVAL TERRY HOMBRE UNDER ARMOUR - Cantidad: 1 - Subtotal: 39990.0\nTotal de la venta: 219970.0\n\nFecha de la Venta: 05/12/2024\nProducto: Polera oversize mujer - Cantidad: 2 - Subtotal: 50000.0\nTotal de la venta: 50000.0\n\nFecha de la Venta: 04/12/2024\nProducto: Adidas Grand Court Lifestyle - Cantidad: 2 - Subtotal: 80000.0\nProducto: Pantalón Cargo Gabardina Forro Polar Hombre - Cantidad: 1 - Subtotal: 9000.0\nTotal de la venta: 89000.0\n\nFecha de la Venta: 05/12/2024\nProducto: Nike Revolution 7 - Cantidad: 2 - Subtotal: 119980.0\nTotal de la venta: 119980.0\n\nFecha de la Venta: 05/12/2024\nProducto: Polera oversize mujer - Cantidad: 2 - Subtotal: 50000.0\nProducto: Adidas Grand Court Lifestyle - Cantidad: 2 - Subtotal: 80000.0\nTotal de la venta: 130000.0\n\nFecha de la Venta: 08/12/2024\nProducto: Nike Revolution 7 - Cantidad: 1 - Subtotal: 59990.0\nProducto: Polera oversize mujer - Cantidad: 2 - Subtotal: 50000.0\nTotal de la venta: 109990.0\n\n', '2024-12-08 17:07:42', 1018880),
(138, NULL, 'Rango del Mes: 01/12/24 - 31/12/24\n\nFecha de la Venta: 04/12/24\nProducto: Polera Algodon - Cantidad: 2 - Subtotal: 40000.0\nProducto: POLERÓN FULL ZIP RIVAL TERRY HOMBRE UNDER ARMOUR - Cantidad: 3 - Subtotal: 119970.0\nTotal de la venta: 159970.0\n\nFecha de la Venta: 04/12/24\nProducto: POLERÓN FULL ZIP RIVAL TERRY HOMBRE UNDER ARMOUR - Cantidad: 2 - Subtotal: 79980.0\nProducto: Nike Revolution 7 - Cantidad: 1 - Subtotal: 59990.0\nTotal de la venta: 139970.0\n\nFecha de la Venta: 04/12/24\nProducto: Adidas Grand Court Lifestyle - Cantidad: 1 - Subtotal: 40000.0\nProducto: Nike Revolution 7 - Cantidad: 2 - Subtotal: 119980.0\nProducto: Polera Algodon - Cantidad: 1 - Subtotal: 20000.0\nProducto: POLERÓN FULL ZIP RIVAL TERRY HOMBRE UNDER ARMOUR - Cantidad: 1 - Subtotal: 39990.0\nTotal de la venta: 219970.0\n\nFecha de la Venta: 05/12/24\nProducto: Polera oversize mujer - Cantidad: 2 - Subtotal: 50000.0\nTotal de la venta: 50000.0\n\nFecha de la Venta: 04/12/24\nProducto: Adidas Grand Court Lifestyle - Cantidad: 2 - Subtotal: 80000.0\nProducto: Pantalón Cargo Gabardina Forro Polar Hombre - Cantidad: 1 - Subtotal: 9000.0\nTotal de la venta: 89000.0\n\nFecha de la Venta: 05/12/24\nProducto: Nike Revolution 7 - Cantidad: 2 - Subtotal: 119980.0\nTotal de la venta: 119980.0\n\nFecha de la Venta: 05/12/24\nProducto: Polera oversize mujer - Cantidad: 2 - Subtotal: 50000.0\nProducto: Adidas Grand Court Lifestyle - Cantidad: 2 - Subtotal: 80000.0\nTotal de la venta: 130000.0\n\nFecha de la Venta: 08/12/24\nProducto: Nike Revolution 7 - Cantidad: 1 - Subtotal: 59990.0\nProducto: Polera oversize mujer - Cantidad: 2 - Subtotal: 50000.0\nTotal de la venta: 109990.0\n\n', '2024-12-08 17:07:43', 1018880),
(142, NULL, 'Fecha de la Venta: 09/12/24\nProducto: Polera Algodon - Cantidad: 2 - Subtotal: 40000.0\nProducto: Pantalón Cargo Gabardina Forro Polar Hombre - Cantidad: 1 - Subtotal: 9000.0\nTotal de la venta: 49000.0\n\n', '2024-12-09 22:49:59', 49000),
(143, NULL, 'Rango de la Semana: 09/12/2024 - 15/12/2024\n\nFecha de la Venta: 09/12/2024\nProducto: Polera Algodon - Cantidad: 2 - Subtotal: 40000.0\nProducto: Pantalón Cargo Gabardina Forro Polar Hombre - Cantidad: 1 - Subtotal: 9000.0\nTotal de la venta: 49000.0\n\n', '2024-12-09 22:50:01', 49000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ropa`
--

CREATE TABLE `ropa` (
  `ID` int(11) NOT NULL,
  `COLOR` varchar(255) DEFAULT NULL,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  `IMAGEN` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `PRECIO` double DEFAULT NULL,
  `STOCK` int(11) DEFAULT NULL,
  `TALLA` varchar(255) DEFAULT NULL,
  `TIPO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ropa`
--

INSERT INTO `ropa` (`ID`, `COLOR`, `DESCRIPCION`, `IMAGEN`, `NOMBRE`, `PRECIO`, `STOCK`, `TALLA`, `TIPO`) VALUES
(152, 'Negro', 'Cargamos el Revolution 7 con el tipo de amortiguación suave y soporte que podría cambiar tu mundo del running', 'https://nikeclprod.vtexassets.com/arquivos/ids/837308-1200-1200?v=638327428010130000&width=1200&height=1200&aspect=true', 'Nike Revolution 7', 59990, 0, '42', 'Zapatilla'),
(201, 'Negro', 'Under Armour te hace mejor. En eso nos enfocamos. Inspiramos a todo apasionado del deporte con soluciones de alto rendimiento que no sabías que necesitabas, pero que no te puedes imaginar viviendo sin ellas.', 'https://rimage.ripley.cl/home.ripley/Attachment/MKP/3550/MPM10001826083/full_image-2.jpeg', 'POLERÓN FULL ZIP RIVAL TERRY HOMBRE UNDER ARMOUR', 39990, 0, 'L', 'Poleron'),
(252, 'Negro', 'descripcion', 'https://sublimachile.cl/wp-content/uploads/2020/12/polera-negra-sublimachile.jpg', 'Polera Algodon', 20000, 0, 'S', 'Polera'),
(1001, 'Negro', 'Polera oversize con cuello redondo y hombros marcadamente caídos. Puños y bajo en punto elástico acanalado. Interior cepillado suave.', 'https://hmperu.vtexassets.com/arquivos/ids/4741835-600-900?v=638625087366870000&width=600&height=900&aspect=true', 'Polera oversize mujer', 25000, 4, 'S', 'Polera'),
(1052, 'Blanco', 'Hecha con una serie de materiales reciclados, esta parte superior incorpora al menos un 50 % de contenido reciclado.', 'https://assets.adidas.com/images/h_2000,f_auto,q_auto,fl_lossy,c_fill,g_auto/02cd9a97ce874d89ba17ae2b003ebe50_9366/Zapatillas_adidas_Grand_Court_Lifestyle_para_Tenis_con_Cordones_Blanco_GW6511_01_standard.jpg', 'Adidas Grand Court Lifestyle', 40000, 0, '43', 'Zapatilla'),
(1053, 'Negro', ' ¡Eleva tu estilo y comodidad con nuestros Pantalones Cargo Gabardina con Forro Polar de la línea Practical Line!', 'https://tworldstore.cl/6138-large_default/pantalon-cargo-gabardina-forro-polar-hombre.jpg', 'Pantalón Cargo Gabardina Forro Polar Hombre', 9000, 2, 'L', 'Pantalon');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sequence`
--

CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', 1450);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `PHONENUMBER` varchar(255) DEFAULT NULL,
  `ROLE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`ID`, `EMAIL`, `NAME`, `PASSWORD`, `PHONENUMBER`, `ROLE`) VALUES
(1, 'tobarbadillaaaa@gmail.com', 'admin', 'admin', '9-9807-2266', 'admin'),
(251, 'fabian@gmail.com', 'fabian', '123', '11111', 'cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `ID` int(11) NOT NULL,
  `FECHA` date DEFAULT NULL,
  `USUARIO_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`ID`, `FECHA`, `USUARIO_ID`) VALUES
(901, '2024-12-04', 1),
(951, '2024-12-04', 1),
(1101, '2024-12-04', 1),
(1151, '2024-12-05', 1),
(1201, '2024-12-04', 1),
(1251, '2024-12-05', 1),
(1301, '2024-12-05', 1),
(1351, '2024-12-08', 1),
(1401, '2024-12-09', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productoventa`
--
ALTER TABLE `productoventa`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_PRODUCTOVENTA_venta_id` (`venta_id`),
  ADD KEY `FK_PRODUCTOVENTA_PRODUCTO_ID` (`PRODUCTO_ID`);

--
-- Indices de la tabla `reportesemanal`
--
ALTER TABLE `reportesemanal`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `ropa`
--
ALTER TABLE `ropa`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_VENTA_USUARIO_ID` (`USUARIO_ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productoventa`
--
ALTER TABLE `productoventa`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `reportesemanal`
--
ALTER TABLE `reportesemanal`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=144;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `productoventa`
--
ALTER TABLE `productoventa`
  ADD CONSTRAINT `FK_PRODUCTOVENTA_PRODUCTO_ID` FOREIGN KEY (`PRODUCTO_ID`) REFERENCES `ropa` (`ID`),
  ADD CONSTRAINT `FK_PRODUCTOVENTA_venta_id` FOREIGN KEY (`venta_id`) REFERENCES `venta` (`ID`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `FK_VENTA_USUARIO_ID` FOREIGN KEY (`USUARIO_ID`) REFERENCES `user` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
