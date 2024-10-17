package br.com.cadastro.dao;

import java.util.List;

import br.com.cadastro.model.BaseEntity;
import br.com.cadastro.model.Cliente;

public interface AbstractDao <T extends BaseEntity>{
	
	public T inserir(T obj) throws Exception;
	
	public T alterar(T obj) throws Exception;
	
	public boolean excluir(T obj) throws Exception;
	
	public T buscarPorCodigo(Long id) throws Exception;

	List<T> buscarTodos() throws Exception;
	
}

