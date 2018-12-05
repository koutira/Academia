/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Payment;
import model.PaymentPK;

/**
 *
 * @author Aluno
 */
public class ControlPayment {
       public void saveNew(Payment newPayment)
    {
        EntityManager management = utilities.ManagementEntities.createManagement();
        
        management.getTransaction().begin();
        
        management.persist(newPayment);
        
        management.getTransaction().commit();
        
        management.close();
        
    }
    
    public void change(Payment altPayment)
    {
       
        EntityManager gerente = utilities.ManagementEntities.createManagement();
        
        gerente.getTransaction().begin();  
        
        gerente.merge(altPayment);
        
        gerente.getTransaction().commit();
        
        gerente.close(); 
    }
    
    
    public void delete(int mouthPayment, int registrationNumeroMatricula)
    {
        Payment deletePayment;
        PaymentPK deletePayment01 = new PaymentPK();
        
        deletePayment01.setMonth(mouthPayment);
        deletePayment01.setRegistrationNumeroMatricula(registrationNumeroMatricula);

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        deletePayment = gerente.find(Payment.class, deletePayment01);

        gerente.getTransaction().begin();  
        
        gerente.remove(deletePayment);
        
        gerente.getTransaction().commit();
        
        gerente.close(); 
    }
    
    public List<Payment> listAll()
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        TypedQuery<Payment> consulta;
        
        consulta = gerente.createNamedQuery("Payment.findAll",Payment.class);
        
        return consulta.getResultList();
    }
    
    public List<Payment> listByRegistrationNumber(int numberRegistration)
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        TypedQuery<Payment> consulta;
        
        consulta = gerente.createNamedQuery("Payment.findByRegistrationNumeroMatricula", Payment.class);
        
        consulta.setParameter("RegistrationNumeroMatricula", numberRegistration);
        
        return consulta.getResultList();        
    }
    
    public List<Payment> listByType(int monthPayment)
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        TypedQuery<Payment> consulta;
        
        consulta = gerente.createNamedQuery("Payment.findByMonth", Payment.class);
        
        consulta.setParameter("Month", monthPayment);
        
        return consulta.getResultList();        
    }
    
}
