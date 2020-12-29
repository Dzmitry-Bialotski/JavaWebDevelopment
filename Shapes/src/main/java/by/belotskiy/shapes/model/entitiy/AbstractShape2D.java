package by.belotskiy.shapes.model.entitiy;

public abstract class AbstractShape2D {

    private long shapeId;

    public AbstractShape2D(long shapeId) {
        this.shapeId = shapeId;
    }

    public long getShapeId() {
        return shapeId;
    }

    public void setShapeId(long shapeId) {
        this.shapeId = shapeId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractShape2D{");
        sb.append("shapeId='").append(shapeId).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
