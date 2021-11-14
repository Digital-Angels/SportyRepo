package com.spring.sporty.controller;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.model.Commande;
import com.spring.sporty.model.Searchcat;
import com.spring.sporty.model.Searchcom;
import com.spring.sporty.service.CategorieService;
import com.spring.sporty.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
public class CommandeMvc {
    @Autowired
    CommandeService agent;
    private Commande c;
    private BindingResult result;

    @RequestMapping(value = "/commandes/add", method = RequestMethod.GET)
    public ModelAndView form_add(){
        ModelAndView mv = new ModelAndView();
        Commande commande = new Commande();
        mv.addObject("Formcommande", commande);
        mv.setViewName("commande");
        return mv;

    }
    @RequestMapping(value = "/commandes/save", method = RequestMethod.POST)
    public ModelAndView save(@Validated @ModelAttribute("Formcommande") Commande c, BindingResult result) {
//        if(result.hasErrors()){
//            return(new ModelAndView("commande"))  ;
//        }else{
            agent.add_commande(c);
            return new ModelAndView("redirect:/");
//        }
    }
    @RequestMapping(value = "/commandes/list", method = RequestMethod.GET)
    public ModelAndView display_commandes() {
        ModelAndView mv = new ModelAndView();
        List<Commande> commandes = agent.findAll();
        mv.addObject("commandes", commandes);
        mv.setViewName("commandes");
        return mv;

    }

    @RequestMapping(value = "/commandes/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete_commande(@PathVariable("id") long id) {
        agent.delete_commande(id);
        return new ModelAndView("redirect:/commandes/list");
    }
    @RequestMapping(value = "/commandes/recherche", method =RequestMethod.GET )
    public  ModelAndView display_search(){
        ModelAndView mv = new ModelAndView();
        Searchcom searchcom = new Searchcom();
        mv.addObject("searchcom",searchcom);
        mv.setViewName("searchcom");
        return mv;
    }
    @RequestMapping(value = "/commandes/avancee", method =RequestMethod.GET )
    public  ModelAndView display_advanced_search(){
        ModelAndView mv = new ModelAndView();
        Searchcom searchcom = new Searchcom();
        mv.addObject("searchcom",searchcom);
        mv.setViewName("advancedsearchcom");
        return mv;
    }
    @RequestMapping(value  ="/commandes/advancedsearch", method=RequestMethod.POST)
    public ModelAndView advanced_searchcat(@ModelAttribute("searchcom") Searchcom searchcom){
        List<Commande> res = agent.advanced_searchcom(searchcom.getPseudo());
        searchcom.setCommandes(res);
        ModelAndView mv = new ModelAndView();
        mv.addObject("searchcom",searchcom);
        mv.setViewName("advancedsearchcom");
        return mv;
    }
}
