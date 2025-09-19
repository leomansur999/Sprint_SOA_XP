package br.com.fiap.Sprint_SOA_XP.dto;

import br.com.fiap.Sprint_SOA_XP.cliente.ObjetivoInvestimento;
import br.com.fiap.Sprint_SOA_XP.cliente.PerfilInvestidor;
import br.com.fiap.Sprint_SOA_XP.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
    private String profissao;
    private String telefone;
    private Double patrimonioLiquido;
    private Double rendaMensal;
    private String banco;
    private String titularConta;
    private String agencia;
    private String numeroConta;
    private PerfilInvestidor perfilInvestidor;
    private ObjetivoInvestimento objetivoInvestimento;
    private List<String> preferenciasInvestimentos;
    private String tipoConta;
    private String nacionalidade;
    private Endereco endereco;
    private Boolean ativo;

    // Se não estiver usando Lombok, adicione manualmente os getters e setters:
    // public String getNome() { return nome; }
    // public void setNome(String nome) { this.nome = nome; }
    // ...
}
