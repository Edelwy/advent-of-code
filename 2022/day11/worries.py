from typing import List
import math

class Monkey:
    def __init__(self, items, operation, operator, test, true, false):
        self.items = items
        self.operation = operation
        self.operator = operator
        self.test = test
        self.true = true
        self.false = false
        self.inspects = 0
    
    def __str__(self):
        string = f"\nItems: {self.items}\n"
        if operator == None: string += f"Operation {self.operation} with: old\n"
        else: string += f"Operation {self.operation} with: {self.operator}\n"
        string += f"Test if divisible by: {self.test}\n"
        string += f"True, next monkey: {self.true}\n"
        string += f"False, next monkey: {self.false}\n"
        string += f"Inspected items: {self.inspects}\n\n"
        return string
    
    def __repr__(self):
        return str(self)

def most_active(monkeys):
    first = 0
    second = 0
    m1 = None
    m2 = None

    for monkey in monkeys:
        if monkey.inspects > first:
            second = first
            m2 = m1
            first = monkey.inspects
            m1 = monkey
        elif monkey.inspects > second:
            second = monkey.inspects
            m2 = monkey   
    return m1, m2   


file = open('input.txt', 'r')
monkeys: List[Monkey] = []

for line in file:
    lines = line.strip().split(" ")

    if lines[0] == "Monkey": 
        tmp = next(file).strip().split(":")
        tmp = tmp[1].split(", ")
        items = [eval(i) for i in tmp]

        tmp = next(file).strip().split(" ")
        operation = tmp[4]

        if tmp[5] == "old": operator = None
        else: operator = int(tmp[5])

        tmp = next(file).strip().split(" ")
        test = int(tmp[3])

        tmp = next(file).strip().split(" ")
        true = int(tmp[5])

        tmp = next(file).strip().split(" ")
        false = int(tmp[5])
    
        monkeys.append(Monkey(items, operation, operator, test, true, false))

file.close()

sum = 1
for monkey in monkeys:
    sum *= monkey.test

print(sum)
rounds = 10000
for round in range(rounds):
    for i,monkey in enumerate(monkeys):
        for item in monkey.items:
            operator = monkey.operator
            if monkey.operator == None: operator = item 
            if monkey.operation == "*": item = (item * operator) % sum
            if monkey.operation == "+": item = (item + operator) % sum
            if item  % monkey.test == 0: monkeys[monkey.true].items.append(item)
            else: monkeys[monkey.false].items.append(item)
            monkey.inspects += 1
        monkey.items.clear()

m1, m2 = most_active(monkeys)
result = m1.inspects * m2.inspects
print(result)



