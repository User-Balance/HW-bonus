This is the program about the Bonus homework of CSC505, NCSU 2020 fall


Instuctor:
The .class file are generated at HW-bonus/out/production/HW_bonus/

Main.class is the main class to operate and there are three arguement needed for program:
args[0]: filename   (The input file of integers that needed to sort.)
args[1]: min        (the minimum array size for which 2 threads would be created.)
args[2]: thread     (maximum number of threads that should be created.)


This assignment using extending RecursiveAction to re-define thread operation.
And ForkJoinPool, ForkJoinTask is used to  manage the number of thread to be created.



