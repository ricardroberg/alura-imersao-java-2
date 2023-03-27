# Imersão Java Alura 2ed

## Alura Stickers

### Aula 01

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