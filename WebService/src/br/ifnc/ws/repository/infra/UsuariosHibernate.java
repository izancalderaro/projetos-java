package br.ifnc.ws.repository.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import br.ifnc.ws.model.Usuario;
import br.ifnc.ws.repository.Usuarios;
import br.ifnc.ws.util.HibernateUtil;

public class UsuariosHibernate implements Usuarios {

	private Session session;
	
	public UsuariosHibernate() {
		this.session = HibernateUtil.getSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> todos() {

		return session.createCriteria(Usuario.class).addOrder(Order.asc("nome")).list();
	}

	@Override
	public Usuario porCodigo(int id) {
		return (Usuario) session.get(Usuario.class, id);
	}

	@Override
	public boolean apagarCadastro(int id) {

		Transaction trx = session.beginTransaction();
		try {
			//this.porCodigo(id);
			session.delete(this.porCodigo(id));
			trx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			trx.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean inserirCadastro(Usuario usr) {
		
		Transaction trx = session.beginTransaction();
		try {
			session.save(usr);
			trx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			trx.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean atualizarCadastro(Usuario usr) {

		Transaction trx = session.beginTransaction();
		try {
			session.merge(usr);
			trx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			trx.rollback();
			return false;
		}
		return true;
	}

}
