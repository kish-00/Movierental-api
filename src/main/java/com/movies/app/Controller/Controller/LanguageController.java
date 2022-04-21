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
    @PostMapping("/addLanguage")
    public Language handleAddLanguage(@RequestBody Language language){
        return languageService.addLanguage(language);
    }

//add multiple languages

    //gets all languages
    @GetMapping("/languages")
    public List<Language> handleGetAllLanguages(){
        return languageService.getAllLanguage();
    }

    //gets a language by its id
    @GetMapping("/languageId/{id}")
    public Language handleGetLanguageById(@PathVariable int id){
        return languageService.getLanguageById(id);
    }

    //get language by name of language
    @GetMapping("/languageName/{name}")
    public Language handleGetLanguageByName(String name){
        return languageService.getLanguageByName(name);
    }
    //update language Rest API
    @PutMapping("/updateLanguage/{id}")
    public Language handleUpdateLanguage(@PathVariable int id, @RequestBody Language languageInfo){
        return languageService.updateLanguage(id, languageInfo);
    }

    // delete language from rest API
    @DeleteMapping("/deleteLanguage/{id}")
    public String handleDeleteLanguage(@PathVariable int id){
        return languageService.deleteLanguage(id);
    }
}
