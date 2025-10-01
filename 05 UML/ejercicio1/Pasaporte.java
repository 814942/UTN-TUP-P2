package ejercicio1;

import java.util.Date;

// Clase Pasaporte
public class Pasaporte {
    private String numero;
    private Date fechaEmision;
    private Foto foto; // Composición: la foto es parte integral del pasaporte
    private Titular titular; // Asociación bidireccional
    
    public Pasaporte(String numero, Date fechaEmision, byte[] imagenFoto, String formatoFoto) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        // Composición: el pasaporte crea y controla la foto
        this.foto = new Foto(imagenFoto, formatoFoto);
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public Date getFechaEmision() {
        return fechaEmision;
    }
    
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
    
    public Foto getFoto() {
        return foto;
    }
    
    // Método para actualizar la foto (composición)
    public void actualizarFoto(byte[] nuevaImagen, String nuevoFormato) {
        this.foto = new Foto(nuevaImagen, nuevoFormato);
    }
    
    public Titular getTitular() {
        return titular;
    }
    
    public void setTitular(Titular titular) {
        this.titular = titular;
        // Mantener la bidireccionalidad
        if (titular != null && titular.getPasaporte() != this) {
            titular.setPasaporte(this);
        }
    }
    
    @Override
    public String toString() {
        return "Pasaporte{numero='" + numero + "', fechaEmision=" + fechaEmision + 
               ", titular=" + (titular != null ? titular.getNombre() : "Sin titular") + "}";
    }
}