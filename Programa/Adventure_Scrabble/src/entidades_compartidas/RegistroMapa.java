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
public class RegistroMapa {
    
    private int id;
    private String titulo;
    private String descripcion;
    private int puntos_mapa;
    private Date fecha_hecho;
    private Date fecha_baja;
    private Mapa mapa;
    private ArrayList<RegistroPantalla>  lista_pantalla;

    public int getPuntos_mapa() {
        return puntos_mapa;
    }

    public void setPuntos_mapa(int puntos_mapa) {
        this.puntos_mapa = puntos_mapa;
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

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public ArrayList<RegistroPantalla> getLista_pantalla() {
        return lista_pantalla;
    }

    public void setLista_pantalla(ArrayList<RegistroPantalla> lista_pantalla) {
        this.lista_pantalla = lista_pantalla;
    }

    public RegistroMapa() {
    }

    public RegistroMapa(int id, String titulo, String descripcion, int puntos_mapa , Date fecha_hecho, Date fecha_baja, Mapa mapa, ArrayList<RegistroPantalla> lista_pantalla) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.puntos_mapa  = puntos_mapa;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.mapa = mapa;
        this.lista_pantalla = lista_pantalla;
    }

    @Override
    public String toString() {
        return "RegistroMapa{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", puntos_mapa=" + puntos_mapa + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", mapa=" + mapa + ", lista_pantalla=" + lista_pantalla + '}';
    }

    //modificar luego
    public int ObtenerSumaPuntaje()
    {
        int suma = 0;
        return suma;
    }
    
}
