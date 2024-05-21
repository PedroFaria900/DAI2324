package tub.aplicattion;

public class ErrorController {

    // Método para lidar com exceções de login inválido
    public static void handleLoginInvalido() {
        System.out.println("Credenciais inválidas. Por favor, tente novamente.");
    }

    // Método para lidar com exceções de falha na inicialização do banco de dados
    public static void handleDatabaseInitializationError(Exception e) {
        System.out.println("Erro ao inicializar o banco de dados:");
        e.printStackTrace();
        System.out.println("A aplicação não pode continuar. Por favor, verifique a configuração do banco de dados e tente novamente.");
        System.exit(1); // Encerrar a aplicação após o erro de inicialização do banco de dados
    }

    // Outros métodos para lidar com diferentes tipos de exceções podem ser adicionados conforme necessário

}