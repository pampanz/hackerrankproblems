// Pablo Sosa (psosa_ar@yahoo.com)
// 3/05/18
package nz.proyectomagoo.hackerrank.crackingtheinterview;


public class Node {
   int data;
   Node left;
   Node right;

  public Node(int data, Node left, Node right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
  public Node(int data) {
    this.data = data;
  }

  public Node(Integer data, Node left, Node right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }
}
