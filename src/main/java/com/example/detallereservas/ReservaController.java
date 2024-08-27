package com.example.detallereservas;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ReservaController {

    // Lista en memoria para almacenar las reservas y los estados
    private List<Reserva> reservas;
    private List<Status> estados;

    // Constructor
    public ReservaController() {
        this.estados = new ArrayList<>();
        this.reservas = new ArrayList<>();

        // Poblar los estados
        estados.add(new Status(1, "disponible"));
        estados.add(new Status(2, "ocupada"));
        estados.add(new Status(3, "limpieza"));
        estados.add(new Status(4, "mantenimiento"));
        estados.add(new Status(5, "reservada"));

        // Poblar algunas reservas con múltiples estados
        reservas.add(new Reserva(1, 101, 201, LocalDate.of(2024, 9, 1), LocalDate.of(2024, 9, 5), Arrays.asList(estados.get(0), estados.get(2))));
        reservas.add(new Reserva(2, 102, 202, LocalDate.of(2024, 10, 1), LocalDate.of(2024, 10, 4), Arrays.asList(estados.get(1))));
        reservas.add(new Reserva(3, 103, 203, LocalDate.of(2024, 11, 10), LocalDate.of(2024, 11, 15), Arrays.asList(estados.get(0))));
        reservas.add(new Reserva(4, 104, 204, LocalDate.of(2024, 12, 12), LocalDate.of(2024, 12, 18), Arrays.asList(estados.get(1), estados.get(3))));
        reservas.add(new Reserva(5, 105, 205, LocalDate.of(2025, 1, 3), LocalDate.of(2025, 1, 10), Arrays.asList(estados.get(0))));
    }

    // Método para obtener todas las reservas
    @GetMapping("/reservas")
    public List<Reserva> listarReservas() {
        return reservas;
    }

    // Método para obtener reservas por estado (basado en la descripción del estado)
    @GetMapping("/reservas/porEstado")
    public List<Reserva> obtenerReservasPorEstado(String estado) {
        return reservas.stream()
                       .filter(reserva -> reserva.getEstado().stream()
                           .anyMatch(status -> status.getNombre().equalsIgnoreCase(estado)))
                       .collect(Collectors.toList());
    }

    // Método para obtener todos los estados
    @GetMapping("/estados")
    public List<Status> listarEstados() {
        return estados;
    }
}