package com.example.detallereservas;

import java.time.LocalDate;
import java.util.List;

public class Reserva {
    private int id;
    private int clienteId;
    private int habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Status> estado;  // Usar List<Status> para los estados

    // Constructor
    public Reserva(int id, int clienteId, int habitacion, LocalDate fechaInicio, LocalDate fechaFin, List<Status> estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public List<Status> getEstado() {
        return estado;
    }

}