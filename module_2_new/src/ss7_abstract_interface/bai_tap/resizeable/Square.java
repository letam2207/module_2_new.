package ss7_abstract_interface.bai_tap.resizeable;

public class Square extends Rectangle implements Colorable {

    public Square(){
    }
    public Square(double side ){
        super(side , side);
    }
    public double getSide(){
        return super.getWidth();
    }
    public void setSide(double side){
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "Square{" +
                " side="+getWidth()+
                " Area="+getArea()
                +"}";
    }

    @Override
    public String howToColor(String color) {
        return "This Circle is " + color;
    }
}
