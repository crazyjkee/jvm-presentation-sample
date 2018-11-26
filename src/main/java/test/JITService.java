package test;

import org.springframework.stereotype.Service;

@Service
public class JITService {

    private static final String LOG = "Invoked method";

    //javap -c C:\Users\Artem.Pasyugin\Documents\ideaProjects\jvm-presentation\target\classes\test\MainService.class
    public String fastOrSlowCompiling(boolean isFastCompiling) {

        A a;
        if (isFastCompiling) {
            a = new B();
        } else {
            a = new A();
        }
        return a.value();
    }

    private class A {

        protected String value() {
            return LOG;
        }
    }

    private class B extends A {

        @Override
        protected String value() {
            return LOG;
        }
    }

    private String getData(){
        return "";
    }


}
