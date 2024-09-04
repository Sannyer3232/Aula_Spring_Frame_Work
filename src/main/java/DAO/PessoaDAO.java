package DAO;

import model.Pessoa;

import javax.persistence.*;
import java.util.List;

public class PessoaDAO {
    private EntityManager em = null;

    public PessoaDAO(EntityManager em){
        this.em = em;
    }

    public void inserir(Pessoa pessoa) {

        EntityTransaction transacao = em.getTransaction();

        try {
            transacao.begin();

            em.persist(pessoa);

            transacao.commit();


        } catch (Exception e) {
            if (transacao.isActive()) {
                transacao.rollback();

            }
            throw new RuntimeException(e);
        }

    }

    public Pessoa consultar(long id) {
        Pessoa pessoa = new Pessoa();
        try {
            pessoa = em.find(Pessoa.class, id);

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pessoa;
    }

    public void alterar(Pessoa pessoa){
        EntityTransaction transacao = em.getTransaction();
        try {
            transacao.begin();
            Pessoa pes = em.find(Pessoa.class, pessoa.getId());
            pes.setNome(pessoa.getNome());
            pes.setCpf(pessoa.getCpf());
            pes.setIdade(pessoa.getIdade());
            transacao.commit();


        }catch (Exception e ){
            if (transacao.isActive()) {
                transacao.rollback();

            }else{
                throw new RuntimeException(e);
            }

        }
    }
    public void excluir(long id){
        EntityTransaction transacao = em.getTransaction();
        try {
            em.getTransaction().begin();
            Pessoa pessoa = em.find(Pessoa.class, id);
            em.remove(pessoa);
            em.getTransaction().commit();

        }catch (Exception e ){
            if (transacao.isActive()) {
                transacao.rollback();

            }else{
                throw new RuntimeException(e);
            }
        }
    }

    public void pesquisar(String nome){
        EntityTransaction transacao = em.getTransaction();
        try {
            Query query = em.createQuery("select p from pessoa p where p.nome like :parNome");
            query.setParameter("parNome", "%"+nome+"%");

            List<Pessoa> pessoas = query.getResultList();
            for (Pessoa p : pessoas) {
                System.out.println("Nome: " + p.getNome());
                System.out.println("Idade: " + p.getIdade());
                System.out.println("Cpf: " + p.getCpf());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
