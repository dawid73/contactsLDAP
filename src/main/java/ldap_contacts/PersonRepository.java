package ldap_contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.query.SearchScope;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import java.util.List;
import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Service
public class PersonRepository {

    private static final Integer THREE_SECONDS = 3000;

    @Autowired
    private LdapTemplate ldapTemplate;


    public List<Person> getPersonByString(String lastName) {

        SearchControls sc = new SearchControls();
        sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
        sc.setTimeLimit(THREE_SECONDS);
        sc.setCountLimit(350);
        sc.setReturningAttributes(new String[]{"cn", "mail", "mobile", "telephoneNumber"});

        String filter = "(&(objectclass=person)(cn=*" + lastName + "*))";
        return ldapTemplate.search(LdapUtils.emptyLdapName(), filter, sc, new PersonAttributesMapper());
    }


    private class PersonAttributesMapper implements AttributesMapper<Person> {
        public Person mapFromAttributes(Attributes attrs) throws NamingException {
            Person person = new Person();
            person.setFullName((String)attrs.get("cn").get());

            Attribute mail = attrs.get("mail");
            if (mail != null){
                person.setEmail((String)mail.get());
            }

            Attribute mobile = attrs.get("mobile");
            if (mobile != null){
                person.setMobile((String)mobile.get());
            }

            Attribute telephoneNumber = attrs.get("telephoneNumber");
            if (telephoneNumber != null){
                person.setTelephoneNumber((String)telephoneNumber.get());
            }

            Attribute sn = attrs.get("sn");
            if (sn != null){
                person.setLastName((String)sn.get());
            }
            return person;
        }
    }
}
