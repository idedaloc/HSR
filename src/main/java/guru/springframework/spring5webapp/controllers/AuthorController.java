package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

//    @GetMapping("/authors")
//    public String getAuthors(Model model){
//        model.addAttribute("authors", authorRepository.findAll());
//        return "authors";
//    }
    @GetMapping("/authors")
    public ModelAndView getAuthors(){
        ModelAndView mav = new ModelAndView("authors");
        mav.addObject("authors", authorRepository.findAll());
        return mav;
   }

}
