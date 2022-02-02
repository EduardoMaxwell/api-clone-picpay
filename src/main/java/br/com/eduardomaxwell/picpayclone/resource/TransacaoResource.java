package br.com.eduardomaxwell.picpayclone.resource;

import br.com.eduardomaxwell.picpayclone.dto.TransacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transacoes")
public class TransacaoResource extends BaseResource<TransacaoDTO> {

    public ResponseEntity<TransacaoDTO> salvar(@RequestBody @Valid TransacaoDTO transacaoDTO){

    }
}
