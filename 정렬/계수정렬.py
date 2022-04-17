array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]

index = [0] * (max(array) - min(array) + 1)
for i in array:
    index[i] += 1

for j in range(len(index)):
    for k in range(index[j]):
        print(min(array) + j, end=' ')
