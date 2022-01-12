def solution(bridge_length, weight, truck_weights):
    cnt_all = [1]
    come = [truck_weights[0]]
    cnt = 0
    done = 0
    while come:
        cnt += 1
        if cnt_all[0] == bridge_length:
            come.pop(0)
            cnt_all.pop(0)
            if come:
                cnt_all = [i + 1 for i in cnt_all]
        else:
            cnt_all = [i + 1 for i in cnt_all]
        if done != len(truck_weights)-1 and truck_weights[done+1] + sum(come) <= weight:
            come.append(truck_weights[done+1])
            cnt_all.append(1)
            done += 1
    return cnt+1