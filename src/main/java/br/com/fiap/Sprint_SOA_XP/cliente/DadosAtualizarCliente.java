package br.com.fiap.Sprint_SOA_XP.cliente;

import br.com.fiap.Sprint_SOA_XP.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public record DadosAtualizarCliente(

        // Informações Pessoais (opcionais)
        String nome,
        String cpf,
        String nacionalidade,
        LocalDate dataNascimento,
        String telefone,
        @Email(message = "Email inválido")
        String email,
        String pais,

        // Endereço (opcional)
        @Valid
        DadosEndereco endereco,

        // Informações Financeiras (opcionais)
        @Positive
        Double rendaMensal,
        @Positive
        Double patrimonioLiquido,
        String profissao,
        String experienciaInvestimentos,

        // Perfil de Investidor (opcional)
        PerfilInvestidor perfilInvestidor,
        ObjetivoInvestimento objetivoInvestimento,
        @Size(min = 1, message = "Deve ter pelo menos uma preferência de investimento")
        List<String> preferenciaInvestimentos,

        // Conta Bancária (opcional)
        String banco,
        String agencia,
        String numeroConta,
        String tipoConta,
        String titularConta) {

}
