package br.com.eduardomaxwell.picpayclone.resource;

import br.com.eduardomaxwell.picpayclone.dto.TransacaoDTO;
import br.com.eduardomaxwell.picpayclone.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/transacoes")
public class TransacaoResource extends BaseResource<TransacaoDTO> {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoDTO> salvar(
            @RequestBody @Valid TransacaoDTO transacaoDTO,
            UriComponentsBuilder uriComponentsBuilder) {
        TransacaoDTO transacaoRetornoDTO = transacaoService.processar(transacaoDTO);
        return responderItemCriadoComURI(transacaoDTO, uriComponentsBuilder, "/transacoes/{codigo}", transacaoRetornoDTO.getCodigo());
    }

    @GetMapping
    public ResponseEntity<Page<TransacaoDTO>> listar(
            @PageableDefault(page = 0, size = 20) Pageable pageable,
            @RequestParam String login) {

        Page<TransacaoDTO> transacoes = transacaoService.listar(pageable, login);
        return responderListaDeItensPaginada(transacoes);
    }
}
