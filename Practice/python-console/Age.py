from datetime import datetime
 
dob = input("Enter your date of birth (YYYY-MM-DD): ")
dob = datetime.strptime(dob, "%Y-%m-%d")
age = datetime.now().year - dob.year
print(f"You are {age} years old.")