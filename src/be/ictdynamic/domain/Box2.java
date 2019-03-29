package be.ictdynamic.domain;

public class Box2 {
     private int width;
     private int length;
     private int height;

    public Box2(int w, int l, int h) {
        this.width = w;
        this.length = l;
        this.height = h;
    }

    @Override
    public String toString() {
        return "Box2{" + "width=" + width + ", length=" + length + ", height=" + height + '}';
    }
}
