
def draw(x, cpu, screen_line):
    if cpu == x - 1: screen_line += "#"
    elif cpu == x: screen_line += "#"
    elif cpu == x + 1: screen_line += "#"
    else: screen_line += "."
    return screen_line


file = open('input.txt', 'r')
input = file.readlines()
x = 1
cpu = 0
k = 40
screen_line = ""

for line in input:
    line = line.strip()
    instructions = line.split(" ")
    mnemonic = instructions[0]

    #print(mnemonic, x, cpu)
    
    if len(instructions) == 2:
        value = int(instructions[1])

        screen_line = draw(cpu, x, screen_line)
        cpu += 1
        if cpu == k: 
            cpu = 0
            print(screen_line)
            screen_line = ""

        screen_line = draw(cpu, x, screen_line)
        cpu += 1
        if cpu == k: 
            cpu = 0
            print(screen_line)
            screen_line = ""

        x += value

    else: 
        screen_line = draw(cpu, x, screen_line)
        cpu += 1
        if cpu == k: 
            cpu = 0
            print(screen_line)
            screen_line = ""
