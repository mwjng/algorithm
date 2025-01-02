import java.util.*;

class Solution {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int[][] map = new int[101][101];

    static class Node {
        int x, y, cnt;
        Node(int x, int y, int cnt) {
            this.x=x;
            this.y=y;
            this.cnt=cnt;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        for(int i = 0; i < rectangle.length; i++) {
            for(int j = 0; j < rectangle[i].length; j++) {
                rectangle[i][j] *= 2;
            }
            for(int x = rectangle[i][0]; x <= rectangle[i][2]; x++) {
                for(int y = rectangle[i][1]; y <= rectangle[i][3]; y++) {
                    if(x == rectangle[i][0] || x == rectangle[i][2] || y == rectangle[i][1] || y == rectangle[i][3]) {
                        if(map[x][y] == 0) {
                            map[x][y] = 1;
                        }
                    } else {
                        map[x][y] = -1;
                    }
                }
            }
        }

        answer = bfs(characterX, characterY, itemX, itemY) / 2;
        return answer;
    }

    public int bfs(int x, int y, int ix, int iy) {
        int result = Integer.MAX_VALUE;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x, y, 0));
        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.x == ix && node.y == iy) {
                result = Math.min(result, node.cnt);
            }
            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx < 0 || ny < 0 || nx > 100 || ny > 100 || map[nx][ny] != 1) continue;
                map[nx][ny] = -1;
                q.offer(new Node(nx, ny, node.cnt+1));
            }
        }
        return result;
    }
}