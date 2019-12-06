package br.com.casadocodigo.loja.model;
import javax.persistence.*;
import java.sql.ClientInfoStatus;
import java.util.List;
import br.com.casadocodigo.loja.model.Preco;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private int quantidadeDePaginas;
    private String descricao;

    @ElementCollection
    private  List<Preco> precos;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Preco> getPrecos() {

        return precos;
    }

    public void setPrecos(List<Preco> precos) {
        this.precos = precos;

    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuantidadeDePaginas() {
        return quantidadeDePaginas;
    }

    public void setQuantidadeDePaginas(int quantidadeDePaginas) {
        this.quantidadeDePaginas = quantidadeDePaginas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "titulo='" + titulo + '\'' +
                ", quantidadeDePaginas=" + quantidadeDePaginas +
                ", descricao='" + descricao + '\'' +
                '}';
    }

}
