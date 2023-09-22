package cn.poi.strategy;

import cn.poi.easy.Mistake;
import com.alibaba.excel.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

//策略父类
public abstract class Policyinf<T> {
    public List<Mistake<T>> checkImportExcel(List< T> ta){
        //错误的结果集
        List<Mistake<T>> arlist = new ArrayList<Mistake<T>>();

        for (int i=0,len = ta.size();i<len;i++){
            T t = ta.get(i);
            //定义错误的提示信息
            String impartial = impartial(t);
            if (StringUtils.isEmpty(impartial)){
            }else {
                arlist.add(new Mistake<T>(t,impartial));
                ta.remove(t);
                --len;
                --i;
            }
        }


        return arlist;
    }

    //校验方法
    public abstract String impartial(T t);
}
