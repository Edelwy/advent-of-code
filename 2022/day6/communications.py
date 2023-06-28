
file = open('input.txt', 'r')

line = file.readline()
for i in range(len(line) - 3):
    ch1 = line[i]
    ch2 = line[i + 1]
    ch3 = line[i + 2]
    ch4 = line[i + 3]

    if ch1 == ch2: continue
    elif ch1 == ch3: continue
    elif ch1 == ch4: continue
    elif ch2 == ch3: continue
    elif ch2 == ch4: continue
    elif ch3 == ch4: continue
    else: 
        print(str(i + 4) + " : " + ch1 + ch2 + ch3 + ch4)
        break