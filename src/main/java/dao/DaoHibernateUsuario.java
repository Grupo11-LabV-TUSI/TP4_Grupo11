package dao;

import entidad.Paciente;
import entidad.Usuario;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoHibernateUsuario {
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
	public static List<Usuario> leerTodos() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Usuario> lista = new ArrayList<Usuario>();

		session.beginTransaction();

		Query queryUsuario = session.createQuery("Select p FROM Usuario p");
		lista = queryUsuario.list();

		return lista;
	}
	// Cerrar el SessionFactory
	public void cerrar() {
		sessionFactory.close();
	}

}
