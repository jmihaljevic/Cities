public class Rocket extends BaseObject {
    public Rocket(double x, double y) {
        super(x, y, 1);
    }
    @Override
    public void move() {
        double y0 = getY();
        setY(y0 - 1);
    }
    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(getX(), getY(), 'R');
    }
}