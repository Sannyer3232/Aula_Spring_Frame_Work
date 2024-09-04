package model;

import javax.persistence.*;

@Entity
public class Cidade {
    @Id
    @Column(name = "cidcodigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="cidnome", nullable=false, unique=true, length=100)
    private String nome;
    @ManyToOne
    private Estado estado;


    public Cidade() {}

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
