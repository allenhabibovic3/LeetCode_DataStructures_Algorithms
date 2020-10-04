def timeConversion(s):
    parts = s.split(':')
    if s == "12:00:00AM":
        return "00:00:00"
    elif s == "12:00:00pm":
        return "12:00:00"

    hour = int(parts[0])
    code = parts[-1]
    if 'PM' in parts[-1] and hour >= 1 and hour <= 11:
        hour += 12
        parts[-1] = code[0:2]
    elif 'AM' in parts[-1] and hour == 12:
        hour -= 12
        parts[0] = str(hour).zfill(2)
        parts[-1] = code[0:2]
    else:
        parts[-1] = code[0:2]
    parts[0] = str(hour).zfill(2)
    return ':'.join(parts)

print(timeConversion("12:40:22AM"))
