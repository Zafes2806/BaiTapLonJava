from rembg import remove
from PIL import Image

input_path = "image/Paper3.png"
output_path = "image/Paper4.png"
input = Image.open(input_path)
output = remove(input)
output.save(output_path)
