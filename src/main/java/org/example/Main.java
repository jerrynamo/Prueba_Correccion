package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TarjetaMetro.mostrarTarifas();

        System.out.print("Ingrese el nombre del titular: ");
        String titular = sc.nextLine();

        System.out.print("Ingrese la cedula: ");
        String cedula = sc.nextLine();

        System.out.print("Saldo inicial: ");
        int saldo = sc.nextInt();

        System.out.print("Ingrese la edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.println("Tiene discapacidad (s/n): ");
        String discapacidad = sc.nextLine();
        boolean disc = discapacidad.equalsIgnoreCase("s");

        TarjetaMetro usuario1 = new TarjetaMetro(titular,cedula,edad,saldo,disc);

        int opcion;

        do {
            System.out.println(" === MENU === ");
            System.out.println("1.- Recargar");
            System.out.println("2.- Pagar viaje");
            System.out.println("3.- Consultar tarjeta");
            System.out.println("4.- Simular recarga");
            System.out.println("5.- Salir");

            System.out.println("Opcion > ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese el monto a recargar: ");
                    double monto = sc.nextDouble();
                    sc.nextLine();

                    usuario1.recargar(monto);

                    break;

                case 2:
                    usuario1.pagarViaje();
                    break;

                case 3:
                    usuario1.mostrarInformacion();
                    break;

                case 4:
                    System.out.println("Ingrese un monto para la simulacion: ");
                    double viajes = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Saldo actual: "+usuario1.getSaldo());
                    System.out.println("Saldo simulado: "+(usuario1.getSaldo() + viajes));
                    System.out.println("Viajes simulados: "+String.format("%.0f"+usuario1.calcularViajesDisponibles(viajes)));

                    break;

                case 5:
                    System.out.println("Gracias por usar nuestro sistema");
                    break;

                default:
                    System.out.println("Opcion invalida");


            }

        }while(opcion != 5);



    }
}