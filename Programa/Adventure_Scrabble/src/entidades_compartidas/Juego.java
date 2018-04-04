/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades_compartidas;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author ubuntulourdes
 */
public class Juego {
    
    private int id;
    private String nombre;
    private String archivo;
    private String ubicacion;
    private Image imagen;
    private Calendar fecha_hecho;
    private Calendar fecha_baja;
    private ArrayList<Mapa> lista_mapa;
    private ArrayList<Ficha> lista_ficha;
    private ArrayList<Oferta> lista_oferta;
    private ArrayList<ImagenJuego> lista_imagen_juego;

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

    public Calendar getFecha_hecho() {
        return fecha_hecho;
    }

    public void setFecha_hecho(Calendar fecha_hecho) {
        this.fecha_hecho = fecha_hecho;
    }

    public Calendar getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Calendar fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public ArrayList<Mapa> getLista_mapa() {
        return lista_mapa;
    }

    public void setLista_mapa(ArrayList<Mapa> lista_mapa) {
        this.lista_mapa = lista_mapa;
    }

    public ArrayList<Ficha> getLista_ficha() {
        return lista_ficha;
    }

    public void setLista_ficha(ArrayList<Ficha> lista_ficha) {
        this.lista_ficha = lista_ficha;
    }

    public ArrayList<Oferta> getLista_oferta() {
        return lista_oferta;
    }

    public void setLista_oferta(ArrayList<Oferta> lista_oferta) {
        this.lista_oferta = lista_oferta;
    }

    public ArrayList<ImagenJuego> getLista_imagen_juego() {
        return lista_imagen_juego;
    }

    public void setLista_imagen_juego(ArrayList<ImagenJuego> lista_imagen_juego) {
        this.lista_imagen_juego = lista_imagen_juego;
    }

    public Juego() {
    }

    public Juego(int id, String nombre, String archivo, String ubicacion, Image imagen, Calendar fecha_hecho, Calendar fecha_baja, ArrayList<Mapa> lista_mapa, ArrayList<Ficha> lista_ficha, ArrayList<Oferta> lista_oferta, ArrayList<ImagenJuego> lista_imagen_juego) {
        this.id = id;
        this.nombre = nombre;
        this.archivo = archivo;
        this.ubicacion = ubicacion;
        this.imagen = imagen;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.lista_mapa = lista_mapa;
        this.lista_ficha = lista_ficha;
        this.lista_oferta = lista_oferta;
        this.lista_imagen_juego = lista_imagen_juego;
    }

    @Override
    public String toString() {
        return "Juego{" + "id=" + id + ", nombre=" + nombre + ", archivo=" + archivo + ", ubicacion=" + ubicacion + ", imagen=" + imagen + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", lista_mapa=" + lista_mapa + ", lista_ficha=" + lista_ficha + ", lista_oferta=" + lista_oferta + ", lista_imagen_juego=" + lista_imagen_juego + '}';
    }
   
}
