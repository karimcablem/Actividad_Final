package mx.tecmilenio.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.tecmilenio.dao.UsuarioDao;
import mx.tecmilenio.entity.Usuario;

@RestController
@RequestMapping("Usuario")
public class UsuarioRest {

	@Autowired
	private UsuarioDao usuarioDao;
//	@GetMapping

	@PutMapping()
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
		Optional<Usuario> optionalUsuario= usuarioDao.findById(usuario.getIdUsuario());
		
		if(!optionalUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			Usuario updateUsuario= optionalUsuario.get();

			updateUsuario.setEdad(usuario.getEdad());
			updateUsuario.setNombre(usuario.getNombre());
			updateUsuario.setPassword(usuario.getPassword());
			updateUsuario.setSexo(usuario.getSexo());
			usuarioDao.save(updateUsuario);
			return ResponseEntity.ok(updateUsuario);
		}
	}
	
	@PostMapping()
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		Usuario newUsuario= usuarioDao.save(usuario);
		return ResponseEntity.ok(newUsuario);
	}

	@DeleteMapping(value= "{idUsuario}")
	public ResponseEntity<Usuario> delUsuarioById(@PathVariable("idUsuario") Integer idUsuario) {
		Optional<Usuario> usuarios= usuarioDao.findById(idUsuario);
		
		if(!usuarios.isPresent()) {
			return ResponseEntity.noContent().build();
			
		}else {
			usuarioDao.deleteById(idUsuario);
			return ResponseEntity.ok(usuarios.get());
		}
	}
	
	@RequestMapping(value= "{idUsuario}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable("idUsuario") Integer idUsuario) {
		Optional<Usuario> usuarios= usuarioDao.findById(idUsuario);
		
		if(!usuarios.isPresent()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(usuarios.get());
		}
	}
	
	@RequestMapping(value= "user/{usuario}")
	public ResponseEntity<Usuario> getUsuarioByUser(@PathVariable("usuario") String usuario) {
		Optional<Usuario> usuarios= usuarioDao.findByUser(usuario);
		
		if(!usuarios.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(usuarios.get());
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuario() {
		List<Usuario> usuarios= usuarioDao.findAll();
		return ResponseEntity.ok(usuarios);

	}
}
