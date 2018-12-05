/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Repositioning;
import model.RepositioningPK;

/**
 *
 * @author Aluno
 */
public class ControlRepositioning {
       public void saveNew(Repositioning newRepositioning)
    {
        EntityManager management = utilities.ManagementEntities.createManagement();
        

        management.getTransaction().begin();
        
        management.persist(newRepositioning);
        
        management.getTransaction().commit();
        
        management.close();
        
    }
    
    public void change(Repositioning altRepositioning)
    {
       
        EntityManager gerente = utilities.ManagementEntities.createManagement();
        
        gerente.getTransaction().begin();  
        
        gerente.merge(altRepositioning);
        
        gerente.getTransaction().commit();
        
        gerente.close(); 
    }
    
    
    public void delete(Date dayClass,String horaryClass)
    {
        Repositioning repositioningDelete;
        RepositioningPK deleteRepositioning = new RepositioningPK();
        
        deleteRepositioning.setDay(dayClass);
        deleteRepositioning.setHorary(horaryClass);
        

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        repositioningDelete = gerente.find(Repositioning.class,deleteRepositioning );

        gerente.getTransaction().begin();  
        
        gerente.remove(repositioningDelete);
        
        gerente.getTransaction().commit();
        
        gerente.close(); 
    }
    
    public List<Repositioning> listAll()
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        
        TypedQuery<Repositioning> consulta;
        
        consulta = gerente.createNamedQuery("Repositioning.findAll", Repositioning.class);
        
        return consulta.getResultList();
    }
    
    public List<Repositioning> listByDay(Date daySearch)
    {
  
       EntityManager gerente = utilities.ManagementEntities.createManagement();
        
        TypedQuery<Repositioning> consulta;
        
        consulta = gerente.createNamedQuery("Repositioning.findByDay", Repositioning.class);
        
        consulta.setParameter("day", daySearch);
        
        return consulta.getResultList();        
    }
    
}
