/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure_scrabble;

import datos.controlador.*;
import entidades_compartidas.*;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ubuntulourdes
 */
public class Adventure_Scrabble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            DatosCorazon d = new DatosCorazon();
            System.out.println(d.ListarCorazon());
            
        }
        catch(Exception ex)
        {
        
        }
    }
    
}
