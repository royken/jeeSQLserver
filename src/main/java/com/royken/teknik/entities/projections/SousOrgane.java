package com.royken.teknik.entities.projections;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name="sousOrgarne")
@XmlAccessorType(XmlAccessType.FIELD)
public class SousOrgane implements Serializable{
    
    private Long id;
    
    private String nom;
    
    private String code;
    
    private Long idOrgane;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getIdOrgane() {
        return idOrgane;
    }

    public void setIdOrgane(Long idOrgane) {
        this.idOrgane = idOrgane;
    }

    @Override
    public String toString() {
        return "SousOrgane{" + "id=" + id + ", nom=" + nom + ", code=" + code + ", idOrgane=" + idOrgane + '}';
    }
    
    
    
}
