package br.com.fiap.Sprint_SOA_XP.cliente;

import br.com.fiap.Sprint_SOA_XP.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record DadosCadastroCliente(
        // Cadastro Informações Pessoais
        @NotBlank
        String nome,

        @NotBlank
        String cpf,

        @NotBlank
        String nacionalidade,

        @NotNull
        LocalDate dataNascimento,

        @NotBlank
        String telefone,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String pais,

        // Cadastro Endereço
        @NotNull
        @Valid
        DadosEndereco endereco,

        // Cadastro Informações Financeiras
        @NotNull
        @Positive
        Double rendaMensal,

        @NotNull
        @Positive
        Double patrimonioLiquido,

        @NotBlank
        String profissao,

        @NotBlank
        String experienciaInvestimentos,

        // Cadastro Perfil de Investidor
        @NotNull
        PerfilInvestidor perfilInvestidor,

        @NotNull
        ObjetivoInvestimento objetivoInvestimento,

        @NotNull
        @Size(min = 1, message = "Deve ter pelo menos uma preferência de investimento.")
        List<String> preferenciaInvestimentos,

        // Cadastro Conta Bancária
        @NotBlank
        String banco,

        @NotBlank
        String agencia,

        @NotBlank
        String numeroConta,

        @NotBlank
        String tipoConta,

        @NotBlank
        String titularConta) {
}
