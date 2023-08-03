package com.cf401d18.bcrypt.auth.controllers;

import com.cf401d18.bcrypt.auth.models.Secret;
import com.cf401d18.bcrypt.auth.models.SiteUser;
import com.cf401d18.bcrypt.auth.repositories.SecretRepository;
import com.cf401d18.bcrypt.auth.repositories.SiteUserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SecretController {
    @Autowired
    SiteUserRepository siteUserRepository;
    @Autowired
    SecretRepository secretRepository;

    @GetMapping("/secret")
    public String getSecrets(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession();

        Object userNameAttribute = session.getAttribute("userName");

        if(userNameAttribute == null) {
            return "redirect:/";
        }

        String userName = userNameAttribute.toString();
        SiteUser currentUser = siteUserRepository.findSiteUserByUserName(userName);

        model.addAttribute("currentUser", currentUser);


        return "secret.html";
    }

    @PostMapping("/post-secret")
    public RedirectView addSecretFromForm(HttpServletRequest request, String codeName, String secretPost){
        HttpSession session = request.getSession();

        Object userNameAttribute = session.getAttribute("userName");

        if(userNameAttribute == null) {
            return new RedirectView("/secret");
        }

        String userName = userNameAttribute.toString();
        SiteUser currentUser = siteUserRepository.findSiteUserByUserName(userName);

        Secret newPost = new Secret(codeName, secretPost, currentUser);
        secretRepository.save(newPost);

        return new RedirectView("/secret");
    }
}