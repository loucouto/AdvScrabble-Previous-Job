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
public class Mapa {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String archivo;
    private String ubicacion;
    private Image imagen;
    private Date fecha_hecho;
    private Date fecha_baja;
    private ArrayList<Pantalla> lista_pantalla;
    private ArrayList<ImagenMapa> lista_imagen_pantalla;

    public ArrayList<ImagenMapa> getLista_imagen_pantalla() {
        return lista_imagen_pantalla;
    }

    public void setLista_imagen_pantalla(ArrayList<ImagenMapa> lista_imagen_pantalla) {
        this.lista_imagen_pantalla = lista_imagen_pantalla;
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

    public ArrayList<Pantalla> getLista_pantalla() {
        return lista_pantalla;
    }

    public void setLista_pantalla(ArrayList<Pantalla> lista_pantalla) {
        this.lista_pantalla = lista_pantalla;
    }

    public Mapa() {
    }

    public Mapa(int id, String nombre, String descripcion, String archivo, String ubicacion, Image imagen, Date fecha_hecho, Date fecha_baja, ArrayList<Pantalla> lista_pantalla, ArrayList<ImagenMapa> lista_imagen_mapa) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.lista_pantalla = lista_pantalla;
        this.lista_imagen_pantalla = lista_imagen_mapa;
    }

    @Override
    public String toString() {
        return "Mapa{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", archivo=" + archivo + ", ubicacion=" + ubicacion + ", imagen=" + imagen + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", lista_pantalla=" + lista_pantalla + ", lista_imagen_pantalla=" + lista_imagen_pantalla + '}';
    }
}
