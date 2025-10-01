public class Estudiante {
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Curso: " + curso);
        System.out.println("Calificación: " + calificacion);
    }

    public void subirCalificacion(double puntos) {
        calificacion += puntos;
        if (calificacion > 100) calificacion = 100; // Limitar a 100
    }

    public void bajarCalificacion(double puntos) {
        calificacion -= puntos;
        if (calificacion < 0) calificacion = 0; // Limitar a 0
    }
}