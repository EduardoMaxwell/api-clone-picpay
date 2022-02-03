package br.com.eduardomaxwell.picpayclone.resource;

import br.com.eduardomaxwell.picpayclone.dto.TransacaoDTO;
import br.com.eduardomaxwell.picpayclone.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/transacoes")
public class TransacaoResource extends BaseResource<TransacaoDTO> {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoDTO> salvar(@RequestBody @Valid TransacaoDTO transacaoDTO, UriComponentsBuilder uriComponentsBuilder) {
        TransacaoDTO transacaoRetornoDTO = transacaoService.processar(transacaoDTO);
        return responderItemCriadoComURI(transacaoDTO, uriComponentsBuilder, "/transacoes/{codigo}", transacaoRetornoDTO.getCodigo());
    }
}
