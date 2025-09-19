package br.com.fiap.Sprint_SOA_XP.cliente;

import br.com.fiap.Sprint_SOA_XP.endereco.Endereco;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "clientes", uniqueConstraints = {@UniqueConstraint(columnNames = "cpf")})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
    private String profissao;
    private String telefone;
    private String nacionalidade;

    private Double patrimonioLiquido;
    private Double rendaMensal;

    private String banco;
    private String agencia;
    private String numeroConta;
    private String titularConta;
    private String tipoConta;
    private String experienciaInvestimentos;

    @Enumerated(EnumType.STRING)
    private PerfilInvestidor perfilInvestidor;

    @Enumerated(EnumType.STRING)
    private ObjetivoInvestimento objetivoInvestimento;

    @ElementCollection
    private List<String> preferenciaInvestimentos;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;
}
