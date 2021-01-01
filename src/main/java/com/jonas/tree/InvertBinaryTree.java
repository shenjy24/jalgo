package com.jonas.tree;

import com.jonas.util.TreeNode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @author shenjy 2018/12/24
 */
public class InvertBinaryTree {

    public static TreeNode invert(TreeNode root) {
        if (null == root) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
        return root;
    }
}
