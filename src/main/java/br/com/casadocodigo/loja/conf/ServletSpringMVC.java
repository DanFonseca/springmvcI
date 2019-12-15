package br.com.casadocodigo.loja.conf;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import br.com.casadocodigo.loja.model.Produto;
import org.springframework.web.filter.CharacterEncodingFilter;
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

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[]{encodingFilter};
    }

    @Override
    protected void customizeRegistration(Dynamic registration) {
        super.customizeRegistration(registration);
        registration.setMultipartConfig(new MultipartConfigElement(""));
    }





}
