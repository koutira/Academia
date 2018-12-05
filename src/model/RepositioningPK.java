/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aluno
 */
@Embeddable
public class RepositioningPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Day")
    @Temporal(TemporalType.DATE)
    private Date day;
    @Basic(optional = false)
    @Column(name = "Horary")
    private String horary;

    public RepositioningPK() {
    }

    public RepositioningPK(Date day, String horary) {
        this.day = day;
        this.horary = horary;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getHorary() {
        return horary;
    }

    public void setHorary(String horary) {
        this.horary = horary;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (day != null ? day.hashCode() : 0);
        hash += (horary != null ? horary.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepositioningPK)) {
            return false;
        }
        RepositioningPK other = (RepositioningPK) object;
        if ((this.day == null && other.day != null) || (this.day != null && !this.day.equals(other.day))) {
            return false;
        }
        if ((this.horary == null && other.horary != null) || (this.horary != null && !this.horary.equals(other.horary))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RepositioningPK[ day=" + day + ", horary=" + horary + " ]";
    }
    
}
