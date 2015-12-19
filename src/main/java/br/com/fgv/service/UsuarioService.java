package br.com.fgv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.fgv.dao.DAOException;
import br.com.fgv.dao.UsuarioDAO;
import br.com.fgv.entidade.Usuario;

@Service
public class UsuarioService {
	@Autowired
	@Qualifier("usuarioDAOJPA")
	UsuarioDAO usuDAO;
	public Usuario salvar(Usuario usuario) throws ServiceException{
		Usuario usuarioExistente = usuDAO.BuscarLogin(usuario.getLogin());
		if(usuarioExistente!=null){
			throw new ServiceException("Usuario j� existe!");
		}
		return usuDAO.salvar(usuario);
	}
	public void excluir(Usuario usuario) throws ServiceException, DAOException{
		Usuario usuarioExistente = usuDAO.BuscarLogin(usuario.getLogin());
		if(usuarioExistente!=null){
			throw new ServiceException("Usuario n�o existe");
		}
		usuDAO.excluir(usuario);
	}
	public Usuario buscarPorId(int id) throws ServiceException{
		Usuario usuarioBuscado = usuDAO.buscarPorId(id);
		if(usuarioBuscado!=null){
			throw new ServiceException("Usuario n�o encontrado");
		}
		return usuarioBuscado;
	}
	//falta o listar usuarios
	

}
