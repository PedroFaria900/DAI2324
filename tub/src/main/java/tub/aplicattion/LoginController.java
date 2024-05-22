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
    public String fiscaissPage() {
        return "9fiscaisnormais"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/perfil")
    public String perfilPage() {
        return "10perfil"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }
    
    @GetMapping("/fiscaispagina")
    public String fiscaisPage() {
        return "Fiscaispagina"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/fiscaisperfil")
    public String fiscaisPerfilPage() {
        return "Fiscaisperfil"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/fiscaispagamentos")
    public String fiscaisPagamentoPage() {
        return "Fiscaispagamentos"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/fiscaiscoimas")
    public String fiscaisCoimasPage() {
        return "Fiscaiscoimas"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/Condutorperfil")
    public String Condutorpage() {
        return "Condutorperfil"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/Condutorpageinicial")
    public String Condutorpageinicial() {
        return "Condutorpageinicial"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/Gestorperfil")
    public String Gestorpage() {
        return "Gestorperfil"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/Gestorpagina")
    public String Gestorpageinicial() {
        return "Gestorpagina"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/Gestorautocarros")
    public String Gestorpageautocarros() {
        return "Gestorautocarros"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }

    @GetMapping("/Gestorestacionamentos")
    public String Gestorpageestacionamentos() {
        return "Gestorestacionamentos"; // Isso corresponde ao nome do arquivo HTML sem a extensão
    }
}
