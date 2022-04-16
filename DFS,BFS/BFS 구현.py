from collections import deque


def bfs(graph, n, visited):
    queue = deque([n])
    visited[n] = True
    while queue:
        a = queue.popleft()
        print(a, end=' ')
        for i in graph[a]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


graph = [[], [2, 3, 8], [1, 7], [1, 4, 5], [3, 5], [3, 4], [7], [2, 6, 8], [1, 7]]
visited = [False]*9

bfs(graph, 1, visited)
