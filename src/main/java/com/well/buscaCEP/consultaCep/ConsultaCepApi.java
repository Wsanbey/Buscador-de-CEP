package com.well.buscaCEP.consultaCep;

import com.well.buscaCEP.DTO.ConsultaCepDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/consulta-cep")
public class ConsultaCepApi {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/buscar")
    public String buscarCep(@RequestParam("cep") String cep, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ConsultaCepDTO> resp = restTemplate.getForEntity(
                String.format("https://viacep.com.br/ws/%s/json/", cep), ConsultaCepDTO.class);

        model.addAttribute("infCEP", resp.getBody());
        return "home";
    }
}
