package dk.sdu.mmmi.mathiasi.tec.xml.viewer.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mathias
 */
@Controller
@RequestMapping("/emps")
public class EmployeeController {

//    @Autowired
//    private IEmployeeRepository repository;
    
    @RequestMapping("/")
    public String index(Model model){
//        List<Employee> emps = repository.getAll();
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter(); 
//        try {
//            model.addAttribute("userId", ow.writeValueAsString(emps));
//        } catch (JsonProcessingException ex) {
//            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return "employees";
    }
}
