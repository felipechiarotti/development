salary = float(input("Digite o Salário: "))
percent = float(input("Digite a porcentagem do aumento: "))/100

aumento = salary*percent
result = salary + aumento
print("O Novo salario é %.2f, com um aumento de %.2f" % (result,aumento))
