package Practica.src.Ejercicio_primero;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int stock;
    private CategoriaProducto categoria;

    // Constructor
    public Producto(String id, String nombre, double precio, int stock, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public void mostrarInfo() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad: " + stock);
        System.out.println("Categoría: " + (categoria != null ? categoria.toString() : "Sin categoría"));
    }

    public String getId() {
        return id;
    }

    public void setStock(int nuevaCantidad) {
        this.stock = nuevaCantidad;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    // Métodos adicionales para depuración
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCategoria(CategoriaProducto categoria) {
        this.categoria = categoria;
    }

    // Método para representación resumida (útil en logs)
    public String toShortString() {
        return String.format("[%s] %s ($%.2f x%d)", 
                id, nombre, precio, stock);
    }

    // Método para validar el estado del producto
    public boolean esValido() {
        return id != null && !id.trim().isEmpty() &&
               nombre != null && !nombre.trim().isEmpty() &&
               precio >= 0 &&
               stock >= 0 &&
               categoria != null;
    }

    // Método para obtener información de depuración
    public String getDebugInfo() {
        return String.format("DEBUG - Producto{id=%s, nombre=%s, precio=%.4f, stock=%d, categoria=%s, esValido=%s}", 
                id, nombre, precio, stock, categoria, esValido());
    }

    @Override
    public String toString() {
        return String.format("Producto{" +
                "id='%s', " +
                "nombre='%s', " +
                "precio=%.2f, " +
                "stock=%d, " +
                "categoria=%s, " +
                "descripcionCategoria='%s'" +
                "}", 
                id, 
                nombre, 
                precio, 
                stock, 
                categoria != null ? categoria : "SIN_CATEGORIA",
                categoria != null ? categoria.getDescripcion() : "Sin descripción");
    }

}
