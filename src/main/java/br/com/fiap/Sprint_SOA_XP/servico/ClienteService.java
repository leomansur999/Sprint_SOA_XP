package br.com.fiap.Sprint_SOA_XP.service;

import br.com.fiap.Sprint_SOA_XP.cliente.Cliente;
import br.com.fiap.Sprint_SOA_XP.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente criarCliente(Cliente cliente) {
        if (clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new RuntimeException("Cliente com CPF " + cliente.getCpf() + " já existe");
        }
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + id));
    }

    @Transactional
    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Cliente clienteExistente = buscarPorId(id);
        // Atualiza campos necessários
        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setEmail(clienteAtualizado.getEmail());
        clienteExistente.setCpf(clienteAtualizado.getCpf());
        clienteExistente.setProfissao(clienteAtualizado.getProfissao());
        // ... adicione os outros campos que você deseja atualizar
        return clienteRepository.save(clienteExistente);
    }

    @Transactional
    public void deletarCliente(Long id) {
        Cliente cliente = buscarPorId(id);
        clienteRepository.delete(cliente);
    }
}
