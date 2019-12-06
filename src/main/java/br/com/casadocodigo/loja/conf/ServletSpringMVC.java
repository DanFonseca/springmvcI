package br.com.casadocodigo.loja.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Informando ao servidor WEB que o SPRING MVC ira tratar as requisiçoes
//deve herdar as interfaces do spring AbstractAnnotationConfigDispatcherServletInitializer
//Classe de configuração.

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("iniciando getRootConfigClasses");
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("iniciando getServletConfigClasses");
        return new Class[] {AppWebConfiguration.class, JPAConfiguration.class};

    }

    //Este método informa qual URL o Spring deve mapear
    @Override
    protected String[] getServletMappings() {
        System.out.println("iniciando getServletMappings");
        return new String [] {"/"};
    }
}
