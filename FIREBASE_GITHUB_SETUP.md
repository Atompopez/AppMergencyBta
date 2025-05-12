# Configuración de Firebase con GitHub Actions

Este documento explica cómo configurar correctamente la integración entre Firebase Test Lab y GitHub Actions para tu proyecto AppMergencyBta.

## Configuración de secretos en GitHub

Para que el flujo de trabajo de GitHub Actions pueda autenticarse con Firebase/Google Cloud, necesitas configurar un secreto en tu repositorio de GitHub:

1. Ve a tu repositorio en GitHub (https://github.com/Atompopez/AppMergencyBta)
2. Haz clic en "Settings" (Configuración)
3. En el menú lateral, haz clic en "Secrets and variables" > "Actions"
4. Haz clic en "New repository secret"
5. Configura el siguiente secreto:

### Opción 1: Usar credenciales JSON (recomendado para empezar)

1. Nombre del secreto: `GCP_FIREBASE_CREDENTIALS`
2. Valor: El contenido completo del archivo JSON de la cuenta de servicio de Google Cloud

Para obtener este archivo JSON:
1. Ve a la [Consola de Google Cloud](https://console.cloud.google.com/)
2. Selecciona tu proyecto
3. Ve a "IAM & Admin" > "Service Accounts"
4. Crea una nueva cuenta de servicio o selecciona una existente
5. Genera una nueva clave en formato JSON
6. Copia todo el contenido del archivo JSON y pégalo como valor del secreto

### Opción 2: Usar Workload Identity Federation (más seguro para entornos de producción)

Si prefieres usar Workload Identity Federation (más seguro pero más complejo de configurar):

1. Configura Workload Identity Federation en Google Cloud siguiendo [esta guía](https://github.com/google-github-actions/auth#setup)
2. Crea un secreto llamado `WORKLOAD_IDENTITY_PROVIDER` con el valor del proveedor de identidad
3. Modifica el archivo de flujo de trabajo para usar `workload_identity_provider` en lugar de `credentials_json`

## Verificación

Una vez configurados los secretos, cada vez que hagas push a la rama main, el flujo de trabajo de GitHub Actions:

1. Compilará la aplicación
2. Ejecutará pruebas en Firebase Test Lab usando un dispositivo virtual

## Solución de problemas

Si sigues viendo el error:
```
google-github-actions/auth failed with: the GitHub Action workflow must specify exactly one of "workload_identity_provider" or "credentials_json"!
```

Asegúrate de que:
1. El secreto `GCP_FIREBASE_CREDENTIALS` está correctamente configurado en GitHub
2. El secreto contiene el JSON completo y válido de las credenciales de servicio
3. Si estás ejecutando el flujo de trabajo desde un fork o Dependabot, los secretos no se pasarán por razones de seguridad

## Recursos adicionales

- [Documentación de google-github-actions/auth](https://github.com/google-github-actions/auth)
- [Documentación de Firebase Test Lab](https://firebase.google.com/docs/test-lab)
- [Guía de GitHub Actions para secretos](https://docs.github.com/es/actions/security-guides/encrypted-secrets)
