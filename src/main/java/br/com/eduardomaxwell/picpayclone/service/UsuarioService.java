package br.com.eduardomaxwell.picpayclone.service;

import br.com.eduardomaxwell.picpayclone.dto.UsuarioDTO;
import br.com.eduardomaxwell.picpayclone.model.Transacao;
import br.com.eduardomaxwell.picpayclone.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario consultarEntidade(String login);

    void validar(Usuario... usuarios);

    void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito);

    UsuarioDTO consultar(String login);

    List<UsuarioDTO> listar(String login);
}
