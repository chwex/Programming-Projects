CREATE TABLE [dbo].[Empleados]
(
	[Clave_Emp] INT NOT NULL PRIMARY KEY, 
    [Nombre] VARCHAR(50) NOT NULL, 
    [ApPaterno] VARCHAR(50) NOT NULL, 
    [ApMaterno] VARCHAR(50) NOT NULL, 
    [FecNac] DATETIME NOT NULL, 
    [Departamento] INT NOT NULL, 
    [Sueldo] MONEY NOT NULL
)
