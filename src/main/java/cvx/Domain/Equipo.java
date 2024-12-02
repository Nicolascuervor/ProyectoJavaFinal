package cvx.Domain;

import jakarta.persistence.*;
import java.util.List;

import java.util.Objects;

@Entity
@Table(name = "Equipos")

public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String ubicacion;
    
    
    @OneToMany(mappedBy = "equipo")
    private List<Reserva> reservas;
    
    


    public Equipo(String nombre, String tipo, String estado, String ubicacion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.estado = estado;
        this.ubicacion = ubicacion; 
    }

    public Equipo() {}


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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

   
    
   
    
    

    @Override
    public String toString() {
        return "Informacion de equipo: " +
                "ID de equipo = |" + id + "|\t" +
                "Nombre = |" + nombre + "|\t" +
                "Tipo = |" + tipo + "|\t" +
                "Estado = |" + estado + "|\t" +
                "Ubicacion |" + ubicacion + "|\t";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return id == equipo.id && Objects.equals(nombre, equipo.nombre) && Objects.equals(tipo, equipo.tipo) && Objects.equals(estado, equipo.estado) && Objects.equals(ubicacion, equipo.ubicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, tipo, estado, ubicacion);
    }
}
