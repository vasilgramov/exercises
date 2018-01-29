package hackerRank.challenges.hr_visitorPattern;

public abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return this.value;
    }

    public Color getColor() {
        return this.color;
    }

    public int getDepth() {
        return this.depth;
    }

    public abstract void accept(TreeVis visitor);
}
