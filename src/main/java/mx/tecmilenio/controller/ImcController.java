package mx.tecmilenio.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mx.tecmilenio.dao.HistoricoImcDao;
import mx.tecmilenio.dao.UsuarioDao;
import mx.tecmilenio.entity.HistoricoImc;
import mx.tecmilenio.entity.Usuario;

@Controller
@RequestMapping("/")
public class ImcController {
	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private HistoricoImcDao historicoImcDao;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "HistoricoImc", method = RequestMethod.POST, params = "guardar")
	public String createImc(@RequestParam("altura") String altura, @RequestParam("peso") String peso,
			HttpSession session, ModelMap modelMap) {


		if (altura.equals("")==true) {
			modelMap.put("error", "Altura invalida");
			return "success";
		}else if (peso.equals("")==true) {
			modelMap.put("error", "Peso invalido");
			return "success";
		}
		if (Double.parseDouble(altura) >= 1.0 && Double.parseDouble(altura) <= 2.5) {
			HistoricoImc newHistorico = new HistoricoImc();
			newHistorico.setIdUsuario(Integer.parseInt(session.getAttribute("idusuario").toString()));
			newHistorico.setAltura(Float.parseFloat(altura));
			newHistorico.setPeso(Float.parseFloat(peso));

			Float imc = Float.parseFloat(peso) / (Float.parseFloat(altura) * Float.parseFloat(altura));
			newHistorico.setImc(imc);

			historicoImcDao.save(newHistorico);		
			
			List<HistoricoImc> historico = historicoImcDao
					.findByUser(Integer.parseInt(session.getAttribute("idusuario").toString()));
			for (HistoricoImc imc2 : historico) {
				System.out.println(imc2.getImc());
			}

			modelMap.put("imclist", historico);
			return "success";
		} else {
			modelMap.put("error", "Altura fuera de rango");
			return "success";
		}

	}

	@RequestMapping(value = "CreateUser", method = RequestMethod.POST)
	public String createUser(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("nombre") String nombre, @RequestParam("edad") String edad, @RequestParam("sexo") String sexo,
			HttpSession session, ModelMap modelMap) {
		Optional<Usuario> usuarios = usuarioDao.findByUser(username);

		if (!usuarios.isPresent()) {
			Usuario user = new Usuario();
			user.setEdad(Integer.parseInt(edad));
			user.setUsuario(username);
			user.setNombre(nombre);
			user.setPassword(password);
			user.setSexo(sexo);
			usuarioDao.save(user);
			return "index";
		} else {
			modelMap.put("error", "Usuario ya existe");
			return "newuser";
		}
	}

	@RequestMapping(value = "login", method = RequestMethod.POST, params = "newuser")
	public String newuser() {
		return "newuser";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST, params = "login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session, ModelMap modelMap) {
		Optional<Usuario> usuarios = usuarioDao.findByUser(username);

		if (!usuarios.isPresent()) {
			modelMap.put("error", "Invalid Account");
			return "index";
		} else {

			if (password.equals(usuarios.get().getPassword())) {
				session.setAttribute("username", username);
				session.setAttribute("nombre", usuarios.get().getNombre());
				session.setAttribute("idusuario", usuarios.get().getIdUsuario());
				List<HistoricoImc> historico = historicoImcDao
						.findByUser(Integer.parseInt(session.getAttribute("idusuario").toString()));
				for (HistoricoImc imc : historico) {
					System.out.println(imc.getImc());
				}

				modelMap.put("imclist", historico);
				return "success";
			} else {
				modelMap.put("error", "Invalid Account");
				return "index";
			}
		}

	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:/";
	}

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public void error(HttpSession session) {
		session.removeAttribute("username");
		System.out.println("error de jsp");

	}
}
