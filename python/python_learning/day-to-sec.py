day = int(input("Dia(s): "))
hour = int(input("Hour(s): "))
minutes = int(input("Minute(s): "))
seconds = int(input("Second(s): "))

seconds_in_minute = 60
seconds_in_hour = seconds_in_minute*seconds_in_minute
seconds_in_day = seconds_in_hour*24

day_to_sec = day*seconds_in_day
hour_to_sec = hour * seconds_in_hour
minutes_to_sec = minutes * seconds_in_minute
result = day_to_sec + hour_to_sec + minutes_to_sec + seconds

print("%dD e %02d:%02d:%02d possuem um total de: %d segundos" % (day,hour,minutes,seconds,result))
