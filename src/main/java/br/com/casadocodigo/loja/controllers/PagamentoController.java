package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.model.CarrinhoCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pagamnto")
public class PagamentoController {
    @Autowired
    private CarrinhoCompras carrinhoCompras;

    @RequestMapping(value = "finalizar", method = RequestMethod.POST)
    public ModelAndView finalizar (RedirectAttributes attributes){
        attributes.addFlashAttribute("sucesso","Compra finalizada com sucesso");
        return new ModelAndView("redirect:/produtos/");
    }
}
