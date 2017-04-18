time = int(input())
seconds = time - ((int(time/60))*60)
hours = int((int(time/60))/60)
minutes = int((time/60))
if hours >= 1:
   minutes -= hours*60 


print("%d:%d:%d" % (hours,minutes,seconds))