package br.com.fiap.Sprint_SOA_XP.repository;

import br.com.fiap.Sprint_SOA_XP.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(String cpf);
}
