package com.vinimanfrin.safeway.services.callback;

import com.vinimanfrin.safeway.infra.exceptions.CallBackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CallBackService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${webhook.url}")
    private String webhookUrl;

    public void sendCallBack(CallBackDTO callBackDTO){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CallBackDTO> requestEntity = new HttpEntity<>(callBackDTO, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(webhookUrl, HttpMethod.POST, requestEntity, String.class);
        HttpStatusCode statusCode = responseEntity.getStatusCode();

        if (statusCode != HttpStatus.OK){
            throw new CallBackException("erro ao enviar callback");
        }
    }
}
