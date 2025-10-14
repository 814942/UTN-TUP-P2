package Practica.src.Ejercicio_primero;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia del inventario
        Inventario inventario = new Inventario();
        
        // Crear al menos cinco productos con diferentes categorías
        Producto producto1 = new Producto("001", "Arroz 1kg", 2000.50, 100, CategoriaProducto.ALIMENTOS);
        Producto producto2 = new Producto("002", "Smartphone Samsung", 2999.99, 15, CategoriaProducto.ELECTRONICA);
        Producto producto3 = new Producto("003", "Camiseta Polo", 2500.00, 50, CategoriaProducto.ROPA);
        Producto producto4 = new Producto("004", "Mesa de Centro", 12000.00, 8, CategoriaProducto.HOGAR);
        Producto producto5 = new Producto("005", "Leche 1L", 1800.00, 75, CategoriaProducto.ALIMENTOS);
        Producto producto6 = new Producto("006", "Laptop Dell", 7999.99, 5, CategoriaProducto.ELECTRONICA);

        // Agregar los productos al inventario
        inventario.agregarProducto(producto1);
        inventario.agregarProducto(producto2);
        inventario.agregarProducto(producto3);
        inventario.agregarProducto(producto4);
        inventario.agregarProducto(producto5);
        inventario.agregarProducto(producto6);
        
        // Listar todos los productos mostrando su información y categoría
        System.out.println("=== INVENTARIO COMPLETO ===");
        inventario.listarProductos();

        // Buscar un producto por ID y mostrar su información
        String buscarId = "003";
        System.out.println("\n=== BUSCAR PRODUCTO POR ID: " + buscarId + " ===");
        Producto encontrado = inventario.buscarProductoPorId(buscarId);
        System.out.println(encontrado != null ? encontrado : "Producto no encontrado");
        
        // Filtrar y mostrar productos que pertenezcan a una categoría específica
        System.out.println("\n=== PRODUCTOS POR CATEGORIA: ALIMENTOS ===");
        inventario.filtrarPorCategoria(CategoriaProducto.ALIMENTOS)
                .forEach(System.out::println);
        
        System.out.println("\n=== PRODUCTOS POR CATEGORIA: ELECTRONICA ===");
        inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA)
                .forEach(System.out::println);

        // Eliminar un producto por su ID y listar los productos restantes
        String eliminarId = "002";
        System.out.println("\n=== ELIMINAR PRODUCTO POR ID: " + eliminarId + " ===");
        boolean eliminado = inventario.eliminarProducto(eliminarId);
        System.out.println(eliminado ? "Producto eliminado." : "Producto no encontrado.");
        
        System.out.println("=== INVENTARIO RESTANTE ===");
        inventario.listarProductos();

        // Actualizar el stock de un producto existente
        String actualizarId = "003";
        int nuevaCantidad = 60;
        System.out.println("\n=== ACTUALIZAR STOCK DEL PRODUCTO ID: " + actualizarId + " A " + nuevaCantidad + " ===");
        boolean actualizado = inventario.actualizarStock(actualizarId, nuevaCantidad);
        System.out.println(actualizado ? "Stock actualizado." : "Producto no encontrado.");

        // Mostrar el total de stock disponible
        System.out.println("\n=== TOTAL DE STOCK ===");
        System.out.println("Total stock: " + inventario.obtenerTotalStock() + " unidades");
        
        // Obtener y mostrar el producto con mayor stock
        System.out.println("\n=== PRODUCTO CON MAYOR STOCK ===");
        Producto mayorStock = inventario.obtenerProductoConMayorStock();
        if (mayorStock != null) {
            mayorStock.mostrarInfo();
        }

        // Filtrar productos con precios entre $1000 y $3000
        System.out.println("\n=== PRODUCTOS CON PRECIO ENTRE $1000 Y $3000 ===");
        inventario.filtrarProductosPorPrecio(1000, 3000)
                .forEach(System.out::println);
        
        
        // Mostrar las categorías disponibles con sus descripciones
        System.out.println("\n=== CATEGORIAS DISPONIBLES ===");
        inventario.mostrarCategoriasDisponibles();
    }
}