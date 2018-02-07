package com.chen.spring.factorybean;

/**
 * Dog
 *
 * @author Chenpz
 * @package com.chen.spring.factorybean
 * @date 2018/1/28/18:09
 */
public class Dog {
    private String msg;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Dog(String msg){
        this.msg=msg;
    }
    public void run(){
        System.out.println(msg);
    }
}
