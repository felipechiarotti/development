kwh = int(input("KwH consumidos: "))
instalacao = input("Residencial (R), Industrial (I), Comercial (C): ")

result = 0

if instalacao == 'R':
	if kwh <=500:
		result= kwh*0.4
	else:
		result= kwh*0.65
elif instalacao == 'C':
	if kwh <= 1000:
		result = kwh*0.55
	else:
		result = kwh*0.6
elif instalacao == 'I':
	if kwh <= 5000:
		result = kwh*0.55
	else:
		result = kwh*0.6

print("Valor a pagar: R$%.2f" % (result))
