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
@Table(name = "UTILISATEURS")
@XmlRootElement(name="utilisateurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class Utilisateurs implements Serializable{

    private static final long serialVersionUID = 1L;
    
    
    @XmlTransient
    @OneToMany(mappedBy = "utilisateurs")
    private List<Reponse> reponses;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Version
    @Column(name = "VERSION")
    private int version;
    
    @Column(name = "LOGIN")
    private String login;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "CAHIER")
    private String cahier;
    
    @Column(name = "NOM")
    private String nom;
    
    @Column(name = "ROLE")
    private String role;
    
    @XmlTransient
    @Column(columnDefinition = "int default 1",name = "ACTIVE")
    private int active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCahier() {
        return cahier;
    }

    public void setCahier(String cahier) {
        this.cahier = cahier;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
    
    
    
}
