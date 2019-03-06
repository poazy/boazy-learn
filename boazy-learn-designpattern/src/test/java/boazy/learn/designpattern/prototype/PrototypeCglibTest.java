package boazy.learn.designpattern.prototype;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author boazy
 * @company boazy
 * @date 2018/8/5
 */
public class PrototypeCglibTest {

    @Test
    public void testCglib1() {
        MyHouse myHouse = new MyHouse();
        myHouse.setName("我的房子2");
        myHouse.setPosition("广东省广州市增城区2");
        myHouse.setTel("83388228");
        myHouse.setTotalFloorNumber(3);
        MyTV myTV;
        myHouse.setMyTV(myTV = new MyTV());
        myTV.setLength(2000);
        myTV.setHigh(1500);
        myTV.setWidth(100);
        TVCpu tvCpu;
        myTV.setTvCpu(tvCpu = new TVCpu());
        tvCpu.setName("冲天CPU2");
        tvCpu.setKernelNumber(8);
        List<TVMemory> tvMemories;
        myTV.setTvMemories(tvMemories = new ArrayList<TVMemory>());
        TVMemory tvMemory1;
        tvMemories.add(tvMemory1 = new TVMemory());
        tvMemory1.setName("冲天Memory12");
        tvMemory1.setSize(8);
        TVMemory tvMemory2;
        tvMemories.add(tvMemory2 = new TVMemory());
        tvMemory2.setName("冲天Memory22");
        tvMemory2.setSize(4);

        MyHouse myHouseCopy = new MyHouse();

        /**
         * TODO
         * 对象复制的是引用！
         */
        BeanCopier beanCopier =BeanCopier.create(MyHouse.class, MyHouse.class, false);
        beanCopier.copy(myHouse, myHouseCopy, null);

        ProtorypeTestHelper.assertObject(myHouse, myHouseCopy);
    }

    @Test
    public void testCglib2() {
        MyHouse myHouse = new MyHouse();
        myHouse.setName("我的房子2");
        myHouse.setPosition("广东省广州市增城区2");
        myHouse.setTel("83388228");
        myHouse.setTotalFloorNumber(3);
        MyTV myTV;
        myHouse.setMyTV(myTV = new MyTV());
        myTV.setLength(2000);
        myTV.setHigh(1500);
        myTV.setWidth(100);
        TVCpu tvCpu;
        myTV.setTvCpu(tvCpu = new TVCpu());
        tvCpu.setName("冲天CPU2");
        tvCpu.setKernelNumber(8);
        List<TVMemory> tvMemories;
        myTV.setTvMemories(tvMemories = new ArrayList<TVMemory>());
        TVMemory tvMemory1;
        tvMemories.add(tvMemory1 = new TVMemory());
        tvMemory1.setName("冲天Memory12");
        tvMemory1.setSize(8);
        TVMemory tvMemory2;
        tvMemories.add(tvMemory2 = new TVMemory());
        tvMemory2.setName("冲天Memory22");
        tvMemory2.setSize(4);
        Custom custom;
        myHouse.setCustom(custom = new Custom());
        custom.setName("custom for boazy");

        MyNatatorium myNatatorium = new MyNatatorium();

        /**
         * TODO
         * 对象复制的是引用！
         */
        BeanCopier beanCopier = BeanCopier.create(MyHouse.class, MyNatatorium.class, false);
        beanCopier.copy(myHouse, myNatatorium, null);

        ProtorypeTestHelper.assertObject(myHouse, myNatatorium);
    }

}