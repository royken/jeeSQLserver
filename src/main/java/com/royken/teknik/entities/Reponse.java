package com.royken.teknik.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
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
@Table(name = "REPONSE")
@XmlRootElement(name="reponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reponse implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Version
    @Column(name = "VERSION")
    private int version;
    
    @ManyToOne
    @JoinColumn(name = "ELEMENTS_ID")
    private Elements elements;
    
    @Temporal(javax.persistence.TemporalType.TIME)
    @Column(name = "DATE")
    private Date date;
    
    @Column(name = "VALEUR")
    private String valeur;
    
    @Column(name = "VALEURCORRECTE")
    private boolean valeurCorrecte;
    
    @ManyToOne
    @JoinColumn(name = "UTILISATEURS_ID")
    private Utilisateurs utilisateurs;
    
    @XmlTransient
    @Column(columnDefinition = "int default 1",name = "ACTIVE")
    private int active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Elements getElements() {
        return elements;
    }

    public void setElements(Elements elements) {
        this.elements = elements;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public boolean isValeurCorrecte() {
        return valeurCorrecte;
    }

    public void setValeurCorrecte(boolean valeurCorrecte) {
        this.valeurCorrecte = valeurCorrecte;
    }

    public Utilisateurs getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Utilisateurs utilisateurs) {
        this.utilisateurs = utilisateurs;
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
        return "Reponse{" + "date=" + date + ", valeur=" + valeur + ", valeurCorrecte=" + valeurCorrecte + ", active=" + active + '}';
    }
    
    
    
    
    
}
