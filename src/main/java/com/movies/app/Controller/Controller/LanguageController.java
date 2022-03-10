package com.movies.app.Controller.Controller;

import com.movies.app.Controller.Model.Language;
import com.movies.app.Controller.Service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class LanguageController {

    private final LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    //adds a language
    @PostMapping(value = "/addLanguage", consumes = "application/JSON")
    public Language handleAddLanguage(@RequestBody Language language){
        return languageService.addLanguage(language);
    }

//add multiple languages

    //gets all languages
    @GetMapping(value = "/languages", produces = "application/JSON")
    public List<Language> handleGetAllLanguages(){
        return languageService.getAllLanguage();
    }

    //gets a language by its id
    @GetMapping(value = "/language/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Language handleGetLanguageById(@PathVariable int id){
        return languageService.getLanguageById(id);
    }

    //update language Rest API
    @PutMapping(value = "/updateLanguage/{id}", consumes = "application/JSON", produces = "application/JSON")
    public Language handleUpdateLanguage(int id, Language languageInfo){
        return languageService.updateLanguage(id, languageInfo);
    }

    // delete language from rest API
    @DeleteMapping(value = "/deleteLanguage/{id}")
    public String handleDeleteLanguage(@PathVariable int id){
        return languageService.deleteLanguage(id);
    }
}
