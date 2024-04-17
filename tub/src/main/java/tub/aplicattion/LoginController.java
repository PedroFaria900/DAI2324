package tub.aplicattion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String homePage() {
        return "1paginainicial"; // Retorna a página inicial
    }

    @GetMapping("/login")
    public String loginPage() {
        return "2login"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/erro")
    public String loginErrorPage() {
        return "3loginerro"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/menuinicialrua")
    public String menuInicialRuaPage() {
        return "5menuinicialrua"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/fiscaisadmin")
    public String fiscaisAdminPage() {
        return "8fiscaisadmin"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/matriculas")
    public String matriculasPage() {
        return "7matriculas"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/fiscais")
    public String fiscaisPage() {
        return "9fiscaisnormais"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }
    
}
