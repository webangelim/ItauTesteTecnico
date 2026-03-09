package com.angelim.itauTesteTecnico.Transacao;

import com.angelim.itauTesteTecnico.Estatistica.EstatisticaDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TransacaoRepository {

    List<TransacaoRequest> listaTransacoes = new ArrayList<>();

    public void salvarDados(TransacaoRequest transacaoRequest) {
        listaTransacoes.add(transacaoRequest);
    }

    public void limparDados(TransacaoRequest transacaoRequest) {

    }

    public EstatisticaDTO estatistica (OffsetDateTime horaAtual) {

        if (listaTransacoes.isEmpty()) {
            return new EstatisticaDTO(0L, 0.0,0.0,0.0, 0.0);
        }

        final var summary = listaTransacoes.stream()
                .filter(t -> t.getDataHora().isAfter(horaAtual) || t.getDataHora().isEqual(horaAtual))
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        return new EstatisticaDTO(summary.getCount(),
                summary.getAverage(),
                summary.getMax(),
                summary.getMin(),
                summary.getSum());
    }

    public void deletarDados() {
        listaTransacoes.clear();
    }
}
