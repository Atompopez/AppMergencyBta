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
6.	Ver progreso en los diferentes módulos de formación
7.      Ver puntae obtenido en cada módulo
8.      Consultar puntajes y ver el historial de puntajes
9.	Bloquear o eliminar usuarios
10.	Consultar rol, progreso usuarios
11.     Cerrar sesión
12.     Jugar un juego llamado cayendo en la tipificación
13.     Eliminar usuarios (solo para usuario administrador)



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
RESUMEN	El usuario se podrá capacitar en diferentes temáticas, una de ellas es la codificación de los casos que se reportan a la línea de emergencias en cuyo caso tendrá la opción denominada "guía de tipificación", la otra opción es "geolocalización" para aprender a registrar y ubicar de manera correcta la ubicación del incidente reportado por parte del ciudadano y el otro es el de "servicio al ciudadano"  para aprender a darle manejo a la llamada superando limitaciones de la interacción con personas en estado de alteración, el módulo de formación deberá contener una introducción a cada módulo y una explicación de los códigos que se van a aprender y sus circunstancias modificadoras, es decir aquellas que pueden aumentar el nivel de prioridad y activar otra entidad o agencia, un módulo debe corresponder a un juego que permita al usuario practicar la codificación de los códigos y sus circunstancias modificadoras y que le permita obtener un puntaje final que le permita evaluar su conocimiento sobre los códigos y sus circunstancias modificadoras, para ello deberá jugar un juego de memoria en el que se ven diferentes opciones y debe seleccionar aquellas que corresponden a la codificación de los códigos y sus circunstancias modificadoras, el juego debe tener un tiempo límite y un puntaje final que le permita evaluar su conocimiento sobre los códigos y sus circunstancias modificadoras, el usuario podrá ver su puntaje final y un resumen de los códigos y sus circunstancias modificadoras que ha visto en el módulo.
El módulo de geolocalización deberá permitir al usuario aprender a registrar y ubicar de manera correcta la ubicación del incidente reportado por parte del ciudadano identificando cómo se registran las direcciones en Bogotá, cuando llevan la palabra sur y dónde la llevan, cuando la palabra este y dónde se ponen, las localidades y sus límites.

El módulo de servicio al ciudadano deberá permitir al usuario aprender a darle manejo a la llamada superando limitaciones de la interacción con personas en estado de alteración enfocando la atención hacia los detalles que permitan identificar de manera clara y en el menor tiempo posible, qué está pasando y dónde está pasando.

ENTRADAS	Módulos de formación diseñados para cada tema y rol
RESULTADO	El usuario podrá seleccionar el rol en el cual capacitarse
	
RF5. VER PROGRESO	
RESUMEN	El usuario podrá ver cuantos códigos ha visto en su proceso de formación, cuántos aciertos y desaciertos ha tenido a lo largo del curso y una sugerencia sobre los códigos en los que debería trabajar
ENTRADAS	Datos de progreso del usuario en relación con los módulos vistos y los avances que ha tenido el usuario en cada uno de ellos
RESULTADO	El usuario podrá ver su avance en cada módulo y un resumen de los temas vistos y sus aciertos y desaciertos
	
RF6. PRESENTAR EVALUACIÓN	
RESUMEN	El usuario podrá realizar evaluaciones que le permitirán evidenciar el resultado de su aprendizaje, el usuario podrá ver su puntaje final y un resumen de los códigos y sus circunstancias modificadoras que ha visto en el módulo
ENTRADAS	Formularios de evaluación
RESULTADO	El estudiante presentará evaluaciones que le darán un puntaje aprobatorio conforme va avanzando en el estudio de cada uno de los módulos

RF7. VER PUNTAJE
RESUMEN	El usuario podrá ver su puntaje obtenido en cada módulo de formación
ENTRADAS	Puntaje obtenido en cada módulo
RESULTADO	El usuario podrá ver su puntaje obtenido en cada módulo de formación

RF8. CONSULTAR ROL, PROGRESO USUARIOS
RESUMEN	El usuario podrá consultar el rol y progreso de los usuarios
ENTRADAS	Rol y progreso de los usuarios
RESULTADO	El usuario podrá consultar el rol y progreso de los usuarios

RF9. CERRAR SESIÓN
RESUMEN	El usuario podrá cerrar sesión
ENTRADAS	Sesión del usuario
RESULTADO	El usuario podrá cerrar sesión  

RF10. BLOQUEAR USUARIO
RESUMEN	El usuario podrá bloquear a los usuarios
ENTRADAS	Usuario a bloquear
RESULTADO	El usuario podrá bloquear a los usuarios

RF11. ELIMINAR USUARIO
RESUMEN	El usuario podrá eliminar a los usuarios
ENTRADAS	Usuario a eliminar
RESULTADO	El usuario podrá eliminar a los usuarios

RF12. CONSULTAR ROL, PROGRESO USUARIOS
RESUMEN	El usuario podrá consultar el rol y progreso de los usuarios
ENTRADAS	Rol y progreso de los usuarios
RESULTADO	El usuario podrá consultar el rol y progreso de los usuarios

RF13. JUGAR JUEGO
RESUMEN	        Se trata de un juego similar al tuxmath en el que se debe disparar a unos códigos su tipificación correcta en el acrónimo o en el código numérico y si lo digita bien destruirá el meteorito pero si el meteorito llega a la tierra se perde el juego, la idea es que gradualmente vaya aumentando la velocidad de caída y la cantidad de meteoritos que caen   
ENTRADAS	Juego de cayendo en la tipificación
RESULTADO	El usuario podrá jugar un juego llamado cayendo en la tipificación

![image](https://github.com/user-attachments/assets/b28c7f82-4955-4e0f-957b-a05457af0488)
