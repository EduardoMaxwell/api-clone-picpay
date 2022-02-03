package br.com.eduardomaxwell.picpayclone.service;

import br.com.eduardomaxwell.picpayclone.exceptions.NegocioException;
import br.com.eduardomaxwell.picpayclone.model.Transacao;
import br.com.eduardomaxwell.picpayclone.model.Usuario;
import br.com.eduardomaxwell.picpayclone.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario consultarEntidade(String login) {
        return usuarioRepository.findByLogin(login);
    }

    @Override
    public void validar(Usuario... usuarios) {
        Arrays.asList(usuarios).stream().forEach(usuario -> {
                    if (usuario == null){
                        throw new NegocioException("Usuário informado não existe!");
                    }
                }
        );
    }

    @Override
    @Async("asyncExecutor")
    public void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito) {
        decrementarSaldo(transacao, isCartaoCredito);
        incrementarSaldo(transacao);
    }

    private void incrementarSaldo(Transacao transacaoSalva) {
        usuarioRepository.updateIncrementarSaldo(transacaoSalva.getDestino().getLogin(), transacaoSalva.getValor());
    }

    private void decrementarSaldo(Transacao transacaoSalva, Boolean isCartaoCredito) {
        if (!isCartaoCredito) {
            usuarioRepository.updateDecrementarSaldo(transacaoSalva.getOrigem().getLogin(), transacaoSalva.getValor());
        }
    }
}




























