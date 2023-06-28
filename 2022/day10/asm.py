

file = open('input.txt', 'r')
input = file.readlines()
x = 1
cpu = 0
sum = 0
k = 20

for line in input:
    line = line.strip()
    instructions = line.split(" ")
    mnemonic = instructions[0]

    print(mnemonic, sum, x, k, cpu)
    
    if len(instructions) == 2:
        value = int(instructions[1])

        cpu += 1
        if cpu == k: 
            sum += x * cpu
            k += 40

        cpu += 1
        if cpu == k: 
            sum += x * cpu
            k += 40

        x += value

    else: 
        cpu += 1
        if cpu == k: 
            sum += x * cpu
            k += 40
