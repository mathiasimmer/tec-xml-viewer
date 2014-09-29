package dk.sdu.mmmi.mathiasi.tec.xml.viewer.component;

import dk.sdu.mmmi.mathiasi.tec.xml.viewer.model.Employee;
import java.util.List;

/**
 *
 * @author Mathias
 */
public interface IEmployeeRepository {

    public List<Employee> getAll();

    public Employee getEmployee(String id);

    public void addEmployee(Employee emp);
}
