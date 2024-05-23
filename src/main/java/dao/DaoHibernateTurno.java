package dao;

import entidad.Turno;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.List;

public class DaoHibernateTurno {
	public static void crearTurno(Turno turno) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		session.save(turno);
		session.getTransaction().commit();

		ch.cerrarSession();
	}

	public static Turno obtenerTurnoPorId(Long id) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		Turno turno = (Turno) session.get(Turno.class, id);
		session.getTransaction().commit();

		ch.cerrarSession();

		return turno;
	}

	public static void actualizarTurno(Turno turno) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		session.update(turno);
		session.getTransaction().commit();

		ch.cerrarSession();
	}

	public static void borrarTurno(Long id) {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();

		session.beginTransaction();
		Turno turno = (Turno) session.get(Turno.class, id);
		if (turno != null) {
	        turno.getMedico().getTurnos().remove(turno);
	        turno.getPaciente().getTurnos().remove(turno);
			session.delete(turno);
		}
		session.getTransaction().commit();

		ch.cerrarSession();
	}

	public static List<Turno> leerTodos() {
		ConfigHibernate ch = new ConfigHibernate();
		Session session = ch.abrirConexion();
		List<Turno> lista = new ArrayList<Turno>();

		session.beginTransaction();
		Query queryTurno = session.createQuery("SELECT t FROM Turno t");
		lista = queryTurno.list();

		ch.cerrarSession();

		return lista;
	}
}
