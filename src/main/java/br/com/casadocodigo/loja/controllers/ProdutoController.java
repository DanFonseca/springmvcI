package br.com.casadocodigo.loja.controllers;
import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.tipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping("form")
    public ModelAndView form(){

       ModelAndView modelAndView = new ModelAndView("produtos/form");
       modelAndView.addObject("tipos", tipoPreco.values());

       return modelAndView;
    }

    @RequestMapping(value = "cadastrarProduto", method = RequestMethod.POST)
    public ModelAndView cadastrarProduto (Produto produto, RedirectAttributes redirectAttributes){
        System.out.println(produto);
        produtoDAO.gravar(produto);
        redirectAttributes.addFlashAttribute("sucesso", "Produto Cadastrado com Sucesso");

        return  new ModelAndView("redirect:listar");
    }


    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public ModelAndView listarProduto (){

        List<Produto> produtos = produtoDAO.listarProdutos();
        ModelAndView modelAndView = new ModelAndView("/produtos/listar");
        modelAndView.addObject("produtos", produtos);

        return  modelAndView;
    }
}
