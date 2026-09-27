package com.krakedev.ParqueaderoInteligente.modelo;

public class Motocicleta extends Vehiculo {

    private static final double TARIFA_HORA_REGULAR = 0.75;
    private static final double TARIFA_HORA_ALTO_CILINDRAJE = 1.00;
    private static final int LIMITE_CILINDRAJE = 250;

    private int cilindraje;

    public Motocicleta(String placa, String propietario, int cilindraje) {
        super(placa, propietario);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularTarifa(int horasPermanencia) {
        double tarifaHora = (cilindraje > LIMITE_CILINDRAJE)
                ? TARIFA_HORA_ALTO_CILINDRAJE
                : TARIFA_HORA_REGULAR;
        return horasPermanencia * tarifaHora;
    }

    @Override
    public String toString() {
        return "Motocicleta{" +
                "cilindraje=" + cilindraje +
                ", " + super.toString() +
                '}';
    }
}