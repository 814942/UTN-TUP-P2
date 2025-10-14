package Practica.src.Ejercicio_tercero;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Profesor que representa un profesor con sus cursos asignados
 * Mantiene una relación bidireccional con la clase Curso
 */
public class Profesor {
    // Atributos
    private String id;              // Identificador único
    private String nombre;          // Nombre completo
    private String especialidad;    // Área principal
    private List<Curso> cursos;     // Cursos que dicta
    
    // Constructor por defecto
    public Profesor() {
        this.cursos = new ArrayList<>();
    }
    
    // Constructor con parámetros
    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList<>();
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
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public List<Curso> getCursos() {
        return cursos;
    }
    
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    /**
     * Agrega un curso a la lista del profesor si no está ya asignado
     * y sincroniza el lado del curso (relación bidireccional)
     */
    public void agregarCurso(Curso curso) {
        if (curso == null) {
            System.out.println("ERROR: El curso no puede ser null");
            return;
        }
        
        // Verificar si el curso ya está asignado a este profesor
        for (Curso c : cursos) {
            if (c.getCodigo().equals(curso.getCodigo())) {
                System.out.println("ERROR: El curso " + curso.getCodigo() + " ya está asignado a este profesor");
                return;
            }
        }
        
        // Agregar el curso a la lista del profesor
        cursos.add(curso);
        
        // Sincronizar el lado del curso (establecer este profesor como el profesor del curso)
        if (curso.getProfesor() != this) {
            curso.setProfesor(this);
        }
        
        System.out.println("Curso agregado exitosamente: " + curso.getNombre() + " (" + curso.getCodigo() + ")");
    }
    
    /**
     * Elimina un curso de la lista del profesor
     * y sincroniza el lado del curso (establece profesor en null)
     */
    public boolean eliminarCurso(Curso curso) {
        if (curso == null) {
            System.out.println("ERROR: El curso no puede ser null");
            return false;
        }
        
        // Buscar y eliminar el curso de la lista
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getCodigo().equals(curso.getCodigo())) {
                Curso cursoEliminado = cursos.remove(i);
                
                // Sincronizar el lado del curso (establecer profesor en null)
                if (curso.getProfesor() == this) {
                    curso.setProfesor(null);
                }
                
                System.out.println("Curso eliminado exitosamente: " + cursoEliminado.getNombre() + " (" + cursoEliminado.getCodigo() + ")");
                return true;
            }
        }
        
        System.out.println("ERROR: El curso " + curso.getCodigo() + " no está asignado a este profesor");
        return false;
    }
    
    /**
     * Lista todos los cursos asignados al profesor
     * Muestra códigos y nombres de los cursos
     */
    public void listarCursos() {
        System.out.println("\n=== CURSOS DEL PROFESOR " + nombre + " ===");
        
        if (cursos.isEmpty()) {
            System.out.println("No tiene cursos asignados.");
        } else {
            System.out.println("Total de cursos: " + cursos.size());
            System.out.println("=========================================");
            
            for (int i = 0; i < cursos.size(); i++) {
                Curso curso = cursos.get(i);
                System.out.println((i + 1) + ". Código: " + curso.getCodigo() + " - Nombre: " + curso.getNombre());
            }
        }
        System.out.println();
    }
    
    /**
     * Muestra la información completa del profesor
     * Incluye datos personales y cantidad de cursos
     */
    public void mostrarInfo() {
        System.out.println("=== INFORMACIÓN DEL PROFESOR ===");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Cantidad de cursos: " + cursos.size());
        
        if (!cursos.isEmpty()) {
            System.out.println("Cursos que dicta:");
            for (Curso curso : cursos) {
                System.out.println("  • " + curso.getCodigo() + " - " + curso.getNombre());
            }
        }
        System.out.println("===============================");
    }
    
    /**
     * Método para verificar si el profesor tiene un curso específico
     */
    public boolean tieneCurso(String codigoCurso) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigoCurso)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método para obtener la cantidad de cursos
     */
    public int getCantidadCursos() {
        return cursos.size();
    }
}