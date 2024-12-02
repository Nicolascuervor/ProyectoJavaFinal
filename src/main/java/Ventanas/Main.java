package Ventanas;

import cvx.Aplication.Services.EquipoService;
import cvx.Aplication.Services.ReservaService;
import cvx.Aplication.Services.UsuarioService;
import cvx.Domain.Usuario;
import cvx.InfrasEstucture.FileEquipoRepository;
import cvx.InfrasEstucture.FileReservaRepository;
import cvx.InfrasEstucture.FileUsuarioRepository;
import cvx.Interfaces.EquipoRepository;
import cvx.Interfaces.ReservaRepository;
import cvx.Interfaces.UsuarioRepository;

public class Main {
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(() -> {
            UsuarioRepository repository1 = new FileUsuarioRepository();
            UsuarioService service1 = new UsuarioService(repository1);

            EquipoRepository repository2 = new FileEquipoRepository();
            EquipoService service2 = new EquipoService(repository2);

            ReservaRepository repository3 = new FileReservaRepository();
            ReservaService service3 = new ReservaService(repository3);
            
            Usuario usuario = new Usuario();


            IngresoDeUsuario visualApp = new IngresoDeUsuario(service1,service2,service3,usuario);
            visualApp.setVisible(true);

        });

    }
}
