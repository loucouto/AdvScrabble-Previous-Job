/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.Cuadrado;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosCuadrado {
    
    int AltaCuadrado(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado); 
    
    int ModificarCuadrado(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado); 
    
    int BajaCuadrado(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado); 
    
    ArrayList<Cuadrado> ListarCuadrado(); 
    
    ArrayList<Cuadrado> BuscarCuadradoPorIdTablero(int pIdMapa , int pIdPantalla, int pIdTablero); 
    
    Cuadrado BuscarCuadradoPorId(int pIdMapa , int pIdPantalla, int pIdTablero, int pIdCuadrado); 
    
    ArrayList<Cuadrado> ListarCuadradosEliminados(); 
    
    int ReingresarCuadrado(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado);
    
    int EliminarCuadradoDefinitivo(int pIdMapa , int pIdPantalla, int pIdTablero, Cuadrado pCuadrado); 
    
    int EliminarListaCuadradoDefinitivo();
    
}
