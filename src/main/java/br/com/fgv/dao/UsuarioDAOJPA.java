package br.com.fgv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fgv.entidade.Usuario;
@Repository
public class UsuarioDAOJPA implements UsuarioDAO {
	@PersistenceContext
	EntityManager em;
	public UsuarioDAOJPA(EntityManager em){
		this.em = em;
	}
	public UsuarioDAOJPA(){
		
	}
	/* (non-Javadoc)
	 * @see br.com.fgv.dao.UsuarioDAO#salvar(br.com.fgv.entidade.Usuario)
	 */
	@Override
	@Transactional
	public Usuario salvar (Usuario usuario){
		
		Usuario u = em.merge(usuario);

		return u;
	}
	//select by id
	/* (non-Javadoc)
	 * @see br.com.fgv.dao.UsuarioDAO#buscarPorId(int)
	 */
	@Override
	public Usuario buscarPorId(int id){
		return em.find(Usuario.class, id);
	}
	/* (non-Javadoc)
	 * @see br.com.fgv.dao.UsuarioDAO#buscarTodos()
	 */
	@Override
	public List<Usuario> buscarTodos(){
		Query q = em.createQuery("select u from Usuario u");
		return q.getResultList();
	}
	/* (non-Javadoc)
	 * @see br.com.fgv.dao.UsuarioDAO#excluir(br.com.fgv.entidade.Usuario)
	 */
	@Override
	@Transactional
	public void excluir (Usuario usuario) throws DAOException{
		try{
		em.remove(usuario);
		}catch(Exception e){
			throw new DAOException("Não foi possível excluir", e);
			
		}
		
	}
	@Override
	public Usuario BuscarLogin(String login) {
		try{
		Query q = em.createQuery("select u from Usuario u where u.login=:loginParameter");
		q.setParameter("loginParameter", login);
		q.setMaxResults(1);
		return (Usuario) q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
		
	}
	
}
