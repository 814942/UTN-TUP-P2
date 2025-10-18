/**
 * Clase abstracta Empleado que define la estructura base para diferentes tipos de empleados
 * Demuestra el uso de clases abstractas en contextos empresariales
 */
abstract class Empleado {
    protected String nombre;
    protected String apellido;
    protected int id;
    
    public Empleado(String nombre, String apellido, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }
    
    // Método abstracto que debe ser implementado por las subclases
    public abstract double calcularSueldo();
    
    // Método concreto para mostrar información básica
    public void mostrarInfo() {
        System.out.printf("Empleado: %s %s (ID: %d) - Sueldo: $%.2f%n", 
                         nombre, apellido, id, calcularSueldo());
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}

/**
 * Subclase EmpleadoPlanta para empleados permanentes
 */
class EmpleadoPlanta extends Empleado {
    private double sueldoBase;
    private double bonificacion;
    
    public EmpleadoPlanta(String nombre, String apellido, int id, double sueldoBase, double bonificacion) {
        super(nombre, apellido, id);
        this.sueldoBase = sueldoBase;
        this.bonificacion = bonificacion;
    }
    
    @Override
    public double calcularSueldo() {
        return sueldoBase + bonificacion;
    }
    
    @Override
    public void mostrarInfo() {
        System.out.printf("Empleado de Planta: %s %s (ID: %d) - Sueldo Base: $%.2f + Bonificación: $%.2f = Total: $%.2f%n", 
                         nombre, apellido, id, sueldoBase, bonificacion, calcularSueldo());
    }
    
    public double getSueldoBase() {
        return sueldoBase;
    }
    
    public double getBonificacion() {
        return bonificacion;
    }
}

/**
 * Subclase EmpleadoTemporal para empleados temporales
 */
class EmpleadoTemporal extends Empleado {
    private double tarifaPorHora;
    private int horasTrabajadas;
    
    public EmpleadoTemporal(String nombre, String apellido, int id, double tarifaPorHora, int horasTrabajadas) {
        super(nombre, apellido, id);
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }
    
    @Override
    public double calcularSueldo() {
        return tarifaPorHora * horasTrabajadas;
    }
    
    @Override
    public void mostrarInfo() {
        System.out.printf("Empleado Temporal: %s %s (ID: %d) - Tarifa: $%.2f/hora x %d horas = Total: $%.2f%n", 
                         nombre, apellido, id, tarifaPorHora, horasTrabajadas, calcularSueldo());
    }
    
    public double getTarifaPorHora() {
        return tarifaPorHora;
    }
    
    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }
}

/**
 * Subclase EmpleadoComision para empleados que cobran por comisión
 */
class EmpleadoComision extends Empleado {
    private double ventasRealizadas;
    private double porcentajeComision;
    
    public EmpleadoComision(String nombre, String apellido, int id, double ventasRealizadas, double porcentajeComision) {
        super(nombre, apellido, id);
        this.ventasRealizadas = ventasRealizadas;
        this.porcentajeComision = porcentajeComision;
    }
    
    @Override
    public double calcularSueldo() {
        return ventasRealizadas * (porcentajeComision / 100);
    }
    
    @Override
    public void mostrarInfo() {
        System.out.printf("Empleado por Comisión: %s %s (ID: %d) - Ventas: $%.2f x %.1f%% = Total: $%.2f%n", 
                         nombre, apellido, id, ventasRealizadas, porcentajeComision, calcularSueldo());
    }
}

/**
 * Clase de prueba para demostrar polimorfismo con empleados
 * Kata 3: Empleados y polimorfismo
 */
public class Kata3_Empleados {
    
    public static void main(String[] args) {
        System.out.println("=== KATA 3: EMPLEADOS Y POLIMORFISMO ===\n");
        
        // 1. Crear diferentes tipos de empleados
        System.out.println("1. Creando empleados individuales:");
        EmpleadoPlanta empleadoPlanta = new EmpleadoPlanta("Juan", "Pérez", 1001, 50000, 5000);
        EmpleadoTemporal empleadoTemporal = new EmpleadoTemporal("María", "González", 1002, 25, 160);
        EmpleadoComision empleadoComision = new EmpleadoComision("Carlos", "López", 1003, 80000, 5);
        
        empleadoPlanta.mostrarInfo();
        empleadoTemporal.mostrarInfo();
        empleadoComision.mostrarInfo();
        
        // 2. Crear lista de empleados (polimorfismo)
        System.out.println("\n2. Lista de empleados (polimorfismo):");
        Empleado[] empleados = {
            new EmpleadoPlanta("Ana", "Martínez", 1004, 45000, 3000),
            new EmpleadoTemporal("Pedro", "Ruiz", 1005, 30, 120),
            new EmpleadoComision("Laura", "Díaz", 1006, 60000, 7),
            new EmpleadoPlanta("Roberto", "Silva", 1007, 55000, 6000),
            new EmpleadoTemporal("Sofia", "Torres", 1008, 22, 180)
        };
        
        // 3. Invocar calcularSueldo() polimórficamente
        System.out.println("\n3. Calculando sueldos polimórficamente:");
        for (Empleado empleado : empleados) {
            empleado.mostrarInfo(); // Polimorfismo: se ejecuta el método correcto según el tipo
        }
        
        // 4. Usar instanceof para clasificar empleados
        System.out.println("\n4. Clasificando empleados por tipo usando instanceof:");
        int empleadosPlanta = 0, empleadosTemporales = 0, empleadosComision = 0;
        double totalSueldosPlanta = 0, totalSueldosTemporales = 0, totalSueldosComision = 0;
        
        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoPlanta) {
                empleadosPlanta++;
                totalSueldosPlanta += empleado.calcularSueldo();
                System.out.println("- Empleado de Planta: " + empleado.getNombreCompleto());
            } else if (empleado instanceof EmpleadoTemporal) {
                empleadosTemporales++;
                totalSueldosTemporales += empleado.calcularSueldo();
                System.out.println("- Empleado Temporal: " + empleado.getNombreCompleto());
            } else if (empleado instanceof EmpleadoComision) {
                empleadosComision++;
                totalSueldosComision += empleado.calcularSueldo();
                System.out.println("- Empleado por Comisión: " + empleado.getNombreCompleto());
            }
        }
        
        // 5. Mostrar estadísticas
        System.out.println("\n5. Estadísticas por tipo de empleado:");
        System.out.println("Empleados de Planta: " + empleadosPlanta + 
                          " - Total sueldos: $" + String.format("%.2f", totalSueldosPlanta));
        System.out.println("Empleados Temporales: " + empleadosTemporales + 
                          " - Total sueldos: $" + String.format("%.2f", totalSueldosTemporales));
        System.out.println("Empleados por Comisión: " + empleadosComision + 
                          " - Total sueldos: $" + String.format("%.2f", totalSueldosComision));
        
        // 6. Calcular nómina total
        System.out.println("\n6. Nómina total de la empresa:");
        double nominaTotal = 0;
        for (Empleado empleado : empleados) {
            nominaTotal += empleado.calcularSueldo();
        }
        System.out.printf("Total de empleados: %d%n", empleados.length);
        System.out.printf("Nómina total: $%.2f%n", nominaTotal);
        System.out.printf("Sueldo promedio: $%.2f%n", nominaTotal / empleados.length);
        
        // 7. Encontrar empleado con mayor sueldo
        System.out.println("\n7. Empleado con mayor sueldo:");
        Empleado empleadoMayorSueldo = empleados[0];
        for (Empleado empleado : empleados) {
            if (empleado.calcularSueldo() > empleadoMayorSueldo.calcularSueldo()) {
                empleadoMayorSueldo = empleado;
            }
        }
        System.out.print("Empleado con mayor sueldo: ");
        empleadoMayorSueldo.mostrarInfo();
        
        System.out.println("\n=== FIN KATA 3 ===");
    }
}