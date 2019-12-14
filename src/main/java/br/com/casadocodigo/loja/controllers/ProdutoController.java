package br.com.casadocodigo.loja.controllers;
import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.tipoPreco;
import br.com.casadocodigo.loja.validator.ProdutoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @InitBinder
    public void initBinder (WebDataBinder binder){
        binder.addValidators(new ProdutoValidator());
    }


    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping("form")
    public ModelAndView form(Produto produto){

       ModelAndView modelAndView = new ModelAndView("produtos/form");
       modelAndView.addObject("tipos", tipoPreco.values());

       return modelAndView;
    }



    @RequestMapping(value = "cadastrarProduto", method = RequestMethod.POST)
    public ModelAndView cadastrarProduto (@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes){

       if(result.hasErrors()){
           return form(produto);
       }

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
