package Interfaz;


import Entidades.Pacientes;

public class App_Prueba {
    public static void main(String[] args) {
        Pacientes paciente = new Pacientes(" 37512020", " Barrios Marchan Ivana",32, 'f');

        System.out.println("Datos del paciente");

        System.out.println("Dni del paciente "+ paciente.getDni());
        System.out.println("Nombre del paciente "+ paciente.getNombre());
        System.out.println("Edad del paciente "+ paciente.getEdad());
        System.out.println("Sexo del paciente "+paciente.getSexo());

        for (int i=0;i<paciente.getPesoMensual().length; i++){
            System.out.println("Peso mes "+ (i+1)+ ",total "+ paciente.getPesoMensual()[i]);



        }





    }
}
