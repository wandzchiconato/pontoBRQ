Feature: Acessar o Portal da BRQ
@Search
 Scenario Outline:  Bater o ponto
    Given User abre o portal da BRQ
   # And Digita o <login> e a <senha>
    And Digita o <login> e a <senha>
    Then User clica no icone do relogio
    Then clica no botao registrar
    Then user aloca as <horas> em aberto no <projeto>
    Examples:
    | login                 | senha      | horas  |      projeto      |
    | "wandersonchiconato" | "$Adm1nttd" | "00:00"| "BRD2020/0142-01" |