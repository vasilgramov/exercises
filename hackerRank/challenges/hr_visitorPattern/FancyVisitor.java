package hackerRank.challenges.hr_visitorPattern;

public class FancyVisitor extends TreeVis {

    private int sumOfGreenLeafs;
    private int sumOfNonLeavesWithEvenDepth;

    @Override
    public int getResult() {
        return Math.abs(this.sumOfGreenLeafs - this.sumOfNonLeavesWithEvenDepth);
    }

    @Override
    public void visitNode(TreeNode treeNode) {
        if (treeNode.getDepth() % 2 == 0)
            this.sumOfNonLeavesWithEvenDepth += treeNode.getValue();
    }

    @Override
    public void visitLeaf(TreeLeaf treeLeaf) {
        if (treeLeaf.getColor() == Color.GREEN)
            this.sumOfGreenLeafs += treeLeaf.getValue();
    }
}
