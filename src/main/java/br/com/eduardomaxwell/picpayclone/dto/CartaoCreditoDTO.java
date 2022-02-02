package br.com.eduardomaxwell.picpayclone.dto;

import br.com.eduardomaxwell.picpayclone.enums.BandeiraCartao;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CartaoCreditoDTO {

    @NotBlank
    private BandeiraCartao bandeira;
    @NotBlank
    private String codigoSeguranca;
    @NotBlank
    private String dataExpiracao;
    @NotBlank
    private String nomeTitular;
    @NotBlank
    private String numero;
    @NotBlank
    private String numeroToken;
    @NotNull
    private UsuarioDTO usuario;

    private Boolean isSalva = false;

}
