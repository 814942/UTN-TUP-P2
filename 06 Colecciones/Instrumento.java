public class Instrumento {
    private String nombre;
    private String marca;
    private double precio;
    private TipoInstrumento tipo;
    
    // Constructor
    public Instrumento(String nombre, String marca, double precio, TipoInstrumento tipo) {
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.tipo = tipo;
    }
    
    // Constructor por defecto
    public Instrumento() {
        this.nombre = "";
        this.marca = "";
        this.precio = 0.0;
        this.tipo = null;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public TipoInstrumento getTipo() {
        return tipo;
    }
    
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void setTipo(TipoInstrumento tipo) {
        this.tipo = tipo;
    }
    
    // Método toString para mostrar información del instrumento
    @Override
    public String toString() {
        return "Instrumento{" +
                "nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", precio=" + precio +
                ", tipo=" + tipo +
                '}';
    }
    
    // Método equals para comparar instrumentos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Instrumento that = (Instrumento) obj;
        
        return Double.compare(that.precio, precio) == 0 &&
                nombre.equals(that.nombre) &&
                marca.equals(that.marca) &&
                tipo == that.tipo;
    }
    
    // Método hashCode
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = nombre.hashCode();
        result = 31 * result + marca.hashCode();
        temp = Double.doubleToLongBits(precio);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + tipo.hashCode();
        return result;
    }
}