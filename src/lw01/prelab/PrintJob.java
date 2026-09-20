package lw01.prelab;

public class PrintJob implements Chargeable {
    private int Pages;
    private String id;

    protected PrintJob(int Pages, String id) {
        this.Pages = Pages;
        this.id = id;
    }

    public int getPages() {
        return Pages;
    }

    public String getId() {
        return id;
    }

    public int calculateCharge() {
        return 0;
    }

    public int calculateCharge(int copies) {
        return copies * calculateCharge();
    }

    public String label(){
        return "Print";
    }

    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }
}