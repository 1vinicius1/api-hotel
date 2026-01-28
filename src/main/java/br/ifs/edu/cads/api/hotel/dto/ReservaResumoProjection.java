package br.ifs.edu.cads.api.hotel.dto;

import java.time.LocalDate;

public interface ReservaResumoProjection {
    Long getIdReserva();
    String getNomeHospede();
    String getCategoriaQuarto();
    LocalDate getDataInicio();
    LocalDate getDataFim();
    String getStatusReserva();
}

