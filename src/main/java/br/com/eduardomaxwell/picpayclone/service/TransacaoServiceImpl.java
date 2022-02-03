package br.com.eduardomaxwell.picpayclone.service;

import br.com.eduardomaxwell.picpayclone.converters.TransacaoConverter;
import br.com.eduardomaxwell.picpayclone.dto.TransacaoDTO;
import br.com.eduardomaxwell.picpayclone.model.Transacao;
import br.com.eduardomaxwell.picpayclone.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    @Autowired
    private TransacaoConverter transacaoConverter;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoCreditoService cartaoCreditoService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public TransacaoDTO processar(TransacaoDTO transacaoDTO) {
        Transacao transacao = salvar(transacaoDTO);
        cartaoCreditoService.salvar(transacaoDTO.getCartaoCredito());
        usuarioService.atualizarSaldo(transacao, transacaoDTO.getIsCartaoCredito());
        return transacaoConverter.converterEntidadeParaDto(transacao);
    }

    private Transacao salvar(TransacaoDTO transacaoDTO) {
        Transacao transacao = transacaoConverter.converterDtoParaEntidade(transacaoDTO);
        usuarioService.validar(transacao.getDestino(), transacao.getOrigem());
        return transacaoRepository.save(transacao);
    }

    @Override
    public Page<TransacaoDTO> listar(Pageable pageable, String login) {
        Page<Transacao> transacoes = transacaoRepository.findByOrigem_LoginOrDestino_Login(login, login, pageable);
        return transacaoConverter.converterPageEntidadeParaDto(transacoes);
    }
}
