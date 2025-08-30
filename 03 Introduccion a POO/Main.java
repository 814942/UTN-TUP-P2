public class Main {
    Estudiante estudiante = new Estudiante();
    estudiante.mostrarInfo();
    estudiante.subirCalificacion(10);
    estudiante.bajarCalificacion(5);

    Mascota mascota = new Mascota();
    mascota.nombre = "Fido";
    mascota.especie = "Perro";
    mascota.edad = 3;
    mascota.mostrarInfo();
    mascota.cumplirAnios();

    Libro libro = new Libro();
    libro.setTitulo("1984");
    libro.setAutor("George Orwell");
    libro.setAnioPublicacion(-1949); // Inválido
    libro.setAnioPublicacion(1949);  // Válido
    libro.mostrarInfo();

    Gallina gallina1 = new Gallina();
    gallina1.idGallina = 1;
    gallina1.edad = 2;
    gallina1.huevosPuestos = 5;
    gallina1.ponerHuevo();
    gallina1.envejecer();
    gallina1.mostrarEstado();

    Gallina gallina2 = new Gallina();
    gallina2.idGallina = 2;
    gallina2.edad = 1;
    gallina2.huevosPuestos = 3;
    gallina2.ponerHuevo();
    gallina2.envejecer();
    gallina2.mostrarEstado();

    NaveEspacial nave = new NaveEspacial();
    nave.nombre = "Enterprise";
    nave.combustible = 50;
    nave.mostrarEstado();
    nave.despegar();
    nave.avanzar(30); // Intentar avanzar sin suficiente combustible
    nave.recargarCombustible(40); // Recargar combustible
    nave.avanzar(30); // Avanzar correctamente
    nave.mostrarEstado();
}
