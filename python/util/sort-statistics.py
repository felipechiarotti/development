import sys
file_read = open(sys.argv[1],'r')

data = []
for line in file_read.readlines():
        data_line = line.split()
        link = data_line[1]
        pos2 = link.find('!')+2
        full_name = link[pos2:-1]
        full_name = full_name.split('_')
        del data_line[0:5]
        del data_line[1]
        data_line.insert(0,full_name[0].title())
        data_line.insert(1,full_name[1].title())
        data.append(data_line)
        print(data_line)

for i in range(len(data)):
    for j in range(len(data)-1):
        lineA = data[j]
        lineB = data[j+1]
        if(ord(lineA[1][0]) > ord(lineB[1][0])):
            aux = lineA
            data[j] = data[j+1]
            data[j+1] = aux


file_save = open(sys.argv[1]+'-ordened.csv','w')

for line in data:
    save_line = ';'.join(line)+'\n'
    file_save.write(save_line)