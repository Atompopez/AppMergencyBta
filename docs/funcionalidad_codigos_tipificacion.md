# Funcionalidad de Códigos de Tipificación

## Descripción
La funcionalidad de Códigos de Tipificación permite a los operadores de la línea de emergencia 123 aprender y practicar los códigos utilizados para clasificar las emergencias. Esta funcionalidad incluye:

1. **Lista de códigos de tipificación**: Muestra todos los códigos disponibles con su número, acrónimo y descripción.
2. **Detalle de código**: Permite ver información detallada de cada código, incluyendo preguntas clave, circunstancias modificadoras y transferencia de voz.
3. **Práctica de códigos**: Permite al usuario practicar la identificación de códigos a través de diferentes tipos de preguntas.
4. **Resumen de práctica**: Muestra un resumen del desempeño del usuario después de completar una sesión de práctica.

## Componentes implementados

### Base de datos
- **TypificationCode**: Entidad que representa un código de tipificación.
- **UserCodeProgress**: Entidad que registra el progreso del usuario con cada código.
- **TypificationCodeDao**: Interfaz para acceder a los códigos de tipificación.
- **UserCodeProgressDao**: Interfaz para acceder al progreso del usuario.
- **AppDatabase**: Clase que gestiona la base de datos Room.
- **DataProvider**: Clase que proporciona los datos iniciales para la base de datos.
- **TypificationRepository**: Clase que implementa el patrón repositorio para gestionar los datos.

### Interfaz de usuario
- **TypificationCodesFragment**: Fragmento que muestra la lista de códigos de tipificación.
- **CodeDetailFragment**: Fragmento que muestra los detalles de un código seleccionado.
- **CodePracticeFragment**: Fragmento que permite al usuario practicar la identificación de códigos.
- **PracticeSummaryFragment**: Fragmento que muestra el resumen de la práctica.
- **TypificationCodeAdapter**: Adaptador para mostrar los códigos en un RecyclerView.
- **PracticeOptionAdapter**: Adaptador para mostrar las opciones de respuesta en la práctica.

### Lógica de negocio
- **TypificationViewModel**: ViewModel que gestiona la lógica de negocio para la funcionalidad de códigos de tipificación.
- **QuestionType**: Enum que define los tipos de preguntas para la práctica.
- **PracticeQuestion**: Clase que representa una pregunta de práctica.
- **PracticeSummary**: Clase que representa el resumen de una práctica.

### Recursos
- **Animaciones**: Animaciones para mostrar feedback visual al usuario durante la práctica.
- **Íconos**: Íconos para representar visualmente cada código de tipificación.
- **Strings**: Textos para la interfaz de usuario.

## Flujo de usuario

1. El usuario accede a la sección "Códigos de Tipificación" desde el menú de navegación.
2. Se muestra la lista de códigos disponibles.
3. El usuario puede:
   - Seleccionar un código para ver sus detalles.
   - Iniciar una sesión de práctica.
4. Durante la práctica, el usuario responde a preguntas sobre los códigos.
5. Al finalizar la práctica, se muestra un resumen con su desempeño.
6. El progreso del usuario se guarda para personalizar futuras sesiones de práctica.

## Algoritmo de aprendizaje adaptativo

La funcionalidad implementa un algoritmo de aprendizaje adaptativo que:

1. Registra el desempeño del usuario con cada código.
2. Asigna un nivel de dificultad a cada código basado en el historial de respuestas.
3. Prioriza los códigos con mayor dificultad en futuras sesiones de práctica.
4. Ajusta dinámicamente la dificultad según el desempeño del usuario.

Este enfoque garantiza que los usuarios practiquen más los códigos que les resultan más difíciles, optimizando así su proceso de aprendizaje.

## Integración con el resto de la aplicación

La funcionalidad de Códigos de Tipificación se integra con:

- **Sistema de navegación**: A través del archivo de navegación y el menú lateral.
- **Sistema de usuarios**: Utilizando el ID de usuario para personalizar la experiencia.
- **Módulos de formación**: Como parte del proceso de capacitación general.

## Próximas mejoras

Para futuras versiones, se planea:

1. Implementar estadísticas detalladas del progreso del usuario.
2. Añadir modos de práctica con límite de tiempo.
3. Incorporar ejemplos de audio para la transferencia de voz.
4. Desarrollar escenarios de simulación completos.
