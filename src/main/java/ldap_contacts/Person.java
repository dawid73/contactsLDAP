package ldap_contacts;

public class Person {

    private String fullName;
    private String lastName;
    private String mail;
    private String mobile;
    private String telephoneNumber;

    public Person() {
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Person(String fullName, String lastName, String mail) {
        this.fullName = fullName;
        this.lastName = lastName;
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setEmail(String mail) {
        this.mail = mail;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return
                "Nazwa: " + fullName + " || " + '\'' +
                        "Email: " + mail + " " + '\'' +
                        "Telefon: " + mobile + " " + '\'' +
                        "Telefon: " + telephoneNumber + " " + '\'' ;
    }
}
