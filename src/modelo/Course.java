/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findByInitials", query = "SELECT c FROM Course c WHERE c.initials = :initials")
    , @NamedQuery(name = "Course.findByType", query = "SELECT c FROM Course c WHERE c.type = :type")
    , @NamedQuery(name = "Course.findByTime", query = "SELECT c FROM Course c WHERE c.time = :time")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Initials")
    private String initials;
    @Column(name = "Type")
    private String type;
    @Column(name = "Time")
    private String time;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseInitials")
    private Collection<Registration> registrationCollection;

    public Course() {
    }

    public Course(String initials) {
        this.initials = initials;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @XmlTransient
    public Collection<Registration> getRegistrationCollection() {
        return registrationCollection;
    }

    public void setRegistrationCollection(Collection<Registration> registrationCollection) {
        this.registrationCollection = registrationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (initials != null ? initials.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.initials == null && other.initials != null) || (this.initials != null && !this.initials.equals(other.initials))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Course[ initials=" + initials + " ]";
    }
    
}
