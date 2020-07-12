package claudioteles.com.github.backendmaster.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import claudioteles.com.github.backendmaster.model.Cliente;
import claudioteles.com.github.backendmaster.repository.AdministradorRepository;
import claudioteles.com.github.backendmaster.repository.ClienteRepository;
import io.swagger.annotations.ApiOperation;

@RestController("/")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:5000"})
public class ClienteController {

	@Autowired
	private AdministradorRepository ar;
	@Autowired
	private ClienteRepository cr;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Página Inicial")
	public Map<String, String> homePage() {
		Map<String, String> mensagem = new HashMap<>();
		mensagem.put("mensagem", "Bem Vindo!");
		return mensagem;
	}

	@PostMapping("/cliente")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Salva um cliente no PostgreSQL")
	public Cliente criar(@RequestParam("admId") Long admId, @RequestBody Cliente cliente) {
		if (ar.findById(admId).get().getLogin()) {
			return cr.save(cliente);
		}
		return null;
	}

	@GetMapping("/cliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Obtem um cliente no PostgreSQL")
	public Cliente ler(@RequestParam("admId") Long admId, @PathVariable("id") Long id) {
		if (ar.findById(admId).get().getLogin()) {
			return cr.findById(id).get();
		}
		return null;
	}

	@GetMapping("/cliente")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Obtém um cliente no PostgreSQL através do nome")
	public Cliente ler(@RequestParam("admId") Long admId, @RequestParam("nome") String nome) {
		if (ar.findById(admId).get().getLogin()) {
			return cr.findByNome(nome).get();
		}
		return null;
	}

	@GetMapping("/clientes")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Obtém todos os clientes no PostgreSQL")
	public List<Cliente> lerTodos(@RequestParam("admId") Long admId) {
		if (ar.findById(admId).get().getLogin()) {
			return cr.findAllByOrderByIdClienteAsc();
		}
		return null;
	}

	@PutMapping("/cliente")
	@ResponseStatus(HttpStatus.RESET_CONTENT)
	@ApiOperation(value = "Atualiza um cliente no PostgreSQL")
	public void atualizar(@RequestParam("admId") Long admId, @RequestBody Cliente cliente) {
		if (ar.findById(admId).get().getLogin()) {
			cr.save(cliente);
		}
	}

	@DeleteMapping("/cliente/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Deleta um cliente no PostgreSQL")
	public void deletar(@RequestParam("admId") Long admId, @PathVariable("id") Long id) {
		if (ar.findById(admId).get().getLogin()) {
			cr.delete(cr.findById(id).get());
		}
	}

}
