score = 0
file = open('input.txt', 'r')

def result(op, me):
    if op == "A" and me == "X": return 3
    if op == "A" and me == "Y": return 6
    if op == "A" and me == "Z": return 0

    if op == "B" and me == "X": return 0
    if op == "B" and me == "Y": return 3
    if op == "B" and me == "Z": return 6

    if op == "C" and me == "X": return 6
    if op == "C" and me == "Y": return 0
    if op == "C" and me == "Z": return 3

for line in file:
    round = line.split(" ")
    op = round[0]
    me = round[1].strip()

    if me == "X": score += 1 + result(op, me)
    if me == "Y": score += 2 + result(op, me)
    if me == "Z": score += 3 + result(op, me)

print(score)