package org.stpaul.springboot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="BAPTISM")
public class Guest implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "HOME_CHURCH")
    private String homeChurch;

    @Column(name = "COMMUNION_DATE")
    private String communionDate;

    @Column(name = "GUEST_EMAIL")
    private String guestEmail;

    @Column(name = "GUEST_COMMENT")
    private String guestComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomeChurch() {
        return homeChurch;
    }

    public void setHomeChurch(String homeChurch) {
        this.homeChurch = homeChurch;
    }

    public String getCommunionDate() {
        return communionDate;
    }

    public void setCommunionDate(String communionDate) {
        this.communionDate = communionDate;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public String getGuestComment() {
        return guestComment;
    }

    public void setGuestComment(String guestComment) {
        this.guestComment = guestComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Guest guest = (Guest) o;

        if (id != null ? !id.equals(guest.id) : guest.id != null) return false;
        if (name != null ? !name.equals(guest.name) : guest.name != null) return false;
        if (address != null ? !address.equals(guest.address) : guest.address != null) return false;
        if (phone != null ? !phone.equals(guest.phone) : guest.phone != null) return false;
        if (homeChurch != null ? !homeChurch.equals(guest.homeChurch) : guest.homeChurch != null) return false;
        if (communionDate != null ? !communionDate.equals(guest.communionDate) : guest.communionDate != null)
            return false;
        if (guestEmail != null ? !guestEmail.equals(guest.guestEmail) : guest.guestEmail != null) return false;
        return guestComment != null ? guestComment.equals(guest.guestComment) : guest.guestComment == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (homeChurch != null ? homeChurch.hashCode() : 0);
        result = 31 * result + (communionDate != null ? communionDate.hashCode() : 0);
        result = 31 * result + (guestEmail != null ? guestEmail.hashCode() : 0);
        result = 31 * result + (guestComment != null ? guestComment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", homeChurch='" + homeChurch + '\'' +
                ", communionDate='" + communionDate + '\'' +
                ", guestEmail='" + guestEmail + '\'' +
                ", guestComment='" + guestComment + '\'' +
                '}';
    }
}
