i = 0
soma = 0
result = 0
number = int(input("Digite o número: "))

while number != 0:
    soma = soma + number
    i = i+1
    number = int(input("Digite o número: "))

if i!=0:
    result = soma/i
else:
    result = 0

print("A soma é %d e a média aritmética %d" % (soma,result))
