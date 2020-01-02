public class Bomb extends BaseObject {
    public Bomb(double x, double y) {
        super(x, y, 1);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(getX(), getY(), 'B');
    }

    @Override
    public void move() {
        double y0 = getY();
        setY(y0 + 1);
    }
}