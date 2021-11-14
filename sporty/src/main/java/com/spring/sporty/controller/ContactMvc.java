package com.spring.sporty.controller;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.model.Contact;
import com.spring.sporty.model.Searchcat;
import com.spring.sporty.model.Searchcon;
import com.spring.sporty.service.CategorieService;
import com.spring.sporty.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ContactMvc {
    @Autowired
    ContactService agent;
    private Contact c;
    private BindingResult result;

    @RequestMapping(value = "/contacts/add", method = RequestMethod.GET)
    public ModelAndView form_add(){
        ModelAndView mv = new ModelAndView();
        Contact contact = new Contact();
        mv.addObject("Formcontact", contact);
        mv.setViewName("contact");
        return mv;

    }
    @RequestMapping(value = "/contacts/save", method = RequestMethod.POST)
    public ModelAndView save(@Validated @ModelAttribute("Formcontact") Contact c, BindingResult result) {
        if(result.hasErrors()){
            return(new ModelAndView("contact"))  ;
        }else{
            agent.add_contact(c);
            return new ModelAndView("redirect:/home");
        }
    }
    @RequestMapping(value = "/contacts/list", method = RequestMethod.GET)
    public ModelAndView display_contacts() {
        ModelAndView mv = new ModelAndView();
        List<Contact> contacts = agent.findAll();
        mv.addObject("contacts", contacts);
        mv.setViewName("contacts");
        return mv;

    }

    @RequestMapping(value = "/contacts/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete_contacts(@PathVariable("id") long id) {
        agent.delete_contact(id);
        return new ModelAndView("redirect:/contacts/list");
    }
    @RequestMapping(value = "/contacts/update/{id}", method = RequestMethod.GET)
    public ModelAndView display_form_update(@PathVariable("id") long id) {

        Contact contact = agent.find_contact(id).get();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editcontact");
        mv.addObject("Formcontact", contact);
        return mv;
    }

    @RequestMapping(value = "/contacts/recherche", method =RequestMethod.GET )
    public  ModelAndView display_search(){
        ModelAndView mv = new ModelAndView();
        Searchcon searchcon = new Searchcon();
        mv.addObject("searchcon",searchcon);
        mv.setViewName("searchcon");
        return mv;
    }
    @RequestMapping(value = "/contacts/avancee", method =RequestMethod.GET )
    public  ModelAndView display_advanced_search(){
        ModelAndView mv = new ModelAndView();
        Searchcon searchcon = new Searchcon();
        mv.addObject("searchcon",searchcon);
        mv.setViewName("advancedsearchcon");
        return mv;
    }
    @RequestMapping(value  ="/contacts/advancedsearch", method=RequestMethod.POST)
    public ModelAndView advanced_searchcon(@ModelAttribute("searchcon") Searchcon searchcon){
        List<Contact> res = agent.advanced_searchcon(searchcon.getPseudo());
        searchcon.setContacts(res);
        ModelAndView mv = new ModelAndView();
        mv.addObject("searchcon",searchcon);
        mv.setViewName("advancedsearchcon");
        return mv;
    }
}
