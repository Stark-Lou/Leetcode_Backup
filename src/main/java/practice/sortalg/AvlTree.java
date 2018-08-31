package practice.sortalg;

/**
 * AVL树的实现
 * 实现了平衡二叉树的插入
 * TODO 实现删除操作
 *
 * @param <T>
 */
public class AvlTree<T extends Comparable<T>> {

    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree();
        AvlNode head = null;
        for (int i = 1; i < 20; i++) {
            head = avlTree.insert(i, head);
        }
    }

    static class AvlNode<T extends Comparable<T>> implements Comparable<T> {
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;

        AvlNode(T node) {
            this(node, null, null);
        }

        AvlNode(T element, AvlNode<T> lt, AvlNode<T> rt) {
            this.element = element;
            left = lt;
            right = rt;
            height = 0;
        }

        @Override
        public int compareTo(T o) {
            return element.compareTo(o);
        }
    }

    private int height(AvlNode<T> t) {
        return t == null ? -1 : t.height;
    }

    private AvlNode<T> find(T x, AvlNode<T> root) {
        int result = x.compareTo(root.element);
        if (result == 0) {
            return root;
        }
        if (result > 0) {
            return find(x, root.right);
        } else {
            return find(x, root.left);
        }
    }

    private AvlNode<T> insert(T x, AvlNode<T> t) {
        if (t == null) return new AvlNode<T>(x, null, null);
        int compareResult = compare(x, t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
            if (height(t.left) - height(t.right) == 2) {
                if (compare(x, t.left.element) < 0) {
                    t = rotateWithLeftChild(t);
                } else {
                    t = doubleWithLeftChild(t);
                }
            }
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
            if (height(t.right) - height(t.left) == 2) {
                if (compare(x, t.right.element) > 0) {
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {
        AvlNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.right), height(k1.left)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<T> doubleWithRightChild(AvlNode<T> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    private int compare(T x, T element) {
        return x.compareTo(element);
    }


}
