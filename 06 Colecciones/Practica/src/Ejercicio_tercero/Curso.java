package Practica.src.Ejercicio_tercero;

/**
 * Clase Curso que representa un curso académico
 * Mantiene una relación bidireccional con la clase Profesor
 */
public class Curso {
    // Atributos
    private String codigo;      // Código único del curso
    private String nombre;      // Nombre del curso
    private Profesor profesor;  // Profesor responsable del curso
    
    // Constructor por defecto
    public Curso() {
    }
    
    // Constructor con parámetros (sin profesor)
    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    // Constructor completo con profesor
    public Curso(String codigo, String nombre, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        setProfesor(profesor); // Usar el método para sincronizar
    }
    
    // Getters y Setters básicos
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Profesor getProfesor() {
        return profesor;
    }
    
    /**
     * Asigna o cambia el profesor del curso sincronizando ambos lados de la relación
     * Si tenía profesor previo, se quita de su lista de cursos
     * Si el nuevo profesor no es null, se agrega este curso a su lista
     */
    public void setProfesor(Profesor nuevoProfesor) {
        // Si ya tiene el mismo profesor, no hacer nada
        if (this.profesor == nuevoProfesor) {
            return;
        }
        
        // Si tenía un profesor previo, quitarse de su lista
        if (this.profesor != null) {
            Profesor profesorAnterior = this.profesor;
            this.profesor = null; // Evitar recursión infinita
            
            // Quitar este curso de la lista del profesor anterior
            profesorAnterior.getCursos().remove(this);
            System.out.println("Curso " + codigo + " desasignado del profesor " + profesorAnterior.getNombre());
        }
        
        // Asignar el nuevo profesor
        this.profesor = nuevoProfesor;
        
        // Si el nuevo profesor no es null, agregarse a su lista
        if (nuevoProfesor != null) {
            // Verificar si este curso ya está en la lista del nuevo profesor
            boolean yaEstaEnLista = false;
            for (Curso cursoExistente : nuevoProfesor.getCursos()) {
                if (cursoExistente.getCodigo().equals(this.codigo)) {
                    yaEstaEnLista = true;
                    break;
                }
            }
            
            // Si no está en la lista, agregarlo
            if (!yaEstaEnLista) {
                nuevoProfesor.getCursos().add(this);
                System.out.println("Curso " + codigo + " asignado al profesor " + nuevoProfesor.getNombre());
            }
        }
    }
    
    /**
     * Muestra la información completa del curso
     * Incluye código, nombre y nombre del profesor (si tiene)
     */
    public void mostrarInfo() {
        System.out.println("=== INFORMACIÓN DEL CURSO ===");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        
        if (profesor != null) {
            System.out.println("Profesor: " + profesor.getNombre());
            System.out.println("Especialidad del profesor: " + profesor.getEspecialidad());
        } else {
            System.out.println("Profesor: Sin asignar");
        }
        
        System.out.println("============================");
    }
    
    /**
     * Método para desasignar el profesor del curso
     * Útil para liberar completamente un curso
     */
    public void desasignarProfesor() {
        if (profesor != null) {
            System.out.println("Desasignando profesor " + profesor.getNombre() + " del curso " + codigo);
            setProfesor(null);
        } else {
            System.out.println("El curso " + codigo + " no tiene profesor asignado");
        }
    }
    
    /**
     * Verifica si el curso tiene profesor asignado
     */
    public boolean tieneProfesor() {
        return profesor != null;
    }
    
    /**
     * Override del método toString para mejor representación
     */
    @Override
    public String toString() {
        return codigo + " - " + nombre + (profesor != null ? " (Prof: " + profesor.getNombre() + ")" : " (Sin profesor)");
    }
    
    /**
     * Override del método equals para comparar cursos por código
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Curso curso = (Curso) obj;
        return codigo != null ? codigo.equals(curso.codigo) : curso.codigo == null;
    }
    
    /**
     * Override del método hashCode basado en el código del curso
     */
    @Override
    public int hashCode() {
        return codigo != null ? codigo.hashCode() : 0;
    }
}