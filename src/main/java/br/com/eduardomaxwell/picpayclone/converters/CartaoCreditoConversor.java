package br.com.eduardomaxwell.picpayclone.converters;

import br.com.eduardomaxwell.picpayclone.dto.CartaoCreditoDTO;
import br.com.eduardomaxwell.picpayclone.dto.TransacaoDTO;
import br.com.eduardomaxwell.picpayclone.model.CartaoCredito;
import br.com.eduardomaxwell.picpayclone.model.Transacao;
import br.com.eduardomaxwell.picpayclone.service.UsuarioService;
import br.com.eduardomaxwell.picpayclone.util.CartaoCreditoUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartaoCreditoConversor extends BaseConverter<CartaoCredito, CartaoCreditoDTO> {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public CartaoCreditoDTO converterEntidadeParaDto(CartaoCredito entidade) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Transacao, TransacaoDTO>() {
            @Override
            protected void configure() {
            }
        });
        return modelMapper.map(entidade, CartaoCreditoDTO.class);
    }

    @Override
    public CartaoCredito converterDtoParaEntidade(CartaoCreditoDTO dto) {
        return CartaoCredito
                .builder()
                .bandeira(dto.getBandeira())
                .numero(CartaoCreditoUtil.mascarar(dto.getNumero()))
                .numeroToken(dto.getNumeroToken())
                .usuario(usuarioService.consultarEntidade(dto.getUsuario().getLogin()))
                .build();
    }
}
