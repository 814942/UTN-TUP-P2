package Practica.src.Ejercicio_tercero;

/**
 * Clase Main para demostrar el sistema de gestión Universidad-Profesor-Curso
 * Demuestra relaciones bidireccionales y sincronización automática
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN UNIVERSITARIA ===");
        System.out.println("Demostración de relaciones bidireccionales\n");
        
        // 1. Crear una universidad
        System.out.println("1. CREANDO LA UNIVERSIDAD");
        System.out.println("=========================");
        Universidad universidad = new Universidad("Universidad Tecnológica Nacional - UTN");
        System.out.println("Universidad creada: " + universidad.getNombre());
        System.out.println();
        
        // 2. Crear al menos 3 profesores
        System.out.println("2. CREANDO PROFESORES");
        System.out.println("=====================");
        Profesor prof1 = new Profesor("P001", "Dr. Ana García", "Matemáticas");
        Profesor prof2 = new Profesor("P002", "Mg. Carlos López", "Programación");
        Profesor prof3 = new Profesor("P003", "Dr. María Rodríguez", "Física");
        Profesor prof4 = new Profesor("P004", "Ing. Juan Pérez", "Electrónica");
        
        System.out.println("Profesores creados:");
        prof1.mostrarInfo();
        prof2.mostrarInfo();
        prof3.mostrarInfo();
        prof4.mostrarInfo();
        
        // 3. Crear 5 cursos
        System.out.println("3. CREANDO CURSOS");
        System.out.println("=================");
        Curso curso1 = new Curso("MAT101", "Matemática I");
        Curso curso2 = new Curso("PROG201", "Programación Orientada a Objetos");
        Curso curso3 = new Curso("FIS102", "Física General");
        Curso curso4 = new Curso("MAT201", "Álgebra Lineal");
        Curso curso5 = new Curso("ELEC301", "Circuitos Electrónicos");
        
        System.out.println("Cursos creados:");
        curso1.mostrarInfo();
        curso2.mostrarInfo();
        curso3.mostrarInfo();
        curso4.mostrarInfo();
        curso5.mostrarInfo();
        
        // 4. Agregar profesores y cursos a la universidad
        System.out.println("4. AGREGANDO PROFESORES Y CURSOS A LA UNIVERSIDAD");
        System.out.println("=================================================");
        
        // Agregar profesores
        universidad.agregarProfesor(prof1);
        universidad.agregarProfesor(prof2);
        universidad.agregarProfesor(prof3);
        universidad.agregarProfesor(prof4);
        
        // Agregar cursos
        universidad.agregarCurso(curso1);
        universidad.agregarCurso(curso2);
        universidad.agregarCurso(curso3);
        universidad.agregarCurso(curso4);
        universidad.agregarCurso(curso5);
        
        System.out.println();
        universidad.mostrarEstadisticas();
        
        // 5. Asignar profesores a cursos usando asignarProfesorACurso
        System.out.println("\n5. ASIGNANDO PROFESORES A CURSOS");
        System.out.println("================================");
        universidad.asignarProfesorACurso("MAT101", "P001");    // Ana García -> Matemática I
        universidad.asignarProfesorACurso("MAT201", "P001");    // Ana García -> Álgebra Lineal
        universidad.asignarProfesorACurso("PROG201", "P002");   // Carlos López -> POO
        universidad.asignarProfesorACurso("FIS102", "P003");    // María Rodríguez -> Física
        universidad.asignarProfesorACurso("ELEC301", "P004");   // Juan Pérez -> Electrónica
        
        System.out.println("\nEstado después de asignaciones:");
        universidad.mostrarEstadisticas();
        
        // 6. Listar cursos con su profesor y profesores con sus cursos
        System.out.println("\n6. LISTADOS COMPLETOS");
        System.out.println("======================");
        universidad.listarCursos();
        universidad.listarProfesores();
        
        // Mostrar detalles de cada profesor con sus cursos
        System.out.println("DETALLES DE PROFESORES Y SUS CURSOS:");
        System.out.println("====================================");
        for (Profesor profesor : universidad.getProfesores()) {
            profesor.listarCursos();
        }
        
        // 7. Cambiar el profesor de un curso y verificar sincronización
        System.out.println("7. CAMBIANDO PROFESOR DE UN CURSO");
        System.out.println("==================================");
        System.out.println("ANTES del cambio:");
        prof1.listarCursos();  // Ana tiene MAT101 y MAT201
        prof3.listarCursos();  // María tiene FIS102
        
        System.out.println("Cambiando profesor de MAT101 de Ana García a María Rodríguez...");
        universidad.asignarProfesorACurso("MAT101", "P003");
        
        System.out.println("\nDESPUÉS del cambio:");
        prof1.listarCursos();  // Ana ahora solo tiene MAT201
        prof3.listarCursos();  // María ahora tiene FIS102 y MAT101
        
        // Verificar desde el lado del curso también
        System.out.println("Verificación desde el curso MAT101:");
        curso1.mostrarInfo();
        
        // 8. Remover un curso y confirmar sincronización
        System.out.println("\n8. REMOVIENDO UN CURSO");
        System.out.println("======================");
        System.out.println("ANTES de eliminar curso ELEC301:");
        prof4.listarCursos();  // Juan tiene ELEC301
        
        universidad.eliminarCurso("ELEC301");
        
        System.out.println("\nDESPUÉS de eliminar curso ELEC301:");
        prof4.listarCursos();  // Juan ya no tiene cursos
        
        universidad.listarCursos();  // El curso ya no aparece en la universidad
        
        // 9. Remover un profesor y dejar cursos con profesor = null
        System.out.println("9. REMOVIENDO UN PROFESOR");
        System.out.println("=========================");
        System.out.println("ANTES de eliminar profesor María Rodríguez (P003):");
        prof3.listarCursos();  // María tiene FIS102 y MAT101
        curso1.mostrarInfo();  // MAT101 tiene a María como profesor
        curso3.mostrarInfo();  // FIS102 tiene a María como profesor
        
        universidad.eliminarProfesor("P003");
        
        System.out.println("\nDESPUÉS de eliminar profesor María Rodríguez:");
        System.out.println("Verificando que los cursos quedaron sin profesor:");
        curso1.mostrarInfo();  // MAT101 ahora sin profesor
        curso3.mostrarInfo();  // FIS102 ahora sin profesor
        
        universidad.listarCursos();  // Los cursos aparecen sin profesor
        
        // 10. Mostrar reporte: cantidad de cursos por profesor
        System.out.println("10. REPORTE FINAL - CANTIDAD DE CURSOS POR PROFESOR");
        System.out.println("===================================================");
        mostrarReporteCursosPorProfesor(universidad);
        
        // Estado final del sistema
        System.out.println("\nESTADO FINAL DEL SISTEMA:");
        universidad.mostrarEstadisticas();
        
        // Demostración adicional: Intentar operaciones con elementos inexistentes
        System.out.println("\nDEMOSTRACIÓN ADICIONAL - MANEJO DE ERRORES:");
        System.out.println("===========================================");
        
        // Intentar asignar profesor inexistente
        universidad.asignarProfesorACurso("MAT101", "P999");
        
        // Intentar asignar a curso inexistente
        universidad.asignarProfesorACurso("CURSO999", "P001");
        
        // Intentar eliminar elementos inexistentes
        universidad.eliminarCurso("CURSO999");
        universidad.eliminarProfesor("P999");
        
        // Mostrar conclusiones del ejercicio
        mostrarConclusiones();
    }
    
    /**
     * Genera un reporte detallado de la cantidad de cursos por profesor
     */
    private static void mostrarReporteCursosPorProfesor(Universidad universidad) {
        System.out.println("\n📊 REPORTE DE DISTRIBUCIÓN DE CURSOS");
        System.out.println("====================================");
        
        if (universidad.getProfesores().isEmpty()) {
            System.out.println("No hay profesores en la universidad.");
            return;
        }
        
        int totalCursos = 0;
        int profesoresConCursos = 0;
        
        for (Profesor profesor : universidad.getProfesores()) {
            int cantidadCursos = profesor.getCantidadCursos();
            totalCursos += cantidadCursos;
            
            if (cantidadCursos > 0) {
                profesoresConCursos++;
            }
            
            System.out.println("👤 " + profesor.getNombre() + " (ID: " + profesor.getId() + ")");
            System.out.println("   Especialidad: " + profesor.getEspecialidad());
            System.out.println("   Cantidad de cursos: " + cantidadCursos);
            
            if (cantidadCursos > 0) {
                System.out.print("   Cursos: ");
                for (int i = 0; i < profesor.getCursos().size(); i++) {
                    Curso curso = profesor.getCursos().get(i);
                    System.out.print(curso.getCodigo() + " (" + curso.getNombre() + ")");
                    if (i < profesor.getCursos().size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
        
        // Estadísticas del reporte
        double promedioCursos = universidad.getProfesores().size() > 0 ? 
                               (double) totalCursos / universidad.getProfesores().size() : 0;
        
        System.out.println("📈 ESTADÍSTICAS DEL REPORTE:");
        System.out.println("- Total de profesores: " + universidad.getProfesores().size());
        System.out.println("- Profesores con cursos asignados: " + profesoresConCursos);
        System.out.println("- Profesores sin cursos: " + (universidad.getProfesores().size() - profesoresConCursos));
        System.out.println("- Total de asignaciones: " + totalCursos);
        System.out.printf("- Promedio de cursos por profesor: %.2f%n", promedioCursos);
    }
    
    /**
     * Muestra las conclusiones del ejercicio
     */
    private static void mostrarConclusiones() {
        System.out.println("\n=== CONCLUSIONES DEL EJERCICIO ===");
        System.out.println("===================================");
        System.out.println();
        
        System.out.println("✓ BIDIRECCIONALIDAD vs UNIDIRECCIONALIDAD:");
        System.out.println("  🔄 BIDIRECCIONAL: Navegación desde ambos extremos");
        System.out.println("     - Profesor → Lista de Cursos");
        System.out.println("     - Curso → Referencia al Profesor");
        System.out.println("     - Sincronización automática en ambas direcciones");
        System.out.println();
        
        System.out.println("  ➡️  UNIDIRECCIONAL: Navegación desde un solo extremo");
        System.out.println("     - Solo una clase conoce a la otra");
        System.out.println("     - Sin sincronización automática");
        System.out.println();
        
        System.out.println("✓ INVARIANTES DE ASOCIACIÓN:");
        System.out.println("  - Coherencia de referencias mantenida automáticamente");
        System.out.println("  - Al asignar: curso.profesor ↔ profesor.cursos sincronizados");
        System.out.println("  - Al eliminar: relaciones rotas en ambos lados");
        System.out.println("  - Al reasignar: cambios propagados correctamente");
        System.out.println();
        
        System.out.println("✓ COLECCIONES Y OPERACIONES:");
        System.out.println("  - ArrayList para gestión dinámica de elementos");
        System.out.println("  - Búsquedas eficientes por identificadores únicos");
        System.out.println("  - Operaciones CRUD (Create, Read, Update, Delete)");
        System.out.println("  - Prevención de ConcurrentModificationException");
        System.out.println();
        
        System.out.println("✓ MÉTODOS \"SEGUROS\" DE SINCRONIZACIÓN:");
        System.out.println("  - setProfesor(Profesor): Sincroniza automáticamente ambos lados");
        System.out.println("  - agregarCurso(Curso): Evita duplicados y sincroniza");
        System.out.println("  - eliminarCurso/Profesor: Rompe relaciones correctamente");
        System.out.println("  - Validaciones robustas en todos los métodos");
        System.out.println();
        
        System.out.println("✓ PATRONES DE DISEÑO APLICADOS:");
        System.out.println("  - Encapsulación: Atributos privados con métodos públicos");
        System.out.println("  - Composición: Universidad contiene Profesores y Cursos");
        System.out.println("  - Agregación: Profesor trabaja con Cursos");
        System.out.println("  - Responsabilidad única: Cada clase tiene un propósito específico");
        System.out.println();
        
        System.out.println("🎯 BENEFICIOS OBTENIDOS:");
        System.out.println("  ✅ Integridad de datos garantizada");
        System.out.println("  ✅ Navegación natural desde cualquier extremo");
        System.out.println("  ✅ Operaciones seguras sin efectos colaterales");
        System.out.println("  ✅ Código mantenible y extensible");
        System.out.println("  ✅ Detección temprana de inconsistencias");
        System.out.println();
        
        System.out.println("=== EJERCICIO COMPLETADO EXITOSAMENTE ===");
        System.out.println("Sistema de relaciones bidireccionales implementado correctamente");
    }
}