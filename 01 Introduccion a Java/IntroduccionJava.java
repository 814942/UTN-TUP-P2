import java.util.Scanner;

public class IntroduccionJava {
    public static void main(String[] args) {
        holaJava();
        imprimirDatos();
        solicitarDatos();
        operacionesBasicas();
        mostrarDatos();
        divisionEnteros();
    }
    
    // Ejercicio 2
    public static void holaJava() {
        System.out.println("¡Hola, Java!");
    }

    // Ejercicio 3
    public static void imprimirDatos() {
        String nombre = "Juan";
        int edad = 25;
        double altura = 1.75;
        boolean estudiante = true;
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura);
        System.out.println("Estudiante: " + estudiante);
    }

    // Ejercicio 4
    public static void solicitarDatos() {
        Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();
        System.out.println("Nombre: " + nombre + "Edad: " + edad);
        scanner.close();
    }

    // Ejercicio 5
    public static void operacionesBasicas() {
        Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        int num1 = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int num2 = scanner.nextInt();
        System.out.println("Suma: " + (num1 + num2));
        System.out.println("Resta: " + (num1 - num2));
        System.out.println("Multiplicación: " + (num1 * num2));
        if (num2 != 0) {
            System.out.println("División: " + ((double) num1 / num2));
        }
        else {
            System.out.println("División: No se puede dividir por cero.");
        }
        scanner.close();
    }

    // Ejercicio 6
    public static void mostrarDatos() {
        System.out.println("Nombre: Juan Pérez\nEdad: 30 años\nDirección: \"Calle Falsa 123\"");
    }

    // Ejercicio 7
    public static void divisionEnteros() {
        Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Ingrese el primer número entero: ");
        int num1 = scanner.nextInt();
        System.out.print("Ingrese el segundo número entero: ");
        int num2 = scanner.nextInt();
        System.out.println("División entera: " + num1 / num2);

        System.out.print("Ingrese otro número entero: ");
        double num3 = scanner.nextInt();
        System.out.print("Ingrese un número entero mas: ");
        double num4 = scanner.nextInt();
        System.out.println("División decimal: " + num3 / num4);
        scanner.close();
    }
}
