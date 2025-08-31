public class Main {
    public static void main(String[] args) {
        Empleado emp1 = new Empleado(1, "Ana Perez", "Desarrolladora", 45000);
        Empleado emp2 = new Empleado("Luis Gomez", "Diseñador");
        System.out.println("Empleado 1 creado: " + emp1);
        System.out.println("Empleado 2 creado: " + emp2);
        Empleado.mostrarTotalEmpleados();
    }
}
