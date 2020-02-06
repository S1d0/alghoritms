package pl.my.alghoritms.examples.alghoritms;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class BinaryTreeTest {
    BinaryTree myTree;

    @BeforeEach
    public void setUp() {
        myTree = new BinaryTree();
        myTree.add(50, "boss");
        myTree.add(30, "left-left");
        myTree.add(35, "left-right");
        myTree.add(40, "left-right-right");
        myTree.add(20, "left-left-left");
        myTree.add(60, "right");
        myTree.add(55, "right-left");
    }

    @Test
    void add() {
    }

    @Test
    void inOrderTraversal() {
        myTree.inOrderTraversal(myTree.root);
    }

    @Test
    void preOrderTraversal() {
        myTree.preOrderTraversal(myTree.root);
    }

    @Test
    void postOrderTraversal() {
        myTree.postOrderTraversal(myTree.root);
    }

    @Test
    void find() {
        // given
        Node node = myTree.find(20);
        Node node2 = myTree.find(60);

        // expect
        assertEquals(20, node.key);
        assertEquals(60, node2.key);
    }

    @Test
    void shouldDeleteRoot() {
        // givem
        boolean isDeleted = myTree.deleteNode(50);
        Node node = myTree.find(50);

        // expect
        assertTrue(isDeleted);
        assertNull(node);
    }

    @Test
    void shouldDeleteLeaf() {
        // given
        boolean isDeleted = myTree.deleteNode(40);
        Node node = myTree.find(40);

        // expect
        assertTrue(isDeleted);
        assertNull(node);
    }

    @Test
    void shouldDeleteMidElement() {
        // given
        boolean isDeleted = myTree.deleteNode(35);
        Node node = myTree.find(35);

        // expect
        assertTrue(isDeleted);
        assertNull(node);
    }


    @Test
    void should_return_false_when_no_element_to_delete() {
        // given
        boolean isDeleted = myTree.deleteNode(45);
        Node node = myTree.find(45);

        // expect
        assertFalse(isDeleted);
        assertNull(node);
    }



}