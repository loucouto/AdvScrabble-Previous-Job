/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion_computadora.ventanas_auxiliares;

/**
 *
 * @author Lourdes
 */
public class OrdenAlfabetico {
    
    public OrdenAlfabetico(){}
    
    public int CompararAlfabeticamente(String a, String b)
    {
        int retorno = 0;
        
            if(a.length() <= b.length())
            {
                for(int i=0; i<a.length(); i++)
                {
                    if(this.ObtenerOrdenLetra(a.charAt(i)) < this.ObtenerOrdenLetra(b.charAt(i)))
                    {
                        retorno = 1;
                        break;
                    }
                    else if(this.ObtenerOrdenLetra(a.charAt(i)) > this.ObtenerOrdenLetra(b.charAt(i)))
                    {
                        retorno = -1;
                        break;
                    }
                  
                }
                
                if(retorno == 0)
                {
                    retorno = 1;
                }
            }
            else
            {
                for(int i=0; i<b.length(); i++)
                {
                    if(this.ObtenerOrdenLetra(a.charAt(i)) < this.ObtenerOrdenLetra(b.charAt(i)))
                    { 
                        retorno = 1;
                        break;
                    }
                    else if(this.ObtenerOrdenLetra(a.charAt(i)) > this.ObtenerOrdenLetra(b.charAt(i)))
                    {
                        retorno = -1;
                        break;
                    }
                    
                }
                
                if(retorno == 0)
                {
                    retorno = -1;
                }
            }
        
        return retorno;
    }
    
    private int ObtenerOrdenLetra(Character letra)
    {   
        int retorno = 0;
        
        switch(letra)
        {
            case 'a':
                retorno = 1;
            break;
            case 'A':
                retorno = 1;
            break;
            case 'á':
                retorno = 1;
            break;
            case 'b':
                retorno = 2;
            break;
            case 'B':
                retorno = 2;
            break;
            case 'c':
                retorno = 3;
            break;
            case 'C':
                retorno = 3;
            break;
            case 'd':
                retorno = 4;
            break;
            case 'D':
                retorno = 4;
            break;
            case 'e':
                retorno = 5;
            break;
            case 'E':
                retorno = 5;
            break;
            case 'é':
                retorno = 5;
            break;
            case 'f':
                retorno = 6;
            break;
            case 'F':
                retorno = 6;
            break;
            case 'g':
                retorno = 7;
            break;
            case 'G':
                retorno = 7;
            break;
            case 'h':
                retorno = 8;
            break;
            case 'H':
                retorno = 8;
            break;
            case 'i':
                retorno = 9;
            break;
            case 'I':
                retorno = 9;
            break;
            case 'j':
                retorno = 10;
            break;
            case 'J':
                retorno = 10;
            break;
            case 'k':
                retorno = 11;
            break;
            case 'K':
                retorno = 11;
            break;
            case 'l':
                retorno = 12;
            break;
            case 'L':
                retorno = 12;
            break;
            case 'm':
                retorno = 13;
            break;
            case 'M':
                retorno = 13;
            break;            
            case 'n':
                retorno = 14;
            break;   
            case 'N':
                retorno = 14;
            break; 
            case 'ñ':
                retorno = 15;
            break; 
            case 'Ñ':
                retorno = 15;
            break;
            case 'o':
                retorno = 16;
            break; 
            case 'O':
                retorno = 16;
            break; 
            case 'ó':
                retorno = 16;
            break; 
            case 'p':
                retorno = 17;
            break; 
            case 'P':
                retorno = 17;
            break; 
            case 'q':
                retorno = 18;
            break; 
            case 'Q':
                retorno = 18;
            break; 
            case 'r':
                retorno = 19;
            break; 
            case 'R':
                retorno = 19;
            break; 
            case 's':
                retorno = 20;
            break; 
            case 'S':
                retorno = 20;
            break; 
            case 't':
                retorno = 21;
            break; 
            case 'T':
                retorno = 21;
            break; 
            case 'u':
                retorno = 22;
            break; 
            case 'U':
                retorno = 22;
            break; 
            case 'ú':
                retorno = 22;
            break; 
            case 'ü':
                retorno = 22;
            break; 
            case 'v':
                retorno = 23;
            break; 
            case 'V':
                retorno = 23;
            break; 
            case 'w':
                retorno = 24;
            break; 
            case 'W':
                retorno = 24;
            break; 
            case 'x':
                retorno = 25;
            break; 
            case 'X':
                retorno = 25;
            break; 
            case 'y':
                retorno = 26;
            break; 
            case 'Y':
                retorno = 26;
            break; 
            case 'z':
                retorno = 27;
            break; 
            default:
                retorno = 27;
        }
        
        return retorno;
    }
    
}
