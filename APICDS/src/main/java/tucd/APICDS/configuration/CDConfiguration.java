package tucd.APICDS.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import tucd.APICDS.model.Dolar;

@Configuration
public class CDConfiguration {

    @Value("${dolarapi.url}")
    private String URL_Dolar;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public Dolar fetchDolar(){
        RestTemplate restTemplate = restTemplate();
        return restTemplate.getForObject(URL_Dolar + "/tarjeta", Dolar.class);
    }

    public Dolar [] fetchAllDolars(){
        RestTemplate restTemplate = restTemplate();
        return restTemplate.getForEntity(URL_Dolar, Dolar[].class).getBody();
    }
}
