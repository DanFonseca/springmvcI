package br.com.casadocodigo.loja.controllers;
import br.com.casadocodigo.loja.DAO.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.model.Produto;
import br.com.casadocodigo.loja.model.TipoPreco;
import br.com.casadocodigo.loja.validator.ProdutoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
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
    @Autowired
    FileSaver fileSaver;

    @RequestMapping("form")

    public ModelAndView form(Produto produto){

       ModelAndView modelAndView = new ModelAndView("produtos/form");
       modelAndView.addObject("tipos", TipoPreco.values());

       return modelAndView;
    }



    @RequestMapping(value = "cadastrarProduto", method = RequestMethod.POST)
    @CacheEvict(value="produtosHome", allEntries=true)
    public ModelAndView cadastrarProduto
            (
            MultipartFile sumario,
            @Valid Produto produto,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) throws IOException
    {


       if(result.hasErrors()){
           return form(produto);
       }

       String path = fileSaver.write("aquivos-sumario", sumario);
       produto.setSumarioPath(path);

        produtoDAO.gravar(produto);
        redirectAttributes.addFlashAttribute("sucesso", "Produto Cadastrado com Sucesso");

        return  new ModelAndView("redirect:/produtos/");
    }




    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listarProduto (){

        List<Produto> produtos = produtoDAO.listarProdutos();
        ModelAndView modelAndView = new ModelAndView("/produtos/listar");
        modelAndView.addObject("produtos", produtos);

        return  modelAndView;
    }

    @RequestMapping(value = "detalhe/{id}", method = RequestMethod.GET)
    public ModelAndView detalhe (@PathVariable("id") Integer id){
       Produto produto = produtoDAO.buscarProduto(id);

        ModelAndView modelAndView = new ModelAndView("produtos/detalhe");
        modelAndView.addObject("produto", produto);

        return modelAndView;
    }
}
