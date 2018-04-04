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
public class Corazon {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String archivo;
    private String ubicacion;
    private Image imagen;
    private int cant_vidas;
    private boolean es_infinito;
    private Date tiempo_prox_vida;
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

    public int getCant_vidas() {
        return cant_vidas;
    }

    public void setCant_vidas(int cant_vidas) {
        this.cant_vidas = cant_vidas;
    }

    public boolean getEs_infinito() {
        return es_infinito;
    }

    public void setEs_infinito(boolean es_infinito) {
        this.es_infinito = es_infinito;
    }

    public Date getTiempo_prox_vida() {
        return tiempo_prox_vida;
    }

    public void setTiempo_prox_vida(Date tiempo_prox_vida) {
        this.tiempo_prox_vida = tiempo_prox_vida;
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

    public Corazon() {
    }

    public Corazon(int id, String nombre, String descripcion, String archivo, String ubicacion, Image imagen, int cant_vidas, boolean es_infinito, Date tiempo_prox_vida, Date fecha_hecho, Date fecha_baja) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        this.cant_vidas = cant_vidas;
        this.es_infinito = es_infinito;
        this.tiempo_prox_vida = tiempo_prox_vida;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
    }

    @Override
    public String toString() {
        return "Corazon{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", archivo=" + archivo + ", ubicacion=" + ubicacion + ", imagen=" + imagen + ", cant_vidas=" + cant_vidas + ", es_infinito=" + es_infinito + ", tiempo_prox_vida=" + tiempo_prox_vida + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + '}';
    }

    //modificar luego
   public int ObtenerCantidadVidas()
   {
       int vidas = 0;
       return vidas;
   }
    
}
