package org.stpaul.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="COMMUNION")
public class Communion implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @NotNull
    @Column(name = "COMMUNION_DATE")
    private String communionDate;

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

    public String getCommunionDate() {
        return communionDate;
    }

    public void setCommunionDate(String communionDate) {
        this.communionDate = communionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Communion communion = (Communion) o;

        if (id != null ? !id.equals(communion.id) : communion.id != null) return false;
        if (memberId != null ? !memberId.equals(communion.memberId) : communion.memberId != null) return false;
        return communionDate != null ? communionDate.equals(communion.communionDate) : communion.communionDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (communionDate != null ? communionDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Communion{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", communionDate='" + communionDate + '\'' +
                '}';
    }
}
