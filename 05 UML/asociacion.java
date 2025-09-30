// Asociación Unidireccional
// Definición: Una clase contiene una referencia a otra, pero la otra no tiene conocimiento de esta.
// Implementación: Se establece mediante un setter desde el main.

public class Tutor {
    private String nombre;
    public Tutor(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}

public class Alumno {
    private String nombre;
    private Tutor tutor;
    public Alumno(String nombre) {
        this.nombre = nombre;
    }
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    public void mostrar() {
        System.out.println("Alumno: " + nombre + " - Tutor: " +
        tutor.getNombre());
    }
}

public class Main {
    public static void main(String[] args) {
        Tutor tutor = new Tutor("Prof. Gómez");
        Alumno alumno = new Alumno("Lucía");
        alumno.setTutor(tutor);
        alumno.mostrar();
    }
}

// Agregación
// Definición: Una clase está compuesta por otra, pero esta puede existir por separado. Hay una relación de pertenencia flexible.
// Implementación: Se pasa la instancia como parámetro en el constructor.

public class Profesor {
    private String nombre;
    public Profesor(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}
public class Curso {
    private String nombre;
    private Profesor profesor;
    public Curso(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
    }
    public void mostrar() {
        System.out.println("Curso: " + nombre + " - Profesor: " +
        profesor.getNombre());
    }
}
public class Main {
    public static void main(String[] args) {
        Profesor profe = new Profesor("Fernández");
        Curso curso = new Curso("Matemática", profe);
        curso.mostrar();
    }
}

// Composición
//  Definición: Una clase posee y controla el ciclo de vida de la otra. Si el "todo" se destruye, las partes también.
//  Implementación: Se crea internamente la instancia a través de parámetros primitivos del constructor.

public class Foto {
    private String url;
    public Foto(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }
}
public class Pasaporte {
    private String numero;
    private Foto foto;
    public Pasaporte(String numero, String urlFoto) {
        this.numero = numero;
        this.foto = new Foto(urlFoto);
    }
    public void mostrar() {
        System.out.println("Pasaporte: " + numero + " - Foto: " +
        foto.getUrl());
    }
}

public class Main {
    public static void main(String[] args) {
        Pasaporte pasaporte = new Pasaporte("A123456", "foto.jpg");
        pasaporte.mostrar();
    }
}

// Tipo de relación    || Dirección        || Fortaleza    || Ciclo de vida compartido || Implementación recomendada
// ----------------------------------------------------------------------------------------------------------------------- 
// Asociación          || Unidireccional   || Débil        || No                       || Setter en el main
// Agregación          || Unidireccional   || Medio        || No                       || Constructor con objeto externo
// Composición         || Unidireccional   || Fuerte       || Sí                       || Constructor con datos primitivos
// Asociación          || Bidireccional    || Medio        || Parcialmente compartido  || Setters sincronizados