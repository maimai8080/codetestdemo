package cn.mch.test;

import cn.mch.code.NumToLetters;
import org.junit.Test;



/**
 * 测试方法
 *
 * @Auther: MCH
 * @Date: 2020/12/10/11:39
 */
public class TestCode {
    @Test
    public void testCode() {

        NumToLetters.numToLetters();

    }
    //测试方法，由于Junit不支持控制台手动输入，使用main方法测试
    public static void main(String[] args) {
        NumToLetters.numToLetters();
    }
}
