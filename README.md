# Auditeste-Mobile-Automation
Testes automatizados de aceitação para o site da Auditeste (acesso mobile Android).

## Ferramentas utilizadas

1. Java (OpenJDK 11)
2. Maven
3. Cucumber
4. Selenium
5. JUnit
6. PageFactory
7. ChromeDriver
8. IntelliJ IDE
9. Linux Ubuntu 20.04
10. Appium
11. Android Emulator

## Execução

Após clonar o projeto, é possível executá-lo utilizando o Maven. Para isso, é necessário possuir o Java, o Maven, o Appium e o Google Chrome instalados em seu ambiente. Dependendo da atualização do seu browser, pode ser necessário possuir uma versão diferente do chromedriver configurando o Appium para utilizar a versão correta. Foi utilizado um emulador Android para executar os testes. É necessário alterar os parâmetros de configuração do Appium para utilizar dispositivos diferentes. Os testes são executados ao rodar o comando "mvn clean install" pelo terminal. Após executar os testes, é possível visualizar um relatório de resultados em formato HTML gerado em `target/report.html`.

## Observações

* O padrão PageFactory não foi utilizado por completo pois os testes apenas acessam menus da plataforma, portanto implementar inteiramente o padrão geraria complexidades desnecessárias.
* Os arquivos do IDE IntelliJ foram commitados para caso exista necessidade de uso dos mesmos.