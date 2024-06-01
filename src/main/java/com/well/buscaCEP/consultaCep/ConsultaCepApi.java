package com.well.buscaCEP.consultaCep;

import com.well.buscaCEP.DTO.ConsultaCepDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consulta-cep")
public class ConsultaCepApi {

    @GetMapping("{cep}")
    public ConsultaCepDTO buscarCep(@PathVariable("cep") String cep){

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ConsultaCepDTO> resp = restTemplate.getForEntity(String.format("https://viacep.com.br/ws/%s/json/",cep),ConsultaCepDTO.class);

        return resp.getBody();
    }
}
