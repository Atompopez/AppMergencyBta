package com.example.appmergencybta.data

import com.example.appmergencybta.data.database.entities.TypificationCode

/**
 * Proveedor de datos para la aplicación
 * Contiene los datos iniciales para la base de datos
 */
object DataProvider {
    
    /**
     * Obtiene la lista de códigos de tipificación para inicializar la base de datos
     * Basado en la guía de tipificación oficial actualizada
     */
    fun getTypificationCodes(): List<TypificationCode> {
        return listOf(
            TypificationCode(
                code = "457",
                acronym = "VMEDGUB",
                description = "Violación de medida gubernamental",
                questions = "Conductas de violación a la normatividad que afectan el desarrollo de las acciones de control de los actos gubernamentales. Palabras clave: aglomeración, establecimiento, espacio público, vivienda, elementos de bioseguridad.",
                modifyingCircumstances = "Tipo de violación",
                modifyingCircumstancesDescription = "Aglomeración, establecimiento, espacio público, vivienda, elementos de bioseguridad",
                voiceTransfer = "Transferencia a autoridades competentes",
                incidentCopy = "Violación de medida gubernamental en [DIRECCIÓN].",
                imageResource = "ic_government"
            ),
            TypificationCode(
                code = "535",
                acronym = "INFCON",
                description = "Información confidencial",
                questions = "Información que puede conducir a la captura o hallazgo de: caleta de armas, cabecilla de la delincuencia o persona buscada, ubicación de un secuestrado, amenaza de muerte, ubicación de una obra de arte u objeto de valor robado.",
                modifyingCircumstances = "Tipo de información",
                modifyingCircumstancesDescription = "Incluye casos de extorsión, contrabando y perturbación electoral",
                voiceTransfer = "Transferencia a autoridades competentes",
                incidentCopy = "Información confidencial reportada.",
                imageResource = "ic_confidential"
            ),
            TypificationCode(
                code = "601",
                acronym = "ACV",
                description = "Accidente cerebro vascular",
                questions = "Evento de origen cerebral que se manifiesta por incapacidad para articular palabra, desviación de la cara, incapacidad para la movilización de cualquier extremidad (superiores o inferiores).",
                modifyingCircumstances = "Síntomas",
                modifyingCircumstancesDescription = "Derrame, infarto cerebral",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Posible ACV en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_stroke"
            ),
            TypificationCode(
                code = "602",
                acronym = "CAIALT",
                description = "Caída de altura",
                questions = "Se utiliza este código en caso de caída de altura o trauma craneoencefálico. No incluye caída de su propia altura, la cual se deberá aplicar como 605-HERIDO.",
                modifyingCircumstances = "Tipo de caída",
                modifyingCircumstancesDescription = "Caída, trauma",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Caída de altura en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_fall"
            ),
            TypificationCode(
                code = "603",
                acronym = "CONVULSIÓN",
                description = "Convulsión",
                questions = "Se caracterizan por movimientos incontrolados e involuntarios, manifestados en uno o más miembros. Incluye salivación profusa, de manera ocasional relajación de esfínteres o, incluso, hasta la pérdida del estado de conciencia.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Ataque, epilepsia, ataque epiléptico",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona con convulsiones en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_seizure"
            ),
            TypificationCode(
                code = "604",
                acronym = "EVERES",
                description = "Evento respiratorio",
                questions = "Situación que ocasiona una sensación de incomodidad al respirar o la sensación de no estar recibiendo el suficiente aire, puede producir cambios de color en la piel y observarse mayor esfuerzo al respirar.",
                modifyingCircumstances = "Causa",
                modifyingCircumstancesDescription = "Inmersión, obstrucción por cuerpo extraño, por humo, por factores químicos, por enfermedad crónica, por enfermedad aguda, asfixiado, ahogado, está morado",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Evento respiratorio en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_respiratory"
            ),
            TypificationCode(
                code = "605",
                acronym = "DOLTOR",
                description = "Dolor torácico",
                questions = "Situación que ocasiona una sensación o incomodidad en el pecho.",
                modifyingCircumstances = "Intensidad",
                modifyingCircumstancesDescription = "Dolor, opresión, pecho",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona con dolor torácico en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_chest_pain"
            ),
            TypificationCode(
                code = "606",
                acronym = "ELECTROCUC",
                description = "Electrocución",
                questions = "Emergencia originada al entrar una persona en contacto de manera directa o indirecta con energía eléctrica. Incluye impactos de rayo.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Contacto directo, contacto indirecto, rayo",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona electrocutada en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_electrocution"
            ),
            TypificationCode(
                code = "607",
                acronym = "PATGIN",
                description = "Patología ginecobstetricia",
                questions = "Condiciones o procesos anormales asociados con el embarazo: dolor, sangrado, salida de líquido amniótico, salida de carnes fetales, etc. Parto extra hospitalario. Aborto: interrupción o terminación a destiempo de un embarazo, antes de la semana 20 de gestación.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Embarazo, parto, aborto",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Emergencia ginecobstétrica en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_pregnancy"
            ),
            TypificationCode(
                code = "608",
                acronym = "HERIDO",
                description = "Herido",
                questions = "Herida causada por un objeto cortante, punzante o contundente.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Herida, corte, punzada",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona herida en [DIRECCIÓN]. Requiere asistencia médica.",
                imageResource = "ic_injury"
            ),
            TypificationCode(
                code = "609",
                acronym = "AMESUI",
                description = "Amenaza de suicidio",
                questions = "Manifestación expresa del deseo a través de palabras de quitarse la vida. Cuando la persona está realizando acciones para quitarse la vida tipificar como 918-INTSUI.",
                modifyingCircumstances = "Estado",
                modifyingCircumstancesDescription = "Verbal, escrita, con plan definido",
                voiceTransfer = "Transferencia a servicios médicos y policía",
                incidentCopy = "Amenaza de suicidio en [DIRECCIÓN]. Requiere intervención urgente.",
                imageResource = "ic_suicide_threat"
            ),
            TypificationCode(
                code = "610",
                acronym = "INTOX",
                description = "Intoxicación",
                questions = "Ingestión o exposición a sustancias tóxicas que causan daño al organismo.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Intoxicación, veneno, sustancia tóxica",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona intoxicada en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_poisoning"
            ),
            TypificationCode(
                code = "611",
                acronym = "MALTRATO",
                description = "Maltrato",
                questions = "Cualquier acción intencional que provoque daño psicológico o físico a niños o niñas, personas en condición de discapacidad o adultos mayores.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Incluye casos informados directamente por Bienestar Familiar, abandono de niños o niñas, personas en condición de discapacidad o adultos mayores, maltrato a la mujer",
                voiceTransfer = "Transferencia a policía y servicios sociales",
                incidentCopy = "Maltrato reportado en [DIRECCIÓN]. Requiere intervención urgente.",
                imageResource = "ic_abuse"
            ),
            TypificationCode(
                code = "613",
                acronym = "INCONSCIEN",
                description = "Inconsciente o paro cardiorrespiratorio",
                questions = "Estado de la persona que ha perdido el conocimiento y la capacidad de sentir y de moverse. Es la interrupción repentina y simultánea de la respiración y el funcionamiento del corazón, que produce pérdida de la conciencia y potencialmente la muerte.",
                modifyingCircumstances = "Estado",
                modifyingCircumstancesDescription = "Inconsciente, sin respiración, sin pulso",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona inconsciente en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_unconscious"
            ),
            TypificationCode(
                code = "615",
                acronym = "QUEMADURAS",
                description = "Quemaduras",
                questions = "Lesión en los tejidos del cuerpo causada por la exposición al fuego, calor, sustancias químicas, rayos solares, radiaciones, líquidos hirvientes o frío extremo.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Térmica, química, eléctrica, solar, por frío",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona con quemaduras en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_burn"
            ),
            TypificationCode(
                code = "616",
                acronym = "SANVAG",
                description = "Sangrado vaginal",
                questions = "Sangrado anormal por genitales, manchado entre períodos o menstruaciones, aplica en casos en que la mujer no esté embarazada.",
                modifyingCircumstances = "Intensidad",
                modifyingCircumstancesDescription = "Leve, moderado, grave",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Sangrado vaginal en [DIRECCIÓN]. Requiere asistencia médica.",
                imageResource = "ic_medical_emergency"
            ),
            TypificationCode(
                code = "617",
                acronym = "SINTOGASTR",
                description = "Síntomas gastrointestinales",
                questions = "Urgencia producida por afecciones que comprometen al estómago y los intestinos: dolor abdominal, diarrea, náuseas, vómitos, heces con sangre.",
                modifyingCircumstances = "Síntomas",
                modifyingCircumstancesDescription = "Dolor abdominal, diarrea, náuseas, vómitos, heces con sangre",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Síntomas gastrointestinales en [DIRECCIÓN]. Requiere asistencia médica.",
                imageResource = "ic_stomach"
            ),
            TypificationCode(
                code = "702",
                acronym = "ABRIRDOMIC",
                description = "Abrir domicilio",
                questions = "Procedimiento preventivo ante imperiosa necesidad por potencial emergencia cuando: 1. Para socorrer a quien pida auxilio. 2. Para proteger los bienes de personas ausentes. 3. Cuando desde el interior de un inmueble se atente contra persona o propiedad.",
                modifyingCircumstances = "Motivo",
                modifyingCircumstancesDescription = "Auxilio, protección de bienes, atentado desde interior",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Solicitud para abrir domicilio en [DIRECCIÓN]. Requiere intervención policial.",
                imageResource = "ic_open_door"
            ),
            TypificationCode(
                code = "703",
                acronym = "ELEMECAÍDO",
                description = "Elemento caído o en peligro de caer",
                questions = "Prevención de una potencial emergencia, la cual se puede originar a partir de la inminente caída de un elemento y que puede poner en peligro la vida, el medio ambiente y los bienes.",
                modifyingCircumstances = "Tipo de elemento",
                modifyingCircumstancesDescription = "Árbol, poste, semáforo, mobiliario urbano",
                voiceTransfer = "Transferencia a bomberos",
                incidentCopy = "Elemento caído o en peligro de caer en [DIRECCIÓN]. Requiere intervención.",
                imageResource = "ic_falling_object"
            ),
            TypificationCode(
                code = "708",
                acronym = "MATPEL",
                description = "Materiales peligrosos",
                questions = "Incidentes relacionados con artículos o sustancias sólidas, líquidas o gaseosas, que cuando son transportados por cualquier medio, o cuando son expuestos, son capaces de constituir un riesgo importante para la vida, la salud, los bienes o el medio ambiente.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Incluye pólvora, fugas de gas natural o propano, y residuos peligrosos",
                voiceTransfer = "Transferencia a bomberos y equipos MATPEL",
                incidentCopy = "Materiales peligrosos en [DIRECCIÓN]. Requiere equipo especializado.",
                imageResource = "ic_hazmat"
            ),
            TypificationCode(
                code = "709",
                acronym = "RESCATE",
                description = "Rescate",
                questions = "Acuático: Proceso de localización y rescate de víctimas atrapadas en aguas oscuras o rápidas. Estructura colapsada: Búsqueda, localización, acceso y rescate de víctimas atrapadas en espacios confinados. Montaña: Procedimiento tendiente a la localización y rescate de personas en sitios montañosos o de difícil acceso. Transporte vertical: rescate de personas en ascensores, escaleras eléctricas, rampas eléctricas o cualquier otro transporte vertical.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Acuático, estructura colapsada, montaña, transporte vertical",
                voiceTransfer = "Transferencia a bomberos",
                incidentCopy = "Rescate en [DIRECCIÓN]. Requiere equipo especializado.",
                imageResource = "ic_rescue"
            ),
            TypificationCode(
                code = "715",
                acronym = "EVENAT",
                description = "Evento natural",
                questions = "Incidentes que ocurren por procesos naturales sin intervención humana y que generan afectación a la vida, al medio ambiente y los bienes.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Movimiento telúrico, sismo, temblor, vendaval, viento violento, destechado",
                voiceTransfer = "Transferencia a defensa civil y bomberos",
                incidentCopy = "Evento natural en [DIRECCIÓN]. Requiere activación de protocolos de emergencia.",
                imageResource = "ic_natural_disaster"
            ),
            TypificationCode(
                code = "802",
                acronym = "MANIOBRAPE",
                description = "Maniobras peligrosas",
                questions = "Conductor de vehículo realizando maniobras peligrosas en la vía pública, poniendo en riesgo su vida o la de los demás.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Zigzag, alta velocidad, contravía",
                voiceTransfer = "Transferencia a policía de tránsito",
                incidentCopy = "Maniobras peligrosas en [DIRECCIÓN]. Requiere intervención de tránsito.",
                imageResource = "ic_dangerous_driving"
            ),
            TypificationCode(
                code = "901",
                acronym = "MUERTO",
                description = "Muerto",
                questions = "Este tipo de incidente se debe usar cuando se reporta un caso de muerte de un ser humano y se desconocen las causas, o hay prueba fehaciente de su deceso. Es reportado por hospitales o un primer respondiente.",
                modifyingCircumstances = "Circunstancias",
                modifyingCircumstancesDescription = "Desconocida, reportada por hospital, reportada por testigo",
                voiceTransfer = "Transferencia a policía judicial y medicina legal",
                incidentCopy = "Persona fallecida en [DIRECCIÓN]. Requiere intervención de autoridades.",
                imageResource = "ic_death"
            ),
            TypificationCode(
                code = "902",
                acronym = "SECUESTRO",
                description = "Secuestro",
                questions = "Delito que consiste en retener de forma indebida o ilegal con fines extorsivos.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Express, extorsivo, en curso",
                voiceTransfer = "Transferencia a policía antisecuestro",
                incidentCopy = "Secuestro reportado en [DIRECCIÓN]. Requiere intervención policial especializada.",
                imageResource = "ic_kidnapping"
            ),
            TypificationCode(
                code = "903",
                acronym = "RAPTO",
                description = "Rapto",
                questions = "Delito consistente en la retención de una persona, privándola de libertad en contra de su voluntad, sin fines delictivos. Por ejemplo: el rapto de un hijo por parte de su padre.",
                modifyingCircumstances = "Circunstancias",
                modifyingCircumstancesDescription = "Familiar, conocido, desconocido",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Rapto reportado en [DIRECCIÓN]. Requiere intervención policial.",
                imageResource = "ic_abduction"
            ),
            TypificationCode(
                code = "904",
                acronym = "HUREFECT",
                description = "Hurto efectuado",
                questions = "Comete este delito quien toma un bien mueble y ajeno sin la voluntad de su dueño, sometiendo a la víctima a estado de indefensión o con violencia sobre las personas o las cosas. Aquellos hurtos en los que no hay presencia de agresores.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "A persona, residencia, comercio, vehículo",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Hurto efectuado en [DIRECCIÓN]. Requiere intervención policial.",
                imageResource = "ic_theft"
            ),
            TypificationCode(
                code = "905",
                acronym = "HURPROCESO",
                description = "Hurto en proceso",
                questions = "Se utiliza este código para aquellos casos en los cuales el usuario puede informar algunas características del delincuente(s) implicado(s) o del medio en que se moviliza o la ruta que siguió, en un tiempo razonablemente corto (máximo 30 minutos). Comete este delito quien toma un bien mueble y ajeno sin la voluntad de su dueño.",
                modifyingCircumstances = "Estado",
                modifyingCircumstancesDescription = "En curso, reciente, con descripción de sospechoso",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Hurto en proceso en [DIRECCIÓN]. Requiere intervención policial urgente.",
                imageResource = "ic_theft_in_progress"
            ),
            TypificationCode(
                code = "906",
                acronym = "VIOSEXUAL",
                description = "Violencia sexual",
                questions = "El concepto de violencia sexual incluye diferentes tipos y manifestaciones que pueden ser las siguientes: 1. Acceso carnal violento. 2. Violación. 3. Indecente: Contacto o permitir a un adulto, niño o niña que toque de manera inapropiada a otra. 4. Explotación sexual: todo tipo de actividad en que una persona usa el cuerpo de otra para sacar ventaja o provecho de carácter sexual, basándose en una relación de poder.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Acceso carnal violento, violación, indecente, explotación sexual",
                voiceTransfer = "Transferencia a policía y servicios médicos",
                incidentCopy = "Violencia sexual en [DIRECCIÓN]. Requiere intervención urgente.",
                imageResource = "ic_sexual_assault"
            ),
            TypificationCode(
                code = "909",
                acronym = "EXACOB",
                description = "Exhibiciones o actos obscenos",
                questions = "Realizar actos sexuales o de exhibicionismo en presencia de adultos, niños o niñas.",
                modifyingCircumstances = "Circunstancias",
                modifyingCircumstancesDescription = "En vía pública, cerca de escuelas, con acoso",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Exhibicionismo reportado en [DIRECCIÓN]. Requiere intervención policial.",
                imageResource = "ic_indecent_exposure"
            ),
            TypificationCode(
                code = "910",
                acronym = "LESPER",
                description = "Lesiones personales",
                questions = "Delito en contra de la vida y la salud personal, que comete el que cause a otro un daño que deje en su cuerpo un vestigio o afecte su salud física. Tener en cuenta para la redacción: zona del cuerpo donde ocurre la herida.",
                modifyingCircumstances = "Gravedad",
                modifyingCircumstancesDescription = "Leve, moderada, grave",
                voiceTransfer = "Transferencia a servicios médicos y policía",
                incidentCopy = "Lesiones personales en [DIRECCIÓN]. Requiere asistencia médica y policial.",
                imageResource = "ic_injury"
            ),
            TypificationCode(
                code = "911",
                acronym = "DISPAROS",
                description = "Disparos",
                questions = "Información donde se reporta el haber escuchado o presenciado disparos, sabiendo no el lugar de dónde provienen. No depende de la intencionalidad. Puede haberse disparado a sí mismo.",
                modifyingCircumstances = "Circunstancias",
                modifyingCircumstancesDescription = "Escuchados, presenciados, con heridos",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Disparos reportados en [DIRECCIÓN]. Requiere intervención policial urgente.",
                imageResource = "ic_gunshots"
            ),
            TypificationCode(
                code = "912",
                acronym = "DAÑOSPP",
                description = "Daños en propiedad pública o privada",
                questions = "Daño ocasionado a bienes de titularidad pública, tales como obras, caminos públicos, parques, calles, incluye propiedad privada. Escritos o fin leyendas, dibujos, grafitis, sin el debido permiso.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Pública, privada, grafitis",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Daños en propiedad en [DIRECCIÓN]. Requiere intervención policial.",
                imageResource = "ic_property_damage"
            ),
            TypificationCode(
                code = "914",
                acronym = "VHABAN",
                description = "Vehículo abandonado",
                questions = "Vehículo abandonado en un lugar, cuya presencia no es habitual en la zona donde se encuentra.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Automóvil, motocicleta, bicicleta",
                voiceTransfer = "Transferencia a policía de tránsito",
                incidentCopy = "Vehículo abandonado en [DIRECCIÓN]. Requiere verificación.",
                imageResource = "ic_abandoned_vehicle"
            ),
            TypificationCode(
                code = "914",
                acronym = "VHMALE",
                description = "Vehículo mal estacionado",
                questions = "Vehículo que puede estar obstruyendo una vía o un garaje.",
                modifyingCircumstances = "Ubicación",
                modifyingCircumstancesDescription = "Obstruyendo vía, obstruyendo garaje, zona prohibida",
                voiceTransfer = "Transferencia a policía de tránsito",
                incidentCopy = "Vehículo mal estacionado en [DIRECCIÓN]. Requiere intervención de tránsito.",
                imageResource = "ic_bad_parking"
            ),
            TypificationCode(
                code = "915",
                acronym = "VIODOM",
                description = "Intento o violación de domicilio",
                questions = "Avistamientos de personas que están tratando de entrar en una propiedad en cuyas inmediaciones el usuario 123 manifiesta no ser conocidos (el desconocido aún no ha entrado en la propiedad). Si han ingresado a la propiedad se debe tipificar como 905 - HURPROCESO. Utilizar este tipo de incidente para casos donde se reporta una persona conocida que ingresa a una propiedad sin autorización de su residente.",
                modifyingCircumstances = "Estado",
                modifyingCircumstancesDescription = "Intento, conocido, desconocido",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Intento o violación de domicilio en [DIRECCIÓN]. Requiere intervención policial.",
                imageResource = "ic_break_in"
            ),
            TypificationCode(
                code = "916",
                acronym = "SOSPEVH",
                description = "Persona o vehículo sospechoso",
                questions = "Persona que la hace sospechosa su actitud con relación al comportamiento de las personas del lugar donde se encuentra, se puede movilizar a pie o en un vehículo.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Persona, vehículo, grupo",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Persona o vehículo sospechoso en [DIRECCIÓN]. Requiere verificación policial.",
                imageResource = "ic_suspicious"
            ),
            TypificationCode(
                code = "918",
                acronym = "INTSUI",
                description = "Intento de suicidio",
                questions = "Situación en la que una persona está realizando o ha realizado acciones para quitarse la vida.",
                modifyingCircumstances = "Estado",
                modifyingCircumstancesDescription = "En curso, reciente, con método definido",
                voiceTransfer = "Transferencia a servicios médicos y policía",
                incidentCopy = "Intento de suicidio en [DIRECCIÓN]. Requiere intervención urgente.",
                imageResource = "ic_suicide"
            ),
            TypificationCode(
                code = "919",
                acronym = "PERAUX",
                description = "Persona pidiendo auxilio",
                questions = "Este tipo de incidente se debe utilizar para reportes en los cuales alguna persona o personas manifiestan requerir ayuda de tipo policial, médico, o de otra clase, pero no se logra identificar con precisión la situación que se ha suscitado.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Auxilio policial, auxilio médico, otro",
                voiceTransfer = "Transferencia a autoridades competentes",
                incidentCopy = "Persona pidiendo auxilio en [DIRECCIÓN]. Requiere verificación urgente.",
                imageResource = "ic_help"
            ),
            TypificationCode(
                code = "922",
                acronym = "NARCÓTICOS",
                description = "Narcóticos",
                questions = "Tener, almacenar, facilitar, distribuir, expender o consumir drogas o sustancias prohibidas.",
                modifyingCircumstances = "Actividad",
                modifyingCircumstancesDescription = "Consumo, venta, distribución, almacenamiento",
                voiceTransfer = "Transferencia a policía antinarcóticos",
                incidentCopy = "Actividad relacionada con narcóticos en [DIRECCIÓN]. Requiere intervención policial.",
                imageResource = "ic_drugs"
            ),
            TypificationCode(
                code = "923",
                acronym = "HABITCALLE",
                description = "Habitante de la calle",
                questions = "Este incidente se debe utilizar cuando una persona sin distinción de sexo, raza o edad, que hace de la calle su lugar de habitación, ya sea de forma permanente o transitoria está generando comportamientos contrarios a la convivencia.",
                modifyingCircumstances = "Comportamiento",
                modifyingCircumstancesDescription = "Agresivo, alterando orden público, requiriendo asistencia",
                voiceTransfer = "Transferencia a policía y servicios sociales",
                incidentCopy = "Habitante de calle en [DIRECCIÓN]. Requiere intervención.",
                imageResource = "ic_homeless"
            ),
            TypificationCode(
                code = "924",
                acronym = "ENFERMO",
                description = "Enfermo",
                questions = "Cualquier manifestación de enfermedad que no se encuentre en ninguno de los códigos de esta guía.",
                modifyingCircumstances = "Estado",
                modifyingCircumstancesDescription = "Leve, moderado, grave",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona enferma en [DIRECCIÓN]. Requiere asistencia médica.",
                imageResource = "ic_sick"
            ),
            TypificationCode(
                code = "926",
                acronym = "EMBRIAGUEZ",
                description = "Embriaguez",
                questions = "Se utiliza para tipificar incidentes en los que se reportan personas que se encuentran bajo los efectos del alcohol y a las que dicho estado no les permite dilucidar o sortear situaciones cotidianas o que están alterando el orden público. Venta y consumo en el espacio público.",
                modifyingCircumstances = "Estado",
                modifyingCircumstancesDescription = "Alterando orden público, inconsciente, agresivo",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Persona en estado de embriaguez en [DIRECCIÓN]. Requiere intervención.",
                imageResource = "ic_drunk"
            ),
            TypificationCode(
                code = "927",
                acronym = "QUEMAS",
                description = "Quemas",
                questions = "Fuego controlado ocasionado por acto humano, que genera riesgo de un potencial fuego incontrolado.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Basura, vegetación, controlada, sin control",
                voiceTransfer = "Transferencia a bomberos",
                incidentCopy = "Quema reportada en [DIRECCIÓN]. Requiere verificación.",
                imageResource = "ic_controlled_fire"
            ),
            TypificationCode(
                code = "928",
                acronym = "INUNDACIÓN",
                description = "Inundación",
                questions = "Caudales o niveles de agua que afectan edificaciones, infraestructuras, vías o al medio ambiente.",
                modifyingCircumstances = "Causa",
                modifyingCircumstancesDescription = "Lluvia, ruptura de tubería, desbordamiento",
                voiceTransfer = "Transferencia a bomberos",
                incidentCopy = "Inundación en [DIRECCIÓN]. Requiere intervención de bomberos.",
                imageResource = "ic_flood"
            ),
            TypificationCode(
                code = "929",
                acronym = "EXPLOSIÓN",
                description = "Explosión",
                questions = "Liberación brusca de una gran cantidad de energía, de origen térmico, químico o nuclear, encerrada en un volumen relativamente pequeño, la cual produce un incremento violento y rápido de la presión, con desprendimiento de calor, luz y gases. Vía acompañada de estruendo y rotura violenta del recipiente contenedor.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Gas, artefacto explosivo, químicos",
                voiceTransfer = "Transferencia a bomberos y policía",
                incidentCopy = "Explosión en [DIRECCIÓN]. Requiere equipos especializados.",
                imageResource = "ic_explosion"
            ),
            TypificationCode(
                code = "930",
                acronym = "FEREMA",
                description = "Fenómeno de remoción de masa",
                questions = "Son desplazamientos descendentes del suelo o rocas a lo largo de una o varias superficies. Incluye avalanchas, derrumbes, amenazas de deslizamientos y caída de rocas.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Avalancha, derrumbe, deslizamiento, caída de rocas",
                voiceTransfer = "Transferencia a bomberos y defensa civil",
                incidentCopy = "Fenómeno de remoción de masa en [DIRECCIÓN]. Requiere evaluación técnica.",
                imageResource = "ic_landslide"
            ),
            TypificationCode(
                code = "931",
                acronym = "INCENDIO",
                description = "Incendio",
                questions = "Incendios o fuegos sin control.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Estructural, forestal, vehicular, industrial",
                voiceTransfer = "Transferencia a bomberos",
                incidentCopy = "Incendio en [DIRECCIÓN]. Requiere intervención de bomberos.",
                imageResource = "ic_fire"
            ),
            TypificationCode(
                code = "932",
                acronym = "RUIDO",
                description = "Ruido",
                questions = "Sonido no deseado o molesto que interfiere con las actividades normales o el descanso de las personas.",
                modifyingCircumstances = "Fuente",
                modifyingCircumstancesDescription = "Establecimiento, vecinos, vía pública",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Ruido excesivo en [DIRECCIÓN]. Requiere intervención policial.",
                imageResource = "ic_noise"
            ),
            TypificationCode(
                code = "933",
                acronym = "DELINCAPTU",
                description = "Delincuente capturado por civil",
                questions = "Persona capturada por la ciudadanía porque presuntamente cometió un delito y la autoridad debe acercarse a verificar dicha situación.",
                modifyingCircumstances = "Delito",
                modifyingCircumstancesDescription = "Hurto, agresión, daños",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Delincuente capturado por civil en [DIRECCIÓN]. Requiere intervención policial urgente.",
                imageResource = "ic_civilian_capture"
            ),
            TypificationCode(
                code = "934",
                acronym = "RIÑA",
                description = "Riña",
                questions = "Es todo incidente o altercado que pueda surgir entre dos o más personas ocasionando agresiones físicas, que pueden llevar incluso a poner en riesgo la vida de una persona. Reñir, incitar o incurrir en confrontaciones violentas que puedan derivar en agresiones físicas.",
                modifyingCircumstances = "Estado",
                modifyingCircumstancesDescription = "En curso, finalizada con heridos, con armas",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Riña en [DIRECCIÓN]. Requiere intervención policial.",
                imageResource = "ic_fight"
            ),
            TypificationCode(
                code = "935",
                acronym = "VERIFSITUA",
                description = "Verificar situación",
                questions = "Se utiliza este código para tipificar situaciones no contenidas en la Guía de Tipificación. Su selección busca la verificación o asistencia de la Agencia competente al lugar del incidente.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Policial, médica, bomberos",
                voiceTransfer = "Transferencia a la agencia competente",
                incidentCopy = "Verificar situación en [DIRECCIÓN]. Requiere asistencia.",
                imageResource = "ic_verify"
            ),
            TypificationCode(
                code = "000",
                acronym = "SIMULACRO",
                description = "Simulacro",
                questions = "Solicitar entidad donde se va a realizar, fecha, hora y tipo de simulacro.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Evacuación, incendio, terremoto",
                voiceTransfer = "Registro en sistema",
                incidentCopy = "Simulacro en [DIRECCIÓN]. Información registrada.",
                imageResource = "ic_drill"
            ),
         /*   TypificationCode(
                code = "106",
                acronym = "AHOGAM",
                description = "Ahogamiento",
                questions = "¿La persona está consciente? ¿Está respirando? ¿Cuánto tiempo estuvo sumergida?",
                modifyingCircumstances = "Estado de la víctima",
                modifyingCircumstancesDescription = "Consciente, inconsciente, sin respiración",
                voiceTransfer = "Transferencia a servicios médicos y bomberos",
                incidentCopy = "Persona ahogándose en [DIRECCIÓN]. Requiere asistencia inmediata.",
                imageResource = "ic_drowning"
            ),
            TypificationCode(
                code = "107",
                acronym = "ALLANM",
                description = "Allanamiento",
                questions = "¿Los intrusos están presentes? ¿Hay personas en peligro? ¿Hay armas?",
                modifyingCircumstances = "Estado del allanamiento",
                modifyingCircumstancesDescription = "En curso, finalizado, con sospechosos presentes",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Allanamiento reportado en [DIRECCIÓN]. Requiere intervención policial.",
                imageResource = "ic_break_in"
            ),
            TypificationCode(
                code = "108",
                acronym = "AMENAZ",
                description = "Amenaza personal",
                questions = "¿Quién realiza la amenaza? ¿Cuál es la naturaleza de la amenaza? ¿Hay riesgo inmediato?",
                modifyingCircumstances = "Tipo de amenaza",
                modifyingCircumstancesDescription = "Verbal, escrita, con arma",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Amenaza personal reportada en [DIRECCIÓN]. Requiere intervención.",
                imageResource = "ic_threat"
            ),
            TypificationCode(
                code = "109",
                acronym = "ASFIXIA",
                description = "Asfixia",
                questions = "¿La persona está consciente? ¿Está respirando? ¿Cuál fue la causa?",
                modifyingCircumstances = "Causa",
                modifyingCircumstancesDescription = "Obstrucción, gases, estrangulamiento",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona con asfixia en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_asphyxia"
            ),
            
            // Códigos 110-119
            TypificationCode(
                code = "110",
                acronym = "ATAQUE",
                description = "Ataque cardíaco/Infarto",
                questions = "¿La persona está consciente? ¿Está respirando? ¿Tiene antecedentes cardíacos?",
                modifyingCircumstances = "Estado del paciente",
                modifyingCircumstancesDescription = "Consciente, inconsciente, con dolor",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Posible ataque cardíaco en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_heart_attack"
            ),
            TypificationCode(
                code = "111",
                acronym = "ATRACO",
                description = "Atraco/Robo",
                questions = "¿Hay heridos? ¿Los delincuentes están presentes? ¿Había armas?",
                modifyingCircumstances = "Estado del atraco",
                modifyingCircumstancesDescription = "En curso, finalizado, con heridos",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Atraco reportado en [DIRECCIÓN]. Requiere intervención policial.",
                imageResource = "ic_robbery"
            ),
            TypificationCode(
                code = "112",
                acronym = "ATRNINO",
                description = "Atropello a menor",
                questions = "¿El menor está consciente? ¿Hay lesiones visibles? ¿El vehículo sigue en el lugar?",
                modifyingCircumstances = "Estado de la víctima",
                modifyingCircumstancesDescription = "Consciente, inconsciente, con lesiones graves",
                voiceTransfer = "Transferencia a servicios médicos y policía",
                incidentCopy = "Menor atropellado en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_child_accident"
            ),
            TypificationCode(
                code = "113",
                acronym = "ATRPELL",
                description = "Atropello",
                questions = "¿La víctima está consciente? ¿Hay lesiones visibles? ¿El vehículo sigue en el lugar?",
                modifyingCircumstances = "Estado de la víctima",
                modifyingCircumstancesDescription = "Consciente, inconsciente, con lesiones graves",
                voiceTransfer = "Transferencia a servicios médicos y policía",
                incidentCopy = "Persona atropellada en [DIRECCIÓN]. Requiere asistencia médica.",
                imageResource = "ic_pedestrian_accident"
            ),
            TypificationCode(
                code = "114",
                acronym = "AVALANC",
                description = "Avalancha",
                questions = "¿Hay personas atrapadas? ¿Cuál es la magnitud? ¿Hay riesgo de más deslizamientos?",
                modifyingCircumstances = "Magnitud",
                modifyingCircumstancesDescription = "Pequeña, mediana, grande",
                voiceTransfer = "Transferencia a bomberos y defensa civil",
                incidentCopy = "Avalancha reportada en [DIRECCIÓN]. Requiere equipos de rescate.",
                imageResource = "ic_avalanche"
            ),
            TypificationCode(
                code = "115",
                acronym = "BALACE",
                description = "Balacera",
                questions = "¿Hay heridos? ¿La balacera continúa? ¿Cuántas personas están involucradas?",
                modifyingCircumstances = "Estado",
                modifyingCircumstancesDescription = "En curso, finalizada, con heridos",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Balacera reportada en [DIRECCIÓN]. Requiere intervención policial urgente.",
                imageResource = "ic_shooting"
            ),
            TypificationCode(
                code = "116",
                acronym = "BOMBA",
                description = "Amenaza de bomba",
                questions = "¿Dónde está el artefacto? ¿Cuándo podría detonar? ¿Quién realizó la amenaza?",
                modifyingCircumstances = "Tipo de amenaza",
                modifyingCircumstancesDescription = "Llamada, nota escrita, objeto sospechoso",
                voiceTransfer = "Transferencia a policía y antiexplosivos",
                incidentCopy = "Amenaza de bomba en [DIRECCIÓN]. Requiere evacuación y equipos especializados.",
                imageResource = "ic_bomb_threat"
            ),
            TypificationCode(
                code = "117",
                acronym = "BUSQUED",
                description = "Búsqueda de persona",
                questions = "¿Cuándo fue vista por última vez? ¿Cómo iba vestida? ¿Tiene condiciones médicas?",
                modifyingCircumstances = "Tiempo desaparecida",
                modifyingCircumstancesDescription = "Horas, días, semanas",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Persona desaparecida reportada en [DIRECCIÓN]. Requiere búsqueda.",
                imageResource = "ic_missing_person"
            ),
            TypificationCode(
                code = "118",
                acronym = "CAIDA",
                description = "Caída desde altura",
                questions = "¿Desde qué altura cayó? ¿Está consciente? ¿Tiene lesiones visibles?",
                modifyingCircumstances = "Altura",
                modifyingCircumstancesDescription = "Baja, media, alta",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona caída desde altura en [DIRECCIÓN]. Requiere asistencia médica.",
                imageResource = "ic_fall"
            ),
            TypificationCode(
                code = "119",
                acronym = "CADAVER",
                description = "Cadáver encontrado",
                questions = "¿Dónde fue encontrado? ¿Hay signos de violencia? ¿Cuánto tiempo lleva fallecido?",
                modifyingCircumstances = "Condición",
                modifyingCircumstancesDescription = "Reciente, en descomposición, con signos de violencia",
                voiceTransfer = "Transferencia a policía y medicina legal",
                incidentCopy = "Cadáver encontrado en [DIRECCIÓN]. Requiere intervención de autoridades.",
                imageResource = "ic_death"
            ),
            // Códigos 120-129
            TypificationCode(
                code = "120",
                acronym = "CALAMI",
                description = "Calamidad pública",
                questions = "¿Qué tipo de calamidad? ¿Cuántas personas afectadas? ¿Qué recursos se necesitan?",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Inundación, incendio forestal, deslizamiento masivo",
                voiceTransfer = "Transferencia a defensa civil y bomberos",
                incidentCopy = "Calamidad pública en [DIRECCIÓN]. Requiere activación de protocolos de emergencia.",
                imageResource = "ic_public_calamity"
            ),
            TypificationCode(
                code = "121",
                acronym = "CHOQUE",
                description = "Choque vehicular",
                questions = "¿Cuántos vehículos involucrados? ¿Hay heridos? ¿Hay derrame de combustible?",
                modifyingCircumstances = "Gravedad",
                modifyingCircumstancesDescription = "Leve, moderado, grave",
                voiceTransfer = "Transferencia a policía de tránsito",
                incidentCopy = "Choque vehicular en [DIRECCIÓN]. Requiere asistencia.",
                imageResource = "ic_car_crash"
            ),
            TypificationCode(
                code = "122",
                acronym = "CONVUL",
                description = "Convulsiones",
                questions = "¿La persona tiene historial de epilepsia? ¿Cuánto tiempo lleva convulsionando? ¿Está respirando?",
                modifyingCircumstances = "Duración",
                modifyingCircumstancesDescription = "Breve, prolongada, repetitiva",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona con convulsiones en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_seizure"
            ),
            TypificationCode(
                code = "123",
                acronym = "DANOS",
                description = "Daños a propiedad pública",
                questions = "¿Qué tipo de daño? ¿Los responsables están presentes? ¿Hay riesgo para transeuntes?",
                modifyingCircumstances = "Tipo de daño",
                modifyingCircumstancesDescription = "Vandalismo, accidental, estructural",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Daños a propiedad pública en [DIRECCIÓN]. Requiere intervención.",
                imageResource = "ic_property_damage"
            ),
            TypificationCode(
                code = "124",
                acronym = "DEFLA",
                description = "Deflagración/Explosión",
                questions = "¿Qué explosión? ¿Hay heridos? ¿Hay riesgo de más explosiones?",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Gas, explosivos, químicos",
                voiceTransfer = "Transferencia a bomberos y policía",
                incidentCopy = "Explosión reportada en [DIRECCIÓN]. Requiere equipos especializados.",
                imageResource = "ic_explosion"
            ),
            TypificationCode(
                code = "125",
                acronym = "DEMEN",
                description = "Persona con demencia/Alzheimer",
                questions = "¿Dónde fue vista por última vez? ¿Cómo iba vestida? ¿Tiene medicación necesaria?",
                modifyingCircumstances = "Estado",
                modifyingCircumstancesDescription = "Desorientada, agitada, en peligro",
                voiceTransfer = "Transferencia a policía y servicios médicos",
                incidentCopy = "Persona con demencia extraviada en [DIRECCIÓN]. Requiere asistencia.",
                imageResource = "ic_dementia"
            ),
            TypificationCode(
                code = "126",
                acronym = "DERRUM",
                description = "Derrumbe",
                questions = "¿Hay personas atrapadas? ¿Cuál es la magnitud? ¿Hay riesgo de más derrumbes?",
                modifyingCircumstances = "Magnitud",
                modifyingCircumstancesDescription = "Pequeño, mediano, grande",
                voiceTransfer = "Transferencia a bomberos y defensa civil",
                incidentCopy = "Derrumbe reportado en [DIRECCIÓN]. Requiere equipos de rescate.",
                imageResource = "ic_landslide"
            ),
            TypificationCode(
                code = "127",
                acronym = "DESAPA",
                description = "Desaparición de persona",
                questions = "¿Cuándo fue vista por última vez? ¿Cómo iba vestida? ¿Hay sospecha de secuestro?",
                modifyingCircumstances = "Tiempo",
                modifyingCircumstancesDescription = "Reciente, prolongada, con sospecha de delito",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Persona desaparecida reportada en [DIRECCIÓN]. Requiere investigación.",
                imageResource = "ic_missing_person"
            ),
            TypificationCode(
                code = "128",
                acronym = "DESNAT",
                description = "Desastre natural",
                questions = "¿Qué tipo de desastre? ¿Cuántas personas afectadas? ¿Qué daños hay?",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Terremoto, inundación, deslizamiento",
                voiceTransfer = "Transferencia a defensa civil y bomberos",
                incidentCopy = "Desastre natural en [DIRECCIÓN]. Requiere activación de protocolos de emergencia.",
                imageResource = "ic_natural_disaster"
            ),
            TypificationCode(
                code = "129",
                acronym = "DESMAY",
                description = "Desmayo/Pérdida de consciencia",
                questions = "¿La persona está respirando? ¿Tiene pulso? ¿Tiene condiciones médicas conocidas?",
                modifyingCircumstances = "Causa probable",
                modifyingCircumstancesDescription = "Golpe, enfermedad, deshidratación",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona desmayada en [DIRECCIÓN]. Requiere asistencia médica.",
                imageResource = "ic_unconscious"
            ),
            
            // Códigos 130-139
            TypificationCode(
                code = "130",
                acronym = "DISPAROS",
                description = "Disparos",
                questions = "¿Hay heridos? ¿Los disparos continúan? ¿Se identificó al tirador?",
                modifyingCircumstances = "Estado",
                modifyingCircumstancesDescription = "En curso, finalizado, con heridos",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Disparos reportados en [DIRECCIÓN]. Requiere intervención policial urgente.",
                imageResource = "ic_gunshots"
            ),
            TypificationCode(
                code = "131",
                acronym = "ELECTRO",
                description = "Electrocución",
                questions = "¿La persona está aún en contacto con la fuente eléctrica? ¿Está consciente? ¿Está respirando?",
                modifyingCircumstances = "Estado",
                modifyingCircumstancesDescription = "En contacto con electricidad, desconectado, con quemaduras",
                voiceTransfer = "Transferencia a servicios médicos y bomberos",
                incidentCopy = "Persona electrocutada en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_electrocution"
            ),
            TypificationCode(
                code = "132",
                acronym = "EMBARA",
                description = "Emergencia en embarazo/Parto",
                questions = "¿Cuántos meses de embarazo? ¿Hay contracciones? ¿Hay sangrado?",
                modifyingCircumstances = "Estado",
                modifyingCircumstancesDescription = "Parto en curso, complicaciones, dolor intenso",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Emergencia de embarazo en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_pregnancy"
            ),
            TypificationCode(
                code = "133",
                acronym = "ENVENE",
                description = "Envenenamiento/Intoxicación",
                questions = "¿Qué sustancia ingirió? ¿Cuándo ocurrió? ¿La persona está consciente?",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Alimentos, químicos, medicamentos",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona intoxicada en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_poisoning"
            ),
            TypificationCode(
                code = "134",
                acronym = "EPIDE",
                description = "Epidemia/Brote",
                questions = "¿Cuántas personas afectadas? ¿Qué síntomas presentan? ¿Cuándo iniciaron los síntomas?",
                modifyingCircumstances = "Alcance",
                modifyingCircumstancesDescription = "Localizado, extendido, grave",
                voiceTransfer = "Transferencia a servicios de salud pública",
                incidentCopy = "Posible brote epidémico en [DIRECCIÓN]. Requiere intervención sanitaria.",
                imageResource = "ic_epidemic"
            ),
            TypificationCode(
                code = "135",
                acronym = "ESCAND",
                description = "Escándalo/Alteración del orden público",
                questions = "¿Cuántas personas involucradas? ¿Hay violencia? ¿Hay consumo de alcohol o drogas?",
                modifyingCircumstances = "Magnitud",
                modifyingCircumstancesDescription = "Menor, moderado, grave",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Alteración del orden público en [DIRECCIÓN]. Requiere intervención policial.",
                imageResource = "ic_public_disorder"
            ),
            TypificationCode(
                code = "136",
                acronym = "ESTAFA",
                description = "Estafa/Fraude",
                questions = "¿Cómo ocurrió la estafa? ¿Cuándo sucedió? ¿Tiene información del estafador?",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Telefónica, electrónica, presencial",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Estafa reportada en [DIRECCIÓN]. Requiere investigación policial.",
                imageResource = "ic_fraud"
            ),
            TypificationCode(
                code = "137",
                acronym = "EXHIB",
                description = "Exhibicionismo",
                questions = "¿Dónde está ocurriendo? ¿Hay menores presentes? ¿Puede describir a la persona?",
                modifyingCircumstances = "Circunstancias",
                modifyingCircumstancesDescription = "En vía pública, cerca de escuelas, con acoso",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Exhibicionismo reportado en [DIRECCIÓN]. Requiere intervención policial.",
                imageResource = "ic_indecent_exposure"
            ),
            TypificationCode(
                code = "138",
                acronym = "EXPLOS",
                description = "Explosión",
                questions = "¿Qué tipo de explosión? ¿Hay heridos? ¿Hay riesgo de más explosiones?",
                modifyingCircumstances = "Causa",
                modifyingCircumstancesDescription = "Gas, artefacto explosivo, accidental",
                voiceTransfer = "Transferencia a bomberos y policía",
                incidentCopy = "Explosión reportada en [DIRECCIÓN]. Requiere equipos especializados.",
                imageResource = "ic_explosion"
            ),
            TypificationCode(
                code = "139",
                acronym = "EXTORS",
                description = "Extorsión",
                questions = "¿Cómo lo están extorsionando? ¿Ha recibido amenazas? ¿Tiene información del extorsionista?",
                modifyingCircumstances = "Medio",
                modifyingCircumstancesDescription = "Telefónica, electrónica, presencial",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Extorsión reportada en [DIRECCIÓN]. Requiere investigación policial.",
                imageResource = "ic_extortion"
            ),
            // Códigos 140-149
            TypificationCode(
                code = "140",
                acronym = "FALLA",
                description = "Falla estructural",
                questions = "¿Qué estructura falló? ¿Hay personas en peligro? ¿Hay riesgo de colapso adicional?",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Parcial, inminente, con personas atrapadas",
                voiceTransfer = "Transferencia a bomberos y defensa civil",
                incidentCopy = "Falla estructural en [DIRECCIÓN]. Requiere evaluación técnica urgente.",
                imageResource = "ic_structural_failure"
            ),
            TypificationCode(
                code = "141",
                acronym = "FALLECER",
                description = "Persona fallecida",
                questions = "¿Cómo ocurrió el fallecimiento? ¿Hay signos de violencia? ¿Cuánto tiempo lleva fallecida?",
                modifyingCircumstances = "Causa aparente",
                modifyingCircumstancesDescription = "Natural, accidental, violenta",
                voiceTransfer = "Transferencia a policía y medicina legal",
                incidentCopy = "Persona fallecida en [DIRECCIÓN]. Requiere intervención de autoridades.",
                imageResource = "ic_death"
            ),
            TypificationCode(
                code = "142",
                acronym = "FALSALARM",
                description = "Falsa alarma",
                questions = "¿Qué tipo de emergencia se reportó inicialmente? ¿Cómo se confirmó que era falsa?",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Error, broma, malentendido",
                voiceTransfer = "Registro en sistema",
                incidentCopy = "Falsa alarma reportada en [DIRECCIÓN]. No requiere intervención.",
                imageResource = "ic_false_alarm"
            ),
            TypificationCode(
                code = "143",
                acronym = "FUGA",
                description = "Fuga de gas/Materiales peligrosos",
                questions = "¿Qué tipo de fuga? ¿Hay personas afectadas? ¿Cuál es la magnitud?",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Gas domiciliario, industrial, material químico",
                voiceTransfer = "Transferencia a bomberos",
                incidentCopy = "Fuga de material peligroso en [DIRECCIÓN]. Requiere equipo especializado.",
                imageResource = "ic_gas_leak"
            ),
            TypificationCode(
                code = "936",
                acronym = "VIODOMÉSTICA",
                description = "Violencia doméstica o intrafamiliar",
                questions = "Cualquier forma de maltrato o agresiones físicas, psicológicas o sexuales infligidas por personas del medio familiar y dirigida generalmente a los miembros más vulnerables de la misma: niños, mujeres y ancianos.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Física, psicológica, sexual, económica",
                voiceTransfer = "Transferencia a policía y servicios sociales",
                incidentCopy = "Violencia doméstica en [DIRECCIÓN]. Requiere intervención urgente.",
                imageResource = "ic_domestic_violence"
            ),
            TypificationCode(
                code = "937",
                acronym = "ESCPGAS",
                description = "Escape de gas",
                questions = "Fuga de gas en una edificación o vía pública.",
                modifyingCircumstances = "Ubicación",
                modifyingCircumstancesDescription = "Residencial, comercial, vía pública",
                voiceTransfer = "Transferencia a bomberos",
                incidentCopy = "Escape de gas en [DIRECCIÓN]. Requiere intervención de bomberos.",
                imageResource = "ic_gas_leak"
            ),
            TypificationCode(
                code = "938",
                acronym = "MATPEL",
                description = "Materiales peligrosos",
                questions = "Derrame o fuga de material peligroso que pueda afectar a personas, animales o el medio ambiente.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Químico, biológico, radiactivo",
                voiceTransfer = "Transferencia a bomberos y equipos HAZMAT",
                incidentCopy = "Materiales peligrosos en [DIRECCIÓN]. Requiere equipos especializados.",
                imageResource = "ic_hazmat"
            ),
            TypificationCode(
                code = "939",
                acronym = "EVADES",
                description = "Evento de aglomeración o desorden",
                questions = "Situación que altera el orden público en un evento con gran cantidad de personas.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Deportivo, cultural, protesta",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Evento de aglomeración o desorden en [DIRECCIÓN]. Requiere control policial.",
                imageResource = "ic_crowd"
            ),
            TypificationCode(
                code = "942",
                acronym = "ACCTRA",
                description = "Accidente de tránsito",
                questions = "Suceso imprevisto producido por la participación de un vehículo o más en las vías o carreteras y que ocasiona daños materiales o lesiones a personas y hasta la muerte de las mismas.",
                modifyingCircumstances = "Gravedad",
                modifyingCircumstancesDescription = "Sin heridos, con heridos, con atrapados",
                voiceTransfer = "Transferencia a policía de tránsito y servicios médicos",
                incidentCopy = "Accidente de tránsito en [DIRECCIÓN]. Requiere asistencia.",
                imageResource = "ic_traffic_accident"
            ),
            TypificationCode(
                code = "941",
                acronym = "ACCAEREO",
                description = "Accidente aéreo",
                questions = "Suceso relacionado con la operación de una aeronave que ocurre entre el momento en que una persona entra a bordo con intención de volar y el momento en que todas las personas han desembarcado.",
                modifyingCircumstances = "Tipo",
                modifyingCircumstancesDescription = "Comercial, privado, militar",
                voiceTransfer = "Transferencia a servicios de emergencia y autoridades aéreas",
                incidentCopy = "Accidente aéreo en [DIRECCIÓN]. Requiere respuesta de emergencia.",
                imageResource = "ic_plane_crash"
            ),
                   
            // Códigos especiales
            TypificationCode(
                code = "901",
                acronym = "MUERTO",
                description = "Persona fallecida encontrada",
                questions = "¿Cómo fue encontrado el cuerpo? ¿Hay signos de violencia? ¿Cuánto tiempo lleva fallecido aproximadamente?",
                modifyingCircumstances = "Circunstancias del hallazgo",
                modifyingCircumstancesDescription = "Muerte natural, muerte violenta, muerte en vía pública, muerte en residencia",
                voiceTransfer = "Transferencia a policía judicial y medicina legal",
                incidentCopy = "Persona fallecida encontrada en [DIRECCIÓN]. Se requiere presencia de autoridades.",
                imageResource = "ic_death"
            ),
            TypificationCode(
                code = "902",
                acronym = "HERIDO",
                description = "Persona con lesiones que requiere atención médica",
                questions = "¿Qué tipo de heridas presenta? ¿Está consciente? ¿Cómo ocurrió el incidente?",
                modifyingCircumstances = "Gravedad de las heridas",
                modifyingCircumstancesDescription = "Heridas leves, heridas graves, heridas por arma, heridas por accidente",
                voiceTransfer = "Transferencia a servicios médicos de emergencia",
                incidentCopy = "Persona herida en [DIRECCIÓN]. Requiere atención médica urgente.",
                imageResource = "ic_injury"
            ),
            TypificationCode(
                code = "903",
                acronym = "INCENDIO",
                description = "Fuego no controlado que puede causar daños a personas o propiedades",
                questions = "¿Qué está ardiendo? ¿Hay personas atrapadas? ¿Cuál es la magnitud del incendio?",
                modifyingCircumstances = "Tipo de incendio",
                modifyingCircumstancesDescription = "Estructural, forestal, vehicular, industrial, con personas atrapadas",
                voiceTransfer = "Transferencia a bomberos",
                incidentCopy = "Incendio reportado en [DIRECCIÓN]. Se requiere intervención de bomberos.",
                imageResource = "ic_fire"
            ),
           
            ),
            TypificationCode(
                code = "905",
                acronym = "HURTO",
                description = "Robo o hurto de bienes",
                questions = "¿Qué fue robado? ¿Cuándo ocurrió? ¿Hay testigos o cámaras de seguridad?",
                modifyingCircumstances = "Tipo de hurto",
                modifyingCircumstancesDescription = "Hurto a persona, hurto a residencia, hurto a comercio, hurto de vehículo",
                voiceTransfer = "Transferencia a policía",
                incidentCopy = "Hurto reportado en [DIRECCIÓN]. Se requiere presencia policial.",
                imageResource = "ic_theft"
            ),
          
         
          
        )
    }
}
