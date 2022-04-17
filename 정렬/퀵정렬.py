array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]


def quick(start, end):
    if start+1 >= end:
        return
    pivot = start
    stateStart = 0
    stateEnd = 0
    firstStart = start - 1
    firstEnd = end
    while end >= start:
        if array[start] < array[pivot]:
            start += 1
        else:
            stateStart = 1
        if array[end] > array[pivot]:
            end -= 1
        else:
            stateEnd = 1
        if stateStart == 1 and stateEnd == 1:
            array[end], array[start] = array[start], array[end]
            stateStart, stateEnd = 0, 0
    array[end], array[pivot] = array[pivot], array[end]
    pivot = end
    quick(firstStart, pivot-1)
    quick(pivot + 1, firstEnd)


quick(0, len(array)-1)
print(array)
