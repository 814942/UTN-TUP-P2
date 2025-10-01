import java.util.Random;

public class Empleado {
    int id; // Identificador único del empleado.
    String nombre; // Nombre completo.
    String puesto; // Cargo que desempeña.
    double salario; // Salario actual.
    static int totalEmpleados; // Contador global de empleados creados
    final static int SALARIO_MINIMO = 30000; // Salario mínimo permitido

    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        actualizarSalario(salario);
        totalEmpleados++;
    }

    public Empleado(String nombre, String puesto) {
        Random rand = new Random();
        this.id = rand.nextInt(1000);
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = SALARIO_MINIMO;
        totalEmpleados++;
    }

    public void actualizarSalario(double nuevoSalario) {
        if (nuevoSalario >= SALARIO_MINIMO) {
            this.salario = nuevoSalario;
        } else {
            System.out.println("Error: El salario no puede ser menor al salario mínimo.");
        }
    }

    public void actualizarSalario(int porcentaje) {
        double nuevoSalario = this.salario + (this.salario * porcentaje / 100);
        this.actualizarSalario(nuevoSalario);
    }

    @Override
    public String toString() {
        return "Empleado: " +
                "id: " + id +
                ", nombre: '" + nombre + '\'' +
                ", puesto: '" + puesto + '\'' +
                ", salario: " + salario;
    }

    static void mostrarTotalEmpleados() {
        System.out.println("Total de empleados creados: " + totalEmpleados);
        this.id = 5; // Error: no se puede usar 'this' en un contexto estático
    }
}
