salary = float(input("Digite o Salário: "))

tax = 0

if salary > 1000 and salary <= 3000:
	tax = (salary-1000) * 0.2
elif salary>3000:
	tax = (2000*0.2)+(salary-3000)*0.3


print("O Imposto é de R$%.2f" % (tax))
