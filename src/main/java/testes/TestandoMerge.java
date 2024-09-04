package testes;

import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestandoMerge {

    public static void main(String[] args) {

        EntityManagerFactory fabricaEM = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager em = fabricaEM.createEntityManager();

        em.getTransaction().begin();
        Pessoa pessoa = new Pessoa();
        pessoa.setId(7l);
        pessoa.setNome("Irismar antes do Merge");
        pessoa.setCpf("34548262253");

        pessoa = em.merge(pessoa);
        em.getTransaction().commit();

        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());
        System.out.println("CPF: " + pessoa.getCpf());


        em.close();

        fabricaEM.close();
    }
}
