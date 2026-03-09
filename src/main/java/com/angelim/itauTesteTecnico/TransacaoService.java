package com.angelim.itauTesteTecnico;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(TransacaoRequest transacaoRequest) {
        if (transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0) {
            // transacao inválida
            throw new IllegalArgumentException("ERRO: Isso não é uma transação válida, transações devem ter valor maior ou igual a zero");
        }
        if (transacaoRequest.getDataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("ERRO: Isso não é uma transação válida, erro na data da transação");
        }
        if (transacaoRequest.getValor() == null) {
            throw new IllegalArgumentException("ERRO: O campo de valor deve ser preenchido");
        }
        if (transacaoRequest.getDataHora() == null) {
            throw new IllegalArgumentException("ERRO: O campo de data deve ser preenchido");
        }
    }
}
