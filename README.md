# Servicio de Envío de Correos con Archivos Adjuntos

Este proyecto implementa un servicio para enviar correos electrónicos personalizados con la capacidad de incluir archivos adjuntos. El servicio está desarrollado con Spring Boot y utiliza JavaMailSender para la gestión del envío de correos.

## Descripción

Este servicio permite enviar correos electrónicos de forma sencilla con un cuerpo HTML que incluye detalles personalizados del contacto, como el nombre, correo, asunto y mensaje. Además, se puede adjuntar un archivo al correo. El HTML del mensaje está diseñado para ser atractivo y amigable, utilizando estilos CSS en línea.

## Funcionalidades

- **Envío de correos electrónicos**: El servicio permite enviar correos personalizados con los detalles de un contacto.
- **Soporte para archivos adjuntos**: Se pueden adjuntar archivos al correo, si es necesario.
- **Diseño de correo HTML**: El cuerpo del correo incluye un diseño básico con estilo en línea para asegurar la compatibilidad con diferentes clientes de correo.
- **Uso de JavaMailSender**: Utiliza `JavaMailSender` para manejar la creación y el envío del correo electrónico.

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal utilizado para el desarrollo del servicio.
- **JavaMailSender**: Biblioteca de Spring utilizada para enviar correos electrónicos.
- **Thymeleaf**: Motor de plantillas utilizado para renderizar el contenido HTML en el cuerpo del correo.

## Requisitos

- **JDK 11 o superior**
- **Spring Boot**: 3.0.0 o superior
- **JavaMailSender**: Integración con Spring Boot
- **Dependencia de Thymeleaf** (si se desea incluir plantillas HTML más dinámicas)

## Instrucciones de Uso

### 1. Configuración del Servidor SMTP

Antes de utilizar el servicio de correo, asegúrate de configurar correctamente el servidor SMTP en tu archivo `application.properties` o `application.yml` de Spring Boot.

```properties
spring.mail.host=smtp.example.com
spring.mail.port=587
spring.mail.username=tu-correo@example.com
spring.mail.password=tu-contraseña
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
