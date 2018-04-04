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
public class Jugador extends Usuario {
    
    private int puntaje_total;
    private TipoJugador tipo_jugador;
    private ArrayList<RegistroMapa> lista_registro_mapa;
    private ArrayList<Bonus> lista_bonus;
    private ArrayList<Corazon> lista_corazon;
    private ArrayList<Lingote> lista_lingote;
    private ArrayList<TipoMensaje> lista_tipo_mensaje;

    public int getPuntaje_total() {
        return puntaje_total;
    }

    public void setPuntaje_total(int puntaje_total) {
        this.puntaje_total = puntaje_total;
    }

    public TipoJugador getTipo_jugador() {
        return tipo_jugador;
    }

    public void setTipo_jugador(TipoJugador tipo_jugador) {
        this.tipo_jugador = tipo_jugador;
    }

    public ArrayList<RegistroMapa> getLista_registro_mapa() {
        return lista_registro_mapa;
    }

    public void setLista_registro_mapa(ArrayList<RegistroMapa> lista_registro_mapa) {
        this.lista_registro_mapa = lista_registro_mapa;
    }

    public ArrayList<Bonus> getLista_bonus() {
        return lista_bonus;
    }

    public void setLista_bonus(ArrayList<Bonus> lista_bonus) {
        this.lista_bonus = lista_bonus;
    }

    public ArrayList<Corazon> getLista_corazon() {
        return lista_corazon;
    }

    public void setLista_corazon(ArrayList<Corazon> lista_corazon) {
        this.lista_corazon = lista_corazon;
    }

    public ArrayList<Lingote> getLista_lingote() {
        return lista_lingote;
    }

    public void setLista_lingote(ArrayList<Lingote> lista_lingote) {
        this.lista_lingote = lista_lingote;
    }

    public ArrayList<TipoMensaje> getLista_tipo_mensaje() {
        return lista_tipo_mensaje;
    }

    public void setLista_tipo_mensaje(ArrayList<TipoMensaje> lista_tipo_mensaje) {
        this.lista_tipo_mensaje = lista_tipo_mensaje;
    }
    
    public Jugador()
    {
    
    }

    public Jugador(int puntaje_total, TipoJugador tipo_jugador, ArrayList<RegistroMapa> lista_registro_mapa, ArrayList<Bonus> lista_bonus, ArrayList<Corazon> lista_corazon, ArrayList<Lingote> lista_lingote, ArrayList<TipoMensaje> lista_tipo_mensaje) {
        this.puntaje_total = puntaje_total;
        this.tipo_jugador = tipo_jugador;
        this.lista_registro_mapa = lista_registro_mapa;
        this.lista_bonus = lista_bonus;
        this.lista_corazon = lista_corazon;
        this.lista_lingote = lista_lingote;
        this.lista_tipo_mensaje = lista_tipo_mensaje;
    }

    public Jugador(int puntaje_total, TipoJugador tipo_jugador, ArrayList<RegistroMapa> lista_registro_mapa, ArrayList<Bonus> lista_bonus, ArrayList<Corazon> lista_corazon, ArrayList<Lingote> lista_lingote, ArrayList<TipoMensaje> lista_tipo_mensaje, int id, String nombre_completo, String contrasenia, String nombre_usuario, String correo_electronico, String descripcion, String archivo, String ubicacion, Image foto, Date fecha_hecho, Date fecha_baja, PerfilUsuario perfil_usuario) {
        super(id, nombre_completo, contrasenia, nombre_usuario, correo_electronico, descripcion, archivo, ubicacion, foto, fecha_hecho, fecha_baja, perfil_usuario);
        this.puntaje_total = puntaje_total;
        this.tipo_jugador = tipo_jugador;
        this.lista_registro_mapa = lista_registro_mapa;
        this.lista_bonus = lista_bonus;
        this.lista_corazon = lista_corazon;
        this.lista_lingote = lista_lingote;
        this.lista_tipo_mensaje = lista_tipo_mensaje;
    }

    @Override
    public String toString() {
        return "Jugador{" + "puntaje_total=" + puntaje_total + ", tipo_jugador=" + tipo_jugador + ", lista_registro_mapa=" + lista_registro_mapa + ", lista_bonus=" + lista_bonus + ", lista_corazon=" + lista_corazon + ", lista_lingote=" + lista_lingote + ", lista_tipo_mensaje=" + lista_tipo_mensaje + '}';
    }
    
    //modificar después
    public int ObtenerPuntajeTotal()
    {
        int puntaje = 0;
        return puntaje;
    }
    
}
