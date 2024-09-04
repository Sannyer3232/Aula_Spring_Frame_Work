package testes;

import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TestandoPesquisar {

    public static void main(String[] args) {
        EntityManagerFactory fabricaEM = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager em = fabricaEM.createEntityManager();


        Query query = em.createQuery("select p from pessoa p where p.nome like :parNome");

        query.setParameter("parNome", "%"+"Tamires"+"%");

        List<Pessoa> pessoas = query.getResultList();
        for (Pessoa p : pessoas) {
            System.out.println("Nome: " + p.getNome());
            System.out.println("Idade: " + p.getIdade());
        }



        em.close();

        fabricaEM.close();
    }
}
