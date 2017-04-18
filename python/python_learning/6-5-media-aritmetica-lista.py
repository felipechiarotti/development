notas = []
soma = 0
i = 0
nota = 0
nota = float(input("Digite a nota: "))
while nota != -1:
    soma = soma + nota
    notas.append(nota)
    nota = float(input("Digite a nota: "))

print("A média é %.1f" % (soma/len(notas)))
