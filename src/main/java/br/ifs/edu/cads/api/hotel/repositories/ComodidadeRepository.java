package br.ifs.edu.cads.api.hotel.repositories;

import br.ifs.edu.cads.api.hotel.entities.Comodidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComodidadeRepository extends JpaRepository<Comodidade, Long> {
}
