/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades_compartidas;

import java.util.Date;

/**
 *
 * @author ubuntulourdes
 */
public class Condicionante {
    
    private int id;
    private String nombre;
    private String descripcion;
    private Date fecha_hecho;
    private Date fecha_baja;
    private TipoCondicionante tipo_condicionante;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_hecho() {
        return fecha_hecho;
    }

    public void setFecha_hecho(Date fecha_hecho) {
        this.fecha_hecho = fecha_hecho;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public TipoCondicionante getTipo_condicionante() {
        return tipo_condicionante;
    }

    public void setTipo_condicionante(TipoCondicionante tipo_condicionante) {
        this.tipo_condicionante = tipo_condicionante;
    }

    public Condicionante() {
    }

    public Condicionante(int id, String nombre, String descripcion, Date fecha_hecho, Date fecha_baja, TipoCondicionante tipo_condicionante) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.tipo_condicionante = tipo_condicionante;
    }

    @Override
    public String toString() {
        return "Condicionante{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", tipo_condicionante=" + tipo_condicionante + '}';
    }
      
}
