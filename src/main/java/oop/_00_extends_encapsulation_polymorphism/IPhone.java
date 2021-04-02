package oop._00_extends_encapsulation_polymorphism;

/**
 * @Author JoeBig7
 * @date 2021/3/30 16:20:05
 */
public class IPhone extends Phone {

    private String photoParam;

    public IPhone() {

    }

    public IPhone(String name) {
        super(name);
    }

    public void picture() {
        System.out.println("拍个照");
    }

    public String getPhotoParam() {
        return photoParam;
    }

    public void setPhotoParam(String photoParam) {
        this.photoParam = photoParam;
    }
}
