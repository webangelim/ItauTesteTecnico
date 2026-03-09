package com.angelim.itauTesteTecnico;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoRequest> listaTransacoes = new ArrayList<>();

    public void salvarDados(TransacaoRequest transacaoRequest) {
        listaTransacoes.add(transacaoRequest);
    }

    public void limparDados(TransacaoRequest transacaoRequest) {

    }

    public void deletarDados(TransacaoRequest transacaoRequest) {
        listaTransacoes.clear();
    }
}
