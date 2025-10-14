package Practica.src.Ejercicio_segundo;

/**
 * Clase Autor que representa un autor con sus datos básicos
 */
public class Autor {
    // Atributos
    private String id;           // Identificador único del autor
    private String nombre;       // Nombre del autor
    private String nacionalidad; // Nacionalidad del autor
    
    // Constructor por defecto
    public Autor() {
    }
    
    // Constructor con parámetros
    public Autor(String id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    
    // Getters y Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNacionalidad() {
        return nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    /**
     * Método que muestra la información del autor en consola
     */
    public void mostrarInfo() {
        System.out.println("=== Información del Autor ===");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("============================");
    }
}