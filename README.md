## GlobalTek-Prueba TECNICA

Este repositorio fue creado para facilitar la accesibilidad al código fuente que resuelve la prueba tecnica ubicada en la carpeta resoures del proyecto.

### Guia de instalación

Requisitios
- Java 8
- SQL Server 2018 - 2019
- Conexión a internet para el usos de los links referenciados de BOOSTRAP 5+
- Git y GitFlow
- Dependencias y librerias, ya vienen en el proyecto podra verlos en la carpeta 'Resources'

#### Pasos para clonar el código localmente
1. Crear una carpeta donde se van a guardar los fuentes del proyecto.
2. Abrir la consola de comando y dirigirse a la ruta donde creo la carpeta.
3. Ejecutar el comando **git init** (Para inicializar un control de versiones vació).
4. Ejecutar el comando **git clone https://github.com/sayerpro/GlobalTek-Prueba.git**
5. Ejecutar el comando **git flow init** (Para inicializar las ramas y branchs que utiliza git).
6. Bajar cambios con el comando. **git pull origin/master**
7. Bajar cambios de develop con el comando. **git checkout origin/develop**

## Utilidades Importantes

###### Fijese en la carpeta 'Resources' del proyecto allí encontrara varios archivos que pueden facilitar el uso de este software, en este caso cabe resaltar el archivo ***'Query_CrearBD.sql'***, este es un archivo sql con una sintaxis especifica para crear la base de datos necesaria para que el programa fncione de manera correcta al momento de gestionar informacion con la base de datos. hechele un vistazo y trate de entender primero la estructura

# Paso final
Una vez que se logre bajar el proyecto correctamente y tenga lista la Base de datos, dirijase al archivo ***'src\java\Configuration\Conection.java'***.

Allí encontrara la logica que se usa para generar una conexion estable con la base de datos, interprete el código de manera que lo entienda y haga las correcciones correspondientes para que pueda trabajar con la base de datos de su maquina local;

Se requieren cambios en las siguientes 3  variables:

##### Url
- Estructura
jdbc:sqlserver://localhost:(puerto);databaseName=(nombreBaseDeDatos));
######Ejemplo
jdbc:sqlserver://localhost:1433;databaseName=Facturacion;

##### User
- Estructura
(usuario)
###### Ejemplo
root

##### Password
- Estructura
(password)
###### Ejemplo
123





En caso de que no funcione contacte con el administrador del respositorio o considere prioritariamente soluciones en linea.

#### Anotaciones importartes a tener en cuenta
###### Porfavor Siempre asegurarse hacer Pull antes de subir cambios con Push. Esto para evitar conflicto de cambios en el repositorio.

###### En caso de tener dudas, complicaciones, inconvenientes y demás percances contacte con los colaboradores del repositorio.

> Ultima fecha de actualización
04/08/2022 - 7:00
Version 1.0.0
Autores - TheSrSmith - sayerpro.op7@gmail.com


