package oop._00_extends_encapsulation_polymorphism;

/**
 * @Author JoeBig7
 * @date 2021/3/30 16:19:50
 */
public class HuaWei extends Phone {
    private String paramWith5G;

    private void open5G() {
        System.out.println("打开5g信号");
    }


    public String getParamWith5G() {
        return paramWith5G;
    }

    public void setParamWith5G(String paramWith5G) {
        this.paramWith5G = paramWith5G;
    }
}
