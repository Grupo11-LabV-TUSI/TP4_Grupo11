package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entidad.Medico;

public class DaoHibernateMedico {
	 private SessionFactory sessionFactory;

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
