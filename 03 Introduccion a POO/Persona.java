// Entendiendo POO
public class Persona { // Clase Persona
    // Atributos
    private String nombre; 
    private int edad;

    // Metodos
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}