class Node {
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