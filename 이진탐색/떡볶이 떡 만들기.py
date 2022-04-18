# 내 풀이
# def binarySearch(start, end, array, target):
#     if start > end:
#         return end
#     mid = (start + end) // 2
#     if array[mid] == target:
#         return mid
#     elif array[mid] > target:
#         return binarySearch(mid + 1, end, array, target)
#     else:
#         return binarySearch(start, mid - 1, array, target)
#
#
# n, m = map(int, input().split())
# riceCake = list(map(int, input().split()))
# sumValue = [0]*(max(riceCake)+1)
#
# for i in range(max(riceCake), -1, -1):
#     for j in riceCake:
#         if j - i <= 0:
#             continue
#         sumValue[i] += (j - i)
#
# print(binarySearch(0, len(sumValue)-1, sumValue, m))

def binarySearch(start, end, array, target):
    result = 0
    while start <= end:
        total = 0
        mid = (start + end) // 2
        for i in array:
            if i > mid:
                total += i - mid
        if total < target:
            end = mid - 1
        else:
            result = mid
            start = mid + 1
    return result


n, m = map(int, input().split())
riceCake = list(map(int, input().split()))

print(binarySearch(0, max(riceCake), riceCake, m))
