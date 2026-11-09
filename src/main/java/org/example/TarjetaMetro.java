package org.example;

public class TarjetaMetro {
    private String titular;
    private String cedula;
    private int edad;
    private boolean tieneDiscapacidad;
    private double saldo;
    private int viajesRealizados;
    private double totalRecaudado;

    public static final double TARIFA_GENERAL = 0.45;

    public TarjetaMetro(){
        this.titular = "ANONIMO";
        this.cedula = "0000000000";
        this.edad = 30;
        this.tieneDiscapacidad = false;
        this.saldo = 0;
        this.viajesRealizados = 0;
        this.totalRecaudado = 0;
    }

    public TarjetaMetro(String titular, String cedula, int edad, double saldoInicial, boolean tieneDiscapacidad){
        setTitular(titular);
        setCedula(cedula);
        setEdad(edad);
        setTieneDiscapacidad(tieneDiscapacidad);
        if(saldoInicial >= 0 && saldoInicial <=40){
            this.saldo = saldoInicial;
        }else{
            System.out.println("Error: saldo esta invalido (0-40)");
            this.saldo = 0;
        }

        viajesRealizados = 0;
        totalRecaudado = 0;
    }

    public String getTitular() {
        return titular;
    }

    public String getCedula() {
        return cedula;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isTieneDiscapacidad() {
        return tieneDiscapacidad;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getViajesRealizados() {
        return viajesRealizados;
    }

    public double getTotalRecaudado() {
        return totalRecaudado;
    }

    public void setTitular(String titular) {
        if(titular != null && !titular.trim().isEmpty()){
            this.titular = titular;
        }else{
            System.out.println("Error: Titular invalido se asigna 'SIN NOMBRE'");
            this.titular = "SIN NOMBRE";
        }
    }

    public void setCedula(String cedula) {
        if(cedula != null && cedula.length() == 10){
            this.cedula = cedula;
        }else{
            System.out.println("Error: Cedula invalida se asigna '000000000'");
            this.cedula = "0000000000";
        }
    }

    public void setEdad(int edad) {
        if(edad >= 5 && edad <= 110){
            this.edad = edad;
        }else{
            this.edad = 18;
        }
    }

    public void setTieneDiscapacidad(boolean tieneDiscapacidad) {
        this.tieneDiscapacidad = tieneDiscapacidad;
    }

    public static void mostrarTarifas(){
        System.out.println("=== METRO DE QUITO - TARIFAS ===");
        System.out.println("Persona con discapacidad: $0.10 (prioridad sobre la edad)");
        System.out.println("De 5 a 17 anios o de 65 en adelante: $0.22");
        System.out.println("Resto de usuarios: $"+TARIFA_GENERAL);
        System.out.println("\nReglas: ");
        System.out.println("- Cada recarga debe ser de $1.00 a $20.00");
        System.out.println("- El saldo de la tarjeta no puede superar $40.00");
        System.out.println("- Un viaje se permite si el saldo es mayor o igual que la tarifa");
        System.out.println("=========================================");
    }

    public double calcularTaria(){
        if(tieneDiscapacidad){
            return 0.10;
        }else if ((edad >= 5 && edad <= 17) || edad >= 65){
            return 0.22;
        }else {
            return TARIFA_GENERAL;
        }
    }

    public double calcularViajesDisponibles(){
        return saldo / calcularTaria();
    }

    public double calcularViajesDisponibles(double monto){
        return (saldo + monto) / calcularTaria();
    }

    public boolean recargar(double monto){
        if(monto < 1 || monto >20){
            System.out.println("MONTO NO PERMITIDO");
            return false;
        }

        if(saldo + monto > 40){
            System.out.println("SUPERA EL SALDO MAXIMO");
            return false;
        }

        this.saldo += monto;
        this.totalRecaudado += monto;

        System.out.println("Saldo recargado Correctamente");
        System.out.println("Saldo: "+this.saldo);
        return true;
    }

    public boolean pagarViaje(){
        double tarifa = calcularTaria();
        if(tarifa <= saldo){
            saldo -= tarifa;
            viajesRealizados ++;
            System.out.println("ACCESO PERMITIDO");
            System.out.println("Saldo: "+this.saldo);
            System.out.println("Tarifa: "+tarifa);
            return true;
        }else{
            System.out.println("SALDO INSUFICIENTE");
            return false;
        }
    }

    public void mostrarInformacion(){
        System.out.println("--- DATOS DE LA TARJETA ---");
        System.out.println("Titular: "+this.titular);
        System.out.println("Cedula: "+this.cedula);
        System.out.println("Edad: "+this.edad);
        System.out.println("Discapacidad: "+(tieneDiscapacidad ? "SI": "NO"));
        System.out.println("Tarifa aplicada: $"+calcularTaria());
        System.out.println("Saldo: "+this.saldo);
        System.out.println("Viajes realizados: "+this.viajesRealizados);
        System.out.println("Total recargado: "+this.totalRecaudado);
        System.out.println("Viajes disponibles: "+calcularViajesDisponibles());
        System.out.println("=============================");


    }

}












