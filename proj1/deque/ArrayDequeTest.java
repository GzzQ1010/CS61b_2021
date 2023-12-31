package deque;

import org.junit.Test;


import java.util.Iterator;

import static org.junit.Assert.*;
import edu.princeton.cs.algs4.StdRandom;


public class ArrayDequeTest {
    @Test
    public void addFirstTest(){
        ArrayDeque<Integer> List1 = new ArrayDeque<Integer>();
        List1.addFirst(1);
        List1.addFirst(2);
        List1.addFirst(3);
        assertEquals(3,List1.size());
        assertEquals(3,(int)List1.get(1));
        assertEquals(2,(int)List1.get(2));
        assertEquals(1,(int)List1.get(3));
    }

    @Test
    public void addLastTest(){
        ArrayDeque<Integer> List1 = new ArrayDeque<Integer>();
        List1.addFirst(1);
        List1.addFirst(2);
        List1.addFirst(3);
        List1.addLast(4);
        List1.addLast(5);
        List1.addLast(6);
        assertEquals(6,List1.size());
        assertEquals(6,(int)List1.get(6));
        assertEquals(5,(int)List1.get(5));
        assertEquals(4,(int)List1.get(4));
    }
    @Test
    public void removeFirstTest(){
        ArrayDeque<Integer> List1 = new ArrayDeque<Integer>();
        List1.addFirst(1);
        List1.addFirst(2);
        List1.addFirst(3);
        List1.addLast(4);
        List1.removeFirst();
        assertEquals(2,(int)List1.get(1));
        assertEquals(3,List1.size());
        List1.removeFirst();
        assertEquals(1,(int)List1.get(1));
        assertEquals(2,List1.size());
    }

    @Test
    public void removeLastTest(){
        ArrayDeque<Integer> List1 = new ArrayDeque<Integer>();
        List1.addFirst(1);
        List1.addFirst(2);
        List1.addFirst(3);
        List1.addLast(4);
        List1.addLast(5);
        List1.removeLast();
        assertEquals(4,List1.size());
        assertEquals(4,(int)List1.get(List1.size()));
        List1.removeLast();
        assertEquals(3,List1.size());
        assertEquals(1,(int)List1.get(List1.size()));
        List1.removeLast();
        List1.removeLast();
        List1.removeLast();
        assertEquals(0,List1.size());
        assertEquals(null,List1.removeLast());

    }

    @Test
    public void reSizeTest(){
        ArrayDeque<Integer> List1 = new ArrayDeque<Integer>();
        for(int i=0;i<1000;i++){
            List1.addFirst(i);
        }
        assertEquals(2048,List1.lengthHelper());
        for (int j=0;j<900;j++){
            List1.removeLast();
        }
        assertEquals(128,List1.lengthHelper());
    }

@Test
    public void equalsTest(){
        ArrayDeque<Integer> List1= new ArrayDeque<Integer>();
        ArrayDeque<Integer> List2= new ArrayDeque<Integer>();
        for(int i=0;i<10;i++){
            List1.addFirst(i);
            List2.addFirst(i);
        }
        assertTrue(List1.equals(List2));
    }

    @Test
    public void iterator(){
        ArrayDeque<Integer> List1 = new ArrayDeque<Integer>();
        List1.addFirst(1);
        List1.addFirst(2);
        List1.addFirst(3);
        List1.addLast(4);
        List1.addLast(5);
        List1.addLast(6);
        Iterator<Integer> iter1=List1.iterator();
        assertTrue(iter1.hasNext());
        assertEquals(3,(int)iter1.next());
    }
@Test
    public void add1000andRemove1000Test(){
        ArrayDeque<Integer>List1= new ArrayDeque<Integer>();
        LinkedListDeque<Integer> List2 = new LinkedListDeque<Integer>();
        for (int i=0; i<1000;i++){
            Integer randNum= StdRandom.uniform(0,100);
            Integer Expect,Actual;
            if(i<500){
                List1.addFirst(randNum);
                List2.addFirst(randNum);
            }else{
                List1.addLast(randNum);
                List2.addLast(randNum);
            }
            Expect=List2.get(i);
            Actual=List1.get(i);
            List1.get(i);
            assertEquals(Expect,Actual);
        }
        for (int i=0; i<1000;i++){
            Integer Expect,Actual;
            if(i<500){
                 Expect=List2.removeFirst();
                Actual=List1.removeFirst();
            }else{
                 Expect=List2.removeLast();
                Actual=List1.removeLast();
            }
            assertEquals(Expect,Actual);
        }
    }

@Test
    public void fillupAfterEmpty() {
        ArrayDeque<Integer> List1 = new ArrayDeque<Integer>();
        LinkedListDeque<Integer> List2 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000; i++) {
            Integer randNum = StdRandom.uniform(0, 100);
            Integer Expect, Actual;
            if (i < 500) {
                List1.addFirst(randNum);
                List2.addFirst(randNum);
            } else {
                List1.addLast(randNum);
                List2.addLast(randNum);
            }
            Expect = List2.get(i);
            Actual = List1.get(i);
            List1.get(i);
            assertEquals(Expect, Actual);
        }
        for (int i = 0; i < 1000; i++) {
            Integer Expect, Actual;
            if (i < 500) {
                Expect = List2.removeFirst();
                Actual = List1.removeFirst();
            } else {
                Expect = List2.removeLast();
                Actual = List1.removeLast();
            }
            assertEquals(Expect, Actual);
        }
        for(int i = 0; i < 1000; i++){
            Integer Expect, Actual;
            if (i < 500) {
                Expect = List2.removeFirst();
                Actual = List1.removeFirst();
            } else {
                Expect = List2.removeLast();
                Actual = List1.removeLast();
            }
            assertEquals(Expect, Actual);
        }
    }
}

