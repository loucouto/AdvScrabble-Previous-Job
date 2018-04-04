/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.interfaces;

import entidades_compartidas.Cuadrado;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface ILogicaCuadrado {
    
    int AltaCuadrado(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado); 
    
    int ModificarCuadrado(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado); 
    
    int BajaCuadrado(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado); 
    
    ArrayList<Cuadrado> ListarCuadrado(); 
    
    Cuadrado BuscarCuadradoPorId(int pIdMapa , int pIdPantalla, int pIdTablero, int pIdCuadrado); 
    
    ArrayList<Cuadrado> BuscarCuadradoPorIdTablero(int pIdMapa , int pIdPantalla, int pIdTablero); 
    
    ArrayList<Cuadrado> ListarCuadradosEliminados(); 
    
    int ReingresarCuadrado(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado);
    
    int EliminarCuadradoDefinitivo(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado); 
    
    int EliminarListaCuadradoDefinitivo();
    
    
}
