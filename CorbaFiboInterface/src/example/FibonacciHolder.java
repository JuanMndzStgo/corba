package example;

/**
* example/FibonacciHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/reposComputoDistribuido/corba/corba/CorbaFiboInterface/src/fibonacci.idl
* lunes 19 de julio de 2021 05:24:27 PM CDT
*/

public final class FibonacciHolder implements org.omg.CORBA.portable.Streamable
{
  public example.Fibonacci value = null;

  public FibonacciHolder ()
  {
  }

  public FibonacciHolder (example.Fibonacci initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = example.FibonacciHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    example.FibonacciHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return example.FibonacciHelper.type ();
  }

}
