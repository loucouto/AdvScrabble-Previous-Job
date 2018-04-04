/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import entidades_compartidas.TipoCuadrado;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosTipoCuadrado {
    
    int AltaTipoCuadrado(TipoCuadrado pTipoCuadrado); 
     
    int ModificarTipoCuadrado(TipoCuadrado pTipoCuadrado); 
    
    int BajaTipoCuadrado(TipoCuadrado pTipoCuadrado); 
    
    ArrayList<TipoCuadrado> ListarTipoCuadrado(); 
    
    TipoCuadrado BuscarTipoCuadradoPorId(int pIdTipoCuadrado); 
    
    ArrayList<TipoCuadrado> ListarTipoCuadradoEliminados();
  
    int ReingresarTipoCuadrado(TipoCuadrado pTipoCuadrado); 
    
    int EliminarTipoCuadradoDefinitivo(TipoCuadrado pTipoCuadrado); 
    
    int EliminarListaTipoCuadradoDefinitivo(); 
    
}
