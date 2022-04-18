n = int(input())
nNumber = list(map(int, input().split()))
count = [0] * (max(nNumber)+1)

m = int(input())
mNumber = list(map(int, input().split()))

for i in nNumber:
    count[i] += 1
for j in mNumber:
    if count[j] > 0:
        print('yes', end=' ')
    else:
        print('no', end=' ')
