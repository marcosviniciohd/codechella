package br.com.codechalle.service;

import br.com.codechalle.dto.EventoDTO;
import br.com.codechalle.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public Flux<EventoDTO> obterTodos() {
        return eventoRepository.findAll().map(EventoDTO::toDTO);
    }

    public Mono<EventoDTO> obterPorId(Long id) {
        return eventoRepository.findById(id).
                switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .map(EventoDTO::toDTO);
    }

    public Mono<EventoDTO> salvar(EventoDTO eventoDTO) {
        return eventoRepository.save(eventoDTO.toEntity()).map(EventoDTO::toDTO);
    }

    public Mono<Void> excluir(Long id) {
        return eventoRepository.findById(id).switchIfEmpty(
                Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND
                ))).flatMap(eventoRepository::delete);
    }
}
