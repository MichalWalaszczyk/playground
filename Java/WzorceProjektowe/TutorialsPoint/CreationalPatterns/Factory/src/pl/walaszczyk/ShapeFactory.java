package pl.walaszczyk;

public class ShapeFactory {

    public Shape makeShape(ShapeTypeEnum shapeType) {
        makeSureThatShapeTypeIsNotNull(shapeType);
        return getShape(shapeType);
    }

    private void makeSureThatShapeTypeIsNotNull(ShapeTypeEnum shapeType) {
        if (shapeType == null) {
            throw new IllegalArgumentException("Shape type must not be null.");
        }
    }

    private Shape getShape(ShapeTypeEnum shapeType) {
        switch (shapeType) {
            case CIRCLE:
                return new Circle();
            case SQUARE:
                return new Square();
            case RECTANGLE:
                return new Rectangle();
            default:
                throw new IllegalArgumentException("Provided shape type does not exist.");
        }
    }
}
