package br.com.alura.api.languages;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanguageController {

    @Autowired
    private LanguageRepository repository;

    @GetMapping("/languages")
    public List<Language> getLanguages(){

        List<Language> languageList = repository.findAll();
        return languageList;
    }

    @PostMapping( "/languages")
    public Language addLanguage(@RequestBody Language language){
        Language savedLanguage = repository.save(language);
        return savedLanguage;
    }

}

//    private List<Language> languageList = List.of(
//            new Language("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1),
//            new Language("Python", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/python/python_256x256.png", 2),
//            new Language("JavaScript", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/javascript/javascript_256x256.png", 3),
//            new Language("TypeScript", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/typescript/typescript_256x256.png", 4),
//            new Language("Html", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/html/html_256x256.png", 5),
//            new Language("CSS", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/css/css_256x256.png", 6)
//    );