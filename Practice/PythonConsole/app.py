import os
from datetime import datetime, timezone

print("Docker practice: Python console app")
print("Python is running in a container.")
print(f"APP_MODE={os.getenv('APP_MODE', 'practice')}")
print(f"2 containers + 3 images = {2 + 3}")
print(f"Started at (UTC): {datetime.now(timezone.utc).isoformat()}")
