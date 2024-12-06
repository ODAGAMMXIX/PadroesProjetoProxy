# PadroesProjetoProxy
Studying Proxy (powered by Copilot);
Language: Portuguese
Proxy. Padrão de Projeto ESTRUTURAL. fornecer um substituto ou representante para outro objeto.

O padrão de projeto Proxy é utilizado para fornecer um substituto ou representante para outro objeto, a fim de controlar o acesso a ele. No exemplo acima, criamos um sistema onde um objeto RealSubject representa um recurso sensível e um ProxySubject controla o acesso a esse recurso com base nas permissões de usuário.

![image](https://github.com/user-attachments/assets/04e813a3-2add-47e8-a3f8-1bfe0f25c342)

![image](https://github.com/user-attachments/assets/8db0dda6-3e26-434e-b243-b28ecc21ce73)

![image](https://github.com/user-attachments/assets/46298589-c8cb-4d58-adbf-dc9484404acd)

![image](https://github.com/user-attachments/assets/25bbad0c-dfc5-4d86-ab18-b4ec0e13bf24)


Passo a Passo (Debug) com Explicações:
Interface Subject:

Define a interface Subject com o método request(), que será implementado pelas classes RealSubject e ProxySubject.

Classe RealSubject:

Implementa a interface Subject e contém a lógica real que queremos proteger. O método request() imprime uma mensagem indicando que o RealSubject está lidando com a solicitação.

Classe ProxySubject:

Também implementa a interface Subject, mas controla o acesso ao RealSubject.

O construtor ProxySubject(String currentUser) inicializa a instância do RealSubject e armazena o usuário atual.

O método request() verifica se o usuário atual tem permissão para acessar o RealSubject usando o método checkAccess().

Se a permissão for concedida, a chamada é delegada para o RealSubject e o acesso é registrado com o método logAccess().

Se a permissão for negada, o acesso é negado e uma mensagem é exibida.

Uso do Proxy no Sistema:

No método main() da classe Main, criamos duas instâncias de ProxySubject, uma para um usuário "admin" e outra para um usuário "guest".

Quando adminProxy.request() é chamado, a permissão é verificada, o acesso é concedido e a mensagem de RealSubject é exibida, seguida pelo log de acesso.

Quando guestProxy.request() é chamado, a permissão é negada e uma mensagem indicando "Acesso negado" é exibida.

Este exemplo mostra como o padrão Proxy pode ser usado para controlar o acesso a um recurso sensível, implementando verificações de permissão e registrando acessos, tornando o sistema mais seguro e auditável.
