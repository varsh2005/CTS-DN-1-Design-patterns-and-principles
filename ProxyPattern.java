interface Image{
    void display();
}
class RealImage implements Image{
    private String fileName;
    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromServer();
    }
    private void loadFromServer(){
        System.out.println("Loading image from server: " + fileName);
    }
    public void display(){
        System.out.println("Displaying image: " + fileName);
    }
}
class ProxyImage implements Image{
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }
    public void display(){
        if (realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
public class ProxyPattern{
    public static void main(String[] args){
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");
        image1.display();
        System.out.println();
        image2.display();
    }
}
