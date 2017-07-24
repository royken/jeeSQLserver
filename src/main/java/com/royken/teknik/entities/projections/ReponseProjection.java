package com.royken.teknik.entities.projections;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name="reponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReponseProjection implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int idElement;
    
    private Date date;
    
    private String valeur;
    
    private boolean valeurCorrecte;
    
    private int idUser;

    public int getIdElement() {
        return idElement;
    }

    public void setIdElement(int idElement) {
        this.idElement = idElement;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "ReponseProjection{" + "idElement=" + idElement + ", date=" + date + ", valeur=" + valeur + ", valeurCorrecte=" + valeurCorrecte + ", idUser=" + idUser + '}';
    }
    
    
    
    
    
}
