# def dfs(x, y):
#     iceMap[x][y] = 2
#     for k in range(4):
#         newX = x + dx[k]
#         newY = y + dy[k]
#         if newX < 0 or newX > n-1 or newY < 0 or newY > m-1:
#             continue
#         if iceMap[newX][newY] == 0:
#             dfs(newX, newY)

# 재귀니깐.. 모든방향 재귀로
def dfs(x, y):
    if x < 0 or x > n - 1 or y < 0 or y > m - 1:
        return False
    if iceMap[x][y] == 0:
        iceMap[x][y] = 2
        dfs(x-1, y)
        dfs(x, y+1)
        dfs(x+1, y)
        dfs(x, y-1)
        return True
    return False


dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
n, m = map(int, input().split())
iceMap = [list(map(int, input())) for _ in range(n)]
iceCount = 0

for i in range(n):
    for j in range(m):
        if iceMap[i][j] == 0:
            if dfs(i, j):
                iceCount += 1

print(iceCount)
