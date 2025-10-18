/**
 * Clase base Animal que representa un animal genérico
 * Demuestra sobrescritura de métodos con @Override
 */
class Animal {
    protected String nombre;
    protected String especie;
    protected int edad;
    
    public Animal(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }
    
    /**
     * Método que será sobrescrito por las subclases
     * Cada animal hace un sonido diferente
     */
    public void hacerSonido() {
        System.out.println(nombre + " hace un sonido genérico");
    }
    
    /**
     * Método para describir el animal
     */
    public void describirAnimal() {
        System.out.printf("%s es un %s de %d años%n", nombre, especie, edad);
    }
    
    /**
     * Método que puede ser sobrescrito para comportamientos específicos
     */
    public void dormir() {
        System.out.println(nombre + " está durmiendo...");
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    
    public String getEspecie() {
        return especie;
    }
    
    public int getEdad() {
        return edad;
    }
}

/**
 * Subclase Perro que sobrescribe el comportamiento de Animal
 */
class Perro extends Animal {
    private String raza;
    
    public Perro(String nombre, int edad, String raza) {
        super(nombre, "Perro", edad);
        this.raza = raza;
    }
    
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Guau guau!");
    }
    
    @Override
    public void describirAnimal() {
        System.out.printf("%s es un perro %s de %d años%n", nombre, raza, edad);
    }
    
    @Override
    public void dormir() {
        System.out.println(nombre + " está durmiendo en su casita...");
    }
    
    // Método específico de Perro
    public void moverCola() {
        System.out.println(nombre + " está moviendo la cola felizmente");
    }
    
    public String getRaza() {
        return raza;
    }
}

/**
 * Subclase Gato que sobrescribe el comportamiento de Animal
 */
class Gato extends Animal {
    private String color;
    
    public Gato(String nombre, int edad, String color) {
        super(nombre, "Gato", edad);
        this.color = color;
    }
    
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Miau miau!");
    }
    
    @Override
    public void describirAnimal() {
        System.out.printf("%s es un gato %s de %d años%n", nombre, color, edad);
    }
    
    @Override
    public void dormir() {
        System.out.println(nombre + " está durmiendo en un lugar soleado...");
    }
    
    // Método específico de Gato
    public void ronronear() {
        System.out.println(nombre + " está ronroneando: purrr purrr");
    }
    
    public String getColor() {
        return color;
    }
}

/**
 * Subclase Vaca que sobrescribe el comportamiento de Animal
 */
class Vaca extends Animal {
    private double litrosLeche;
    
    public Vaca(String nombre, int edad, double litrosLeche) {
        super(nombre, "Vaca", edad);
        this.litrosLeche = litrosLeche;
    }
    
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Muuuu muuuu!");
    }
    
    @Override
    public void describirAnimal() {
        System.out.printf("%s es una vaca de %d años que produce %.1f litros de leche al día%n", 
                         nombre, edad, litrosLeche);
    }
    
    @Override
    public void dormir() {
        System.out.println(nombre + " está durmiendo en el establo...");
    }
    
    // Método específico de Vaca
    public void darLeche() {
        System.out.printf("%s está dando %.1f litros de leche%n", nombre, litrosLeche);
    }
    
    public double getLitrosLeche() {
        return litrosLeche;
    }
}

/**
 * Subclase Pájaro para mostrar más diversidad
 */
class Pajaro extends Animal {
    private String tipoVuelo;
    
    public Pajaro(String nombre, int edad, String tipoVuelo) {
        super(nombre, "Pájaro", edad);
        this.tipoVuelo = tipoVuelo;
    }
    
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " dice: ¡Pío pío!");
    }
    
    @Override
    public void describirAnimal() {
        System.out.printf("%s es un pájaro de %d años con vuelo %s%n", nombre, edad, tipoVuelo);
    }
    
    // Método específico de Pájaro
    public void volar() {
        System.out.println(nombre + " está volando con vuelo " + tipoVuelo);
    }
}

/**
 * Clase de prueba para demostrar sobrescritura de métodos y polimorfismo
 * Kata 4: Animales y comportamiento sobrescrito
 */
public class Kata4_Animales {
    
    public static void main(String[] args) {
        System.out.println("=== KATA 4: ANIMALES Y COMPORTAMIENTO SOBRESCRITO ===\n");
        
        // 1. Crear instancias individuales de cada animal
        System.out.println("1. Creando animales individuales:");
        Perro perro = new Perro("Max", 5, "Golden Retriever");
        Gato gato = new Gato("Whiskers", 3, "anaranjado");
        Vaca vaca = new Vaca("Lola", 4, 25.5);
        Pajaro pajaro = new Pajaro("Tweety", 1, "ágil");
        
        // Mostrar información y sonidos individuales
        perro.describirAnimal();
        perro.hacerSonido();
        perro.moverCola();
        
        System.out.println();
        gato.describirAnimal();
        gato.hacerSonido();
        gato.ronronear();
        
        System.out.println();
        vaca.describirAnimal();
        vaca.hacerSonido();
        vaca.darLeche();
        
        System.out.println();
        pajaro.describirAnimal();
        pajaro.hacerSonido();
        pajaro.volar();
        
        // 2. Crear lista de animales (polimorfismo)
        System.out.println("\n2. Lista de animales (polimorfismo):");
        Animal[] animales = {
            new Perro("Buddy", 2, "Labrador"),
            new Gato("Mittens", 4, "gris"),
            new Vaca("Bessie", 6, 30.0),
            new Pajaro("Robin", 2, "rápido"),
            new Perro("Rex", 7, "Pastor Alemán"),
            new Gato("Shadow", 1, "negro"),
            new Vaca("Daisy", 5, 28.5)
        };
        
        // 3. Mostrar sonidos usando polimorfismo
        System.out.println("\n3. Concierto de animales (polimorfismo con @Override):");
        for (Animal animal : animales) {
            animal.describirAnimal();
            animal.hacerSonido(); // Polimorfismo: cada animal hace su sonido específico
            System.out.println();
        }
        
        // 4. Clasificar animales por tipo usando instanceof
        System.out.println("4. Clasificando animales por tipo:");
        int contadorPerros = 0, contadorGatos = 0, contadorVacas = 0, contadorPajaros = 0;
        
        for (Animal animal : animales) {
            if (animal instanceof Perro) {
                contadorPerros++;
                System.out.println("- Perro: " + animal.getNombre());
            } else if (animal instanceof Gato) {
                contadorGatos++;
                System.out.println("- Gato: " + animal.getNombre());
            } else if (animal instanceof Vaca) {
                contadorVacas++;
                System.out.println("- Vaca: " + animal.getNombre());
            } else if (animal instanceof Pajaro) {
                contadorPajaros++;
                System.out.println("- Pájaro: " + animal.getNombre());
            }
        }
        
        // 5. Mostrar estadísticas
        System.out.println("\n5. Estadísticas del zoológico:");
        System.out.println("Total de perros: " + contadorPerros);
        System.out.println("Total de gatos: " + contadorGatos);
        System.out.println("Total de vacas: " + contadorVacas);
        System.out.println("Total de pájaros: " + contadorPajaros);
        System.out.println("Total de animales: " + animales.length);
        
        // 6. Hora de dormir (polimorfismo)
        System.out.println("\n6. Hora de dormir (comportamiento polimórfico):");
        for (Animal animal : animales) {
            animal.dormir(); // Cada animal duerme de manera diferente
        }
        
        // 7. Downcasting para acceder a métodos específicos
        System.out.println("\n7. Comportamientos específicos (downcasting):");
        for (Animal animal : animales) {
            if (animal instanceof Perro) {
                Perro perroEspecifico = (Perro) animal;
                perroEspecifico.moverCola();
            } else if (animal instanceof Gato) {
                Gato gatoEspecifico = (Gato) animal;
                gatoEspecifico.ronronear();
            } else if (animal instanceof Vaca) {
                Vaca vacaEspecifica = (Vaca) animal;
                vacaEspecifica.darLeche();
            } else if (animal instanceof Pajaro) {
                Pajaro pajaroEspecifico = (Pajaro) animal;
                pajaroEspecifico.volar();
            }
        }
        
        // 8. Calcular edad promedio
        System.out.println("\n8. Estadísticas de edad:");
        int sumaEdades = 0;
        int animalMasViejo = 0;
        for (Animal animal : animales) {
            sumaEdades += animal.getEdad();
            if (animal.getEdad() > animales[animalMasViejo].getEdad()) {
                animalMasViejo = animales.length - 1;
                for (int i = 0; i < animales.length; i++) {
                    if (animales[i] == animal) {
                        animalMasViejo = i;
                        break;
                    }
                }
            }
        }
        double edadPromedio = (double) sumaEdades / animales.length;
        System.out.printf("Edad promedio de los animales: %.1f años%n", edadPromedio);
        System.out.println("Animal más viejo: " + animales[animalMasViejo].getNombre() + 
                          " (" + animales[animalMasViejo].getEdad() + " años)");
        
        System.out.println("\n=== FIN KATA 4 ===");
    }
}