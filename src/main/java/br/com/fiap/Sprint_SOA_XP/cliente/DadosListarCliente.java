package br.com.fiap.Sprint_SOA_XP.cliente;

public record DadosListarCliente(
        Long id,
        String nome,
        String email,
        String telefone,
        PerfilInvestidor perfilInvestidor
) {
    public DadosListarCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getPerfilInvestidor());
    }
}
