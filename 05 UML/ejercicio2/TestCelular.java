package ejercicio2;

// Clase de prueba
public class TestCelular {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 2: Celular - Batería - Usuario ===\n");
        
        // Crear batería independiente (agregación)
        Bateria bateria1 = new Bateria("BT-5000", 5000);
        System.out.println("Batería creada: " + bateria1);
        
        // Crear celular sin batería
        Celular celular = new Celular("123456789012345", "Samsung", "Galaxy S21");
        
        // Instalar batería en el celular (agregación)
        celular.instalarBateria(bateria1);
        System.out.println("\nCelular con batería: " + celular);
        System.out.println("Batería instalada: " + celular.getBateria());
        
        // Crear usuario
        Usuario usuario = new Usuario("María González", "87654321");
        
        // Establecer relación bidireccional
        celular.setUsuario(usuario);
        
        System.out.println("\n" + celular);
        System.out.println(usuario);
        System.out.println("Celular del usuario: " + usuario.getCelular().getMarca() + " " + 
                           usuario.getCelular().getModelo());
        
        // Demostrar agregación: remover y reutilizar batería
        System.out.println("\n--- Demostrando Agregación ---");
        Bateria bateriaRemovida = celular.removerBateria();
        System.out.println("Batería removida: " + bateriaRemovida);
        System.out.println("Celular sin batería: " + (celular.getBateria() == null ? "Sin batería" : "Con batería"));
        
        // La batería sigue existiendo y puede usarse en otro celular
        Celular otroCelular = new Celular("999888777666555", "Motorola", "Moto G");
        otroCelular.instalarBateria(bateriaRemovida);
        System.out.println("Batería instalada en otro celular: " + otroCelular.getBateria());
        
        System.out.println("\n=== Ejercicio completado exitosamente ===");
    }
}