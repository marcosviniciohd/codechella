package br.com.codechalle.dto;

import br.com.codechalle.model.Evento;
import br.com.codechalle.model.TipoEvento;

import java.time.LocalDate;

public record EventoDTO(
        Long id,
        TipoEvento tipoEvento,
        String nome,
        LocalDate data,
        String descricao
) {
    public static EventoDTO toDTO(Evento evento) {
        return new EventoDTO(
                evento.getId(),
                evento.getTipo(),
                evento.getNome(),
                evento.getData(),
                evento.getDescricao()
        );

    }

    public Evento toEntity() {
        Evento evento = new Evento();
        evento.setId(this.id());
        evento.setTipo(this.tipoEvento());
        evento.setNome(this.nome());
        evento.setData(this.data());
        evento.setDescricao(this.descricao());
        return evento;
    }
}
