# FundAppsKata
Pluto Rover kata for FundApps interview.

On branch **Master**, the implementation for the first 3 requirements can be found. It was all done under the 2-hour time window. 

For improving my implementation, further changes to be made could be are: 
* *DRY* in `moveForward / moveBackwards` and `turnLeft / turnRight`: find a more elegant logic that could help me avoid so similar switch statements.
* Instead of saving a boolean matrix for the map, just save the mapSize (which is what I used for first 3 requirements), and then a hashSet with the obstacles as Strings (so then I only need to check if next position has an obstacle or not by accessing the hashSet - O(1) -, and return it).
* Add comments above each test case to explain what are they testing.
* Build an easy console interface to try the whole program, user providing a String of commands. 


On branch **Completed**, I am meant to complete the requirement 4 and the command string parser, as well as the improvements mentioned above. 

