/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.Oferta;
import java.util.ArrayList;
import logica.interfaces.ILogicaOferta;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaOferta implements ILogicaOferta{

    @Override
    public int AltaOferta(Oferta pOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarOferta(Oferta pOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaOferta(Oferta pOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Oferta> ListarOferta() {
        ArrayList<Oferta> lista_oferta = new ArrayList();
        try
        {
            lista_oferta = FabricaDatos.getControladorOferta().ListarOferta();
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_oferta;
    }

    @Override
    public Oferta BuscarOfertaPorId(int pIdOferta) {
        Oferta oferta = new Oferta();
        try
        {
            oferta = FabricaDatos.getControladorOferta().BuscarOfertaPorId(pIdOferta);
        }
        catch(Exception ex)
        {
            Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return oferta;
    }

    @Override
    public ArrayList<Oferta> ListarOfertaEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarOferta(Oferta pOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarOfertaDefinitivo(Oferta pOferta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaOfertaDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
