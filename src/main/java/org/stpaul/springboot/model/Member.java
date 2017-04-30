package org.stpaul.springboot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="MEMBER")
public class Member implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "BAPTISM_ID")
	private Long baptismId;

	@Column(name = "MARRIAGE_ID")
	private Long marriageId;

	@Column(name = "FUNERAL_ID")
	private Long funeralId;

	@Column(name = "CONFIRMATION_ID")
	private Long confirmationId;

	@Column(name = "MEMBER_INFO")
	private String memberInfo;

	@Column(name = "CONTRIBUTION_ID")
	private Long contributionId;

	@Column(name = "ENVELOPE_ID")
	private Long envelopeId;

	@Column(name = "HOUSEHOLD_ID")
	private Long householdId;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "NICKNAME")
	private String nickname;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "ETHNICITY")
	private String ethnicity;

	@Column(name = "SEQUENCE_IN_HOUSEHOLD")
	private String sequenceInHousehold;

	@Column(name = "STATE")
	private String state;

	@Column(name = "CITY")
	private String city;

	@Column(name = "ZIP_CODE")
	private Long zipCode;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "Email")
	private String email;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "RECEIVED_BY")
	private String receivedBy;

    @Column(name = "REMOVED_BY")
    private String removedBy;

    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;

    @Column(name = "PLACE_OF_BIRTH")
    private String placeOfBirth;

    @Column(name = "PHONE_NUMBER")
    private Long phoneNumber;

    @Column(name = "NUMBER_OF_CHILDREN")
    private Long numberOfChildren;

    @Column(name = "CHILDREN_LIVING")
    private Long childrenLiving;

    @Column(name = "CHILDREN_NAMES")
    private String childrenNames;

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

    public Long getBaptismId() {
        return baptismId;
    }

    public void setBaptismId(Long baptismId) {
        this.baptismId = baptismId;
    }

    public Long getMarriageId() {
        return marriageId;
    }

    public void setMarriageId(Long marriageId) {
        this.marriageId = marriageId;
    }

    public Long getFuneralId() {
        return funeralId;
    }

    public void setFuneralId(Long funeralId) {
        this.funeralId = funeralId;
    }

    public Long getConfirmationId() {
        return confirmationId;
    }

    public void setConfirmationId(Long confirmationId) {
        this.confirmationId = confirmationId;
    }

    public String getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(String memberInfo) {
        this.memberInfo = memberInfo;
    }

    public Long getContributionId() {
        return contributionId;
    }

    public void setContributionId(Long contributionId) {
        this.contributionId = contributionId;
    }

    public Long getEnvelopeId() {
        return envelopeId;
    }

    public void setEnvelopeId(Long envelopeId) {
        this.envelopeId = envelopeId;
    }

    public Long getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Long householdId) {
        this.householdId = householdId;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getSequenceInHousehold() {
        return sequenceInHousehold;
    }

    public void setSequenceInHousehold(String sequenceInHousehold) {
        this.sequenceInHousehold = sequenceInHousehold;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public String getRemovedBy() {
        return removedBy;
    }

    public void setRemovedBy(String removedBy) {
        this.removedBy = removedBy;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Long numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public Long getChildrenLiving() {
        return childrenLiving;
    }

    public void setChildrenLiving(Long childrenLiving) {
        this.childrenLiving = childrenLiving;
    }

    public String getChildrenNames() {
        return childrenNames;
    }

    public void setChildrenNames(String childrenNames) {
        this.childrenNames = childrenNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (id != null ? !id.equals(member.id) : member.id != null) return false;
        if (name != null ? !name.equals(member.name) : member.name != null) return false;
        if (baptismId != null ? !baptismId.equals(member.baptismId) : member.baptismId != null) return false;
        if (marriageId != null ? !marriageId.equals(member.marriageId) : member.marriageId != null) return false;
        if (funeralId != null ? !funeralId.equals(member.funeralId) : member.funeralId != null) return false;
        if (confirmationId != null ? !confirmationId.equals(member.confirmationId) : member.confirmationId != null)
            return false;
        if (memberInfo != null ? !memberInfo.equals(member.memberInfo) : member.memberInfo != null) return false;
        if (contributionId != null ? !contributionId.equals(member.contributionId) : member.contributionId != null)
            return false;
        if (envelopeId != null ? !envelopeId.equals(member.envelopeId) : member.envelopeId != null) return false;
        if (householdId != null ? !householdId.equals(member.householdId) : member.householdId != null) return false;
        if (dob != null ? !dob.equals(member.dob) : member.dob != null) return false;
        if (gender != null ? !gender.equals(member.gender) : member.gender != null) return false;
        if (nickname != null ? !nickname.equals(member.nickname) : member.nickname != null) return false;
        if (title != null ? !title.equals(member.title) : member.title != null) return false;
        if (ethnicity != null ? !ethnicity.equals(member.ethnicity) : member.ethnicity != null) return false;
        if (sequenceInHousehold != null ? !sequenceInHousehold.equals(member.sequenceInHousehold) : member.sequenceInHousehold != null)
            return false;
        if (state != null ? !state.equals(member.state) : member.state != null) return false;
        if (city != null ? !city.equals(member.city) : member.city != null) return false;
        if (zipCode != null ? !zipCode.equals(member.zipCode) : member.zipCode != null) return false;
        if (address != null ? !address.equals(member.address) : member.address != null) return false;
        if (email != null ? !email.equals(member.email) : member.email != null) return false;
        if (status != null ? !status.equals(member.status) : member.status != null) return false;
        if (receivedBy != null ? !receivedBy.equals(member.receivedBy) : member.receivedBy != null) return false;
        if (removedBy != null ? !removedBy.equals(member.removedBy) : member.removedBy != null) return false;
        if (maritalStatus != null ? !maritalStatus.equals(member.maritalStatus) : member.maritalStatus != null)
            return false;
        if (placeOfBirth != null ? !placeOfBirth.equals(member.placeOfBirth) : member.placeOfBirth != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(member.phoneNumber) : member.phoneNumber != null) return false;
        if (numberOfChildren != null ? !numberOfChildren.equals(member.numberOfChildren) : member.numberOfChildren != null)
            return false;
        if (childrenLiving != null ? !childrenLiving.equals(member.childrenLiving) : member.childrenLiving != null)
            return false;
        return childrenNames != null ? childrenNames.equals(member.childrenNames) : member.childrenNames == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (baptismId != null ? baptismId.hashCode() : 0);
        result = 31 * result + (marriageId != null ? marriageId.hashCode() : 0);
        result = 31 * result + (funeralId != null ? funeralId.hashCode() : 0);
        result = 31 * result + (confirmationId != null ? confirmationId.hashCode() : 0);
        result = 31 * result + (memberInfo != null ? memberInfo.hashCode() : 0);
        result = 31 * result + (contributionId != null ? contributionId.hashCode() : 0);
        result = 31 * result + (envelopeId != null ? envelopeId.hashCode() : 0);
        result = 31 * result + (householdId != null ? householdId.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (ethnicity != null ? ethnicity.hashCode() : 0);
        result = 31 * result + (sequenceInHousehold != null ? sequenceInHousehold.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (receivedBy != null ? receivedBy.hashCode() : 0);
        result = 31 * result + (removedBy != null ? removedBy.hashCode() : 0);
        result = 31 * result + (maritalStatus != null ? maritalStatus.hashCode() : 0);
        result = 31 * result + (placeOfBirth != null ? placeOfBirth.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (numberOfChildren != null ? numberOfChildren.hashCode() : 0);
        result = 31 * result + (childrenLiving != null ? childrenLiving.hashCode() : 0);
        result = 31 * result + (childrenNames != null ? childrenNames.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", baptismId=" + baptismId +
                ", marriageId=" + marriageId +
                ", funeralId=" + funeralId +
                ", confirmationId=" + confirmationId +
                ", memberInfo='" + memberInfo + '\'' +
                ", contributionId=" + contributionId +
                ", envelopeId=" + envelopeId +
                ", householdId=" + householdId +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", nickname='" + nickname + '\'' +
                ", title='" + title + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", sequenceInHousehold=" + sequenceInHousehold +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", receivedBy='" + receivedBy + '\'' +
                ", removedBy='" + removedBy + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", numberOfChildren=" + numberOfChildren +
                ", childrenLiving=" + childrenLiving +
                ", childrenNames='" + childrenNames + '\'' +
                '}';
    }
}
