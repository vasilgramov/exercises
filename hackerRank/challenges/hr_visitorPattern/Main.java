package hackerRank.challenges.hr_visitorPattern;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Tree root = solve();

        TreeVis vis1 = new SumInLeavesVisitor();
        TreeVis vis2 = new ProductOfRedNodesVisitor();
        TreeVis vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        System.out.println(vis1.getResult());
        System.out.println(vis2.getResult());
        System.out.println(vis3.getResult());
    }

    public static Tree solve() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nodeValues = new int[n];
        for (int i = 0; i < n; i++) {
            nodeValues[i] = in.nextInt();
        }

        Color[] nodeColors = new Color[n];
        for (int i = 0; i < n; i++) {
            nodeColors[i] = Color.values()[in.nextInt()];
        }

        Map<Integer, List<Integer>> childrenByParent = new HashMap<>();
        boolean[] hasParent = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;

            List<Integer> children = childrenByParent.get(u) == null ? new ArrayList<Integer>() : childrenByParent.get(u);
            children.add(v);
            childrenByParent.put(u, children);

            hasParent[v] = true;
        }

        int rootIndex = -1;
        for (int i = 0; i < hasParent.length; i++) {
            if (!hasParent[i]) {
                rootIndex = i;
                break;
            }
        }

        // root wil always have children
        TreeNode root = new TreeNode(nodeValues[rootIndex], nodeColors[rootIndex], 0);
        dfs(root, rootIndex, nodeValues, nodeColors, childrenByParent);

        return root;
    }

    private static void dfs(TreeNode node, int index, int[] nodeValues, Color[] nodeColors, Map<Integer, List<Integer>> tree) {
        List<Integer> children = tree.get(index);

        for (Integer nodeIndex : children) {

            // check if node IS A leaf
            if (tree.get(nodeIndex) == null) {
                Tree leaf = new TreeLeaf(nodeValues[nodeIndex], nodeColors[nodeIndex], node.getDepth() + 1);
                node.addChild(leaf);
            } else {
                TreeNode treeNode = new TreeNode(nodeValues[nodeIndex], nodeColors[nodeIndex], node.getDepth() + 1);
                node.addChild(treeNode);

                dfs(treeNode, nodeIndex, nodeValues, nodeColors, tree);
            }
        }
    }
}
