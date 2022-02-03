package br.com.eduardomaxwell.picpayclone.repository;

import br.com.eduardomaxwell.picpayclone.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
