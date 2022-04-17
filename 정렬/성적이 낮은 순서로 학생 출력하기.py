n = int(input())
nameGrade = []
for i in range(n):
    t = input().split()
    nameGrade.append((t[0], int(t[1])))

sortGrade = sorted(nameGrade, key=lambda l: l[1])
for j in sortGrade:
    print(j[0], end=' ')
