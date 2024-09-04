package testes;

import model.Cidade;
import model.Estado;
import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestandoPessoaComCidade {

    public static void inserindoComCidade(Pessoa pessoa, Cidade cidade) {
        EntityManagerFactory fabricaEM = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager em = fabricaEM.createEntityManager();

        pessoa.setCidade(cidade);

        EntityTransaction transacao =em.getTransaction();

        try {
            transacao.begin();
            em.persist(cidade);

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

    public static void inserindoComCidadeExistenteNoBancoDeDados() {
        EntityManagerFactory fabricaEM = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager em = fabricaEM.createEntityManager();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João de Carvalho");
        pessoa.setCpf("12345678912");
        pessoa.setIdade(93);

        EntityTransaction transacao =em.getTransaction();

        try {
            transacao.begin();
            Cidade cidade = em.find(Cidade.class, 1L);

            pessoa.setCidade(cidade);

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

    public static void inserindoComCidadeEstado() {
        EntityManagerFactory fabricaEM = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager em = fabricaEM.createEntityManager();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João de Carvalho");
        pessoa.setCpf("12345678912");
        pessoa.setIdade(93);

        Cidade cidade = new Cidade();
        cidade.setNome("Manaus");

        Estado estado = new Estado();
        estado.setNome("Amazonas");
        estado.setSigla("AM");

        cidade.setEstado(estado);
        pessoa.setCidade(cidade);

        EntityTransaction transacao =em.getTransaction();

        try {
            transacao.begin();
            em.persist(estado);
            em.persist(cidade);
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

    public static void consultarComCidade(long id) {
        EntityManagerFactory fabricaEM = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager em = fabricaEM.createEntityManager();



        EntityTransaction transacao =em.getTransaction();

        try {

            Pessoa pessoa = em.find(Pessoa.class, id);
            System.out.println(pessoa);

        }catch (Exception e) {

            throw new RuntimeException(e);
        }finally {
            em.close();

            fabricaEM.close();
        }
    }
    public static void main(String[] args) {

        inserindoComCidadeEstado();
    }
}
