speed = float(input("Digite a velocidade de seu carro: "))

if speed > 80:
	print("Você foi multado em R$%.2f!" % ((speed-80)*5))

