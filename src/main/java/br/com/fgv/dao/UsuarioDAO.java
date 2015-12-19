package br.com.fgv.dao;

import java.util.List;

import br.com.fgv.entidade.Usuario;

public interface UsuarioDAO {

	public Usuario salvar(Usuario usuario);

	//select by id
	public Usuario buscarPorId(int id);

	public List<Usuario> buscarTodos();

	public void excluir(Usuario usuario) throws DAOException;

	public Usuario BuscarLogin(String login);

}