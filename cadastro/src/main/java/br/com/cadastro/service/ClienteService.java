package br.com.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.dao.AbstractDao;
import br.com.cadastro.dao.ClienteDAO;
import br.com.cadastro.model.Cliente;

@Service
public class ClienteService extends AbstractService<Cliente> {

	@Autowired
	ClienteDAO dao;

	@Override
	public AbstractDao<Cliente> getDao() {
		return dao;
	}
	
	public List<Cliente> pesquisarDesc(String pesquisa) throws Exception{
		return dao.pesquisarDesc(pesquisa);
	}

}
