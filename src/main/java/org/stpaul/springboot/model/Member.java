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
    
	@Column(name = "MEMBER_INFO")
	private String memberInfo;

	@Column(name = "ENVELOPE")
	private Long envelope;

	@Column(name = "HOUSEHOLD_ID")
	private Long householdId;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "PREFERRED_NICKNAME")
	private String preferredNickname;

	@Column(name = "TITLE")
	private String title;

    @Column(name = "SUFFIX")
    private String suffix;

	@Column(name = "ETHNICITY")
	private String ethnicity;

	@Column(name = "SEQUENCE_IN_HOUSEHOLD")
	private String sequenceInHousehold;

	@Column(name = "STATE_PROVINCE")
	private String stateProvince;

	@Column(name = "CITY")
	private String city;

	@Column(name = "ZIP")
	private Long zip;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "Email")
	private String email;

	@Column(name = "MEMBER_TYPE")
	private String memberType;

	@Column(name = "RECEIVED_BY")
	private String receivedBy;

    @Column(name = "REMOVED_BY")
    private String removedBy;

    @Column(name = "CHURCH_BACKGROUND")
    private String churchBackground;

    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;

    @Column(name = "MARRIAGE_DATE")
    private Date marriageDate;

    @Column(name = "SPOUSES_NAME")
    private String spousesName;

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

    @Column(name = "PARENT_NAME_1")
    private String parentName1;

    @Column(name = "PARENT_NAME_2")
    private String parentName2;

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

    public String getMemberInfo() {
        return memberInfo;
    }

    public void setMemberInfo(String memberInfo) {
        this.memberInfo = memberInfo;
    }

    public Long getEnvelope() {
        return envelope;
    }

    public void setEnvelope(Long envelope) {
        this.envelope = envelope;
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

    public String getPreferredNickname() {
        return preferredNickname;
    }

    public void setPreferredNickname(String preferredNickname) {
        this.preferredNickname = preferredNickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
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

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZip() {
        return zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
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

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
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

    public String getChurchBackground() {
        return churchBackground;
    }

    public void setChurchBackground(String churchBackground) {
        this.churchBackground = churchBackground;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Date getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(Date marriageDate) {
        this.marriageDate = marriageDate;
    }

    public String getSpousesName() {
        return spousesName;
    }

    public void setSpousesName(String spousesName) {
        this.spousesName = spousesName;
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

    public String getParentName1() {
        return parentName1;
    }

    public void setParentName1(String parentName1) {
        this.parentName1 = parentName1;
    }

    public String getParentName2() {
        return parentName2;
    }

    public void setParentName2(String parentName2) {
        this.parentName2 = parentName2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (id != null ? !id.equals(member.id) : member.id != null) return false;
        if (name != null ? !name.equals(member.name) : member.name != null) return false;
        if (memberInfo != null ? !memberInfo.equals(member.memberInfo) : member.memberInfo != null) return false;
        if (envelope != null ? !envelope.equals(member.envelope) : member.envelope != null) return false;
        if (householdId != null ? !householdId.equals(member.householdId) : member.householdId != null) return false;
        if (dob != null ? !dob.equals(member.dob) : member.dob != null) return false;
        if (gender != null ? !gender.equals(member.gender) : member.gender != null) return false;
        if (preferredNickname != null ? !preferredNickname.equals(member.preferredNickname) : member.preferredNickname != null)
            return false;
        if (title != null ? !title.equals(member.title) : member.title != null) return false;
        if (suffix != null ? !suffix.equals(member.suffix) : member.suffix != null) return false;
        if (ethnicity != null ? !ethnicity.equals(member.ethnicity) : member.ethnicity != null) return false;
        if (sequenceInHousehold != null ? !sequenceInHousehold.equals(member.sequenceInHousehold) : member.sequenceInHousehold != null)
            return false;
        if (stateProvince != null ? !stateProvince.equals(member.stateProvince) : member.stateProvince != null)
            return false;
        if (city != null ? !city.equals(member.city) : member.city != null) return false;
        if (zip != null ? !zip.equals(member.zip) : member.zip != null) return false;
        if (address != null ? !address.equals(member.address) : member.address != null) return false;
        if (email != null ? !email.equals(member.email) : member.email != null) return false;
        if (memberType != null ? !memberType.equals(member.memberType) : member.memberType != null) return false;
        if (receivedBy != null ? !receivedBy.equals(member.receivedBy) : member.receivedBy != null) return false;
        if (removedBy != null ? !removedBy.equals(member.removedBy) : member.removedBy != null) return false;
        if (churchBackground != null ? !churchBackground.equals(member.churchBackground) : member.churchBackground != null)
            return false;
        if (maritalStatus != null ? !maritalStatus.equals(member.maritalStatus) : member.maritalStatus != null)
            return false;
        if (marriageDate != null ? !marriageDate.equals(member.marriageDate) : member.marriageDate != null)
            return false;
        if (spousesName != null ? !spousesName.equals(member.spousesName) : member.spousesName != null) return false;
        if (placeOfBirth != null ? !placeOfBirth.equals(member.placeOfBirth) : member.placeOfBirth != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(member.phoneNumber) : member.phoneNumber != null) return false;
        if (numberOfChildren != null ? !numberOfChildren.equals(member.numberOfChildren) : member.numberOfChildren != null)
            return false;
        if (childrenLiving != null ? !childrenLiving.equals(member.childrenLiving) : member.childrenLiving != null)
            return false;
        if (childrenNames != null ? !childrenNames.equals(member.childrenNames) : member.childrenNames != null)
            return false;
        if (parentName1 != null ? !parentName1.equals(member.parentName1) : member.parentName1 != null) return false;
        return parentName2 != null ? parentName2.equals(member.parentName2) : member.parentName2 == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (memberInfo != null ? memberInfo.hashCode() : 0);
        result = 31 * result + (envelope != null ? envelope.hashCode() : 0);
        result = 31 * result + (householdId != null ? householdId.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (preferredNickname != null ? preferredNickname.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (suffix != null ? suffix.hashCode() : 0);
        result = 31 * result + (ethnicity != null ? ethnicity.hashCode() : 0);
        result = 31 * result + (sequenceInHousehold != null ? sequenceInHousehold.hashCode() : 0);
        result = 31 * result + (stateProvince != null ? stateProvince.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (memberType != null ? memberType.hashCode() : 0);
        result = 31 * result + (receivedBy != null ? receivedBy.hashCode() : 0);
        result = 31 * result + (removedBy != null ? removedBy.hashCode() : 0);
        result = 31 * result + (churchBackground != null ? churchBackground.hashCode() : 0);
        result = 31 * result + (maritalStatus != null ? maritalStatus.hashCode() : 0);
        result = 31 * result + (marriageDate != null ? marriageDate.hashCode() : 0);
        result = 31 * result + (spousesName != null ? spousesName.hashCode() : 0);
        result = 31 * result + (placeOfBirth != null ? placeOfBirth.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (numberOfChildren != null ? numberOfChildren.hashCode() : 0);
        result = 31 * result + (childrenLiving != null ? childrenLiving.hashCode() : 0);
        result = 31 * result + (childrenNames != null ? childrenNames.hashCode() : 0);
        result = 31 * result + (parentName1 != null ? parentName1.hashCode() : 0);
        result = 31 * result + (parentName2 != null ? parentName2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", memberInfo='" + memberInfo + '\'' +
                ", envelope=" + envelope +
                ", householdId=" + householdId +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", preferredNickname='" + preferredNickname + '\'' +
                ", title='" + title + '\'' +
                ", suffix='" + suffix + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", sequenceInHousehold='" + sequenceInHousehold + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", memberType='" + memberType + '\'' +
                ", receivedBy='" + receivedBy + '\'' +
                ", removedBy='" + removedBy + '\'' +
                ", churchBackground='" + churchBackground + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", marriageDate=" + marriageDate +
                ", spousesName='" + spousesName + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", numberOfChildren=" + numberOfChildren +
                ", childrenLiving=" + childrenLiving +
                ", childrenNames='" + childrenNames + '\'' +
                ", parentName1='" + parentName1 + '\'' +
                ", parentName2='" + parentName2 + '\'' +
                '}';
    }
}
