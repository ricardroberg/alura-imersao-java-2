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

- Falta resolver desafios ...
