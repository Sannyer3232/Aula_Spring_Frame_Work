package testes;

import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestandoDeletar {
    public static void main(String[] args) {
        EntityManagerFactory fabricaEM = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager em = fabricaEM.createEntityManager();

        em.getTransaction().begin();

        Pessoa pessoa = em.find(Pessoa.class, 5L);


        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());

        em.remove(pessoa);

        em.getTransaction().commit();

        em.close();

        fabricaEM.close();
    }
}
