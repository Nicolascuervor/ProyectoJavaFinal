package cvx.Aplication.Services;

import cvx.Domain.Usuario;
import cvx.Interfaces.UsuarioRepository;

import java.util.List;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void registrarUsuario(Usuario usuario) {
        usuarioRepository.saveUsuario(usuario);
    }

    public List<Usuario> listaUsuarios() {
        return usuarioRepository.findAllUsuarios();
    }

    public void eliminarUsuario(int id) {
        usuarioRepository.deleteUsuario(id);
    }

    public Usuario obtenerUsuario(int id) {
        return usuarioRepository.findUsuarioId(id);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.updateUsuario(usuario);
    }
}
