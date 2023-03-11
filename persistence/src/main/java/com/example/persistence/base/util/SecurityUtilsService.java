package com.example.persistence.base.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SecurityUtilsService {

    private final TokenStore tokenStore;
    @Value("${jwt.token.header-name}")
    private String AUTHORIZATION_HEADER;

    public SecurityUtilsService(TokenStore tokenStore) {
        super();
        this.tokenStore = tokenStore;
    }

    /**
     * @return logged in user id
     */
    public String getLoggedInUserId() {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if (principal instanceof OAuth2Authentication) {
            OAuth2Authentication authentication = (OAuth2Authentication) principal;
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(details.getTokenValue());
            return (String) accessToken.getAdditionalInformation().get("id");
        }
        return null;
    }

    public String getOnlyToken() {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if (principal instanceof OAuth2Authentication) {
            OAuth2Authentication authentication = (OAuth2Authentication) principal;
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(details.getTokenValue());
            return ((String) accessToken.getValue());
        }
        return null;
    }

    public List<String> getLoggedInUserSAccess() {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if (principal instanceof OAuth2Authentication) {
            OAuth2Authentication authentication = (OAuth2Authentication) principal;
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(details.getTokenValue());
            return (List<String>) accessToken.getAdditionalInformation().get("sAccess");
        }
        return null;
    }

    public List<String> getLoggedInUserItems() {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if (principal instanceof OAuth2Authentication) {
            OAuth2Authentication authentication = (OAuth2Authentication) principal;
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(details.getTokenValue());
            return (List<String>) accessToken.getAdditionalInformation().get("items");
        }
        return null;
    }



    public String getLoggedInUserAdditinalInformationByKey(String key) {
        Authentication principal = SecurityContextHolder.getContext().getAuthentication();
        if (principal instanceof OAuth2Authentication) {
            OAuth2Authentication authentication = (OAuth2Authentication) principal;
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(details.getTokenValue());
            return (String) accessToken.getAdditionalInformation().get(key);
        }
        return null;
    }


    public String getLoggedInUserCenterId() {
        return getLoggedInUserAdditinalInformationByKey("centerId");
    }

    public String getAuthorizationToken() {
        return AUTHORIZATION_HEADER + " " + getOnlyToken();
    }

    public String getBearerToken() {
        return "Bearer " + getOnlyToken();
    }


    public String getLoggedInClassInstituteId() {
        return getLoggedInUserAdditinalInformationByKey("classInstituteId");
    }

    public String getLoggedInUserSetadId() {
        return getLoggedInUserAdditinalInformationByKey("setadId");
    }
}