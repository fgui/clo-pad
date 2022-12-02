from hy.core.language import reduce, take
from hy.core.shadow import hyx_Xplus_signX
sample_data = [[1000, 2000, 3000], [4000], [5000, 6000], [7000, 8000, 9000],
    [10000]]


def solve_first_part(data):
    return max(map(lambda x: reduce(hyx_Xplus_signX, x), data))


solve_first_part(sample_data)


def sort_big_first(l):
    l.sort(reverse=True)
    return l


def solve_second_part(data):
    return reduce(hyx_Xplus_signX, take(3, sort_big_first(list(map(lambda x:
        reduce(hyx_Xplus_signX, x), data)))))


solve_second_part(sample_data)

