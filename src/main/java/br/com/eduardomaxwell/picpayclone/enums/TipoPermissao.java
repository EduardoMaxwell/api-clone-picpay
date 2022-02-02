package br.com.eduardomaxwell.picpayclone.enums;

public enum TipoPermissao {

    USUARIO("ROLE_USER"), ADMINISTRADOR("ROLE_ADMIN");

    private String codigo;

    TipoPermissao(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
