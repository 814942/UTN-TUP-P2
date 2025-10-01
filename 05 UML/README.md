# GUÍA: CÓMO TRABAJAR CON MÚLTIPLES CLASES EN JAVA

## ¿Por qué Java requiere un archivo por clase pública?

### Reglas de Java:
1. **Una clase pública por archivo**
2. **El archivo debe llamarse igual que la clase pública**
3. **Ejemplo**: clase `Usuario` → archivo `Usuario.java`

### Diferencias con JavaScript:
```javascript
// JavaScript: múltiples clases en un archivo
// archivo: models.js
class Usuario { ... }
class Producto { ... }
class Orden { ... }
export { Usuario, Producto, Orden };
```

```java
// Java: una clase pública por archivo
// archivo: Usuario.java
public class Usuario { ... }

// archivo: Producto.java  
public class Producto { ... }

// archivo: Orden.java
public class Orden { ... }
```

## Cómo organizar tus ejercicios:

### 1. Estructura de directorios:
```
05 UML/
├── ejercicio1/
│   ├── Foto.java
│   ├── Titular.java
│   ├── Pasaporte.java
│   └── TestPasaporte.java
├── ejercicio2/
│   ├── Bateria.java
│   ├── Usuario.java
│   ├── Celular.java
│   └── TestCelular.java
└── dependencia/
    ├── Artista.java
    ├── Cancion.java
    ├── Reproductor.java
    └── TestReproductor.java
```

### 2. Usar packages:
```java
// En cada archivo
package ejercicio1;

public class Foto {
    // clase Foto
}
```

### 3. Manejar dependencias entre clases:
Cuando una clase usa otra del mismo package, Java las encuentra automáticamente:

```java
package ejercicio1;

public class Pasaporte {
    private Foto foto;        // ✓ Encuentra Foto automáticamente
    private Titular titular;  // ✓ Encuentra Titular automáticamente
}
```

## Cómo compilar y ejecutar:

### Método 1: Individual
```bash
# Compilar un ejercicio específico
javac ejercicio1/*.java

# Ejecutar (desde el directorio padre)
java ejercicio1.TestPasaporte
```

### Método 2: Todos a la vez
```bash
# Usar el script proporcionado
ejecutar_ejercicios.bat
```

### Método 3: Desde VSCode
1. Abrir cualquier archivo .java del ejercicio
2. Click derecho → "Run Java"
3. O usar F5 para debug

## Ventajas de esta organización:

### ✅ Beneficios:
- **Claridad**: Cada clase en su propio archivo
- **Mantenimiento**: Fácil encontrar y modificar código
- **Reutilización**: Las clases se pueden importar desde otros packages
- **Compilación**: Java puede optimizar mejor la compilación
- **Versionado**: Git puede trackear cambios por clase individual

### ✅ Comparación con el archivo único:
```java
// ❌ PROBLEMA: Un archivo con todas las clases
public class Foto { ... }
public class Titular { ... }    // ❌ Error: múltiples clases públicas
public class Pasaporte { ... }  // ❌ Error: múltiples clases públicas

// ✅ SOLUCIÓN: Un archivo por clase
// Foto.java
public class Foto { ... }

// Titular.java  
public class Titular { ... }

// Pasaporte.java
public class Pasaporte { ... }
```

## Patrones de relaciones implementados:

### 1. Composición (Pasaporte → Foto):
```java
public class Pasaporte {
    private Foto foto;  // Composición: Pasaporte CREA y CONTROLA Foto
    
    public Pasaporte(...) {
        this.foto = new Foto(...);  // Crea internamente
    }
}
```

### 2. Agregación (Celular → Bateria):
```java
public class Celular {
    private Bateria bateria;  // Agregación: usa Bateria existente
    
    public void instalarBateria(Bateria bateria) {
        this.bateria = bateria;  // Recibe desde fuera
    }
}
```

### 3. Asociación Bidireccional (Usuario ↔ Celular):
```java
public class Usuario {
    private Celular celular;
    
    public void setCelular(Celular celular) {
        this.celular = celular;
        if (celular != null) {
            celular.setUsuario(this);  // Mantiene bidireccionalidad
        }
    }
}
```

### 4. Dependencia de Uso (Reproductor usa Cancion):
```java
public class Reproductor {
    // NO tiene atributo Cancion
    
    public void reproducir(Cancion cancion) {  // Solo como parámetro
        // Usa temporalmente, no almacena
    }
}
```

## Comandos útiles:

```bash
# Compilar todo
javac **/*.java

# Limpiar archivos compilados
del /s *.class

# Ver estructura
tree /f
```

¡Ahora cada ejercicio está separado y funcionando independientemente!