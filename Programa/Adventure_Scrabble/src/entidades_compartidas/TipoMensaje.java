/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades_compartidas;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ubuntulourdes
 */
public class TipoMensaje {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String archivo;
    private String ubicacion;
    private Image imagen;
    private Date fecha_hecho;
    private Date fecha_baja;
    private ArrayList<Mensaje> lista_mensaje;

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

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
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

    public ArrayList<Mensaje> getLista_mensaje() {
        return lista_mensaje;
    }

    public void setLista_mensaje(ArrayList<Mensaje> lista_mensaje) {
        this.lista_mensaje = lista_mensaje;
    }

   

    public TipoMensaje() {
    }

    public TipoMensaje(int id, String nombre, String descripcion, String archivo, String ubicacion, Image imagen, Date fecha_hecho, Date fecha_baja, ArrayList<Mensaje> lista_mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.lista_mensaje = lista_mensaje;
    }

    @Override
    public String toString() {
        return "TipoMensaje{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", archivo=" + archivo + ", ubicacion=" + ubicacion + ", imagen=" + imagen + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", lista_mensaje=" + lista_mensaje + '}';
    }
}
