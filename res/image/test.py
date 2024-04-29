from rembg import remove
from PIL import Image

input1 = "image/Unmute2.png"
output1 = "image/Unmute2.png"
input = Image.open(input1)
output = remove(input)
output.save(output1)
