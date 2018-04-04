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
public class Cuadrado {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String archivo;
    private String ubicacion;
    private Image imagen;
    private Date fecha_hecho;
    private Date fecha_baja;
    private TipoCuadrado tipo_cuadrado;
    private int coordenada_x;
    private int coordenada_y;
    private boolean ocupado;

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public void setCoordenada_x(int coordenada_x) {
        this.coordenada_x = coordenada_x;
    }

    public void setCoordenada_y(int coordenada_y) {
        this.coordenada_y = coordenada_y;
    }
    
    public int getCoordenada_x() {
        return coordenada_x;
    }

    public int getCoordenada_y() {
        return coordenada_y;
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

    public TipoCuadrado getTipo_cuadrado() {
        return tipo_cuadrado;
    }

    public void setTipo_cuadrado(TipoCuadrado tipo_cuadrado) {
        this.tipo_cuadrado = tipo_cuadrado;
    }
    
    public Cuadrado() {
    }

    public Cuadrado(int id, String nombre, String descripcion, String archivo, String ubicacion, Image imagen, Date fecha_hecho, Date fecha_baja, TipoCuadrado tipo_cuadrado, int coordenada_x, int coordenada_y, boolean ocupado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.tipo_cuadrado = tipo_cuadrado;
        this.coordenada_x = coordenada_x;
        this.coordenada_y = coordenada_y;
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        return "Cuadrado{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", archivo=" + archivo + ", ubicacion=" + ubicacion + ", imagen=" + imagen + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", tipo_cuadrado=" + tipo_cuadrado + ", coordenada_x=" + coordenada_x + ", coordenada_y=" + coordenada_y + ", ocupado=" + ocupado + '}';
    }

}
