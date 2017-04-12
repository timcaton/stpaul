package org.stpaul.springboot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="HOUSEHOLD")
public class Household implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "HOUSEHOLD_TYPE")
    private String householdType;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseholdType() {
        return householdType;
    }

    public void setHouseholdType(String householdType) {
        this.householdType = householdType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Household household = (Household) o;

        if (id != null ? !id.equals(household.id) : household.id != null) return false;
        if (memberId != null ? !memberId.equals(household.memberId) : household.memberId != null) return false;
        if (name != null ? !name.equals(household.name) : household.name != null)
            return false;
        return householdType != null ? householdType.equals(household.householdType) : household.householdType == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (householdType != null ? householdType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Household{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", name='" + name + '\'' +
                ", householdType='" + householdType + '\'' +
                '}';
    }
}
