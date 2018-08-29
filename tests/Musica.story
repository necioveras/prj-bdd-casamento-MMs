Historia sobre os convidados do casamento da Mayara com o Moises

Narrative:
In order to organizar uma festa de casamento topzera
As a noiva
I want to gerenciar minha trilha sonora
					 
Scenario: Escolher banda de música
Given uma lista de <numero> opcoes de bandas
When for conhecida as opcoes. Exemplo: <bandas>
Then verificar se foi escolhida <escolha> banda(s) automaticamente

Examples:
|numero|bandas|escolha|
|2|safadao,dj pen drive|safadao|
|5|pen1,pen2,pen3,pen4,pen5|pen4|
|3|roupa nova,klb,katinguele|roupa nova|