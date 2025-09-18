package br.com.fiap.Sprint_SOA_XP.cliente;

import br.com.fiap.Sprint_SOA_XP.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo = true;

    // Informações Pessoais
    private String nome;
    private String cpf;
    private String nacionalidade;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;

    // Informações Financeiras
    private Double rendaMensal;
    private Double patrimonioLiquido;
    private String profissao;
    private String experienciaInvestimentos;

    // Perfil de Investidor
    @Enumerated(EnumType.STRING)
    private PerfilInvestidor perfilInvestidor;

    @Enumerated(EnumType.STRING)
    private ObjetivoInvestimento objetivoInvestimento;

    @ElementCollection
    private List<String> preferenciaInvestimento;

    // Informações de Conta Bancária
    private String banco;
    private String agencia;
    private String numeroConta;
    private String tipoConta; // "Corrente" ou "Poupança"
    private String titularConta;

    @Embedded
    private Endereco endereco;

    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.nacionalidade = dados.nacionalidade();
        this.dataNascimento = dados.dataNascimento();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.rendaMensal = dados.rendaMensal();
        this.patrimonioLiquido = dados.patrimonioLiquido();
        this.profissao = dados.profissao();
        this.experienciaInvestimentos = dados.experienciaInvestimentos();
        this.perfilInvestidor = dados.perfilInvestidor();
        this.objetivoInvestimento = dados.objetivoInvestimento();
        this.preferenciaInvestimento = dados.preferenciaInvestimentos();
        this.banco = dados.banco();
        this.agencia = dados.agencia();
        this.numeroConta = dados.numeroConta();
        this.tipoConta = dados.tipoConta();
        this.titularConta = dados.titularConta();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;

    }

    // Atualizar Informações do Cliente
    public void atualizarInformacoes(@Valid DadosAtualizarCliente dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.email() != null) this.email = dados.email();
        if (dados.telefone() != null) this.telefone = dados.telefone();
        if (dados.perfilInvestidor() != null) this.perfilInvestidor = dados.perfilInvestidor();
        if (dados.objetivoInvestimento() != null) this.objetivoInvestimento = dados.objetivoInvestimento();
        if (dados.preferenciaInvestimentos() != null) this.preferenciaInvestimento = dados.preferenciaInvestimentos();
        if (dados.endereco() != null) this.endereco.atualizarInformacoes(dados.endereco());
    }

    // Excluir o Cliente
    public void excluir() {
        this.ativo = false;
    }

}
