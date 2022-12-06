package mx.tecmilenio.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mx.tecmilenio.entity.HistoricoImc;


public interface HistoricoImcDao extends JpaRepository<HistoricoImc,Integer> {

	@Query("SELECT t FROM HistoricoImc t WHERE t.idUsuario = ?1 ")
	List<HistoricoImc> findByUser(Integer usuario);
}
