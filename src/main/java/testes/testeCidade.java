package testes;

import model.Cidade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class testeCidade {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Cidade cidade = new Cidade();
        cidade.setNome("Manaus");

        em.persist(cidade);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
