def find_max_n(S):
    N = 0
    sum_of_numbers = 0

    while sum_of_numbers <= S:
        N += 1
        sum_of_numbers += N

    return N-1

S = int(input())
print(find_max_n(S))