/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import datos.util.DatosConstantes;
import entidades_compartidas.PuntajePantalla;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ubuntulourdes
 */
public interface IDatosPuntajePantalla {
    
    int AltaPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla);
       
    int ModificarPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla); 
     
    int BajaPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla);
   
    ArrayList<PuntajePantalla> ListarPuntajePantalla(); 
    
    PuntajePantalla BuscarPuntajePantallaPorId(int pIdMapa, int pIdPantalla, int pIdPuntajePantalla); 
    
    ArrayList<PuntajePantalla> ListarPuntajePantallaEliminados(); 
    
    int ReingresarPuntajePantalla(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla); 
    
    int EliminarPuntajePantallaDefinitivo(int pIdMapa, int pIdPantalla, int pIdEstrella, PuntajePantalla pPuntajePantalla); 
    
    int EliminarListaMapaDefinitivo(); 
}
