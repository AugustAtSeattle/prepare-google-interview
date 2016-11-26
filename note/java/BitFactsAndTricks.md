

following expression is useful in bit manipulation. We use "1s" and "0s" to indicate a sequence of 1s or 0s, respectively.


- x^x = 0s
- x^0s = x
- x^1s = ~x
- x^~x = 1s

- x|0s = x
- x|1s = 1s
- x|x = x

- x&0s = 0
- x&x = x
- x&1s = x


PS.  
- '^' means difference set 1 or set 0
- '&' means AND 
- '~' means reverse all bits
- '|' means OR 


##### Arithmetic vs Logical Right Shift

- Arithmetic Shift >> fill the second most right bit with the value of the sign bit.
- Logical Right Shift >>> fill the most right bit with 0. 
