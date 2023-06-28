
def result(op, me):
    if op == "A" and me == "X": return 3
    if op == "A" and me == "Y": return 1
    if op == "A" and me == "Z": return 2

    if op == "B" and me == "X": return 1
    if op == "B" and me == "Y": return 2
    if op == "B" and me == "Z": return 3

    if op == "C" and me == "X": return 2
    if op == "C" and me == "Y": return 3
    if op == "C" and me == "Z": return 1

score = 0
file = open('input.txt', 'r')

for line in file:
    round = line.split(" ")
    op = round[0]
    me = round[1].strip()

    if me == "X": score += 0 + result(op, me)
    if me == "Y": score += 3 + result(op, me)
    if me == "Z": score += 6 + result(op, me)

print(score)