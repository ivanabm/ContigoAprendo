package Entidades;
import java.util.ArrayList;
import java.util.Random;

public class Pacientes {

    private String dni;
    private String nombre;
    private int edad;
    private char sexo;
    private int[] pesoMensual;

    // Constructor que inicializa los datos y genera el peso mensual aleatorio
    public Pacientes(String dni, String nombre, int edad, char sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.pesoMensual = generarPesosAleatorios();
    }
    // Constructor vacio
    public Pacientes() {
    }

    // Generador de pesos mensuales aleatorios entre 70 y 250 kg
    private int[] generarPesosAleatorios() {
        int[] pesos = new int[12];
        Random random = new Random();
        for (int i = 0; i < pesos.length; i++) {
            pesos[i] = 70 + random.nextInt(181); // Genera valores entre 70 y 250
        }
        return pesos;
    }

    // Accesadores y mutadores
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int[] getPesoMensual() {
        return pesoMensual;
    }

    public void setPesoMensual(int[] pesoMensual) {
        this.pesoMensual = pesoMensual;
    }

    // Metodo para obtener el mes con el menor peso
    public int menorPesoMensual() {
        int mesMenorPeso = 0;
        for (int i = 1; i < pesoMensual.length; i++) {
            if (pesoMensual[i] < pesoMensual[mesMenorPeso]) {
                mesMenorPeso = i;
            }
        }
        return mesMenorPeso + 1; // Sumamos 1 para devolver el mes en formato 1 a 12
    }

    // Metodo para calcular el IMC en un mes específico
    public double indiceMasaCorporal(int mes, double estatura) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("El mes debe estar entre 1 y 12.");
        }
        double peso = pesoMensual[mes - 1];
        return peso / (estatura * estatura);
    }
    // Metodo para obtener los meses en los que el peso fue menor a X kilos
    public int[] menosDeXKilos(int x) {
        ArrayList<Integer> meses = new ArrayList<>();
        for (int i = 0; i < pesoMensual.length; i++) {
            if (pesoMensual[i] < x) {
                meses.add(i + 1); // Guardamos el mes (1-12)
            }
        }
        return meses.isEmpty() ? null : meses.stream().mapToInt(Integer::intValue).toArray();
    }

    // Metodo para obtener el estado según el IMC en un mes específico
    public String pesoMesX(int mes, double estatura) {
        double imc = indiceMasaCorporal(mes, estatura);
        if (imc < 20) {
            return "Normal";
        } else if (imc < 28) {
            return "Sobrepeso";
        } else {
            return "Obeso";
        }
    }
}
