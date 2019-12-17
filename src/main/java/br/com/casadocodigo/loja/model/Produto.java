package br.com.casadocodigo.loja.model;
import org.hibernate.TypeMismatchException;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


import java.util.Calendar;
import java.util.List;


@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String titulo;
    private int quantidadeDePaginas;
    private String descricao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar dataLancamento;

    private String sumarioPath;

    @ElementCollection
    private  List<@Valid Preco> precos;





    public String getSumarioPath() {
        return sumarioPath;
    }

    public void setSumarioPath(String sumarioPath) {
        this.sumarioPath = sumarioPath;
    }

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


    public Calendar getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Calendar dataLancamento) {
        this.dataLancamento = dataLancamento;
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
