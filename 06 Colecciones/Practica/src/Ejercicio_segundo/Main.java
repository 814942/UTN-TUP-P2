package Practica.src.Ejercicio_segundo;

/**
 * Clase Main para demostrar el funcionamiento del sistema de biblioteca
 * Demuestra la composición 1 a N entre Biblioteca y Libro
 * y el uso de colecciones dinámicas (ArrayList)
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===\n");
        
        // 1. Crear una biblioteca
        System.out.println("1. CREANDO LA BIBLIOTECA");
        System.out.println("========================");
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central UTN");
        System.out.println("Biblioteca creada: " + biblioteca.getNombre());
        System.out.println();
        
        // 2. Crear al menos tres autores
        System.out.println("2. CREANDO AUTORES");
        System.out.println("==================");
        Autor autor1 = new Autor("A001", "Gabriel García Márquez", "Colombiano");
        Autor autor2 = new Autor("A002", "Isabel Allende", "Chilena");
        Autor autor3 = new Autor("A003", "Jorge Luis Borges", "Argentino");
        Autor autor4 = new Autor("A004", "Mario Vargas Llosa", "Peruano");
        
        System.out.println("Autores creados:");
        autor1.mostrarInfo();
        autor2.mostrarInfo();
        autor3.mostrarInfo();
        autor4.mostrarInfo();
        System.out.println();
        
        // 3. Agregar 5 libros asociados a alguno de los autores
        System.out.println("3. AGREGANDO LIBROS A LA BIBLIOTECA");
        System.out.println("===================================");
        biblioteca.agregarLibro("978-84-376-0494-7", "Cien años de soledad", 1967, autor1);
        biblioteca.agregarLibro("978-84-204-8207-5", "El amor en los tiempos del cólera", 1985, autor1);
        biblioteca.agregarLibro("978-84-204-5246-7", "La casa de los espíritus", 1982, autor2);
        biblioteca.agregarLibro("978-84-376-0841-9", "El Aleph", 1949, autor3);
        biblioteca.agregarLibro("978-84-204-6597-9", "La ciudad y los perros", 1963, autor4);
        System.out.println();
        
        // 4. Listar todos los libros con su información y la del autor
        System.out.println("4. LISTANDO TODOS LOS LIBROS");
        System.out.println("============================");
        biblioteca.listarLibros();
        
        // 5. Buscar un libro por su ISBN y mostrar su información
        System.out.println("5. BUSCANDO LIBRO POR ISBN");
        System.out.println("==========================");
        String isbnBuscar = "978-84-376-0494-7";
        System.out.println("Buscando libro con ISBN: " + isbnBuscar);
        biblioteca.buscarLibroPorIsbn(isbnBuscar);
        System.out.println();
        
        // También buscar un ISBN que no existe
        System.out.println("Probando búsqueda con ISBN inexistente:");
        biblioteca.buscarLibroPorIsbn("978-00-000-0000-0");
        System.out.println();
        
        // 6. Filtrar y mostrar los libros publicados en un año específico
        System.out.println("6. FILTRANDO LIBROS POR AÑO DE PUBLICACIÓN");
        System.out.println("==========================================");
        int anioFiltrar = 1967;
        System.out.println("Filtrando libros del año: " + anioFiltrar);
        biblioteca.filtrarLibrosPorAnio(anioFiltrar);
        
        // Filtrar por otro año
        System.out.println("Filtrando libros del año: 1980");
        biblioteca.filtrarLibrosPorAnio(1980);
        
        // 7. Mostrar la cantidad total de libros antes de eliminar
        System.out.println("7. CANTIDAD DE LIBROS ANTES DE ELIMINAR");
        System.out.println("=======================================");
        biblioteca.obtenerCantidadLibros();
        System.out.println();
        
        // 8. Eliminar un libro por su ISBN y listar los libros restantes
        System.out.println("8. ELIMINANDO UN LIBRO");
        System.out.println("======================");
        String isbnEliminar = "978-84-204-8207-5";
        System.out.println("Eliminando libro con ISBN: " + isbnEliminar);
        biblioteca.eliminarLibro(isbnEliminar);
        System.out.println();
        
        System.out.println("Listando libros después de la eliminación:");
        biblioteca.listarLibros();
        
        // 9. Mostrar la cantidad total de libros después de eliminar
        System.out.println("9. CANTIDAD DE LIBROS DESPUÉS DE ELIMINAR");
        System.out.println("=========================================");
        biblioteca.obtenerCantidadLibros();
        System.out.println();
        
        // 10. Listar todos los autores de los libros disponibles
        System.out.println("10. MOSTRANDO AUTORES DISPONIBLES");
        System.out.println("=================================");
        biblioteca.mostrarAutoresDisponibles();
        
        // Demostración adicional: Intentar agregar un libro con ISBN duplicado
        System.out.println("DEMOSTRACIÓN ADICIONAL: VALIDACIÓN DE ISBN DUPLICADO");
        System.out.println("====================================================");
        System.out.println("Intentando agregar un libro con ISBN ya existente:");
        biblioteca.agregarLibro("978-84-376-0494-7", "Libro Duplicado", 2023, autor1);
        System.out.println();
        
        // Conclusiones
        mostrarConclusiones();
    }
    
    /**
     * Método para mostrar las conclusiones del ejercicio
     */
    private static void mostrarConclusiones() {
        System.out.println("=== CONCLUSIONES DEL EJERCICIO ===");
        System.out.println("===================================");
        System.out.println();
        
        System.out.println("✓ COMPOSICIÓN 1 a N ENTRE BIBLIOTECA Y LIBRO:");
        System.out.println("  - Una biblioteca puede contener múltiples libros");
        System.out.println("  - Cada libro pertenece a una biblioteca específica");
        System.out.println("  - La relación se gestiona mediante ArrayList<Libro>");
        System.out.println();
        
        System.out.println("✓ MANEJO DE COLECCIONES DINÁMICAS (ARRAYLIST):");
        System.out.println("  - Uso de ArrayList para almacenar libros de forma dinámica");
        System.out.println("  - Operaciones de agregar, eliminar y buscar elementos");
        System.out.println("  - Iteración sobre colecciones con bucles for-each y tradicionales");
        System.out.println();
        
        System.out.println("✓ MÉTODOS DE BÚSQUEDA, FILTRADO Y ELIMINACIÓN:");
        System.out.println("  - Búsqueda por ISBN con validación de existencia");
        System.out.println("  - Filtrado por año de publicación con creación de nuevas listas");
        System.out.println("  - Eliminación segura con verificación previa");
        System.out.println();
        
        System.out.println("✓ PROGRAMACIÓN ORIENTADA A OBJETOS:");
        System.out.println("  - Encapsulación: atributos privados con getters/setters");
        System.out.println("  - Composición: Libro contiene Autor, Biblioteca contiene Libros");
        System.out.println("  - Modularidad: cada clase tiene responsabilidades específicas");
        System.out.println("  - Reutilización: métodos especializados para diferentes operaciones");
        System.out.println();
        
        System.out.println("=== EJERCICIO COMPLETADO EXITOSAMENTE ===");
    }
}