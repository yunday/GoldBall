n, m = map(int, input().split())
a, b, d = map(int, input().split())
ma = []
total_cnt = 1

for i in range(n):
    ma.append(list(map(int, input().split())))

dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
direction = [0, 1, 2, 3]
direction_new = [3, 0, 1, 2]
back_d = [2, 3, 0, 1]
turn_time = 0

while True:
    if turn_time == 4:
        c = 0
        a_new = a + dx[back_d[d]]
        b_new = b + dy[back_d[d]]
        if ma[a_new][b_new] == 1:
            break
        else:
            a = a_new
            b = b_new
    else:
        d = direction_new[d]
        a_new = a + dx[d]
        b_new = b + dy[d]
        if ma[a_new][b_new] == 0:
            ma[a_new][b_new] = 2
            a = a_new
            b = b_new
            total_cnt += 1
            continue
        turn_time += 1

print(total_cnt)
