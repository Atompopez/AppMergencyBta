package com.example.appmergencybta.data.database

import com.example.appmergencybta.data.database.entities.TypificationCode

/**
 * Proveedor de datos iniciales para la base de datos
 */
object DataProvider {
    
    /**
     * Obtiene la lista de códigos de tipificación para inicializar la base de datos
     * Actualizado según la guía oficial de tipificación
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
                questions = "Información que puede conducir a la captura o hallazgo de: caleta de armas, cabecilla de la delincuencia o persona buscada, ubicación de un secuestrado, amenaza de muerte, ubicación de una obra de arte u objeto de valor robado. Incluye casos de extorsión, contrabando y perturbación electoral.",
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
                questions = "Evento de origen cerebral que se manifiesta por incapacidad para articular palabra, desviación de la cara, incapacidad para la movilización de cualquier extremidad (superiores o inferiores). Palabras clave: derrame, infarto cerebral.",
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
                questions = "Se utiliza este código en caso de caída de altura o trauma craneoencefálico. No incluye caída de su propia altura, la cual se deberá aplicar como 605-HERIDO. Palabras clave: caída, trauma.",
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
                questions = "Se caracterizan por movimientos incontrolados e involuntarios, manifestados en uno o más miembros. Incluye salivación profusa, de manera ocasional relajación de esfínteres o, incluso, hasta la pérdida del estado de conciencia. Palabras clave: ataque, epilepsia, ataque epiléptico.",
                modifyingCircumstances = "Estado",
                modifyingCircumstancesDescription = "Consciente, inconsciente",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona con convulsiones en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_convulsion"
            ),
            TypificationCode(
                code = "604",
                acronym = "EVERES",
                description = "Evento respiratorio",
                questions = "Situación que ocasiona una sensación de incomodidad al respirar o la sensación de no estar recibiendo el suficiente aire, puede producir cambios de color en la piel y observarse mayor esfuerzo al respirar. También se puede originar por la presencia de un cuerpo extraño sólido o líquido en la tráquea, laringe o faringe. Palabras clave: inmersión, obstrucción por cuerpo extraño, por humo, por factores químicos, por enfermedad crónica, por enfermedad aguda, asfixiado, ahogado, está morado.",
                modifyingCircumstances = "Causa",
                modifyingCircumstancesDescription = "Obstrucción, inmersión, enfermedad",
                voiceTransfer = "Transferencia a servicios médicos",
                incidentCopy = "Persona con dificultad respiratoria en [DIRECCIÓN]. Requiere asistencia médica urgente.",
                imageResource = "ic_respiratory"
            ),
            TypificationCode(
                code = "605",
                acronym = "DOLTOR",
                description = "Sensación de molestia, incomodidad o dolor que se siente en el pecho (algún punto a lo largo de la parte anterior del cuerpo entre el cuello y el abdomen superior). Palabras clave: infarto, preinfarto.",
                questions = "¿Sabe si la persona tiene antecedentes? Seleccione ANTECEDEN si la persona tiene antecedentes de infarto, preinfarto o similares.",
                modifyingCircumstances = "EISP, EISP/ASES, ANTECEDEN, NOBOGOTA",
                modifyingCircumstancesDescription = "Evento de interés de salud pública, Asesoría por evento de interés de salud pública, Antecedentes",
                voiceTransfer = "TARM, Información CRUE",
                incidentCopy = "CRUE",
                imageResource = "ic_doltor"
            ),
            TypificationCode(
                code = "934",
                acronym = "RIÑA",
                description = "Es todo incidente o altercado que pueda surgir entre dos o más personas ocasionando agresiones físicas, que pueden llevar incluso a poner en riesgo la vida de una persona. Reñir, incitar o incurrir en confrontaciones violentas que puedan derivar en agresiones físicas.",
                questions = "¿Sabe si se están usando armas de fuego? Seleccione U.ARM.FUE si se están usando armas de fuego. ¿Sabe si hay heridos? Seleccione HERIDO si hay heridos.",
                modifyingCircumstances = "VIOINTFAM, VIOGENERO, VMEDGUB, U.ARM.FUE, HERIDO, U.A.F/HER, NOBOGOTA",
                modifyingCircumstancesDescription = "Violencia intrafamiliar, Violencia de género, Violación de medida gubernamental, Uso de arma de fuego, Herido, Uso de arma de fuego y herido",
                voiceTransfer = "TARM",
                incidentCopy = "Policía, CRUE",
                imageResource = "ic_rina"
            ),
            TypificationCode(
                code = "904",
                acronym = "HUREFECT",
                description = "Comete este delito quien toma un bien mueble y ajeno sin la voluntad de su dueño, sometiendo a la víctima a estado de indefensión o con violencia sobre las personas o las cosas. Aquellos hurtos en los que no hay presencia de agresores.",
                questions = "¿Sabe hace cuánto ocurrió? Si son menos de 30 minutos y puede informar características de los delincuentes tipificar como 905 – HURPROCESO.",
                modifyingCircumstances = "VEHI, HERIDO, VH/HER, NOBOGOTA",
                modifyingCircumstancesDescription = "Vehículo, Herido, Vehículo y herido",
                voiceTransfer = "TARM",
                incidentCopy = "Policía, CRUE",
                imageResource = "ic_hurefect"
            ),
            TypificationCode(
                code = "942",
                acronym = "ACCTRA",
                description = "Suceso eventual que altera el orden regular del tránsito en la ciudad, en el cual están involucrados vehículos contra: personas, estructuras, mobiliario público, otros vehículos o cualquier otro actor de la vía.",
                questions = "¿Puede dar información de los vehículos o elementos implicados? ¿Sabe si bloquean alguna vía? ¿Sabe si se presentan vehículos volcados o que no puedan ser movilizados?",
                modifyingCircumstances = "HERIDO, RESCATE, TR.MASIVO, MAT.PEL, HER/RES, HER/T.MAS, M.PEL/HER, RES/T.MAS, M.PEL/RES, T.MAS/M.P, T.M/H/R, M.P/H/R, T.M/M.P/H, T.M/M.P/R, T/M/H/R, NOBOGOTA",
                modifyingCircumstancesDescription = "Herido, Rescate, Transporte masivo, Materiales peligrosos, Herido y rescate, Herido y transporte masivo, Materiales peligrosos y herido, Rescate y transporte masivo, Materiales peligrosos y rescate, Transporte masivo y materiales peligrosos, Transporte masivo, herido y rescate, Materiales peligrosos, herido y rescate, Transporte masivo, materiales peligrosos y herido, Transporte masivo, materiales peligrosos y rescate, Transporte masivo, materiales peligrosos, herido y rescate",
                voiceTransfer = null,
                incidentCopy = "Movilidad, CRUE, Bomberos, IDIGER, Policía",
                imageResource = "ic_acctra"
            )
        )
    }
}
