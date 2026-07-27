/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    
    int preIndex;
    HashMap<Integer, Integer> map;

    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        preIndex = 0;
        map = new HashMap<>();

        for (int i = 0; i < preMirror.length; i++) {
            map.put(preMirror[i], i);
        }

        return build(pre, preMirror, 0, preMirror.length - 1);
    }

    private Node build(int[] pre, int[] preMirror, int l, int r) {

        if (preIndex >= pre.length || l > r)
            return null;

        Node root = new Node(pre[preIndex++]);

        // Leaf node
        if (l == r || preIndex >= pre.length)
            return root;

        // Next preorder element is left child
        int nextVal = pre[preIndex];

        // Find this node in mirror preorder
        int idx = map.get(nextVal);

        // Right subtree in mirror is [l+1 ... idx-1]
        root.left = build(pre, preMirror, idx, r);
        root.right = build(pre, preMirror, l + 1, idx - 1);

        return root;
    }
}