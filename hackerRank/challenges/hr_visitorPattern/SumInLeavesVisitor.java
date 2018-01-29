package hackerRank.challenges.hr_visitorPattern;

public class SumInLeavesVisitor extends TreeVis {

    private int result;

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public void visitNode(TreeNode treeNode) {
        // do nothing
    }

    @Override
    public void visitLeaf(TreeLeaf treeLeaf) {
        this.result += treeLeaf.getValue();
    }
}
