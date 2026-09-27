package com.krakedev.ParqueaderoInteligente.modelo;

public class Auto extends Vehiculo {

    private static final double TARIFA_HORA = 1.50;
    private static final double RECARGO_ESTADIA_PROLONGADA = 2.00;
    private static final int LIMITE_HORAS_SIN_RECARGO = 4;

    private int numeroPuertas;

    public Auto(String placa, String propietario, int numeroPuertas) {
        super(placa, propietario);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public double calcularTarifa(int horasPermanencia) {
        double total = horasPermanencia * TARIFA_HORA;
        if (horasPermanencia > LIMITE_HORAS_SIN_RECARGO) {
            total += RECARGO_ESTADIA_PROLONGADA;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "numeroPuertas=" + numeroPuertas +
                ", " + super.toString() +
                '}';
    }
}