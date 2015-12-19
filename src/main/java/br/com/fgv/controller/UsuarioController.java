package br.com.fgv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fgv.entidade.Usuario;
import br.com.fgv.service.ServiceException;
import br.com.fgv.service.UsuarioService;

@Controller(value="usuCtrl")
public class UsuarioController {
	private Usuario usuario = new Usuario();
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	
	public void salvar(){
		try {
			usuarioService.salvar(usuario);
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
	
	
}
