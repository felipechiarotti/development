values = input()
values = values.split()
mx = 0
for element in values:
    if int(element) > mx:
        mx = int(element)
print ("%d eh o maior" % (mx))