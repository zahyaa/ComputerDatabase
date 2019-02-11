#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include "file_util.h"



void processFile(char inpFile[15], char outFile[15],char inpExt[6],char outExt[6]) {

    FILE *fptr,*optr,*temp;
    char *ext1;
    char newline[500];





    //program in prompts for opening input file, and then output file
    printf("Please enter the input file to process: ");
    scanf("%s", inpFile);

    //check to see if any .ext is given. if not, set it to .IN
    ext1 = strrchr(inpFile, '.');     //this searches for the last "." in the string, and will store everything after it as the extension
    if (!ext1) {
        // no extension
        printf("Please insert the file extension you would like to use\n(example would be .txt): ");
        scanf("%s", inpExt);     //will place the extension into the inpExt string
        //need to code way to add typed in expression to inpFile
        printf("extension is %s\n", inpExt);

        strcat(inpFile, ext1);
    } else {
        printf("extension is %s\n", ext1);
    }
    if (inpFile == NULL) {
        printf("File does not exist\n");

    }

    fptr = fopen(inpFile,"r");

    while(!feof(fptr)) {
        fgets(newline, 500,fptr);
        puts("\n");
        puts(newline);


    }
    fclose(fptr);


    // ---------------------- Writting output file --------------------------------------------

    temp = tmpfile();

    char choice;


    char outBackup[15];
    char extBak[4] = ".BAK";
    char extLIS[4] = ".LIS";


    char *ext2 = outExt;
    printf("Please enter an output file name: ");
    scanf("%s", outFile);

    optr = fopen(outFile,"w");

    //need help setting the the input to print the output
    /*while(newline != NULL){

        fprintf(optr,"%s",newline);
        fclose(optr);
    }*/
    for(int i = 0; i < 500 ; i++){
        fprintf(optr,"%s",newline);
        fclose(optr);
    }




    //ext2 = strrchr(outFile, '.' );  //this searches for the last "." in the string, and will store everything after it as the extension
    if (access(outFile, F_OK) != -1) { // The file exists, ask to overwrite
        printf("Do you want to overwrite this file (y)es or (n)o: ");
        scanf("%c", &choice);


        if (choice == 'y') {
            // overwrite file
            printf("What do you want the backup file to be named?(don't put the extension): ");
            scanf("%s", outBackup);
            strcat(outBackup, extBak);
            fptr = fopen(outBackup, "w");
            fclose(fptr);      //this created backup file then closed it


            fptr = fopen(outFile, "a");
        } else {
            // exit program
        }
    } else { // the file doesn't exist

        fptr = fopen(outFile, "w");
    }

    if (!ext2) {
        ext2 = ".out";
    }





    fclose(fptr);


}

