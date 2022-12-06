package mx.tecmilenio.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tecmilenio.dao.HistoricoImcDao;
import mx.tecmilenio.dao.UsuarioDao;
import mx.tecmilenio.entity.HistoricoImc;
import mx.tecmilenio.entity.Usuario;

@RestController
@RequestMapping("HistoricoImc")
public class HistoricoImcRest {
	@Autowired
	private HistoricoImcDao historicoImcDao;
	
	@DeleteMapping(value= "{idHistorico}")
	public ResponseEntity<HistoricoImc> delUsuarioById(@PathVariable("idHistorico") Integer idHistorico) {
		Optional<HistoricoImc> historico= historicoImcDao.findById(idHistorico);
		
		if(!historico.isPresent()) {
			return ResponseEntity.noContent().build();
			
		}else {
			historicoImcDao.deleteById(idHistorico);
			return ResponseEntity.ok(historico.get());
		}
	}
	
	@RequestMapping(value= "usuario/{idUsuario}")
	public ResponseEntity<List<HistoricoImc>>  getHistoricoByUsuario(@PathVariable("idUsuario") Integer idUsuario) {
		List<HistoricoImc> historico= historicoImcDao.findByUser(idUsuario);
		return ResponseEntity.ok(historico);

	}
	
	@RequestMapping(value= "{idHistorico}")
	public ResponseEntity<HistoricoImc> getHistoricoById(@PathVariable("idHistorico") Integer idHistorico) {
		Optional<HistoricoImc> historico= historicoImcDao.findById(idHistorico);
		
		if(!historico.isPresent()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(historico.get());
		}
	}
	@GetMapping
	public ResponseEntity<List<HistoricoImc>> getHistoricoImc() {
		List<HistoricoImc> histImc= historicoImcDao.findAll();
		return ResponseEntity.ok(histImc);

	}
	
	@PostMapping()
	public ResponseEntity<HistoricoImc> createHistorico(@RequestBody HistoricoImc historico) {
		HistoricoImc newHistorico= historicoImcDao.save(historico);
		return ResponseEntity.ok(newHistorico);
	}

}
