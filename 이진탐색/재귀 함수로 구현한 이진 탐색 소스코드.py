def binarySearch(start, end, array, target):
    if start > end:
        return None
    mid = (start+end) // 2
    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return binarySearch(start, mid-1, array, target)
    else:
        return binarySearch(mid+1, end, array, target)


array = [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]
print(binarySearch(0, len(array)-1, array, 4))
