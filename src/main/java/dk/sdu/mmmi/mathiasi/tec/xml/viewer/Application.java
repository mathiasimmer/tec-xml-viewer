package dk.sdu.mmmi.mathiasi.tec.xml.viewer;

import dk.sdu.mmmi.mathiasi.tec.xml.viewer.component.EmployeeRepository;
import dk.sdu.mmmi.mathiasi.tec.xml.viewer.component.IEmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Mathias
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    @Bean
    public IEmployeeRepository employeeRepository() {
        return new EmployeeRepository();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
