package ldap_contacts.controller;

import ldap_contacts.Application;
import ldap_contacts.Person;
import ldap_contacts.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Book {

    private static Logger log = LoggerFactory.getLogger(Application.class);


    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/szukaj")
    public String book(@RequestParam("s") String s, Model model){
        List<Person> names = personRepository.getPersonByString(s);
        log.info("Znaleziono: " + names);
        model.addAttribute("persons", names);
        return "book";
    }

    @RequestMapping("/")
    public String book(){
        personRepository.getPersonByString("");
        return "book";
    }


}
