import mooc.*;

public class Application {
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
