/**
 * Subclase Auto que extiende de Vehiculo
 * Demuestra herencia y sobrescritura de métodos
 */
public class Auto extends Vehiculo {
    private int cantidadPuertas;
    
    /**
     * Constructor de Auto que utiliza super() para llamar al constructor padre
     * @param marca La marca del auto
     * @param modelo El modelo del auto
     * @param cantidadPuertas La cantidad de puertas del auto
     */
    public Auto(String marca, String modelo, int cantidadPuertas) {
        super(marca, modelo); // Llamada al constructor de la clase padre
        this.cantidadPuertas = cantidadPuertas;
    }
    
    /**
     * Sobrescritura del método mostrarInfo() 
     * Utiliza @Override para indicar que está sobrescribiendo un método
     */
    @Override
    public void mostrarInfo() {
        System.out.println("Auto: " + marca + " " + modelo + " - " + cantidadPuertas + " puertas");
    }
    
    /**
     * Método específico de Auto para mostrar información detallada
     */
    public void mostrarInfoDetallada() {
        System.out.println("=== Información del Auto ===");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Cantidad de puertas: " + cantidadPuertas);
    }
    
    // Getter y Setter para cantidadPuertas
    public int getCantidadPuertas() {
        return cantidadPuertas;
    }
    
    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }
}