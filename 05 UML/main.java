// ----- Relaciones 1 a 1 -----
// Ejercicio 1 - Pasaporte - Foto - Titular
// Clase Foto
public class Foto {
    private byte[] imagen;
    private String formato;

    public Foto(byte[] imagen, String formato) {
        this.imagen = imagen;
        this.formato = formato;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "Foto{formato='" + formato + "', tamaño=" + 
               (imagen != null ? imagen.length : 0) + " bytes}";
    }
}

// Clase Titular
public class Titular {
    private String nombre;
    private String dni;
    private Pasaporte pasaporte; // Asociación bidireccional
    
    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public Pasaporte getPasaporte() {
        return pasaporte;
    }
    
    public void setPasaporte(Pasaporte pasaporte) {
        this.pasaporte = pasaporte;
    }
    
    @Override
    public String toString() {
        return "Titular{nombre='" + nombre + "', dni='" + dni + "'}";
    }
}

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

// Clase de prueba
import java.util.Date;

public class TestPasaporte {
    public static void main(String[] args) {
        // Crear titular
        Titular titular = new Titular("Juan Pérez", "12345678");
        
        // Crear pasaporte con foto (composición)
        byte[] imagenFoto = new byte[]{1, 2, 3, 4, 5}; // Simulación de imagen
        Pasaporte pasaporte = new Pasaporte("ARG123456", new Date(), imagenFoto, "JPEG");
        
        // Establecer la relación bidireccional
        pasaporte.setTitular(titular);
        
        // Mostrar información
        System.out.println(pasaporte);
        System.out.println(titular);
        System.out.println("Foto del pasaporte: " + pasaporte.getFoto());
        
        // Verificar bidireccionalidad
        System.out.println("Pasaporte del titular: " + titular.getPasaporte());
    }
}

// Ejercicio 2 - Celular - Batería - Usuario

// Clase Bateria
public class Bateria {
    private String modelo;
    private int capacidad; // en mAh
    
    public Bateria(String modelo, int capacidad) {
        this.modelo = modelo;
        this.capacidad = capacidad;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    @Override
    public String toString() {
        return "Bateria{modelo='" + modelo + "', capacidad=" + capacidad + " mAh}";
    }
}

// Clase Usuario
public class Usuario {
    private String nombre;
    private String dni;
    private Celular celular; // Asociación bidireccional
    
    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public Celular getCelular() {
        return celular;
    }
    
    public void setCelular(Celular celular) {
        this.celular = celular;
    }
    
    @Override
    public String toString() {
        return "Usuario{nombre='" + nombre + "', dni='" + dni + "'}";
    }
}

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

// Clase de prueba
public class TestCelular {
    public static void main(String[] args) {
        // Crear batería independiente (agregación)
        Bateria bateria1 = new Bateria("BT-5000", 5000);
        System.out.println("Batería creada: " + bateria1);
        
        // Crear celular sin batería
        Celular celular = new Celular("123456789012345", "Samsung", "Galaxy S21");
        
        // Instalar batería en el celular (agregación)
        celular.instalarBateria(bateria1);
        System.out.println("\nCelular con batería: " + celular);
        System.out.println("Batería instalada: " + celular.getBateria());
        
        // Crear usuario
        Usuario usuario = new Usuario("María González", "87654321");
        
        // Establecer relación bidireccional
        celular.setUsuario(usuario);
        
        System.out.println("\n" + celular);
        System.out.println(usuario);
        System.out.println("Celular del usuario: " + usuario.getCelular().getMarca() + " " + 
                           usuario.getCelular().getModelo());
        
        // Demostrar agregación: remover y reutilizar batería
        System.out.println("\n--- Demostrando Agregación ---");
        Bateria bateriaRemovida = celular.removerBateria();
        System.out.println("Batería removida: " + bateriaRemovida);
        System.out.println("Celular sin batería: " + (celular.getBateria() == null ? "Sin batería" : "Con batería"));
        
        // La batería sigue existiendo y puede usarse en otro celular
        Celular otroCelular = new Celular("999888777666555", "Motorola", "Moto G");
        otroCelular.instalarBateria(bateriaRemovida);
        System.out.println("Batería instalada en otro celular: " + otroCelular.getBateria());
    }
}

// Ejercicio 3 - Libro - Autor - Editorial
// Clase Autor
public class Autor {
    private String nombre;
    private String nacionalidad;
    
    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNacionalidad() {
        return nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
    @Override
    public String toString() {
        return "Autor{nombre='" + nombre + "', nacionalidad='" + nacionalidad + "'}";
    }
}

// Clase Libro
public class Libro {
    private String titulo;
    private String isbn;
    private Autor autor; // Asociación unidireccional: Libro conoce a Autor
    
    public Libro(String titulo, String isbn, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public Autor getAutor() {
        return autor;
    }
    
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    @Override
    public String toString() {
        return "Libro{titulo='" + titulo + "', isbn='" + isbn + 
               "', autor=" + (autor != null ? autor.getNombre() : "Sin autor") + "}";
    }
}

// Clase Editorial
import java.util.ArrayList;
import java.util.List;

public class Editorial {
    private String nombre;
    private String direccion;
    private List<Libro> librosPublicados; // Agregación: Editorial contiene libros
    
    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.librosPublicados = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public List<Libro> getLibrosPublicados() {
        return librosPublicados;
    }
    
    // Agregación: agregar libro existente al catálogo
    public void publicarLibro(Libro libro) {
        if (libro != null && !librosPublicados.contains(libro)) {
            librosPublicados.add(libro);
        }
    }
    
    // Agregación: remover libro del catálogo (el libro sigue existiendo)
    public boolean retirarLibro(Libro libro) {
        return librosPublicados.remove(libro);
    }
    
    public void mostrarCatalogo() {
        System.out.println("\nCatálogo de " + nombre + ":");
        if (librosPublicados.isEmpty()) {
            System.out.println("  No hay libros publicados");
        } else {
            for (Libro libro : librosPublicados) {
                System.out.println("  - " + libro.getTitulo() + " por " + 
                                   libro.getAutor().getNombre());
            }
        }
    }
    
    @Override
    public String toString() {
        return "Editorial{nombre='" + nombre + "', direccion='" + direccion + 
               "', libros publicados=" + librosPublicados.size() + "}";
    }
}

// Clase de prueba
public class TestLibro {
    public static void main(String[] args) {
        // Crear autores independientes
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("Jorge Luis Borges", "Argentina");
        Autor autor3 = new Autor("Isabel Allende", "Chilena");
        
        System.out.println("Autores creados:");
        System.out.println(autor1);
        System.out.println(autor2);
        System.out.println(autor3);
        
        // Crear libros (asociación unidireccional con autor)
        Libro libro1 = new Libro("Cien años de soledad", "978-0307474728", autor1);
        Libro libro2 = new Libro("El Aleph", "978-8420633114", autor2);
        Libro libro3 = new Libro("La casa de los espíritus", "978-1501117015", autor3);
        Libro libro4 = new Libro("Ficciones", "978-0802130303", autor2);
        
        System.out.println("\nLibros creados:");
        System.out.println(libro1);
        System.out.println(libro2);
        System.out.println(libro3);
        System.out.println(libro4);
        
        // Crear editoriales
        Editorial editorial1 = new Editorial("Editorial Sudamericana", "Buenos Aires, Argentina");
        Editorial editorial2 = new Editorial("Penguin Random House", "Barcelona, España");
        
        System.out.println("\nEditoriales:");
        System.out.println(editorial1);
        System.out.println(editorial2);
        
        // Agregación: publicar libros en editoriales
        editorial1.publicarLibro(libro1);
        editorial1.publicarLibro(libro2);
        
        editorial2.publicarLibro(libro3);
        editorial2.publicarLibro(libro4);
        
        editorial1.mostrarCatalogo();
        editorial2.mostrarCatalogo();
        
        // Demostrar agregación: transferir libro entre editoriales
        System.out.println("\n--- Demostrando Agregación ---");
        System.out.println("Retirando '" + libro2.getTitulo() + "' de " + editorial1.getNombre());
        editorial1.retirarLibro(libro2);
        
        System.out.println("El libro sigue existiendo: " + libro2);
        
        System.out.println("\nPublicando '" + libro2.getTitulo() + "' en " + editorial2.getNombre());
        editorial2.publicarLibro(libro2);
        
        editorial1.mostrarCatalogo();
        editorial2.mostrarCatalogo();
        
        // Demostrar asociación unidireccional
        System.out.println("\n--- Asociación Unidireccional ---");
        System.out.println("El libro '" + libro1.getTitulo() + "' conoce a su autor: " + 
                           libro1.getAutor().getNombre());
        System.out.println("El autor no mantiene referencia directa a sus libros en este modelo");
    }
}

// Ejercicio 4 - TarjetaDeCrédito - Cliente - Banco
// Clase Cliente
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String dni;
    private List<TarjetaDeCredito> tarjetas; // Asociación bidireccional
    
    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.tarjetas = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public List<TarjetaDeCredito> getTarjetas() {
        return tarjetas;
    }
    
    // Método para agregar tarjeta (mantiene bidireccionalidad)
    public void agregarTarjeta(TarjetaDeCredito tarjeta) {
        if (tarjeta != null && !tarjetas.contains(tarjeta)) {
            tarjetas.add(tarjeta);
            if (tarjeta.getCliente() != this) {
                tarjeta.setCliente(this);
            }
        }
    }
    
    // Método para remover tarjeta
    public void removerTarjeta(TarjetaDeCredito tarjeta) {
        if (tarjetas.remove(tarjeta)) {
            if (tarjeta.getCliente() == this) {
                tarjeta.setCliente(null);
            }
        }
    }
    
    public void mostrarTarjetas() {
        System.out.println("\nTarjetas de " + nombre + ":");
        if (tarjetas.isEmpty()) {
            System.out.println("  No tiene tarjetas");
        } else {
            for (TarjetaDeCredito tarjeta : tarjetas) {
                System.out.println("  - " + tarjeta.getNumero() + " (vence: " + 
                                   tarjeta.getFechaVencimiento() + ")");
            }
        }
    }
    
    @Override
    public String toString() {
        return "Cliente{nombre='" + nombre + "', dni='" + dni + 
               "', tarjetas=" + tarjetas.size() + "}";
    }
}

// Clase TarjetaDeCredito
import java.util.Date;

public class TarjetaDeCredito {
    private String numero;
    private Date fechaVencimiento;
    private Cliente cliente; // Asociación bidireccional
    
    public TarjetaDeCredito(String numero, Date fechaVencimiento) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }
    
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        // Remover de cliente anterior si existe
        if (this.cliente != null && this.cliente != cliente) {
            this.cliente.getTarjetas().remove(this);
        }
        
        this.cliente = cliente;
        
        // Agregar al nuevo cliente (mantener bidireccionalidad)
        if (cliente != null && !cliente.getTarjetas().contains(this)) {
            cliente.agregarTarjeta(this);
        }
    }
    
    @Override
    public String toString() {
        return "TarjetaDeCredito{numero='" + numero + "', fechaVencimiento=" + 
               fechaVencimiento + ", cliente=" + 
               (cliente != null ? cliente.getNombre() : "Sin cliente") + "}";
    }
}

// Clase Banco
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre;
    private String cuit;
    private List<TarjetaDeCredito> tarjetasEmitidas; // Agregación
    
    public Banco(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.tarjetasEmitidas = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCuit() {
        return cuit;
    }
    
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    
    public List<TarjetaDeCredito> getTarjetasEmitidas() {
        return tarjetasEmitidas;
    }
    
    // Agregación: emitir una tarjeta existente
    public void emitirTarjeta(TarjetaDeCredito tarjeta) {
        if (tarjeta != null && !tarjetasEmitidas.contains(tarjeta)) {
            tarjetasEmitidas.add(tarjeta);
        }
    }
    
    // Agregación: cancelar tarjeta (la tarjeta sigue existiendo)
    public boolean cancelarTarjeta(TarjetaDeCredito tarjeta) {
        return tarjetasEmitidas.remove(tarjeta);
    }
    
    public void mostrarTarjetasEmitidas() {
        System.out.println("\nTarjetas emitidas por " + nombre + ":");
        if (tarjetasEmitidas.isEmpty()) {
            System.out.println("  No hay tarjetas emitidas");
        } else {
            for (TarjetaDeCredito tarjeta : tarjetasEmitidas) {
                System.out.println("  - " + tarjeta.getNumero() + " (Cliente: " + 
                                   (tarjeta.getCliente() != null ? 
                                    tarjeta.getCliente().getNombre() : "Sin asignar") + ")");
            }
        }
    }
    
    @Override
    public String toString() {
        return "Banco{nombre='" + nombre + "', cuit='" + cuit + 
               "', tarjetas emitidas=" + tarjetasEmitidas.size() + "}";
    }
}

// Clase de prueba
import java.util.Date;
import java.util.Calendar;

public class TestTarjetaDeCredito {
    public static void main(String[] args) {
        // Crear clientes
        Cliente cliente1 = new Cliente("Ana Martínez", "30123456");
        Cliente cliente2 = new Cliente("Pedro Gómez", "27987654");
        
        System.out.println("Clientes creados:");
        System.out.println(cliente1);
        System.out.println(cliente2);
        
        // Crear fechas de vencimiento
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 3);
        Date vencimiento1 = cal.getTime();
        
        cal.add(Calendar.YEAR, 1);
        Date vencimiento2 = cal.getTime();
        
        // Crear tarjetas independientes
        TarjetaDeCredito tarjeta1 = new TarjetaDeCredito("4532-1111-2222-3333", vencimiento1);
        TarjetaDeCredito tarjeta2 = new TarjetaDeCredito("5555-6666-7777-8888", vencimiento1);
        TarjetaDeCredito tarjeta3 = new TarjetaDeCredito("3782-1234-5678-9012", vencimiento2);
        
        System.out.println("\nTarjetas creadas:");
        System.out.println(tarjeta1);
        System.out.println(tarjeta2);
        System.out.println(tarjeta3);
        
        // Establecer relación bidireccional con clientes
        tarjeta1.setCliente(cliente1);
        tarjeta2.setCliente(cliente1);
        tarjeta3.setCliente(cliente2);
        
        cliente1.mostrarTarjetas();
        cliente2.mostrarTarjetas();
        
        // Crear bancos
        Banco banco1 = new Banco("Banco Nación", "30-12345678-9");
        Banco banco2 = new Banco("Banco Galicia", "30-98765432-1");
        
        System.out.println("\n" + banco1);
        System.out.println(banco2);
        
        // Agregación: emitir tarjetas
        banco1.emitirTarjeta(tarjeta1);
        banco1.emitirTarjeta(tarjeta2);
        banco2.emitirTarjeta(tarjeta3);
        
        banco1.mostrarTarjetasEmitidas();
        banco2.mostrarTarjetasEmitidas();
        
        // Demostrar agregación: cancelar y transferir tarjeta
        System.out.println("\n--- Demostrando Agregación ---");
        System.out.println("Cancelando tarjeta " + tarjeta2.getNumero() + " en " + banco1.getNombre());
        banco1.cancelarTarjeta(tarjeta2);
        
        System.out.println("La tarjeta sigue existiendo: " + tarjeta2);
        System.out.println("Y sigue vinculada a su cliente: " + tarjeta2.getCliente().getNombre());
        
        System.out.println("\nTransfiriendo la tarjeta a " + banco2.getNombre());
        banco2.emitirTarjeta(tarjeta2);
        
        banco1.mostrarTarjetasEmitidas();
        banco2.mostrarTarjetasEmitidas();
        
        // Demostrar asociación bidireccional
        System.out.println("\n--- Asociación Bidireccional ---");
        System.out.println("Transferir tarjeta de un cliente a otro");
        System.out.println("Antes:");
        cliente1.mostrarTarjetas();
        cliente2.mostrarTarjetas();
        
        tarjeta1.setCliente(cliente2);
        
        System.out.println("\nDespués de transferir tarjeta " + tarjeta1.getNumero() + 
                           " a " + cliente2.getNombre() + ":");
        cliente1.mostrarTarjetas();
        cliente2.mostrarTarjetas();
    }
}

// Ejercicio 5 - Computadora - PlacaMadre - Propietario
// Clase PlacaMadre
public class PlacaMadre {
    private String modelo;
    private String chipset;
    
    public PlacaMadre(String modelo, String chipset) {
        this.modelo = modelo;
        this.chipset = chipset;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getChipset() {
        return chipset;
    }
    
    public void setChipset(String chipset) {
        this.chipset = chipset;
    }
    
    @Override
    public String toString() {
        return "PlacaMadre{modelo='" + modelo + "', chipset='" + chipset + "'}";
    }
}

// Clase Propietario
import java.util.ArrayList;
import java.util.List;

public class Propietario {
    private String nombre;
    private String dni;
    private List<Computadora> computadoras; // Asociación bidireccional
    
    public Propietario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.computadoras = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public List<Computadora> getComputadoras() {
        return computadoras;
    }
    
    // Método para agregar computadora (mantiene bidireccionalidad)
    public void agregarComputadora(Computadora computadora) {
        if (computadora != null && !computadoras.contains(computadora)) {
            computadoras.add(computadora);
            if (computadora.getPropietario() != this) {
                computadora.setPropietario(this);
            }
        }
    }
    
    // Método para remover computadora
    public void removerComputadora(Computadora computadora) {
        if (computadoras.remove(computadora)) {
            if (computadora.getPropietario() == this) {
                computadora.setPropietario(null);
            }
        }
    }
    
    public void mostrarComputadoras() {
        System.out.println("\nComputadoras de " + nombre + ":");
        if (computadoras.isEmpty()) {
            System.out.println("  No tiene computadoras");
        } else {
            for (Computadora comp : computadoras) {
                System.out.println("  - " + comp.getMarca() + " " + comp.getNumeroSerie());
            }
        }
    }
    
    @Override
    public String toString() {
        return "Propietario{nombre='" + nombre + "', dni='" + dni + 
               "', computadoras=" + computadoras.size() + "}";
    }
}

// Clase Computadora
public class Computadora {
    private String marca;
    private String numeroSerie;
    private PlacaMadre placaMadre; // Composición: parte integral de la computadora
    private Propietario propietario; // Asociación bidireccional
    
    // Constructor que crea la placa madre internamente (composición)
    public Computadora(String marca, String numeroSerie, String modeloPlaca, String chipset) {
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        // Composición: la computadora crea y controla la placa madre
        this.placaMadre = new PlacaMadre(modeloPlaca, chipset);
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getNumeroSerie() {
        return numeroSerie;
    }
    
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    
    public PlacaMadre getPlacaMadre() {
        return placaMadre;
    }
    
    // En composición, no se permite reemplazar la placa madre desde fuera
    // Solo se pueden modificar sus propiedades
    public void actualizarPlacaMadre(String nuevoModelo, String nuevoChipset) {
        this.placaMadre = new PlacaMadre(nuevoModelo, nuevoChipset);
    }
    
    public Propietario getPropietario() {
        return propietario;
    }
    
    public void setPropietario(Propietario propietario) {
        // Remover del propietario anterior si existe
        if (this.propietario != null && this.propietario != propietario) {
            this.propietario.getComputadoras().remove(this);
        }
        
        this.propietario = propietario;
        
        // Agregar al nuevo propietario (mantener bidireccionalidad)
        if (propietario != null && !propietario.getComputadoras().contains(this)) {
            propietario.agregarComputadora(this);
        }
    }
    
    public void mostrarDetalles() {
        System.out.println("\nDetalles de la Computadora:");
        System.out.println("  Marca: " + marca);
        System.out.println("  Número de Serie: " + numeroSerie);
        System.out.println("  Placa Madre: " + placaMadre.getModelo() + 
                           " (Chipset: " + placaMadre.getChipset() + ")");
        System.out.println("  Propietario: " + 
                           (propietario != null ? propietario.getNombre() : "Sin propietario"));
    }
    
    @Override
    public String toString() {
        return "Computadora{marca='" + marca + "', numeroSerie='" + numeroSerie + 
               "', propietario=" + (propietario != null ? propietario.getNombre() : "Sin propietario") + "}";
    }
}

// Clase de prueba
public class TestComputadora {
    public static void main(String[] args) {
        // Crear propietarios
        Propietario propietario1 = new Propietario("Carlos Rodríguez", "25123456");
        Propietario propietario2 = new Propietario("Laura Fernández", "28987654");
        
        System.out.println("Propietarios creados:");
        System.out.println(propietario1);
        System.out.println(propietario2);
        
        // Crear computadoras (composición: la placa madre se crea internamente)
        System.out.println("\n--- Composición: Creación de Computadoras ---");
        Computadora comp1 = new Computadora("Dell", "SN001234", "ASUS ROG STRIX Z590", "Intel Z590");
        Computadora comp2 = new Computadora("HP", "SN005678", "MSI B550", "AMD B550");
        Computadora comp3 = new Computadora("Lenovo", "SN009012", "Gigabyte X570", "AMD X570");
        
        System.out.println("Computadoras creadas con sus placas madres (composición):");
        comp1.mostrarDetalles();
        comp2.mostrarDetalles();
        comp3.mostrarDetalles();
        
        // Establecer relación bidireccional con propietarios
        System.out.println("\n--- Asociación Bidireccional ---");
        comp1.setPropietario(propietario1);
        comp2.setPropietario(propietario1);
        comp3.setPropietario(propietario2);
        
        propietario1.mostrarComputadoras();
        propietario2.mostrarComputadoras();
        
        // Demostrar composición: actualizar placa madre
        System.out.println("\n--- Demostrando Composición ---");
        System.out.println("Estado inicial de comp1:");
        comp1.mostrarDetalles();
        
        System.out.println("\nActualizando placa madre de comp1 (la anterior deja de existir):");
        comp1.actualizarPlacaMadre("ASUS TUF Z690", "Intel Z690");
        comp1.mostrarDetalles();
        
        // Demostrar que la placa madre no puede existir independientemente
        System.out.println("\nLa placa madre solo existe como parte de la computadora.");
        System.out.println("No se puede instalar una placa madre existente desde fuera.");
        System.out.println("Solo se puede crear/actualizar internamente.");
        
        // Transferir computadora entre propietarios (asociación bidireccional)
        System.out.println("\n--- Transferir Propiedad ---");
        System.out.println("Antes de la transferencia:");
        propietario1.mostrarComputadoras();
        propietario2.mostrarComputadoras();
        
        System.out.println("\nTransfiriendo " + comp1.getMarca() + " de " + 
                           propietario1.getNombre() + " a " + propietario2.getNombre());
        comp1.setPropietario(propietario2);
        
        System.out.println("\nDespués de la transferencia:");
        propietario1.mostrarComputadoras();
        propietario2.mostrarComputadoras();
        
        // Demostrar que al eliminar la computadora, la placa madre también se pierde
        System.out.println("\n--- Ciclo de vida en Composición ---");
        System.out.println("Si eliminamos comp2, su placa madre también deja de existir");
        System.out.println("Computadora: " + comp2);
        System.out.println("Placa madre antes de eliminar: " + comp2.getPlacaMadre());
        
        propietario1.removerComputadora(comp2);
        comp2 = null; // Simular eliminación
        System.out.println("Computadora eliminada. La placa madre ya no es accesible.");
    }
}

// Ejercicio 6 - Reserva - Cliente - Mesa
// Clase Cliente
public class Cliente {
    private String nombre;
    private String telefono;
    
    public Cliente(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return "Cliente{nombre='" + nombre + "', telefono='" + telefono + "'}";
    }
}

// Clase Mesa
public class Mesa {
    private int numero;
    private int capacidad;
    
    public Mesa(int numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    @Override
    public String toString() {
        return "Mesa{numero=" + numero + ", capacidad=" + capacidad + " personas}";
    }
}

// Clase Reserva
import java.util.Date;
import java.text.SimpleDateFormat;

public class Reserva {
    private Date fecha;
    private String hora;
    private Cliente cliente; // Asociación unidireccional: Reserva conoce a Cliente
    private Mesa mesa; // Agregación: Reserva asigna una Mesa
    
    public Reserva(Date fecha, String hora, Cliente cliente, Mesa mesa) {
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.mesa = mesa; // Agregación: recibe mesa existente
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getHora() {
        return hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Mesa getMesa() {
        return mesa;
    }
    
    // Agregación: permite reasignar mesa
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    public void mostrarDetalles() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\nDetalles de la Reserva:");
        System.out.println("  Fecha: " + sdf.format(fecha));
        System.out.println("  Hora: " + hora);
        System.out.println("  Cliente: " + cliente.getNombre() + " (Tel: " + cliente.getTelefono() + ")");
        System.out.println("  Mesa: " + mesa.getNumero() + " (Capacidad: " + mesa.getCapacidad() + " personas)");
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Reserva{fecha=" + sdf.format(fecha) + ", hora='" + hora + 
               "', cliente=" + cliente.getNombre() + 
               ", mesa=" + mesa.getNumero() + "}";
    }
}

// Sistema de gestión de reservas
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class SistemaReservas {
    private List<Reserva> reservas;
    private List<Mesa> mesas;
    
    public SistemaReservas() {
        this.reservas = new ArrayList<>();
        this.mesas = new ArrayList<>();
    }
    
    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
    }
    
    public void crearReserva(Reserva reserva) {
        reservas.add(reserva);
    }
    
    public void cancelarReserva(Reserva reserva) {
        reservas.remove(reserva);
        // La mesa y el cliente siguen existiendo (agregación y asociación)
    }
    
    public void mostrarTodasReservas() {
        System.out.println("\n=== Todas las Reservas ===");
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas");
        } else {
            for (Reserva reserva : reservas) {
                reserva.mostrarDetalles();
            }
        }
    }
    
    public void mostrarMesasDisponibles() {
        System.out.println("\n=== Mesas Disponibles ===");
        for (Mesa mesa : mesas) {
            System.out.println(mesa);
        }
    }
    
    public List<Reserva> getReservas() {
        return reservas;
    }
    
    public List<Mesa> getMesas() {
        return mesas;
    }
}

// Clase de prueba
import java.util.Date;
import java.util.Calendar;

public class TestReserva {
    public static void main(String[] args) {
        // Crear sistema de reservas
        SistemaReservas sistema = new SistemaReservas();
        
        // Crear mesas independientes (existen antes de las reservas)
        System.out.println("--- Creando Mesas ---");
        Mesa mesa1 = new Mesa(1, 4);
        Mesa mesa2 = new Mesa(2, 2);
        Mesa mesa3 = new Mesa(3, 6);
        Mesa mesa4 = new Mesa(4, 4);
        
        sistema.agregarMesa(mesa1);
        sistema.agregarMesa(mesa2);
        sistema.agregarMesa(mesa3);
        sistema.agregarMesa(mesa4);
        
        System.out.println("Mesas creadas:");
        System.out.println(mesa1);
        System.out.println(mesa2);
        System.out.println(mesa3);
        System.out.println(mesa4);
        
        // Crear clientes independientes
        System.out.println("\n--- Creando Clientes ---");
        Cliente cliente1 = new Cliente("Roberto Sánchez", "3514567890");
        Cliente cliente2 = new Cliente("María López", "3515678901");
        Cliente cliente3 = new Cliente("Diego Martín", "3516789012");
        
        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
        
        // Crear fechas para reservas
        Calendar cal = Calendar.getInstance();
        Date hoy = cal.getTime();
        
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date manana = cal.getTime();
        
        cal.add(Calendar.DAY_OF_MONTH, 1);
        Date pasado = cal.getTime();
        
        // Crear reservas (asociación unidireccional + agregación)
        System.out.println("\n--- Creando Reservas ---");
        Reserva reserva1 = new Reserva(hoy, "20:00", cliente1, mesa1);
        Reserva reserva2 = new Reserva(manana, "21:30", cliente2, mesa2);
        Reserva reserva3 = new Reserva(pasado, "19:00", cliente3, mesa3);
        
        sistema.crearReserva(reserva1);
        sistema.crearReserva(reserva2);
        sistema.crearReserva(reserva3);
        
        sistema.mostrarTodasReservas();
        
        // Demostrar asociación unidireccional
        System.out.println("\n--- Asociación Unidireccional ---");
        System.out.println("La reserva conoce al cliente: " + reserva1.getCliente().getNombre());
        System.out.println("El cliente NO mantiene referencia a sus reservas en este modelo");
        System.out.println("(Para obtener reservas de un cliente, se debe buscar en el sistema)");
        
        // Demostrar agregación: reasignar mesa
        System.out.println("\n--- Demostrando Agregación ---");
        System.out.println("Reserva original:");
        reserva1.mostrarDetalles();
        
        System.out.println("\nReasignando mesa (la mesa original sigue existiendo):");
        reserva1.setMesa(mesa4);
        reserva1.mostrarDetalles();
        
        System.out.println("\nLa mesa 1 sigue existiendo y disponible:");
        System.out.println(mesa1);
        
        // Cancelar reserva
        System.out.println("\n--- Cancelar Reserva ---");
        System.out.println("Cancelando reserva de " + reserva2.getCliente().getNombre());
        sistema.cancelarReserva(reserva2);
        
        System.out.println("\nDespués de cancelar:");
        sistema.mostrarTodasReservas();
        
        System.out.println("\nEl cliente y la mesa siguen existiendo:");
        System.out.println(cliente2);
        System.out.println(mesa2);
        
        // Reutilizar cliente y mesa en nueva reserva
        System.out.println("\n--- Reutilizando Cliente y Mesa ---");
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DAY_OF_MONTH, 5);
        Reserva nuevaReserva = new Reserva(cal2.getTime(), "22:00", cliente2, mesa2);
        sistema.crearReserva(nuevaReserva);
        
        System.out.println("Nueva reserva creada con el mismo cliente y mesa:");
        nuevaReserva.mostrarDetalles();
        
        sistema.mostrarTodasReservas();
        sistema.mostrarMesasDisponibles();
    }
}

// Ejercicio 7 - Vehículo - Motor - Conductor
// Clase Motor
public class Motor {
    private String tipo;
    private String numeroSerie;
    
    public Motor(String tipo, String numeroSerie) {
        this.tipo = tipo;
        this.numeroSerie = numeroSerie;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getNumeroSerie() {
        return numeroSerie;
    }
    
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    
    @Override
    public String toString() {
        return "Motor{tipo='" + tipo + "', numeroSerie='" + numeroSerie + "'}";
    }
}

// Clase Conductor
import java.util.ArrayList;
import java.util.List;

public class Conductor {
    private String nombre;
    private String licencia;
    private List<Vehiculo> vehiculos; // Asociación bidireccional (muchos a muchos)
    
    public Conductor(String nombre, String licencia) {
        this.nombre = nombre;
        this.licencia = licencia;
        this.vehiculos = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getLicencia() {
        return licencia;
    }
    
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
    
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    // Método para agregar vehículo (mantiene bidireccionalidad)
    public void agregarVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null && !vehiculos.contains(vehiculo)) {
            vehiculos.add(vehiculo);
            if (!vehiculo.getConductores().contains(this)) {
                vehiculo.agregarConductor(this);
            }
        }
    }
    
    // Método para remover vehículo
    public void removerVehiculo(Vehiculo vehiculo) {
        if (vehiculos.remove(vehiculo)) {
            if (vehiculo.getConductores().contains(this)) {
                vehiculo.removerConductor(this);
            }
        }
    }
    
    public void mostrarVehiculos() {
        System.out.println("\nVehículos de " + nombre + ":");
        if (vehiculos.isEmpty()) {
            System.out.println("  No conduce ningún vehículo");
        } else {
            for (Vehiculo v : vehiculos) {
                System.out.println("  - " + v.getModelo() + " (Patente: " + v.getPatente() + ")");
            }
        }
    }
    
    @Override
    public String toString() {
        return "Conductor{nombre='" + nombre + "', licencia='" + licencia + 
               "', vehiculos=" + vehiculos.size() + "}";
    }
}

// Clase Vehiculo
import java.util.ArrayList;
import java.util.List;

public class Vehiculo {
    private String patente;
    private String modelo;
    private Motor motor; // Agregación: el motor puede existir independientemente
    private List<Conductor> conductores; // Asociación bidireccional (muchos a muchos)
    
    public Vehiculo(String patente, String modelo) {
        this.patente = patente;
        this.modelo = modelo;
        this.conductores = new ArrayList<>();
    }
    
    // Constructor sobrecargado que acepta un motor existente
    public Vehiculo(String patente, String modelo, Motor motor) {
        this.patente = patente;
        this.modelo = modelo;
        this.motor = motor; // Agregación: recibe motor desde fuera
        this.conductores = new ArrayList<>();
    }
    
    public String getPatente() {
        return patente;
    }
    
    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public Motor getMotor() {
        return motor;
    }
    
    // Agregación: permite instalar motor existente
    public void instalarMotor(Motor motor) {
        this.motor = motor;
    }
    
    // Agregación: permite remover el motor (sigue existiendo)
    public Motor removerMotor() {
        Motor motorRemovido = this.motor;
        this.motor = null;
        return motorRemovido;
    }
    
    public List<Conductor> getConductores() {
        return conductores;
    }
    
    // Método para agregar conductor (mantiene bidireccionalidad)
    public void agregarConductor(Conductor conductor) {
        if (conductor != null && !conductores.contains(conductor)) {
            conductores.add(conductor);
            if (!conductor.getVehiculos().contains(this)) {
                conductor.agregarVehiculo(this);
            }
        }
    }
    
    // Método para remover conductor
    public void removerConductor(Conductor conductor) {
        if (conductores.remove(conductor)) {
            if (conductor.getVehiculos().contains(this)) {
                conductor.removerVehiculo(this);
            }
        }
    }
    
    public void mostrarConductores() {
        System.out.println("\nConductores del vehículo " + modelo + " (" + patente + "):");
        if (conductores.isEmpty()) {
            System.out.println("  No tiene conductores asignados");
        } else {
            for (Conductor c : conductores) {
                System.out.println("  - " + c.getNombre() + " (Licencia: " + c.getLicencia() + ")");
            }
        }
    }
    
    public void mostrarDetalles() {
        System.out.println("\nDetalles del Vehículo:");
        System.out.println("  Patente: " + patente);
        System.out.println("  Modelo: " + modelo);
        System.out.println("  Motor: " + (motor != null ? motor.getTipo() + " (" + motor.getNumeroSerie() + ")" : "Sin motor"));
        System.out.println("  Conductores: " + conductores.size());
    }
    
    @Override
    public String toString() {
        return "Vehiculo{patente='" + patente + "', modelo='" + modelo + 
               "', conductores=" + conductores.size() + "}";
    }
}

// Clase de prueba
public class TestVehiculo {
    public static void main(String[] args) {
        // Crear motores independientes (agregación)
        System.out.println("--- Creando Motores ---");
        Motor motor1 = new Motor("V6 3.5L", "M001-2020");
        Motor motor2 = new Motor("4 cilindros 2.0L", "M002-2021");
        Motor motor3 = new Motor("V8 5.0L", "M003-2019");
        
        System.out.println(motor1);
        System.out.println(motor2);
        System.out.println(motor3);
        
        // Crear vehículos
        System.out.println("\n--- Creando Vehículos ---");
        Vehiculo vehiculo1 = new Vehiculo("ABC123", "Toyota Camry", motor1);
        Vehiculo vehiculo2 = new Vehiculo("XYZ789", "Honda Civic");
        Vehiculo vehiculo3 = new Vehiculo("LMN456", "Ford Mustang", motor3);
        
        // Instalar motor en vehiculo2
        vehiculo2.instalarMotor(motor2);
        
        vehiculo1.mostrarDetalles();
        vehiculo2.mostrarDetalles();
        vehiculo3.mostrarDetalles();
        
        // Crear conductores
        System.out.println("\n--- Creando Conductores ---");
        Conductor conductor1 = new Conductor("Juan Pérez", "B-12345678");
        Conductor conductor2 = new Conductor("Ana García", "B-87654321");
        Conductor conductor3 = new Conductor("Carlos Ruiz", "B-11223344");
        
        System.out.println(conductor1);
        System.out.println(conductor2);
        System.out.println(conductor3);
        
        // Establecer relación bidireccional muchos a muchos
        System.out.println("\n--- Asociación Bidireccional Muchos a Muchos ---");
        
        // Juan conduce vehículo1 y vehículo2
        vehiculo1.agregarConductor(conductor1);
        vehiculo2.agregarConductor(conductor1);
        
        // Ana conduce vehículo2 y vehículo3
        vehiculo2.agregarConductor(conductor2);
        vehiculo3.agregarConductor(conductor2);
        
        // Carlos conduce vehículo3
        vehiculo3.agregarConductor(conductor3);
        
        conductor1.mostrarVehiculos();
        conductor2.mostrarVehiculos();
        conductor3.mostrarVehiculos();
        
        vehiculo1.mostrarConductores();
        vehiculo2.mostrarConductores();
        vehiculo3.mostrarConductores();
        
        // Demostrar agregación: remover e intercambiar motores
        System.out.println("\n--- Demostrando Agregación ---");
        System.out.println("Removiendo motor del vehículo1:");
        Motor motorRemovido = vehiculo1.removerMotor();
        System.out.println("Motor removido: " + motorRemovido);
        vehiculo1.mostrarDetalles();
        
        System.out.println("\nEl motor sigue existiendo y puede instalarse en otro vehículo:");
        System.out.println("Instalando motor en vehículo2 (reemplazando el actual):");
        Motor motorAnterior = vehiculo2.removerMotor();
        vehiculo2.instalarMotor(motorRemovido);
        vehiculo2.mostrarDetalles();
        
        System.out.println("\nEl motor anterior de vehículo2 también sigue existiendo:");
        System.out.println(motorAnterior);
        
        // Demostrar modificación de relación bidireccional
        System.out.println("\n--- Modificar Relaciones ---");
        System.out.println("Removiendo a Juan como conductor de vehículo2:");
        vehiculo2.removerConductor(conductor1);
        
        conductor1.mostrarVehiculos();
        vehiculo2.mostrarConductores();
        
        System.out.println("\nAgregando a Carlos como conductor de vehículo1:");
        conductor3.agregarVehiculo(vehiculo1);
        
        conductor3.mostrarVehiculos();
        vehiculo1.mostrarConductores();
        
        // Resumen final
        System.out.println("\n=== RESUMEN FINAL ===");
        System.out.println("\nTodos los vehículos:");
        vehiculo1.mostrarDetalles();
        vehiculo2.mostrarDetalles();
        vehiculo3.mostrarDetalles();
        
        System.out.println("\nTodos los conductores:");
        conductor1.mostrarVehiculos();
        conductor2.mostrarVehiculos();
        conductor3.mostrarVehiculos();
    }
}

// Ejercicio 8 - Documento - FirmaDigital - Usuario
// Clase Usuario
public class Usuario {
    private String nombre;
    private String email;
    
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Usuario{nombre='" + nombre + "', email='" + email + "'}";
    }
}

// Clase FirmaDigital
import java.util.Date;
import java.text.SimpleDateFormat;

public class FirmaDigital {
    private String codigoHash;
    private Date fecha;
    private Usuario usuario; // Agregación: Usuario existe independientemente
    
    // Constructor para uso interno (composición desde Documento)
    public FirmaDigital(String codigoHash, Date fecha, Usuario usuario) {
        this.codigoHash = codigoHash;
        this.fecha = fecha;
        this.usuario = usuario; // Agregación: recibe usuario existente
    }
    
    public String getCodigoHash() {
        return codigoHash;
    }
    
    public void setCodigoHash(String codigoHash) {
        this.codigoHash = codigoHash;
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public boolean verificarFirma(String hash) {
        return this.codigoHash.equals(hash);
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "FirmaDigital{codigoHash='" + codigoHash + "', fecha=" + sdf.format(fecha) + 
               ", usuario=" + (usuario != null ? usuario.getNombre() : "Sin usuario") + "}";
    }
}

// Clase Documento
import java.util.Date;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;

public class Documento {
    private String titulo;
    private String contenido;
    private FirmaDigital firmaDigital; // Composición: la firma es parte integral del documento
    
    public Documento(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getContenido() {
        return contenido;
    }
    
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    public FirmaDigital getFirmaDigital() {
        return firmaDigital;
    }
    
    public boolean estaFirmado() {
        return firmaDigital != null;
    }
    
    // Composición: el documento crea la firma digital internamente
    public void firmarDocumento(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser null");
        }
        
        // Generar hash del contenido
        String hash = generarHash(this.contenido);
        
        // Composición: crear la firma digital como parte del documento
        this.firmaDigital = new FirmaDigital(hash, new Date(), usuario);
        
        System.out.println("Documento firmado por " + usuario.getNombre());
    }
    
    // Método auxiliar para generar hash
    private String generarHash(String texto) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(texto.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString().substring(0, 16); // Tomar primeros 16 caracteres
        } catch (Exception e) {
            return "hash_error";
        }
    }
    
    public boolean verificarIntegridad() {
        if (!estaFirmado()) {
            System.out.println("El documento no está firmado");
            return false;
        }
        
        String hashActual = generarHash(this.contenido);
        boolean esValido = firmaDigital.verificarFirma(hashActual);
        
        if (esValido) {
            System.out.println("✓ La firma digital es válida - El documento no ha sido modificado");
        } else {
            System.out.println("✗ La firma digital es inválida - El documento ha sido modificado");
        }
        
        return esValido;
    }
    
    public void mostrarDetalles() {
        System.out.println("\n=== Documento ===");
        System.out.println("Título: " + titulo);
        System.out.println("Contenido: " + contenido);
        System.out.println("Estado: " + (estaFirmado() ? "Firmado" : "Sin firmar"));
        if (estaFirmado()) {
            System.out.println("Firma: " + firmaDigital);
        }
    }
    
    @Override
    public String toString() {
        return "Documento{titulo='" + titulo + "', firmado=" + estaFirmado() + "}";
    }
}

// Sistema de gestión de documentos
import java.util.ArrayList;
import java.util.List;

public class SistemaDocumentos {
    private List<Documento> documentos;
    private List<Usuario> usuarios;
    
    public SistemaDocumentos() {
        this.documentos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }
    
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    
    public void agregarDocumento(Documento documento) {
        documentos.add(documento);
    }
    
    public void mostrarTodosDocumentos() {
        System.out.println("\n=== Todos los Documentos ===");
        if (documentos.isEmpty()) {
            System.out.println("No hay documentos en el sistema");
        } else {
            for (Documento doc : documentos) {
                doc.mostrarDetalles();
            }
        }
    }
    
    public void mostrarDocumentosFirmados() {
        System.out.println("\n=== Documentos Firmados ===");
        boolean hayFirmados = false;
        for (Documento doc : documentos) {
            if (doc.estaFirmado()) {
                System.out.println("- " + doc.getTitulo() + " (firmado por " + 
                                   doc.getFirmaDigital().getUsuario().getNombre() + ")");
                hayFirmados = true;
            }
        }
        if (!hayFirmados) {
            System.out.println("No hay documentos firmados");
        }
    }
    
    public List<Documento> getDocumentos() {
        return documentos;
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}

// Clase de prueba
public class TestDocumento {
    public static void main(String[] args) {
        // Crear sistema de documentos
        SistemaDocumentos sistema = new SistemaDocumentos();
        
        // Crear usuarios independientes (agregación)
        System.out.println("--- Creando Usuarios ---");
        Usuario usuario1 = new Usuario("Dr. Roberto Fernández", "roberto@example.com");
        Usuario usuario2 = new Usuario("Lic. María Rodríguez", "maria@example.com");
        Usuario usuario3 = new Usuario("Ing. Carlos López", "carlos@example.com");
        
        sistema.registrarUsuario(usuario1);
        sistema.registrarUsuario(usuario2);
        sistema.registrarUsuario(usuario3);
        
        System.out.println(usuario1);
        System.out.println(usuario2);
        System.out.println(usuario3);
        
        // Crear documentos sin firmar
        System.out.println("\n--- Creando Documentos ---");
        Documento doc1 = new Documento("Contrato de Trabajo", 
                                       "Por medio del presente contrato...");
        Documento doc2 = new Documento("Acuerdo de Confidencialidad", 
                                       "Las partes acuerdan mantener confidencial...");
        Documento doc3 = new Documento("Informe Técnico 2024", 
                                       "Resultados del análisis técnico...");
        
        sistema.agregarDocumento(doc1);
        sistema.agregarDocumento(doc2);
        sistema.agregarDocumento(doc3);
        
        sistema.mostrarTodosDocumentos();
        
        // Firmar documentos (composición)
        System.out.println("\n--- Composición: Firmando Documentos ---");
        doc1.firmarDocumento(usuario1);
        doc2.firmarDocumento(usuario2);
        doc3.firmarDocumento(usuario1);
        
        sistema.mostrarTodosDocumentos();
        sistema.mostrarDocumentosFirmados();
        
        // Verificar integridad
        System.out.println("\n--- Verificar Integridad ---");
        System.out.println("Verificando documento 1:");
        doc1.verificarIntegridad();
        
        System.out.println("\nVerificando documento 2:");
        doc2.verificarIntegridad();
        
        // Demostrar composición: modificar contenido invalida la firma
        System.out.println("\n--- Demostrando Composición ---");
        System.out.println("Modificando contenido del documento 1...");
        doc1.setContenido("Por medio del presente contrato MODIFICADO...");
        
        System.out.println("Verificando integridad después de modificar:");
        doc1.verificarIntegridad();
        
        // Demostrar agregación: el usuario existe independientemente
        System.out.println("\n--- Demostrando Agregación ---");
        System.out.println("Usuario que firmó doc1: " + doc1.getFirmaDigital().getUsuario());
        System.out.println("Usuario que firmó doc3: " + doc3.getFirmaDigital().getUsuario());
        System.out.println("El mismo usuario puede firmar múltiples documentos");
        System.out.println("El usuario sigue existiendo si se elimina un documento");
        
        // Eliminar documento (la firma se pierde, pero el usuario no)
        System.out.println("\nEliminando documento 3 del sistema:");
        sistema.getDocumentos().remove(doc3);
        System.out.println("La firma digital del doc3 ya no existe (composición)");
        System.out.println("Pero el usuario sigue existiendo: " + usuario1);
        
        sistema.mostrarDocumentosFirmados();
        
        // Crear nuevo documento y firmarlo con el mismo usuario
        System.out.println("\n--- Reutilizando Usuario ---");
        Documento doc4 = new Documento("Nuevo Contrato 2024", 
                                       "Este es un nuevo documento...");
        doc4.firmarDocumento(usuario1);
        sistema.agregarDocumento(doc4);
        
        System.out.println("Nuevo documento firmado con el mismo usuario:");
        doc4.mostrarDetalles();
        doc4.verificarIntegridad();
        
        // Resumen final
        System.out.println("\n=== RESUMEN FINAL ===");
        sistema.mostrarDocumentosFirmados();
        
        System.out.println("\nUsuarios en el sistema:");
        for (Usuario u : sistema.getUsuarios()) {
            System.out.println("- " + u);
        }
    }
}

// Ejercicio 9 - CitaMédica - Paciente - Profesional
// Clase Paciente
public class Paciente {
    private String nombre;
    private String obraSocial;
    
    public Paciente(String nombre, String obraSocial) {
        this.nombre = nombre;
        this.obraSocial = obraSocial;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getObraSocial() {
        return obraSocial;
    }
    
    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }
    
    @Override
    public String toString() {
        return "Paciente{nombre='" + nombre + "', obraSocial='" + obraSocial + "'}";
    }
}

// Clase Profesional
public class Profesional {
    private String nombre;
    private String especialidad;
    
    public Profesional(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    @Override
    public String toString() {
        return "Profesional{nombre='" + nombre + "', especialidad='" + especialidad + "'}";
    }
}

// Clase CitaMedica
import java.util.Date;
import java.text.SimpleDateFormat;

public class CitaMedica {
    private Date fecha;
    private String hora;
    private Paciente paciente; // Asociación unidireccional
    private Profesional profesional; // Asociación unidireccional
    private String estado; // "Programada", "Confirmada", "Cancelada", "Completada"
    
    public CitaMedica(Date fecha, String hora, Paciente paciente, Profesional profesional) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.profesional = profesional;
        this.estado = "Programada";
    }
    
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getHora() {
        return hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public Profesional getProfesional() {
        return profesional;
    }
    
    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void confirmar() {
        this.estado = "Confirmada";
        System.out.println("Cita confirmada para " + paciente.getNombre());
    }
    
    public void cancelar() {
        this.estado = "Cancelada";
        System.out.println("Cita cancelada");
    }
    
    public void completar() {
        this.estado = "Completada";
        System.out.println("Cita completada");
    }
    
    public void mostrarDetalles() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\n--- Cita Médica ---");
        System.out.println("Fecha: " + sdf.format(fecha));
        System.out.println("Hora: " + hora);
        System.out.println("Paciente: " + paciente.getNombre() + " (Obra Social: " + paciente.getObraSocial() + ")");
        System.out.println("Profesional: " + profesional.getNombre() + " (" + profesional.getEspecialidad() + ")");
        System.out.println("Estado: " + estado);
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "CitaMedica{fecha=" + sdf.format(fecha) + ", hora='" + hora + 
               "', paciente=" + paciente.getNombre() + 
               ", profesional=" + profesional.getNombre() + 
               ", estado=" + estado + "}";
    }
}

// Sistema de gestión de citas médicas
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class SistemaCitasMedicas {
    private List<CitaMedica> citas;
    private List<Paciente> pacientes;
    private List<Profesional> profesionales;
    
    public SistemaCitasMedicas() {
        this.citas = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.profesionales = new ArrayList<>();
    }
    
    public void registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }
    
    public void registrarProfesional(Profesional profesional) {
        profesionales.add(profesional);
    }
    
    public void agendarCita(CitaMedica cita) {
        citas.add(cita);
    }
    
    public void cancelarCita(CitaMedica cita) {
        cita.cancelar();
    }
    
    public void mostrarTodasCitas() {
        System.out.println("\n=== Todas las Citas ===");
        if (citas.isEmpty()) {
            System.out.println("No hay citas programadas");
        } else {
            for (CitaMedica cita : citas) {
                cita.mostrarDetalles();
            }
        }
    }
    
    public List<CitaMedica> buscarCitasPorPaciente(Paciente paciente) {
        List<CitaMedica> citasPaciente = new ArrayList<>();
        for (CitaMedica cita : citas) {
            if (cita.getPaciente().equals(paciente)) {
                citasPaciente.add(cita);
            }
        }
        return citasPaciente;
    }
    
    public List<CitaMedica> buscarCitasPorProfesional(Profesional profesional) {
        List<CitaMedica> citasProfesional = new ArrayList<>();
        for (CitaMedica cita : citas) {
            if (cita.getProfesional().equals(profesional)) {
                citasProfesional.add(cita);
            }
        }
        return citasProfesional;
    }
    
    public void mostrarAgendaProfesional(Profesional profesional) {
        System.out.println("\n=== Agenda de " + profesional.getNombre() + " ===");
        List<CitaMedica> citasProf = buscarCitasPorProfesional(profesional);
        if (citasProf.isEmpty()) {
            System.out.println("No hay citas programadas");
        } else {
            for (CitaMedica cita : citasProf) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("- " + sdf.format(cita.getFecha()) + " " + cita.getHora() + 
                                   " | " + cita.getPaciente().getNombre() + 
                                   " (" + cita.getEstado() + ")");
            }
        }
    }
    
    public void mostrarHistorialPaciente(Paciente paciente) {
        System.out.println("\n=== Historial de " + paciente.getNombre() + " ===");
        List<CitaMedica> citasPac = buscarCitasPorPaciente(paciente);
        if (citasPac.isEmpty()) {
            System.out.println("No hay citas registradas");
        } else {
            for (CitaMedica cita : citasPac) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("- " + sdf.format(cita.getFecha()) + " " + cita.getHora() + 
                                   " | Dr. " + cita.getProfesional().getNombre() + 
                                   " (" + cita.getEstado() + ")");
            }
        }
    }
    
    public List<CitaMedica> getCitas() {
        return citas;
    }
    
    public List<Paciente> getPacientes() {
        return pacientes;
    }
    
    public List<Profesional> getProfesionales() {
        return profesionales;
    }
}

// Clase de prueba
import java.util.Date;
import java.util.Calendar;

public class TestCitaMedica {
    public static void main(String[] args) {
        // Crear sistema de citas
        SistemaCitasMedicas sistema = new SistemaCitasMedicas();
        
        // Crear pacientes independientes
        System.out.println("--- Creando Pacientes ---");
        Paciente paciente1 = new Paciente("Laura Martínez", "OSDE");
        Paciente paciente2 = new Paciente("Roberto Gómez", "Swiss Medical");
        Paciente paciente3 = new Paciente("Ana Silva", "IOMA");
        
        sistema.registrarPaciente(paciente1);
        sistema.registrarPaciente(paciente2);
        sistema.registrarPaciente(paciente3);
        
        System.out.println(paciente1);
        System.out.println(paciente2);
        System.out.println(paciente3);
        
        // Crear profesionales independientes
        System.out.println("\n--- Creando Profesionales ---");
        Profesional prof1 = new Profesional("Dr. Carlos Fernández", "Cardiología");
        Profesional prof2 = new Profesional("Dra. Marta López", "Dermatología");
        Profesional prof3 = new Profesional("Dr. Juan Pérez", "Traumatología");
        
        sistema.registrarProfesional(prof1);
        sistema.registrarProfesional(prof2);
        sistema.registrarProfesional(prof3);
        
        System.out.println(prof1);
        System.out.println(prof2);
        System.out.println(prof3);
        
        // Crear fechas para las citas
        Calendar cal = Calendar.getInstance();
        Date hoy = cal.getTime();
        
        cal.add(Calendar.DAY_OF_MONTH, 2);
        Date dentroDosDias = cal.getTime();
        
        cal.add(Calendar.DAY_OF_MONTH, 3);
        Date dentroCincoDias = cal.getTime();
        
        cal.add(Calendar.DAY_OF_MONTH, 2);
        Date dentroSieteDias = cal.getTime();
        
        // Crear citas (asociación unidireccional)
        System.out.println("\n--- Creando Citas Médicas ---");
        CitaMedica cita1 = new CitaMedica(hoy, "10:00", paciente1, prof1);
        CitaMedica cita2 = new CitaMedica(dentroDosDias, "15:30", paciente2, prof2);
        CitaMedica cita3 = new CitaMedica(dentroCincoDias, "09:00", paciente1, prof2);
        CitaMedica cita4 = new CitaMedica(dentroSieteDias, "11:00", paciente3, prof1);
        CitaMedica cita5 = new CitaMedica(dentroDosDias, "16:30", paciente2, prof3);
        
        sistema.agendarCita(cita1);
        sistema.agendarCita(cita2);
        sistema.agendarCita(cita3);
        sistema.agendarCita(cita4);
        sistema.agendarCita(cita5);
        
        sistema.mostrarTodasCitas();
        
        // Demostrar asociación unidireccional
        System.out.println("\n--- Asociación Unidireccional ---");
        System.out.println("La cita conoce al paciente: " + cita1.getPaciente().getNombre());
        System.out.println("La cita conoce al profesional: " + cita1.getProfesional().getNombre());
        System.out.println("El paciente y profesional NO tienen referencias a sus citas");
        System.out.println("Para obtener citas, se debe buscar en el sistema");
        
        // Buscar citas por paciente
        System.out.println("\n--- Buscando Citas por Paciente ---");
        sistema.mostrarHistorialPaciente(paciente1);
        sistema.mostrarHistorialPaciente(paciente2);
        
        // Buscar citas por profesional
        System.out.println("\n--- Agendas de Profesionales ---");
        sistema.mostrarAgendaProfesional(prof1);
        sistema.mostrarAgendaProfesional(prof2);
        sistema.mostrarAgendaProfesional(prof3);
        
        // Gestionar estados de citas
        System.out.println("\n--- Gestionando Citas ---");
        cita1.confirmar();
        cita2.confirmar();
        cita3.cancelar();
        cita1.completar();
        
        sistema.mostrarTodasCitas();
        
        // Reasignar profesional a una cita
        System.out.println("\n--- Reasignando Profesional ---");
        System.out.println("Cita 4 antes:");
        cita4.mostrarDetalles();
        
        System.out.println("\nCambiando profesional de Cardiología a Traumatología:");
        cita4.setProfesional(prof3);
        cita4.mostrarDetalles();
        
        // Demostrar independencia de objetos
        System.out.println("\n--- Independencia de Objetos ---");
        System.out.println("Cancelando cita2...");
        sistema.cancelarCita(cita2);
        
        System.out.println("\nEl paciente y profesional siguen existiendo:");
        System.out.println(paciente2);
        System.out.println(prof2);
        System.out.println("Y pueden participar en nuevas citas");
        
        // Crear nueva cita con los mismos paciente y profesional
        cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 10);
        CitaMedica nuevaCita = new CitaMedica(cal.getTime(), "14:00", paciente2, prof2);
        sistema.agendarCita(nuevaCita);
        
        System.out.println("\nNueva cita creada:");
        nuevaCita.mostrarDetalles();
        
        // Resumen final
        System.out.println("\n=== RESUMEN FINAL ===");
        System.out.println("\nTotal de pacientes: " + sistema.getPacientes().size());
        System.out.println("Total de profesionales: " + sistema.getProfesionales().size());
        System.out.println("Total de citas: " + sistema.getCitas().size());
        
        sistema.mostrarHistorialPaciente(paciente1);
        sistema.mostrarHistorialPaciente(paciente2);
        sistema.mostrarAgendaProfesional(prof1);
        sistema.mostrarAgendaProfesional(prof2);
    }
}

// Ejercicio 10 - CuentaBancaria - ClaveSeguridad - Titular
// Clase ClaveSeguridad
import java.util.Date;
import java.text.SimpleDateFormat;

public class ClaveSeguridad {
    private String codigo;
    private Date ultimaModificacion;
    
    // Constructor para uso interno (composición desde CuentaBancaria)
    public ClaveSeguridad(String codigo, Date ultimaModificacion) {
        this.codigo = codigo;
        this.ultimaModificacion = ultimaModificacion;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
        this.ultimaModificacion = new Date();
    }
    
    public Date getUltimaModificacion() {
        return ultimaModificacion;
    }
    
    public boolean verificar(String claveIngresada) {
        return this.codigo.equals(claveIngresada);
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "ClaveSeguridad{codigo='****', ultimaModificacion=" + 
               sdf.format(ultimaModificacion) + "}";
    }
}

// Clase Titular
import java.util.ArrayList;
import java.util.List;

public class Titular {
    private String nombre;
    private String dni;
    private List<CuentaBancaria> cuentas; // Asociación bidireccional (muchos a muchos)
    
    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.cuentas = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDni() {
        return dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    public List<CuentaBancaria> getCuentas() {
        return cuentas;
    }
    
    // Método para agregar cuenta (mantiene bidireccionalidad)
    public void agregarCuenta(CuentaBancaria cuenta) {
        if (cuenta != null && !cuentas.contains(cuenta)) {
            cuentas.add(cuenta);
            if (!cuenta.getTitulares().contains(this)) {
                cuenta.agregarTitular(this);
            }
        }
    }
    
    // Método para remover cuenta
    public void removerCuenta(CuentaBancaria cuenta) {
        if (cuentas.remove(cuenta)) {
            if (cuenta.getTitulares().contains(this)) {
                cuenta.removerTitular(this);
            }
        }
    }
    
    public void mostrarCuentas() {
        System.out.println("\nCuentas de " + nombre + ":");
        if (cuentas.isEmpty()) {
            System.out.println("  No tiene cuentas");
        } else {
            for (CuentaBancaria c : cuentas) {
                System.out.println("  - CBU: " + c.getCbu() + " | Saldo: $" + 
                                   String.format("%.2f", c.getSaldo()));
            }
        }
    }
    
    public double calcularPatrimonioTotal() {
        double total = 0;
        for (CuentaBancaria cuenta : cuentas) {
            total += cuenta.getSaldo();
        }
        return total;
    }
    
    @Override
    public String toString() {
        return "Titular{nombre='" + nombre + "', dni='" + dni + 
               "', cuentas=" + cuentas.size() + "}";
    }
}

// Clase CuentaBancaria
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class CuentaBancaria {
    private String cbu;
    private double saldo;
    private ClaveSeguridad claveSeguridad; // Composición: parte integral de la cuenta
    private List<Titular> titulares; // Asociación bidireccional (muchos a muchos)
    private boolean bloqueada;
    private int intentosFallidos;
    
    public CuentaBancaria(String cbu, double saldoInicial, String claveInicial) {
        this.cbu = cbu;
        this.saldo = saldoInicial;
        // Composición: la cuenta crea su propia clave de seguridad
        this.claveSeguridad = new ClaveSeguridad(claveInicial, new Date());
        this.titulares = new ArrayList<>();
        this.bloqueada = false;
        this.intentosFallidos = 0;
    }
    
    public String getCbu() {
        return cbu;
    }
    
    public void setCbu(String cbu) {
        this.cbu = cbu;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public ClaveSeguridad getClaveSeguridad() {
        return claveSeguridad;
    }
    
    public List<Titular> getTitulares() {
        return titulares;
    }
    
    public boolean isBloqueada() {
        return bloqueada;
    }
    
    // Composición: modificar la clave (se crea nueva internamente)
    public boolean cambiarClave(String claveActual, String claveNueva) {
        if (bloqueada) {
            System.out.println("La cuenta está bloqueada");
            return false;
        }
        
        if (claveSeguridad.verificar(claveActual)) {
            this.claveSeguridad = new ClaveSeguridad(claveNueva, new Date());
            this.intentosFallidos = 0;
            System.out.println("Clave actualizada exitosamente");
            return true;
        } else {
            intentosFallidos++;
            System.out.println("Clave actual incorrecta. Intentos fallidos: " + intentosFallidos);
            if (intentosFallidos >= 3) {
                this.bloqueada = true;
                System.out.println("¡CUENTA BLOQUEADA por múltiples intentos fallidos!");
            }
            return false;
        }
    }
    
    // Método para verificar acceso
    public boolean verificarAcceso(String clave) {
        if (bloqueada) {
            System.out.println("La cuenta está bloqueada");
            return false;
        }
        
        if (claveSeguridad.verificar(clave)) {
            intentosFallidos = 0;
            return true;
        } else {
            intentosFallidos++;
            System.out.println("Clave incorrecta. Intentos fallidos: " + intentosFallidos);
            if (intentosFallidos >= 3) {
                this.bloqueada = true;
                System.out.println("¡CUENTA BLOQUEADA por múltiples intentos fallidos!");
            }
            return false;
        }
    }
    
    public void desbloquear() {
        this.bloqueada = false;
        this.intentosFallidos = 0;
        System.out.println("Cuenta desbloqueada");
    }
    
    // Método para agregar titular (mantiene bidireccionalidad)
    public void agregarTitular(Titular titular) {
        if (titular != null && !titulares.contains(titular)) {
            titulares.add(titular);
            if (!titular.getCuentas().contains(this)) {
                titular.agregarCuenta(this);
            }
        }
    }
    
    // Método para remover titular
    public void removerTitular(Titular titular) {
        if (titulares.remove(titular)) {
            if (titular.getCuentas().contains(this)) {
                titular.removerCuenta(this);
            }
        }
    }
    
    public boolean depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso: $" + String.format("%.2f", monto));
            return true;
        }
        System.out.println("Monto inválido");
        return false;
    }
    
    public boolean extraer(double monto, String clave) {
        if (!verificarAcceso(clave)) {
            return false;
        }
        
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Extracción exitosa: $" + String.format("%.2f", monto));
            return true;
        }
        System.out.println("Monto inválido o saldo insuficiente");
        return false;
    }
    
    public void mostrarTitulares() {
        System.out.println("\nTitulares de la cuenta " + cbu + ":");
        if (titulares.isEmpty()) {
            System.out.println("  No tiene titulares");
        } else {
            for (Titular t : titulares) {
                System.out.println("  - " + t.getNombre() + " (DNI: " + t.getDni() + ")");
            }
        }
    }
    
    public void mostrarDetalles() {
        System.out.println("\n=== Cuenta Bancaria ===");
        System.out.println("CBU: " + cbu);
        System.out.println("Saldo: $" + String.format("%.2f", saldo));
        System.out.println("Estado: " + (bloqueada ? "BLOQUEADA" : "Activa"));
        System.out.println("Titulares: " + titulares.size());
        System.out.println("Clave de seguridad: " + claveSeguridad);
    }
    
    @Override
    public String toString() {
        return "CuentaBancaria{cbu='" + cbu + "', saldo=" + saldo + 
               ", titulares=" + titulares.size() + 
               ", estado=" + (bloqueada ? "BLOQUEADA" : "Activa") + "}";
    }
}

// Clase de prueba
public class TestCuentaBancaria {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA BANCARIO ===\n");
        
        // Crear titulares independientes
        System.out.println("--- Creando Titulares ---");
        Titular titular1 = new Titular("María González", "30123456");
        Titular titular2 = new Titular("Pedro Ramírez", "28987654");
        Titular titular3 = new Titular("Laura Fernández", "35456789");
        
        System.out.println(titular1);
        System.out.println(titular2);
        System.out.println(titular3);
        
        // Crear cuentas (composición: cada cuenta crea su clave)
        System.out.println("\n--- Creando Cuentas Bancarias ---");
        CuentaBancaria cuenta1 = new CuentaBancaria("0000003100012345678901", 50000.0, "clave123");
        CuentaBancaria cuenta2 = new CuentaBancaria("0000003100098765432109", 25000.0, "pass456");
        CuentaBancaria cuenta3 = new CuentaBancaria("0000003100055555555555", 100000.0, "secure789");
        
        System.out.println("Cuentas creadas con sus claves de seguridad (composición)");
        cuenta1.mostrarDetalles();
        cuenta2.mostrarDetalles();
        cuenta3.mostrarDetalles();
        
        // Establecer relación bidireccional muchos a muchos
        System.out.println("\n--- Asociación Bidireccional (M:N) ---");
        
        // María es titular de cuenta1 y cuenta2
        cuenta1.agregarTitular(titular1);
        cuenta2.agregarTitular(titular1);
        
        // Pedro es titular de cuenta2 (cuenta conjunta con María)
        cuenta2.agregarTitular(titular2);
        
        // Laura es titular de cuenta3 y cuenta1 (cuenta conjunta con María)
        cuenta3.agregarTitular(titular3);
        cuenta1.agregarTitular(titular3);
        
        titular1.mostrarCuentas();
        titular2.mostrarCuentas();
        titular3.mostrarCuentas();
        
        cuenta1.mostrarTitulares();
        cuenta2.mostrarTitulares();
        cuenta3.mostrarTitulares();
        
        // Operaciones bancarias con verificación de clave
        System.out.println("\n--- Operaciones Bancarias ---");
        System.out.println("\nIntentando extraer de cuenta1:");
        cuenta1.extraer(10000.0, "clave123");
        cuenta1.mostrarDetalles();
        
        System.out.println("\nIntentando depositar en cuenta2:");
        cuenta2.depositar(5000.0);
        cuenta2.mostrarDetalles();
        
        // Demostrar composición: cambiar clave
        System.out.println("\n--- Demostrando Composición ---");
        System.out.println("Cambiando clave de cuenta1:");
        cuenta1.cambiarClave("clave123", "nuevaClave456");
        cuenta1.mostrarDetalles();
        
        System.out.println("\nIntentando usar la clave antigua:");
        cuenta1.extraer(5000.0, "clave123");
        
        System.out.println("\nUsando la nueva clave:");
        cuenta1.extraer(5000.0, "nuevaClave456");
        cuenta1.mostrarDetalles();
        
        // Demostrar bloqueo por intentos fallidos
        System.out.println("\n--- Sistema de Seguridad ---");
        System.out.println("Intentando acceder a cuenta3 con clave incorrecta:");
        cuenta3.verificarAcceso("incorrecta1");
        cuenta3.verificarAcceso("incorrecta2");
        cuenta3.verificarAcceso("incorrecta3");
        cuenta3.mostrarDetalles();
        
        System.out.println("\nIntentando operar con cuenta bloqueada:");
        cuenta3.extraer(1000.0, "secure789");
        
        System.out.println("\nDesbloqueando cuenta:");
        cuenta3.desbloquear();
        cuenta3.mostrarDetalles();
        
        // Calcular patrimonio total
        System.out.println("\n--- Patrimonio de Titulares ---");
        System.out.println(titular1.getNombre() + " - Patrimonio total: $" + 
                           String.format("%.2f", titular1.calcularPatrimonioTotal()));
        System.out.println(titular2.getNombre() + " - Patrimonio total: $" + 
                           String.format("%.2f", titular2.calcularPatrimonioTotal()));
        System.out.println(titular3.getNombre() + " - Patrimonio total: $" + 
                           String.format("%.2f", titular3.calcularPatrimonioTotal()));
        
        // Modificar relación: remover titular
        System.out.println("\n--- Modificar Relaciones ---");
        System.out.println("Removiendo a Laura de cuenta1:");
        cuenta1.removerTitular(titular3);
        
        cuenta1.mostrarTitulares();
        titular3.mostrarCuentas();
        
        // Demostrar que la clave es parte integral de la cuenta
        System.out.println("\n--- Ciclo de Vida en Composición ---");
        System.out.println("Si cerramos cuenta2, su clave de seguridad también se elimina");
        System.out.println("Cuenta antes de cerrar: " + cuenta2);
        System.out.println("Clave de seguridad: " + cuenta2.getClaveSeguridad());
        
        titular1.removerCuenta(cuenta2);
        titular2.removerCuenta(cuenta2);
        cuenta2 = null; // Simular cierre de cuenta
        
        System.out.println("\nCuenta cerrada. La clave de seguridad ya no existe.");
        System.out.println("Pero los titulares siguen existiendo:");
        System.out.println(titular1);
        System.out.println(titular2);
        
        // Resumen final
        System.out.println("\n=== RESUMEN FINAL ===");
        System.out.println("\nTitulares activos:");
        titular1.mostrarCuentas();
        titular2.mostrarCuentas();
        titular3.mostrarCuentas();
        
        System.out.println("\nCuentas activas:");
        cuenta1.mostrarDetalles();
        cuenta3.mostrarDetalles();
    }
}

// ----- Dependencia de uso -----
// Ejercicio 1 - Reproductor - Canción - Artista
// Clase Artista
public class Artista {
    private String nombre;
    private String genero;
    
    public Artista(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = genero;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    @Override
    public String toString() {
        return "Artista{nombre='" + nombre + "', genero='" + genero + "'}";
    }
}

// Clase Cancion
public class Cancion {
    private String titulo;
    private Artista artista; // Asociación unidireccional
    
    public Cancion(String titulo, Artista artista) {
        this.titulo = titulo;
        this.artista = artista;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public Artista getArtista() {
        return artista;
    }
    
    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    
    @Override
    public String toString() {
        return "Cancion{titulo='" + titulo + "', artista=" + artista.getNombre() + "}";
    }
}

// Clase Reproductor (con DEPENDENCIA DE USO)
public class Reproductor {
    // IMPORTANTE: NO tiene atributo de tipo Cancion
    // Solo usa Cancion como parámetro en métodos
    
    private boolean reproduciendo;
    private int volumen;
    
    public Reproductor() {
        this.reproduciendo = false;
        this.volumen = 50;
    }
    
    // DEPENDENCIA DE USO: recibe Cancion como parámetro
    // pero NO la guarda como atributo
    public void reproducir(Cancion cancion) {
        if (cancion == null) {
            System.out.println("Error: No hay canción para reproducir");
            return;
        }
        
        reproduciendo = true;
        System.out.println("♪ Reproduciendo: \"" + cancion.getTitulo() + "\"");
        System.out.println("   Artista: " + cancion.getArtista().getNombre());
        System.out.println("   Género: " + cancion.getArtista().getGenero());
        System.out.println("   Volumen: " + volumen + "%");
    }
    
    // DEPENDENCIA DE USO: otro método que usa Cancion como parámetro
    public void mostrarInfo(Cancion cancion) {
        if (cancion == null) {
            System.out.println("No hay información disponible");
            return;
        }
        
        System.out.println("\n--- Información de la Canción ---");
        System.out.println("Título: " + cancion.getTitulo());
        System.out.println("Artista: " + cancion.getArtista().getNombre());
        System.out.println("Género: " + cancion.getArtista().getGenero());
    }
    
    public void detener() {
        if (reproduciendo) {
            reproduciendo = false;
            System.out.println("■ Reproducción detenida");
        }
    }
    
    public void ajustarVolumen(int nuevoVolumen) {
        if (nuevoVolumen >= 0 && nuevoVolumen <= 100) {
            this.volumen = nuevoVolumen;
            System.out.println("Volumen ajustado a: " + volumen + "%");
        } else {
            System.out.println("Volumen inválido (debe estar entre 0 y 100)");
        }
    }
    
    public boolean isReproduciendo() {
        return reproduciendo;
    }
    
    public int getVolumen() {
        return volumen;
    }
    
    @Override
    public String toString() {
        return "Reproductor{estado=" + (reproduciendo ? "Reproduciendo" : "Detenido") + 
               ", volumen=" + volumen + "%}";
    }
}

// Clase de prueba
public class TestReproductor {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE REPRODUCTOR MUSICAL ===\n");
        
        // Crear artistas independientes
        System.out.println("--- Creando Artistas ---");
        Artista artista1 = new Artista("Gustavo Cerati", "Rock");
        Artista artista2 = new Artista("Mercedes Sosa", "Folklore");
        Artista artista3 = new Artista("Charly García", "Rock");
        
        System.out.println(artista1);
        System.out.println(artista2);
        System.out.println(artista3);
        
        // Crear canciones (asociación unidireccional con artista)
        System.out.println("\n--- Creando Canciones ---");
        Cancion cancion1 = new Cancion("Crimen", artista1);
        Cancion cancion2 = new Cancion("Alfonsina y el Mar", artista2);
        Cancion cancion3 = new Cancion("Demoliendo Hoteles", artista3);
        Cancion cancion4 = new Cancion("Puente", artista1);
        
        System.out.println(cancion1);
        System.out.println(cancion2);
        System.out.println(cancion3);
        System.out.println(cancion4);
        
        // Crear reproductor
        System.out.println("\n--- Creando Reproductor ---");
        Reproductor reproductor = new Reproductor();
        System.out.println(reproductor);
        
        // DEMOSTRAR DEPENDENCIA DE USO
        System.out.println("\n=== DEMOSTRANDO DEPENDENCIA DE USO ===");
        System.out.println("El Reproductor NO guarda la canción como atributo");
        System.out.println("Solo la usa temporalmente como parámetro en métodos\n");
        
        // Usar el reproductor con diferentes canciones
        System.out.println("--- Reproduciendo Canción 1 ---");
        reproductor.reproducir(cancion1);
        
        System.out.println("\n--- Ajustando Volumen ---");
        reproductor.ajustarVolumen(75);
        
        System.out.println("\n--- Reproduciendo Canción 2 ---");
        reproductor.reproducir(cancion2);
        
        reproductor.detener();
        
        System.out.println("\n--- Reproduciendo Canción 3 ---");
        reproductor.reproducir(cancion3);
        
        System.out.println("\n--- Mostrando Info de Canción 4 ---");
        reproductor.mostrarInfo(cancion4);
        
        reproductor.detener();
        
        // DEMOSTRAR que el reproductor NO mantiene referencia a la canción
        System.out.println("\n=== CARACTERÍSTICA CLAVE DE LA DEPENDENCIA ===");
        System.out.println("El reproductor puede usar CUALQUIER canción en cualquier momento");
        System.out.println("sin necesidad de guardarla como atributo:");
        
        System.out.println("\nReproduciendo canción1:");
        reproductor.reproducir(cancion1);
        
        System.out.println("\nInmediatamente reproduciendo canción3:");
        reproductor.reproducir(cancion3);
        
        System.out.println("\nAhora reproduciendo canción2:");
        reproductor.reproducir(cancion2);
        
        System.out.println("\n¡El reproductor usa las canciones pero no las almacena!");
        
        // Comparar con una relación de asociación (si existiera)
        System.out.println("\n=== DIFERENCIA CON ASOCIACIÓN ===");
        System.out.println("Si fuera ASOCIACIÓN:");
        System.out.println("  - El reproductor tendría un atributo: private Cancion cancionActual;");
        System.out.println("  - Tendría métodos: getCancionActual(), setCancionActual()");
        System.out.println("  - La canción estaría 'vinculada' al reproductor");
        System.out.println("\nComo es DEPENDENCIA DE USO:");
        System.out.println("  - El reproductor NO tiene atributo de tipo Cancion");
        System.out.println("  - Solo recibe canciones como parámetros");
        System.out.println("  - La relación es temporal (solo durante la ejecución del método)");
        System.out.println("  - Más flexible: puede trabajar con cualquier canción sin compromiso");
        
        // Probar con null para demostrar la independencia
        System.out.println("\n--- Probando con canción null ---");
        reproductor.reproducir(null);
        
        // Resumen
        System.out.println("\n=== RESUMEN ===");
        System.out.println("Artistas creados: 3");
        System.out.println("Canciones creadas: 4");
        System.out.println("Reproductor: " + reproductor);
        System.out.println("\nRelaciones:");
        System.out.println("• Canción → Artista: Asociación unidireccional (la canción guarda el artista)");
        System.out.println("• Reproductor → Canción: Dependencia de uso (no guarda, solo usa como parámetro)");
    }
}

// Ejercicio 2 - Impuesto - Contribuyente - Calculadora
// Clase Contribuyente
public class Contribuyente {
    private String nombre;
    private String cuil;
    
    public Contribuyente(String nombre, String cuil) {
        this.nombre = nombre;
        this.cuil = cuil;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCuil() {
        return cuil;
    }
    
    public void setCuil(String cuil) {
        this.cuil = cuil;
    }
    
    @Override
    public String toString() {
        return "Contribuyente{nombre='" + nombre + "', cuil='" + cuil + "'}";
    }
}

// Clase Impuesto
public class Impuesto {
    private double monto;
    private Contribuyente contribuyente; // Asociación unidireccional
    private String tipo; // IVA, Ganancias, Monotributo, etc.
    private String periodo; // 01/2024, 02/2024, etc.
    
    public Impuesto(double monto, Contribuyente contribuyente, String tipo, String periodo) {
        this.monto = monto;
        this.contribuyente = contribuyente;
        this.tipo = tipo;
        this.periodo = periodo;
    }
    
    public double getMonto() {
        return monto;
    }
    
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public Contribuyente getContribuyente() {
        return contribuyente;
    }
    
    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getPeriodo() {
        return periodo;
    }
    
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    @Override
    public String toString() {
        return "Impuesto{tipo='" + tipo + "', monto=$" + String.format("%.2f", monto) + 
               ", periodo='" + periodo + "', contribuyente=" + contribuyente.getNombre() + "}";
    }
}

// Clase Calculadora (con DEPENDENCIA DE USO)
public class Calculadora {
    // IMPORTANTE: NO tiene atributo de tipo Impuesto
    // Solo usa Impuesto como parámetro en métodos
    
    private static final double IVA_RATE = 0.21;
    private static final double RECARGO_MORA = 0.05;
    
    public Calculadora() {
        // No necesita inicializar nada relacionado con Impuesto
    }
    
    // DEPENDENCIA DE USO: recibe Impuesto como parámetro
    // pero NO lo guarda como atributo
    public void calcular(Impuesto impuesto) {
        if (impuesto == null) {
            System.out.println("Error: No hay impuesto para calcular");
            return;
        }
        
        System.out.println("\n=== CÁLCULO DE IMPUESTO ===");
        System.out.println("Tipo: " + impuesto.getTipo());
        System.out.println("Período: " + impuesto.getPeriodo());
        System.out.println("Contribuyente: " + impuesto.getContribuyente().getNombre());
        System.out.println("CUIL: " + impuesto.getContribuyente().getCuil());
        System.out.println("Monto Base: $" + String.format("%.2f", impuesto.getMonto()));
        
        // Realizar cálculos
        double montoTotal = impuesto.getMonto();
        System.out.println("TOTAL A PAGAR: $" + String.format("%.2f", montoTotal));
    }
    
    // DEPENDENCIA DE USO: otro método que usa Impuesto como parámetro
    public double calcularConDescuento(Impuesto impuesto, double porcentajeDescuento) {
        if (impuesto == null) {
            System.out.println("Error: Impuesto no válido");
            return 0;
        }
        
        double descuento = impuesto.getMonto() * (porcentajeDescuento / 100);
        double montoFinal = impuesto.getMonto() - descuento;
        
        System.out.println("\n--- Cálculo con Descuento ---");
        System.out.println("Monto Original: $" + String.format("%.2f", impuesto.getMonto()));
        System.out.println("Descuento (" + porcentajeDescuento + "%): -$" + String.format("%.2f", descuento));
        System.out.println("Monto Final: $" + String.format("%.2f", montoFinal));
        
        return montoFinal;
    }
    
    // DEPENDENCIA DE USO: método para calcular recargo por mora
    public double calcularConRecargo(Impuesto impuesto, int diasVencidos) {
        if (impuesto == null || diasVencidos <= 0) {
            System.out.println("Error: Datos inválidos");
            return 0;
        }
        
        double recargo = impuesto.getMonto() * RECARGO_MORA * (diasVencidos / 30.0);
        double montoFinal = impuesto.getMonto() + recargo;
        
        System.out.println("\n--- Cálculo con Recargo por Mora ---");
        System.out.println("Monto Original: $" + String.format("%.2f", impuesto.getMonto()));
        System.out.println("Días vencidos: " + diasVencidos);
        System.out.println("Recargo (" + (RECARGO_MORA * 100) + "% mensual): +$" + String.format("%.2f", recargo));
        System.out.println("Monto Final: $" + String.format("%.2f", montoFinal));
        
        return montoFinal;
    }
    
    // DEPENDENCIA DE USO: método para generar reporte
    public void generarReporte(Impuesto impuesto) {
        if (impuesto == null) {
            System.out.println("Error: No se puede generar reporte");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║        REPORTE DE IMPUESTO                 ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ Tipo: " + String.format("%-36s", impuesto.getTipo()) + " ║");
        System.out.println("║ Período: " + String.format("%-33s", impuesto.getPeriodo()) + " ║");
        System.out.println("║ Contribuyente: " + String.format("%-27s", impuesto.getContribuyente().getNombre()) + " ║");
        System.out.println("║ CUIL: " + String.format("%-36s", impuesto.getContribuyente().getCuil()) + " ║");
        System.out.println("║ Monto: $" + String.format("%-34.2f", impuesto.getMonto()) + " ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
    
    // DEPENDENCIA DE USO: comparar dos impuestos
    public void compararImpuestos(Impuesto impuesto1, Impuesto impuesto2) {
        if (impuesto1 == null || impuesto2 == null) {
            System.out.println("Error: Se necesitan dos impuestos válidos");
            return;
        }
        
        System.out.println("\n=== COMPARACIÓN DE IMPUESTOS ===");
        System.out.println("Impuesto 1: " + impuesto1.getTipo() + " - $" + String.format("%.2f", impuesto1.getMonto()));
        System.out.println("Impuesto 2: " + impuesto2.getTipo() + " - $" + String.format("%.2f", impuesto2.getMonto()));
        
        double diferencia = Math.abs(impuesto1.getMonto() - impuesto2.getMonto());
        System.out.println("Diferencia: $" + String.format("%.2f", diferencia));
        
        if (impuesto1.getMonto() > impuesto2.getMonto()) {
            System.out.println("El " + impuesto1.getTipo() + " es mayor");
        } else if (impuesto1.getMonto() < impuesto2.getMonto()) {
            System.out.println("El " + impuesto2.getTipo() + " es mayor");
        } else {
            System.out.println("Ambos impuestos tienen el mismo monto");
        }
    }
    
    @Override
    public String toString() {
        return "Calculadora{lista para procesar impuestos}";
    }
}

// Clase de prueba
public class TestImpuesto {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CÁLCULO DE IMPUESTOS ===\n");
        
        // Crear contribuyentes independientes
        System.out.println("--- Creando Contribuyentes ---");
        Contribuyente contrib1 = new Contribuyente("Juan Rodríguez", "20-12345678-9");
        Contribuyente contrib2 = new Contribuyente("María Fernández", "27-98765432-1");
        Contribuyente contrib3 = new Contribuyente("Carlos López S.A.", "30-55555555-5");
        
        System.out.println(contrib1);
        System.out.println(contrib2);
        System.out.println(contrib3);
        
        // Crear impuestos (asociación unidireccional con contribuyente)
        System.out.println("\n--- Creando Impuestos ---");
        Impuesto impuesto1 = new Impuesto(15000.0, contrib1, "Monotributo", "03/2024");
        Impuesto impuesto2 = new Impuesto(45000.0, contrib2, "Ganancias", "2023");
        Impuesto impuesto3 = new Impuesto(120000.0, contrib3, "IVA", "02/2024");
        Impuesto impuesto4 = new Impuesto(8500.0, contrib1, "Ingresos Brutos", "01/2024");
        
        System.out.println(impuesto1);
        System.out.println(impuesto2);
        System.out.println(impuesto3);
        System.out.println(impuesto4);
        
        // Crear calculadora
        System.out.println("\n--- Creando Calculadora ---");
        Calculadora calculadora = new Calculadora();
        System.out.println(calculadora);
        
        // DEMOSTRAR DEPENDENCIA DE USO
        System.out.println("\n=== DEMOSTRANDO DEPENDENCIA DE USO ===");
        System.out.println("La Calculadora NO guarda el impuesto como atributo");
        System.out.println("Solo lo usa temporalmente como parámetro en métodos\n");
        
        // Usar la calculadora con diferentes impuestos
        System.out.println("--- Calculando Impuesto 1 ---");
        calculadora.calcular(impuesto1);
        
        System.out.println("\n--- Calculando Impuesto 2 ---");
        calculadora.calcular(impuesto2);
        
        System.out.println("\n--- Calculando Impuesto 3 ---");
        calculadora.calcular(impuesto3);
        
        // Calcular con descuento
        System.out.println("\n--- Aplicando Descuento ---");
        calculadora.calcularConDescuento(impuesto1, 10);
        
        // Calcular con recargo por mora
        System.out.println("\n--- Aplicando Recargo por Mora ---");
        calculadora.calcularConRecargo(impuesto2, 45);
        
        // Generar reportes
        System.out.println("\n--- Generando Reportes ---");
        calculadora.generarReporte(impuesto1);
        calculadora.generarReporte(impuesto3);
        
        // Comparar impuestos
        calculadora.compararImpuestos(impuesto1, impuesto4);
        calculadora.compararImpuestos(impuesto2, impuesto3);
        
        // DEMOSTRAR que la calculadora NO mantiene referencia al impuesto
        System.out.println("\n=== CARACTERÍSTICA CLAVE DE LA DEPENDENCIA ===");
        System.out.println("La calculadora puede procesar CUALQUIER impuesto en cualquier momento");
        System.out.println("sin necesidad de guardarlo como atributo:");
        
        System.out.println("\nProcesando impuesto1:");
        calculadora.calcular(impuesto1);
        
        System.out.println("\nInmediatamente procesando impuesto3:");
        calculadora.calcular(impuesto3);
        
        System.out.println("\nAhora procesando impuesto2:");
        calculadora.calcular(impuesto2);
        
        System.out.println("\n¡La calculadora procesa los impuestos pero no los almacena!");
        
        // Comparar con una relación de asociación (si existiera)
        System.out.println("\n=== DIFERENCIA CON ASOCIACIÓN ===");
        System.out.println("Si fuera ASOCIACIÓN:");
        System.out.println("  - La calculadora tendría un atributo: private Impuesto impuestoActual;");
        System.out.println("  - Tendría métodos: getImpuesto(), setImpuesto()");
        System.out.println("  - El impuesto estaría 'vinculado' a la calculadora");
        System.out.println("\nComo es DEPENDENCIA DE USO:");
        System.out.println("  - La calculadora NO tiene atributo de tipo Impuesto");
        System.out.println("  - Solo recibe impuestos como parámetros");
        System.out.println("  - La relación es temporal (solo durante la ejecución del método)");
        System.out.println("  - Más flexible: puede procesar cualquier impuesto sin compromiso");
        System.out.println("  - Bajo acoplamiento: la calculadora es una herramienta reutilizable");
        
        // Probar con null para demostrar la independencia
        System.out.println("\n--- Probando con impuesto null ---");
        calculadora.calcular(null);
        calculadora.generarReporte(null);
        
        // Resumen
        System.out.println("\n=== RESUMEN ===");
        System.out.println("Contribuyentes creados: 3");
        System.out.println("Impuestos creados: 4");
        System.out.println("Calculadora: " + calculadora);
        System.out.println("\nRelaciones:");
        System.out.println("• Impuesto → Contribuyente: Asociación unidireccional (el impuesto guarda el contribuyente)");
        System.out.println("• Calculadora → Impuesto: Dependencia de uso (no guarda, solo usa como parámetro)");
        
        System.out.println("\nVentajas de la Dependencia de Uso:");
        System.out.println("✓ Bajo acoplamiento");
        System.out.println("✓ Alta reutilización");
        System.out.println("✓ Fácil de probar (unit testing)");
        System.out.println("✓ No mantiene estado innecesario");
    }
}

// ----- Dependencia de creacion -----
// Ejercicio 1 - GeneradorQR - Usuario - CódigoQR
// Clase Usuario
public class Usuario {
    private String nombre;
    private String email;
    
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Usuario{nombre='" + nombre + "', email='" + email + "'}";
    }
}

// Clase CodigoQR
import java.util.Date;
import java.text.SimpleDateFormat;

public class CodigoQR {
    private String valor;
    private Usuario usuario; // Asociación unidireccional
    private Date fechaCreacion;
    private String id;
    
    public CodigoQR(String valor, Usuario usuario) {
        this.valor = valor;
        this.usuario = usuario;
        this.fechaCreacion = new Date();
        this.id = generarId();
    }
    
    private String generarId() {
        return "QR-" + System.currentTimeMillis();
    }
    
    public String getValor() {
        return valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    
    public String getId() {
        return id;
    }
    
    public void mostrarDetalles() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║           CÓDIGO QR                        ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ ID: " + String.format("%-38s", id) + " ║");
        System.out.println("║ Valor: " + String.format("%-35s", valor) + " ║");
        System.out.println("║ Usuario: " + String.format("%-33s", usuario.getNombre()) + " ║");
        System.out.println("║ Email: " + String.format("%-35s", usuario.getEmail()) + " ║");
        System.out.println("║ Creado: " + String.format("%-32s", sdf.format(fechaCreacion)) + " ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
    
    public String generarRepresentacionASCII() {
        // Simulación simplificada de QR en ASCII
        StringBuilder qr = new StringBuilder();
        qr.append("█████████████████████\n");
        qr.append("█ ▄▄▄▄▄ █▀ █ ▄▄▄▄▄ █\n");
        qr.append("█ █   █ █▄▄█ █   █ █\n");
        qr.append("█ █▄▄▄█ █ ▀ █ █▄▄▄█ █\n");
        qr.append("█▄▄▄▄▄▄▄█▀▄▀█▄▄▄▄▄▄▄█\n");
        qr.append("█  ▄▀▄ ▄ █ █▀▄ ▄▀  ▄█\n");
        qr.append("██▄▄ █ ▄▀ ▀ ▀▄ ▀ ▄ ██\n");
        qr.append("█ ▄▄▄▄▄ █▀▀▄█ ▄ ▀▄ ██\n");
        qr.append("█ █   █ █  ▀▄▀█▀ █▀██\n");
        qr.append("█ █▄▄▄█ █ ▄▀  ▄█▄▀▄██\n");
        qr.append("█▄▄▄▄▄▄▄█▄███▄█▄█▄▄██\n");
        return qr.toString();
    }
    
    @Override
    public String toString() {
        return "CodigoQR{id='" + id + "', valor='" + valor + 
               "', usuario=" + usuario.getNombre() + "}";
    }
}

// Clase GeneradorQR (con DEPENDENCIA DE CREACIÓN)
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class GeneradorQR {
    // IMPORTANTE: NO tiene atributo de tipo CodigoQR
    // Crea objetos CodigoQR dentro de métodos pero NO los guarda
    
    private int contadorGenerados;
    
    public GeneradorQR() {
        this.contadorGenerados = 0;
    }
    
    // DEPENDENCIA DE CREACIÓN: crea un CodigoQR dentro del método
    // pero NO lo guarda como atributo, solo lo retorna
    public CodigoQR generar(String valor, Usuario usuario) {
        if (valor == null || valor.trim().isEmpty()) {
            System.out.println("Error: El valor no puede estar vacío");
            return null;
        }
        
        if (usuario == null) {
            System.out.println("Error: Se requiere un usuario");
            return null;
        }
        
        // CREA el objeto CodigoQR
        CodigoQR codigoQR = new CodigoQR(valor, usuario);
        
        contadorGenerados++;
        
        System.out.println("✓ Código QR generado exitosamente");
        System.out.println("  ID: " + codigoQR.getId());
        System.out.println("  Para: " + usuario.getNombre());
        
        // RETORNA el objeto pero NO lo guarda
        return codigoQR;
    }
    
    // DEPENDENCIA DE CREACIÓN: crea CodigoQR con información adicional
    public CodigoQR generarConFecha(String valor, Usuario usuario) {
        if (valor == null || usuario == null) {
            System.out.println("Error: Parámetros inválidos");
            return null;
        }
        
        String valorConFecha = valor + "_" + new Date().getTime();
        
        // CREA el objeto
        CodigoQR codigoQR = new CodigoQR(valorConFecha, usuario);
        
        contadorGenerados++;
        
        System.out.println("✓ Código QR con timestamp generado");
        
        // RETORNA sin guardar
        return codigoQR;
    }
    
    // DEPENDENCIA DE CREACIÓN: crea múltiples CodigoQR
    public List<CodigoQR> generarMultiples(List<String> valores, Usuario usuario) {
        if (valores == null || valores.isEmpty() || usuario == null) {
            System.out.println("Error: Parámetros inválidos");
            return new ArrayList<>();
        }
        
        List<CodigoQR> codigosGenerados = new ArrayList<>();
        
        System.out.println("\n--- Generando múltiples códigos QR ---");
        
        for (String valor : valores) {
            // CREA cada CodigoQR
            CodigoQR codigo = new CodigoQR(valor, usuario);
            codigosGenerados.add(codigo);
            contadorGenerados++;
            
            System.out.println("  ✓ QR creado: " + codigo.getId());
        }
        
        System.out.println("Total generados: " + codigosGenerados.size());
        
        // RETORNA la lista sin guardar los objetos
        return codigosGenerados;
    }
    
    // DEPENDENCIA DE CREACIÓN: genera QR para URL
    public CodigoQR generarParaURL(String url, Usuario usuario) {
        if (url == null || usuario == null) {
            return null;
        }
        
        String valorQR = "URL:" + url;
        
        // CREA el objeto
        CodigoQR codigoQR = new CodigoQR(valorQR, usuario);
        
        contadorGenerados++;
        
        System.out.println("✓ Código QR para URL generado");
        System.out.println("  URL: " + url);
        
        // RETORNA sin guardar
        return codigoQR;
    }
    
    // DEPENDENCIA DE CREACIÓN: genera QR para contacto
    public CodigoQR generarParaContacto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        
        String valorContacto = "VCARD:" + usuario.getNombre() + ":" + usuario.getEmail();
        
        // CREA el objeto
        CodigoQR codigoQR = new CodigoQR(valorContacto, usuario);
        
        contadorGenerados++;
        
        System.out.println("✓ Código QR de contacto generado");
        
        // RETORNA sin guardar
        return codigoQR;
    }
    
    public void mostrarEstadisticas() {
        System.out.println("\n=== Estadísticas del Generador ===");
        System.out.println("Total de códigos QR generados: " + contadorGenerados);
    }
    
    public int getContadorGenerados() {
        return contadorGenerados;
    }
    
    @Override
    public String toString() {
        return "GeneradorQR{códigos generados=" + contadorGenerados + "}";
    }
}

// Clase de prueba
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TestGeneradorQR {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA GENERADOR DE CÓDIGOS QR ===\n");
        
        // Crear usuarios independientes
        System.out.println("--- Creando Usuarios ---");
        Usuario usuario1 = new Usuario("Ana Martínez", "ana@email.com");
        Usuario usuario2 = new Usuario("Pedro Gómez", "pedro@email.com");
        Usuario usuario3 = new Usuario("Laura Silva", "laura@email.com");
        
        System.out.println(usuario1);
        System.out.println(usuario2);
        System.out.println(usuario3);
        
        // Crear generador
        System.out.println("\n--- Creando Generador QR ---");
        GeneradorQR generador = new GeneradorQR();
        System.out.println(generador);
        
        // DEMOSTRAR DEPENDENCIA DE CREACIÓN
        System.out.println("\n=== DEMOSTRANDO DEPENDENCIA DE CREACIÓN ===");
        System.out.println("El GeneradorQR CREA objetos CodigoQR dentro de métodos");
        System.out.println("pero NO los guarda como atributo\n");
        
        // Generar códigos QR (el generador crea pero no guarda)
        System.out.println("--- Generando Códigos QR ---");
        CodigoQR qr1 = generador.generar("https://www.ejemplo.com", usuario1);
        CodigoQR qr2 = generador.generar("Ticket#12345", usuario2);
        CodigoQR qr3 = generador.generarConFecha("Evento2024", usuario3);
        
        // Los códigos QR existen independientemente del generador
        System.out.println("\n--- Códigos QR Creados ---");
        System.out.println(qr1);
        System.out.println(qr2);
        System.out.println(qr3);
        
        // Mostrar detalles de los QR creados
        qr1.mostrarDetalles();
        qr2.mostrarDetalles();
        
        // Generar QR para URL
        System.out.println("\n--- Generando QR para URL ---");
        CodigoQR qrURL = generador.generarParaURL("https://github.com/usuario", usuario1);
        qrURL.mostrarDetalles();
        
        // Generar QR de contacto
        System.out.println("\n--- Generando QR de Contacto ---");
        CodigoQR qrContacto = generador.generarParaContacto(usuario2);
        qrContacto.mostrarDetalles();
        
        // Generar múltiples QR
        System.out.println("\n--- Generando Múltiples QR ---");
        List<String> valores = Arrays.asList(
            "Producto#001",
            "Producto#002",
            "Producto#003",
            "Producto#004"
        );
        
        List<CodigoQR> codigosMultiples = generador.generarMultiples(valores, usuario3);
        
        System.out.println("\nCódigos generados:");
        for (CodigoQR qr : codigosMultiples) {
            System.out.println("  - " + qr);
        }
        
        // Mostrar representación ASCII de un QR
        System.out.println("\n--- Representación ASCII del QR ---");
        System.out.println(qr1.generarRepresentacionASCII());
        
        // DEMOSTRAR que el generador NO guarda los códigos
        System.out.println("\n=== CARACTERÍSTICA CLAVE DE LA DEPENDENCIA DE CREACIÓN ===");
        System.out.println("El generador CREA códigos QR pero NO los guarda:");
        System.out.println("✓ Los objetos CodigoQR se crean dentro de los métodos");
        System.out.println("✓ Se retornan al código que llamó al método");
        System.out.println("✓ El generador NO mantiene referencias a ellos");
        System.out.println("✓ Solo cuenta cuántos ha generado (contador simple)");
        
        generador.mostrarEstadisticas();
        
        // Crear lista para almacenar QRs (esto lo hace el cliente, no el generador)
        System.out.println("\n--- El Cliente Decide Qué Hacer con los QR ---");
        List<CodigoQR> misCodigosQR = new ArrayList<>();
        
        System.out.println("Generando y almacenando QRs (el CLIENTE los guarda):");
        misCodigosQR.add(generador.generar("Dato1", usuario1));
        misCodigosQR.add(generador.generar("Dato2", usuario1));
        misCodigosQR.add(generador.generar("Dato3", usuario2));
        
        System.out.println("\nMis códigos QR almacenados por el cliente:");
        for (CodigoQR qr : misCodigosQR) {
            System.out.println("  - " + qr);
        }
        
        // Comparar con otras relaciones
        System.out.println("\n=== COMPARACIÓN CON OTRAS RELACIONES ===");
        System.out.println("\nSi fuera COMPOSICIÓN:");
        System.out.println("  - El generador tendría: private List<CodigoQR> codigosGenerados;");
        System.out.println("  - Controlaría el ciclo de vida de los códigos");
        System.out.println("  - Si se destruye el generador, se destruyen los códigos");
        
        System.out.println("\nSi fuera AGREGACIÓN:");
        System.out.println("  - El generador tendría: private List<CodigoQR> codigosGestionados;");
        System.out.println("  - Guardaría referencias pero no controlaría el ciclo de vida");
        
        System.out.println("\nSi fuera DEPENDENCIA DE USO:");
        System.out.println("  - El generador recibiría CodigoQR como parámetro");
        System.out.println("  - No crearía ni guardaría códigos");
        
        System.out.println("\nComo es DEPENDENCIA DE CREACIÓN:");
        System.out.println("  - El generador CREA objetos CodigoQR");
        System.out.println("  - NO los guarda como atributos");
        System.out.println("  - Los retorna inmediatamente");
        System.out.println("  - Es una FÁBRICA (Factory Pattern)");
        System.out.println("  - Responsabilidad única: crear objetos");
        
        // Probar con valores inválidos
        System.out.println("\n--- Validaciones ---");
        generador.generar("", usuario1);
        generador.generar("Valor", null);
        
        // Resumen final
        System.out.println("\n=== RESUMEN FINAL ===");
        System.out.println("Usuarios creados: 3");
        generador.mostrarEstadisticas();
        System.out.println(generador);
        
        System.out.println("\nRelaciones:");
        System.out.println("• CodigoQR → Usuario: Asociación unidireccional");
        System.out.println("  (el código QR guarda al usuario para el que fue generado)");
        System.out.println("• GeneradorQR → CodigoQR: Dependencia de creación");
        System.out.println("  (el generador crea códigos pero no los guarda)");
        
        System.out.println("\nPatrón de Diseño:");
        System.out.println("✓ El GeneradorQR implementa el patrón FACTORY");
        System.out.println("✓ Responsabilidad única: crear objetos CodigoQR");
        System.out.println("✓ No mantiene estado de los objetos creados");
        System.out.println("✓ Bajo acoplamiento y alta cohesión");
    }
}