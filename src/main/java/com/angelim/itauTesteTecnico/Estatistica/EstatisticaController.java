package com.angelim.itauTesteTecnico.Estatistica;

import com.angelim.itauTesteTecnico.Transacao.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;


@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private TransacaoRepository transacaoRepository;
    private final EstatisticaProperties estatisticaProperties;

    public EstatisticaController(TransacaoRepository transacaoRepository, EstatisticaProperties estatisticaProperties) {
        this.transacaoRepository = transacaoRepository;
        this.estatisticaProperties = estatisticaProperties;
    }

    @GetMapping
    public ResponseEntity<EstatisticaDTO> estatistica() {

        // Log de requisição criado via lombok
        log.info("Calculando estatísticas de transações nos últimos " + estatisticaProperties.segundos() + "s");

        final var horaAtual = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());

        return ResponseEntity.ok(transacaoRepository.estatistica(horaAtual));
    }

}
