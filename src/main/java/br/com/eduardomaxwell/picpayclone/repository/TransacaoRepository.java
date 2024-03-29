package br.com.eduardomaxwell.picpayclone.repository;

import br.com.eduardomaxwell.picpayclone.model.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    Page<Transacao> findByOrigem_LoginOrDestino_Login(String login, String login1, Pageable pageable);
}
