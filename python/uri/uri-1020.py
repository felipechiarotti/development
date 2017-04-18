age = int(input())

years = int(age/30/12)
months = int(age/30) - years*12
days = age - years*365 +months*365
print("%d ano(s)\n%d mes(es)\n%d dia(s)" % (years,months,days))