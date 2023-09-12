package jackbergus.utils;

@:keep
enum ErrorMonad<A,E> {
    Error(x:String,error:E): ErrorMonad<A,E> ; // string for error message;
    Good(value:A): ErrorMonad<A,E> ;   // good value associated to the processing
}