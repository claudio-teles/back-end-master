package claudioteles.com.github.backendmaster.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import claudioteles.com.github.backendmaster.model.Administrador;
import claudioteles.com.github.backendmaster.repository.AdministradorRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:5000"})
public class IdentificacaoController {

	@Autowired
	private AdministradorRepository ar;

	@PutMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Faz um login no PostgreSQL")
	public Administrador indentificar(@RequestBody Map<String, String> loginJson) {
		if (ar.existsByNome(loginJson.get("nome")) && ar.existsBySenha(loginJson.get("senha"))) {
			Administrador adm = ar.findByNome(loginJson.get("nome")).get();
			adm.setLogin(true);
			ar.save(adm);
			return adm;
		}
		return null;
	}

	@GetMapping("/logout/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Faz o logout")
	public Map<String, Boolean> sair(@PathVariable("id") Long id) {
		Administrador adm = ar.findById(id).get();
		adm.setLogin(false);
		ar.save(adm);
		Map<String, Boolean> resposta = new HashMap<>();
		resposta.put("logado", false);
		return resposta;
	}

}
