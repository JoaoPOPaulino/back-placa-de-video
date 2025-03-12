package br.unitins.back.dto.request.pagamento;

import br.unitins.back.model.pagamento.Cartao;

public record CartaoDTO(
        Long id,
        String numeroCartao,
        String nomeTitular,
        String validade,
        String tipoCartao) {

    public static CartaoDTO valueOf(Cartao cartao) {
        return new CartaoDTO(
                cartao.getId(),
                esconderNumero(cartao.getNumeroCartao()),
                cartao.getNomeTitular(),
                cartao.getValidade(),
                cartao.getTipoCartao().getLabel()
        );
    }

    private static String esconderNumero(String numero) {
        if (numero != null && numero.length() >= 4) {
            return "**** **** **** " + numero.substring(numero.length() - 4);
        }
        return "Número inválido";
    }
}
