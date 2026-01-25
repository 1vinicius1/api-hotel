package br.ifs.edu.cads.api.hotel.repositories;

import br.ifs.edu.cads.api.hotel.entities.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {
}
