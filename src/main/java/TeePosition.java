public class TeePosition {
    private String color;
    private float rating;
    private int slope;

    public TeePosition(String color, int slope, float rating) {
        this.color = color;
        this.slope = slope;
        this.rating = rating;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getSlope() {
        return slope;
    }

    public void setSlope(int slope) {
        this.slope = slope;
    }
}
