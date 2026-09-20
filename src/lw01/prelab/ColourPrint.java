package lw01.prelab;

public class ColourPrint extends PrintJob {

    public ColourPrint(int numPages, String id) {
        super(numPages, id);
    }
    
    @Override
    public int calculateCharge() {
        int pages = getPages();
        int baseCharge;

        if (pages <= 10) {
            baseCharge = pages * 1500;
        } else {
            baseCharge = (10 * 1500) + ((pages - 10) * 1000);   
        }
        return baseCharge + 2000;
    }

    public String label(){
        return "Colour";
    }
}