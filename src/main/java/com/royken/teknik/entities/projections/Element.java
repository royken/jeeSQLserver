package com.royken.teknik.entities.projections;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@XmlRootElement(name="element")
@XmlAccessorType(XmlAccessType.FIELD)
public class Element implements Serializable{
    
    private Long id;

    private String nom;

    private Long sousOrganeId;
    
    private boolean hasBorn;

    private boolean criteriaAlpha;

    private int valMin;

    private int valMax;

    private String guideSaisie;

    private String valeurNormale;

    private String valeurType;
    
    private String code;
    
    private int periode;
    
    private String unite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isHasBorn() {
        return hasBorn;
    }

    public void setHasBorn(boolean hasBorn) {
        this.hasBorn = hasBorn;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getSousOrganeId() {
        return sousOrganeId;
    }

    public void setSousOrganeId(Long sousOrganeId) {
        this.sousOrganeId = sousOrganeId;
    }

    public boolean isCriteriaAlpha() {
        return criteriaAlpha;
    }

    public void setCriteriaAlpha(boolean criteriaAlpha) {
        this.criteriaAlpha = criteriaAlpha;
    }

    public int getValMin() {
        return valMin;
    }

    public void setValMin(int valMin) {
        this.valMin = valMin;
    }

    public int getValMax() {
        return valMax;
    }

    public void setValMax(int valMax) {
        this.valMax = valMax;
    }

    public String getGuideSaisie() {
        return guideSaisie;
    }

    public void setGuideSaisie(String guideSaisie) {
        this.guideSaisie = guideSaisie;
    }

    public String getValeurNormale() {
        return valeurNormale;
    }

    public void setValeurNormale(String valeurNormale) {
        this.valeurNormale = valeurNormale;
    }

    public String getValeurType() {
        return valeurType;
    }

    public void setValeurType(String valeurType) {
        this.valeurType = valeurType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
    
    
    @Override
    public String toString() {
        return "Element{" + "id=" + id + ", nom=" + nom + ", sousOrganeId=" + sousOrganeId + ", hasBorn=" + hasBorn + ", criteriaAlpha=" + criteriaAlpha + ", valMin=" + valMin + ", valMax=" + valMax + ", guideSaisie=" + guideSaisie + ", valeurNormale=" + valeurNormale + ", valeurType=" + valeurType + '}';
    }
    
    
    
}
