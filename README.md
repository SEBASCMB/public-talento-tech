# TalentoTech - Java Projects Portfolio

Este repositorio contiene una colección de proyectos Java desarrollados como parte del programa TalentoTech.

## Proyectos

### 1. Emprendedor
Sistema de gestión de emprendedores y sus proyectos.

**Características:**
- Registro de emprendedores con información personal y profesional
- Gestión de proyectos con diferentes estados y niveles de innovación
- Actualización dinámica del estado de proyectos
- Validación de datos de entrada

**Clases principales:**
- `Emprendedor`: Representa la información del emprendedor
- `Proyecto`: Maneja los datos del proyecto
- `EstadoProyecto`: Enum con estados (EN_DISEÑO, EN_MARCHA, CRECIMIENTO)
- `NivelInnovacion`: Enum con niveles (BAJO, MEDIO, ALTO)
- `App`: Clase principal con interfaz de usuario

### 2. EnergiaSolar
Simulador para calcular la generación de energía solar.

**Características:**
- Cálculo de energía generada basado en eficiencia, área y radiación
- Validación de rangos de valores de entrada
- Clasificación automática de producción energética
- Interfaz de usuario interactiva

**Funcionalidades:**
- Eficiencia del panel: 0.10 - 0.25
- Área del panel: 5 - 50 m²
- Radiación solar: 3.5 - 6.5 kWh/m²/día
- Clasificación: Producción Baja/Media/Alta

## Tecnologías Utilizadas
- Java SE
- Scanner para entrada de datos
- Enums para constantes tipadas
- Manejo de excepciones

## Estructura del Proyecto
```
TalentoTech/
├── Emprendedor/
│   ├── src/
│   │   ├── App.java
│   │   ├── Emprendedor.java
│   │   ├── Proyecto.java
│   │   ├── EstadoProyecto.java
│   │   └── NivelInnovacion.java
│   └── Emprendedor.iml
└── EnergiaSolar/
    ├── src/
    │   └── SimuladorEnergiaSolar.java
    └── EnergiaSolar.iml
```

## Cómo Ejecutar

### Emprendedor
```bash
cd TalentoTech/Emprendedor/src
javac *.java
java App
```

### EnergiaSolar
```bash
cd TalentoTech/EnergiaSolar/src
javac SimuladorEnergiaSolar.java
java SimuladorEnergiaSolar
```

## Autor
Desarrollado como parte del programa TalentoTech

## Licencia
Este proyecto es de uso educativo y está disponible bajo los términos del programa TalentoTech.