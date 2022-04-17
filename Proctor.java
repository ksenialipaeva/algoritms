import mooc.EdxIO;

public class Proctor {
    public static class Tree {
        public Node rootNode;
        public Node[] NodeList;

        public Tree(int n) {
            rootNode = null;
            Node[] List = new Node[n];
            for (int i=0; i<n; i++){
                List[i] = new Node();
            }
            this.NodeList = List;
        }

        public boolean check(Node v, int min, int max) {
            if (v == null) {
                return true;
            }
            if (v.getValue() <= min || max <= v.getValue()) {
                return false;
            }
            boolean res1 = true, res2 = true;
            if (v.getLeftChild() >= 0)
            {res1 = check(NodeList[v.getLeftChild()], min, v.getValue());}
            if (v.getRightChild() >= 0)
            {res2 = check(NodeList[v.getRightChild()], v.getValue(), max);}
            return res1 && res2;
        }

        public void insertNode(int key, int left, int right, int i) {
            Node newNode = new Node();
            this.NodeList[i] = newNode;
            this.NodeList[i].setValue(key);
            if (left > -1){
                this.NodeList[i].setLeftChild(left);
            }
            if (right > -1) {
                this.NodeList[i].setRightChild(right);
            }
        }
    }
    public static class Node {
        private int value;
        private int leftChild;
        private int rightChild;

        public Node() {
            value = 0;
            leftChild = -1;
            rightChild = -1;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(final int value) {
            this.value = value;
        }

        public int getLeftChild() {
            return this.leftChild;
        }

        public void setLeftChild(int leftChild) {
            this.leftChild = leftChild;
        }

        public int getRightChild() {
            return this.rightChild;
        }

        public void setRightChild(int rightChild) {
            this.rightChild = rightChild;
        }

    }

    public static void main(String[] args) {
            try (EdxIO io = EdxIO.create()) {
                int n = io.nextInt();
                Tree tree = new Tree(n);
                for (int i = 0; i < n; i++) {
                    int k = io.nextInt();
                    int l = io.nextInt();
                    int r = io.nextInt();
                    tree.insertNode(k, l-1, r-1, i);
                }
                if (n == 0) {
                    io.print("NO");
                }
                else {
                    tree.rootNode = tree.NodeList[0];
                    boolean result = tree.check(tree.rootNode, -2000000, 2000000);
                    if (result) {
                        io.print("YES");
                    }
                    else {
                        io.print("NO");
                    }
                }
            }
        }
    }