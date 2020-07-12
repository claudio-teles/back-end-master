package claudioteles.com.github.backendmaster.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import claudioteles.com.github.backendmaster.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Optional<Cliente> findByNome(String nome);
	List<Cliente> findAllByOrderByIdClienteAsc();

}
