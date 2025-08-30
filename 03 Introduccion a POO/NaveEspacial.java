public class NaveEspacial {
    String nombre;
    double combustible;
    final double LIMITE_COMBUSTIBLE = 100.0;

    public void despegar() {
        if (combustible >= 10) {
            combustible -= 10;
            System.out.println(nombre + " ha despegado. Combustible restante: " + combustible);
        } else {
            System.out.println("No hay suficiente combustible para despegar.");
        }
    }

    public void avanzar(double distancia) {
        double consumo = distancia * 0.5;
        if (combustible >= consumo) {
            combustible -= consumo;
            System.out.println(nombre + " ha avanzado " + distancia + " unidades. Combustible restante: " + combustible);
        }
        else {
            System.out.println("No hay suficiente combustible para avanzar esa distancia.");
        }
    }

    public void recargarCombustible(double cantidad) {
        if (combustible + cantidad <= LIMITE_COMBUSTIBLE) {
            combustible += cantidad;
            System.out.println(nombre + " ha recargado " + cantidad + " unidades de combustible. Combustible total: " + combustible);
        } else {
            System.out.println("No se puede recargar tanto combustible. Límite alcanzado.");
        }
    }

    public void mostrarEstado() {
        System.out.println("Nave: " + nombre);
        System.out.println("Combustible: " + combustible + "/" + LIMITE_COMBUSTIBLE);
    }
}
