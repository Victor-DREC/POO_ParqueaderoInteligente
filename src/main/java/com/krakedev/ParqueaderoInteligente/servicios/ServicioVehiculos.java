package com.krakedev.ParqueaderoInteligente.servicios;

import com.krakedev.ParqueaderoInteligente.modelo.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioVehiculos {

    private ArrayList<Vehiculo> parqueadero = new ArrayList<>();
    private final int CAPACIDAD_MAXIMA = 10;

    public Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo vehiculo : parqueadero) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }
        return null;
    }

    public boolean ingresarVehiculo(Vehiculo vehiculo) {
        if (parqueadero.size() >= CAPACIDAD_MAXIMA) {
            return false;
        }
        if (buscarPorPlaca(vehiculo.getPlaca()) != null) {
            return false;
        }
        return parqueadero.add(vehiculo);
    }

    public Vehiculo retirarVehiculo(String placa) {
        Vehiculo vehiculo = buscarPorPlaca(placa);
        if (vehiculo != null) {
            parqueadero.remove(vehiculo);
            return vehiculo;
        }
        return null;
    }

    public ArrayList<Vehiculo> listarVehiculos() {
        return parqueadero;
    }
}