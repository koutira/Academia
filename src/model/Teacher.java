/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
@Table(name = "teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t")
    , @NamedQuery(name = "Teacher.findByCpf", query = "SELECT t FROM Teacher t WHERE t.cpf = :cpf")
    , @NamedQuery(name = "Teacher.findByRg", query = "SELECT t FROM Teacher t WHERE t.rg = :rg")
    , @NamedQuery(name = "Teacher.findByName", query = "SELECT t FROM Teacher t WHERE t.name = :name")
    , @NamedQuery(name = "Teacher.findByAddress", query = "SELECT t FROM Teacher t WHERE t.address = :address")
    , @NamedQuery(name = "Teacher.findByEmail", query = "SELECT t FROM Teacher t WHERE t.email = :email")
    , @NamedQuery(name = "Teacher.findByTelephone", query = "SELECT t FROM Teacher t WHERE t.telephone = :telephone")
    , @NamedQuery(name = "Teacher.findByMaritalStatus", query = "SELECT t FROM Teacher t WHERE t.maritalStatus = :maritalStatus")
    , @NamedQuery(name = "Teacher.findByFormation", query = "SELECT t FROM Teacher t WHERE t.formation = :formation")
    , @NamedQuery(name = "Teacher.findBySalary", query = "SELECT t FROM Teacher t WHERE t.salary = :salary")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "RG")
    private String rg;
    @Column(name = "Name")
    private String name;
    @Column(name = "Address")
    private String address;
    @Column(name = "Email")
    private String email;
    @Column(name = "Telephone")
    private String telephone;
    @Column(name = "MaritalStatus")
    private String maritalStatus;
    @Column(name = "Formation")
    private String formation;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Salary")
    private Double salary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherCPF")
    private Collection<Repositioning> repositioningCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherCPF")
    private Collection<Class> classCollection;

    public Teacher() {
    }

    public Teacher(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @XmlTransient
    public Collection<Repositioning> getRepositioningCollection() {
        return repositioningCollection;
    }

    public void setRepositioningCollection(Collection<Repositioning> repositioningCollection) {
        this.repositioningCollection = repositioningCollection;
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
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Teacher[ cpf=" + cpf + " ]";
    }
    
}
