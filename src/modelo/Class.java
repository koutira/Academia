/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Class.findAll", query = "SELECT c FROM Class c")
    , @NamedQuery(name = "Class.findByDay", query = "SELECT c FROM Class c WHERE c.classPK.day = :day")
    , @NamedQuery(name = "Class.findByHorary", query = "SELECT c FROM Class c WHERE c.classPK.horary = :horary")
    , @NamedQuery(name = "Class.findByNumberClass", query = "SELECT c FROM Class c WHERE c.numberClass = :numberClass")
    , @NamedQuery(name = "Class.findByPresence", query = "SELECT c FROM Class c WHERE c.presence = :presence")})
public class Class implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClassPK classPK;
    @Column(name = "NumberClass")
    private Integer numberClass;
    @Column(name = "Presence")
    private String presence;
    @JoinColumn(name = "Registration_NumberRegistration", referencedColumnName = "NumberRegistration")
    @ManyToOne(optional = false)
    private Registration registrationNumberRegistration;
    @JoinColumn(name = "Teacher_CPF", referencedColumnName = "CPF")
    @ManyToOne(optional = false)
    private Teacher teacherCPF;

    public Class() {
    }

    public Class(ClassPK classPK) {
        this.classPK = classPK;
    }

    public Class(Date day, String horary) {
        this.classPK = new ClassPK(day, horary);
    }

    public ClassPK getClassPK() {
        return classPK;
    }

    public void setClassPK(ClassPK classPK) {
        this.classPK = classPK;
    }

    public Integer getNumberClass() {
        return numberClass;
    }

    public void setNumberClass(Integer numberClass) {
        this.numberClass = numberClass;
    }

    public String getPresence() {
        return presence;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }

    public Registration getRegistrationNumberRegistration() {
        return registrationNumberRegistration;
    }

    public void setRegistrationNumberRegistration(Registration registrationNumberRegistration) {
        this.registrationNumberRegistration = registrationNumberRegistration;
    }

    public Teacher getTeacherCPF() {
        return teacherCPF;
    }

    public void setTeacherCPF(Teacher teacherCPF) {
        this.teacherCPF = teacherCPF;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classPK != null ? classPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Class)) {
            return false;
        }
        Class other = (Class) object;
        if ((this.classPK == null && other.classPK != null) || (this.classPK != null && !this.classPK.equals(other.classPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Class[ classPK=" + classPK + " ]";
    }
    
}
