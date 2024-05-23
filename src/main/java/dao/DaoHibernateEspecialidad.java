package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entidad.Especialidad;
import entidad.Medico;

public class DaoHibernateEspecialidad {

	ConfigHibernate ch = new ConfigHibernate();
	Session session = ch.abrirConexion();

	public static void crearEspecialidad(Especialidad especialidad) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		session.save(especialidad);
		session.getTransaction().commit();
		session.close();

	}

	public static Especialidad obtenerEspecialidadPorId(int id) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		Especialidad especialidad = (Especialidad) session.get(Especialidad.class, id);
		session.close();

		return especialidad;
	}

	public static void actualizarEspecialidad(Especialidad especialidad) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		session.update(especialidad);
		session.getTransaction().commit();
		session.close();

	}

	public static void borrarEspecialidad(int id) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		session.beginTransaction();
		Especialidad especialidad = (Especialidad) session.get(Especialidad.class, id);
		if (especialidad != null) {
			session.delete(especialidad);
		}
		session.getTransaction().commit();
		session.close();
	}

	public static List<Especialidad> leerTodos() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Especialidad> lista = new ArrayList<Especialidad>();

		session.beginTransaction();
		Query queryEspecialidad = session.createQuery("SELECT m FROM Especialidad m");
		lista = queryEspecialidad.list();

		ch.cerrarSession();

		return lista;
	}

}
