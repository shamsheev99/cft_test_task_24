# cft_test_task_24
Test task for CFT Shift course

## Functional
  At startup, the utility is given several files on the command line, which may contain a mixture of integers, strings and real numbers.   
The task of the utility is to write different types of data to different output files

### Default Settings
  Output directory: current   
  Output files: integers.txt for integer type values  
                floats.txt for float type values  
                strings.txt for string type valuse  
### Flags 
  -a - turn on overwrite output files  
  -o - output path for result  
  -p - set prefix for output files  
  -s - short statistic on result type values  
  -f - full statistic on result type values  


### Example of using
   java -jar util.jar -s -a -p sample- in1.txt in2.txt

   
