n = input()
x = n[0]
y = int(n[1])

alpha = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
for i in alpha:
    if i == x:
        x = alpha.index(i)+1

# 아스키 코드 변환 ord()
# x = int(ord(n[0])) - int(ord('a')) + 1

dx = [2, 2, -2, -2, 1, -1, 1, -1]
dy = [-1, 1, -1, 1, 2, 2, -2, -2]
cnt = 0

# steps = [(2, -1), (2, 1), ...] 이렇게 표현 가능

for i in range(len(dx)):
    if 9 > x + dx[i] > 0 and 9 > y + dy[i] > 0:
        cnt += 1

print(cnt)
