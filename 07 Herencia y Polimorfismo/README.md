# Katas de Herencia y Polimorfismo en Java

Este proyecto contiene 4 katas prácticas para aprender y aplicar los conceptos fundamentales de herencia y polimorfismo en Java.

## 📁 Estructura del Proyecto

```
07 Herencia y Polimorfismo/
├── Kata1_Vehiculos/
│   └── Kata1_Vehiculos.java
├── Kata2_Figuras/
│   └── Kata2_Figuras.java
├── Kata3_Empleados/
│   └── Kata3_Empleados.java
├── Kata4_Animales/
│   └── Kata4_Animales.java
└── README.md
```

## 🎯 Objetivos de Aprendizaje

- Comprender el mecanismo de **herencia** y sus beneficios
- Aplicar **polimorfismo** para lograr flexibilidad en el diseño
- Utilizar correctamente **super()** en constructores
- Controlar el acceso con **modificadores de acceso**
- Identificar y aplicar **upcasting**, **downcasting** e **instanceof**
- Utilizar **clases y métodos abstractos**
- Aplicar principios de **diseño orientado a objetos**

## 📚 Katas Incluidas

### Kata 1: Vehículos y Herencia Básica
**Archivo:** `Kata1_Vehiculos/Kata1_Vehiculos.java`

**Conceptos demostrados:**
- Herencia básica (`extends`)
- Sobrescritura de métodos (`@Override`)
- Uso de `super()` en constructores
- Modificadores de acceso (`protected`)
- Polimorfismo básico
- Upcasting y downcasting
- Uso de `instanceof`

**Clases:**
- `Vehiculo` (clase base)
- `Auto` (subclase)

**Características:**
- Instanciación de objetos padre e hijo
- Demostración de polimorfismo con arrays
- Verificación de tipos con `instanceof`

### Kata 2: Figuras Geométricas y Métodos Abstractos
**Archivo:** `Kata2_Figuras/Kata2_Figuras.java`

**Conceptos demostrados:**
- Clases abstractas (`abstract class`)
- Métodos abstractos (`abstract method`)
- Implementación obligatoria en subclases
- Polimorfismo con clases abstractas
- Cálculos matemáticos en herencia

**Clases:**
- `Figura` (clase abstracta)
- `Circulo`, `Rectangulo`, `Triangulo` (subclases concretas)

**Características:**
- Método abstracto `calcularArea()`
- Polimorfismo en arrays de figuras
- Cálculo de áreas totales
- Clasificación por tipo de figura

### Kata 3: Empleados y Polimorfismo
**Archivo:** `Kata3_Empleados/Kata3_Empleados.java`

**Conceptos demostrados:**
- Polimorfismo en contextos empresariales
- Diferentes estrategias de cálculo (Strategy Pattern básico)
- Clasificación con `instanceof`
- Gestión de colecciones heterogéneas

**Clases:**
- `Empleado` (clase abstracta)
- `EmpleadoPlanta`, `EmpleadoTemporal`, `EmpleadoComision` (subclases)

**Características:**
- Diferentes métodos de cálculo de sueldo
- Estadísticas por tipo de empleado
- Cálculo de nóminas
- Búsqueda de empleado con mayor sueldo

### Kata 4: Animales y Comportamiento Sobrescrito
**Archivo:** `Kata4_Animales/Kata4_Animales.java`

**Conceptos demostrados:**
- Sobrescritura extensiva de métodos
- Comportamientos específicos por especie
- Métodos únicos por subclase
- Polimorfismo con múltiples comportamientos

**Clases:**
- `Animal` (clase base)
- `Perro`, `Gato`, `Vaca`, `Pajaro` (subclases)

**Características:**
- Sonidos específicos por animal
- Comportamientos únicos (mover cola, ronronear, etc.)
- Simulación de "zoológico"
- Estadísticas de animales

## 🚀 Cómo Ejecutar las Katas

### Opción 1: Compilar y ejecutar individualmente
```bash
# Kata 1
cd "Kata1_Vehiculos"
javac Kata1_Vehiculos.java
java Kata1_Vehiculos

# Kata 2
cd "../Kata2_Figuras"
javac Kata2_Figuras.java
java Kata2_Figuras

# Kata 3
cd "../Kata3_Empleados"
javac Kata3_Empleados.java
java Kata3_Empleados

# Kata 4
cd "../Kata4_Animales"
javac Kata4_Animales.java
java Kata4_Animales
```

### Opción 2: Ejecutar todas desde VS Code
1. Abrir cada archivo `.java`
2. Hacer clic en "Run" en la parte superior del archivo
3. Ver la salida en la terminal integrada

## 🔍 Conceptos Clave Demostrados

### 1. Herencia
```java
public class Auto extends Vehiculo {
    // Auto hereda de Vehiculo
}
```

### 2. Sobrescritura de Métodos
```java
@Override
public void mostrarInfo() {
    // Implementación específica
}
```

### 3. Clases Abstractas
```java
abstract class Figura {
    public abstract double calcularArea();
}
```

### 4. Polimorfismo
```java
Vehiculo[] vehiculos = {
    new Vehiculo("Ford", "Focus"),
    new Auto("Honda", "Civic", 4)
};
```

### 5. Verificación de Tipos
```java
if (objeto instanceof TipoEspecifico) {
    TipoEspecifico casted = (TipoEspecifico) objeto;
}
```

### 6. Uso de super()
```java
public Auto(String marca, String modelo, int puertas) {
    super(marca, modelo); // Llama al constructor padre
    this.cantidadPuertas = puertas;
}
```

## 📊 Patrones de Diseño Implementados

1. **Template Method**: En las clases abstractas
2. **Strategy**: En los diferentes tipos de empleados
3. **Polymorphism**: En todas las katas

## 🎓 Ejercicios Adicionales Sugeridos

1. **Kata 1**: Agregar más tipos de vehículos (Moto, Camión)
2. **Kata 2**: Implementar más figuras (Trapecio, Pentágono)
3. **Kata 3**: Agregar empleados con salario mixto (base + comisión)
4. **Kata 4**: Crear una jerarquía más compleja (Mamíferos, Aves, etc.)

## 📝 Notas Importantes

- Cada kata está diseñada para ser ejecutada independientemente
- Los comentarios explican cada concepto aplicado
- Se incluyen múltiples ejemplos de polimorfismo
- Se demuestra tanto upcasting como downcasting seguro
- Todas las clases están en un solo archivo para facilitar la ejecución

## 🏆 Conclusiones Esperadas

Al completar estas katas, deberías poder:

✅ **Implementar herencia** correctamente usando `extends`  
✅ **Sobrescribir métodos** con `@Override`  
✅ **Crear clases abstractas** y métodos abstractos  
✅ **Aplicar polimorfismo** en diferentes contextos  
✅ **Usar instanceof** para verificación de tipos  
✅ **Realizar casting** seguro de objetos  
✅ **Gestionar modificadores de acceso** apropiadamente  
✅ **Inicializar objetos** con `super()` correctamente  

## 📚 Referencias Adicionales

- [Documentación oficial de Java - Herencia](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- [Documentación oficial de Java - Polimorfismo](https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html)
- [Documentación oficial de Java - Clases Abstractas](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)

---
*Proyecto creado para el curso de Programación 2 - UTN*