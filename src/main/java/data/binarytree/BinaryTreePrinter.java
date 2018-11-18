package data.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BinaryTreePrinter {

    public static String getNodeAsString(BinaryTreeNode root) {
        int maxLevel = BinaryTreePrinter.maxLevel(root);
        StringBuilder sb = new StringBuilder();
        printNodeInternal(Collections.singletonList(root), 1, maxLevel, sb);
        return sb.toString();
    }

    private static void printNodeInternal(List<BinaryTreeNode> nodes, int level, int maxLevel, StringBuilder sb) {
        if (nodes.isEmpty() || BinaryTreePrinter.isAllElementsNull(nodes))
            return;
        
        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BinaryTreePrinter.printWhitespaces(sb, firstSpaces);

        List<BinaryTreeNode> newNodes = new ArrayList<BinaryTreeNode>();
        for (BinaryTreeNode node : nodes) {
            if (node != null) {
            	sb.append(node.getValue());
            	/* Print parent's value
            	if (node.getParent()!=null) {
            		sb.append("("+node.getParent().getValue()+")");
            	}
            	else {
            		sb.append("*");
            	}
            	*/
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                sb.append(" ");
            }

            BinaryTreePrinter.printWhitespaces(sb, betweenSpaces);
        }
        sb.append("\r\n");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BinaryTreePrinter.printWhitespaces(sb, firstSpaces - i);
                if (nodes.get(j) == null) {
                    BinaryTreePrinter.printWhitespaces(sb, endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null)
                    sb.append("/");
                else
                    BinaryTreePrinter.printWhitespaces(sb, 1);

                BinaryTreePrinter.printWhitespaces(sb, i + i - 1);

                if (nodes.get(j).getRight() != null)
                	sb.append("\\");
                else
                    BinaryTreePrinter.printWhitespaces(sb, 1);

                BinaryTreePrinter.printWhitespaces(sb, endgeLines + endgeLines - i);
            }

            sb.append("\r\n");
        }

        printNodeInternal(newNodes, level + 1, maxLevel, sb);
    }

    private static void printWhitespaces(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++)
        	sb.append(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(BinaryTreeNode node) {
        if (node == null)
            return 0;

        return Math.max(BinaryTreePrinter.maxLevel(node.getLeft()), BinaryTreePrinter.maxLevel(node.getRight())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}