<h3 align="center">spring-jooq</h3>
<p align="center">Small test repo demonstrating the use of jOOQ in conjunction with Spring Boot 3</p>

## Project structure

```
├───app (main application)
└───packages
    ├───contracts (DTOs)
    ├───data (jpa entities and repository interfaces)
    ├───jooq (jOOQ generated code and repository implementations)
    └───migrations (liquibase migrations)
```

The project is divided into a main application and a set of packages. 

It seems jOOQ requires a dependency to a package/module which contains the JPA entities when using a `JPADatabase` as a source of truth for generating code. 

This is why the packages are split the way they are and the `data` package is a dependency of the `jooq` package.

## Migrations

The migrations are separated from the main application to allow for creating a init container which runs the migrations before the main application starts.

They are also are included as a development dependency in the main application to ease the development process. 

## License 

Distributed under the MIT License. See `LICENSE` for more information.

