class Tree {
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

    /*public int height(Node v) {
        if (v == null)
        {
            return 0;
        }
        System.out.println(v.getValue());
        int h1 = height(v.getLeftChild());
        int h2 = height(v.getRightChild());
        System.out.print(h1);
        System.out.print(" ");
        System.out.println(h2);
        return Math.max(h1, h2) + 1;
    }*/
}