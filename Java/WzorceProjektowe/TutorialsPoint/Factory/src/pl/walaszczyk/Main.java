package pl.walaszczyk;

public class Main {

    public static void main(String[] args) {
	    ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.makeShape(ShapeTypeEnum.CIRCLE).draw();
        shapeFactory.makeShape(ShapeTypeEnum.RECTANGLE).draw();
        shapeFactory.makeShape(ShapeTypeEnum.SQUARE).draw();
    }
}
