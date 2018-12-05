/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Course;

/**
 *
 * @author Aluno
 */
public class ControlCourse {
       public void saveNew(Course newCourse)
    {
        EntityManager management = utilities.ManagementEntities.createManagement();

        management.getTransaction().begin();
        
        management.persist(newCourse);
        
        management.getTransaction().commit();
        
        management.close();
        
    }
    
    public void change(Course altCourse)
    {
       
        EntityManager gerente = utilities.ManagementEntities.createManagement();

        gerente.getTransaction().begin();  
        
        gerente.merge(altCourse);
        
        gerente.getTransaction().commit();
        
        gerente.close(); 
    }
    
    
    public void delete(String initialCourse)
    {
        Course deleteCourse;

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        deleteCourse = gerente.find(Course.class, initialCourse);

        gerente.getTransaction().begin();  
        
        gerente.remove(deleteCourse);
        
        gerente.getTransaction().commit();
        
        gerente.close(); 
    }
    
    public List<Course> listAll()
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        TypedQuery<Course> consulta;
        
        consulta = gerente.createNamedQuery("Course.findAll",Course.class);
        
        return consulta.getResultList();
    }
    
    public List<Course> listByInitials(String inititalCourse)
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        TypedQuery<Course> consulta;
        
        consulta = gerente.createNamedQuery("Course.findByInitials", Course.class);
        
        consulta.setParameter("initials", inititalCourse);
        
        return consulta.getResultList();        
    }
    
    public List<Course> listByType(String typeCourse)
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        
        TypedQuery<Course> consulta;
        
        consulta = gerente.createNamedQuery("Course.findByType", Course.class);
        
        consulta.setParameter("Type", typeCourse);
        
        return consulta.getResultList();        
    }
    
}
