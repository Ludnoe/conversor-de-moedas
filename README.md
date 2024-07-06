# Conversor de Moedas ![currency](https://img.icons8.com/fluency/48/money.png)
![thumbnail-Formação Java](https://github.com/Ludnoe/conversor-de-moedas/assets/69700583/040e666e-9247-4ffd-a1af-7e45e2848d4d)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![License](https://img.shields.io/badge/license-MIT-green)

## Índice

- [Descrição do Projeto](#descrição-do-projeto)
- [Status do Projeto](#status-do-projeto)
- [Funcionalidades e Demonstração da Aplicação](#funcionalidades-e-demonstração-da-aplicação)
- [Como os Usuários Podem Utilizá-lo](#como-os-usuários-podem-utilizá-lo)
- [Acesso ao Projeto](#acesso-ao-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Licença](#licença)

## Descrição do Projeto

Este projeto é um **Conversor de Moedas** desenvolvido em Java. Ele permite aos usuários converter valores entre diferentes moedas utilizando taxas de câmbio atualizadas. O programa oferece uma interface interativa para selecionar moedas, inserir valores e exibir os resultados com formatação adequada, incluindo símbolos de moeda.

## Status do Projeto

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)

O projeto está em fase de desenvolvimento. As principais funcionalidades estão implementadas, mas melhorias contínuas e novas funcionalidades podem ser adicionadas.

## Funcionalidades e Demonstração da Aplicação

- **Conversão de Moedas:** Converte valores entre moedas com base nas taxas de câmbio atuais.
- **Lista de Moedas Mais Usadas:** Apresenta uma lista de moedas mais comuns, além de permitir a inserção de outros códigos de moeda.
- **Exibição de Resultados:** Mostra o valor convertido com o símbolo da moeda e formatado com duas casas decimais.
- **Histórico de Conversões:** Mantém um registro das conversões realizadas durante a sessão.
- **Interface Intuitiva:** Oferece um menu simples e fácil de usar.

### Demonstração

```plaintext
*******************************************
Menu:
1. Converter moedas
2. Ver histórico de conversões
3. Sair
*******************************************
Selecione o código da moeda de origem ou digite 'outra' para inserir manualmente:
1. USD - Dólar Americano
2. EUR - Euro
3. JPY - Iene Japonês
...
Digite o valor a ser convertido:
100
Selecione o código da moeda de destino ou digite 'outra' para inserir manualmente:
1. USD - Dólar Americano
2. EUR - Euro
3. JPY - Iene Japonês
...
Valor convertido: €91.34
Deseja continuar? (S/N)
```

### Como os Usuários Podem Utilizá-lo
- 1 Pré-requisitos:
    - Java Development Kit (JDK) 8 ou superior.
- 2 Passos para Uso:

    - Clone o repositório
    - Navegue até o diretório do projeto: cd conversor-de-moedas
    - Compile os arquivos Java: javac Principal.java
Execute o programa: java Principal
- 3 Interação:
  - Siga as instruções no menu para converter moedas ou visualizar o histórico de conversões.
### Acesso ao Projeto
- O projeto pode ser acessado através do repositório no GitHub:
  Repositório do Conversor de Moedas
### Tecnologias Utilizadas
- Java: Linguagem principal para desenvolvimento do projeto.
- API de Taxas de Câmbio: ExchangeRate-API para obter taxas de câmbio atualizadas.
- Bibliotecas:
- Gson para parsing de JSON.
### Licença
- Este projeto está licenciado sob a Licença MIT - consulte o arquivo LICENSE para mais detalhes.


### Observação
Este README fornece uma visão completa do projeto, cobrindo todos os aspectos importantes para usuários e desenvolvedores. Se precisar de mais alterações ou seções adicionais, sinta-se à vontade para contribuir!
