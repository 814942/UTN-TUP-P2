import java.util.Scanner;

public class Main {
    public static final double descuentoEspecial = 0.10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        esBisiesto();
        mayorDeTresNumeros();
        clasificacionEdad();
        calculadoraDeDescuentos();
        sumaDePares();
        contadorDeNumeros();
        validadorDeNotas();
        precioFinal();
        manipularPrecios();
        manipularPreciosRecursivo();

        // Ejercicio 9 - Cálculo de Precio Final con Impuesto y Descuento (versión alternativa)
        System.out.println("Ingrese el precio del producto: ");
        double precioBase = scanner.nextDouble();
        System.out.println("Ingrese el peso del paquete en kg: ");
        double peso = scanner.nextDouble();
        System.out.println("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = scanner.next();
        double costoEnvio = calcularCostoEnvio(peso, zona);
        calcularTotalCompra(precioBase, costoEnvio);

        // Ejercicio 10 - Actualización de Stock
        System.out.println("Ingrese el stock actual del producto: ");
        int stock = scanner.nextInt();
        System.out.println("Ingrese la cantidad vendida: ");
        int cantidadVendida = scanner.nextInt();
        System.out.println("Ingrese la cantidad recibida: ");
        int cantidadRecibida = scanner.nextInt();
        
        actualizarStock(stock, cantidadVendida, cantidadRecibida);

        // Ejercicio 11 - Cálculo de Descuento Especial
        System.out.println("Ingrese el precio del producto para calcular el descuento especial: ");
        double precioProducto = scanner.nextDouble();
        calcularDescuentoEspecial(precioProducto);

        scanner.close();
    }
    // Ejercicio 1 - Verificación de Año Bisiesto.
    public static void esBisiesto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un año: ");
        int anio = scanner.nextInt();
        scanner.close();

        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            System.out.println(anio + " es un año bisiesto.");
        } else {
            System.out.println(anio + " no es un año bisiesto.");
        }
    }

    // Ejercicio 2 - Determinar el Mayor de Tres Números.
    public static void mayorDeTresNumeros() {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[3];
        int mayor = numeros[0]; // Asumimos que el primer elemento es el mayor

        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese un número: ");
            int num = scanner.nextInt();

            if (num < 0) {
                System.out.println("El número debe ser positivo. Ingreso otro.");
                i--; // Decrementar i para repetir la iteración
            }
            else {
                numeros[i] = num;
            }

            if(numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }
        
        System.out.println("El mayor de los tres números es: " + mayor);
        scanner.close();
    }

    // Ejercicio 3 - Clasificación de Edad
    public static void clasificacionEdad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su edad: ");
        int edad = scanner.nextInt();
        scanner.close();

        if (edad < 12) {
            System.out.println("Niño");
        }
        else if (edad >= 12 && edad <= 17) {
            System.out.println("Adolescente");
        }
        else if (edad >= 18 && edad <= 59) {
            System.out.println("Adulto");
        }
        else {
            System.out.println("Adulto mayor");
        }
    }

    // Ejercicio 4 - Calculadora de Descuento según categoría.
    public static void calculadoraDeDescuentos() {
    Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.println("Ingrese la categoría del producto (A, B o C): ");
        char categoria = scanner.next().toUpperCase().charAt(0);
        double descuento = 0;

        scanner.close();

        switch (categoria) {
            case 'A':
                descuento = 0.10;
                break;
            case 'B':
                descuento = 0.15;
                break;
            case 'C':
                descuento = 0.20;
                break;
        
            default:
                System.out.println("Categoria invalida. No se aplicará descuento.");
                break;
        }

        System.out.println("Precio original: " + precio);
        System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
        System.out.println("Precio final: " + (precio - (precio * descuento)));
    }

    // Ejercicio 5 - Suma de Números Pares
    public static void sumaDePares() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        int total = 0;

        while (continuar) {
            System.out.println("Ingrese un número entero positivo (0 para salir): ");
            int numero = scanner.nextInt();
            if (numero == 0) {
                continuar = false;
            }

            if (numero % 2 == 0) {
                total += numero;
            }
        }
        
        scanner.close();
        System.out.println("La suma de los números pares ingresados es: " + total);
    }

    // Ejercicio 6 - Contador de Positivos, Negativos y Ceros
    public static void contadorDeNumeros() {
        Scanner scan = new Scanner(System.in);
        int positivos = 0;
        int negativos = 0;
        int ceros = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Ingrese el número " + (i + 1) + ": ");
            int numero = scan.nextInt();
            if (numero > 0) {
                positivos++;
            } else if (numero < 0) {
                negativos++;
            } else {
                ceros++;
            }
        }

        System.out.println("Entradas positivas: " + positivos);
        System.out.println("Entradas negativas: " + negativos);
        System.out.println("Entradas cero: " + ceros);
        scan.close();
    }

    // Ejercicio 7 - Validación de Nota entre 0 y 10
    public static void validadorDeNotas() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        do {
            System.out.println("Ingrese una nota entre 0 y 10: ");
            double nota = scanner.nextDouble();
            if (nota >= 0 && nota <= 10) {
                continuar = false;
                System.out.println("Nota guardada correctamente: " + nota);
            } else {
                System.out.println("Error: Nota inválida. Debe estar entre 0 y 10.");
            }

        } while (continuar);

        scanner.close();
    }

    // Ejercicio 8 - Cálculo de Precio Final con Impuesto y Descuento
    public static void precioFinal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el precio base del producto: ");
        double precioBase = scanner.nextDouble();
        System.out.println("Ingrese el impuesto en porcentaje (Ejemplo: 10 para 10%): ");
        double impuesto = scanner.nextDouble() / 100; 
        System.out.println("Ingrese el descuento en porcentaje (Ejemplo: 5 para 5%): "); 
        double descuento = scanner.nextDouble() / 100;
        
        double precioFinal = precioBase + (precioBase * impuesto) - (precioBase * descuento);

        System.out.println("El precio final del producto es: " + precioFinal);
        scanner.close();
    }

    // Ejercicio 9 - Cálculo de Precio Final con Impuesto y Descuento (versión alternativa)
    public static double calcularCostoEnvio(double peso, String zona) {
        double costoPorKg = zona.equalsIgnoreCase("Nacional") ? 5.0 : 10.0;
        double costoEnvio = peso * costoPorKg;

        System.out.println("El costo de envío es: " + costoEnvio);
        
        return costoEnvio;
    }
    public static void calcularTotalCompra(double precioProducto, double costoEnvio) {
        double totalCompra = precioProducto + costoEnvio;
        System.out.println("El total a pagar es: " + totalCompra);
    }

    // Ejercicio 10 - Actualización de Stock
    public static void actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
        System.out.println("El nuevo stock del producto es: " + (stockActual - cantidadVendida + cantidadRecibida));
    }

    // Ejercicio 11 - Cálculo de Descuento Especial
    public static void calcularDescuentoEspecial(double precio) {
        double descuentoAplicado = precio * descuentoEspecial;
        double precioFinal = precio - descuentoAplicado;
        System.out.println("Precio final con descuento especial: " + precioFinal);
    }

    // Ejercicio 12 - Manipulación de Precios
    public static void manipularPrecios() {
        double[] precios = {199.99, 299.50, 149.75, 399.00, 89.99};
        
        // Mostrar precios originales
        System.out.println("Precios originales:");
        for (double precio : precios) {
            System.out.printf("Precio: $%.2f ", precio);
        }
        System.out.println();

        precios[2] = 129.99;
        
        System.out.println("Precios modificados:");
        for (double precio : precios) {
            System.out.printf("Precio: $%.2f ", precio);
        }
        System.out.println();
    }

    // Ejercio 13 - Manipulacion de precios recursivo
    public static void manipularPreciosRecursivo() {
    double[] precios = {199.99, 299.50, 149.75, 399.00, 89.99};
    
    // Mostrar precios originales
    System.out.println("Precios originales:");
    mostrarPreciosRecursivo(precios, 0);
    System.out.println();

    // Modificar el precio del tercer producto
    precios[2] = 129.99;
    
    // Mostrar precios modificados
    System.out.println("Precios modificados:");
    mostrarPreciosRecursivo(precios, 0);
    System.out.println();
}

    // Método recursivo para mostrar precios
    private static void mostrarPreciosRecursivo(double[] precios, int indice) {
        // Caso base: cuando llegamos al final del array
        if (indice >= precios.length) {
            return;
        }
        
        // Mostrar el precio actual
        System.out.printf("Precio: $%.2f ", precios[indice]);
        
        // Llamada recursiva para el siguiente elemento
        mostrarPreciosRecursivo(precios, indice + 1);
    }
}