package com.example.demo.controller;

import com.example.demo.service.TikTokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TikTokController {

    @Autowired
    private TikTokService tikTokService;

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("/comments/{videoId}")
    @ResponseBody
    public String getComments(@PathVariable String videoId,
                              @AuthenticationPrincipal OAuth2AuthenticationToken authentication) {

        OAuth2AuthorizedClient client =
                authorizedClientService.loadAuthorizedClient(
                        authentication.getAuthorizedClientRegistrationId(),
                        authentication.getName());

        String accessToken = client.getAccessToken().getTokenValue();

        return tikTokService.getComments(accessToken, videoId);
    }

    @PostMapping("/comments/reply/{commentId}")
    @ResponseBody
    public String replyComment(@PathVariable String commentId,
                               @RequestParam String text,
                               @AuthenticationPrincipal OAuth2AuthenticationToken authentication) {

        OAuth2AuthorizedClient client =
                authorizedClientService.loadAuthorizedClient(
                        authentication.getAuthorizedClientRegistrationId(),
                        authentication.getName());

        String accessToken = client.getAccessToken().getTokenValue();

        return tikTokService.replyComment(accessToken, commentId, text);
    }

}
