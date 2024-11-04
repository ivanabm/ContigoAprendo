package Interfaz;

import Entidades.Pacientes;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pacientes paciente = null; // Inicialmente no hay paciente creado

        while (true) {
            System.out.println("\n--- Menú de la Clínica 'Contigo Aprendo' ---");
            System.out.println("1. Crear un nuevo paciente");
            System.out.println("2. Mostrar los atributos del paciente registrado");
            System.out.println("3. Mostrar el mes con menor peso del paciente");
            System.out.println("4. Comparar peso y mostrar meses con peso menor a X kilos");
            System.out.println("5. Mostrar la condición del paciente en noviembre");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Crear un nuevo paciente
                    System.out.print("Ingrese el Dni del paciente: ");
                    String rut = scanner.next();
                    System.out.print("Ingrese solo el nombre del paciente: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese la edad del paciente: ");
                    int edad = scanner.nextInt();
                    System.out.print("Ingrese el sexo del paciente (F/M): ");
                    char sexo = scanner.next().charAt(0);

                    paciente = new Pacientes(rut, nombre, edad, sexo);
                    System.out.println("Paciente creado con éxito.");
                    break;

                case 2:
                    // Mostrar todos los atributos del paciente
                    if (paciente == null) {
                        System.out.println("No hay ningún paciente registrado.");
                    } else {
                        System.out.println("\n--- Atributos del Paciente ---");
                        System.out.println("Dni: " + paciente.getDni());
                        System.out.println("Nombre: " + paciente.getNombre());
                        System.out.println("Edad: " + paciente.getEdad());
                        System.out.println("Sexo: " + paciente.getSexo());
                        System.out.print("Peso Mensual: ");
                        for (int peso : paciente.getPesoMensual()) {
                            System.out.print(peso + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    // Mostrar el mes con menor peso del paciente
                    if (paciente == null) {
                        System.out.println("No hay ningún paciente registrado.");
                    } else {
                        int mesMenorPeso = paciente.menorPesoMensual();
                        System.out.println("El mes con menor peso es: " + mesMenorPeso);
                    }
                    break;

                case 4:
                    // Comparar peso y mostrar meses con peso menor a X kilos
                    if (paciente == null) {
                        System.out.println("No hay ningún paciente registrado.");
                    } else {
                        System.out.print("Ingrese el peso para comparar: ");
                        int pesoComparar = scanner.nextInt();
                        int[] meses = paciente.menosDeXKilos(pesoComparar);
                        if (meses == null) {
                            System.out.println("El paciente nunca pesó menos de " + pesoComparar + " kilos.");
                        } else {
                            System.out.print("Meses en los que el paciente pesó menos de " + pesoComparar + " kilos: ");
                            for (int mes : meses) {
                                System.out.print(mes + " ");
                            }
                            System.out.println();
                        }
                    }
                    break;

                case 5:
                    // Mostrar la condición del paciente en noviembre
                    if (paciente == null) {
                        System.out.println("No hay ningún paciente registrado.");
                    } else {
                        System.out.print("Ingrese la estatura del paciente en metros (por ejemplo: 1,75): ");
                        double estatura = scanner.nextDouble();
                        String condicion = paciente.pesoMesX(11, estatura); // Noviembre es el mes 11
                        System.out.println("La condición del paciente en noviembre es: " + condicion);
                    }
                    break;

                case 6:
                    // Salir
                    System.out.println("Saliendo de la aplicación.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
