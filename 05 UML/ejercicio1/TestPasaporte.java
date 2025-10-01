package ejercicio1;

import java.util.Date;

// Clase de prueba
public class TestPasaporte {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 1: Pasaporte - Foto - Titular ===\n");
        
        // Crear titular
        Titular titular = new Titular("Juan Pérez", "12345678");
        
        // Crear pasaporte con foto (composición)
        byte[] imagenFoto = new byte[]{1, 2, 3, 4, 5}; // Simulación de imagen
        Pasaporte pasaporte = new Pasaporte("ARG123456", new Date(), imagenFoto, "JPEG");
        
        // Establecer la relación bidireccional
        pasaporte.setTitular(titular);
        
        // Mostrar información
        System.out.println("Información del pasaporte:");
        System.out.println(pasaporte);
        System.out.println("\nInformación del titular:");
        System.out.println(titular);
        System.out.println("\nFoto del pasaporte:");
        System.out.println(pasaporte.getFoto());
        
        // Verificar bidireccionalidad
        System.out.println("\nVerificación de bidireccionalidad:");
        System.out.println("Pasaporte del titular: " + titular.getPasaporte().getNumero());
        
        System.out.println("\n=== Ejercicio completado exitosamente ===");
    }
}