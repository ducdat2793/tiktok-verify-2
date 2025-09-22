package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//@RestController
@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // Trang index có nút "Login with TikTok"
    }

    @GetMapping("/home")
    @ResponseBody
    public String home(@AuthenticationPrincipal OAuth2AuthenticationToken authentication) {
        // Sau khi login thành công, lấy token
        OAuth2AuthorizedClient client =
                authorizedClientService.loadAuthorizedClient(
                        authentication.getAuthorizedClientRegistrationId(),
                        authentication.getName());

        String accessToken = client.getAccessToken().getTokenValue();
        return "Access Token: " + accessToken;
    }

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

}
