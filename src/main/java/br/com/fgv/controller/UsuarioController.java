package br.com.fgv.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fgv.entidade.Usuario;
import br.com.fgv.service.ServiceException;
import br.com.fgv.service.UsuarioService;

@Controller(value="usuCtrl")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarioList;
	
	public UsuarioController(){
		
	}
	@PostConstruct
	public void init(){
		try {
			setUsuarioList(usuarioService.buscarTodos());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void salvar(){
		try {
			Usuario usuSalvo = usuarioService.salvar(usuario);
			usuarioList.add(usuSalvo);
			usuario = new Usuario();
			System.out.println("SUCESSO!!!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}
	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}
	
	
}
