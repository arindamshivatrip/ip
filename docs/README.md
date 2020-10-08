# User Guide

## Introduction
This application is named Air. It is a command line application with a feisty personality  that allows users to store a list of tasks.
### How to run Air 
*Prerequisite*: Java 11

1. Download the jar file from the release of this project.
2. Extract this file to your preferred folder.
3. Open command prompt and change to the directory in the previous step
4. Run this command: java -jar duke.jar
5. You should see this message below if all has happened correctly so far:

   ```
   File does not already exist
   Hello from
       _____  __        
     /  _  \ |__|______ 
    /  /_\  \|  \_  __ \
   /    |    \  ||  | \/
   \____|__  /__||__|   
            \/           
   ```
____________________________________________________________

	Sup! I'm Air
	How can I help you out today?

____________________________________________________________

## Features of Air
#####1. Save Tasks
Air saves the tasks in the  list every time a change occurs to the list of tasks.
#####2. Load Tasks
Loading previously saved tasks on starting up.
#####3. Add Tasks
A user can add tasks to the program of many types. These include:
   1. Todo\
   These are normal tasks and are added by typing\
   `todo <taskName>`
   2. Events\
   These are events and have a time that goes along with the name of the event.They are added by typing:
   `event <Event-Name> /at <Event-Time>`
   3. Deadlines\
   These are deadlines and have a time that goes along with the name of the deadline.They are added by typing:
   `deadline <deadline-Name> /by <deadline-Time>`
#####4. List Tasks
By typing the word `list` a list of all the tasks currently in the program is listed.
#####5. Finish Tasks
By typing the string `done <taskNumber>` the task at the position `taskNumber` is marked to be done.
#####6. Delete Tasks
By typing the string `delete <taskNumber>` the task at the position `taskNumber` is removed from the list of tasks.
#####7. Find Tasks
By typing the string `find <String>` the tasks which contain `string` are listed.
#####8. Error Handling
Taking nearly all the possible errors that can be made into account and displaying helpful error messages.
## Sample run
### Inputs
```
hello
todo Eat dinner
done 1
delete 1
event project meeting /at Mon 2-4pm
list
bye
```
### Output
```
File already exists. Previous tasks will be imported.
	Hello from
   _____  .__        
  /  _  \ |__|______ 
 /  /_\  \|  \_  __ \
/    |    \  ||  | \/
\____|__  /__||__|   
        \/           


____________________________________________________________

	Sup! I'm Air
	How can I help you out today?

____________________________________________________________

____________________________________________________________
hi OOPS!!! I'm sorry, but I don't know what that means :-(
____________________________________________________________
____________________________________________________________
	Task added:	[T][✘]	Eat dinner

	Now you have 1 tasks in the list.

____________________________________________________________
Noiice! You're done with this Task. Good for you. I've marked that ure done with it.
	[✓]	Eat dinner
	[✓]	Eat dinner
Task has been deleted. Here's the new list
____________________________________________________________
☹ OOPS!!! There are no tasks currently in the list
____________________________________________________________
____________________________________________________________
	Task added:	[E][✘]	project meeting (at: Mon 2-4pm)

	Now you have 1 tasks in the list.

____________________________________________________________
1.  [E][✘]	project meeting (at: Mon 2-4pm)
See you later Alligator!

````
## Note
All the commands are case-sensitive. In case you spot errors kindly reach out to me.

