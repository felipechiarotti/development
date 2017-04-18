notas = [[100,0],[50,0],[20,0],[10,0],[5,0],[2,0]]
moedas = [[1.00,0],[0.50,0],[0.25,0],[0.10,0],[0.05,0],[0.01,0]]
valor = float(input())


x = 0
print("NOTAS:")
for nota, quantidade in notas:
    while (valor - nota) >= 0:
        notas[x][1] += 1
        valor -= nota
    print("%d nota(s) de R$ %.2f" % (notas[x][1],nota))
    x=x+1

x = 0
print("MOEDAS:")
for moeda, quantidade in moedas:
    while (valor - moeda) >= 0:
        moedas[x][1] += 1
        valor -= moeda
    print("%d moeda(s) de R$ %.2f" % (moedas[x][1],moeda))
    x=x+1