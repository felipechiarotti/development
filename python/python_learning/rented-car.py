traveled = float(input("KM Percorridos: "))
rented_days = int(input("Dia(s) Alugados: "))

cost_day = 60
cost_km = 0.15

result = (cost_day*rented_days)+(cost_km*traveled)

print ("Sua conta é de: R$%.2f" % (result))
