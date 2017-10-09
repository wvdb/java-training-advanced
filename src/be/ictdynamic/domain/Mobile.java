package be.ictdynamic.domain;

/**
 * Created by admin on 29/09/2017.
 */
public class Mobile extends Remuneration{
    String type;
    String msisdn;

    public Mobile(String type, String msisdn, double cost) {
        super(cost);
        this.type = type;
        this.msisdn = msisdn;
    }

}
