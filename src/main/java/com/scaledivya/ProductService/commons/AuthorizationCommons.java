package com.scaledivya.ProductService.commons;

import com.scaledivya.ProductService.model.Userdto;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthorizationCommons {

    private RestTemplate restTemplate;

    public  AuthorizationCommons(){
        this.restTemplate=new RestTemplate();
    }

    public Userdto validateToken(String token){
        ResponseEntity<Userdto> resp= restTemplate.postForEntity("http://localhost:3030/users/validate/"+token,null,Userdto.class);
        if(resp.getBody()==null){
            return null;
        }
        return resp.getBody();
    }



}
