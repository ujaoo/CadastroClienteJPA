package br.com.cadastro.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cadastro.model.Cliente;

@Repository
public class ClienteDAO extends AbstractDaoImpl<Cliente> {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Cliente inserir(Cliente obj) throws Exception {
		entityManager.persist(obj);
		return obj;
	}

	@Override
	@Transactional
	public Cliente alterar(Cliente obj) throws Exception {
		return entityManager.merge(obj);
	}

	@Override
	@Transactional
	public boolean excluir(Cliente obj) throws Exception {
		Cliente cliente = entityManager.find(Cliente.class, obj.getId());
		if (cliente != null) {
			entityManager.remove(cliente);
			return true;
		}
		return false;
	}

	@Override
	public Cliente buscarPorCodigo(Long id) throws Exception {
		return entityManager.find(Cliente.class, id);
	}
	
	@Override
	 public List<Cliente> buscarTodos() throws Exception {
	        String jpql = "SELECT c FROM Cliente c";  
	        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
	        return query.getResultList();
	    }
	 
	public List<Cliente> pesquisarDesc(String pesquisa) throws Exception {
	    String jpql = "SELECT c FROM Cliente c WHERE UPPER(c.nome) LIKE :nome";
	    pesquisa = "%" + pesquisa.toUpperCase().trim() + "%";
	    TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
	    query.setParameter("nome", pesquisa);
	    return query.getResultList(); 
	}

}
