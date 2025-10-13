package Practica.src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void listarProductos() {
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    public Producto buscarProductoPorId(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public boolean eliminarProducto(String id) {
        return productos.removeIf(p -> p.getId().equals(id));
    }

    public boolean actualizarStock(String id, int nuevaCantidad) {
        Producto p = buscarProductoPorId(id);
        if (p != null) {
            p.setStock(nuevaCantidad);
            return true;
        }
        return false;
    }

    public List<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria().equals(categoria))
                .collect(Collectors.toList());
    }

    public int obtenerTotalStock() {
        return productos.stream()
            .mapToInt(Producto::getStock)
            .sum();
    }

    public Producto obtenerProductoConMayorStock() {
        return productos.stream()
                .max((p1, p2) -> Integer.compare(p1.getStock(), p2.getStock()))
                .orElse(null);
    }

    public List<Producto> filtrarProductosPorPrecio(double min, double max) {
        return productos.stream()
                .filter(p -> p.getPrecio() >= min && p.getPrecio() <= max)
                .collect(Collectors.toList());
    }

    public void mostrarCategoriasDisponibles() {
        productos.stream()
                .map(Producto::getCategoria)
                .distinct()
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Inventario{\n");
        sb.append(String.format("  totalProductos=%d,\n", productos.size()));
        sb.append(String.format("  totalStock=%d,\n", obtenerTotalStock()));
        
        if (!productos.isEmpty()) {
            sb.append("  productos=[\n");
            for (int i = 0; i < productos.size(); i++) {
                sb.append("    ").append(i + 1).append(". ").append(productos.get(i).toString());
                if (i < productos.size() - 1) {
                    sb.append(",");
                }
                sb.append("\n");
            }
            sb.append("  ],\n");
            
            // Mostrar resumen por categorías
            sb.append("  resumenCategorias={\n");
            for (CategoriaProducto cat : CategoriaProducto.values()) {
                long count = productos.stream()
                    .filter(p -> p.getCategoria().equals(cat))
                    .count();
                if (count > 0) {
                    int stockCategoria = productos.stream()
                        .filter(p -> p.getCategoria().equals(cat))
                        .mapToInt(Producto::getStock)
                        .sum();
                    sb.append(String.format("    %s: %d productos, %d unidades\n", 
                        cat, count, stockCategoria));
                }
            }
            sb.append("  }\n");
        } else {
            sb.append("  productos=[VACIO]\n");
        }
        
        sb.append("}");
        return sb.toString();
    }
}
