Historia sobre os convidados do casamento da Mayara com o Moises

Narrative:
In order to organizar uma festa de casamento topzera
As a noiva
I want to gerenciar minha lista de convidados
					 
Scenario: Adicionar convidados em uma Lista de Convidados
Given uma lista de 2 convidados
When  a lista for conhecida. Exemplos: Arruda, Joe, Dayane
Then  Arruda, Joe,  Dayane devem fazer parte da lista

Scenario: Verificar se alguém está  ausente na lista de Convidados 
Given uma lista de 3 convidados
When  a lista for conhecida. Exemplos: Arruda, Joe, Dayane
Then  confirmar que Arruda, Joe, Dayane estão na lista and Jorge está ausente na lista
