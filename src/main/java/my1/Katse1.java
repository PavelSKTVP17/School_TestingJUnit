/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my1;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author user
 */
public class Katse1 
{
    public static void main(final String[] args) throws Exception 
    {
        /*
        final ScriptEngineManager manager = new ScriptEngineManager();
        final ScriptEngine engine = manager.getEngineByName("nashorn");

        // JavaScript code in a String
        final String script = "var obj = new Object(); obj.run = function() { print('run method called'); }";

        // evaluate script
        engine.eval(script);

        // get script object on which we want to implement the interface with
        final Object obj = engine.get("obj");

        final Invocable inv = (Invocable) engine;

        // get Runnable interface object from engine. This interface methods
        // are implemented by script methods of object 'obj'
        final Runnable r = inv.getInterface(obj, Runnable.class);

        // start a new thread that runs the script implemented
        // runnable interface
        final Thread th = new Thread(r);
        th.start();
        th.join();
        */
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        Bindings obj = (Bindings)engine.eval("var obj = { value: 1 };  obj; ");
        Integer value = (Integer)obj.get("value");
        System.out.println(obj);
    }
}
