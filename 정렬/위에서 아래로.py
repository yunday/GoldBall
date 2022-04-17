n = int(input())
numList = [int(input()) for _ in range(n)]

for i in sorted(numList, reverse=True):
    print(i, end=' ')
