package br.com.eduardomaxwell.picpayclone.service;

import br.com.eduardomaxwell.picpayclone.dto.TransacaoDTO;

public interface TransacaoService {

    TransacaoDTO processar(TransacaoDTO transacaoDTO);
}
