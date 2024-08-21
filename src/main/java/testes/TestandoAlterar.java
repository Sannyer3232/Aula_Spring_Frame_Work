package testes;

import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestandoAlterar {
    public static void main(String[] args) {
        EntityManagerFactory fabricaEM = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager em = fabricaEM.createEntityManager();

        em.getTransaction().begin();
        Pessoa pessoa = em.find(Pessoa.class, 1L);

        pessoa.setNome("Sannyer Cardoso Carvalho Nery");
        pessoa.setIdade(24);
        pessoa.setCpf("03536054250");
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());

        em.getTransaction().commit();

        em.close();

        fabricaEM.close();
    }
}
