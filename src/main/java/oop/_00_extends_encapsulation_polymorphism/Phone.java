package oop._00_extends_encapsulation_polymorphism;

/**
 * @Author JoeBig7
 * @date 2021/3/30 16:17:00
 * @description 父类  表示所有的手机类
 */
public class Phone {

    private String name;

    private Double price;

    private Long memory;

    protected Float size;

    public Phone() {

    }

    public Phone(String name) {
        this.name = name;
    }

    public void call() {
        System.out.println("call to someone");
    }


    protected void cal() {
        System.out.println("cal something");
    }


    private void listen() {
        System.out.println("listen a song");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }
}
