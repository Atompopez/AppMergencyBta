@echo off
echo Ejecutando build sin tareas de lint...
gradlew.bat build -x lint -x lintVitalRelease -x lintDebug -x lintRelease
echo Build completado.
pause
