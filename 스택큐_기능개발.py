from collections import deque


# 내 코드
def solution(progresses, speeds):
    q = deque(progresses)
    s = deque(speeds)
    cnt = []
    while len(q) > 0:
        t = 0
        while q[0] < 100:
            q = deque([i+k for i, k in zip(q, s)])
        while q and q[0] >= 100:
            q.popleft()
            s.popleft()
            t += 1
        cnt.append(t)
    return cnt


print(solution([93, 30, 55], [1, 30, 5]))


# 다른 사람 코드 --> 시간복잡도 n으로 내 코드보다 훨씬 짧음
# def solution(progresses, speeds):
#     print(progresses)
#     print(speeds)
#     answer = []
#     time = 0
#     count = 0
#     while len(progresses)> 0:
#         if (progresses[0] + time*speeds[0]) >= 100:
#             progresses.pop(0)
#             speeds.pop(0)
#             count += 1
#         else:
#             if count > 0:
#                 answer.append(count)
#                 count = 0
#             time += 1
#     answer.append(count)
#     return answer
