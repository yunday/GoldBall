# n = int(input())
# direction = list(input().split())
# now = [1, 1]
#
# for i in direction:
#     if i == 'R':
#         now[1] += 1
#         if now[1] > n:
#             now[1] -= 1
#     elif i == 'L':
#         now[1] -= 1
#         if now[1] < 1:
#             now[1] += 1
#     elif i == 'U':
#         now[0] -= 1
#         if now[0] < 1:
#             now[0] += 1
#     else:
#         now[0] += 1
#         if now[0] > n:
#             now[0] -= 1
#
# print(str(now[0])+' '+str(now[1]))

n = int(input())
x, y = 1, 1
direction = input().split()

# 항상 디렉션 방향 좌표를 리스트로 두고 for문 으로 추가하기

# L R U D
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
move = ['L', 'R', 'U', 'D']

for i in direction:
    nx, ny = 0, 0
    for j in range(len(move)):
        if i == move[j]:
            nx = x + dx[j]
            ny = y + dy[j]
    if nx < 1 or ny < 1 or nx > n or ny > n:
        continue
    x, y = nx, ny

print(x, y)