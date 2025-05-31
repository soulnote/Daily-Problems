public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // Start from square 1
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size(); // All positions reachable with current number of moves
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == n * n) {
                    return moves; // Reached final square
                }

                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                    int[] pos = getCoordinates(next, n);
                    int r = pos[0], c = pos[1];

                    int destination = board[r][c] == -1 ? next : board[r][c];

                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            moves++;
        }

        return -1; // Not reachable
    }

    // Convert square number to board coordinates, considering Boustrophedon style
    private int[] getCoordinates(int square, int n) {
        int quot = (square - 1) / n;
        int rem = (square - 1) % n;

        int row = n - 1 - quot;
        int col = (quot % 2 == 0) ? rem : (n - 1 - rem);

        return new int[]{row, col};
    }
}
