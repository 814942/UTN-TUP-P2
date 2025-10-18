/**
 * Clase abstracta Figura que define la estructura base para figuras geométricas
 * Demuestra el uso de clases abstractas y métodos abstractos
 */
abstract class Figura {
    protected String nombre;
    
    public Figura(String nombre) {
        this.nombre = nombre;
    }
    
    // Método abstracto que debe ser implementado por las subclases
    public abstract double calcularArea();
    
    // Método concreto que puede ser usado por todas las subclases
    public void mostrarInfo() {
        System.out.println("Figura: " + nombre + " - Área: " + calcularArea());
    }
    
    public String getNombre() {
        return nombre;
    }
}

/**
 * Subclase Circulo que implementa el cálculo del área
 */
class Circulo extends Figura {
    private double radio;
    
    public Circulo(double radio) {
        super("Círculo");
        this.radio = radio;
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
    
    public double getRadio() {
        return radio;
    }
    
    @Override
    public void mostrarInfo() {
        System.out.printf("Círculo - Radio: %.2f - Área: %.2f%n", radio, calcularArea());
    }
}

/**
 * Subclase Rectangulo que implementa el cálculo del área
 */
class Rectangulo extends Figura {
    private double base;
    private double altura;
    
    public Rectangulo(double base, double altura) {
        super("Rectángulo");
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double calcularArea() {
        return base * altura;
    }
    
    public double getBase() {
        return base;
    }
    
    public double getAltura() {
        return altura;
    }
    
    @Override
    public void mostrarInfo() {
        System.out.printf("Rectángulo - Base: %.2f, Altura: %.2f - Área: %.2f%n", 
                         base, altura, calcularArea());
    }
}

/**
 * Subclase Triangulo para demostrar más polimorfismo
 */
class Triangulo extends Figura {
    private double base;
    private double altura;
    
    public Triangulo(double base, double altura) {
        super("Triángulo");
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }
    
    @Override
    public void mostrarInfo() {
        System.out.printf("Triángulo - Base: %.2f, Altura: %.2f - Área: %.2f%n", 
                         base, altura, calcularArea());
    }
}

/**
 * Clase de prueba para demostrar clases abstractas y polimorfismo
 * Kata 2: Figuras geométricas y métodos abstractos
 */
public class Kata2_Figuras {
    
    public static void main(String[] args) {
        System.out.println("=== KATA 2: FIGURAS GEOMÉTRICAS Y MÉTODOS ABSTRACTOS ===\n");
        
        // 1. Crear instancias de diferentes figuras
        System.out.println("1. Creando figuras individuales:");
        Circulo circulo = new Circulo(5.0);
        Rectangulo rectangulo = new Rectangulo(4.0, 6.0);
        Triangulo triangulo = new Triangulo(3.0, 8.0);
        
        circulo.mostrarInfo();
        rectangulo.mostrarInfo();
        triangulo.mostrarInfo();
        
        // 2. Crear array de figuras (polimorfismo)
        System.out.println("\n2. Array de figuras (polimorfismo):");
        Figura[] figuras = {
            new Circulo(3.0),
            new Rectangulo(5.0, 4.0),
            new Triangulo(6.0, 7.0),
            new Circulo(2.5),
            new Rectangulo(3.0, 3.0)
        };
        
        // 3. Mostrar área de cada figura usando polimorfismo
        System.out.println("\n3. Mostrando áreas usando polimorfismo:");
        for (Figura figura : figuras) {
            figura.mostrarInfo(); // Polimorfismo: se ejecuta el método correcto según el tipo
        }
        
        // 4. Calcular área total
        System.out.println("\n4. Calculando área total:");
        double areaTotal = 0;
        for (Figura figura : figuras) {
            areaTotal += figura.calcularArea();
        }
        System.out.printf("Área total de todas las figuras: %.2f%n", areaTotal);
        
        // 5. Clasificar figuras por tipo usando instanceof
        System.out.println("\n5. Clasificando figuras por tipo:");
        int circulos = 0, rectangulos = 0, triangulos = 0;
        
        for (Figura figura : figuras) {
            if (figura instanceof Circulo) {
                circulos++;
            } else if (figura instanceof Rectangulo) {
                rectangulos++;
            } else if (figura instanceof Triangulo) {
                triangulos++;
            }
        }
        
        System.out.println("Cantidad de círculos: " + circulos);
        System.out.println("Cantidad de rectángulos: " + rectangulos);
        System.out.println("Cantidad de triángulos: " + triangulos);
        
        // 6. Encontrar la figura con mayor área
        System.out.println("\n6. Figura con mayor área:");
        Figura figuraMaxArea = figuras[0];
        for (Figura figura : figuras) {
            if (figura.calcularArea() > figuraMaxArea.calcularArea()) {
                figuraMaxArea = figura;
            }
        }
        System.out.print("Figura con mayor área: ");
        figuraMaxArea.mostrarInfo();
        
        System.out.println("\n=== FIN KATA 2 ===");
    }
}