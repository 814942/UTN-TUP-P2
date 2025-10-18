/**
 * Clase base Vehiculo que representa un vehículo genérico
 * Demuestra conceptos básicos de herencia
 */
class Vehiculo {
    protected String marca;
    protected String modelo;
    
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public void mostrarInfo() {
        System.out.println("Vehículo: " + marca + " " + modelo);
    }
    
    public String getMarca() {
        return marca;
    }
    
    public String getModelo() {
        return modelo;
    }
}

/**
 * Subclase Auto que extiende de Vehiculo
 */
class Auto extends Vehiculo {
    private int cantidadPuertas;
    
    public Auto(String marca, String modelo, int cantidadPuertas) {
        super(marca, modelo);
        this.cantidadPuertas = cantidadPuertas;
    }
    
    @Override
    public void mostrarInfo() {
        System.out.println("Auto: " + marca + " " + modelo + " - " + cantidadPuertas + " puertas");
    }
    
    public void mostrarInfoDetallada() {
        System.out.println("=== Información del Auto ===");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Cantidad de puertas: " + cantidadPuertas);
    }
    
    public int getCantidadPuertas() {
        return cantidadPuertas;
    }
}

/**
 * Clase de prueba para demostrar herencia básica con Vehículos
 * Kata 1: Vehículos y herencia básica
 */
public class Kata1_Vehiculos {
    
    public static void main(String[] args) {
        System.out.println("=== KATA 1: VEHÍCULOS Y HERENCIA BÁSICA ===\n");
        
        // 1. Crear instancia de la clase padre
        System.out.println("1. Creando un vehículo genérico:");
        Vehiculo vehiculo = new Vehiculo("Toyota", "Genérico");
        vehiculo.mostrarInfo();
        
        // 2. Crear instancia de la subclase
        System.out.println("\n2. Creando un auto (subclase):");
        Auto auto = new Auto("Honda", "Civic", 4);
        auto.mostrarInfo(); // Método sobrescrito
        
        // 3. Mostrar información detallada
        System.out.println("\n3. Mostrando información detallada del auto:");
        auto.mostrarInfoDetallada();
        
        // 4. Demostrar polimorfismo (upcasting)
        System.out.println("\n4. Demostrando polimorfismo:");
        Vehiculo vehiculoPolimorfismo = new Auto("Mazda", "CX-5", 5);
        vehiculoPolimorfismo.mostrarInfo(); // Se ejecuta el método sobrescrito de Auto
        
        // 5. Verificar tipo con instanceof
        System.out.println("\n5. Usando instanceof para verificar tipo:");
        if (vehiculoPolimorfismo instanceof Auto) {
            System.out.println("vehiculoPolimorfismo es una instancia de Auto");
            // Downcasting para acceder a métodos específicos de Auto
            Auto autoDowncast = (Auto) vehiculoPolimorfismo;
            System.out.println("Cantidad de puertas: " + autoDowncast.getCantidadPuertas());
        }
        
        // 6. Crear array de vehículos (polimorfismo)
        System.out.println("\n6. Array de vehículos (polimorfismo):");
        Vehiculo[] vehiculos = {
            new Vehiculo("Ford", "Genérico"),
            new Auto("Chevrolet", "Onix", 4),
            new Auto("Volkswagen", "Golf", 5)
        };
        
        for (Vehiculo v : vehiculos) {
            v.mostrarInfo(); // Polimorfismo en acción
        }
        
        System.out.println("\n=== FIN KATA 1 ===");
    }
}