package com.royken.teknik.entities.projections;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name="zone")
@XmlAccessorType(XmlAccessType.FIELD)
public class ZoneP implements Serializable{
    
     private Long id;
    
    private String code;
    
    private String nom;
    
    private String cahierCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ZoneP{" + "id=" + id + ", code=" + code + ", nom=" + nom + ", cahierCode=" + cahierCode + '}';
    }
    
    

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCahierCode() {
        return cahierCode;
    }

    public void setCahierCode(String cahierCode) {
        this.cahierCode = cahierCode;
    }   
}