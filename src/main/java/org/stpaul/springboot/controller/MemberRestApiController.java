package org.stpaul.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import org.stpaul.springboot.model.Member;
import org.stpaul.springboot.service.MemberService;
import org.stpaul.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class MemberRestApiController {

	public static final Logger logger = LoggerFactory.getLogger(MemberRestApiController.class);

	@Autowired
	MemberService memberService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Members---------------------------------------------

	@RequestMapping(value = "/member/", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> listAllMembers() {
		List<Member> members = memberService.findAllMembers();
		if (members.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
	}

	// -------------------Retrieve Single Member------------------------------------------

	@RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getMember(@PathVariable("id") long id) {
		logger.info("Fetching Member with id {}", id);
		Member member = memberService.findById(id);
		if (member == null) {
			logger.error("Member with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Member with id " + id
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}

	// -------------------Create a Member-------------------------------------------

	@RequestMapping(value = "/member/", method = RequestMethod.POST)
	public ResponseEntity<?> createMember(@RequestBody Member member, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Member : {}", member);

		if (memberService.isMemberExist(member)) {
			logger.error("Unable to create. A Member with name {} already exist", member.getName());
			return new ResponseEntity(new CustomErrorType("Unable to create. A Member with name " + 
			member.getName() + " already exist."),HttpStatus.CONFLICT);
		}
		memberService.saveMember(member);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/member/{id}").buildAndExpand(member.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Member ------------------------------------------------

	@RequestMapping(value = "/member/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateMember(@PathVariable("id") long id, @RequestBody Member member) {
		logger.info("Updating Member with id {}", id);

		Member currentMember = memberService.findById(id);

		if (currentMember == null) {
			logger.error("Unable to update. Member with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Member with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentMember.setName(member.getName());
		currentMember.setMemberInfo(member.getMemberInfo());
		currentMember.setHouseholdId(member.getHouseholdId());
		currentMember.setDob(member.getDob());
		currentMember.setGender(member.getGender());
		currentMember.setPreferredNickname(member.getPreferredNickname());
		currentMember.setTitle(member.getTitle());
		currentMember.setEthnicity(member.getEthnicity());
		currentMember.setSequenceInHousehold(member.getSequenceInHousehold());
		currentMember.setStateProvince(member.getStateProvince());
		currentMember.setCity(member.getCity());
		currentMember.setZip(member.getZip());
		currentMember.setAddress(member.getAddress());
		currentMember.setEmail(member.getEmail());
		currentMember.setMemberType(member.getMemberType());
		currentMember.setReceivedBy(member.getReceivedBy());
        currentMember.setRemovedBy(member.getRemovedBy());
        currentMember.setMaritalStatus(member.getMaritalStatus());
        currentMember.setPlaceOfBirth(member.getPlaceOfBirth());
        currentMember.setPhoneNumber(member.getPhoneNumber());
        currentMember.setNumberOfChildren(member.getNumberOfChildren());
        currentMember.setChildrenLiving(member.getChildrenLiving());
        currentMember.setChildrenNames(member.getChildrenNames());
        currentMember.setSuffix(member.getSuffix());
        currentMember.setChurchBackground(member.getChurchBackground());
        currentMember.setMarriageDate(member.getMarriageDate());
        currentMember.setSpousesName(member.getSpousesName());
        currentMember.setParentName1(member.getParentName1());
		currentMember.setParentName2(member.getParentName2());
		currentMember.setEnvelope(member.getEnvelope());

		memberService.updateMember(currentMember);
		return new ResponseEntity<Member>(currentMember, HttpStatus.OK);
	}

	// ------------------- Delete a Member-----------------------------------------

	@RequestMapping(value = "/member/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMember(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Member with id {}", id);

		Member member = memberService.findById(id);
		if (member == null) {
			logger.error("Unable to delete. Member with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Member with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		memberService.deleteMemberById(id);
		return new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Members-----------------------------

	@RequestMapping(value = "/member/", method = RequestMethod.DELETE)
	public ResponseEntity<Member> deleteAllMembers() {
		logger.info("Deleting All Members");

		memberService.deleteAllMembers();
		return new ResponseEntity<Member>(HttpStatus.NO_CONTENT);
	}

}

