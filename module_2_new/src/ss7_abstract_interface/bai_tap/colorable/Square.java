package ss7_abstract_interface.bai_tap.colorable;

public class Square extends Rectangle implements Resizeable {

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
    public void resize(double percent) {
        setSide(getLength()+getLength()*percent/100);
    }
    @Override
    public String toString() {
        return "Square{" +
                " side="+getWidth()+
                " Area="+getArea()
                +"}";
    }

}
