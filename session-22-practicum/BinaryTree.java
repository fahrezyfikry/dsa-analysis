class Node {
  int data;
  Node left, right;

  Node(int item) {
    data = item;
    left = right = null;
  }
}

class BinaryTree {
  Node root;

  BinaryTree() {
    root = null;
  }

  void inorderTraversal(Node node) {
    if (node == null) {
      return;
    }

    inorderTraversal(node.left);
    System.out.print(node.data + " ");
    inorderTraversal(node.right);
  }

  void preorderTraversal(Node node) {
    if (node == null) {
      return;
    }

    System.out.print(node.data + " ");
    preorderTraversal(node.left);
    preorderTraversal(node.right);
  }

  void postorderTraversal(Node node) {
    if (node == null) {
      return;
    }

    postorderTraversal(node.left);
    postorderTraversal(node.right);
    System.out.print(node.data + " ");
  }

  void insert(int data) {
    root = insertRec(root, data);
  }

  Node insertRec(Node root, int data) {
    if (root == null) {
      root = new Node(data);
      return root;
    }

    if (data < root.data) {
      root.left = insertRec(root.left, data);
    } else if (data > root.data) {
      root.right = insertRec(root.right, data);
    }

    return root;
  }

  Node search(Node root, int key) {
    if (root == null || root.data == key) {
      return root;
    }

    if (root.data > key) {
      return search(root.left, key);
    }

    return search(root.right, key);
  }

  Node deleteNode(Node root, int key) {
    if (root == null) {
      return root;
    }

    if (key < root.data) {
      root.left = deleteNode(root.left, key);
    } else if (key > root.data) {
      root.right = deleteNode(root.right, key);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }

      root.data = minValue(root.right);
      root.right = deleteNode(root.right, root.data);
    }

    return root;
  }

  int minValue(Node root) {
    int minv = root.data;
    while (root.left != null) {
      minv = root.left.data;
      root = root.left;
    }
    return minv;
  }

  int getHeight(Node node) {
    if (node == null) {
      return 0;
    } else {
      int leftHeight = getHeight(node.left);
      int rightHeight = getHeight(node.right);

      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();

    tree.root = new Node(50);
    tree.root.left = new Node(30);
    tree.root.right = new Node(70);
    tree.root.left.left = new Node(20);
    tree.root.left.right = new Node(40);
    tree.root.right.left = new Node(60);
    tree.root.right.right = new Node(80);

    System.out.println("Inorder traversal:");
    tree.inorderTraversal(tree.root);
    System.out.println("\nPreorder traversal:");
    tree.preorderTraversal(tree.root);
    System.out.println("\nPostorder traversal:");
    tree.postorderTraversal(tree.root);

    int key = 40;
    Node result = tree.search(tree.root, key);
    if (result != null) {
      System.out.println("\nElement " + key + " found in the tree.");
    } else {
      System.out.println("\nElement " + key + " not found in the tree.");
    }

    System.out.println("Height of the tree: " + tree.getHeight(tree.root));
  }
}