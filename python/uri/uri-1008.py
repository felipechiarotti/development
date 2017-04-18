employer_id = int(input())
employer_total = int(input())
employer_salary_per_hour = float(input())
employer = [employer_id,employer_total,employer_salary_per_hour]
employer_salary = employer[1]*employer[2]
print("NUMBER = %d\nSALARY = U$ %.2f" % (employer[0],employer_salary))