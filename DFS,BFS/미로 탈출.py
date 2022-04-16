from collections import deque

n, m = map(int, input().split())
mazeMap = [list(map(int, input())) for _ in range(n)]


def BFS(x, y):
    queue = deque()
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    queue.append((x, y))
    while True:
        if not queue:
            break
        v = queue.popleft()
        x, y = v[0], v[1]
        for i in range(4):
            newX = x + dx[i]
            newY = y + dy[i]
            if newX < 0 or newX > n-1 or newY < 0 or newY > m-1:
                continue
            if mazeMap[newX][newY] == 1:
                queue.append((newX, newY))
                mazeMap[newX][newY] = mazeMap[x][y] + 1
    return mazeMap[n-1][m-1]


print(BFS(0, 0))


# 최단경로 구하는건, BFS로 했을 때 너비로 어디로 가든지간에 현재 위치는 전 까지의 최단경로의 +1이라는 점
