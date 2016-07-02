
from PIL import Image

for num in range(1,10):

	img=Image.open('./'+str(num)+'.jpeg')
	img=img.resize((20,20),Image.ANTIALIAS)
	img.save(str(num)+'.jpeg')