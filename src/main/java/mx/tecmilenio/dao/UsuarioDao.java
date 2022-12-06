package mx.tecmilenio.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.tecmilenio.entity.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario,Integer> {

	@Query("SELECT t FROM Usuario t WHERE t.usuario = ?1 ")
	Optional<Usuario> findByUser(String usuario);
}
