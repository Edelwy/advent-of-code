import re


fully_included = 0
file = open('input.txt', 'r')

for line in file:

    line.strip() # da se znebimo newlina
    assigment = line.split(",")
    pair1 = assigment[0]
    pair2 = assigment[1]

    start1 = int(pair1.split("-")[0])
    start2 = int(pair2.split("-")[0])
    end1 = int(pair1.split("-")[1])
    end2 = int(pair2.split("-")[1])
    checked = False

    for i in range(start1, end1 + 1):
        if i in range(start2, end2 + 1):
            fully_included += 1
            checked = True
            break

    if not checked:
        for i in range(start2, end2 + 1):
            if i in range(start1, end1 + 1):
                fully_included += 1
                break


print(fully_included)
    