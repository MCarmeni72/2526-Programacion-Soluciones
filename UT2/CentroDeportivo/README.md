# CentroDeportivo

Proyecto educativo desarrollado en Java con el objetivo de aplicar el patrón de arquitectura MVC (Modelo–Vista–Controlador) en una aplicación de consola.

La aplicación simula la gestión básica de un centro deportivo, permitiendo trabajar con socios y actividades, separando claramente la lógica de negocio, la interacción con el usuario y el control del flujo de la aplicación.

## Objetivos del proyecto

* Comprender y aplicar el patrón MVC en una aplicación Java.
* Organizar el código en paquetes con responsabilidades bien definidas.
* Practicar programación orientada a objetos.
* Implementar validaciones y control de errores.
* Escribir y ejecutar pruebas unitarias con JUnit.
* Gestionar el proyecto con Maven.

Este proyecto está pensado con fines formativos y puede utilizarse como base para ampliar funcionalidades o como referencia para futuros desarrollos estructurados en capas.

## Estructura del proyecto

El proyecto sigue una estructura estándar de Maven:

```
src
 ├─ main
 │   └─ java
 │       ├─ controller
 │       ├─ model
 │       ├─ view
 │       ├─ util
 │       └─ Main.java
 └─ test
     └─ java
```

### model

Contiene las clases que representan la lógica de negocio y las entidades principales del sistema:

* `Socio`
* `Actividad`
* `CentroDeportivo`

Aquí se definen los atributos, reglas básicas y comportamiento del dominio.

### view

Incluye la clase `VistaConsola`, responsable de la interacción con el usuario a través de la consola. No contiene lógica de negocio, únicamente muestra información y recoge datos.

### controller

Contiene `CentroDeportivoController`, que actúa como intermediario entre la vista y el modelo. Se encarga de coordinar las operaciones y mantener el flujo de la aplicación.

### util

Incluye clases auxiliares como `InputUtils` para centralizar la lectura y validación de datos introducidos por el usuario.

### Main

Punto de entrada de la aplicación. Inicializa los componentes y arranca el sistema.

## Requisitos

* Java 17 o superior
* Maven 3.8 o superior

## Compilación y ejecución

Desde la raíz del proyecto:

Compilar el proyecto:

```
mvn clean compile
```

Ejecutar la aplicación:

```
mvn exec:java -Dexec.mainClass="Main"
```

Ejecutar las pruebas:

```
mvn test
```

## Funcionalidades principales

* Alta de socios.
* Gestión de actividades.
* Asociación de socios a actividades.
* Visualización de información por consola.
* Validación básica de datos de entrada.
* Pruebas unitarias para modelo y controlador.

## Posibles ampliaciones

Este proyecto puede evolucionar fácilmente hacia:

* Persistencia en ficheros o base de datos.
* Interfaz gráfica (por ejemplo con JavaFX).
* Gestión de cuotas y facturación.
* Control de aforo por actividad.
* Refactorización hacia arquitectura más avanzada (por ejemplo, separación en servicios).

## Notas finales

El objetivo principal no es la complejidad funcional, sino la correcta aplicación de la arquitectura MVC y la claridad en la organización del código. Se recomienda revisar la separación de responsabilidades y las pruebas unitarias como parte del aprendizaje.
