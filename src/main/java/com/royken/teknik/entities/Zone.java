package com.royken.teknik.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Entity
@Table(name = "ZONE")
@XmlRootElement(name="zones")
@XmlAccessorType(XmlAccessType.FIELD)
public class Zone implements Serializable{
    
    @XmlTransient
    @OneToMany(mappedBy = "zone")
    private List<Bloc> blocs;
    
    @Version
    @Column(name = "VERSION")
    private int version;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "CODE")
    private String code;
    
    @Column(name = "NOM")
    private String nom;
    
    @Column(name = "CAHIERCODE")
    private String cahierCode;
    
    @XmlTransient
    @Column(columnDefinition = "int default 1",name = "ACTIVE")
    private int active;

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

    public List<Bloc> getBlocs() {
        return blocs;
    }

    public void setBlocs(List<Bloc> blocs) {
        this.blocs = blocs;
    }

    public String getCahierCode() {
        return cahierCode;
    }

    public void setCahierCode(String cahierCode) {
        this.cahierCode = cahierCode;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Zone{" + "version=" + version + ", id=" + id + ", code=" + code + ", nom=" + nom + ", cahierCode=" + cahierCode + ", active=" + active + '}';
    }
    
    
    
}