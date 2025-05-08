package com.example.appmergencybta.data

import com.example.appmergencybta.R
import com.example.appmergencybta.data.model.Evaluation
import com.example.appmergencybta.data.model.Lesson
import com.example.appmergencybta.data.model.Module
import com.example.appmergencybta.data.model.Question

/**
 * Clase que proporciona acceso a los módulos de formación
 */
class ModuleRepository {
    
    /**
     * Obtiene todos los módulos de formación disponibles
     */
    fun getAllModules(): List<Module> {
        return listOf(
            createTipificationModule(),
            createGeolocalizationModule(),
            createCustomerServiceModule()
        )
    }
    
    /**
     * Obtiene un módulo por su ID
     */
    fun getModuleById(moduleId: String): Module? {
        return getAllModules().find { it.id == moduleId }
    }
    
    /**
     * Obtiene los módulos disponibles para un rol específico
     */
    fun getModulesForRole(role: String): List<Module> {
        return getAllModules().filter { it.requiredRoles.contains(role) }
    }
    
    /**
     * Crea el módulo de Guía de Tipificación
     */
    private fun createTipificationModule(): Module {
        return Module(
            id = "tipification",
            title = "Guía de Tipificación",
            description = "Aprende a codificar correctamente los incidentes reportados a la línea de emergencia",
            imageResource = R.drawable.ic_menu_gallery, // Cambiar por imagen adecuada
            lessons = createTipificationLessons(),
            evaluations = createTipificationEvaluations()
        )
    }
    
    /**
     * Crea el módulo de Geolocalización
     */
    private fun createGeolocalizationModule(): Module {
        return Module(
            id = "geolocalization",
            title = "Geolocalización",
            description = "Aprende a registrar y ubicar correctamente la ubicación de los incidentes",
            imageResource = R.drawable.ic_menu_gallery, // Cambiar por imagen adecuada
            lessons = createGeolocalizationLessons(),
            evaluations = createGeolocalizationEvaluations()
        )
    }
    
    /**
     * Crea el módulo de Servicio al Ciudadano
     */
    private fun createCustomerServiceModule(): Module {
        return Module(
            id = "customer_service",
            title = "Servicio al Ciudadano",
            description = "Aprende a manejar llamadas de emergencia y a interactuar con personas en estado de alteración",
            imageResource = R.drawable.ic_menu_gallery, // Cambiar por imagen adecuada
            lessons = createCustomerServiceLessons(),
            evaluations = createCustomerServiceEvaluations()
        )
    }
    
    /**
     * Crea las lecciones para el módulo de Tipificación
     */
    private fun createTipificationLessons(): List<Lesson> {
        return listOf(
            Lesson(
                id = "tipification_intro",
                title = "Introducción a la Tipificación",
                content = "La tipificación de incidentes es el proceso mediante el cual se asigna un código específico a cada tipo de emergencia reportada. Esto permite categorizar y priorizar adecuadamente las llamadas recibidas en la línea 123, facilitando la asignación de recursos y la respuesta oportuna a las emergencias.\n\nLa correcta tipificación es crucial para el funcionamiento eficiente del sistema de emergencias de Bogotá, ya que determina qué agencias deben ser activadas, el nivel de prioridad y los recursos necesarios para atender cada situación. Un error en la tipificación puede resultar en una respuesta inadecuada o tardía, poniendo en riesgo la vida y seguridad de los ciudadanos.\n\nComo operador de la línea 123, tu rol en este proceso es fundamental, ya que eres el primer punto de contacto con el ciudadano y quien debe extraer la información necesaria para asignar el código correcto.",
                order = 1
            ),
            Lesson(
                id = "tipification_codes",
                title = "Códigos de Emergencia",
                content = "Los códigos de emergencia están organizados por categorías según el tipo de incidente. Cada código tiene un significado específico y puede tener modificadores que indican circunstancias especiales. Es fundamental memorizar estos códigos para una respuesta rápida y eficaz.\n\nLos códigos se dividen en las siguientes categorías principales:\n\n1. Seguridad: Incluye delitos contra personas y propiedad\n   - 602: Hurto a persona sin arma\n   - 603: Hurto a persona con arma\n   - 604: Lesiones personales\n   - 605: Riña\n   - 606: Violencia intrafamiliar\n\n2. Médica: Situaciones que requieren atención médica\n   - 800: Paro cardiorrespiratorio\n   - 801: Dificultad respiratoria\n   - 802: Herida por arma\n   - 803: Intoxicación\n   - 804: Enfermedad general\n\n3. Incendios: Situaciones que involucran fuego\n   - 901: Incendio estructural\n   - 902: Incendio vehicular\n\n4. Tránsito: Incidentes relacionados con el tránsito\n   - 929: Accidente de tránsito (con modificadores H, M, T)\n\n5. Desastres: Incidentes que afectan infraestructura o grandes áreas\n   - 950: Inundación\n   - 951: Deslizamiento\n\nLa memorización y correcta aplicación de estos códigos es esencial para tu labor como operador de la línea 123.",
                order = 2
            ),
            Lesson(
                id = "tipification_modifiers",
                title = "Modificadores de Códigos",
                content = "Los modificadores son elementos adicionales que se agregan a los códigos básicos para indicar circunstancias específicas del incidente, como la presencia de armas, personas heridas, o situaciones de riesgo especial.\n\nLos principales modificadores utilizados en el sistema de emergencias de Bogotá son:\n\n- H: Herido. Indica que hay personas lesionadas en el incidente.\n  Ejemplo: 929-H (Accidente de tránsito con heridos)\n\n- M: Menor de edad. Indica la participación o afectación de menores de edad.\n  Ejemplo: 606-M (Violencia intrafamiliar con menores afectados)\n\n- T: Persona atrapada. Indica que hay personas atrapadas en estructuras o vehículos.\n  Ejemplo: 929-T (Accidente de tránsito con personas atrapadas)\n\nLos modificadores pueden combinarse cuando múltiples circunstancias están presentes.\nEjemplo: 929-H-T (Accidente de tránsito con heridos y personas atrapadas)\n\nEl uso correcto de los modificadores permite a las agencias de respuesta prepararse adecuadamente antes de llegar al lugar del incidente.",
                order = 3
            ),
            Lesson(
                id = "tipification_agencies",
                title = "Agencias de Respuesta",
                content = "Cada código de emergencia está asociado a una o más agencias de respuesta, como Policía, Bomberos, o Servicios Médicos. Es importante conocer qué agencia debe ser activada para cada tipo de incidente.\n\nLas principales agencias de respuesta en Bogotá son:\n\n1. Policía Nacional:\n   - Atiende incidentes de seguridad ciudadana (códigos 602-606)\n   - Apoyo en emergencias de tránsito (código 929)\n\n2. Servicios Médicos:\n   - Emergencias médicas (códigos 800-804)\n   - Atención a heridos en cualquier tipo de incidente\n   - Traslados hospitalarios\n\n3. Bomberos:\n   - Incendios estructurales y vehiculares (códigos 901-902)\n   - Rescates en altura, espacios confinados o estructuras colapsadas\n   - Incidentes con materiales peligrosos\n   - Rescate de personas atrapadas en accidentes de tránsito\n\n4. Defensa Civil:\n   - Apoyo en desastres naturales (códigos 950-951)\n   - Búsqueda y rescate\n   - Evacuaciones\n\nEn muchos casos, se requiere la activación de múltiples agencias para atender un mismo incidente. Por ejemplo, un accidente de tránsito con heridos puede requerir la presencia de Policía, Servicios Médicos y Bomberos simultáneamente.",
                order = 4
            ),
            Lesson(
                id = "tipification_priority",
                title = "Priorización de Incidentes",
                content = "No todas las emergencias tienen la misma urgencia. Aprende a identificar el nivel de prioridad de cada incidente para asignar recursos de manera eficiente.\n\nLos niveles de prioridad utilizados en el sistema de emergencias de Bogotá son:\n\n1. Prioridad Alta (Rojo):\n   - Situaciones que representan un riesgo inmediato para la vida\n   - Incidentes con múltiples víctimas\n   - Delitos violentos en progreso\n   - Ejemplos: paro cardiorrespiratorio, incendio estructural con personas atrapadas, robo con arma de fuego en progreso\n\n2. Prioridad Media (Amarillo):\n   - Situaciones que requieren atención urgente pero no representan un riesgo inmediato para la vida\n   - Incidentes con heridos no críticos\n   - Delitos ya ocurridos donde el perpetrador ya no está en la escena\n   - Ejemplos: accidente de tránsito con heridos leves, hurto ya ocurrido, inundación sin personas en peligro\n\n3. Prioridad Baja (Verde):\n   - Situaciones que pueden ser atendidas de manera programada\n   - Incidentes sin heridos\n   - Situaciones de convivencia no violentas\n   - Ejemplos: vehículo mal estacionado, ruido excesivo, daños en la vía pública\n\nFactores que influyen en la priorización:\n\n- Presencia de armas\n- Personas heridas o en peligro\n- Incidente en progreso vs. ya ocurrido\n- Afectación a población vulnerable (niños, adultos mayores)\n- Cantidad de personas afectadas\n- Riesgo de escalamiento\n\nLa correcta priorización es fundamental para optimizar los recursos disponibles y garantizar que las emergencias más graves reciban atención inmediata.",
                order = 5
            )
        )
    }
    
    /**
     * Crea las evaluaciones para el módulo de Tipificación
     */
    private fun createTipificationEvaluations(): List<Evaluation> {
        return listOf(
            Evaluation(
                id = "tipification_basic",
                title = "Evaluación Básica de Tipificación",
                description = "Evaluación sobre los conceptos básicos de tipificación de incidentes",
                questions = listOf(
                    Question(
                        id = "q1",
                        text = "¿Qué código se utiliza para un robo a persona sin arma?",
                        options = listOf("911", "602", "302", "101"),
                        correctOptionIndex = 1,
                        explanation = "El código 602 corresponde a hurto a persona sin arma"
                    ),
                    Question(
                        id = "q2",
                        text = "¿Qué agencia debe responder primero a un incendio estructural?",
                        options = listOf("Policía", "Bomberos", "Defensa Civil", "Ambulancia"),
                        correctOptionIndex = 1,
                        explanation = "Los Bomberos son la agencia principal para atender incendios estructurales"
                    ),
                    Question(
                        id = "q3",
                        text = "¿Qué modificador se usa cuando hay personas heridas en el incidente?",
                        options = listOf("A", "H", "P", "M"),
                        correctOptionIndex = 1,
                        explanation = "El modificador H (Herido) se utiliza cuando hay personas lesionadas en el incidente"
                    )
                )
            ),
            Evaluation(
                id = "tipification_advanced",
                title = "Evaluación Avanzada de Tipificación",
                description = "Evaluación sobre casos complejos de tipificación de incidentes",
                questions = listOf(
                    Question(
                        id = "q1",
                        text = "Un ciudadano reporta un robo a mano armada con una persona herida. ¿Qué código y modificadores utilizarías?",
                        options = listOf("602-A", "603-H", "603-A-H", "602-H"),
                        correctOptionIndex = 2,
                        explanation = "603 es robo a persona con arma, A indica presencia de arma y H indica herido"
                    ),
                    Question(
                        id = "q2",
                        text = "¿Qué código corresponde a un accidente de tránsito con personas atrapadas?",
                        options = listOf("901-A", "902-T", "903-H", "929-T"),
                        correctOptionIndex = 3,
                        explanation = "929 es accidente de tránsito y T indica personas atrapadas"
                    )
                )
            )
        )
    }
    
    /**
     * Crea las lecciones para el módulo de Geolocalización
     */
    private fun createGeolocalizationLessons(): List<Lesson> {
        return listOf(
            Lesson(
                id = "geo_intro",
                title = "Introducción a la Geolocalización",
                content = "La geolocalización es fundamental para ubicar correctamente los incidentes y enviar los recursos adecuados al lugar exacto. En esta lección aprenderás los conceptos básicos de geolocalización y su importancia en la atención de emergencias.\n\n¿Qué es la geolocalización?\nLa geolocalización es el proceso de determinar la ubicación geográfica precisa de un incidente o persona. En el contexto de la línea de emergencia 123, es el proceso mediante el cual identificamos dónde está ocurriendo una emergencia para poder enviar los recursos adecuados al lugar correcto.\n\n¿Por qué es importante la geolocalización en emergencias?\n- Reduce el tiempo de respuesta: Conocer la ubicación exacta permite enviar recursos por la ruta más rápida.\n- Optimiza recursos: Se pueden asignar las unidades más cercanas al incidente.\n- Evita confusiones: Previene que los equipos de emergencia acudan a direcciones erróneas.\n- Facilita la coordinación: Permite que diferentes agencias conozcan con precisión dónde deben acudir.\n\nEn Bogotá, la geolocalización es particularmente desafiante debido a:\n- La compleja nomenclatura urbana\n- La existencia de barrios informales\n- Áreas rurales con direcciones no estandarizadas\n- Zonas con nombres similares en diferentes localidades\n\nComo operador de la línea 123, tu habilidad para geolocalizar correctamente un incidente puede ser la diferencia entre una respuesta oportuna y un retraso crítico que ponga en riesgo vidas humanas.",
                order = 1
            ),
            Lesson(
                id = "geo_tools",
                title = "Herramientas de Geolocalización",
                content = "Conoce las diferentes herramientas y sistemas utilizados para la geolocalización de incidentes, como mapas digitales, GPS y sistemas de información geográfica.\n\nSistema de Información Geográfica (SIG) del C4:\nEl Centro de Comando, Control, Comunicaciones y Cómputo (C4) de Bogotá cuenta con un sistema integrado que incluye:\n\n1. Mapas digitales de Bogotá:\n   - Visualización en tiempo real de la ciudad\n   - Capas de información con nomenclatura oficial\n   - Puntos de referencia actualizados\n   - División por localidades, UPZ y barrios\n\n2. Sistema de Posicionamiento Global (GPS):\n   - Localización de unidades de respuesta en tiempo real\n   - Cálculo de rutas óptimas\n   - Estimación de tiempos de llegada\n\n3. Herramientas de triangulación de llamadas:\n   - Determinación aproximada de la ubicación del llamante mediante antenas de telefonía\n   - Útil cuando el ciudadano desconoce su ubicación exacta\n\n4. Integración con cámaras de videovigilancia:\n   - Verificación visual de incidentes reportados\n   - Monitoreo de situaciones en desarrollo\n\n5. Base de datos de direcciones y alias:\n   - Registro de nombres comunes para lugares específicos\n   - Conversión entre diferentes formatos de dirección\n\nComo operador, tendrás acceso a estas herramientas a través de la interfaz del sistema CAD (Computer-Aided Dispatch), que te permitirá visualizar mapas, buscar direcciones y registrar la ubicación precisa de los incidentes reportados.",
                order = 2
            ),
            Lesson(
                id = "geo_address",
                title = "Identificación de Direcciones",
                content = "Aprende a identificar y registrar correctamente las direcciones en Bogotá, considerando nomenclatura, puntos de referencia y características especiales.\n\nNomenclatura urbana de Bogotá:\n\n1. Componentes básicos de una dirección:\n   - Tipo de vía: Calle, Carrera, Diagonal, Transversal, Avenida\n   - Número de vía principal: Identifica la vía principal (ej: Calle 80)\n   - Número de vía generadora: Identifica la vía secundaria (ej: # 20)\n   - Distancia en metros: Distancia desde la vía generadora (ej: -15)\n   - Complemento: Información adicional (ej: Torre 3, Apto 502)\n\n2. Formatos comunes de direcciones:\n   - Formato estándar: Calle 80 # 20-15\n   - Con avenidas: Avenida Carrera 30 # 45-70\n   - Con complementos: Carrera 7 # 45-10 Edificio Centro, Oficina 304\n\n3. Técnicas para obtener direcciones precisas:\n   - Solicitar siempre el tipo de vía (calle, carrera, etc.)\n   - Confirmar los números en orden (vía principal, generadora, distancia)\n   - Pedir referencias cercanas (centros comerciales, parques, estaciones)\n   - Identificar el barrio y la localidad\n   - Preguntar por puntos cardinales cuando aplique (Norte, Sur, etc.)\n\n4. Manejo de situaciones especiales:\n   - Ciudadano que desconoce su ubicación exacta:\n     * Solicitar puntos de referencia visibles\n     * Preguntar por establecimientos comerciales cercanos\n     * Identificar características únicas del entorno\n   - Áreas rurales:\n     * Utilizar nombres de veredas o corregimientos\n     * Identificar kilómetros de vías principales\n     * Registrar referencias naturales (ríos, montañas)\n   - Barrios informales:\n     * Usar nomenclatura común en la zona\n     * Registrar puntos de referencia conocidos\n\nRecuerda: Una dirección bien tomada es el primer paso para una respuesta efectiva a la emergencia. Siempre verifica la información con el ciudadano y utiliza las herramientas de geolocalización disponibles para confirmar la ubicación.",
                order = 3
            ),
            Lesson(
                id = "geo_cases",
                title = "Casos Prácticos de Geolocalización",
                content = "En esta lección analizaremos casos prácticos para aplicar las técnicas de geolocalización en situaciones reales de emergencia.\n\nCaso 1: Accidente de tránsito en vía principal\nSituación: Un ciudadano reporta un accidente entre dos vehículos en la Avenida Boyacá.\nPasos para geolocalizar:\n1. Identificar la vía principal: \"Está en la Avenida Boyacá, ¿en qué dirección va? ¿Norte-Sur o Sur-Norte?\"\n2. Buscar intersecciones: \"Por favor, dígame qué calle o carrera cruza cerca del accidente\"\n3. Confirmar puntos de referencia: \"Veo que está cerca del centro comercial Titan Plaza, ¿es correcto?\"\n4. Validar con el sistema: Utilizar el mapa digital para ubicar la intersección de Av. Boyacá con Calle 80, cerca del Titan Plaza.\n\nCaso 2: Emergencia médica en zona residencial\nSituación: Una persona reporta que su familiar está inconsciente en un apartamento.\nPasos para geolocalizar:\n1. Obtener dirección completa: \"Por favor, dígame la dirección exacta incluyendo torre, bloque y apartamento\"\n2. Confirmar el nombre del conjunto residencial: \"El conjunto se llama Parques de Salitre, ¿es correcto?\"\n3. Identificar accesos: \"Por favor, indíqueme por cuál entrada deben ingresar los paramédicos\"\n4. Registrar detalles adicionales: \"El apartamento está en el quinto piso y no hay ascensor\"\n\nCaso 3: Incidente en zona rural\nSituación: Reporte de incendio forestal en los cerros orientales.\nPasos para geolocalizar:\n1. Identificar la vereda o sector: \"Está en la vereda El Verjón, ¿es correcto?\"\n2. Buscar vías de acceso: \"Por favor, indíqueme qué vía tomó para llegar a ese lugar\"\n3. Establecer puntos de referencia naturales: \"Veo una quebrada grande y estoy cerca de una finca con vacas\"\n4. Utilizar coordenadas si es posible: Solicitar al ciudadano que comparta su ubicación por WhatsApp si tiene un smartphone\n\nRecuerda que la precisión en la geolocalización puede marcar la diferencia entre una respuesta oportuna y un retraso crítico en la atención de la emergencia.",
                order = 4
            )
        )
    }
    
    /**
     * Crea las evaluaciones para el módulo de Geolocalización
     */
    private fun createGeolocalizationEvaluations(): List<Evaluation> {
        return listOf(
            Evaluation(
                id = "geo_basic",
                title = "Evaluación Básica de Geolocalización",
                description = "Evaluación sobre los conceptos básicos de geolocalización",
                questions = listOf(
                    Question(
                        id = "q1",
                        text = "¿Cuál es la forma correcta de registrar una dirección en Bogotá?",
                        options = listOf(
                            "Calle 123 # 45-67",
                            "Carrera 45 # 123-67",
                            "Avenida Calle 123 # 45-67",
                            "Todas las anteriores son correctas"
                        ),
                        correctOptionIndex = 3,
                        explanation = "Todas son formas válidas de registrar direcciones en Bogotá"
                    ),
                    Question(
                        id = "q2",
                        text = "¿Qué información adicional es útil solicitar cuando el ciudadano no conoce la dirección exacta?",
                        options = listOf(
                            "Solo el barrio",
                            "Puntos de referencia cercanos",
                            "El estrato socioeconómico",
                            "El nombre del alcalde local"
                        ),
                        correctOptionIndex = 1,
                        explanation = "Los puntos de referencia son fundamentales para ubicar un incidente cuando no se tiene la dirección exacta"
                    )
                )
            )
        )
    }
    
    /**
     * Crea las lecciones para el módulo de Servicio al Ciudadano
     */
    private fun createCustomerServiceLessons(): List<Lesson> {
        return listOf(
            Lesson(
                id = "cs_intro",
                title = "Atención en Situaciones de Crisis",
                content = "Aprende técnicas para mantener la calma y obtener información crucial de personas que se encuentran en estado de alteración o crisis emocional.\n\nLa atención de llamadas de emergencia requiere habilidades especiales para manejar situaciones donde el ciudadano puede estar experimentando altos niveles de estrés, miedo o pánico. Como operador de la línea 123, tu capacidad para mantener la calma y guiar al ciudadano es fundamental.\n\nReacciones comunes en situaciones de crisis:\n\n1. Respuestas emocionales:\n   - Miedo intenso o pánico\n   - Ira o agresión verbal\n   - Llanto o desesperación\n   - Confusión o desorientación\n   - Shock o negación\n\n2. Respuestas cognitivas:\n   - Dificultad para procesar información\n   - Incapacidad para recordar detalles importantes\n   - Pensamiento desorganizado\n   - Dificultad para seguir instrucciones\n\n3. Respuestas físicas:\n   - Hiperventilación\n   - Temblores en la voz\n   - Tartamudeo\n   - Habla acelerada\n\nTécnicas para la atención en crisis:\n\n1. Control de la llamada:\n   - Utiliza un tono de voz firme pero tranquilizador\n   - Habla con claridad y a un ritmo moderado\n   - Evita interrumpir al ciudadano, pero guía la conversación\n   - Utiliza frases cortas y directas\n\n2. Técnicas de contención emocional:\n   - Reconoce las emociones del ciudadano: \"Entiendo que está asustado/preocupado\"\n   - Normaliza la reacción: \"Es normal sentirse así en esta situación\"\n   - Ofrece apoyo: \"Estoy aquí para ayudarle, vamos a resolver esto juntos\"\n   - Técnica de anclaje: \"Respire profundamente conmigo, inhale... exhale...\"\n\n3. Obtención de información crucial:\n   - Prioriza las preguntas: ubicación, tipo de emergencia, personas afectadas\n   - Utiliza preguntas cerradas cuando la persona está muy alterada\n   - Confirma la información obtenida: \"Entonces, me dice que está en...\"\n   - Mantente enfocado en los datos esenciales\n\nRecuerda que tu actitud y manejo de la llamada puede influir directamente en la capacidad del ciudadano para proporcionar información vital y seguir instrucciones que podrían salvar vidas.",
                order = 1
            ),
            Lesson(
                id = "cs_communication",
                title = "Comunicación Efectiva",
                content = "Desarrolla habilidades de comunicación efectiva para obtener información clara y precisa durante llamadas de emergencia.\n\nLa comunicación efectiva es una herramienta esencial para los operadores de la línea 123. Tu capacidad para comunicarte claramente y obtener información precisa puede ser determinante en la respuesta a una emergencia.\n\nElementos clave de la comunicación efectiva:\n\n1. Escucha activa:\n   - Presta atención completa al ciudadano\n   - Evita interrupciones innecesarias\n   - Identifica la información crucial entre todo lo que dice el ciudadano\n   - Utiliza confirmaciones verbales: \"Le estoy escuchando\", \"Entiendo\"\n\n2. Lenguaje claro y sencillo:\n   - Evita términos técnicos o jerga especializada\n   - Adapta tu vocabulario al nivel del ciudadano\n   - Utiliza frases cortas y directas\n   - Evita ambigüedades o expresiones que puedan malinterpretarse\n\n3. Preguntas efectivas:\n   - Preguntas abiertas para obtener descripciones: \"Cuénteme qué está viendo\"\n   - Preguntas cerradas para confirmar datos específicos: \"Está la persona consciente, sí o no?\"\n   - Preguntas de sondeo para profundizar: \"Puede describir cómo es la herida?\"\n   - Preguntas de confirmación: \"Entonces, me dice que hay tres personas heridas, ¿es correcto?\"\n\n4. Manejo de silencios:\n   - Utiliza silencios breves para permitir que el ciudadano procese la información\n   - Evita silencios prolongados que puedan generar ansiedad\n   - Informa al ciudadano si necesitas un momento: \"Permaneceré en silencio un momento mientras registro esta información\"\n\n5. Comunicación no verbal (a través de la voz):\n   - Tono de voz: adaptado a la situación (firme pero tranquilizador)\n   - Ritmo: moderado, ni muy rápido ni muy lento\n   - Volumen: adecuado para ser escuchado claramente\n   - Entonación: que transmita seguridad y confianza\n\n6. Barreras de comunicación y cómo superarlas:\n   - Ruido ambiental: solicitar al ciudadano que se mueva a un lugar más tranquilo si es posible\n   - Barreras idiomáticas: utilizar lenguaje más sencillo o solicitar apoyo de traducción\n   - Limitaciones tecnológicas: pedir al ciudadano que hable más fuerte o repetir la información\n   - Estado emocional: utilizar técnicas de contención emocional\n\nRecuerda que la comunicación efectiva no solo te permite obtener información crucial, sino que también transmite seguridad al ciudadano y puede ayudar a reducir su nivel de estrés durante la emergencia.",
                order = 2
            ),
            Lesson(
                id = "cs_protocol",
                title = "Protocolos de Atención",
                content = "Conoce los protocolos establecidos para la atención de diferentes tipos de emergencias y cómo aplicarlos correctamente.\n\nLos protocolos de atención son guías estandarizadas que establecen los pasos a seguir durante la recepción y gestión de llamadas de emergencia. Estos protocolos garantizan una respuesta uniforme, eficiente y de calidad a los ciudadanos.\n\nEstructura general de los protocolos de atención:\n\n1. Recepción de la llamada:\n   - Saludo institucional: \"Línea 123 Bogotá, ¿en qué puedo ayudarle?\"\n   - Identificación del tipo de emergencia\n   - Determinación del nivel de prioridad\n\n2. Recolección de información básica (en este orden):\n   - Ubicación exacta del incidente\n   - Tipo de emergencia\n   - Detalles específicos según el tipo de incidente\n   - Datos del reportante (opcional, no prioritario en emergencias graves)\n\n3. Clasificación y tipificación:\n   - Asignación del código correspondiente\n   - Determinación de agencias a activar\n   - Establecimiento del nivel de prioridad\n\n4. Instrucción al ciudadano:\n   - Indicaciones de primeros auxilios si aplica\n   - Medidas de seguridad a tomar\n   - Información sobre la respuesta que recibirá\n\n5. Cierre de la llamada:\n   - Confirmación de datos\n   - Instrucción de volver a llamar si la situación cambia\n   - Despedida institucional\n\nProtocolos específicos por tipo de emergencia:\n\n1. Emergencias médicas:\n   - Verificar estado de consciencia de la víctima\n   - Comprobar respiración\n   - Identificar tipo de lesión o condición\n   - Brindar instrucciones de primeros auxilios según el caso\n\n2. Incidentes de seguridad:\n   - Determinar si el incidente está en progreso o ya ocurrió\n   - Verificar presencia de armas\n   - Identificar número y descripción de sospechosos\n   - Instruir al ciudadano sobre medidas de seguridad\n\n3. Accidentes de tránsito:\n   - Determinar número de vehículos involucrados\n   - Verificar presencia de heridos\n   - Comprobar si hay personas atrapadas\n   - Identificar riesgos adicionales (derrame de combustible, incendio)\n\n4. Incendios:\n   - Determinar tipo de estructura o material en combustión\n   - Verificar presencia de personas atrapadas\n   - Identificar riesgos especiales (materiales peligrosos)\n   - Instruir sobre evacuación segura\n\nRecuerda que estos protocolos deben aplicarse con flexibilidad, adaptándolos a las circunstancias específicas de cada emergencia, pero siempre manteniendo la estructura básica que garantiza una atención completa y efectiva.",
                order = 3
            ),
            Lesson(
                id = "cs_special_cases",
                title = "Manejo de Casos Especiales",
                content = "Aprende a manejar situaciones especiales como llamadas de niños, personas con discapacidad, adultos mayores o casos de violencia intrafamiliar.\n\nAlgunas emergencias requieren un enfoque especializado debido a las características particulares del ciudadano o de la situación. Como operador de la línea 123, debes estar preparado para adaptar tu comunicación y procedimientos a estas circunstancias especiales.\n\n1. Atención a niños y adolescentes:\n   - Utiliza un lenguaje sencillo y adecuado a su edad\n   - Mantén un tono tranquilizador y paciente\n   - Haz preguntas directas y concretas\n   - Valida sus emociones: \"Entiendo que estés asustado, estás haciendo muy bien en llamar\"\n   - Intenta establecer si hay adultos cerca que puedan ayudar\n   - Prioriza la obtención de la ubicación\n\n2. Personas con discapacidad:\n   - Discapacidad auditiva: habla con claridad, utiliza frases cortas, considera la posibilidad de que estén usando un servicio de retransmisión\n   - Discapacidad cognitiva: utiliza lenguaje simple, haz una pregunta a la vez, sé paciente con las respuestas\n   - Discapacidad del habla: da tiempo suficiente para responder, haz preguntas que puedan contestarse con \"sí\" o \"no\"\n   - Discapacidad visual: solicita descripciones detalladas del entorno para ayudar en la ubicación\n\n3. Adultos mayores:\n   - Habla con claridad y a un ritmo moderado\n   - Evita términos técnicos o jerga\n   - Sé paciente si necesitan más tiempo para procesar información\n   - Confirma la comprensión frecuentemente\n   - Considera posibles limitaciones físicas al dar instrucciones\n\n4. Casos de violencia intrafamiliar:\n   - Reconoce señales de llamadas encubiertas (la persona no puede hablar libremente)\n   - Desarrolla códigos o preguntas de sí/no si sospechas que la persona está siendo vigilada\n   - Prioriza la seguridad inmediata: \"Está el agresor presente ahora?\"\n   - Evita juicios o cuestionamientos sobre las acciones de la víctima\n   - Mantiene la confidencialidad y privacidad\n\n5. Personas en crisis suicida:\n   - Toma todas las amenazas de suicidio con seriedad\n   - Mantente en la línea, no termines la llamada\n   - Escucha activamente y valida sus sentimientos\n   - Evita minimizar sus problemas o dar consejos simplistas\n   - Enfoca la conversación en la seguridad inmediata\n   - Obtiene información sobre su ubicación lo antes posible\n\n6. Llamadas en idioma extranjero:\n   - Identifica el idioma si es posible\n   - Utiliza frases básicas en inglés si el ciudadano parece entenderlo\n   - Solicita apoyo de traducción cuando esté disponible\n   - Utiliza palabras clave universales como \"emergencia\", \"policía\", \"ambulancia\"\n\nRecuerda que la adaptabilidad y la empatía son fundamentales para manejar estos casos especiales. Tu capacidad para ajustar tu enfoque puede marcar una diferencia significativa en el resultado de la emergencia.",
                order = 4
            )
        )
    }
    
    /**
     * Crea las evaluaciones para el módulo de Servicio al Ciudadano
     */
    private fun createCustomerServiceEvaluations(): List<Evaluation> {
        return listOf(
            Evaluation(
                id = "cs_basic",
                title = "Evaluación de Servicio al Ciudadano",
                description = "Evaluación sobre técnicas de atención y comunicación en emergencias",
                questions = listOf(
                    Question(
                        id = "q1",
                        text = "¿Cuál es la primera acción que debe tomar al recibir una llamada de emergencia?",
                        options = listOf(
                            "Pedir el nombre del ciudadano",
                            "Identificar la ubicación del incidente",
                            "Determinar el tipo de emergencia",
                            "Transferir la llamada a otra agencia"
                        ),
                        correctOptionIndex = 1,
                        explanation = "Lo primero es identificar la ubicación para poder enviar ayuda, incluso si la llamada se corta"
                    ),
                    Question(
                        id = "q2",
                        text = "¿Qué técnica es recomendada para calmar a un ciudadano alterado?",
                        options = listOf(
                            "Hablar en voz alta para que entienda mejor",
                            "Usar un tono calmado y hablar con claridad",
                            "Interrumpir cuando divague para ahorrar tiempo",
                            "Transferir inmediatamente la llamada a un supervisor"
                        ),
                        correctOptionIndex = 1,
                        explanation = "Usar un tono calmado y hablar con claridad ayuda a tranquilizar a la persona y obtener mejor información"
                    )
                )
            )
        )
    }
}
