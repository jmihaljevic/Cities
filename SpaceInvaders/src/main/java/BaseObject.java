public abstract class BaseObject {
    public double x;
    public double y;
    public double radius;
    public boolean isAlive;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isAlive = true;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getRadius() {
        return radius;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean isAlive() {
        return isAlive;
    }
    public void move(){

    }
    public void draw(Canvas canvas) {

    }
    public void die() {
        isAlive = false;
    }
    public boolean intersects(BaseObject o) {
        float distance = (float) Math.sqrt((float) Math.pow((float) this.getX() - o.getX(), 2) + (float) Math.pow((float) this.getY() - o.getY(), 2));
        double radious = o.getRadius();
        if(radious < this.getRadius()) radious = this.getRadius();
        if(distance < radious) return true;
        return false;
    }
    public void checkBorders(double minx, double maxx, double miny, double maxy) {
        if (x < minx) x = minx;
        if (x > maxx) x = maxx;
        if (y < miny) y = miny;
        if (y > maxy) y = maxy;
    }
}