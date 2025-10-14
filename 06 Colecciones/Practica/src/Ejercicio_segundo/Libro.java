package Practica.src.Ejercicio_segundo;

/**
 * Clase Libro que representa un libro con sus datos básicos y su autor
 */
public class Libro {
    // Atributos
    private String isbn;              // Identificador único del libro
    private String titulo;            // Título del libro
    private int anioPublicacion;      // Año de publicación
    private Autor autor;              // Autor del libro
    
    // Constructor por defecto
    public Libro() {
    }
    
    // Constructor con parámetros
    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }
    
    // Getters y Setters
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    
    public Autor getAutor() {
        return autor;
    }
    
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    /**
     * Método que muestra la información del libro en consola
     * Incluye título, ISBN, año y autor
     */
    public void mostrarInfo() {
        System.out.println("=== Información del Libro ===");
        System.out.println("Título: " + titulo);
        System.out.println("ISBN: " + isbn);
        System.out.println("Año de Publicación: " + anioPublicacion);
        
        if (autor != null) {
            System.out.println("Autor: " + autor.getNombre() + " (" + autor.getNacionalidad() + ")");
        } else {
            System.out.println("Autor: No especificado");
        }
        
        System.out.println("============================");
    }
}