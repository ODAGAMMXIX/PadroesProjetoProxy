// Define a interface Subject que declara o método request()
public interface Subject {
    // Método que será implementado pelas classes RealSubject e ProxySubject
    void request();
}
// Implementa a interface Subject
public class RealSubject implements Subject {
    // Implementação do método request() definido na interface Subject
    @Override
    public void request() {
        // Lógica real que queremos proteger
        System.out.println("RealSubject: Handling request.");
    }
}
// Implementa a interface Subject e atua como um proxy para RealSubject
public class ProxySubject implements Subject {
    private RealSubject realSubject; // Instância do objeto real
    private String currentUser;      // Usuário atual

    // Construtor que inicializa o Proxy com o usuário atual
    public ProxySubject(String currentUser) {
        this.currentUser = currentUser;
        this.realSubject = new RealSubject(); // Cria uma instância do RealSubject
    }

    // Implementação do método request() da interface Subject
    @Override
    public void request() {
        // Verifica se o usuário tem permissão para acessar RealSubject
        if (checkAccess()) {
            // Se tiver permissão, delega a chamada para o RealSubject
            realSubject.request();
            // Registra o acesso
            logAccess();
        } else {
            // Se não tiver permissão, nega o acesso
            System.out.println("ProxySubject: Access denied.");
        }
    }

    // Método privado para verificar a permissão de acesso
    private boolean checkAccess() {
        // Simula a verificação de acesso: somente permite se o usuário for "admin"
        return "admin".equals(currentUser);
    }

    // Método privado para registrar o acesso
    private void logAccess() {
        System.out.println("ProxySubject: Logging access for user: " + currentUser);
    }
}

public class Main {
    public static void main(String[] args) {
        // Cria um ProxySubject para um usuário "admin"
        Subject adminProxy = new ProxySubject("admin");
        adminProxy.request();  // Output: RealSubject: Handling request. | ProxySubject: Logging access for user: admin

        // Cria um ProxySubject para um usuário "guest"
        Subject guestProxy = new ProxySubject("guest");
        guestProxy.request();  // Output: ProxySubject: Access denied.
    }
}
