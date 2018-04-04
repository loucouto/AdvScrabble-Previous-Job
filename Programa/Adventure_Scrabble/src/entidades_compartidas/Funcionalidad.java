/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades_compartidas;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ubuntulourdes
 */
public class Funcionalidad {
 
    private int id;
    private String titulo;
    private String descripcion;
    private Date fecha_hecho;
    private Date fecha_baja;
    private ArrayList<SubFuncionalidad> sub_funcionalidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public ArrayList<SubFuncionalidad> getSub_funcionalidad() {
        return sub_funcionalidad;
    }

    public void setSub_funcionalidad(ArrayList<SubFuncionalidad> sub_funcionalidad) {
        this.sub_funcionalidad = sub_funcionalidad;
    }

    public Funcionalidad() {
    }

    public Funcionalidad(int id, String titulo, String descripcion, Date fecha_hecho, Date fecha_baja, ArrayList<SubFuncionalidad> sub_funcionalidad) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.sub_funcionalidad = sub_funcionalidad;
    }

    @Override
    public String toString() {
        return "Funcionalidad{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", sub_funcionalidad=" + sub_funcionalidad + '}';
    }

}
