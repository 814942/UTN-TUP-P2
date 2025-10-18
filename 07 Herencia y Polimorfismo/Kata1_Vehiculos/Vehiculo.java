/**
 * Clase base Vehiculo que representa un vehículo genérico
 * Demuestra conceptos básicos de herencia
 */
public class Vehiculo {
    protected String marca;
    protected String modelo;
    
    /**
     * Constructor de la clase Vehiculo
     * @param marca La marca del vehículo
     * @param modelo El modelo del vehículo
     */
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
    /**
     * Método para mostrar la información básica del vehículo
     * Este método puede ser sobrescrito por las subclases
     */
    public void mostrarInfo() {
        System.out.println("Vehículo: " + marca + " " + modelo);
    }
    
    // Getters y Setters
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}