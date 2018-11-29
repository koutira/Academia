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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registration.findAll", query = "SELECT r FROM Registration r")
    , @NamedQuery(name = "Registration.findByNumberRegistration", query = "SELECT r FROM Registration r WHERE r.numberRegistration = :numberRegistration")})
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NumberRegistration")
    private Integer numberRegistration;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registrationNumberRegistration")
    private Collection<Repositioning> repositioningCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registration")
    private Collection<Payment> paymentCollection;
    @JoinColumn(name = "Course_Initials", referencedColumnName = "Initials")
    @ManyToOne(optional = false)
    private Course courseInitials;
    @JoinColumn(name = "Student_CPF", referencedColumnName = "CPF")
    @ManyToOne(optional = false)
    private Student studentCPF;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registrationNumberRegistration")
    private Collection<Class> classCollection;

    public Registration() {
    }

    public Registration(Integer numberRegistration) {
        this.numberRegistration = numberRegistration;
    }

    public Integer getNumberRegistration() {
        return numberRegistration;
    }

    public void setNumberRegistration(Integer numberRegistration) {
        this.numberRegistration = numberRegistration;
    }

    @XmlTransient
    public Collection<Repositioning> getRepositioningCollection() {
        return repositioningCollection;
    }

    public void setRepositioningCollection(Collection<Repositioning> repositioningCollection) {
        this.repositioningCollection = repositioningCollection;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public Course getCourseInitials() {
        return courseInitials;
    }

    public void setCourseInitials(Course courseInitials) {
        this.courseInitials = courseInitials;
    }

    public Student getStudentCPF() {
        return studentCPF;
    }

    public void setStudentCPF(Student studentCPF) {
        this.studentCPF = studentCPF;
    }

    @XmlTransient
    public Collection<Class> getClassCollection() {
        return classCollection;
    }

    public void setClassCollection(Collection<Class> classCollection) {
        this.classCollection = classCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numberRegistration != null ? numberRegistration.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registration)) {
            return false;
        }
        Registration other = (Registration) object;
        if ((this.numberRegistration == null && other.numberRegistration != null) || (this.numberRegistration != null && !this.numberRegistration.equals(other.numberRegistration))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Registration[ numberRegistration=" + numberRegistration + " ]";
    }
    
}
