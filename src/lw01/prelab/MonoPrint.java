package lw01.prelab;

public class MonoPrint extends PrintJob {

    public MonoPrint(int Pages, String id) {
        super(Pages, id);
    }

    @Override
    public int calculateCharge() {
        return getPages() * 500;
    }

    @Override 
    public String label(){
        return "Mono";
    }
}
