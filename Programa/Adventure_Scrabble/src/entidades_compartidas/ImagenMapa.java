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
public class ImagenMapa {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String archivo_imagen;
    private String ubicacion_imagen;
    private String archivo_texto;
    private String ubicacion_texto;
    private Image imagen;
    private Date fecha_hecho;
    private Date fecha_baja;

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

    public String getArchivo_imagen() {
        return archivo_imagen;
    }

    public void setArchivo_imagen(String archivo_imagen) {
        this.archivo_imagen = archivo_imagen;
    }

    public String getUbicacion_imagen() {
        return ubicacion_imagen;
    }

    public void setUbicacion_imagen(String ubicacion_imagen) {
        this.ubicacion_imagen = ubicacion_imagen;
    }

    public String getArchivo_texto() {
        return archivo_texto;
    }

    public void setArchivo_texto(String archivo_texto) {
        this.archivo_texto = archivo_texto;
    }

    public String getUbicacion_texto() {
        return ubicacion_texto;
    }

    public void setUbicacion_texto(String ubicacion_texto) {
        this.ubicacion_texto = ubicacion_texto;
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

    public ImagenMapa() {
    }

    public ImagenMapa(int id, String nombre, String descripcion, String archivo_imagen, String ubicacion_imagen, String archivo_texto, String ubicacion_texto, Image imagen, Date fecha_hecho, Date fecha_baja) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo_imagen = archivo_imagen;
        this.ubicacion_imagen = ubicacion_imagen;
        this.archivo_texto = archivo_texto;
        this.ubicacion_texto = ubicacion_texto;
        this.imagen = imagen;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
    }

    @Override
    public String toString() {
        return "ImagenMapa{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", archivo_imagen=" + archivo_imagen + ", ubicacion_imagen=" + ubicacion_imagen + ", archivo_texto=" + archivo_texto + ", ubicacion_texto=" + ubicacion_texto + ", imagen=" + imagen + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + '}';
    }
 
}
