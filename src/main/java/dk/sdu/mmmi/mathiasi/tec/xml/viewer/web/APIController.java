package dk.sdu.mmmi.mathiasi.tec.xml.viewer.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dk.sdu.mmmi.mathiasi.tec.xml.viewer.component.IEmployeeRepository;
import dk.sdu.mmmi.mathiasi.tec.xml.viewer.model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mathias
 */
@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private IEmployeeRepository repository;

    @RequestMapping("/employeeList")
    public String employeeList() {
        List<Employee> emps = repository.getAll();
        ListResponse response = new ListResponse(emps);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(response);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @RequestMapping(value = "/employee/add", method = RequestMethod.POST)
    public String addEmployee(
            @RequestParam(value = "forname", required = true) String forname,
            @RequestParam(value = "lastname", required = true) String lastname,
            @RequestParam(value = "sex", required = true) String sex,
            @RequestParam(value = "birthday", required = true) String birthday) {
        
        String newId = "Entry" + (repository.getAll().size() + 1);
        Employee emp = new Employee(newId);
        emp.setForname(forname);
        emp.setLastname(lastname);
        emp.setSex(sex);
        emp.setBirthday(birthday);
        
        repository.addEmployee(emp);

        System.out.println(emp);

        return "";
    }

    @RequestMapping("/employee/{id}/mails")
    public String getEmployeeMails(@PathVariable("id") String id) {
        Employee emp = repository.getEmployee(id);

        List<EntryRecord> mailRecords = new ArrayList();

        for (String mail : emp.getMails()) {
            mailRecords.add(new EntryRecord(mail));
        }

        ListResponse response = new ListResponse(mailRecords);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(response);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";

    }

    @RequestMapping("/employee/{id}/phones")
    public String getEmployeePhones(@PathVariable("id") String id) {
        Employee emp = repository.getEmployee(id);

        List<EntryRecord> phoneRecords = new ArrayList();

        for (String phone : emp.getPhones()) {
            phoneRecords.add(new EntryRecord(phone));
        }

        ListResponse response = new ListResponse(phoneRecords);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(response);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "";

    }

    class ListResponse<T> {

        public String Result = "OK";

        public List<T> Records;

        public ListResponse(List<T> Records) {
            this.Records = Records;
        }

        public void setError(boolean bool) {
            if (bool) {
                Result = "ERROR";
            } else {
                Result = "OK";
            }
        }

    }

    class EntryRecord {

        private String entry;

        public EntryRecord(String entry) {
            this.entry = entry;
        }

        public String getEntry() {
            return entry;
        }

        public void setEntry(String entry) {
            this.entry = entry;
        }

    }
}
