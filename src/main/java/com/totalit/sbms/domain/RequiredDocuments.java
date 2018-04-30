/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.totalit.sbms.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Roy Kanavheti
 */
@Entity
@Table(name = "procurement_docs")
public class RequiredDocuments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
   
    private String applicationLetter;
    private String companyProfile;
    private String certOfIncorporation;
    private String mou;
    private String crFourteen;
    private String vat;
    private String itf;
    private String tradeLicense;
    private String traceableReference;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Client client;
    @Transient
    private Long ci;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicationLetter() {
        return applicationLetter;
    }

    public void setApplicationLetter(String applicationLetter) {
        this.applicationLetter = applicationLetter;
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile;
    }

    public String getCertOfIncorporation() {
        return certOfIncorporation;
    }

    public void setCertOfIncorporation(String certOfIncorporation) {
        this.certOfIncorporation = certOfIncorporation;
    }

    public String getMou() {
        return mou;
    }

    public void setMou(String mou) {
        this.mou = mou;
    }

    public String getCrFourteen() {
        return crFourteen;
    }

    public void setCrFourteen(String crFourteen) {
        this.crFourteen = crFourteen;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getItf() {
        return itf;
    }

    public void setItf(String itf) {
        this.itf = itf;
    }

    public String getTradeLicense() {
        return tradeLicense;
    }

    public void setTradeLicense(String tradeLicense) {
        this.tradeLicense = tradeLicense;
    }

    public String getTraceableReference() {
        return traceableReference;
    }

    public void setTraceableReference(String traceableReference) {
        this.traceableReference = traceableReference;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getCi() {
        return ci;
    }

    public void setCi(Long ci) {
        this.ci = ci;
    }
    
    
}
