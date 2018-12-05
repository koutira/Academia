/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Aluno
 */
@Embeddable
public class PaymentPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Month")
    private int month;
    @Basic(optional = false)
    @Column(name = "Registration_NumeroMatricula")
    private int registrationNumber;

    public PaymentPK() {
    }

    public PaymentPK(int month, int registrationNumeroMatricula) {
        this.month = month;
        this.registrationNumber = registrationNumeroMatricula;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getRegistrationNumeroMatricula() {
        return registrationNumber;
    }

    public void setRegistrationNumeroMatricula(int registrationNumeroMatricula) {
        this.registrationNumber = registrationNumeroMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) month;
        hash += (int) registrationNumber;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentPK)) {
            return false;
        }
        PaymentPK other = (PaymentPK) object;
        if (this.month != other.month) {
            return false;
        }
        if (this.registrationNumber != other.registrationNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PaymentPK[ month=" + month + ", registrationNumeroMatricula=" + registrationNumber + " ]";
    }
    
}
