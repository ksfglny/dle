

object Demo extends App{
    val hello=new Thread(new Runnable{
      def run()=print("hello")
    })
    hello.start()
    
}  
/**
 * @author idle
 */
