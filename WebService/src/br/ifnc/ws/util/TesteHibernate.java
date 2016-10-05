package br.ifnc.ws.util;

import java.util.List;

import br.ifnc.ws.model.Usuario;
import br.ifnc.ws.repository.infra.UsuariosHibernate;

public class TesteHibernate {

	public static void main(String[] args) {
		UsuariosHibernate usr = new UsuariosHibernate();
		
		boolean teste = usr.inserirCadastro(new Usuario(null,"pedro",60));
		//boolean teste = usr.atualizarCadastro(new Usuario(14,"pedro",45));
		//boolean teste =usr.apagarCadastro(13);
		//Usuario teste = usr.porCodigo(10);
		
		System.out.println(teste);
		

		
		List<Usuario> t = usr.todos();
		
		for (Usuario u : t) {
			
			System.out.println(u.toString());
		}
		
		

		
	}

}
