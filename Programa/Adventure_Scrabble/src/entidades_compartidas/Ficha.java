/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades_compartidas;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author ubuntulourdes
 */
public class Ficha {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String archivo;
    private String ubicacion;
    private Image imagen;
    private int numero_ficha;
    private int puntaje_ficha;
    private Date fecha_hecho;
    private Date fecha_baja;
    private Modelo modelo;

    public Ficha() {
    }

    public Ficha(int id, String nombre, String descripcion, String archivo, String ubicacion, Image imagen, int numero_ficha, int puntaje_ficha, Date fecha_hecho, Date fecha_baja, Modelo modelo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        this.numero_ficha = numero_ficha;
        this.puntaje_ficha = puntaje_ficha;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.modelo = modelo;
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

    public int getNumero_ficha() {
        return numero_ficha;
    }

    public void setNumero_ficha(int numero_ficha) {
        this.numero_ficha = numero_ficha;
    }

    public int getPuntaje_ficha() {
        return puntaje_ficha;
    }

    public void setPuntaje_ficha(int puntaje_ficha) {
        this.puntaje_ficha = puntaje_ficha;
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

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Ficha{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", archivo=" + archivo + ", ubicacion=" + ubicacion + ", imagen=" + imagen + ", numero_ficha=" + numero_ficha + ", puntaje_ficha=" + puntaje_ficha + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", modelo=" + modelo + '}';
    }
    
    
}
