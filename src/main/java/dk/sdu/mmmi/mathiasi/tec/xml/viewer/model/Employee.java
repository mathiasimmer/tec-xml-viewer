package dk.sdu.mmmi.mathiasi.tec.xml.viewer.model;

import java.util.List;

/**
 *
 * @author Mathias
 */
public class Employee {

    private String id;
    private String forname;
    private String lastname;
    private List<String> mails;
    private List<String> phones;
    private String sex;
    private String birthday;

    public Employee() {
    }

    public Employee(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<String> getMails() {
        return mails;
    }

    public void setMails(List<String> mails) {
        this.mails = mails;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", forname=" + forname + ", lastname=" + lastname + ", mails=" + mails + ", phones=" + phones + ", sex=" + sex + ", birthday=" + birthday + '}';
    }

}
