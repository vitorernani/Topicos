package br.unitins.books.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.books.application.Util;
import br.unitins.books.model.Entity;
import br.unitins.books.model.Usuario;

@Named
@ViewScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = -563227102506849534L;

	private Usuario usuario;
	private List<Usuario> listaUsuario;
	
	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getListaUsuario() {
		if (listaUsuario == null)
			listaUsuario = new ArrayList<Usuario>();
		return listaUsuario;
	}


	public void incluir() {
		if(getUsuario().getNome().equals("")) {
			Util.addErrorMessage("o campo nome deve ser informado");
			return;
			
		}
		getUsuario().setId(proximoId());
		getListaUsuario().add(getUsuario());
		limpar();
 	}

	public void alterar() {
		Integer index = getListaUsuario().indexOf(getUsuario());
		getListaUsuario().set(index, getUsuario());
		limpar();
	}

	public void remover() {
		getListaUsuario().remove(getUsuario());
		limpar();
	}
	
	public void limpar() {
		usuario = null;
	}
	
	public void editar(Usuario objeto) {
		setUsuario(objeto.getClone());
	}

	private int proximoId() {
		int resultado = 0;
		
		for (Usuario usuario : listaUsuario) {
			if(usuario.getId() > resultado)
				resultado = usuario.getId();
		}
		return resultado++;
	}	

}
