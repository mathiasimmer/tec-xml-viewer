package dk.sdu.mmmi.mathiasi.tec.xml.viewer.component;

import dk.sdu.mmmi.mathiasi.tec.xml.viewer.model.Employee;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Mathias
 */
public class EmployeeRepository implements IEmployeeRepository {

    private final String XML_FILE = "addressbook.xml";

    @Override
    public List<Employee> getAll() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        List<Employee> result = new ArrayList();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document dom = db.parse(XML_FILE);

            Element rootElement = dom.getDocumentElement();

            NodeList nl = rootElement.getElementsByTagName("entry");

            for (int i = 0; i < nl.getLength(); i++) {
                Element el = (Element) nl.item(i);

                Employee emp = new Employee(el.getAttribute("id"));
                emp.setId(el.getAttribute("id"));
                emp.setForname(el.getElementsByTagName("forename").item(0).getTextContent());
                emp.setLastname(el.getElementsByTagName("lastname").item(0).getTextContent());
                emp.setBirthday(el.getElementsByTagName("birthday").item(0).getTextContent());
                emp.setSex(el.getElementsByTagName("sex").item(0).getTextContent());

                NodeList mailNodes = el.getElementsByTagName("mail");
                List<String> mails = new ArrayList();
                for (int j = 0; j < mailNodes.getLength(); j++) {
                    mails.add(mailNodes.item(j).getTextContent());
                }
                emp.setMails(mails);
                
                NodeList phoneNodes = el.getElementsByTagName("phone");
                List<String> phones = new ArrayList();
                for (int j = 0; j < phoneNodes.getLength(); j++) {
                    phones.add(phoneNodes.item(j).getTextContent());
                }
                emp.setPhones(phones);

                result.add(emp);

            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(EmployeeRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(EmployeeRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public Employee getEmployee(String id) {
        for (Employee employee : getAll()) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public void addEmployee(Employee emp) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
