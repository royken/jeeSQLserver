package com.royken.teknik.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "SOUSORGANES")
@XmlRootElement(name="sousorganes")
@XmlAccessorType(XmlAccessType.FIELD)
public class SousOrganes implements Serializable{
    
    @XmlTransient
    @OneToMany(mappedBy = "sousOrganes")
    private List<Elements> elementss;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    
    @Version
    @Column(name = "VERSION")
    private int version;
    
    @Column(name = "CODE")
    private String code;
    
    @Column(name = "NOM")
    private String nom;
    
    
    @ManyToOne
    @JoinColumn(name = "ORGANES_ID")
    private Organes organes;
    
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

    public Organes getOrganes() {
        return organes;
    }

    public void setOrganes(Organes organes) {
        this.organes = organes;
    }

    public List<Elements> getElementss() {
        return elementss;
    }

    public void setElementss(List<Elements> elementss) {
        this.elementss = elementss;
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
        return "SousOrganes{" + "id=" + id + ", code=" + code + ", nom=" + nom + ", organes=" + organes + '}';
    }
    
}
