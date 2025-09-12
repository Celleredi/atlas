# Atlas
atlas is a data-driven image-based world generator. give the mod a heightmap and biome map image, and you can incorporate it into a [datapack dimension](https://minecraft.fandom.com/wiki/Custom_dimension)! 

### How to Use
- create or find a grayscale heightmap. save it as a png with 32 bit, RGBA encoding. put it in your datapack; the standard is in the `atlas/map` directory.
- create a copy of the image and paint over it with whatever colors you like. each color corresponds to a different biome. do not mix or blend the colors. save this image with the same encoding and place it in your map folder.
- create a dimension file in your datapack and use `atlas:atlas` for the generator and biome source.
- load up the world! if something has gone wrong, you'll get an error in your logs. 

**an example datapack, including an explanation of the dimension parameters, can be found [here](example).**

if you're still having trouble, send a message in the [discord](https://discord.gg/6p27K23zSa) `#help-and-support` channel.

### Some Tips:
- when you're drawing the biomes, it may be helpful to be able to see the heightmap as a [contour map](https://en.wikipedia.org/wiki/Contour_line). you can emulate this in your preferred photo editor by selecting a black pixel and then using "select by color" with varying thresholds to get varying contour lines of your map.
- if your maps are not the same size, you might have regions of void that are mapped to biomes, or regions of terrain that are just your default biome. you can use this to save yourself some time!
- your map will be centered at 0,0. up in the image is north. if your map is an uneven number of pixels, the last pixel on the south and/or east side will be cut off.
- if `starting_y` in your dimension is less than your dimension's `min_y`, you can create areas of void. use this to create non-rectangular maps!
- anything outside of the world will be void, but certain hardcoded structures may still spawn, depending on what features are in your default biome.

### How to Build
- Make sure you have installed Gralde >8.14.3 and Java JDK >21
- Execute Gradle's build task in your IDE or run ./gradlew build
It's as shrimple as that
