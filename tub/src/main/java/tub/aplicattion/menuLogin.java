package tub.aplicattion;

import java.util.Scanner;

public class menuLogin {

    // Método para exibir o menu de login
    public void exibirMenuLogin() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TUB ===");
        System.out.print("Utilizador: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Verificar se o login é válido
        if (validarLogin(username, password)) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + username + "!");
            // Aqui você pode chamar o método para continuar com o fluxo do programa após o login bem-sucedido
        } else {
            handleLoginInvalido(); // Chamando o método da própria classe
            exibirMenuLogin(); // Se as credenciais forem inválidas, exiba o menu de login novamente
        }
    }

    // Método para validar o login (apenas um exemplo básico)
    private boolean validarLogin(String username, String password) {
        // Verificar se o nome de usuário e a senha correspondem a um usuário válido
        // Aqui você pode adicionar lógica para verificar em um banco de dados, arquivo, etc.
        // Por simplicidade, este exemplo aceitará qualquer nome de usuário e senha "password"
        return username.equals("admin") && password.equals("password");
    }

    // Método para lidar com exceções de login inválido
    private static void handleLoginInvalido() {
        System.out.println("Credenciais inválidas. Por favor, tente novamente.");
    }
}
