package br.ifnc.ws.repository;

import java.util.List;

import br.ifnc.ws.model.Usuario;

public interface Usuarios {

	public List<Usuario> todos();
	public Usuario porCodigo(int id);
	public boolean apagarCadastro(int id);
	public boolean inserirCadastro(Usuario usr);
	public boolean atualizarCadastro(Usuario usr);
}
