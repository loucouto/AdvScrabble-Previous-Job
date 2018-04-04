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
public class RegistroPantalla {
   
    private int id;
    private String titulo;
    private String descripcion;
    private int puntos_pantalla;
    private Date fecha_hecho;
    private Date fecha_baja;
    private Pantalla pantalla;
    private ArrayList<Pantalla> lista_pantalla;

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

    public int getPuntos_pantalla() {
        return puntos_pantalla;
    }

    public void setPuntos_pantalla(int puntos_pantalla) {
        this.puntos_pantalla = puntos_pantalla;
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

    public Pantalla getPantalla() {
        return pantalla;
    }

    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

    public ArrayList<Pantalla> getLista_pantalla() {
        return lista_pantalla;
    }

    public void setLista_pantalla(ArrayList<Pantalla> lista_pantalla) {
        this.lista_pantalla = lista_pantalla;
    }

    public RegistroPantalla() {
    }

    public RegistroPantalla(int id, String titulo, String descripcion, int puntos_pantalla, Date fecha_hecho, Date fecha_baja, Pantalla pantalla, ArrayList<Pantalla> lista_pantalla) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.puntos_pantalla = puntos_pantalla;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.pantalla = pantalla;
        this.lista_pantalla = lista_pantalla;
    }

    @Override
    public String toString() {
        return "RegistroPantalla{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", puntos_pantalla=" + puntos_pantalla + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", pantalla=" + pantalla + ", lista_pantalla=" + lista_pantalla + '}';
    }
 
    //modificar luego
    public int ObtenerSumaPuntaje()
    {
        int suma = 0;
        return suma;
    }
    
}
