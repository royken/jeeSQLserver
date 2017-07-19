package com.royken.teknik.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@XmlRootElement(name = "elements")
@Table(name = "ELEMENTS")
@XmlAccessorType(XmlAccessType.FIELD)
public class Elements implements Serializable {
    @OneToMany(mappedBy = "elements")
    private List<Reponse> reponses;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    
    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "NOM")
    private String nom;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "SOUSORGANES_ID")
    private SousOrganes sousOrganes;
    
    @Column(columnDefinition = "tinyint(1) default true", name = "HASBORNS")
    private boolean hasBorns;

    @Column(columnDefinition = "tinyint(1) default true", name = "CRITERIAALPHA")
    private boolean criteriaAlpha;

    @Column
    private int valMin;

    @Column
    private int valMax;

    @Column
    private String guideSaisie;

    @Column
    private String valeurNormale;

    @Column
    private String valeurType;
    
    @Column
    private String code;
    
    @Column
    private String unite;
    
    @Enumerated(EnumType.ORDINAL)
    private PeriodeType periodeType;
    
    @XmlTransient
    @Column(columnDefinition = "int default 1")
    private int active;

    public boolean isHasBorns() {
        return hasBorns;
    }

    public void setHasBorns(boolean hasBorns) {
        this.hasBorns = hasBorns;
    }

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

    public SousOrganes getSousOrganes() {
        return sousOrganes;
    }

    public void setSousOrganes(SousOrganes sousOrganes) {
        this.sousOrganes = sousOrganes;
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

    public PeriodeType getPeriodeType() {
        return periodeType;
    }

    public void setPeriodeType(PeriodeType periodeType) {
        this.periodeType = periodeType;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
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
        return "Elements{" + "id=" + id + ", nom=" + nom + ", sousOrganes=" + sousOrganes + ", hasBorns=" + hasBorns + ", criteriaAlpha=" + criteriaAlpha + ", valMin=" + valMin + ", valMax=" + valMax + ", guideSaisie=" + guideSaisie + ", valeurNormale=" + valeurNormale + ", valeurType=" + valeurType + ", code=" + code + ", unite=" + unite + ", periodeType=" + periodeType + '}';
    }
    
    
    
}
