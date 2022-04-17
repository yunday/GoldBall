array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    minVal = i
    for j in range(i+1, len(array)):
        if array[j] < array[minVal]:
            minVal = j
    # 스와프, 리스트 주어졌을 때 두 변수의 위치 변경 (파이썬만 됨)
    array[i], array[minVal] = array[minVal], array[i]

print(array)
