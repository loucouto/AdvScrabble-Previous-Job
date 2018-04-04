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
public class Oferta {
    
    private int id;
    private String titulo;
    private String descripcion;
    private String archivo;
    private String ubicacion;
    private Image imagen;
    private double precio;
    private String moneda;
    private String simbolo;
    private Date fecha_hecho;
    private Date fecha_baja;
    private TipoOferta tipo_oferta;

    public TipoOferta getTipo_oferta() {
        return tipo_oferta;
    }

    public void setTipo_oferta(TipoOferta tipo_oferta) {
        this.tipo_oferta = tipo_oferta;
    }

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
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

    public Oferta() {
    }

    public Oferta(int id, String titulo, String descripcion, String archivo, String ubicacion, Image imagen, double precio, String moneda, String simbolo, Date fecha_hecho, Date fecha_baja, TipoOferta tipo_oferta) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        this.precio = precio;
        this.moneda = moneda;
        this.simbolo = simbolo;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.tipo_oferta = tipo_oferta;
    }

    @Override
    public String toString() {
        return "Oferta{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", archivo=" + archivo + ", ubicacion=" + ubicacion + ", imagen=" + imagen + ", precio=" + precio + ", moneda=" + moneda + ", simbolo=" + simbolo + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", tipo_oferta=" + tipo_oferta + '}';
    }
    
}
