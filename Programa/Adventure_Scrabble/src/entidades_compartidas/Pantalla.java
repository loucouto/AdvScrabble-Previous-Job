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
public class Pantalla {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String archivo;
    private String ubicacion;
    private Image imagen;
    private Date fecha_hecho;
    private Date fecha_baja;
    private ArrayList<Tablero> lista_tablero;
    private ArrayList<Condicionante> lista_condicionante;
    private ArrayList<PuntajePantalla> lista_puntaje_pantalla;
    private ArrayList<Objetivo> lista_objetivo;

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

    public ArrayList<Tablero> getLista_tablero() {
        return lista_tablero;
    }

    public void setLista_tablero(ArrayList<Tablero> lista_tablero) {
        this.lista_tablero = lista_tablero;
    }

    public ArrayList<Condicionante> getLista_condicionante() {
        return lista_condicionante;
    }

    public void setLista_condicionante(ArrayList<Condicionante> lista_condicionante) {
        this.lista_condicionante = lista_condicionante;
    }

    public ArrayList<PuntajePantalla> getLista_puntaje_pantalla() {
        return lista_puntaje_pantalla;
    }

    public void setLista_puntaje_pantalla(ArrayList<PuntajePantalla> lista_puntaje_pantalla) {
        this.lista_puntaje_pantalla = lista_puntaje_pantalla;
    }

    public ArrayList<Objetivo> getLista_objetivo() {
        return lista_objetivo;
    }

    public void setLista_objetivo(ArrayList<Objetivo> lista_objetivo) {
        this.lista_objetivo = lista_objetivo;
    }

    public Pantalla() {
    }

    public Pantalla(int id, String nombre, String descripcion, String archivo, String ubicacion, Image imagen, Date fecha_hecho, Date fecha_baja, ArrayList<Tablero> lista_tablero, ArrayList<Condicionante> lista_condicionante, ArrayList<PuntajePantalla> lista_puntaje_pantalla, ArrayList<Objetivo> lista_objetivo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.lista_tablero = lista_tablero;
        this.lista_condicionante = lista_condicionante;
        this.lista_puntaje_pantalla = lista_puntaje_pantalla;
        this.lista_objetivo = lista_objetivo;
    }

    @Override
    public String toString() {
        return "Pantalla{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", archivo=" + archivo + ", ubicacion=" + ubicacion + ", imagen=" + imagen + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", lista_tablero=" + lista_tablero + ", lista_condicionante=" + lista_condicionante + ", lista_puntaje_pantalla=" + lista_puntaje_pantalla + ", lista_objetivo=" + lista_objetivo + '}';
    }
    
}
