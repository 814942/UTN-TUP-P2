package dependencia;

// Clase Reproductor (con DEPENDENCIA DE USO)
public class Reproductor {
    // IMPORTANTE: NO tiene atributo de tipo Cancion
    // Solo usa Cancion como parámetro en métodos
    
    private boolean reproduciendo;
    private int volumen;
    
    public Reproductor() {
        this.reproduciendo = false;
        this.volumen = 50;
    }
    
    // DEPENDENCIA DE USO: recibe Cancion como parámetro
    // pero NO la guarda como atributo
    public void reproducir(Cancion cancion) {
        if (cancion == null) {
            System.out.println("Error: No hay canción para reproducir");
            return;
        }
        
        reproduciendo = true;
        System.out.println("♪ Reproduciendo: \"" + cancion.getTitulo() + "\"");
        System.out.println("   Artista: " + cancion.getArtista().getNombre());
        System.out.println("   Género: " + cancion.getArtista().getGenero());
        System.out.println("   Volumen: " + volumen + "%");
    }
    
    // DEPENDENCIA DE USO: otro método que usa Cancion como parámetro
    public void mostrarInfo(Cancion cancion) {
        if (cancion == null) {
            System.out.println("No hay información disponible");
            return;
        }
        
        System.out.println("\n--- Información de la Canción ---");
        System.out.println("Título: " + cancion.getTitulo());
        System.out.println("Artista: " + cancion.getArtista().getNombre());
        System.out.println("Género: " + cancion.getArtista().getGenero());
    }
    
    public void detener() {
        if (reproduciendo) {
            reproduciendo = false;
            System.out.println("■ Reproducción detenida");
        }
    }
    
    public void ajustarVolumen(int nuevoVolumen) {
        if (nuevoVolumen >= 0 && nuevoVolumen <= 100) {
            this.volumen = nuevoVolumen;
            System.out.println("Volumen ajustado a: " + volumen + "%");
        } else {
            System.out.println("Volumen inválido (debe estar entre 0 y 100)");
        }
    }
    
    public boolean isReproduciendo() {
        return reproduciendo;
    }
    
    public int getVolumen() {
        return volumen;
    }
    
    @Override
    public String toString() {
        return "Reproductor{estado=" + (reproduciendo ? "Reproduciendo" : "Detenido") + 
               ", volumen=" + volumen + "%}";
    }
}