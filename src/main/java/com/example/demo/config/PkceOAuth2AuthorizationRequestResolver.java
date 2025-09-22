//package com.example.demo.config;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
//import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestCustomizers;
//import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
//import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
//
//public class PkceOAuth2AuthorizationRequestResolver implements OAuth2AuthorizationRequestResolver {
//
//    private final DefaultOAuth2AuthorizationRequestResolver defaultResolver;
//
//    public PkceOAuth2AuthorizationRequestResolver(ClientRegistrationRepository repo) {
//        this.defaultResolver = new DefaultOAuth2AuthorizationRequestResolver(repo, "/oauth2/authorization");
//    }
//
//    @Override
//    public OAuth2AuthorizationRequest resolve(HttpServletRequest request) {
//        return customize(defaultResolver.resolve(request));
//    }
//
//    @Override
//    public OAuth2AuthorizationRequest resolve(HttpServletRequest request, String clientRegistrationId) {
//        return customize(defaultResolver.resolve(request, clientRegistrationId));
//    }
//
//    private OAuth2AuthorizationRequest customize(OAuth2AuthorizationRequest req) {
//        if (req == null) return null;
//        OAuth2AuthorizationRequest.Builder builder = OAuth2AuthorizationRequest.from(req);
//        OAuth2AuthorizationRequestCustomizers.withPkce().accept(builder);
//        return builder.build();
//    }
//
//}
