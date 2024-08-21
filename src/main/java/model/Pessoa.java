package model;

import javax.persistence.*;

@Entity(name = "pessoa")
public class Pessoa {

    @Id()
    @Column(name="pesid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="pescpf", nullable=false, unique=true, length=11)
    private String cpf;
    @Column(name="pesnome", nullable = false)
    private String nome;
    @Column(name ="pesidade", nullable = true)
    private int idade;

    public Pessoa() {
    }

    public Pessoa(long id, String cpf, int idade, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.idade = idade;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
