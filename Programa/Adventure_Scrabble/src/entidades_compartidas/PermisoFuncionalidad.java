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
public class PermisoFuncionalidad {
    
    private int id;
    private String nombre;
    private String descripcion;
    private Date fecha_hecho;
    private Date fecha_baja;
    private TipoPermiso tipo_permiso;
    private ArrayList<Funcionalidad> lista_funcionalidad;

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

    public TipoPermiso getTipo_permiso() {
        return tipo_permiso;
    }

    public void setTipo_permiso(TipoPermiso tipo_permiso) {
        this.tipo_permiso = tipo_permiso;
    }

    public ArrayList<Funcionalidad> getLista_funcionalidad() {
        return lista_funcionalidad;
    }

    public void setLista_funcionalidad(ArrayList<Funcionalidad> lista_funcionalidad) {
        this.lista_funcionalidad = lista_funcionalidad;
    }

    public PermisoFuncionalidad() {
    }

    public PermisoFuncionalidad(int id, String nombre, String descripcion, Date fecha_hecho, Date fecha_baja, TipoPermiso tipo_permiso, ArrayList<Funcionalidad> lista_funcionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.tipo_permiso = tipo_permiso;
        this.lista_funcionalidad = lista_funcionalidad;
    }

    @Override
    public String toString() {
        return "PermisoFuncionalidad{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", tipo_permiso=" + tipo_permiso + ", lista_funcionalidad=" + lista_funcionalidad + '}';
    }
    
}
