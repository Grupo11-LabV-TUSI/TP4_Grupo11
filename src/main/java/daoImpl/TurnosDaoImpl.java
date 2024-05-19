package daoImpl;

import entidad.Turno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.IHibernateTurnoDao;

import java.util.List;

public abstract class TurnosDaoImpl implements IHibernateTurnoDao {
	private SessionFactory sessionFactory;

	public TurnosDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void crearTurno(Turno turno) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(turno);
		session.getTransaction().commit();
		session.close();
	}

	public Turno obtenerTurnoPorId(Long id) {
		Session session = sessionFactory.openSession();
		Turno turno = (Turno) session.get(Turno.class, id);
		session.close();
		return turno;
	}

	public void actualizarTurno(Turno turno) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(turno);
		session.getTransaction().commit();
		session.close();
	}

	public void borrarTurno(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Turno turno = (Turno) session.get(Turno.class, id);
		if (turno != null) {
			session.delete(turno);
		}
		session.getTransaction().commit();
		session.close();
	}

	public List<Turno> leerTodos() {
		Session session = sessionFactory.openSession();
		List<Turno> lista = session.createQuery("FROM Turno").list();
		session.close();
		return lista;
	}

	public void cerrar() {
		sessionFactory.close();
	}
}
