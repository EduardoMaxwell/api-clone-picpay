package br.com.eduardomaxwell.picpayclone.service;

import br.com.eduardomaxwell.picpayclone.dto.CartaoCreditoDTO;
import br.com.eduardomaxwell.picpayclone.model.CartaoCredito;

public interface CartaoCreditoService{
    CartaoCreditoDTO salvar(CartaoCreditoDTO cartaoCredito);
}
