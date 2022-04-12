n, m = map(int, input().split())
answer = 0

for i in range(n):
    card = list(map(int, input().split()))
    min_val = min(card)
    if min_val > answer:
        answer = min_val

print(answer)
