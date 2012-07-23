comente-sobre (saitodisse)
===============
Java, hibernate, vRaptor and HSQLDB

Criei o repositório exportanto do Eclipse para uma pasta. Portanto, deve funcionar bem importando pelo Eclipse.
Geralmente, após a primeira importação, é preciso informar onde está o jNunit.
Indique a pasta abaixo:

    /comente-sobre-vraptor/build-lib/tests/junit-4.9.jar


Estrutura do domínio:

    Discussão
     pergunta (Mensagem)
     respostas (List<Mensagem>)
    
    Mensagem
     titulo
     texto
     usuario
    
    Usuario
     nome


Como funciona?


    INDEX: O usuário tenta acessar o site e este verifica que ele não está logado
    USUARIO/LOGON: O usuário escolhe um nome de usuário
    USUARIO/LOGON (post): o sistema grava o novo usuário e loga com ele. Redireciona para o index inicial
    INDEX: 1) Ele pode escolher por fazer uma discussão nova
      INDEX: o usuário preenche o titulo e o texto.
      obs: nessa parte optei por disparar excessões da classe mensagem
    INDEX: 2) Ele pode escolher por comentar uma discussão já iniciada


Rotas:


    "/" -> opção de iniciar discussão ou continuar. vai para o usuario/logon caso não esteja logado
    "/{titulo}" -> busca no banco pela discussão e renderiza a view de Discussao/detalhe
    "/usuario/logon" -> permite se logar no sistema.
    "/usuario/logout" -> efetua o logout e redireciona para o root
    