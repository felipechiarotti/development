total = 0.0
for i in range(2):
    line = input()
    peca = line.split()
    total += float(peca[1])*float(peca[2])

print("VALOR A PAGAR: R$ %.2f" % (total))\