import java.util.ArrayList;
import java.util.List;

// Node structure for tree
class TreeNode {
  int data;
  List<TreeNode> children;

  TreeNode(int x) {
      data = x;
      children = new ArrayList<>();
  }
}

class Tree {
  // Function to add a child to a node
  static void addChild(TreeNode parent, TreeNode child) {
      parent.children.add(child);
  }

  // Function to print parents of each node
  static void printParents(TreeNode node, TreeNode parent) {
      if (parent == null) {
        System.out.println(node.data + " -> NULL");
      } else {
        System.out.println(node.data + " -> " + parent.data);
      }

    for (TreeNode child : node.children) {
      printParents(child, node);
    }
  }

  // Function to print children of each node
  static void printChildren(TreeNode node) {
    System.out.print(node.data + " -> ");
    for (TreeNode child : node.children) {
      System.out.print(child.data + " ");
    }
    System.out.println();

    for (TreeNode child : node.children) {
      printChildren(child);
    }
  }

  // Function to print leaf nodes
  static void printLeafNodes(TreeNode node) {
    if (node.children.isEmpty()) {
        System.out.print(node.data + " ");
        return;
    }
    for (TreeNode child : node.children) {
      printLeafNodes(child);
    }
  }

  // Function to print degrees of each node 
  static void printDegrees(TreeNode node, TreeNode parent) {
    int degree = node.children.size();
    if (parent != null)
        degree++;
    System.out.println(node.data + " -> " + degree);

    for (TreeNode child : node.children) {
      printDegrees(child, node);
    }
  }

  public static void main(String[] args) {
    // Creating nodes
    TreeNode root = new TreeNode(1);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);
    TreeNode n4 = new TreeNode(4);
    TreeNode n5 = new TreeNode(5);

    // Constructing tree
    addChild(root, n2);
    addChild(root, n3);
    addChild(n2, n4);
    addChild(n2, n5);

    System.out.println("Parents of each node:");
    printParents(root, null);

    System.out.println("Children of each node:");
    printChildren(root);

    System.out.print("Leaf nodes: ");
    printLeafNodes(root);
    System.out.println();

    System.out.println("Degrees of nodes:");
    printDegrees(root, null);
  }
}
