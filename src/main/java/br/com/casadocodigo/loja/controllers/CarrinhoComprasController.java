package br.com.casadocodigo.loja.controllers;

import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.model.CarrinhoCompras;
import br.com.casadocodigo.loja.model.CarrinhoItem;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/carrinho")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {

    @Autowired
    private CarrinhoCompras carrinhoCompras;
    @Autowired
    ProdutoDAO produtoDAO;

    @RequestMapping("add")
    public ModelAndView add (Integer produtoId, TipoPreco tipoPreco){

            CarrinhoItem carrinhoItem = criaItem(produtoId, tipoPreco);
            carrinhoCompras.add(carrinhoItem);
             System.out.println(carrinhoCompras.getTotal());
            ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");

        return  modelAndView;
    }

    public CarrinhoItem criaItem (Integer produtoId, TipoPreco tipoPreco){
       Produto produto = produtoDAO.buscarProduto(produtoId);
        CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);

        return carrinhoItem;
    }

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView itens(){
        return new ModelAndView("/carrinho/itens");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView remover (Integer id, TipoPreco tipoPreco){
        carrinhoCompras.remover(id, tipoPreco);
        return new ModelAndView("redirect:/carrinho");
    }

}
