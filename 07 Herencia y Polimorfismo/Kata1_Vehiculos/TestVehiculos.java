/**
 * Clase de prueba para demostrar herencia básica con Vehículos
 * Kata 1: Vehículos y herencia básica
 */
public class TestVehiculos {
    
    public static void main(String[] args) {
        System.out.println("=== KATA 1: VEHÍCULOS Y HERENCIA BÁSICA ===\n");
        
        // Crear instancia de la clase padre
        System.out.println("1. Creando un vehículo genérico:");
        Vehiculo vehiculo = new Vehiculo("Toyota", "Genérico");
        vehiculo.mostrarInfo();
        
        System.out.println("\n2. Creando un auto (subclase):");
        Auto auto = new Auto("Honda", "Civic", 4);
        auto.mostrarInfo();
        
        System.out.println("\n3. Mostrando información detallada del auto:");
        auto.mostrarInfoDetallada();
        
        System.out.println("\n4. Demostrando polimorfismo:");
        // Upcasting: Auto se asigna a referencia de Vehiculo
        Vehiculo vehiculoPolimorfismo = new Auto("Mazda", "CX-5", 5);
        vehiculoPolimorfismo.mostrarInfo(); // Se ejecuta el método sobrescrito de Auto
        
        System.out.println("\n5. Usando instanceof para verificar tipo:");
        if (vehiculoPolimorfismo instanceof Auto) {
            System.out.println("vehiculoPolimorfismo es una instancia de Auto");
            // Downcasting para acceder a métodos específicos de Auto
            Auto autoDowncast = (Auto) vehiculoPolimorfismo;
            System.out.println("Cantidad de puertas: " + autoDowncast.getCantidadPuertas());
        }
        
        System.out.println("\n=== FIN KATA 1 ===");
    }
}