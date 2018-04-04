/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.Lingote;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaLingote;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaLingote implements ILogicaLingote{

    @Override
    public int AltaLingote(int pIdUsuario, Lingote pLingote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarLingote(int pIdUsuario, Lingote pLingote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaLingote(int pIdUsuario, Lingote pLingote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Lingote> ListarLingote() {
       ArrayList<Lingote> lista_lingote = new ArrayList();
        try
        {
            lista_lingote = FabricaDatos.getControladorLingote().ListarLingote();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_lingote;
    }

    @Override
    public Lingote BuscarLingotePorId(int pIdUsuario, int pIdLingote) {
        Lingote lingote = new Lingote();
        try
        {
            lingote = FabricaDatos.getControladorLingote().BuscarLingotePorId(pIdUsuario, pIdLingote);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lingote;
    }

    @Override
    public ArrayList<Lingote> ListarLingoteEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarLingote(int pIdUsuario, Lingote pLingote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarLingoteDefinitivo(int pIdUsuario, Lingote pLingote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarLingoteLingoteDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
