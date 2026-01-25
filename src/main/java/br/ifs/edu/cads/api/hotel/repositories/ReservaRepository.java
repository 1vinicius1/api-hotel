package br.ifs.edu.cads.api.hotel.repositories;

import br.ifs.edu.cads.api.hotel.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
