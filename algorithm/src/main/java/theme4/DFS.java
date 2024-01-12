package theme4;

import java.util.List;

// 재귀 == stack or queue loop 이라고 생각 가능!
// 방문 -> visited
// 다음 탐색 :
//  1. 재귀 - 함수 호출
//  2. 스택 / 큐 loop

public class DFS {

    public static void DFS(Node v) {

        System.out.print(v.info + " ");

        v.visited = true;
        List<Node> neighbours = v.neighbours;

        for (int i = 0; i < neighbours.size(); i++) {
            Node w = neighbours.get(i);
            if (w.visited == false && w != null) {
                DFS(w);
            }

        }
    }

    public static void main(String[] args) {

        Node[] nodes = new Node[6];

        for (int i = 0; i < 6; i++) {
            nodes[i] = new Node(i + 1);
        }

        nodes[0].addNeighbours(nodes[1]);
        nodes[0].addNeighbours(nodes[2]);
        nodes[0].addNeighbours(nodes[4]);
        nodes[1].addNeighbours(nodes[0]);
        nodes[1].addNeighbours(nodes[2]);
        nodes[2].addNeighbours(nodes[0]);
        nodes[2].addNeighbours(nodes[1]);
        nodes[2].addNeighbours(nodes[3]);
        nodes[2].addNeighbours(nodes[4]);
        nodes[3].addNeighbours(nodes[2]);
        nodes[3].addNeighbours(nodes[5]);
        nodes[4].addNeighbours(nodes[0]);
        nodes[4].addNeighbours(nodes[2]);
        nodes[5].addNeighbours(nodes[2]);
        nodes[5].addNeighbours(nodes[3]);

        System.out.println("재귀를 사용한 깊이 우선 탐색 실행 결과");
        DFS(nodes[0]);
    }
}
