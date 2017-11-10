package be.ictdynamic.domain;

public class Woning <E extends MateriaalType> {
//public class Woning <MateriaalType> {
//    private MateriaalType muren2;
//    private MateriaalType plafond;
//    private MateriaalType vloeren;

    private E muren;
    private E plafond;
    private E vloeren;

//    public E getMuren() {
////        return muren.getKostPerKubiekeMeter();
//    }

//    public MateriaalType getMuren2() {
//        return muren2.getKostPerKubiekeMeter();
//    }

    //    public Woning(MateriaalType muren) {
//        this.muren = muren;
//    }
}
