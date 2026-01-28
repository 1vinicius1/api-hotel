package br.ifs.edu.cads.api.hotel.repositories;

import br.ifs.edu.cads.api.hotel.dto.ReservaResumoProjection;
import br.ifs.edu.cads.api.hotel.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query(value = """
    SELECT
        r.id_reserva                 AS idReserva,
        h.nome                       AS nomeHospede,
        cq.nome                      AS categoriaQuarto,
        CAST(r.data_inicio AS DATE)  AS dataInicio,
        CAST(r.data_fim AS DATE)     AS dataFim,
        r.status_reserva             AS statusReserva
    FROM reserva r
    JOIN hospede h ON h.id_hospede = r.hospede_id
    JOIN categoria_quarto cq ON cq.id_categoria_quarto = r.categoria_quarto_id
    WHERE CAST(r.data_inicio AS DATE) BETWEEN :inicio AND :fim
    ORDER BY r.data_inicio
""", nativeQuery = true)
    List<ReservaResumoProjection> buscarResumoPorPeriodo(
            @Param("inicio") java.sql.Date inicio,
            @Param("fim") java.sql.Date fim
    );



}
