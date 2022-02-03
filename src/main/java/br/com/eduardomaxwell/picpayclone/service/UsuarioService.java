package br.com.eduardomaxwell.picpayclone.service;

import br.com.eduardomaxwell.picpayclone.model.Transacao;
import br.com.eduardomaxwell.picpayclone.model.Usuario;

public interface UsuarioService {
    Usuario consultarEntidade(String login);

    void validar(Usuario... usuarios);

    void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito);
}
