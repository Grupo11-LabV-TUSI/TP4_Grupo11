package dao;

import java.util.List;

import entidad.Usuario;

public interface IHibernateUsuarioDao {
	void crearUsuario(Usuario usuario);
    Usuario obtenerUsuarioPorId(Long id);
    void actualizarUsuario(Usuario usuario);
    void borrarUsuario(Long id);
    List<Usuario> listarUsuarios();
}
