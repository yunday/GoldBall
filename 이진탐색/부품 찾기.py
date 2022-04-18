def binarySearch(start, end, array, target):
    while start <= end:
        mid = (start+end) // 2
        if array[mid] == target:
            return True
        elif array[mid] < target:
            start = mid + 1
        else:
            end = mid - 1
    return False


n = int(input())
nNumber = list(map(int, input().split()))
nNumber.sort()

m = int(input())
mNumber = list(map(int, input().split()))

for i in mNumber:
    if binarySearch(0, len(nNumber)-1, nNumber, i):
        print('yes', end=' ')
    else:
        print('no', end=' ')
