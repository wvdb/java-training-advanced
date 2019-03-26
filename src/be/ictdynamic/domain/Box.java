package be.ictdynamic.domain;

public class Box implements  Comparable<Box> {
     private int width;
     private int length;
     private int height;

    public Box(int w, int l, int h) {
        this.width = w;
        this.length = l;
        this.height = h;
    }

    @Override
    public int compareTo(Box other) {
        return width * length * height - other.width * other.length * other.height;
    }

    @Override
    public String toString() {
        return "Box{" + "width=" + width + ", length=" + length + ", height=" + height + '}';
    }
}
