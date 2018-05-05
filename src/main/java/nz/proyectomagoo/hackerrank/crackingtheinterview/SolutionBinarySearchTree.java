// Pablo Sosa (psosa_ar@yahoo.com)
// 3/05/18

package nz.proyectomagoo.hackerrank.crackingtheinterview;

public class SolutionBinarySearchTree {

  public boolean checkBST(Node root) {
    validate(root);
    if (root == null) {
      return true;
    }
    return rootGreaterThanAllLeft(root.data, root.left)
      && rootSmallerThanAllRight(root.data, root.right)
      && checkBST(root.left)
      && checkBST(root.right)
      ;
  }

  public boolean rootGreaterThanAllLeft(int root, Node subTree) {
    if (subTree == null) {
      return true;
    }
    return root > max(subTree);
  }

  public boolean rootSmallerThanAllRight(int root, Node subTree) {
    if (subTree == null) {
      return true;
    }
    return root < min(subTree);
  }

  public int max(Node subTree) {
    if (subTree == null) {
      return -1;
    }
    int root = subTree.data;
    int maxLeft = max(subTree.left);
    int maxRight = max(subTree.right);

    return Math.max(root, Math.max(maxLeft, maxRight));
  }

  public int min(Node subTree) {
    if (subTree == null) {
      return 10000;
    }
    int root = subTree.data;
    int minLeft = min(subTree.left);
    int minRight = min(subTree.right);

    return Math.min(root, Math.min(minLeft, minRight));
  }

  private void validate(Node root) {
    if (root == null) {
      return;
    }
    if (root.data < 0 || root.data > 10000) {
      throw new IllegalArgumentException("Value " + root.data + " outside valid range [1:10000]");
    }
    validate(root.left);
    validate(root.right);
  }

}
