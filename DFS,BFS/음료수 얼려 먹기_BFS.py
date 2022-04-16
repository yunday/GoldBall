from collections import deque


def bfs(a, b):
    count = 0
    queue = deque()
    queue.append((a, b))
    ice_map[a][b] = 2
    d_x = [-1, 0, 1, 0]
    d_y = [0, 1, 0, -1]
    while True:
        if not queue:
            count += 1
            break
        v = queue.popleft()
        for k in range(len(d_x)):
            if v[0]+d_x[k] < 0 or v[0]+d_x[k] > n-1 or v[1]+d_y[k] < 0 or v[1]+d_y[k] > m-1:
                continue
            if ice_map[v[0]+d_x[k]][v[1]+d_y[k]] == 0:
                queue.append((v[0]+d_x[k], v[1]+d_y[k]))
                ice_map[v[0]+d_x[k]][v[1]+d_y[k]] = 2
    return count


cnt = 0
n, m = map(int, input().split())
ice_map = [list(map(int, input())) for _ in range(n)]

for i in range(n):
    for j in range(m):
        if ice_map[i][j] == 0:
            cnt += bfs(i, j)

print(cnt)


# 이건 DFS로 풀면 간단한 것이였다...