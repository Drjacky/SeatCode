## Mars Rover
A robotic rover is to be landed by NASA on a plateau on Mars. This plateau, which is curiously rectangular, must be navigated by the rovers so that their on-board cameras can get a complete view of the surrounding terrain to send back to Earth.
A rover's position and location is represented by a combination of x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.
In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot. 'M' means move forward one grid point, and maintain the same heading. If the rover tries to move and is heading to the limit of the plateau, It won’t move.
Assume that the square directly North from (x, y) is (x, y+1).

## Input
To ease the processing of the plateau creation and reading the rover’s movements, all data will be sent in JSON format
**topRightCorner:** indicates the upper-right coordinates of the plateau.
**roverPosition:** Indicates the rover initial position inside the plateau
**roverDirection:** Indicates the rover initial heading
**movements:** Instructions telling the rover how to explore the plateau.

## Output
The output for the rover should be its final co-ordinates and heading separated by spaces.

## Example
`
{
   "topRightCorner":{
      "x":5,
      "y":5
   },
   "roverPosition":{
      "x":1,
      "y":2
   },
   "roverDirection":"N",
   "movements":"LMLMLMLMM"
}
`
Expected output:
1 3 N

#### The app has following packages:

 1. **dto**: Model to hold the data.
 2. **exception**: Custom exception.
 3. **main**: Main classes.
 4. **util**: Utility class.
 5. **test**: Include test classes and test cases.
 
 ### Installation and run by IDE
 
 1. IntelliJ IDEA 2020.1.1 from [here](https://www.jetbrains.com/idea/download/)
 2. Run `main.AppKt` from top right corner
 
 ### Installation and run by command
  
  1. IntelliJ IDEA 2019.2.2 from [here](https://www.jetbrains.com/idea/download/)
  2. Rebuild the project
  3. Run `shadowJar` from gradle task from right pane
  4. Go to `libs` folder, under `build` folder from left pane
  5. Copy built jar to the desktop
  6. Copy `inputs.json` from root of project to the same place as previous step
  7. If you have not installed kotlin yet, run this command on your terminal: `brew update` & `brew install kotlin`
  8. Run this command to run the Jar: `kotlin -cp SeatCode-1.0.0-all.jar main.AppKt`
 
 ### Run test cases
 
 1. Go to test folder and run each appropriate test cases.
 
 ![Screenshot](https://raw.githubusercontent.com/Drjacky/SeatCode/master/output.png)
 
 ### License
 ```
    MIT License
    
    Copyright (c) 2020 Dr.jacky
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
 ```
 
