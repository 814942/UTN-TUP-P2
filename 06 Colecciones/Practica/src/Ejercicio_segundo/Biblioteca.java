package Practica.src.Ejercicio_segundo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Biblioteca que gestiona una colección de libros
 */
public class Biblioteca {
    // Atributos
    private String nombre;          // Nombre de la biblioteca
    private List<Libro> libros;     // Colección de libros de la biblioteca
    
    // Constructor por defecto
    public Biblioteca() {
        this.libros = new ArrayList<>();
    }
    
    // Constructor con parámetros
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List<Libro> getLibros() {
        return libros;
    }
    
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    
    /**
     * Agrega un nuevo libro a la biblioteca
     */
    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        // Verificar si ya existe un libro con el mismo ISBN
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                System.out.println("ERROR: Ya existe un libro con el ISBN " + isbn);
                return;
            }
        }
        
        // Crear nuevo libro y agregarlo a la colección
        Libro nuevoLibro = new Libro(isbn, titulo, anioPublicacion, autor);
        libros.add(nuevoLibro);
        System.out.println("Libro agregado exitosamente: " + titulo);
    }
    
    /**
     * Lista todos los libros de la biblioteca
     */
    public void listarLibros() {
        System.out.println("\n=== LIBROS EN LA BIBLIOTECA ===");
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            System.out.println("Total de libros: " + libros.size());
            System.out.println("===============================");
            for (int i = 0; i < libros.size(); i++) {
                System.out.println("Libro #" + (i + 1));
                libros.get(i).mostrarInfo();
                System.out.println();
            }
        }
    }
    
    /**
     * Busca un libro por su ISBN
     */
    public Libro buscarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                System.out.println("Libro encontrado:");
                libro.mostrarInfo();
                return libro;
            }
        }
        System.out.println("No se encontró ningún libro con el ISBN: " + isbn);
        return null;
    }
    
    /**
     * Elimina un libro por su ISBN
     */
    public boolean eliminarLibro(String isbn) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isbn)) {
                Libro libroEliminado = libros.remove(i);
                System.out.println("Libro eliminado exitosamente: " + libroEliminado.getTitulo());
                return true;
            }
        }
        System.out.println("No se encontró ningún libro con el ISBN: " + isbn);
        return false;
    }
    
    /**
     * Obtiene la cantidad total de libros en la biblioteca
     */
    public int obtenerCantidadLibros() {
        int cantidad = libros.size();
        System.out.println("Cantidad total de libros: " + cantidad);
        return cantidad;
    }
    
    /**
     * Filtra y muestra libros por año de publicación
     */
    public List<Libro> filtrarLibrosPorAnio(int anio) {
        List<Libro> librosFiltrados = new ArrayList<>();
        
        for (Libro libro : libros) {
            if (libro.getAnioPublicacion() == anio) {
                librosFiltrados.add(libro);
            }
        }
        
        System.out.println("\n=== LIBROS PUBLICADOS EN " + anio + " ===");
        if (librosFiltrados.isEmpty()) {
            System.out.println("No se encontraron libros publicados en el año " + anio);
        } else {
            System.out.println("Se encontraron " + librosFiltrados.size() + " libro(s):");
            System.out.println("========================================");
            for (Libro libro : librosFiltrados) {
                libro.mostrarInfo();
                System.out.println();
            }
        }
        
        return librosFiltrados;
    }
    
    /**
     * Muestra todos los autores disponibles en la biblioteca (sin repetir)
     */
    public void mostrarAutoresDisponibles() {
        List<String> autoresUnicos = new ArrayList<>();
        
        System.out.println("\n=== AUTORES DISPONIBLES EN LA BIBLIOTECA ===");
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }
        
        for (Libro libro : libros) {
            if (libro.getAutor() != null) {
                String infoAutor = libro.getAutor().getNombre() + " (" + libro.getAutor().getNacionalidad() + ")";
                
                // Verificar si el autor ya está en la lista
                boolean autorExiste = false;
                for (String autorExistente : autoresUnicos) {
                    if (autorExistente.equals(infoAutor)) {
                        autorExiste = true;
                        break;
                    }
                }
                
                if (!autorExiste) {
                    autoresUnicos.add(infoAutor);
                }
            }
        }
        
        if (autoresUnicos.isEmpty()) {
            System.out.println("No hay autores especificados en los libros.");
        } else {
            System.out.println("Total de autores únicos: " + autoresUnicos.size());
            System.out.println("==========================================");
            for (int i = 0; i < autoresUnicos.size(); i++) {
                System.out.println((i + 1) + ". " + autoresUnicos.get(i));
            }
        }
        System.out.println();
    }
}