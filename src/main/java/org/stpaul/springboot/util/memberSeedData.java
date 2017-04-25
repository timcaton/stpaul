package org.stpaul.springboot.util;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.stpaul.springboot.model.Member;
import org.stpaul.springboot.service.MemberService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tjc4h on 4/24/2017.
 */
//@Component
//@Profile("load_test_data")
//public class memberSeedData implements ApplicationRunner {
//
//    @Autowired
//    private MemberService memberService;
//
//    private void loadMembers(){
//
//    }
//
//
//    @Override
//    public void run(ApplicationArguments applicationArguments) throws Exception {
//        loadMembers();
//    }
//}

@Component
public class memberSeedData implements ApplicationRunner {

    private MemberService memberService;

    @Autowired
    public memberSeedData(MemberService memberService) {
        this.memberService = memberService;
    }

    public void run(ApplicationArguments args) {
        Member member = new Member();
        member.setId((long) 1);
        member.setName("Tim Caton");
        memberService.saveMember(member);

        Member member2 = new Member();
        member2.setName("Samantha Thompson");
        member2.setId((long) 2);
        memberService.saveMember(member2);
    }
}