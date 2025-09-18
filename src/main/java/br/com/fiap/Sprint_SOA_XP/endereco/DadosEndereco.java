package br.com.fiap.Sprint_SOA_XP.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosEndereco(

        @NotBlank(message = "Logradouro obrigatório")
        String logradouro,

        @NotBlank(message = "Número obrigatório")
        String numero,
        String complemento,

        @NotBlank(message = "Bairro obrigatório")
        String bairro,

        @NotBlank(message = "Cidade obrigatória")
        String cidade,

        @Size(min = 2, max = 2, message = "Estado deve ter 2 caracteres")
        @NotBlank(message = "Estado obrigatório")
        String estado,

        @NotBlank
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve ter o formato 00000-000")
        String cep) {
}
