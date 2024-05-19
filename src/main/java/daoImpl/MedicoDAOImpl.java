package daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.IHibernateMedicoDao;
import entidad.Medico;

public abstract class MedicoDAOImpl implements IHibernateMedicoDao {
	private SessionFactory sessionFactory;

	public MedicoDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void crearMedico(Medico medico) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(medico);
		session.getTransaction().commit();
		session.close();
	}

	public Medico obtenerMedicoPorId(Long id) {
		Session session = sessionFactory.openSession();
		Medico medico = (Medico) session.get(Medico.class, id);
		session.close();
		return medico;
	}

	public void actualizarMedico(Medico medico) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(medico);
		session.getTransaction().commit();
		session.close();
	}

	public void borrarMedico(Long id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Medico medico = (Medico) session.get(Medico.class, id);
		if (medico != null) {
			session.delete(medico);
		}
		session.getTransaction().commit();
		session.close();
	}

	public void cerrar() {
		sessionFactory.close();
	}
}