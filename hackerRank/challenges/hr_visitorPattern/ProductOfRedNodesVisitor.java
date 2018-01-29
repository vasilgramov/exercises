package hackerRank.challenges.hr_visitorPattern;

public class ProductOfRedNodesVisitor extends TreeVis {

    private final int M = 1000000007;
    private int result;

    public ProductOfRedNodesVisitor() {
        this.result = 1;
    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public void visitNode(TreeNode treeNode) {
        if(treeNode.getColor() == Color.RED)
            this.result = (this.result * treeNode.getValue()) % M;
    }

    @Override
    public void visitLeaf(TreeLeaf treeLeaf) {
        if (treeLeaf.getColor() == Color.RED)
            this.result = (this.result * treeLeaf.getValue()) % M;
    }
}
