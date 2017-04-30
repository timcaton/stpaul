package org.stpaul.springboot.model;

import org.h2.api.DatabaseEventListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="CONFIRMATION")
public class Confirmation implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "CONFIRMATION_DATE")
    private Date confirmationDate;

    @Column(name = "CONFIRMATION_LOCATION")
    private String confirmationLocation;
    
    @Column(name = "CONFIRMATION_COMMENT")
    private String confirmationComment;
    
    @Column(name = "CONFIRMATION_OFFICIANT")
    private String confirmationOfficiant;

    @Column(name = "CONFIRMATION_VERSE")
    private String confirmationVerse;

    @Column(name = "EXAMINATION_DATE")
    private String examinationDate;

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

    public Date getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public String getConfirmationLocation() {
        return confirmationLocation;
    }

    public void setConfirmationLocation(String confirmationLocation) {
        this.confirmationLocation = confirmationLocation;
    }

    public String getConfirmationComment() {
        return confirmationComment;
    }

    public void setConfirmationComment(String confirmationComment) {
        this.confirmationComment = confirmationComment;
    }

    public String getConfirmationOfficiant() {
        return confirmationOfficiant;
    }

    public void setConfirmationOfficiant(String confirmationOfficiant) {
        this.confirmationOfficiant = confirmationOfficiant;
    }

    public String getConfirmationVerse() {
        return confirmationVerse;
    }

    public void setConfirmationVerse(String confirmationVerse) {
        this.confirmationVerse = confirmationVerse;
    }

    public String getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(String examinationDate) {
        this.examinationDate = examinationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Confirmation that = (Confirmation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (memberId != null ? !memberId.equals(that.memberId) : that.memberId != null) return false;
        if (confirmationDate != null ? !confirmationDate.equals(that.confirmationDate) : that.confirmationDate != null)
            return false;
        if (confirmationLocation != null ? !confirmationLocation.equals(that.confirmationLocation) : that.confirmationLocation != null)
            return false;
        if (confirmationComment != null ? !confirmationComment.equals(that.confirmationComment) : that.confirmationComment != null)
            return false;
        if (confirmationOfficiant != null ? !confirmationOfficiant.equals(that.confirmationOfficiant) : that.confirmationOfficiant != null)
            return false;
        if (confirmationVerse != null ? !confirmationVerse.equals(that.confirmationVerse) : that.confirmationVerse != null)
            return false;
        return examinationDate != null ? examinationDate.equals(that.examinationDate) : that.examinationDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (confirmationDate != null ? confirmationDate.hashCode() : 0);
        result = 31 * result + (confirmationLocation != null ? confirmationLocation.hashCode() : 0);
        result = 31 * result + (confirmationComment != null ? confirmationComment.hashCode() : 0);
        result = 31 * result + (confirmationOfficiant != null ? confirmationOfficiant.hashCode() : 0);
        result = 31 * result + (confirmationVerse != null ? confirmationVerse.hashCode() : 0);
        result = 31 * result + (examinationDate != null ? examinationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Confirmation{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", confirmationDate='" + confirmationDate + '\'' +
                ", confirmationLocation='" + confirmationLocation + '\'' +
                ", confirmationComment='" + confirmationComment + '\'' +
                ", confirmationOfficiant='" + confirmationOfficiant + '\'' +
                ", confirmationVerse='" + confirmationVerse + '\'' +
                ", examinationDate='" + examinationDate + '\'' +
                '}';
    }


}
