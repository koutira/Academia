/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Student;

/**
 *
 * @author Aluno
 */
public class ControlStudent {
       public void saveNew(Student newStudent)
    {
        EntityManager management = utilities.ManagementEntities.createManagement();
        
        
        management.getTransaction().begin();
        
        management.persist(newStudent);
        
        management.getTransaction().commit();
        
        management.close();
        
    }
    
    public void change(Student altStudent)
    {
       
        EntityManager gerente = utilities.ManagementEntities.createManagement();
        
        gerente.getTransaction().begin();  
        
        gerente.merge(altStudent);
        
        gerente.getTransaction().commit();
        
        gerente.close(); 
    }
    
    
    public void delete(String cpfStudent)
    {
        Student deleteStudent;


        EntityManager gerente = utilities.ManagementEntities.createManagement();

        deleteStudent = gerente.find(Student.class, cpfStudent);

        gerente.getTransaction().begin();  
        
        gerente.remove(deleteStudent);
        
        gerente.getTransaction().commit();
        
        gerente.close(); 
    }
    
    public List<Student> listAll()
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        
        TypedQuery<Student> consulta;
        
        consulta = gerente.createNamedQuery("Student.findAll",Student.class);
        
        return consulta.getResultList();
    }
    
    public List<Student> listByName(String nameStudent)
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        TypedQuery<Student> consulta;
        
        consulta = gerente.createNamedQuery("Student.findByName", Student.class);
        
        consulta.setParameter("Name", "%"+nameStudent+"%");
        
        return consulta.getResultList();        
    }
    
    public List<Student> listByCPF(String cpfStudent)
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        TypedQuery<Student> consulta;
        
        consulta = gerente.createNamedQuery("Student.findByCpf", Student.class);
        
        consulta.setParameter("Cpf", cpfStudent);
        
        return consulta.getResultList();        
    }
    
    public List<Student> listByRG(String rgStudent)
    {

        EntityManager gerente = utilities.ManagementEntities.createManagement();

        
        TypedQuery<Student> consulta;
        
        consulta = gerente.createNamedQuery("Student.findByRg", Student.class);
        
        consulta.setParameter("Rg", rgStudent);
        
        return consulta.getResultList();        
    }
}
