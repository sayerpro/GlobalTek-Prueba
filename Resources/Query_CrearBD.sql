/*PARA CREAR LA BASE DE DATOS CON LA ESTRUCTURA NECESARIO PARA SU FUNCIONAMIENTO SOLO EJECUTE LA SINTAXÍS QUE NO ESTA COMENTADA*/
CREATE DATABASE Facturacion;
GO
USE Facturacion;
GO
CREATE TABLE Facturas (
	idFactura		 INT IDENTITY(1, 1) PRIMARY KEY NOT NULL,
	NumeroFactura	 INT			 				NOT NULL,
	Fecha			 VARCHAR(20)					NOT NULL,
	TipoDePago		 VARCHAR(20)					NOT NULL,
	DocumentoCliente VARCHAR(20)					NOT NULL,
	NombreCliente    VARCHAR(50)					NOT NULL,
	SubTotal		 INT							NOT NULL,
	Descuento		 INT							NOT NULL,
	Iva				 INT							NOT NULL,
	TotalDescuento	 INT							NOT NULL,
	TotalImpuesto	 INT							NOT NULL,
	Total			 INT							NOT NULL
);
GO
CREATE TABLE Productos (
	idProducto INT IDENTITY(1, 1) PRIMARY KEY NOT NULL,
	Producto   VARCHAR(50)					  NOT NULL
);
GO
INSERT INTO Productos (Producto) VALUES ('Camisa'), ('Pantalón'), ('Zapatos'), ('Tenis'), ('Falda'), ('Chicles'), ('Collar'), ('Lápiz'), ('Chocolate'), ('Guantes'), ('Maceta'), ('Mouse');
GO
CREATE TABLE Detalles (
	idDetalle	   INT IDENTITY(1, 1) PRIMARY KEY NOT NULL,
	idFactura	   INT							  NOT NULL,
	idProducto	   INT						      NOT NULL,
	Cantidad	   INT							  NOT NULL,
	PrecioUnitario INT						      NOT NULL,
	CONSTRAINT FK_Facturas  FOREIGN KEY (idFactura)  REFERENCES Facturas  (idFactura),
	CONSTRAINT FK_Productos FOREIGN KEY (idProducto) REFERENCES Productos (idProducto)
);
GO
CREATE PROCEDURE InsertarFactura
	@NumeroFactura INT,
	@Fecha VARCHAR(20),
	@TipoDePago VARCHAR(20),
	@DocumentoCliente VARCHAR(20),
	@NombreCliente VARCHAR(50),
	@SubTotal INT,
	@Descuento INT,
	@Iva INT,
	@TotalDescuento INT,
	@TotalImpuesto INT,
	@Total INT,
	@Producto INT,
	@Cantidad INT,
	@PrecioUnitario INT
	AS
	BEGIN
		INSERT INTO Facturas (NumeroFactura, Fecha, TipoDePago, DocumentoCliente, NombreCliente, SubTotal, Descuento, Iva, TotalDescuento, TotalImpuesto, Total) VALUES 
			(@NumeroFactura, @Fecha, @TipoDePago, @DocumentoCliente, @NombreCliente, @SubTotal, @Descuento, @Iva, @TotalDescuento, @TotalImpuesto, @Total);

		INSERT INTO Detalles (idFactura, idProducto, Cantidad, PrecioUnitario) VALUES ((SELECT MAX(idFactura) FROM Facturas), @Producto, @Cantidad, @PrecioUnitario);
END
GO
CREATE PROCEDURE ConsultarFacturaCompleta
	@idFactura INT
	AS
	BEGIN
		SELECT * FROM Facturas INNER JOIN Detalles ON Facturas.idFactura = Detalles.idFactura WHERE Facturas.idFactura = @idFactura AND Detalles.idFactura = @idFactura;
END
GO
CREATE PROCEDURE ActualizarFacturaCompleta
	@idFactura INT,
	@NumeroFactura INT,
	@Fecha VARCHAR(20),
	@TipoDePago VARCHAR(20),
	@DocumentoCliente VARCHAR(20),
	@NombreCliente VARCHAR(50),
	@SubTotal INT,
	@Descuento INT,
	@Iva INT,
	@TotalDescuento INT,
	@TotalImpuesto INT,
	@Total INT,
	@Producto INT,
	@Cantidad INT,
	@PrecioUnitario INT
	AS
	BEGIN
		UPDATE Facturas SET Facturas.NumeroFactura = @NumeroFactura, Facturas.Fecha = @Fecha, Facturas.TipoDePago = @TipoDePago, Facturas.DocumentoCliente = @DocumentoCliente,
		Facturas.NombreCliente = @NombreCliente, Facturas.SubTotal = @SubTotal, Facturas.Descuento = @Descuento, Facturas.Iva = @Iva, Facturas.TotalDescuento = @TotalDescuento,
		Facturas.TotalImpuesto = @TotalImpuesto, Facturas.Total = @Total WHERE Facturas.idFactura = @idFactura;

		UPDATE Detalles SET Detalles.idProducto = @Producto, Detalles.Cantidad = @Cantidad, Detalles.PrecioUnitario = @PrecioUnitario WHERE Detalles.idFactura = @idFactura;
END
GO
CREATE PROCEDURE EliminarFacturas
	@idFactura INT
	AS
	BEGIN
		DELETE FROM Detalles WHERE idFactura = @idFactura;
		DELETE FROM Facturas WHERE idFactura = @idFactura;
END


/*SINTAXÍS DE UTILIDAD PARA EJECUCIONES RAPIDAS*/

/*INSERT INTO*/
---------------

/*
INSERT INTO Facturas (NumeroFactura, Fecha, TipoDePago, DocumentoCliente, NombreCliente, SubTotal, Descuento, Iva, TotalDescuento, TotalImpuesto, Total) VALUES
	(1, CURRENT_TIMESTAMP, 'Contado', '0123456789', 'GlobalTek', 100000, 10, 19, 10000, 19000, 109000);
INSERT INTO Productos (Producto) VALUES ('Camisa'), ('Pantalón'), ('Zapatos'), ('Tenis'), ('Falda'), ('Chicles'), ('Collar'), ('Lápiz'), ('Chocolate'), ('Guantes'), ('Maceta'), ('Mouse');
INSERT INTO Detalles (idFactura, idProducto, Cantidad, PrecioUnitario) VALUES (1, 1, 1, 150000);
*/



/*EJECUTAR PROCEDIMIENTO ALMACENADO PARA LLENAR TABLAS 'Facturas' y 'Detalles', la tabla 'Productos' debe estar llena con antelación*/
--------------------------------------------------------------------------------------------------------------------------------------

/*
DECLARE @Tiempo VARCHAR(20) = '03/08/2022';
EXECUTE InsertarFactura 1, @Tiempo, 'Contado', 0123456789, 'GlobalTek', 100000, 10, 19, 10000, 19000, 109000, 1, 1, 100000;
*/

/*
DECLARE @idFactura INT = 3;
EXECUTE ConsultarFacturaCompleta @idFactura;
*/

/*
DECLARE @idFactura INT = 1;
EXECUTE ActualizarFacturaCompleta 1, 2, @idFactura, 'Credito', 01234567892, 'GlobalTek2', 1000002, 102, 192, 100002, 190002, 1090002, 1, 12, 1000002;
*/

/*
DECLARE @idFactura INT = 1;
EXECUTE EliminarFacturas @idFactura;
*/

/*SELECT*/
----------

/*
SELECT * FROM Facturas;
SELECT * FROM Productos;
SELECT * FROM Detalles;
*/

/*DROP*/
--------

/*
DROP TABLE Detalles;
DROP TABLE Productos;
DROP TABLE Facturas;
DROP PROCEDURE InsertarFactura;
DROP PROCEDURE ConsultarFacturaCompleta;
USE master;
DROP DATABASE Facturacion;
*/