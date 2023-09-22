package cn.poi.strategy;


import cn.poi.easy.UserDto;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import sun.text.normalizer.UCharacter;

public class AgeCe<T> extends Policyinf<T> {
    public String impartial(T t) {
        return t instanceof UserDto ? checkInteger((UserDto) t) : "";
    }

    private String checkInteger(UserDto t) {

        return Integer.valueOf(t.getAge()) > 100 ? "您的年龄太吓人了！不能入住我们酒店":"";
    }
}
