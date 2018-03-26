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
@XmlRootElement(name="organes")
@Table(name = "ORGANES")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organes implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @XmlTransient
    @OneToMany(mappedBy = "organes")
    private List<SousOrganes> sousOrganess;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @Version
    @Column(name = "VERSION")
    private int version;
    
    @Column(name = "NOM")
    private String nom;
    
    @Column(name = "CODE")
    private String code;
    
    @ManyToOne
    @JoinColumn(name = "BLOC_ID")
    private Bloc bloc;
    
    @XmlTransient
    @Column(columnDefinition = "int default 1",name = "ACTIVE")
    private int active;

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

    public Bloc getBloc() {
        return bloc;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }

    public List<SousOrganes> getSousOrganess() {
        return sousOrganess;
    }

    public void setSousOrganess(List<SousOrganes> sousOrganess) {
        this.sousOrganess = sousOrganess;
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
        return "Organes{" + "id=" + id + ", nom=" + nom + ", code=" + code + '}';
    }
    
    
    
}
