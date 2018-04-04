/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades_compartidas;

import entidades_compartidas.Ficha;
import entidades_compartidas.Modelo;
import java.awt.Image;
import java.util.Date;

/**
 *
 * @author Lourdes
 */
public class FichaTablero {
    
    private Image imagen;
    private int coordenada_x;
    private int coordenada_y;
    private int numero_ficha;
    private int puntaje_ficha;

    public Image getImagen() {
        return imagen;
    }

    public int getCoordenada_x() {
        return coordenada_x;
    }

    public int getCoordenada_y() {
        return coordenada_y;
    }

    public int getNumero_ficha() {
        return numero_ficha;
    }

    public int getPuntaje_ficha() {
        return puntaje_ficha;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public void setCoordenada_x(int coordenada_x) {
        this.coordenada_x = coordenada_x;
    }

    public void setCoordenada_y(int coordenada_y) {
        this.coordenada_y = coordenada_y;
    }

    public void setNumero_ficha(int numero_ficha) {
        this.numero_ficha = numero_ficha;
    }

    public void setPuntaje_ficha(int puntaje_ficha) {
        this.puntaje_ficha = puntaje_ficha;
    }

    public FichaTablero() {
    }

    public FichaTablero(Image imagen, int coordenada_x, int coordenada_y, int numero_ficha, int puntaje_ficha) {
        this.imagen = imagen;
        this.coordenada_x = coordenada_x;
        this.coordenada_y = coordenada_y;
        this.numero_ficha = numero_ficha;
        this.puntaje_ficha = puntaje_ficha;
    }

    @Override
    public String toString() {
        return "FichaTablero{" + "imagen=" + imagen + ", coordenada_x=" + coordenada_x + ", coordenada_y=" + coordenada_y + ", numero_ficha=" + numero_ficha + ", puntaje_ficha=" + puntaje_ficha + '}';
    }
  
}
