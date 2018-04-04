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
public class TipoPerfil {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String desc_abreviada;
    private Date fecha_hecho;
    private Date fecha_baja;
    private ArrayList<PermisoFuncionalidad> permiso_funcionalidad;

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

    public String getDesc_abreviada() {
        return desc_abreviada;
    }

    public void setDesc_abreviada(String desc_abreviada) {
        this.desc_abreviada = desc_abreviada;
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

    public ArrayList<PermisoFuncionalidad> getPermiso_funcionalidad() {
        return permiso_funcionalidad;
    }

    public void setPermiso_funcionalidad(ArrayList<PermisoFuncionalidad> permiso_funcionalidad) {
        this.permiso_funcionalidad = permiso_funcionalidad;
    }

    public TipoPerfil() {
    }

    public TipoPerfil(int id, String nombre, String descripcion, String desc_abreviada, Date fecha_hecho, Date fecha_baja, ArrayList<PermisoFuncionalidad> permiso_funcionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.desc_abreviada = desc_abreviada;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.permiso_funcionalidad = permiso_funcionalidad;
    }

    @Override
    public String toString() {
        return "TipoPerfil{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", desc_abreviada=" + desc_abreviada + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", permiso_funcionalidad=" + permiso_funcionalidad + '}';
    }
    
}
