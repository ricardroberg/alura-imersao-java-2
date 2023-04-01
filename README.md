# IMERSÂO JAVA ALURA 2ED

# Alura Stickers

## AULA 01

- configurado arquivo .ENV com chave API e adicionado ao .gitignore
- Adicionados 3 novos caminhos para resultados (totalizando 4)

```java
final String MOST_POPULAR_TV="MostPopularTVs/";
final String MOST_POPULAR_MOVIE="MostPopularMovies/";
final String TOP_250_TV="Top250TVs/";
final String TOP_250_MOVIE="Top250Movies/";
```

Que são adicionados a url final:

```java
String url="https://imdb-api.com/pt/API/"+SearchField+api_key;
```

```bash
Titulo: The Shawshank Redemption
Classificacao: 9.2
⭐⭐⭐⭐⭐⭐⭐⭐⭐

Titulo: The Godfather
Classificacao: 9.2
⭐⭐⭐⭐⭐⭐⭐⭐⭐
```

<br>

---

<br>

## AULA 02

- Criada classe para conversão das imagens e adição de texto. Instanciando uma classe e fazendo o forEach para cada imagem:

```java
StickersGenerator newSticker = new StickersGenerator();
```

- Menu funcionando:

```bash
====================================================
1 - Exibir lista Top 250 Filmes
2 - Exibir lista Top 250 SÃ©eies TV
3 - Filmes mais populares
4 - Series TV mais populares
====================================================
```

- Utilizando os JSON providos pela Alura

```java
final String MOST_POPULAR_TV = "MostPopularTVs.json";
final String MOST_POPULAR_MOVIE = "MostPopularMovies.json";
final String TOP_250_TV = "TopTVs.json";
final String TOP_250_MOVIE = "TopMovies.json";
String mainURL = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/";
```

<br>

---

<br>

## AULA 03

- Abstração dos componentes
- Criação de um extrator para API da Nasa e outro para IMDB
- Criada interface em comum com os 2 extratores.

```java
public interface ContentExtractor {
    List<Content> contentExtrator(String json);
}
```

e sua implementação nas classes:

```java
public class NasaContentExtractor implements ContentExtractor {...
// e
public class IMDBContentExtractor implements ContentExtractor {
```

<br>

---

<br>

## AULA 04

- Criado cluster MongoDB Cloud para armazenar os dados
- Utilizado Spring para fazer as requisições no DB e gerar os EndPoints
- Classe LanguageController implementa CRUD básico.

```java
 @GetMapping("/languages")
    public List<Language> getAllLanguages(){
        List<Language> languageList = repository.findAll();
        return languageList;
    }

    @GetMapping(value="/languages/{id}")
    public Language getLanguageById(@PathVariable String id){
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping( "/languages")
    public Language addLanguage(@RequestBody Language language){
        Language savedLanguage = repository.save(language);
        return savedLanguage;
    }

    @PutMapping(value="/languages/{id}")
    public Language updateLanguageById(@PathVariable String id, @RequestBody Language language){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        language.setId(id);
        Language savedLanguage = repository.save(language);
        return savedLanguage;
    }

    @DeleteMapping("/languages/{id}")
    public void removeLanguageById(@PathVariable String id){
       repository.deleteById(id);
    }
```

- Dados acessados com sucesso em /languages:

```json
{
  "id": "6426060c0b79e41987a2ac74",
  "title": "Java",
  "image": "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png",
  "rank": 1
},
{
  "id": "6426060c0b79e41987a2ac75",
  "title": "Python",
  "image": "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/python/python_256x256.png",
  "rank": 2
},
...
```
