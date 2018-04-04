/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.TipoCuadrado;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaTipoCuadrado;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaTipoCuadrado implements ILogicaTipoCuadrado{

    @Override
    public int AltaTipoCuadrado(TipoCuadrado pTipoCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarTipoCuadrado(TipoCuadrado pTipoCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaTipoCuadrado(TipoCuadrado pTipoCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoCuadrado> ListarTipoCuadrado() {
        
        ArrayList<TipoCuadrado> lista_tipo_cuadrado = new ArrayList();
        
        try
        {
             lista_tipo_cuadrado = FabricaDatos.getControladorTipoCuadrado().ListarTipoCuadrado();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista_tipo_cuadrado;
    }

    @Override
    public TipoCuadrado BuscarTipoCuadradoPorId(int pIdTipoCuadrado) {
      
        TipoCuadrado tipo_cuadrado = new TipoCuadrado();
        
        try
        {
             tipo_cuadrado = FabricaDatos.getControladorTipoCuadrado().BuscarTipoCuadradoPorId(pIdTipoCuadrado);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipo_cuadrado;
    }

    @Override
    public ArrayList<TipoCuadrado> ListarTipoCuadradoEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarTipoCuadrado(TipoCuadrado pTipoCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarTipoCuadradoDefinitivo(TipoCuadrado pTipoCuadrado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaTipoCuadradoDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
