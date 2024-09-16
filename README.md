
### README.md

```markdown
# API Registry

## Visão Geral

A API Registry é uma aplicação desenvolvida em Java com Spring Boot, destinada a gerenciar registros de cartórios, atribuições e situações. A aplicação oferece funcionalidades básicas de CRUD (Criar, Ler, Atualizar e Deletar) e é configurada para rodar na porta 9564. Utiliza Flyway para gerenciamento de migrações e OpenJDK 11 como ambiente de execução.

## Funcionalidades

- **Cadastro de Situações**: Permite a gestão de situações com IDs e nomes específicos.
- **Cadastro de Atribuições**: Permite a gestão de atribuições com IDs, nomes e status.
- **Cadastro de Cartórios**: Permite a gestão de cartórios, incluindo validação referencial e atribuições obrigatórias.
- **Validações**: Implementa validações para garantir a unicidade de nomes e IDs, e integridade referencial.

## Estrutura de Pastas

```plaintext
api-registry/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── apiregistry/
│   │   │               ├── ApiRegistryApplication.java
│   │   │               ├── controller/
│   │   │               │   ├── AtribuicaoController.java
│   │   │               │   ├── CartorioController.java
│   │   │               │   └── SituacaoController.java
│   │   │               ├── exception/
│   │   │               │   └── CustomException.java
│   │   │               ├── model/
│   │   │               │   ├── Atribuicao.java
│   │   │               │   ├── Cartorio.java
│   │   │               │   └── Situacao.java
│   │   │               ├── repository/
│   │   │               │   ├── AtribuicaoRepository.java
│   │   │               │   ├── CartorioRepository.java
│   │   │               │   └── SituacaoRepository.java
│   │   │               ├── service/
│   │   │               │   ├── AtribuicaoService.java
│   │   │               │   ├── CartorioService.java
│   │   │               │   └── SituacaoService.java
│   │   │               └── util/
│   │   │                   └── ValidationUtils.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/
│   │           └── migration/
│   │               ├── V1__Create_situacoes.sql
│   │               ├── V2__Create_atribuicoes.sql
│   │               └── V3__Create_cartorios.sql
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── apiregistry/
│                       └── ApiRegistryApplicationTests.java
```

## Configuração

- **Porta**: 9564
- **OpenJDK**: 11
- **Dependências**:
    - Spring Boot
    - Flyway
    - Lombok (opcional)
    - JPA/Hibernate

### Arquivo `application.properties`

Configure as propriedades da aplicação no arquivo `src/main/resources/application.properties`:

```properties
server.port=9564
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.flyway.enabled=true
```

## Funcionalidades

### Cadastro de Situações

- **Campos**:
    - ID: String (até 20 caracteres)
    - Nome: String (até 50 caracteres)

- **Carga Inicial**:
    - Inclui situações "Ativo" e "Bloqueado" com IDs "SIT_ATIVO" e "SIT_BLOQUEADO", respectivamente.

### Cadastro de Atribuições

- **Campos**:
    - ID: String (até 20 caracteres)
    - Nome: String (até 50 caracteres)
    - Situação: Boolean (padrão TRUE)

### Cadastro de Cartórios

- **Campos**:
    - ID: Integer (maiores que zero)
    - Nome: String (até 150 caracteres)
    - Observação: String (até 250 caracteres, opcional)
    - Situação do Cartório: String (obrigatório)
    - Atribuições: Lista de atribuições (pelo menos uma obrigatória)

## Execução

Para executar a aplicação, use o comando:

```bash
./mvnw spring-boot:run
```

Certifique-se de ter o Maven e o OpenJDK 11 instalados.

## Contribuição

Para contribuir com este projeto:

1. Faça um fork do repositório.
2. Crie uma branch para suas alterações (`git checkout -b feature/nome-da-sua-feature`).
3. Faça commit das suas alterações (`git commit -am 'Adiciona nova feature'`).
4. Envie a branch para o repositório remoto (`git push origin feature/nome-da-sua-feature`).
5. Abra um pull request.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

Para dúvidas ou sugestões, entre em contato com [email@dominio.com](mailto:email@dominio.com).
```