package pl.my.alghoritms.examples.alghoritms;

public class BinaryTree {
    Node root;

    void add(int key, String data) {
        Node newNode = new Node(key, data);
        if (root == null) {
            root = new Node(key, data);
        } else {
            recursiveAdd(root, newNode);
        }
    }

    private void recursiveAdd(Node parent, Node newNode) {
        if (parent.key > newNode.key) {
            if (parent.leftNode != null) {
                recursiveAdd(parent.leftNode, newNode);
            } else {
                parent.leftNode = newNode;
            }
        } else {
            if (parent.rightNode != null) {
                recursiveAdd(parent.rightNode, newNode);
            } else {
                parent.rightNode = newNode;
            }
        }
    }

    void inOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.leftNode);
            System.out.println(focusNode.key);
            inOrderTraversal(focusNode.rightNode);
        }
    }

    void preOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode.key);
            preOrderTraversal(focusNode.leftNode);
            preOrderTraversal(focusNode.rightNode);
        }
    }

    void postOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            preOrderTraversal(focusNode.leftNode);
            preOrderTraversal(focusNode.rightNode);
            System.out.println(focusNode.key);
        }
    }

    Node find(int key) {
        if (root.key == key) {
            return root;
        }
        return recursiveFind(root, key);
    }

    private Node recursiveFind(Node focusNode, int key) {
        if (focusNode != null) {
            if (focusNode.key == key) {
                return focusNode;
            } else if (focusNode.key > key) {
                return recursiveFind(focusNode.leftNode, key);
            } else {
                return recursiveFind(focusNode.rightNode, key);
            }
        } else return null;
    }

    boolean deleteNode(int deleteKey) {
        Node replacement;
        if (root == null) {
            return false;
        }

        // Przypadek usuniecia pnia
        if (deleteKey == root.key) {
            if (root.rightNode != null) {
                replacement = root.rightNode;
                replacement.leftNode = root.leftNode;
                root = replacement;
            } else if (root.leftNode != null) {
                root = root.leftNode;
            }
            return true;
        }
        return recursiveDelete(root, root, deleteKey);
    }

    private boolean recursiveDelete(Node parent, Node focusNode, int deleteKey) {
        // Przypadek gdy nie ma podanej wartosci w drzewie
        if (focusNode == null) {
            return false;
        }
        if (focusNode.key > deleteKey) {
            parent = focusNode;
            return recursiveDelete(parent, focusNode.leftNode, deleteKey);
        } else if (focusNode.key < deleteKey) {
            parent = focusNode;
            return recursiveDelete(parent, focusNode.rightNode, deleteKey);
        }

        System.out.println("Parent: " + parent);
        System.out.println("Focus: " + focusNode);

        // Przypadek liść:
        if (focusNode.rightNode == null && focusNode.leftNode == null) {
            if (parent.leftNode == focusNode) {
                parent.leftNode = null;
                return true;
            } else if (parent.rightNode == focusNode) {
                parent.rightNode = null;
                return true;
            }
        }

        // Każdy inny przypadek
        Node replacement = focusNode.rightNode != null ? focusNode.rightNode : focusNode.leftNode;
        if (parent.rightNode == focusNode) {
            parent.rightNode = replacement;
        } else {
            parent.leftNode = replacement;
        }
        return true;
    }
}


class Node {
    int key;
    String data;
    Node leftNode;
    Node rightNode;

    public Node(int key, String data) {
        this.key = key;
        this.data = data;
    }

    int getKey() {
        return key;
    }

    String getDate() {
        return data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", data='" + data + '\'' +
                '}';
    }
}