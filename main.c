//csc460
//Group 10
//program1
//John Davis dav4621@calu.edu
//Yahya Adejoh ade0009@calu.edu
//Tanka Gautam gau2971@calu.edu

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#include "file_util.c"



int main(int argc, char *argv[] )
{
    //creating and instanizing a file

    //some declared variables needed below
    char inpFile[15];   //string variable for input file
    char outFile[15];   //string variable for output file

    char inpExt[6];
    char outExt[6];

    char *ext1 = inpExt;         //ext1 and ext2 will be used to check for file extensions
    char *ext2 = outExt;
    //ex. main input.in output.out
    if ( argc == 3 ) {
        //check to see if input file exists
        //check to see if output file exists
        //create output file
    }
        //ex. main input.in
    else if ( argc == 2 ) {
        //check to see if the input file exists
        //create output file
    }
    else if ( argc > 3 ) {
        printf( "Too many arguments were used!\n" );
    }
        //ex. main
    else {
        processFile(inpFile,outFile,inpExt,outExt);
    }
    return 0;
}
