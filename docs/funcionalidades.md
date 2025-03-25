# Funcionalidades

La siguientes es una lista de las funcionalidades disponibles para el usuario de la aplicación:

PROBLEMA:	Capacitar de manera ágil y efectiva al personal que atiende la línea de emergencia de Bogotá en la codificación de los casos que reciben a través de la línea 123 y reducir los tiempos de respuesta, haciendo uso de dispositivos móviles para su uso generalizado por todas las personas que atienden llamadas con reportes de incidentes de seguridad y emergencias y aquellos que despachan recursos.

CLIENTE: Centro de Comando, Control, Comunicaciones y Cómputo de Bogotá, línea 123

USUARIO	Operadores de recepción de llamadas de emergencia y despachadores de recursos, patrullas, ambulancias camiones de bomberos

REQUERIMIENTOS FUNCIONALES	
1.	Registro de nuevos usuarios
2.	Inicio de sesión
3.	Selección de rol
4.	Acceso a módulos de formación
        i.	Guía de tipificación
        ii.	Geolocalización
        iii.	Servicio al ciudadano
5.	Evaluaciones 
6.	Ver progreso
7.	Bloquear o eliminar usuarios
8.	Consultar rol, progreso usuarios


RF1 REGISTRAR USUARIO	
RESUMEN	Los usuarios podrán registrarse según la entidad en la que prestan sus servicios y/o el rol que desempeñan
ENTRADAS	"Entidad en donde laboran
Nombre del usuario
Número de identificación
Contraseña
Rol que desempeña
Módulo de formación"
RESULTADO	El usuario se registrará en el sistema y podrá acceder a los distintos módulos de formación
	
RF2 INICAR SESIÓN	
RESUMEN	Los usuarios registrados podrán ingresar sus datos de usuario y contraseña para acceder a las funcionalidades de la aplicación
ENTRADAS	"Nombre del usuario
contraseña"
RESULTADO	El usuario ingresará a un listado con los módulos de capacitación según su rol y podrá ver el progreso
	
RF3 SELECCIONAR ROL	
RESUMEN	Según el tipo de usuario podrá elegir el rol de recepcionista de llamada o el de despachador de recursos, a su vez si es despachador podrá elegir entre las diferentes entidades que envian unidades para atender los incidentes, ejemplo: médico regulador, policía, bombero entre otros
ENTRADAS	"* Guía de tipificación de códigos según el rol y la entidad que corresponda.
* Módulo de geolocalización
* Módulo de servicio al ciudadano"
RESULTADO	El usuario podrá seleccionar el rol en el cual capacitarse
	
RF4 ACCEDER A MÓDULOS DE FORMACIÓN	
RESUMEN	El usuario se podrá capacitar en diferentes temáticas, una de ellas es la codificación de los casos que se reportan a la línea de emergencias en cuyo caso tendrá la opción denominada "guía de tipificación", la otra opción es "geolocalización" para aprender a registrar y ubicar de manera correcta la ubicación del incidente reportado por parte del ciudadano y el otro es el de "servicio al ciudadano"  para aprender a darle manejo a la llamada superando limitaciones de la interacción con personas en estado de alteración
ENTRADAS	Módulos de formación diseñados para cada tema y rol
RESULTADO	El usuario podrá seleccionar el rol en el cual capacitarse
	
RF5. VER PROGRESO	
RESUMEN	El usuario podrá ver cuantos códigos ha visto en su proceso de formación, cuántos aciertos y desaciertos ha tenido a lo largo del curso y una sugerencia sobre los códigos en los que debería trabajar
ENTRADAS	Datos de progreso del usuario en relación con los módulos vistos y los avances que ha tenido el usuario en cada uno de ellos
RESULTADO	El usuario podrá ver su avance en cada módulo y un resumen de los temas vistos y sus aciertos y desaciertos
	
RF6. PRESENTAR EVALUACIÓN	
RESUMEN	El usuario podrá realizar evaluaciones que le permitirán evidenciar el resultado de su aprendizaje
ENTRADAS	Formularios de evaluación
RESULTADO	El estudiante presentará evaluaciones que le darán un puntaje aprobatorio conforme va avanzando en el estudio de cada uno de los módulos
![image](https://github.com/user-attachments/assets/b28c7f82-4955-4e0f-957b-a05457af0488)
