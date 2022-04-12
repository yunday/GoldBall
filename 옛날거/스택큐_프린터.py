def solution(priorities, location):
    d = priorities
    cnt = 0
    while d:
        k = d.pop(0)
        state = 0
        for i in d:
            if k < i:
                d.append(k)
                location -= 1
                if location < 0:
                    location = len(d)-1
                state = 1
                break
        if state != 1:
            cnt += 1
            if location == 0:
                return cnt
            location -= 1

# 전문가에게 여쭤보니 성능 상관없이 풀기만 하면 된다고 해서 남 코드 기록은 안함!
