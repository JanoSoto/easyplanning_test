/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author jano
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Usuario.findByUsername",
            query="SELECT u FROM Usuario u WHERE u.username = :username"),
    @NamedQuery(name = "Usuario.findByUid",
            query = "SELECT u FROM Usuario u WHERE u.uid = :uid")
})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id    
    @Size(min = 1, max = 20)
    private String rut_usuario;
    @Size(min = 1, max = 20)
    private String uid;
    @Size(min = 1, max = 50)
    private String nombre_usuario;
    @Size(min = 1, max = 50)
    private String segundo_nombre_usuario;
    @Size(min = 1, max = 50)
    private String apellido_usuario_paterno;
    @Size(min = 1, max = 50)
    private String apellido_usuario_materno;
    @Size(min = 1, max = 100)
    private String mail_usuario;
    @Size(min = 1, max = 20)
    private String telefono_usuario;
    @Size(min = 1, max = 100)
    private String direccion_usuario;
    private boolean activo = true;

    @OneToMany
    private List<Tipo> tipos;

    public List<Tipo> getRoles() {
        return tipos;
    }

    public void setRoles(List<Tipo> roles) {
        this.tipos = roles;
    }
    
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getRut_usuario() {
        return rut_usuario;
    }

    public void setRut_usuario(String rut_usuario) {
        this.rut_usuario = rut_usuario;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSegundo_nombre_usuario() {
        return segundo_nombre_usuario;
    }

    public void setSegundo_nombre_usuario(String segundo_nombre_usuario) {
        this.segundo_nombre_usuario = segundo_nombre_usuario;
    }

    public String getApellido_usuario_paterno() {
        return apellido_usuario_paterno;
    }

    public void setApellido_usuario_paterno(String apellido_usuario_paterno) {
        this.apellido_usuario_paterno = apellido_usuario_paterno;
    }

    public String getApellido_usuario_materno() {
        return apellido_usuario_materno;
    }

    public void setApellido_usuario_materno(String apellido_usuario_materno) {
        this.apellido_usuario_materno = apellido_usuario_materno;
    }

    public String getMail_usuario() {
        return mail_usuario;
    }

    public void setMail_usuario(String mail_usuario) {
        this.mail_usuario = mail_usuario;
    }

    public String getTelefono_usuario() {
        return telefono_usuario;
    }

    public void setTelefono_usuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }

    public String getDireccion_usuario() {
        return direccion_usuario;
    }

    public void setDireccion_usuario(String direccion_usuario) {
        this.direccion_usuario = direccion_usuario;
    }

    public List<Tipo> getTipos() {
        return tipos;
    }

    public void setTipos(List<Tipo> tipos) {
        this.tipos = tipos;
    }
}
