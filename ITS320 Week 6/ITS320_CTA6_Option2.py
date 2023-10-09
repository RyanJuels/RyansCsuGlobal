def cartesian(A, B):
    result = []
    for i in A:
        for j in B:
            result.append("(" + str(i) + ", " + str(j) + ")")
    
    return result


def main():
    A = [1,2]
    B = [3,4]

    print("AxB = ", end='')
    print(cartesian(A, B))


if __name__ == "__main__":
    main()