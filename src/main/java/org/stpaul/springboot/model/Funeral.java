package org.stpaul.springboot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="FUNERAL")
public class Funeral implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "FUNERAL_DATE")
    private String funeralDate;

    @Column(name = "FUNERAL_PLACE")
    private String funeralPlace;

    @Column(name = "FUNERAL_OFFICIANT")
    private String funeralOfficiant;

    @Column(name = "BURIAL_LOCATION")
    private String burialLocation;

    @Column(name = "PALL_BEARERS")
    private String pallBearers;

    @Column(name = "DEATH_DATE")
    private String deathDate;

    @Column(name = "FUNERAL_COMMENT")
    private String funeralComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getFuneralDate() {
        return funeralDate;
    }

    public void setFuneralDate(String funeralDate) {
        this.funeralDate = funeralDate;
    }

    public String getFuneralPlace() {
        return funeralPlace;
    }

    public void setFuneralPlace(String funeralPlace) {
        this.funeralPlace = funeralPlace;
    }

    public String getFuneralOfficiant() {
        return funeralOfficiant;
    }

    public void setFuneralOfficiant(String funeralOfficiant) {
        this.funeralOfficiant = funeralOfficiant;
    }

    public String getBurialLocation() {
        return burialLocation;
    }

    public void setBurialLocation(String burialLocation) {
        this.burialLocation = burialLocation;
    }

    public String getPallBearers() {
        return pallBearers;
    }

    public void setPallBearers(String pallBearers) {
        this.pallBearers = pallBearers;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getFuneralComment() {
        return funeralComment;
    }

    public void setFuneralComment(String funeralComment) {
        this.funeralComment = funeralComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Funeral funeral = (Funeral) o;

        if (id != null ? !id.equals(funeral.id) : funeral.id != null) return false;
        if (memberId != null ? !memberId.equals(funeral.memberId) : funeral.memberId != null) return false;
        if (funeralDate != null ? !funeralDate.equals(funeral.funeralDate) : funeral.funeralDate != null) return false;
        if (funeralPlace != null ? !funeralPlace.equals(funeral.funeralPlace) : funeral.funeralPlace != null)
            return false;
        if (funeralOfficiant != null ? !funeralOfficiant.equals(funeral.funeralOfficiant) : funeral.funeralOfficiant != null)
            return false;
        if (burialLocation != null ? !burialLocation.equals(funeral.burialLocation) : funeral.burialLocation != null)
            return false;
        if (pallBearers != null ? !pallBearers.equals(funeral.pallBearers) : funeral.pallBearers != null) return false;
        if (deathDate != null ? !deathDate.equals(funeral.deathDate) : funeral.deathDate != null) return false;
        return funeralComment != null ? funeralComment.equals(funeral.funeralComment) : funeral.funeralComment == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (funeralDate != null ? funeralDate.hashCode() : 0);
        result = 31 * result + (funeralPlace != null ? funeralPlace.hashCode() : 0);
        result = 31 * result + (funeralOfficiant != null ? funeralOfficiant.hashCode() : 0);
        result = 31 * result + (burialLocation != null ? burialLocation.hashCode() : 0);
        result = 31 * result + (pallBearers != null ? pallBearers.hashCode() : 0);
        result = 31 * result + (deathDate != null ? deathDate.hashCode() : 0);
        result = 31 * result + (funeralComment != null ? funeralComment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Funeral{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", funeralDate='" + funeralDate + '\'' +
                ", funeralPlace='" + funeralPlace + '\'' +
                ", funeralOfficiant='" + funeralOfficiant + '\'' +
                ", burialLocation='" + burialLocation + '\'' +
                ", pallBearers='" + pallBearers + '\'' +
                ", deathDate='" + deathDate + '\'' +
                ", funeralComment='" + funeralComment + '\'' +
                '}';
    }
}
