package com.cf401d18.bcrypt.auth.models;

import jakarta.persistence.*;

@Entity
public class Secret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String codeName;
    String secretMessage;

    @ManyToOne
    SiteUser siteUser;

    protected Secret() {}

    public Secret(String codeName, String secretMessage, SiteUser siteUser) {
        this.codeName = codeName;
        this.secretMessage = secretMessage;
        this.siteUser = siteUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getSecretPost() {
        return secretMessage;
    }

    public void setSecretPost(String secretPost) {
        this.secretMessage = secretPost;
    }

    public SiteUser getSiteUser() {
        return siteUser;
    }

    public void setSiteUser(SiteUser siteUser) {
        this.siteUser = siteUser;
    }

    @Override
    public String toString() {
        return "Secret{" +
                "id=" + id +
                ", codeName='" + codeName + '\'' +
                ", secretPost='" + secretMessage + '\'' +
                ", siteUser=" + siteUser +
                '}';
    }
}