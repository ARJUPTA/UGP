!pip install pillow
from PIL import Image
raw_image = Image.open("Raw.jpg")
raw_image

import numpy as np
arr = np.array(raw_image)
arr.shape

import matplotlib.pyplot as plt
# tuple to select colors of each channel line
colors = ("red", "green", "blue")
channel_ids = (0, 1, 2)

# create the histogram plot, with three lines, one for each color
plt.figure()
plt.xlim([0, 256])
for channel_id, c in zip(channel_ids, colors):
    histogram, bin_edges = np.histogram(
        arr[:, :, channel_id], bins=256, range=(0, 256)
    )
    plt.plot(bin_edges[:-1], histogram, color=c)

plt.title("Color Histogram")
plt.xlabel("Color Coordinate")
plt.ylabel("Pixel Count")

plt.show()