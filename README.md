# Project-Implementation-of-Virtual-Bitmap
CIS6930 Internet Data Streaming

Project Implementation of Virtual Bitmap

By,
Kamal Sai Raj Kuncha
UFID: 48548114

About the code:
The source code includes a mainrun.java file which has classes mainrun which basically runs the file,
Flowparameters java class which contains ip address and actual spread variables and Virtual bitmap class which
contains contains s array for the random number generation, l is the size of the virtual bitmap, m being the size of
physical bitmap and phybitmap being the array of the physical bitmap. This class has record function for taking in the
flow and and the number of distinct elements which are generated automatically and mapped to the physical bitmap
and query function to lookup these mappings and simultaneously calculates the estimated spread of the given flow by using
the number of zeroes of both the physical bitmap and virtual bitmap.



Input tried:
The code uses the given input file to take in the flows but generates the number of distinct elements in each flow
Virtual Bitmap =  number of flows n=8,507, (proj4input.txt) ,size of the virtual bitmap l=500, the size of physical bitmap m= 500000

Output:
Output files attached for the above input.


Steps To Run the project:
1) Import the project into an IDE such as Eclipse or IntelliJ and run the applrun.java file.
3) Enter the size of the virtual bitmap and subsequently other parameters when prompted.
4) The output would print in this format the ip address of a flow, actual spread and recorded spread.
Also output files are simultaneously created and output is written into the files while printing.
5) Graph was created using excel that is attached.
