package br.com.cadastro.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.model.Cliente;
import br.com.cadastro.service.ClienteService;

@RestController
@RequestMapping("cliente")
@CrossOrigin(value = "*")
public class ClienteRest {

	@Autowired
	ClienteService clienteService;

	@PostMapping
	public Cliente inserir(@RequestBody Cliente obj) throws Exception {
		return clienteService.inserir(obj);
	}

	@PutMapping
	public Cliente alterar(@RequestBody Cliente obj) throws Exception {
		if (obj.getId() == null) {
			throw new Exception("O ID do cliente deve ser fornecido para a alteração.");
		}
		return clienteService.alterar(obj);
	}

	@DeleteMapping(path = "/{id}")
	public boolean delete(@PathVariable("id") Long id) throws Exception {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		return clienteService.excluir(cliente);
	}

	@GetMapping(path = "/{id}")
	public Cliente buscarPorCodigo(@PathVariable("id") Long id) throws Exception {
		return clienteService.buscarPorCodigo(id);
	}

	@PostMapping(path = "buscarTodos")
	public List<Cliente> buscarTodos() throws Exception {
		return clienteService.buscarTodos();
	}

	@PostMapping(path = "/pesquisarDesc")
	public List<Cliente> pesquisarPorDescricao(@RequestBody String pesquisa) throws Exception {
		return clienteService.pesquisarDesc(pesquisa);
	}

}
