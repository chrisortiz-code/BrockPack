import BasicIO.ASCIIDataFile;
import BasicIO.BasicForm;

public class Rental {
    private BasicForm form;  // form for user interaction
    int newm;
    double charge;
    private CarNode avail;
    private CarNode out;

    public Rental() {
        setForm();
        loadCars();

        //get user input
        while (true) {
            int button = form.accept();
            if (button == 0) {  // Rent
                rentCar(form.readInt("cat"));
            } else if (button == 1) { // Return
                returnCar(form.readString("license"));
            } else if (button == 2) { // List
                printAll();
            } else { // Quit
                break;
            }
        }
        form.close();
    }

    private void rentCar(int cat) {
        Car c= removeFromAvailable(cat);
        if (c == null) {
          return;
        }
        addToRented(c);
        form.writeInt("mileage",c.getMileage());
        if(c.getCategory()==1|c.getCategory()==2){
            form.writeString("rate","$"+c.getRate()+"0/mi");
        }else{
            form.writeString("rate","$"+c.getRate()+"/mi");
        }
        form.writeLine("console","Car "+c.getLicence()+" has been rented");
    }

    private void returnCar(String license) {
        Car c = removeFromRented(license);
        if (c == null) {
            form.writeLine("msg","Error");
            return;
        }
        form.writeInt("mileage",c.getMileage());
        if(c.getCategory()==1|c.getCategory()==2){
            form.writeString("rate","$"+c.getRate()+"0/mi");
        }else{
            form.writeString("rate","$"+c.getRate()+"/mi");
        }
        addToAvailable(c);
        CalculateCharge(c);
        form.writeLine("msg","Car "+c.getLicence()+" has been returned. Your Total is $"+charge);
    }


    private void printAll() {
        form.newLine("console");
        form.writeLine("console","Available Cars:");
        printAvailableCars();
        form.newLine("console");
        if (out.item == null) {
            return;
        }
        form.writeLine("msg","Rented Cars:");
        printRentedCars();
        form.newLine("console");
    }

    private void loadCars() {
        Car c;
        ASCIIDataFile input = new ASCIIDataFile();
        avail = new CarNode(null,null);
        while (true) {//or for(;;) they are the same!
            c = new Car(input);
            if (input.isEOF()) {

                break;
            }
            addToAvailable(c);
        }
    }

    public void addToAvailable(Car c) {
        avail= new CarNode(c,avail);
    }

    public Car removeFromAvailable(int cat) {
        CarNode n = avail;
        CarNode p = null;
        while (n.next != null&& n.item.getCategory()!=cat) {
            p = n;
            n=n.next;
        }
        Car c = n.item;

        if (c.getCategory()!=cat) {
            form.writeLine("msg","Dont have that");
            return null;
        }
        if(p==null){
            avail=n.next;
        }else{
            p.next = n.next;
        }
        return c;
    }

    private void printAvailableCars() {
        CarNode n = avail;
        while (n.next!=null) {
            form.writeLine("console",n.item.getLicence());
            n=n.next;
        }
    }

    public void addToRented(Car c) {

        if(out==null) {
            out = new CarNode(c, null);
        }
        else{
            out= new CarNode(c,out);
        }
    }

    public Car removeFromRented(String license) {
        CarNode n = out;
        CarNode p = null;
        while(n!=null&& n.item.getLicence().equals(license.toLowerCase())) {
            p = n;
            n=n.next;
        }
        Car c = n.item;
        if (p==null){
            out=n.next;
        }else{
            p.next = n.next;
        }
        return c;
            }

    private void printRentedCars() {
        CarNode n = out;
        while (n!=null) {
            form.writeLine("console",n.item.getLicence());
            n=n.next;
        }
    }

    private void clear() {
        form.clear("licence");
        form.clear("input");
        form.clear("cat");
        form.clear("rate");
        form.clear("mileage");
        form.clear("pay");
        form.clear("message");
    }

    private void CalculateCharge(Car c){
        newm =form.readInt("new");
        charge= c.returned(newm);
        if(c.getCategory()==1|c.getCategory()==2){
            form.writeString("total","$"+charge+"0");
        }else{
            form.writeString("total","$"+charge);
        }

    }
    private void setForm(){
        form = new BasicForm("Rent", "Return", "Print", "Quit");
        form.addTextField("license","License:", 7,5,0);
        form.addTextField("new","Final Mileage", 6,225,0);
        form.addRadioButtons("cat",true, 10,60, "Economy","Full Size", "Van", "SUV");
        form.setLabel("cat","Category");
        form.addTextArea("console","Console", 20,20,150,40);
        form.setEditable("console",false);
        form.addTextField("rate","Rate",8,10, 170);
        form.setEditable("rate", false);
        form.addTextField("mileage","Mileage",8,10,200);
        form.setEditable("mileage", false);
        form.addTextField("total","Total",8,10,230);
        form.setEditable("total", false);
        form.addTextArea("msg",2,32);
        form.setEditable("msg", false);

    }

    public static void main(String[] args) {
        Rental r = new Rental();
    }
}