/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades_compartidas;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author ubuntulourdes
 */
public class Usuario {
    
    private int id;
    private String nombre_completo;
    private String contrasenia;
    private String nombre_usuario;
    private String correo_electronico;
    private String descripcion;
    private String archivo;
    private String ubicacion;
    private Image foto;
    private Date fecha_hecho;
    private Date fecha_baja;
    private PerfilUsuario perfil_usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Date getFecha_hecho() {
        return fecha_hecho;
    }

    public void setFecha_hecho(Date fecha_hecho) {
        this.fecha_hecho = fecha_hecho;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public PerfilUsuario getPerfil_usuario() {
        return perfil_usuario;
    }

    public void setPerfil_usuario(PerfilUsuario perfil_usuario) {
        this.perfil_usuario = perfil_usuario;
    }

    public Usuario() {
    }

    public Usuario(int id, String nombre_completo, String contrasenia, String nombre_usuario, String correo_electronico, String descripcion, String archivo, String ubicacion, Image foto, Date fecha_hecho, Date fecha_baja, PerfilUsuario perfil_usuario) {
        this.id = id;
        this.nombre_completo = nombre_completo;
        this.contrasenia = contrasenia;
        this.nombre_usuario = nombre_usuario;
        this.correo_electronico = correo_electronico;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.ubicacion = ubicacion;
        this.foto = foto;
        this.fecha_hecho = fecha_hecho;
        this.fecha_baja = fecha_baja;
        this.perfil_usuario = perfil_usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre_completo=" + nombre_completo + ", contrasenia=" + contrasenia + ", nombre_usuario=" + nombre_usuario + ", correo_electronico=" + correo_electronico + ", descripcion=" + descripcion + ", archivo=" + archivo + ", ubicacion=" + ubicacion + ", foto=" + foto + ", fecha_hecho=" + fecha_hecho + ", fecha_baja=" + fecha_baja + ", perfil_usuario=" + perfil_usuario + '}';
    }
    
    
}
