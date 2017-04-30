package org.stpaul.springboot.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="BAPTISM")
public class Baptism implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "BAPTISM_DATE")
    private Date baptismDate;

    @Column(name = "BAPTISM_LOCATION")
    private String baptismLocation;

    @Column(name = "BAPTISM_OFFICIANT")
    private String baptismOfficiant;

    @Column(name = "SPONSOR_NAME")
    private String sponsorName;

    @Column(name = "WITNESS_NAME")
    private String witnessName;

    @Column(name = "BAPTISM_COMMENT")
    private String baptismComment;

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

    public Date getBaptismDate() {
        return baptismDate;
    }

    public void setBaptismDate(Date baptismDate) {
        this.baptismDate = baptismDate;
    }

    public String getBaptismLocation() {
        return baptismLocation;
    }

    public void setBaptismLocation(String baptismLocation) {
        this.baptismLocation = baptismLocation;
    }

    public String getBaptismOfficiant() {
        return baptismOfficiant;
    }

    public void setBaptismOfficiant(String baptismOfficiant) {
        this.baptismOfficiant = baptismOfficiant;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getWitnessName() {
        return witnessName;
    }

    public void setWitnessName(String witnessName) {
        this.witnessName = witnessName;
    }

    public String getBaptismComment() {
        return baptismComment;
    }

    public void setBaptismComment(String baptismComment) {
        this.baptismComment = baptismComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Baptism baptism = (Baptism) o;

        if (id != null ? !id.equals(baptism.id) : baptism.id != null) return false;
        if (memberId != null ? !memberId.equals(baptism.memberId) : baptism.memberId != null) return false;
        if (baptismDate != null ? !baptismDate.equals(baptism.baptismDate) : baptism.baptismDate != null) return false;
        if (baptismLocation != null ? !baptismLocation.equals(baptism.baptismLocation) : baptism.baptismLocation != null)
            return false;
        if (baptismOfficiant != null ? !baptismOfficiant.equals(baptism.baptismOfficiant) : baptism.baptismOfficiant != null)
            return false;
        if (sponsorName != null ? !sponsorName.equals(baptism.sponsorName) : baptism.sponsorName != null) return false;
        if (witnessName != null ? !witnessName.equals(baptism.witnessName) : baptism.witnessName != null) return false;
        return baptismComment != null ? baptismComment.equals(baptism.baptismComment) : baptism.baptismComment == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (baptismDate != null ? baptismDate.hashCode() : 0);
        result = 31 * result + (baptismLocation != null ? baptismLocation.hashCode() : 0);
        result = 31 * result + (baptismOfficiant != null ? baptismOfficiant.hashCode() : 0);
        result = 31 * result + (sponsorName != null ? sponsorName.hashCode() : 0);
        result = 31 * result + (witnessName != null ? witnessName.hashCode() : 0);
        result = 31 * result + (baptismComment != null ? baptismComment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Baptism{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", baptismDate='" + baptismDate + '\'' +
                ", baptismLocation='" + baptismLocation + '\'' +
                ", baptismOfficiant='" + baptismOfficiant + '\'' +
                ", sponsorName='" + sponsorName + '\'' +
                ", witnessName='" + witnessName + '\'' +
                ", baptismComment='" + baptismComment + '\'' +
                '}';
    }
}
