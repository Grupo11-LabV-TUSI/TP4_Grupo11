
package daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;
import org.hibernate.Query;
import dao.ConfigHibernate;
import dao.DaoHibernateUsuario;
import dao.IHibernateUsuarioDao;
import entidad.Usuario;

public abstract class UsuarioDAOImpl implements IHibernateUsuarioDao {
	private SessionFactory sessionFactory;

	public void crearUsuario(Usuario usuario) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(usuario);
		session.getTransaction().commit();
		session.close();
	}

	public Usuario obtenerUsuarioPorId(Long id) {
		Session session = sessionFactory.openSession();
		Usuario usuario = (Usuario) session.get(Usuario.class, id);
		session.close();
		return usuario;
	}

	public void actualizarUsuario(Usuario usuario) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(usuario);
		session.getTransaction().commit();
		session.close();
	}

	public void borrarUsuario(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Usuario usuario = (Usuario) session.get(Usuario.class, id);
		if (usuario != null) {
			session.delete(usuario);
		}
		session.getTransaction().commit();
		session.close();
	}

	// Cerrar el SessionFactory
	public void cerrar() {
		sessionFactory.close();
	}
}
