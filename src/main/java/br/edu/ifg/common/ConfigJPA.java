package br.edu.ifg.common;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Singleton
public class ConfigJPA {

    private static javax.persistence.EntityManagerFactory emf;

    public static EntityManagerFactory getEmf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("GestaoPetShop");
        }
        return emf;
    }
    
    public static EntityManager getEntityManager(){
        return getEmf().createEntityManager();
    }
}