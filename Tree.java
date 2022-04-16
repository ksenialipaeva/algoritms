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
        return check(v.getLeftChild(), min, v.getValue()) && check(v.getRightChild(), v.getValue(), max);
    }

    public void insertNode(int key, int left, int right, int i) {
        Node newNode = new Node();
        this.NodeList[i] = newNode;
        this.NodeList[i].setValue(key);
        if (left > -1){
            this.NodeList[i].setLeftChild(this.NodeList[left]);
        }
        if (right > -1) {
            this.NodeList[i].setRightChild(this.NodeList[right]);
        }
    }
}