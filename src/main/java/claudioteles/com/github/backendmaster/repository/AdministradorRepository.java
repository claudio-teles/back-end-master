package claudioteles.com.github.backendmaster.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import claudioteles.com.github.backendmaster.model.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
	
	Boolean existsByNome(String nome);
	Boolean existsBySenha(String senha);
	
	Optional<Administrador> findByNome(String nome);

}
