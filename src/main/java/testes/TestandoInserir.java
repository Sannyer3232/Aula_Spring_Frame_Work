package testes;

import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestandoInserir {
    public static void main(String[] args) {

       EntityManagerFactory fabricaEM = Persistence.createEntityManagerFactory("SistemaPU");

       EntityManager em = fabricaEM.createEntityManager();
       Pessoa pessoa = new Pessoa();
       pessoa.setNome("Fani Tamires");
       pessoa.setIdade(28);
       pessoa.setCpf("15615632478");

       EntityTransaction transacao =em.getTransaction();

       try {
          transacao.begin();

          em.persist(pessoa);

          transacao.commit();

       }catch (Exception e) {
          if(transacao.isActive()) {
             transacao.rollback();
          }
          throw new RuntimeException(e);
       }finally {
          em.close();

          fabricaEM.close();
       }





    }
}
