package br.com.eduardomaxwell.picpayclone.service;

import br.com.eduardomaxwell.picpayclone.converters.CartaoCreditoConversor;
import br.com.eduardomaxwell.picpayclone.dto.CartaoCreditoDTO;
import br.com.eduardomaxwell.picpayclone.model.CartaoCredito;
import br.com.eduardomaxwell.picpayclone.repository.CartaoCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CartaoCreditoServiceImpl implements CartaoCreditoService{
    @Autowired
    private CartaoCreditoRepository cartaoCreditoRepository;

    @Autowired
    private CartaoCreditoConversor cartaoCreditoConversor;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public CartaoCreditoDTO salvar(CartaoCreditoDTO cartaoCreditoDTO) {
        CartaoCreditoDTO cartaoCreditoRetorno = null;
        if (cartaoCreditoDTO.getIsSalva()) {
            CartaoCredito cartaoCredito = cartaoCreditoConversor.converterDtoParaEntidade(cartaoCreditoDTO);
            usuarioService.validar(cartaoCredito.getUsuario());
            CartaoCredito cartaoCreditoSalvo = cartaoCreditoRepository.save(cartaoCredito);
            cartaoCreditoRetorno = cartaoCreditoConversor.converterEntidadeParaDto(cartaoCreditoSalvo);
        }

        return cartaoCreditoRetorno;
    }
}
