package br.com.lcasadocodigo.loja.conf;

import br.com.lcasadocodigo.loja.DAO.ProdutoDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import br.com.lcasadocodigo.loja.controllers.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackageClasses = {PagesController.class, ProdutoDAO.class})

public class AppWebConfiguration {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver (){
        System.out.println("iniciando view");
        InternalResourceViewResolver resolver = new  InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

}
