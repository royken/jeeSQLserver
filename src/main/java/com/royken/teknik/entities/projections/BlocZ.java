package com.royken.teknik.entities.projections;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name="bloc")
@XmlAccessorType(XmlAccessType.FIELD)
public class BlocZ implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private String code;
    
    private String nom;
    
    private Long idZone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
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

    public Long getIdZone() {
        return idZone;
    }

    public void setIdZone(Long idZone) {
        this.idZone = idZone;
    }

    @Override
    public String toString() {
        return "BlocZ{" + "id=" + id + ", code=" + code + ", nom=" + nom + ", idZone=" + idZone + '}';
    }
    
    
    
}
