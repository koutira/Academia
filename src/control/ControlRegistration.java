/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Registration;

/**
 *
 * @author Aluno
 */
public class ControlRegistration {
       public void saveNew(Registration newRegistration)
    {
        EntityManager management = utilities.ManagementEntities.createManagement();
        

        management.getTransaction().begin();
        
        management.persist(newRegistration);
        
        management.getTransaction().commit();
        
        management.close();
        
    }
    
    public void change(Registration altRegistration)
    {
       
        EntityManager gerente = utilities.ManagementEntities.createManagement();
        
        gerente.getTransaction().begin();  
        
        gerente.merge(altRegistration);
        
        gerente.getTransaction().commit();
        
        gerente.close(); 
    }
    
    
    public void delete(int numberRegistration)
    {
        Registration deleteRegistration;

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        deleteRegistration = gerente.find(Registration.class, numberRegistration);

        gerente.getTransaction().begin();  
        
        gerente.remove(deleteRegistration);
        
        gerente.getTransaction().commit();
        
        gerente.close(); 
    }
    
    public List<Registration> listAll()
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        
        TypedQuery<Registration> consulta;
        
        consulta = gerente.createNamedQuery("Registration.findAll",Registration.class);
        
        return consulta.getResultList();
    }
    
    public List<Registration> listByInitials(int numberRegistration)
    {
 
        EntityManager gerente = utilities.ManagementEntities.createManagement();

        TypedQuery<Registration> consulta;
        
        consulta = gerente.createNamedQuery("Registration.findByNumberRegistration", Registration.class);
        
        consulta.setParameter("NumberRegistration", numberRegistration);
        
        return consulta.getResultList();        
    }
    
    
    
}
