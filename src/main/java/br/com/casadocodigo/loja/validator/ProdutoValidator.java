package br.com.casadocodigo.loja.validator;

import br.com.casadocodigo.loja.model.Produto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProdutoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Produto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "titulo","field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "dataLancamento", "field.required");

        Produto produto = (Produto) o;

        if (produto.getQuantidadeDePaginas() <= 0 ){
            errors.rejectValue("quantidadeDePaginas","field.required");
        }

    }
}
