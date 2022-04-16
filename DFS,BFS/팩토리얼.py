# 반복
def iterative(n):
    result = 1
    for i in range(1, n+1):
        result *= i
    return result

# 재귀
def recursive(n):
    if n <= 1:
        return 1
    return n * recursive(n-1)

print(iterative(5))
print(recursive(5))