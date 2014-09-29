package dk.sdu.mmmi.mathiasi.tec.xml.viewer;

/**
 *
 * @author Mathias
 */
import dk.sdu.mmmi.mathiasi.tec.xml.viewer.component.IPersonService;
import dk.sdu.mmmi.mathiasi.tec.xml.viewer.component.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
//@ComponentScan
@ComponentScan("dk.sdu.mmmi.mathiasi.tec.xml.viewer")
@EnableAutoConfiguration
public class Application {

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public IPersonService personService() {
        return new PersonService();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
