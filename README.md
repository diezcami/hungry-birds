# Hungry Birds
<img src=https://github.com/diezcami/hungry-birds/blob/master/images/GameIcon.png width=100 height=100>

Hungry Birds was originally a culminating project for my CS21b (Introduction to Programming II) course in March 2014. It's essentially the first program I developed and learned to love after a whole year of planning to shift out of Computer Science. As of May 2015, the code remains unedited and is therefore inclusive of rather unfortunate code practices including, as seen in the issues portion of this repository.

I'll get around to fixing everything in the list above when I have time between developing my newer projects and learning other technologies. Stay tuned!

## How to Run
As this is pretty much unmaintained legacy software, it was primarily developed and tested using the BlueJay IDE. I've removed the .class and .ctxt files produced from running `javac Main.java` in order to reduce the clutter in the repository, so there's no real way of running it without compiling it (for now, anyway).

1. Download the file as a zip (There's a button to the right of this page) and unextract it.
2. Launch your command prompt and navigate to the `hungry-birds` folder using `cd`.
3. Compile the class with `javac Main.java`. Note that you need to have some kind of JDK installed in order for your command prompt to recognize `javac`.
4. Once compiled, open the `Main.class` file in the `hungry-birds` folder.

Note that only the last step is needed to run the program after doing steps 1-3 at least once.

## Game Mechanics
Hungry Birds was originally supposed to be a two player game played over two computers, however I had difficulty grasping serialization to implement the networking functions as a new programmer when I made this game. With this, there are several mechanics that may not make sense when built as a single player game, as well as several that never made it to this page to begin with.

The main objective of the game is to avoid dying to anything be it eggs, clouds or missiles from your hypothetical enemy. This will further be explained in the instructions below:
* Move the bird forward with the `up` arrow key. To move in different directions, use the `left`, and `right` arrow keys. A yellow block appears in your former spot as soon as you move in any direction- this is your safe spot, where you become immune to everything that could harm you in the game.
* Press the `space bar` to fire missiles that eliminate clouds and hypothetically damage your enemy.
* Use the `down` arrow key to lay eggs or bombs which can be used to hypothetically kill your opponent. In this implementation, the eggs won't really be used for anything except to kill your own character.

There are also some power-ups in the game, namely green crosses and red hearts. These restore health and spawn more clouds once a player comes into contact with them. The red heart also allows the user to respawn to the safe spot, in order to guarantee his protection from the newly spawned clouds. These aren't as useful in a 1P scenario as they would be in a 2P one.

In short, this game is a very simple implementation of Asteroids with incomplete 2P functionalities.

## License
The MIT License (MIT)

Copyright (c) 2013 Camille Diez

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
