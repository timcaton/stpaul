package org.stpaul.springboot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CONTRIBUTION")
public class Contribution implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MEMBER_ID")
    private String memberId;

    @Column(name = "GUEST_ID")
    private String guestId;

    @Column(name = "PURPOSE")
    private String purpose;

    @Column(name = "METHOD")
    private String method;

    @Column(name = "CONTRIBUTION_DATE")
    private String contributionDate;

    @Column(name = "AMOUNT")
    private String amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getContributionDate() {
        return contributionDate;
    }

    public void setContributionDate(String contributionDate) {
        this.contributionDate = contributionDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contribution that = (Contribution) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (memberId != null ? !memberId.equals(that.memberId) : that.memberId != null) return false;
        if (guestId != null ? !guestId.equals(that.guestId) : that.guestId != null) return false;
        if (purpose != null ? !purpose.equals(that.purpose) : that.purpose != null) return false;
        if (method != null ? !method.equals(that.method) : that.method != null) return false;
        if (contributionDate != null ? !contributionDate.equals(that.contributionDate) : that.contributionDate != null)
            return false;
        return amount != null ? amount.equals(that.amount) : that.amount == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (guestId != null ? guestId.hashCode() : 0);
        result = 31 * result + (purpose != null ? purpose.hashCode() : 0);
        result = 31 * result + (method != null ? method.hashCode() : 0);
        result = 31 * result + (contributionDate != null ? contributionDate.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contribution{" +
                "id=" + id +
                ", memberId='" + memberId + '\'' +
                ", guestId='" + guestId + '\'' +
                ", purpose='" + purpose + '\'' +
                ", method='" + method + '\'' +
                ", contributionDate='" + contributionDate + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
