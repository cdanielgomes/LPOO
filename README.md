# frut game

João Carlos Parada Alves up201605236 up201605236@fe.up.pt
Carlos Daniel Coelho Ferreira Gomes up201603404 up201603404@fe.up.pt

## Setup 
Instalar a APK

## UML

![alt tag](https://github.com/DanielGanso/LPOO1718_T3_G10/blob/finalRealese/FruitGame/-UML-/UMLdiagram.png "UML")

## Design Patterns


**Singleton** – O Sigleton foi utilizado com o intuito aceder multiplas vezes a uma mesma classe, sendo esta instanciada apenas uma vez. Isto permitiu que as classes GameModel, GameController apenas fossem acedidas pela função getInstance(), permitindo assim um maior controlo sobre a instância.


**Factory Method** – O Factory Method é implementado para poder dar diferentes Sprites a uma mesma classe. Desta forma, define-se um padrão em Entity View que irá permitir tratar as diversas sprites, sendo estas apenas especificadas 

**MVC** - Model-View-Controller é utilizado para separar a parte gráfica da lógica de jogo e facilitar a interação entre os diferentes modulos.



## Uma Análise Global
Quando começamos a desenvolver o projeto o nosso conhecimento de como tinhamos de desenvolver o jogo era pouquíssimo. Consequentemente não conseguimos desenvolver testes devido à utilização constante de funçoes Gdx.graphics.getWidth e Gdx.graphics.getHeight no projeto.
Apesar do imenso tempo dado para fazer este projeto final, gerimos muito mal o nosso tempo e acabamos por ficar com pouquíssimo tempo para desenvolver o jogo. A nível de desenvolvimento a maior dificuldade que enfrentamos foi no desenvolvimento do cutter pois este tinha de fazer uma linha perfeita que seguida o input do utilizador no ecrã e uma sprite para demonstrar esta mesma linha. A falta de atenção também esteve presente na elaboração do projeto, pois foram perdidas muitas horas em erros que, no final se descobria, que era o path do ficheiro que estava incorreto.
Outra enorme dificuldade que tivemos foi na conversão de pixeis para unidades usadas no mundo. Perdemos alguns dias neste parâmetro pois a não conversão estas unidades provocava ridicularidade no jogo.
Apesar da não existência de testes pela razão que já foi explicada, utilizamos 2 pontos dos objetivos secundários: a física e Android.



## Manual do Utilizador
![alt tag](https://github.com/DanielGanso/LPOO1718_T3_G10/blob/finalRealese/menu.png "main menu")

No menu de utilizador tem o botão NEW GAME , PREFERENCES e EXIT. O exit serve, tal como ele diz, para sair do jogo. O NEWGAME inicia um novo jogo. O Preferences dá para ativar ou desligar a musica de fundo e o efeito sonoro do cutter

![alt tag](https://github.com/DanielGanso/LPOO1718_T3_G10/blob/finalRealese/foto1.png "jogo")

O objetivo do jogo consiste em cortar o maior numero possivel de frutas. Ao cortar a fruta o score é aumentado. Depois existem bombas que aparecem com a mesma probabilidade que qualquer tipo de fruta. Caso a bomba seja cortada o jogador perde automáticamente. Por último existe uma fruta especial que quando é cortada o jogador tem 3 segundos para abanar o telémovel o mais rápido possível e quanto mais abanar mais pontos o jogador conseguirá.

![alt tag](https://github.com/DanielGanso/LPOO1718_T3_G10/blob/finalRealese/lose.png "main menu")

Quando o jogador perde o score é apresentado no ecrã e tem a opção de voltar para o menu principal ou sair do jogo.
