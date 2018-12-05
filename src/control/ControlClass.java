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
import modelo.ClassPK;

/**
 *
 * @author Aluno
 */
public class ControlClass {
       public void saveNew(Class newClass)
    {
        EntityManager management = utilities.ManagementEntities.createManagement();
        
        management.getTransaction().begin();
        
        management.persist(newClass);
        
        management.getTransaction().commit();
        
        management.close();
        
    }
    
    public void change(Class altclass)
    {
       
        EntityManager gerente = utilities.ManagementEntities.createManagement();
        
        gerente.getTransaction().begin();  
        
        gerente.merge(altclass);
        
        gerente.getTransaction().commit();
        
        gerente.close(); 
    }
    
    
    public void delete(Date dayClass,String horaryClass)
    {
        Class classDelete;
        ClassPK deleteClass = new ClassPK();
        
        deleteClass.setDay(dayClass);
        deleteClass.setHorary(horaryClass);
        

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        classDelete = gerente.find(Class.class,deleteClass );

        gerente.getTransaction().begin();  
        
        gerente.remove(classDelete);
        
        gerente.getTransaction().commit();
        
        gerente.close(); 
    }
    
    public List<Class> listAll()
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        TypedQuery<Class> consulta;
        
        consulta = gerente.createNamedQuery("Class.findAll", Class.class);
        
        return consulta.getResultList();
    }
    
    public List<Class> listByDay(Date daySearch)
    {

       EntityManager gerente = utilities.ManagementEntities.createManagement();
        
        TypedQuery<Class> consulta;
        
        consulta = gerente.createNamedQuery("Class.findByDay", Class.class);
        
        consulta.setParameter("day", daySearch);
        
        return consulta.getResultList();        
    }
    
}
