/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controlador;

import datos.fachada.FabricaDatos;
import entidades_compartidas.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.interfaces.ILogicaUsuario;

/**
 *
 * @author ubuntulourdes
 */
public class LogicaUsuario implements ILogicaUsuario{

    @Override
    public int AltaUsuario(Usuario pUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ModificarUsuario(Usuario pUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BajaUsuario(Usuario pUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> ListarUsuario() {
       
            ArrayList<Usuario> lista_tipo_usuario = new ArrayList();
            try
            {
                 lista_tipo_usuario = FabricaDatos.getControladorTipoUsuario().ListarUsuario();
            }
            catch(Exception ex)
            {
                Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return lista_tipo_usuario;
    }

    @Override
    public Usuario BuscarUsuarioPorId(int pIdUsuario) {
            
            Usuario usuario = new Usuario();
            try
            {
                usuario = FabricaDatos.getControladorTipoUsuario().BuscarUsuarioPorId(pIdUsuario);
            }
            catch(Exception ex)
            {
                Logger.getLogger(LogicaFuncionalidad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return usuario;
    }

    @Override
    public ArrayList<Usuario> ListarUsuarioEliminados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int ReingresarUsuario(Usuario pUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarUsuarioDefinitivo(Usuario pUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EliminarListaUsuarioDefinitivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
