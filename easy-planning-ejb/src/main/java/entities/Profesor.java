/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ariel-linux
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Profesor.findByRut",
            query="SELECT p FROM Profesor p WHERE p.rutProfesor = :rut"),

    @NamedQuery(name="Profesor.findDisponiblesByBloque",
            query="SELECT h.profesor FROM Horario h WHERE h.bloque = :bloque AND h.seccion IS NULL AND h.profesor IS NOT NULL"),
    
    @NamedQuery(name="Profesor.getEncuestaBySemestreAndAnio",
            query="SELECT e FROM Encuesta e WHERE e.profesor.rutProfesor = :rutProfesor AND e.anio = :anio AND e.semestre = :semestre"),
    
    @NamedQuery(name="Profesor.getProfesorByHorarioAsignado",
            query="SELECT DISTINCT p FROM Profesor p, Coordinacion c, Seccion s, Horario h WHERE c.asignatura.id = :id_asignatura AND c.id = s.coordinacion.id AND s.id = h.seccion.id AND h.profesor.rutProfesor = p.rutProfesor AND c.anio = :anio AND c.semestre = :semestre"),
})
public class Profesor implements Serializable {
    @ManyToMany(mappedBy = "profesores")
    private List<Asignatura> asignaturas;
    @OneToMany(mappedBy = "profesor")
    private List<Horario> disponibilidad;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "rut_profesor")
    private String rutProfesor;
    private int contrato;
    private int tipo_profesor;
    private int jerarquia_categoria;
    private int maximo_guias;
    private boolean esta_seminar;
    private int puede_guiar;
    private int puede_corregir;
    @Column(name = "alias")
    private String alias_profesor;

    public String getAlias() {
        return alias_profesor;
    }

    public void setAlias(String alias) {
        this.alias_profesor = alias;
    }

    public String getRutProfesor() {
        return rutProfesor;
    }

    public void setRutProfesor(String rutProfesor) {
        this.rutProfesor = rutProfesor;
    }
    
    public List<Horario> getDisponibilidad() {
        return disponibilidad;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
    
    public void setDisponibilidad(List<Horario> disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.rutProfesor == null && other.rutProfesor != null) || (this.rutProfesor != null && !this.rutProfesor.equals(other.rutProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.rutProfesor);
        return hash;
    }

    @Override
    public String toString() {
        return "entities.Profesor[ rutProfesor=" + rutProfesor + " ]";
    }
    
}
