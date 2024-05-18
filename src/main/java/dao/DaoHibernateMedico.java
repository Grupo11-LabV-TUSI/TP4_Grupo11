package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import entidad.Medico;

public class DaoHibernateMedico {
    public static void crearMedico(Medico medico) {
        ConfigHibernate ch = new ConfigHibernate();
        Session session = ch.abrirConexion();

        session.beginTransaction();
        session.save(medico);
        session.getTransaction().commit();

        ch.cerrarSession();
    }

    public Medico obtenerMedicoPorId(Long id) {
        ConfigHibernate ch = new ConfigHibernate();
        Session session = ch.abrirConexion();
        
        session.beginTransaction();
        Medico medico = (Medico) session.get(Medico.class, id);
        session.getTransaction().commit();
        
        ch.cerrarSession();
        
        return medico;
    }

    public void actualizarMedico(Medico medico) {
        ConfigHibernate ch = new ConfigHibernate();
        Session session = ch.abrirConexion();

        session.beginTransaction();
        session.update(medico);
        session.getTransaction().commit();

        ch.cerrarSession();
    }

    public void borrarMedico(Long id) {
        ConfigHibernate ch = new ConfigHibernate();
        Session session = ch.abrirConexion();

        session.beginTransaction();
        Medico medico = (Medico) session.get(Medico.class, id);
        if (medico != null) {
            session.delete(medico);
        }
        session.getTransaction().commit();

        ch.cerrarSession();
    }

    public List<Medico> leerTodos() {
        ConfigHibernate ch = new ConfigHibernate();
        Session session = ch.abrirConexion();
        List<Medico> lista = new ArrayList<Medico>();

        session.beginTransaction();
        Query queryMedico = session.createQuery("SELECT m FROM Medico m");
        lista = queryMedico.list();

        ch.cerrarSession();

        return lista;
    }

}