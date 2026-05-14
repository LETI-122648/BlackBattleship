# BlackBattleship

## Elementos do Grupo

- Francesco Trematerra - 122640
- Tiago Lopes - 122648

---

# Scrum Product Backlog

## User Stories

1. Como jogador, quero desligar o som do jogo para jogar sem áudio quando desejar.

2. Como jogador, quero partilhar um link de convite para iniciar uma partida privada.

---

# Testes Automatizados

## DisableSoundTest

Este teste verifica se o jogador consegue abrir as definições do jogo e desligar o som com sucesso.

### Passos testados

1. Aceder ao website do Battleship
2. Aceitar cookies
3. Abrir o menu de definições
4. Desligar o som
5. Verificar que o estado do botão mudou corretamente

---

## CopyInviteLinkTest

Este teste verifica se o jogador consegue criar uma sala privada e copiar o link de convite.

### Passos testados

1. Aceder ao website do Battleship
2. Aceitar cookies
3. Carregar em “Play with a friend”
4. Inserir o nickname `"tester"`
5. Carregar em “Continue”
6. Entrar na sala privada
7. Copiar o link de convite
8. Verificar a mensagem `"Copied to clipboard"`