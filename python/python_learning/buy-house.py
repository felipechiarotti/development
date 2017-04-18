house_value = float(input("Valor da Casa: "))
salary = float(input("Salário: "))
years_to_pay = int(input("Anos para pagar: "))
months_to_pay = years_to_pay*12

month_value = house_value / months_to_pay

if month_value > salary*0.3:
	print("Negado")
else:
	print("Aprovado")

