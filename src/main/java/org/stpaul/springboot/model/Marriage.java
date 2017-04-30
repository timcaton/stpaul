package org.stpaul.springboot.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="MARRIAGE")
public class Marriage implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SPOUSE_1")
    private String spouse1;

    @Column(name = "SPOUSE_2")
    private String spouse2;

    @Column(name = "MARRIAGE_DATE")
    private Date marriageDate;

    @Column(name = "MARRIAGE_PLACE")
    private String marriagePlace;

    @Column(name = "MARRIAGE_OFFICIANT")
    private String marriageOfficiant;

    @Column(name = "WITNESS_NAME1")
    private String witnessName1;

    @Column(name = "WITNESS_NAME2")
    private String witnessName2;

    @Column(name = "LICENSE_NUMBER")
    private String licenseNumber;

    @Column(name = "RETURN_DATE")
    private Date returnDate;

    @Column(name = "MARRIAGE_COMMENT")
    private String marriageComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpouse1() {
        return spouse1;
    }

    public void setSpouse1(String spouse1) {
        this.spouse1 = spouse1;
    }

    public String getSpouse2() {
        return spouse2;
    }

    public void setSpouse2(String spouse2) {
        this.spouse2 = spouse2;
    }

    public Date getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(Date marriageDate) {
        this.marriageDate = marriageDate;
    }

    public String getMarriagePlace() {
        return marriagePlace;
    }

    public void setMarriagePlace(String marriagePlace) {
        this.marriagePlace = marriagePlace;
    }

    public String getMarriageOfficiant() {
        return marriageOfficiant;
    }

    public void setMarriageOfficiant(String marriageOfficiant) {
        this.marriageOfficiant = marriageOfficiant;
    }

    public String getWitnessName1() {
        return witnessName1;
    }

    public void setWitnessName1(String witnessName1) {
        this.witnessName1 = witnessName1;
    }

    public String getWitnessName2() {
        return witnessName2;
    }

    public void setWitnessName2(String witnessName2) {
        this.witnessName2 = witnessName2;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getMarriageComment() {
        return marriageComment;
    }

    public void setMarriageComment(String marriageComment) {
        this.marriageComment = marriageComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Marriage marriage = (Marriage) o;

        if (id != null ? !id.equals(marriage.id) : marriage.id != null) return false;
        if (spouse1 != null ? !spouse1.equals(marriage.spouse1) : marriage.spouse1 != null) return false;
        if (spouse2 != null ? !spouse2.equals(marriage.spouse2) : marriage.spouse2 != null) return false;
        if (marriageDate != null ? !marriageDate.equals(marriage.marriageDate) : marriage.marriageDate != null)
            return false;
        if (marriagePlace != null ? !marriagePlace.equals(marriage.marriagePlace) : marriage.marriagePlace != null)
            return false;
        if (marriageOfficiant != null ? !marriageOfficiant.equals(marriage.marriageOfficiant) : marriage.marriageOfficiant != null)
            return false;
        if (witnessName1 != null ? !witnessName1.equals(marriage.witnessName1) : marriage.witnessName1 != null)
            return false;
        if (witnessName2 != null ? !witnessName2.equals(marriage.witnessName2) : marriage.witnessName2 != null)
            return false;
        if (licenseNumber != null ? !licenseNumber.equals(marriage.licenseNumber) : marriage.licenseNumber != null)
            return false;
        if (returnDate != null ? !returnDate.equals(marriage.returnDate) : marriage.returnDate != null) return false;
        return marriageComment != null ? marriageComment.equals(marriage.marriageComment) : marriage.marriageComment == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (spouse1 != null ? spouse1.hashCode() : 0);
        result = 31 * result + (spouse2 != null ? spouse2.hashCode() : 0);
        result = 31 * result + (marriageDate != null ? marriageDate.hashCode() : 0);
        result = 31 * result + (marriagePlace != null ? marriagePlace.hashCode() : 0);
        result = 31 * result + (marriageOfficiant != null ? marriageOfficiant.hashCode() : 0);
        result = 31 * result + (witnessName1 != null ? witnessName1.hashCode() : 0);
        result = 31 * result + (witnessName2 != null ? witnessName2.hashCode() : 0);
        result = 31 * result + (licenseNumber != null ? licenseNumber.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + (marriageComment != null ? marriageComment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Marriage{" +
                "id=" + id +
                ", spouse1=" + spouse1 +
                ", spouse2=" + spouse2 +
                ", marriageDate='" + marriageDate + '\'' +
                ", marriagePlace='" + marriagePlace + '\'' +
                ", marriageOfficiant='" + marriageOfficiant + '\'' +
                ", witnessName1='" + witnessName1 + '\'' +
                ", witnessName2='" + witnessName2 + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", marriageComment='" + marriageComment + '\'' +
                '}';
    }
}
