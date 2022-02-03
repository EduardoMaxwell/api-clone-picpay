package br.com.eduardomaxwell.picpayclone.service;

import br.com.eduardomaxwell.picpayclone.dto.TransacaoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransacaoService {

    TransacaoDTO processar(TransacaoDTO transacaoDTO);

    Page<TransacaoDTO> listar(Pageable pageable, String login);
}
