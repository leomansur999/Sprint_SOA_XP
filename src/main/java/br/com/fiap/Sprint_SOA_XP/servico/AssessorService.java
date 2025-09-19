package br.com.fiap.Sprint_SOA_XP.servico;

import br.com.fiap.Sprint_SOA_XP.cliente.Cliente;
import br.com.fiap.Sprint_SOA_XP.cliente.PerfilInvestidor;
import org.springframework.stereotype.Service;

@Service
public class AssessorService {

    // Lógica simples de recomendação baseada no perfil do cliente
    public String gerarRecomendacao(Cliente cliente) {
        if (cliente == null) return "Cliente não encontrado.";

        return switch (cliente.getPerfilInvestidor()) {
            case CONSERVADOR -> "Recomendação: Renda Fixa (Tesouro Selic, CDBs, Fundos DI).";
            case MODERADO -> "Recomendação: Carteira balanceada (40% renda fixa, 40% fundos multimercado, 20% ações).";
            case AGRESSIVO -> "Recomendação: Ações, ETFs, Fundos de Ações e Criptomoedas.";
        };
    }
}
