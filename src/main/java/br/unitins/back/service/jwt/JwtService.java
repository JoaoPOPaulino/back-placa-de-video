package br.unitins.back.service.jwt;

import br.unitins.back.dto.response.UsuarioResponseDTO;

public interface JwtService {

    String generateJwt(UsuarioResponseDTO dto);
}
