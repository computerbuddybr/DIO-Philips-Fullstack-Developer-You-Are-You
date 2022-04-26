# Bookstore Backend

API bem simples criada para oferecer uma busca dos livros para o projeto de Front-end de um e-Commerce em Angular. Feita
em Java e Spring Boot com a DB em MySQL. Sou iniciante ainda tanto em Java quanto Spring Boot (faz só dois dias que
comecei a ver o Spring!), então está bem simples.

**Para quem quiser usar no seu próprio desenvolvimento ao rodar as URLS get ficaram:**

Lista com todos os livros:
http://localhost:8080/

Cada livro é um objeto com:

```
id : int;
author : int;
title : string;
description: string;
price : double;
```

Lista com todos os Autores:
http://localhost:8080/authors

Cada autor é um objeto com:
```
id : int;
name : string;
```

Retornar um único livro
http://localhost:8080/books/id

Filtrar livros por preço:
http://localhost:8080/books/precoMin/precoMax

Filtrar por autor:
http://localhost:8080/authors/author_code

**Meus inserts para popular as tabelas para criar dados estão no arquivo [sqlUsado.sql](../sqlUsado.sql)**





