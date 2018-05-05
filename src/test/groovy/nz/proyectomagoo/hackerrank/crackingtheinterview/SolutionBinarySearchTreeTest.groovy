package nz.proyectomagoo.hackerrank.crackingtheinterview

import nz.proyectomagoo.hackerrank.crackingtheinterview.Node
import nz.proyectomagoo.hackerrank.crackingtheinterview.SolutionBinarySearchTree
import spock.lang.Specification
import spock.lang.Unroll

class SolutionBinarySearchTreeTest extends Specification {

  @Unroll
  void "Given invalid BST #description then an error #expected is returned"() {
    when:
    new SolutionBinarySearchTree().checkBST(tree)
    then:
    thrown(expected)
    where:
    description                                  || expected                || tree
    "containing negative values"                  | IllegalArgumentException | new Node(-1)
    "containing negative values on left subtree"  | IllegalArgumentException | new Node(5, new Node(-1), null)
    "containing negative values on right subtree" | IllegalArgumentException | new Node(5, null, new Node(-1))
  }

  @Unroll
  void "Given valid binary tree (#iterationCount)#description then #expected is returned"() {
    when:
    boolean answer = new SolutionBinarySearchTree().checkBST(tree)
    then:
    answer == expected
    where:
    description                                                                             || expected || tree
    "that is a correct BST"                                                                  | true      | new Node(3, new Node(2), new Node(4))
    "that is not a BST if left subtree is not"                                               | false     | new Node(3, new Node(2, new Node(1), new Node(1)), new Node(4))
    "that is not a BST if right subtree is not"                                              | false     | new Node(3, new Node(2), new Node(4, new Node(6), new Node(6)))
    "that is a BST even if unbalanced"                                                       | true      | new Node(2, new Node(1), new Node(3, null, new Node(4, null, new Node(5, null, new Node(6)))))
    "that is a BST when single noded"                                                        | true      | new Node(2)
    "that is not a BST cause root is not greater than the max of the left with node repeat"  | false     | new Node(5, new Node(4, new Node(3), new Node(5)), null)
    "that is not a BST cause root is not greater than the max of the left"                   | false     | new Node(5, new Node(4, new Node(3), new Node(6)), null)

    "that is not a BST cause root is not smaller than the max of the right"                  | false     | new Node(5, null, new Node(6, new Node(4), new Node(7)))
    "that is not a BST cause root is not smaller than the max of the right with node repeat" | false     | new Node(5, null, new Node(5, new Node(4), new Node(7)))
  }

  /*

  8 pass
  6 fail

           5
         -   6
            4  7

           5
         4    -
       3   6
   */
}
