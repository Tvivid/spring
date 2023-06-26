package hellong.core;

import hellong.core.member.MemberService;
import hellong.core.member.MemberServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl();
    }


}
