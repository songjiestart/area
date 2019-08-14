import java.util.Objects;

/**
 * @Author: songjie
 * @Date: 2019-08-14 14:11
 * @Description:
 */
public class Tree {
    public static void main(String[] args) {
        Node node =
                new Node(1,
                        new Node(2,
                                new Node(4,
                                        new Node(6),
                                        new Node(7)),
                                new Node(5)),
                        new Node(3,
                                new Node(8),
                                new Node(9)));

        get(node,new Node(6),new Node(4));
        System.out.println("targetNode:"+target.getMe());


    }
    private static boolean complete = false;
    private static boolean flagMe = false;
    private static boolean update = false;
    private static Node target = null;

    private static void get(Node node,Node a,Node b) {
        if (complete || node == null) {
            return;
        }
        System.out.println("进入Node"+node.getMe());

        if (node.equals(a) || node.equals(b)) {
            if (flagMe) {
                complete = true;
                return;
            } else {
                target = node;
                flagMe = true;
            }
        }
        get(node.getLeft(), a, b);
        if (update) {
            target = node;
            update = false;
        }
        get(node.getRight(), a, b);
        if (!complete && target == node) {
            update = true;
        }

    }

    static class Node {
        private int me;
        private Node left;
        private Node right;

        public Node(int me) {
            this.me = me;
        }

        public Node(int me, Node left, Node right) {
            this.me = me;
            this.left = left;
            this.right = right;
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

        public int getMe() {
            return me;
        }

        public void setMe(int me) {
            this.me = me;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return me == node.me;
        }

        @Override
        public int hashCode() {
            return Objects.hash(me);
        }
    }
}
