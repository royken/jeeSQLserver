package com.royken.teknik.entities.projections;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name="organe")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organe implements Serializable{
    
    private Long id;
    
    private String nom;
    
    private String code;
    
    private Long idBloc;

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

    public Long getIdBloc() {
        return idBloc;
    }

    public void setIdBloc(Long idBloc) {
        this.idBloc = idBloc;
    }

    @Override
    public String toString() {
        return "Organe{" + "id=" + id + ", nom=" + nom + ", code=" + code + ", idBloc=" + idBloc + '}';
    }
    
}