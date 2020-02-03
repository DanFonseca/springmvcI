package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//Configurando a classe de controller
@Controller
public class HomeController {

    @Autowired
    private ProdutoDAO produtoDAO;

@Cacheable("produtosHome")
@RequestMapping("/")
    public ModelAndView index(){
        List<Produto> produtos = produtoDAO.listarProdutos();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("produtos",produtos);

        return modelAndView;
    }

}
