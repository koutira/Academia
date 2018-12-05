/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
@Table(name = "repositioning")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repositioning.findAll", query = "SELECT r FROM Repositioning r")
    , @NamedQuery(name = "Repositioning.findByDay", query = "SELECT r FROM Repositioning r WHERE r.repositioningPK.day = :day")
    , @NamedQuery(name = "Repositioning.findByHorary", query = "SELECT r FROM Repositioning r WHERE r.repositioningPK.horary = :horary")
    , @NamedQuery(name = "Repositioning.findByNumberClass", query = "SELECT r FROM Repositioning r WHERE r.numberClass = :numberClass")
    , @NamedQuery(name = "Repositioning.findByPresence", query = "SELECT r FROM Repositioning r WHERE r.presence = :presence")
    , @NamedQuery(name = "Repositioning.findByDescription", query = "SELECT r FROM Repositioning r WHERE r.description = :description")})
public class Repositioning implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RepositioningPK repositioningPK;
    @Column(name = "NumberClass")
    private Integer numberClass;
    @Column(name = "Presence")
    private String presence;
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "Registration_NumberRegistration", referencedColumnName = "NumberRegistration")
    @ManyToOne(optional = false)
    private Registration registrationNumberRegistration;
    @JoinColumn(name = "Teacher_CPF", referencedColumnName = "CPF")
    @ManyToOne(optional = false)
    private Teacher teacherCPF;

    public Repositioning() {
    }

    public Repositioning(RepositioningPK repositioningPK) {
        this.repositioningPK = repositioningPK;
    }

    public Repositioning(Date day, String horary) {
        this.repositioningPK = new RepositioningPK(day, horary);
    }

    public RepositioningPK getRepositioningPK() {
        return repositioningPK;
    }

    public void setRepositioningPK(RepositioningPK repositioningPK) {
        this.repositioningPK = repositioningPK;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (repositioningPK != null ? repositioningPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repositioning)) {
            return false;
        }
        Repositioning other = (Repositioning) object;
        if ((this.repositioningPK == null && other.repositioningPK != null) || (this.repositioningPK != null && !this.repositioningPK.equals(other.repositioningPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Repositioning[ repositioningPK=" + repositioningPK + " ]";
    }
    
}
