package Practica.src.Ejercicio_tercero;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Universidad que gestiona profesores y cursos
 * Administra las relaciones bidireccionales entre Profesor y Curso
 */
public class Universidad {
    // Atributos
    private String nombre;              // Nombre de la universidad
    private List<Profesor> profesores;  // Lista de profesores
    private List<Curso> cursos;         // Lista de cursos
    
    // Constructor por defecto
    public Universidad() {
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }
    
    // Constructor con parámetros
    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List<Profesor> getProfesores() {
        return profesores;
    }
    
    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }
    
    public List<Curso> getCursos() {
        return cursos;
    }
    
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    /**
     * Agrega un profesor a la universidad
     */
    public void agregarProfesor(Profesor profesor) {
        if (profesor == null) {
            System.out.println("ERROR: El profesor no puede ser null");
            return;
        }
        
        // Verificar si ya existe un profesor con el mismo ID
        for (Profesor p : profesores) {
            if (p.getId().equals(profesor.getId())) {
                System.out.println("ERROR: Ya existe un profesor con el ID " + profesor.getId());
                return;
            }
        }
        
        profesores.add(profesor);
        System.out.println("Profesor agregado exitosamente: " + profesor.getNombre() + " (ID: " + profesor.getId() + ")");
    }
    
    /**
     * Agrega un curso a la universidad
     */
    public void agregarCurso(Curso curso) {
        if (curso == null) {
            System.out.println("ERROR: El curso no puede ser null");
            return;
        }
        
        // Verificar si ya existe un curso con el mismo código
        for (Curso c : cursos) {
            if (c.getCodigo().equals(curso.getCodigo())) {
                System.out.println("ERROR: Ya existe un curso con el código " + curso.getCodigo());
                return;
            }
        }
        
        cursos.add(curso);
        System.out.println("Curso agregado exitosamente: " + curso.getNombre() + " (Código: " + curso.getCodigo() + ")");
    }
    
    /**
     * Asigna un profesor a un curso usando sus identificadores
     * Utiliza el método setProfesor del curso para mantener sincronización
     */
    public boolean asignarProfesorACurso(String codigoCurso, String idProfesor) {
        // Buscar el curso
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        if (curso == null) {
            System.out.println("ERROR: No se encontró el curso con código " + codigoCurso);
            return false;
        }
        
        // Buscar el profesor
        Profesor profesor = buscarProfesorPorId(idProfesor);
        if (profesor == null) {
            System.out.println("ERROR: No se encontró el profesor con ID " + idProfesor);
            return false;
        }
        
        // Usar setProfesor del curso para mantener la sincronización bidireccional
        curso.setProfesor(profesor);
        System.out.println("Asignación exitosa: Profesor " + profesor.getNombre() + " asignado al curso " + curso.getNombre());
        return true;
    }
    
    /**
     * Lista todos los profesores de la universidad
     */
    public void listarProfesores() {
        System.out.println("\n=== PROFESORES DE " + nombre + " ===");
        
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
        } else {
            System.out.println("Total de profesores: " + profesores.size());
            System.out.println("========================================");
            
            for (int i = 0; i < profesores.size(); i++) {
                Profesor profesor = profesores.get(i);
                System.out.println((i + 1) + ". ID: " + profesor.getId() + " - " + profesor.getNombre());
                System.out.println("   Especialidad: " + profesor.getEspecialidad());
                System.out.println("   Cursos asignados: " + profesor.getCantidadCursos());
                System.out.println();
            }
        }
    }
    
    /**
     * Lista todos los cursos de la universidad
     */
    public void listarCursos() {
        System.out.println("\n=== CURSOS DE " + nombre + " ===");
        
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
        } else {
            System.out.println("Total de cursos: " + cursos.size());
            System.out.println("==============================");
            
            for (int i = 0; i < cursos.size(); i++) {
                Curso curso = cursos.get(i);
                System.out.println((i + 1) + ". Código: " + curso.getCodigo() + " - " + curso.getNombre());
                
                if (curso.getProfesor() != null) {
                    System.out.println("   Profesor: " + curso.getProfesor().getNombre());
                } else {
                    System.out.println("   Profesor: Sin asignar");
                }
                System.out.println();
            }
        }
    }
    
    /**
     * Busca un profesor por su ID
     */
    public Profesor buscarProfesorPorId(String id) {
        for (Profesor profesor : profesores) {
            if (profesor.getId().equals(id)) {
                return profesor;
            }
        }
        return null; // No encontrado
    }
    
    /**
     * Busca un curso por su código
     */
    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null; // No encontrado
    }
    
    /**
     * Elimina un curso por su código
     * Rompe la relación con su profesor si la hubiera
     */
    public boolean eliminarCurso(String codigo) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getCodigo().equals(codigo)) {
                Curso cursoAEliminar = cursos.get(i);
                
                // Si el curso tiene profesor asignado, romper la relación
                if (cursoAEliminar.getProfesor() != null) {
                    System.out.println("Rompiendo relación con profesor " + cursoAEliminar.getProfesor().getNombre());
                    cursoAEliminar.setProfesor(null); // Esto sincroniza automáticamente
                }
                
                // Eliminar el curso de la lista
                cursos.remove(i);
                System.out.println("Curso eliminado exitosamente: " + cursoAEliminar.getNombre() + " (" + codigo + ")");
                return true;
            }
        }
        
        System.out.println("ERROR: No se encontró el curso con código " + codigo);
        return false;
    }
    
    /**
     * Elimina un profesor por su ID
     * Antes de remover, establece en null los cursos que dictaba
     */
    public boolean eliminarProfesor(String id) {
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getId().equals(id)) {
                Profesor profesorAEliminar = profesores.get(i);
                
                // Crear una copia de la lista de cursos para evitar ConcurrentModificationException
                List<Curso> cursosDelProfesor = new ArrayList<>(profesorAEliminar.getCursos());
                
                // Desasignar todos los cursos del profesor
                if (!cursosDelProfesor.isEmpty()) {
                    System.out.println("Desasignando " + cursosDelProfesor.size() + " curso(s) del profesor " + profesorAEliminar.getNombre());
                    
                    for (Curso curso : cursosDelProfesor) {
                        curso.setProfesor(null); // Esto sincroniza automáticamente
                    }
                }
                
                // Eliminar el profesor de la lista
                profesores.remove(i);
                System.out.println("Profesor eliminado exitosamente: " + profesorAEliminar.getNombre() + " (ID: " + id + ")");
                return true;
            }
        }
        
        System.out.println("ERROR: No se encontró el profesor con ID " + id);
        return false;
    }
    
    /**
     * Muestra estadísticas generales de la universidad
     */
    public void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS DE " + nombre + " ===");
        System.out.println("Total de profesores: " + profesores.size());
        System.out.println("Total de cursos: " + cursos.size());
        
        // Contar cursos asignados y sin asignar
        int cursosAsignados = 0;
        int cursosSinAsignar = 0;
        
        for (Curso curso : cursos) {
            if (curso.getProfesor() != null) {
                cursosAsignados++;
            } else {
                cursosSinAsignar++;
            }
        }
        
        System.out.println("Cursos con profesor asignado: " + cursosAsignados);
        System.out.println("Cursos sin profesor: " + cursosSinAsignar);
        
        // Contar profesores con y sin cursos
        int profesoresConCursos = 0;
        int profesoresSinCursos = 0;
        
        for (Profesor profesor : profesores) {
            if (profesor.getCantidadCursos() > 0) {
                profesoresConCursos++;
            } else {
                profesoresSinCursos++;
            }
        }
        
        System.out.println("Profesores con cursos asignados: " + profesoresConCursos);
        System.out.println("Profesores sin cursos: " + profesoresSinCursos);
        System.out.println("=====================================");
    }
}