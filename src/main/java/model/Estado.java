package model;

import javax.persistence.*;

@Entity(name = "estado")
public class Estado {
    @Id
    @Column(name = "estadocodigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "estadonome", nullable = false, length = 50)
    private String nome;
    @Column(name = "estadosigla", nullable = false)
    private String sigla;

    public Estado() {}

    public Estado(int id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
