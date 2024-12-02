package cvx.Interfaces;

import cvx.Domain.Usuario;

import java.util.List;

public interface UsuarioRepository {

    void saveUsuario(Usuario usuario);
    void deleteUsuario(int id);
    void updateUsuario(Usuario usuario);

    Usuario findUsuarioId(int id);
    List<Usuario> findAllUsuarios();


}
