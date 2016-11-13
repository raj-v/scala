object HO extends App {

    /* Sum Integers between a and b */
		def sumInts(a: Int, b: Int) : Int = {
		
			if (a > b) 0
			else a + sumInts(a + 1, b)
		
		}
		
		sumInts(2, 5)
		
		def cube(x : Int) : Int = x * x * x
		
		def sumCube(a: Int, b: Int) : Int = {
		
			if (a > b) 0
			else cube(a) + sumCube(a + 1 , b)
		
		}
		
		def fact(x : Int) : Int = {
			if (x == 0) 1
			else x * fact(x - 1)
		}
		
		def sumFact(a:Int, b:Int) : Int = {
		  if (a > b) 0
		  else fact(a) + sumFact(a + 1, b)
		}

		println(sumFact(1, 3))
		
		
		//Sum is a function used quite often. Why not take it as an argument.
		
		def sumGenericInts ( f: Int => Int, a : Int, b: Int) : Int = {
		  
		  if (a > b) 0
		  else f(a) + sumGenericInts(f , a + 1, b)
		  
		}
		
		def id(x: Int) : Int = x
		
		/* 
		 * Here HO means high order
		 * Functions that take functions as arguments and/or return functions as results 
		 */
		
		def sumIntsHO ( a: Int, b: Int) : Int = sumGenericInts(id, a, b)
		
    def sumCubesHO ( a: Int, b: Int) : Int = sumGenericInts(cube, a, b)
    
    def sumFactHO ( a: Int, b: Int) : Int = sumGenericInts(fact, a, b)


    println(sumIntsHO(2, 3))
    
    println(sumFactHO(1, 3))
    
    
    // f: Int => Int
    //This is called a function type. This funciton f takes an integer and returns a int
	  
    //We had to use id, cube and fact as auxilliary functions.
    
    //Sometimes writing these small functions can be tedious. Find out when and add the details 
    
    def str = "Scala"; println(str)
    
    println("Scala") // because string exists as literals
    
    //can we function literals ? with defining the function. 
    // Anonymous functions are the answers. 
    
    (x: Int) => x * x * x
    
    (x: Int, y: Int) => x + y
    
    
    def sumIntsAnonymous(a: Int, b:Int) : Int = sumGenericInts(x => x, a, b)
    def sumCubesAnonymous(a: Int, b:Int) : Int = sumGenericInts(x => x* x* x, a, b)

    def tailRecSum(f: Int => Int, a: Int, b: Int) : Int = {
      def loop (a: Int, acc: Int) : Int = {
        if (a > b) acc
        else loop(a + 1, acc + f(a))
      }
      loop (a, 0)
    }
    
    println(tailRecSum(x => x, 1, 5))
    
}
