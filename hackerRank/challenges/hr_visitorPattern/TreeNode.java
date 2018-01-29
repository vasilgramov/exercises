package hackerRank.challenges.hr_visitorPattern;

import java.util.ArrayList;
import java.util.List;

public class TreeNode extends Tree {

    private List<Tree> children;

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);

        this.children = new ArrayList<>();
    }

    @Override
    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : this.children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        this.children.add(child);
    }
}
