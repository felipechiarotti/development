file = open("numeros","w")

for line in range(1,101):
    file.write("%d\n" % line)

file.close()


file = open("numeros","r");

for line in file.readlines():
    print(line);

file.close();