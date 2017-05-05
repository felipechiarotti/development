notas = [[100,0],[50,0],[20,0],[10,0],[5,0],[2,0],[1,0]]
valor = int(input())
print(valor)

x = 0

for nota, quantidade in notas:
    while (valor - nota) >= 0:
        notas[x][1] += 1
        valor -= nota
    print("%d nota(s) de R$ %d,00" % (notas[x][1],nota))
    x=x+1