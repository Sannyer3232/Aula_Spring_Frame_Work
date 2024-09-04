package testes;

import DAO.PessoaDAO;
import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestePessoaDAO {


    private static void testarInseir(Pessoa pessoa){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager em = emf.createEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(em);

        pessoaDAO.inserir(pessoa);
        em.close();
        emf.close();

    }

    public static void testarConsultar(long id){
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaPU");

        EntityManager em = emf.createEntityManager();
        PessoaDAO pessoaDAO = new PessoaDAO(em);
        pessoaDAO.consultar(id);
        em.close();
        emf.close();
    }

    public static void testarAlterar(Pessoa pessoa){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaPU");
        EntityManager em = emf.createEntityManager();
        PessoaDAO pessoaDAO = new PessoaDAO(em);
        pessoaDAO.alterar(pessoa);
        em.close();
        emf.close();
    }

    public static void testarDeletar(long id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaPU");
        EntityManager em = emf.createEntityManager();
        PessoaDAO pessoaDAO = new PessoaDAO(em);
        pessoaDAO.excluir(5);
        em.close();
        emf.close();
    }
    public static void testandoPesquisar(String nome){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaPU");
        EntityManager em = emf.createEntityManager();
        PessoaDAO pessoaDAO = new PessoaDAO(em);
        pessoaDAO.pesquisar(nome);
        em.close();
        emf.close();
    }
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(5,"03596345623",36,"Maria dos Santos");
        testandoPesquisar("Tamires");

    }

}
