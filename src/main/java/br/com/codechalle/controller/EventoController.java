package br.com.codechalle.controller;

import br.com.codechalle.dto.EventoDTO;
import br.com.codechalle.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping //(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDTO> obterTodos() {
        return eventoService.obterTodos();
    }

    @GetMapping("/{id}")
    public Mono<EventoDTO> obterPorId(@PathVariable Long id) {
        return eventoService.obterPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<EventoDTO> salvar(@RequestBody EventoDTO eventoDTO) {
        return eventoService.salvar(eventoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> excluir(@PathVariable Long id) {
        return eventoService.excluir(id);
    }
}
