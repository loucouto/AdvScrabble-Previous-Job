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
public class PuntajePantalla {
    
    private int id;
    private String nombre;
    private String descripcion;
    private int nivel;
    private int puntaje;
    private Date fecha_hecho;
    private Date fecha_baja;
    private Estrella estrella;

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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
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

    public Estrella getEstrella() {
        return estrella;
    }

    public void setEstrella(Estrella estrella) {
        this.estrella = estrella;
    }

    public PuntajePantalla() {
    }

    public PuntajePantalla(int id, String nombre, String descripcion, int nivel, int puntaje, Date fecha_hecho, Date fecha_baja, Estrella estrella) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.puntaje = puntaje;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.estrella = estrella;
    }

    @Override
    public String toString() {
        return "PuntajePantalla{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", nivel=" + nivel + ", puntaje=" + puntaje + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", estrella=" + estrella + '}';
    }
  
}
