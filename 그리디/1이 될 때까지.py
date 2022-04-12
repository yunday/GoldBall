# 내가 푼 풀이
# import math
#
# n, k = map(int, input().split())
# cnt = (n % k) + int(math.log(n-(n % k), k))
# print(cnt)

# 정석
n, k = map(int, input().split())
cnt = 0
while n > 1:
    if n % k != 0:
        n -= 1
        cnt += 1
    else:
        n //= k
        cnt += 1
print(cnt)
