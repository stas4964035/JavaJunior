
public class Program {
    public static void main(String[] args) throws InterruptedException {
        StudentData sd = new StudentData();
//        sd.writeData("data.bin");
//        sd.writeData("data.xml");
//        Thread.sleep(100);
        sd.readData("data.bin");
        sd.printData();
        sd.readData("data.xml");
        sd.printData();
    }
}
