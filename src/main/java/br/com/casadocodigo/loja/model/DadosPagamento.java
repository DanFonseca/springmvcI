package br.com.casadocodigo.loja.model;

import java.math.BigDecimal;

public class DadosPagamento {

    private BigDecimal value;

    public DadosPagamento (BigDecimal value){
        this.value = value;
    }
    public BigDecimal getValue (){
        return this.value;
    }
}
