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
    public ResponseEntity<Language> getLanguageById(int id){
        Language language=languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language with id "+id+" does not exit."));
        return ResponseEntity.ok(language);
    }

    //update language
    public ResponseEntity<Language> updateFilms(int id, Language languageInfo){
        Language language=languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language with id:"+id+" does not exist."));

        language.setName(languageInfo.getName());
        language.setLastUpdate(languageInfo.getLastUpdate());

        languageRepo.save(language);
        return ResponseEntity.ok(language);
    }

    // delete language
    public  ResponseEntity<HttpStatus> deleteFilms(int id){
        Language film=languageRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Language with id:" + id+" does not exist."));
        languageRepo.delete(film);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
