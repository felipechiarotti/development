distance_km = float(input("Digite a Distância (Km): "))
speed_kmh = int(input("Digite a Velocidade Média (Km/h): "))

time = int((distance_km / speed_kmh)*60)

print("O Tempo médio para chegada ao destino é de: %d minutos" % (time))
