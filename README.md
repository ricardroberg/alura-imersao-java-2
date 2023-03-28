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

![image](https://user-images.githubusercontent.com/47563670/228097059-5dba5cdd-7960-4d72-9db8-43c147b8e3d3.png)

<br>

---
<br>

### Aula 02

- Criada classe para conversão das imagens e adição de texto. Instanciando uma classe e fazendo o forEach para cada imagem:
```java
StickersGenerator newSticker = new StickersGenerator();
```
- Menu funcionando:

![image](https://user-images.githubusercontent.com/47563670/228097302-dea41b92-dc4b-4817-8626-d53144f1d950.png)

- Utilizando os JSON providos pela Alura

```java
final String MOST_POPULAR_TV = "MostPopularTVs.json";
final String MOST_POPULAR_MOVIE = "MostPopularMovies.json";
final String TOP_250_TV = "TopTVs.json";
final String TOP_250_MOVIE = "TopMovies.json";
String mainURL = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/";
```
