package theme4_graph;

import java.util.List;
import java.util.Stack;

/**
 * Description : 위상 정렬 :: DFS 기반 recuresion
 *  위상 정렬 가능 조건
 *      - 순환 x : DFS를 통해 확인 가능 / 조상으로 가는 간선이 없어야 함
 *      - 즉, 순환이 없는 방향 그래프의 경우 위상 정렬 가능
 *  s : 모든 노드를 돌기 위한 시작점
 *      - 진입 간선이 없는 노드들로 연결됨
 */

public class TopologicalSort {

    Stack<Node> stack;

    public TopologicalSort() {
        stack = new Stack<>();
    }

    public void topologicalSort(Node v) {

        List<Node> neighbours = v.getNeighbours();

        for (Node neighbour : neighbours) {
            Node w = neighbour;

            if (w != null && !w.visited) {
                w.visited = true;
                topologicalSort(w);
            }
        }
        stack.push(v);

    }

    public static void main(String[] args) {

        TopologicalSort topologicalSort = new TopologicalSort();

        Node node0 = new Node(0);

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node0.addNeighbours(node1);
        node0.addNeighbours(node3);

        node1.addNeighbours(node2);
        node1.addNeighbours(node4);
        node2.addNeighbours(node4);
        node2.addNeighbours(node6);
        node3.addNeighbours(node4);
        node3.addNeighbours(node5);
        node4.addNeighbours(node6);
        node5.addNeighbours(node6);
        node5.addNeighbours(node7);
        node6.addNeighbours(node7);

        System.out.println("위상 정렬 순서: ");
        node0.visited = true;

        topologicalSort.topologicalSort(node0);

        Stack<Node> result = topologicalSort.stack;

        while (result.empty() == false)
            System.out.print(result.pop() + " ");
    }

}
