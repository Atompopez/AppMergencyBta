package com.example.appmergencybta.data.database

import com.example.appmergencybta.data.database.entities.TypificationCode

/**
 * Proveedor de datos iniciales para la base de datos
 */
object DataProvider {
    
    /**
     * Obtiene la lista de códigos de tipificación para inicializar la base de datos
     */
    fun getTypificationCodes(): List<TypificationCode> {
        return listOf(
            TypificationCode(
                code = "457",
                acronym = "VMEDGUB",
                description = "Conductas de violación a la normatividad que afectan el desarrollo de las acciones de control de los entes gubernamentales. Palabras clave: aglomeración, establecimiento, espacio público, vivienda, elemento de bioseguridad.",
                questions = "¿Sabe si la persona usa elementos de bioseguridad? ¿De cuántas personas se trata?",
                modifyingCircumstances = null,
                modifyingCircumstancesDescription = null,
                voiceTransfer = null,
                incidentCopy = "Policía",
                imageResource = "ic_vmedgub"
            ),
            TypificationCode(
                code = "535",
                acronym = "INFCON",
                description = "Información que puede conducir a la captura o hallazgo de: caleta de armas, cabecilla de la guerrilla o paramilitar buscado, ubicación de un secuestrado, amenaza de muerte, ubicación de una obra de arte u objeto de valor robado. Incluye casos de extorsión, contrabando y perturbación electoral.",
                questions = "Indague por la situación para poder determinar si hay lugar a otro código.",
                modifyingCircumstances = "NOBOGOTA",
                modifyingCircumstancesDescription = null,
                voiceTransfer = "Policía",
                incidentCopy = "Policía",
                imageResource = "ic_infcon"
            ),
            TypificationCode(
                code = "601",
                acronym = "ACV",
                description = "Evento de origen cerebral que se manifiesta por incapacidad para articular palabra, desviación de la cara, incapacidad para la movilización de cualquier extremidad (superiores o inferiores). Puede provocar estado de inconsciencia. Palabras clave: trombosis, derrame.",
                questions = "¿Sabe si la persona está despierta? Seleccionar INCONSCIEN en caso de que la persona no esté despierta.",
                modifyingCircumstances = "INCONSCIEN",
                modifyingCircumstancesDescription = "Inconsciente",
                voiceTransfer = "TARM",
                incidentCopy = "CRUE",
                imageResource = "ic_acv"
            ),
            TypificationCode(
                code = "602",
                acronym = "CAIALT",
                description = "Se utiliza este código en caso de caída de altura o trauma craneoencefálico. No incluye caída de su propia altura, la cual se deberá tipificar como 608 - HERIDO.",
                questions = "¿Sabe de dónde cayó? ¿Sabe si se encuentra en un lugar de difícil acceso? Seleccionar RESCATE si la persona se encuentra en un lugar de difícil acceso.",
                modifyingCircumstances = "INCONSCIEN, RESCATE, INCO/RESC, NOBOGOTA",
                modifyingCircumstancesDescription = "Inconsciente, Rescate, Inconsciente y rescate",
                voiceTransfer = "TARM",
                incidentCopy = "CRUE, Bomberos",
                imageResource = "ic_caialt"
            ),
            TypificationCode(
                code = "603",
                acronym = "CONVULSIÓN",
                description = "Se caracterizan por movimientos incontrolados e involuntarios, manifestado en uno o más miembros. Incluye salivación profusa, de manera ocasional relajación de esfínteres o, incluso, hasta la pérdida del estado de conciencia. Palabras clave: ataque, epilepsia, ataque epiléptico.",
                questions = "¿Sabe si la persona está despierta? Seleccionar INCONSCIEN en caso de que la persona esté inconsciente.",
                modifyingCircumstances = "INCONSCIEN, NOBOGOTA",
                modifyingCircumstancesDescription = "Inconsciente",
                voiceTransfer = "TARM",
                incidentCopy = "CRUE",
                imageResource = "ic_convulsion"
            ),
            TypificationCode(
                code = "604",
                acronym = "EVERES",
                description = "Situación que ocasiona una sensación o incomodidad al respirar o la sensación de no estar recibiendo el suficiente aire, puede producir cambios de color en la piel y observarse mayor esfuerzo al respirar. También se puede originar por la presencia de un cuerpo extraño sólido o líquido en la tráquea, laringe o faringe. Palabras claves: Inmersión, obstrucción por cuerpo extraño, por humo, por factores químicos, por enfermedad crónica, por enfermedad aguda, asfixiado, ahogado, está morado",
                questions = "¿Sabe si el paciente está morado o si emite ruidos al respirar? Seleccione MORADRUIDO si el paciente está morado o emite ruidos al respirar.",
                modifyingCircumstances = "EISP, EISP/ASES, MORADRUIDO, NOBOGOTA",
                modifyingCircumstancesDescription = "Evento de interés de salud pública, Asesoría por evento de interés de salud pública, Está morado o emite ruidos al respirar",
                voiceTransfer = "TARM, Información CRUE",
                incidentCopy = "CRUE",
                imageResource = "ic_everes"
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
