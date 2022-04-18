def binarySearch(start, end, array, target):
    while start <= end:
        mid = (start+end) // 2
        if array[mid] == target:
            return mid
        elif array[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    return None


array = [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]
print(binarySearch(0, len(array)-1, array, 4))