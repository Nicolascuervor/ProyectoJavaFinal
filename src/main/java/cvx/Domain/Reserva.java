package cvx.Domain;
import jakarta.persistence.*;
import java.util.Date;

import java.util.Objects;

@Entity
@Table(name = "Reservas")


public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
        
    
    @Column(nullable = false)
    private Date fechaInicio;

    @Column(nullable = false)
    private Date fechaFin;
    
    @ManyToOne
    @JoinColumn(name = "usuario_uid")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "equipo_uid")
    private Equipo equipo;

    
   

    public Reserva(Date fechaInicio, Date fechaFin, Usuario usuario, Equipo equipo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.usuario = usuario;
        this.equipo = equipo;
    }

    public Reserva() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Informacion de reserva: " +
                "ID de reserva = |" + id + "|\t" +
                "Fecha de inicio |" + fechaInicio + "|\t" +
                "Fecha de finalizacion = |" + fechaFin + "|\t" +
                "Nombre del usuaario = |" + usuario.getNombre() + "|\t" +
                "Equipo reservado |" + equipo.getNombre() + "|\t";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return id == reserva.id && Objects.equals(fechaInicio, reserva.fechaInicio) && Objects.equals(fechaFin, reserva.fechaFin) && Objects.equals(usuario, reserva.usuario) && Objects.equals(equipo, reserva.equipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaInicio, fechaFin, usuario, equipo);
    }
}
