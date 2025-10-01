package ejercicio2;

// Clase Celular
public class Celular {
    private String imei;
    private String marca;
    private String modelo;
    private Bateria bateria; // Agregación: la batería puede existir independientemente
    private Usuario usuario; // Asociación bidireccional
    
    public Celular(String imei, String marca, String modelo) {
        this.imei = imei;
        this.marca = marca;
        this.modelo = modelo;
    }
    
    // Constructor sobrecargado que acepta una batería existente
    public Celular(String imei, String marca, String modelo, Bateria bateria) {
        this.imei = imei;
        this.marca = marca;
        this.modelo = modelo;
        this.bateria = bateria; // Agregación: recibe batería desde fuera
    }
    
    public String getImei() {
        return imei;
    }
    
    public void setImei(String imei) {
        this.imei = imei;
    }
    
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
    
    public Bateria getBateria() {
        return bateria;
    }
    
    // Agregación: permite instalar/reemplazar batería existente
    public void instalarBateria(Bateria bateria) {
        this.bateria = bateria;
    }
    
    // Agregación: permite remover la batería (sigue existiendo)
    public Bateria removerBateria() {
        Bateria bateriaRemovida = this.bateria;
        this.bateria = null;
        return bateriaRemovida;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        // Mantener la bidireccionalidad
        if (usuario != null && usuario.getCelular() != this) {
            usuario.setCelular(this);
        }
    }
    
    @Override
    public String toString() {
        return "Celular{imei='" + imei + "', marca='" + marca + "', modelo='" + modelo + 
               "', usuario=" + (usuario != null ? usuario.getNombre() : "Sin usuario") + "}";
    }
}