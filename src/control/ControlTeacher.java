/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Teacher;

/**
 *
 * @author Aluno
 */
public class ControlTeacher {
       public void saveNew(Teacher newTeacher)
    {
        EntityManager management = utilities.ManagementEntities.createManagement();

        management.getTransaction().begin();
        
        management.persist(newTeacher);
        
        management.getTransaction().commit();
        
        management.close();
        
    }
    
    public void change(Teacher altTeacher)
    {
       
        EntityManager gerente = utilities.ManagementEntities.createManagement();
        
        gerente.getTransaction().begin();  
        
        gerente.merge(altTeacher);
        
        gerente.getTransaction().commit();
        
        gerente.close(); 
    }
    
    
    public void delete(String cpfTeacher)
    {
        Teacher deleteTeacher;

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        deleteTeacher = gerente.find(Teacher.class, cpfTeacher);

        gerente.getTransaction().begin();  
        
        gerente.remove(deleteTeacher);
        
        gerente.getTransaction().commit();
        
        gerente.close(); 
    }
    
    public List<Teacher> listAll()
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        TypedQuery<Teacher> consulta;
        
        consulta = gerente.createNamedQuery("Teacher.findAll",Teacher.class);
        
        return consulta.getResultList();
    }
    
    public List<Teacher> listByName(String nameTeacher)
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();
        
        TypedQuery<Teacher> consulta;
        
        consulta = gerente.createNamedQuery("Teacher.findByName", Teacher.class);
        
        consulta.setParameter("Name", "%"+nameTeacher+"%");
        
        return consulta.getResultList();        
    }
    
    public List<Teacher> listByCPF(String cpfTeacher)
    {
        EntityManager gerente = utilities.ManagementEntities.createManagement();
        
        TypedQuery<Teacher> consulta;
        
        consulta = gerente.createNamedQuery("Teacher.findByCpf", Teacher.class);
        
        consulta.setParameter("Cpf", cpfTeacher);
        
        return consulta.getResultList();        
    }
    
    public List<Teacher> listByRG(String rgTeacher)
    {
        EntityManager gerente = utilities.ManagementEntities.createManagement();

        
        TypedQuery<Teacher> consulta;
        
        consulta = gerente.createNamedQuery("Teacher.findByRg", Teacher.class);
        
        consulta.setParameter("Rg", rgTeacher);
        
        return consulta.getResultList();        
    }
    
    public List<Teacher> listByFormation(String formationTeacher)
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        TypedQuery<Teacher> consulta;
        
        consulta = gerente.createNamedQuery("Teacher.findByFormation", Teacher.class);
        
        consulta.setParameter("Formation", formationTeacher);
        
        return consulta.getResultList();        
    }
}
