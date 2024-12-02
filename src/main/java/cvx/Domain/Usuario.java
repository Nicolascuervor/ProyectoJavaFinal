package cvx.Domain;


import jakarta.persistence.*;
import java.util.List;

import java.util.Objects;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String rol;
    
    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;
    


    public Usuario(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public Usuario() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Informacion del usuario: " +
                "ID del usuario = |" + id + "|\t" +
                "Nombre = |" + nombre + "|\t" +
                "Rol = |" + rol + "|\t";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && Objects.equals(nombre, usuario.nombre) && Objects.equals(rol, usuario.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, rol);
    }
}
