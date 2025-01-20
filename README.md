# Foro de Tópicos API

Esta es una API REST que simula un foro donde los usuarios pueden gestionar tópicos. Cada tópico tiene un título, mensaje, autor (ID), curso y un estatus que puede ser "RESUELTO" o "NORESUELTO". La API permite la creación, actualización, eliminación y consulta de tópicos.

## Características

- **Autenticación y autorización** para restringir el acceso a la información.
- **Validaciones de negocio** para asegurar que los datos sean correctos antes de ser almacenados o modificados.
- **Base de datos** para la persistencia de la información de los tópicos.
- La API garantiza que no haya tópicos duplicados con el mismo **título** y **mensaje**.

## Funcionalidades

La API proporciona las siguientes funcionalidades:

- **Crear un nuevo tópico**
- **Mostrar todos los tópicos creados**
- **Mostrar un tópico específico**
- **Actualizar un tópico**
- **Eliminar un tópico**
