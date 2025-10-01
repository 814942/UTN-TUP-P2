package dependencia;

// Clase de prueba
public class TestReproductor {
    public static void main(String[] args) {
        System.out.println("=== EJEMPLO DE DEPENDENCIA DE USO ===\n");
        
        // Crear artistas independientes
        Artista artista1 = new Artista("Gustavo Cerati", "Rock");
        Artista artista2 = new Artista("Mercedes Sosa", "Folklore");
        
        // Crear canciones (asociación unidireccional con artista)
        Cancion cancion1 = new Cancion("Crimen", artista1);
        Cancion cancion2 = new Cancion("Alfonsina y el Mar", artista2);
        
        // Crear reproductor
        Reproductor reproductor = new Reproductor();
        System.out.println("Reproductor creado: " + reproductor);
        
        // DEMOSTRAR DEPENDENCIA DE USO
        System.out.println("\n=== DEPENDENCIA DE USO ===");
        System.out.println("El Reproductor NO guarda la canción como atributo");
        System.out.println("Solo la usa temporalmente como parámetro\n");
        
        // Usar el reproductor con diferentes canciones
        System.out.println("--- Reproduciendo Canción 1 ---");
        reproductor.reproducir(cancion1);
        
        System.out.println("\n--- Ajustando Volumen ---");
        reproductor.ajustarVolumen(75);
        
        System.out.println("\n--- Reproduciendo Canción 2 ---");
        reproductor.reproducir(cancion2);
        
        reproductor.detener();
        
        System.out.println("\n--- Mostrando Info ---");
        reproductor.mostrarInfo(cancion1);
        
        System.out.println("\n=== CARACTERISTICA CLAVE ===");
        System.out.println("El reproductor puede usar CUALQUIER cancion");
        System.out.println("sin necesidad de guardarla:");
        
        System.out.println("\nReproduciendo cancion1:");
        reproductor.reproducir(cancion1);
        
        System.out.println("\nInmediatamente reproduciendo cancion2:");
        reproductor.reproducir(cancion2);
        
        System.out.println("\n¡El reproductor usa las canciones pero NO las almacena!");
        
        System.out.println("\n=== Ejercicio completado exitosamente ===");
    }
}