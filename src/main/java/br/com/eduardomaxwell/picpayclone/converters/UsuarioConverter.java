package br.com.eduardomaxwell.picpayclone.converters;

import br.com.eduardomaxwell.picpayclone.dto.UsuarioDTO;
import br.com.eduardomaxwell.picpayclone.model.Usuario;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter extends BaseConverter<Usuario, UsuarioDTO>{

    @Override
    public UsuarioDTO converterEntidadeParaDto(Usuario entidade) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Usuario, UsuarioDTO>() {
            @Override
            protected void configure() {
            }
        });
        return modelMapper.map(entidade, UsuarioDTO.class);
    }

    @Override
    public Usuario converterDtoParaEntidade(UsuarioDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<UsuarioDTO, Usuario>() {
            @Override
            protected void configure() {
            }
        });
        return modelMapper.map(dto, Usuario.class);
    }
}
