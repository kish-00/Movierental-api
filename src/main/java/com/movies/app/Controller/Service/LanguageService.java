package com.movies.app.Controller.Service;

import com.movies.app.Controller.Exception.ResourceNotFoundException;
import com.movies.app.Controller.Model.Language;
import com.movies.app.Controller.Repository.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {
    @Autowired
    private final LanguageRepo languageRepo;

    public LanguageService(LanguageRepo languageRepo) {
        this.languageRepo = languageRepo;
    }

    //creates an language
    public Language addLanguage(Language language){
        return languageRepo.save(language);
    }

    //create a list of languages

    //read a list of all the languages
    public List<Language> getAllLanguage(){
        return languageRepo.findAll();
    }

    //reads a language by its id
    public Language getLanguageById(int id){
        return languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language with id "+id+" does not exit."));
    }

    //update language
    public Language updateLanguage(int id, Language languageInfo){
        Language language=languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language with id:"+id+" does not exist."));

        language.setName(languageInfo.getName());
        language.setLastUpdate(languageInfo.getLastUpdate());

        return languageRepo.save(language);
    }

    // delete language
    public  String deleteLanguage(int id){
        Language film=languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language with id:" + id+" does not exist."));
        languageRepo.delete(film);
        return "Language id "+id+" has been deleted";
    }
}
