/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.interfaces;

import datos.util.DatosConstantes;
import entidades_compartidas.TipoMensaje;
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
public interface IDatosTipoMensaje {
    
    public int AltaTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje);
    
    public int ModificarTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje); 
    
    public int BajaTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje); 
    
    public ArrayList<TipoMensaje> ListarTipoMensaje(); 
    
    public TipoMensaje BuscarTipoMensajePorId(int pIdTipoMensaje, int pIdUsuario); 
    
    public ArrayList<TipoMensaje> ListarTipoMensajeEliminados(); 
    
    public int ReingresarTipoMensaje(int pIdUsuario, TipoMensaje pTipoMensaje); 
    
    public int EliminarTipoMensajeDefinitivo(int pIdUsuario, TipoMensaje pTipoMensaje); 
    
    public int EliminarListaTipoMensajeDefinitivo(); 
    
}
