<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
* Build a terminal-based game using Java and the OOP principles that we have studied.  

* How do I build a game? Where do I start?

* What type of game do I want to make?

* We have only studied how to use the console to print messages.  How do I make an image show?

* What Java libraries exist?  How can they help me?

* I heard someone mention JFrame.  What is JFrame and how do I use it?

* Maybe I will do a racing game.  I will research how to code a racing game in Java.  

<h2>2. Planning the Solution</h2>
* WHOA!!!! I have a limited amount of time.  The learning curve to make a racing game is way too steep for the amount
 of time that we have. 
 
* I will make a Tetris game.  I will research Tetris and how to code a Tetris game in Java.  
 
*  What exactly is Tetris.  I have played the game hundreds, probably thousands of time, but what is the background 
 and history of the game?
 
* Tetris dates back to the mid 1980's. Boards are typically 10 X 20 but can be 10 X 26 

* There are 7 pieces in standard Tetris: stick, L, Mirror L, S, MirrorS, Square, T-Shape.

* Each piece is composed of 4 blocks. 

* A piece is defined by coordinated of the blocks that make up the body of each piece.  Each piece has its own
coordinate system. 

* The Skirt is an int [] array with as many elements as the piece is wide.  The skirt stores the lowest y value 
that appears in the body for each x value in the piece. 

* The game will consist of 3 classes: the Shape, Board, and Main classes.  The Board class will represent the game
board and will do most of the work. 

* I used genmymodel to build a class diagram.

* As I look through code, it looks strangely familiar.  Look!! There is an array! There is an Enum! LOOP!! WAIT WAIT!!! 
You mean to tell me that Tetris is essentially math? With a GUI interface? Suddently this doesnt look so daunting.  

<h2>3. Executing the Plan</h2>
* After building my class tree, it was CLEAR where I needed to start.  If I wanted to conform to DI, I would start 
with what I needed the least.  The Splash Screen!  After researching how to make a splash screen, it was time to execute. 
 
* Initially, I wanted a splash screen to display the instruction of the game for a period of 10 seconds, then the game would start. 
I knew that I would accomplish this using Thread.sleep...

* 10 seconds did not appear to be long enough.  With 10 seconds, the gamer had to read all of the instructions and remember the keys 
for the duration of the game.  What if someone has never played Tetris before? How would they remember?

* Maybe I will display the instructions on the game board during the game? No? The instructions get in the way of the pieces. 

* Maybe I will use the splash screen to display the instructions at the top of the screen.  Out of the way of the gaming screen, 
but always there in case the gamer forgets. 

* First, let me just get a blank splash screen to appear.  Then, let me see if I can print "Hello World." SUCCESS!!! Change Hello World
to short, simple game instructions.

* Next, I move on to the main class.  It has the second least amount of code. It essentially sets up the window, status bar, 
and the name of the game. 

* TEKtris!!! I will name it TEKtris to honor this cohort!!!

* I move to the shape class.  I started by creating each shape. 

* With each shape, I need to include the coordinates.  I knew that each piece had an origin of (0, 0) in the lower left hand corner.  
With some playing around, I was able to determine what the coordinates of each square that will makeup each piece. 

* Display each piece with no movement.  I had to research Swing! I was able to draw each piece! SUCCESS!!!

* Use the Board class to include falling motion. Test each piece.  .  Each piece falls!

* Go back to shape class to include code to rotate/move each piece. I reasearched Action Listeners and Key Events and I 
 was able to use that to link the move methods to a keypress Test each piece.  Each piece rotates. SUCCESS!!!

* Each piece falls, rotates, can move to the left or right.  

* As each line is cleared, update the score.  
<h2>4. Reflection / Refactor</h2>
* There are lots of tutorials on how to build Tetris in Java but BE CAREFUL!

* Most of the tutorials had incomplete code that did not work. Or the tutorial was several years old and may have been
outdated.

* At the end of the day, LIBRARIES are your best friend. They do some of the work for you.  

* This seemed scary in the beginning but as I worked through small, managable tasks, it seemed less and less daunting.

* This code can be refactored to use better practices.  

* I probably sacrified refactoring in order to try to fully understand how to make everything work. 

* There are still some things that I know how to use but don't fully understand how it works.  Think of a microwave. 

* I have never played Tetris so much in my life. 

* I wish I could have figured out how to change the icon for my game. It shows a Java logo. 

* I would like to make a desktop icon so I can click it and start the game. 

* I learned ALOT!!! Some of it was fun, some of it was painful. At the end of the day, the TEKtris game was
a combination of mostly things we had learned already.  It was just a matter of knowing how to fit each piece with the other. 
Pun intended...

* Word of advice, don't forget your break statements!

* I CODED A GAME!!!

* This was hard work but lots of fun.  

* The camp is over in 2 1/2 weeks!!!!