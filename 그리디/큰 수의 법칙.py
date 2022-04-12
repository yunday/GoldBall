n, m, k = map(int, input().split())
lst = list(map(int, input().split()))
lst.sort()
cnt = 0

# 두 숫자만 쓴다는걸 캐치하고 더 쉽게 함.......
a = lst[n-1]
b = lst[n-2]
cnt += (m // (k+1)) * (a*k + b)
cnt += (m % (k+1)) * a

print(cnt)