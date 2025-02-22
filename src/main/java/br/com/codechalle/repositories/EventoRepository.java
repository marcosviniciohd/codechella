package br.com.codechalle.repositories;

import br.com.codechalle.model.Evento;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends ReactiveCrudRepository<Evento, Long> {
}
