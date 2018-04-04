/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion_computadora.ventanas_auxiliares;

import java.awt.Component;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;


/**
 *
 * @author Lourdes Couto
 */
public class RenderJCombobox extends JLabel implements ListCellRenderer {

//    Hashtable<Object, ImageIcon> icono = null;
//
//     public RenderJCombobox() {
//        icono = new Hashtable<Object, ImageIcon>();
//        icono.put("uno", new ImageIcon("/Subrayado/Pixel1.png"));
//        icono.put("dos", new ImageIcon("/Subrayado/Pixel2.png"));
//        icono.put("tres", new ImageIcon("/Subrayado/Pixel3.png"));
//        icono.put("cuatro", new ImageIcon("/Subrayado/Pixel4.png"));
//    }
    
    
    @Override
    public Component getListCellRendererComponent(JList jlist, Object e, int i, boolean bln, boolean bln1) {
       if(e instanceof JLabel)
        {
            JLabel lbl = (JLabel)e;
           return lbl;
        }
       
       return this;
    }

  
}
