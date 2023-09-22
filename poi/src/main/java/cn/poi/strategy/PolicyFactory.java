package cn.poi.strategy;

import cn.poi.easy.UserDto;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;
//策略工厂
public class PolicyFactory<T> {
    List<Policyinf<T>> list = new ArrayList<Policyinf<T>>();
    public PolicyFactory(){
        list.add(new AgeCe());
        list.add(new NameCe());
    }

    public List<Policyinf<T>> show(){
        return list;
    }
}
