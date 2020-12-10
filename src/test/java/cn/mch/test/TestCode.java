package cn.mch.test;

import cn.mch.code.NumToLetters;
import org.junit.Test;



/**
 * The test method
 *
 * @Auther: MCH
 * @Date: 2020/12/10/11:39
 */
public class TestCode {
    @Test
    public void testCode() {

        NumToLetters.numToLetters();

    }
    //Test the method, using the main method since Junit does not support console manual input
    public static void main(String[] args) {
        NumToLetters.numToLetters();
    }
}
