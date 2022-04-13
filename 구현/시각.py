# n = int(input())
# cnt = 0
#
# for i in range(n+1):
#     if '3' in str(i):
#         cnt += 60 * 60
#     else:
#         cnt += 15 * 60
#         cnt += 45 * 15
#
# print(cnt)

# 검사할 것이 심하게 크지 않아서 완전 탐색 가능. 이럴때 써라..
n = int(input())
cnt = 0

for i in range(n+1):
    for j in range(60):
        for k in range(60):
            if '3' in str(i) + str(j) + str(k):
                cnt += 1

print(cnt)
