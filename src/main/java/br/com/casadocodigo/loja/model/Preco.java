package br.com.casadocodigo.loja.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.math.BigDecimal;

@Embeddable
public class Preco {

    private BigDecimal valor;
    private tipoPreco tipo;


    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public tipoPreco getTipo() {
        return tipo;
    }

    public void setTipo(tipoPreco tipo) {
        this.tipo = tipo;
    }



}
