/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aluno
 */
public class ManagementEntities {
    
    private static EntityManagerFactory fabrica;
    
    public static EntityManager createManagement()
    {
        if (fabrica == null)
        {
            fabrica = Persistence.createEntityManagerFactory("MR");
        }
        
        return fabrica.createEntityManager();
    }
    
}
